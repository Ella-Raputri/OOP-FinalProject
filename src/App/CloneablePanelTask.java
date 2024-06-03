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
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.border.LineBorder;
/**
 *
 * @author asus
 */
public class CloneablePanelTask extends JPanel{ 
    private static int panelCount = 0; 
    private static int borderRadius;
    private static Color bgColor;
    private static int borderWidth;
    private String id;
    private String nameInput;
    private String typeInput;
    private String timeFromInput;
    private String timeToInput;
    private String noteInput;
    private String colorInput;
    private boolean isClicked = false;
    private CalendarPage home;
    

    public CloneablePanelTask(CalendarPage home, int borderRadius, Color bgColor, int borderWidth, String id, 
            String nameInput, String typeInput, String timeFromInput, String timeToInput, String noteInput, String colorInput) {
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
                             
        
        // Example content - you can add whatever components you need
        WrappedLabel title = new WrappedLabel(270);
        title.setText(nameInput);        
        title.setForeground(Color.white);
        title.setFont(new Font("Montserrat", 0, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(18, 10, title.getPreferredSize().width, title.getPreferredSize().height);
        add(title);       
        
        //the color label
        JLabel color_label = new JLabel();
        color_label.setBackground(color_map.get(colorInput));
        color_label.setOpaque(true);
        setComponentBounds(color_label, 231, 55, 14, 14);
        add(color_label);
        
        //the view more label
        //INSERT INTO `tasks`(`taskID`, `name`, `type`, `timeFrom`, `timeTo`, `notes`, `color`, `userID`) VALUES ('t3','haii','One-day event','18 June 2024','18 June 2024','ddd','Brown','u1')
        JLabel more_label = new JLabel();
        more_label.setForeground(Color.white);
        more_label.setFont(new Font("Montserrat", 0, 36));
        more_label.setText("...");
        setComponentBounds(more_label, 226, -20, 23, 54);
        more_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.goToEditTask(id);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                more_label.setForeground(new Color(125, 201, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                more_label.setForeground(Color.white);
            }
        });
        add(more_label);
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
    
    
    public void setClicked(boolean click){
        this.isClicked = click;
        repaint();
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
        if (isClicked) {
            g2d.setColor(new Color(125,201,255));
            g2d.setStroke(new BasicStroke(2)); // Set border width
        } else {
            g2d.setColor(Color.white);
            g2d.setStroke(new BasicStroke(borderWidth)); // Set border width
        }
        
        g2d.drawRoundRect(borderWidth / 2, getHeight() - borderWidth, getWidth() - borderWidth, borderWidth, borderRadius, borderRadius);
        g2d.dispose();
    }
}

