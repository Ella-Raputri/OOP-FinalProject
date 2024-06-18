/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import DatabaseConnection.ConnectionProvider;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author asus
 */
public class CloneablePanelTask extends JPanel{ 
    //display attributes
    private static int borderRadius;
    private static Color bgColor;
    private static int borderWidth;
    //task attributes
    private String id;
    private String nameInput;
    private String typeInput;
    private String timeFromInput;
    private String timeToInput;
    private String noteInput;
    private String colorInput;
    private boolean completedInput;
    //parent frame
    private CalendarPage home;  

    //constructor
    public CloneablePanelTask(CalendarPage home, int borderRadius, Color bgColor, int borderWidth, String id, 
            String nameInput, String typeInput, String timeFromInput, String timeToInput, String noteInput, String colorInput, boolean completedInput) {
        setLayout(null);
        this.borderRadius = borderRadius;
        this.bgColor = bgColor;
        this.borderWidth = borderWidth;
        this.id = id;
        this.nameInput = nameInput;
        this.timeFromInput = timeFromInput;
        this.timeToInput = timeToInput;
        this.typeInput = typeInput;
        this.noteInput = noteInput;
        this.colorInput = colorInput;
        this.home = home;
        setOpaque(false);
        
        //hash map that save the color of all possible flow colors
        HashMap<String, Color> color_map = new HashMap<>();
       
        //insert the color name and the corresponding color
        color_map.put("Blue", new Color(80, 213, 255));
        color_map.put("Red", new Color(255, 164, 164));
        color_map.put("Orange", new Color(255, 182, 128));
        color_map.put("Yellow", new Color(248, 232, 87));
        color_map.put("Green", new Color(153, 237, 113));
        color_map.put("Purple", new Color(218, 157, 255));
        color_map.put("Pink", new Color(255, 125, 203));
        color_map.put("Brown", new Color(223, 170, 106));                             
        
        // init the title label
        WrappedLabel title = new WrappedLabel(220);
        title.setText(nameInput);        
        title.setForeground(Color.white);
        title.setFont(new Font("Montserrat", 0, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(18, 10, title.getPreferredSize().width, title.getPreferredSize().height);
        add(title);     
        
        //the view more or edit label in form of ...
        JLabel more_label = new JLabel();
        more_label.setForeground(Color.white);
        more_label.setFont(new Font("Montserrat", 0, 36));
        more_label.setText("...");
        setComponentBounds(more_label, 226, -20, 23, 54);
        more_label.addMouseListener(new MouseAdapter() {
            //the behaviour of this label
            @Override
            public void mouseClicked(MouseEvent e) {
                if (more_label.isEnabled()){ //if it is not disabled
                  //then when we click it, we can edit the corresponding task
                  home.goToEditTask(id);  
                } else{
                    // if disabled, then show the error messagee
                    JOptionPane.showMessageDialog(home.getContentPane(), "The task has already been completed.");
                }
                
            }
            @Override
            public void mouseEntered(MouseEvent e) { //when mouse hover
                more_label.setForeground(new Color(125, 201, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) { //when mouse not hover
                more_label.setForeground(Color.white);
            }
        });
        add(more_label);
        
        //init the color label
        JLabel color_label = new JLabel();
        color_label.setBackground(color_map.get(colorInput));
        color_label.setOpaque(true);
        
        //if the task is completed, then set the color label to be ticked
        if (completedInput == true){
            color_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/checkmark.png")));
            title.setFont(getStrikethrough(new Font("Montserrat", 0, 20))); //set strikethrough to task title
            more_label.setEnabled(false);//disable the view more label
        }
        setComponentBounds(color_label, 231, 55, 14, 14);
        color_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //ithe color label is clicked
                //set ticked or not
               handleCheckmarks(color_label, title, more_label);  
               //update the database based on this data
               updateCompletedDatabase();
            }
        });
        add(color_label);
    }
    
    private void handleCheckmarks(JLabel color_label, JLabel title, JLabel more){     
        //if the color label is ticked (the task is completed) and it is clicked again
        if (completedInput){
            //set the icon become null 
            color_label.setIcon(null);
            title.setFont(new Font("Montserrat", 0, 20));
            more.setEnabled(true); //enable the view more label again
            this.completedInput = false; //set the task to be not completed
            updateTaskCompletionDatabase(-1); //update task completion table database to be minus by 1 for today
        }else{
            //if the task is not completed and it is clicked 
            //set checkmark
            color_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/checkmark.png")));
            title.setFont(getStrikethrough(new Font("Montserrat", 0, 20))); //set the title to be strikethrough
            more.setEnabled(false); //disable the view more label
            this.completedInput = true;      //set compeleted to be true      
            updateTaskCompletionDatabase(1); //update task completion table database to be added by 1 for today
        }
        //revalidate and repaint the color label
        revalidate();
        repaint();
    }
    
    private Font getStrikethrough(Font font){
        //get strikethrough font of the title 
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        Font newFont = new Font(attributes);
        return newFont; //return the new font style
    }
    
    private void updateCompletedDatabase(){
        //update the tasks database based on taskID to set whether the task is completed or not
        try{
            Connection con = ConnectionProvider.getCon();

            String query = "UPDATE tasks SET completed = ? WHERE taskID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setBoolean(1, this.completedInput);
            ps.setString(2, this.id);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private int getTasksCompletion(){
        //get today day name
        String day = LocalDate.now().getDayOfWeek().name();
        //condition the column name based on today day name
        String col_name = day.charAt(0) + day.substring(1,3).toLowerCase();
        int result = -1;
        
        try{
            //query all the task_completion database
            Connection con = ConnectionProvider.getCon();

            String query = "SELECT * FROM task_completion WHERE userID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, home.userID);
            
            try (ResultSet rs = ps.executeQuery()) {
                //if the col name is today day name
                if (rs.next()) {
                    //set today task completion as the value inside the colname
                    result = rs.getInt(col_name);
                } 
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    private void updateTaskCompletionDatabase(int a){
        //get today day name
        String day = LocalDate.now().getDayOfWeek().name();
        //get column name based on today day name
        String col_name = day.charAt(0) + day.substring(1,3).toLowerCase();   
        //get the current completion rate and add it with a 
        //a = 1 if user complete a new task and conversely a = -1
        int curr_completion = getTasksCompletion() + a;
        
        try{
            //update the task_completion database based on the column name and user ID
            Connection con = ConnectionProvider.getCon();

            String query = "UPDATE task_completion SET " + col_name + " = ? WHERE userID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, curr_completion);
            ps.setString(2, home.userID);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public String gettimeFromInput() {
        return timeFromInput;
    }

    public void settimeFromInput(String timeFromInput) {
        this.timeFromInput = timeFromInput;
    }

    public String gettimeToInput() {
        return timeToInput;
    }

    public void settimeToInput(String timeToInput) {
        this.timeToInput = timeToInput;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeInput() {
        return typeInput;
    }

    public void setTypeInput(String typeInput) {
        this.typeInput = typeInput;
    }
    
    public String getNoteInput() {
        return noteInput;
    }

    public void setNoteInput(String noteInput) {
        this.noteInput = noteInput;
    }

    public String getColorInput() {
        return colorInput;
    }

    public void setColorInput(String colorInput) {
        this.colorInput = colorInput;
    }

    public boolean isCompletedInput() {
        return completedInput;
    }

    public void setCompletedInput(boolean completedInput) {
        this.completedInput = completedInput;
    }    
    
    public void setComponentBounds(Component component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height); // Set the position and size of the component
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(bgColor); // Set background color
        // Fill the area inside the border with the background color
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(borderWidth)); // Set border width
                
        g2d.drawRoundRect(borderWidth / 2, getHeight() - borderWidth, getWidth() - borderWidth, borderWidth, borderRadius, borderRadius);
        g2d.dispose();
    }
}

