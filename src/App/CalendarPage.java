/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
/**
 *
 * @author Asus
 */
public class CalendarPage extends javax.swing.JFrame {

    /**
     * Creates new form CalendarPage
     */
    public String userID;
    private JPanel contentPane;
    public JPanel cloneablePanel;
    private JScrollPane scrollPane;
    public LinkedList<Task> taskList = new LinkedList<>();
    public LinkedList<Task> currTasksList = new LinkedList<>();
    public static int open = 0;
    private CalendarPage home = (CalendarPage) SwingUtilities.getRoot(this);
    private MusicPlayer player;
   // private HashMap <String, String> monthMap = new HashMap<>();
    /**
     * Creates new form CalendarPage
     */
    
    public CalendarPage(String id, MusicPlayer mp) {
        this.player = mp;
        setResizable(false);
        setTitle("Calendar Page");
        this.userID = id;
        myinit();
        initComponents();
        initDesign();
        initHover();
    }
    
    //handle hover button in the navbar
    public void hoverButton(String image_path, int colorR, int colorG, int colorB, JLabel[] labels){
        for (JLabel label : labels){
            if (label.getIcon() != null){
                //if it is image label, then set the hovered image
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource(image_path)));
            }else{
                //if it is text label, set the hover color
                label.setForeground(new java.awt.Color(colorR, colorG, colorB));
            }
        }
    }
    
    public void goToEditTask(String taskid){
        //show the edit task window if there is no opened window
        if (CalendarPage.open == 0){
           CalendarPage.open = 1; 
           new EditTask(userID, home, taskid).setVisible(true);
        }else{
           JOptionPane.showMessageDialog(getContentPane(), "One window is already open.");
        } 
    }
    
    private void initHover(){
        //side navbar buttons
        JLabel[] home_labels = {homeBtn, homeBtnTxt};
        JLabel[] add_workflow_labels = {addWorkflowBtn, addWorkflowBtnTxt, addWorkflowBtnTxt1};
        JLabel[] aranara_labels = {aranaraBtn, aranaraBtnTxt};
        JLabel[] logout_labels = {logoutBtn, logoutBtnTxt};
        
        //home button
        homeBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new HomePage(userID, player).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                hoverButton("/App/img/home_active.png", 0, 141, 189, home_labels);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverButton("/App/img/home.png", 255, 255, 255, home_labels);
            }
        });
        homeBtnTxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new HomePage(userID, player).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                hoverButton("/App/img/home_active.png", 0, 141, 189, home_labels);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverButton("/App/img/home.png", 255, 255, 255, home_labels);
            }
        }); 
        
        //add workflow button
        addWorkflowBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new AddWorkflowMenu(userID, player).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                hoverButton("/App/img/add_workflow_active.png", 0, 141, 189, add_workflow_labels);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverButton("/App/img/add_workflow.png", 255, 255, 255, add_workflow_labels);
            }
        });
        addWorkflowBtnTxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new AddWorkflowMenu(userID, player).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                hoverButton("/App/img/add_workflow_active.png", 0, 141, 189, add_workflow_labels);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverButton("/App/img/add_workflow.png", 255, 255, 255, add_workflow_labels);
            }
        });      
        addWorkflowBtnTxt1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new AddWorkflowMenu(userID, player).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                hoverButton("/App/img/add_workflow_active.png", 0, 141, 189, add_workflow_labels);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverButton("/App/img/add_workflow.png", 255, 255, 255, add_workflow_labels);
            }
        });
    
        //aranara button
        aranaraBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new AranaraMenu(userID, player).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                hoverButton("/App/img/aranara_active.png", 0, 141, 189, aranara_labels);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverButton("/App/img/aranara.png", 255, 255, 255, aranara_labels);
            }
        });
        aranaraBtnTxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new AranaraMenu(userID, player).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                hoverButton("/App/img/aranara_active.png", 0, 141, 189, aranara_labels);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverButton("/App/img/aranara.png", 255, 255, 255, aranara_labels);
            }
        });
        
        //logout button
        logoutBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                player.loadMusic("src/App/sound/EnchantingBedtimeStories.wav");
                player.play();
                new WelcomePage(player).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                hoverButton("/App/img/logout_active.png", 0, 141, 189, logout_labels);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverButton("/App/img/logout.png", 255, 255, 255, logout_labels);
            }
        });
        logoutBtnTxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                player.loadMusic("src/App/sound/EnchantingBedtimeStories.wav");
                player.play();
                new WelcomePage(player).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                hoverButton("/App/img/logout_active.png", 0, 141, 189, logout_labels);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverButton("/App/img/logout.png", 255, 255, 255, logout_labels);
            }
        });
        
        //insert workflow as task button
        insertBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                insertBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/insert_workflow_hover.png")));
                insertBtn.setBackground(new java.awt.Color(234, 234, 234));
                insertBtn.setBorderColor(new java.awt.Color(125, 201, 255));
            }
            @Override
            public void mouseExited(MouseEvent me) {
                insertBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/insert_workflow.png")));
                insertBtn.setBackground(new Color(246,252,254));
                insertBtn.setBorderColor(new java.awt.Color(0, 141, 189));
            }
            @Override
            public void mouseClicked(MouseEvent me) {
                insertBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/insert_workflow.png")));
                insertBtn.setBackground(Color.white);
                insertBtn.setBorderColor(new java.awt.Color(0, 141, 189));
                insertWorkflowBtn(); //open the insert workflow task frame
            }
        });
        
        //contact others button
        contactBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                contactBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/contact_btn_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent me) {
                contactBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/contact_btn.png")));
            }
            @Override
            public void mouseClicked(MouseEvent me) {
                if (CalendarPage.open == 0){
                    //open the contact others frame when there is no other opened window
                    CalendarPage.open = 1; 
                    new ContactOthers(userID).setVisible(true);
                }else{
                   JOptionPane.showMessageDialog(getContentPane(), "One window is already open.");
                } 
            }
        });
    }
    
    private void insertWorkflowBtn(){
        //open the insert workflow as task frame 
        //if there is no other opened window
        if (CalendarPage.open == 0){
           CalendarPage.open = 1; 
           new InsertWorkflowTask(userID, home).setVisible(true);
        }else{
           JOptionPane.showMessageDialog(getContentPane(), "One window is already open.");
        } 
    }
    
    public void queryTask(){
       taskList.clear(); //clear all remaining tasks
        try{
            //query from the database to get the tasks
            Connection con = ConnectionProvider.getCon();
            //the order is from the not completed one first
            String query = "SELECT * FROM tasks WHERE userID = ? ORDER BY completed ASC";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.userID);
            
            //get the task attributes
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String tID = rs.getString("taskID");
                String tname = rs.getString("name");
                String ttype = rs.getString("type");
                String ttimeFrom = rs.getString("timeFrom");
                String ttimeTo = rs.getString("timeTo");
                String tnotes = rs.getString("notes");
                String tcolor = rs.getString("color");
                boolean tcomp = rs.getBoolean("completed");
                
                //add it to the task list
                Task new_task = new Task(tID, tname, ttype, ttimeFrom, ttimeTo, tnotes, tcolor, this.userID, tcomp);
                taskList.add(new_task);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        } 
    }
    
    public void refresh(){
        //refresh the calendar page
        queryCurrentTaskList(); //get the selected date task
        cloneablePanel.removeAll(); //remove all the cloned panel
        //create cloned panels based on current task 
        createClonedPanels(home.currTasksList, home.currTasksList.size());       
        renewTaskText(); //renew the task text and the add task button
    }
    
    
    public void renewTaskText(){
        //renew the task panel
        JPanel taskPanel = calendarCustom2.getTaskPanel();
        JLabel tasktxt = new JLabel();
        tasktxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 32)); // NOI18N
        tasktxt.setForeground(new java.awt.Color(255, 255, 255));
        tasktxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tasktxt.setText("Tasks");
        tasktxt.setToolTipText("");
        taskPanel.add(tasktxt);
        tasktxt.setBounds(90, 20, 100, 39);
        
        //renew the line inside the task panel
        JLabel jLabel1 = new JLabel();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/line.png"))); // NOI18N
        taskPanel.add(jLabel1);
        jLabel1.setBounds(30, 50, 232, 43);
        
        //renew the add task button on the bottom of task panel
        ButtonCustom addBtn = new App.ButtonCustom();
        addBtn.setForeground(java.awt.Color.white);
        addBtn.setText("Add task");
        addBtn.setBorderColor(java.awt.Color.white);
        addBtn.setBorderColorNotOver(java.awt.Color.white);
        addBtn.setBorderColorOver(java.awt.Color.white);
        addBtn.setColor(new java.awt.Color(31, 139, 217));
        addBtn.setColor2(java.awt.Color.white);
        addBtn.setColorClick(new java.awt.Color(125, 201, 255));
        addBtn.setColorClick2(java.awt.Color.white);
        addBtn.setColorOver(new java.awt.Color(125, 201, 255));
        addBtn.setColorOver2(java.awt.Color.white);
        addBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        taskPanel.add(addBtn);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarCustom2.addTaskBtnActionPerformed();
            }
        });
        addBtn.setBounds(120, 470, 133, 40);
        //revalidate and repaint
        taskPanel.revalidate();
        taskPanel.repaint();
    }
    
    public LocalDate convertStrDate(String timeStr){
        String modify = timeStr;
        //if the date is still 2024-02-8, then make it to become 2024-02-08
        if (timeStr.length() != 10){
            modify = timeStr.substring(0, 8) + "0" + timeStr.charAt(8);
        }
        //convert the date to localdate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(modify, formatter);
        return date;
    }    
    
    public void queryCurrentTaskList(){
        currTasksList.clear(); //clear all remaining task
        queryTask(); //refresh the task list
        CalendarCell currCell = calendarCustom2.currentPanel.getCurrentCell(); //get the selected cell
        
        //get the selected cell's date
        LocalDate date_cell = currCell.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        for (int i = 0; i < taskList.size(); i++){
            //get the date from of the task
            LocalDate date_from = convertStrDate(taskList.get(i).getTimeFromInput());
            //one-day event
            if (taskList.get(i).getTypeInput().equals("One-day event")){       
                //if the current cell's date is the same with the date from of the task
                if (date_from.equals(date_cell)){
                    currTasksList.add(taskList.get(i)); //add the task to the current task list
                }
            //multiple day event
            }else{
                //get the date to of the task
                LocalDate date_to = convertStrDate(taskList.get(i).getTimeToInput());
                LocalDate curr_iter = date_from;
        
                while (!curr_iter.isAfter(date_to)) {
                    //iterate to check if the cell date is in range of the dateFrom to dateTo of the task
                    if (curr_iter.equals(date_cell)){
                        //if yes, append the task to the current task list
                        currTasksList.add(taskList.get(i));
                        break;
                    }
                    // Increment date by one day
                    curr_iter = curr_iter.plusDays(1);
                }
            }
        }        
    }

    
    private void myinit(){
        queryTask(); //query task list
        
        // Create the content pane
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon bgImage = new ImageIcon("src/App/img/default_page.png");
                // Draw the background image
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPane.setLayout(null); // Use absolute layout
        setContentPane(contentPane);
        
        // Create the scroll pane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(971, 195, 260, 370); // Set bounds for the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane);

        // Create the cloneable panel
        cloneablePanel = new JPanel(); // The initial panel inside scroll pane
        cloneablePanel.setLayout(null); // Use absolute layout
        cloneablePanel.setPreferredSize(new Dimension(400, 200)); // Set initial size
        cloneablePanel.setBounds(180, 200, 1200, 1500); // Set bounds for the initial panel
        cloneablePanel.setBackground(new Color(31, 139, 217));
        scrollPane.setViewportView(cloneablePanel); // Set this panel as viewport's view
        
        calendarCustom2 = new App.CalendarCustom(this.home); //init the calendar panel
        contentPane.add(calendarCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        queryCurrentTaskList(); //query the current task list
        //create the cloned panels in the task panel based on the current date task
        createClonedPanels(currTasksList, currTasksList.size());

        contentPane.setPreferredSize(new Dimension(1280, 750));
        
        // Make the components viewable
        cloneablePanel.setVisible(true);
        calendarCustom2.setVisible(true);
        //revalidate and repaint
        contentPane.revalidate();
        contentPane.repaint();
    }
    
    public void createClonedPanels(LinkedList<Task> list, int size){
        JPanel taskPanel = calendarCustom2.getTaskPanel(); // Access the taskPanel from calendarCustom2
        taskPanel.removeAll(); //remove all the elements inside it
    
        for(int i=0; i<size;i++){
            //iterates over task list
            String id = list.get(i).getId();
            String name = list.get(i).getNameInput();
            String type = list.get(i).getTypeInput();
            String timeFrom = list.get(i).getTimeFromInput();
            String timeTo = list.get(i).getTimeToInput();
            String note = list.get(i).getNoteInput();
            String color = list.get(i).getColorInput();
            boolean comp = list.get(i).getCompleted();
            
            // Create a new cloned panel
            CloneablePanelTask clonedPanel = new CloneablePanelTask(this.home, 0, new Color(31, 139, 217), 1 ,
                    id, name, type, timeFrom, timeTo, note, color, comp);
            // Set width and height for the cloned panel
            int panelWidth = 260;
            int panelHeight = 90;
            
            // Calculate the x and y positions 
            int x = -10;
            int y = 10 + i * (panelHeight + 30);

            // Set the bounds for the cloned panel 
            clonedPanel.setBounds(x, y, panelWidth, panelHeight);
            
            // Add the cloned panel to the initial panel
            taskPanel.add(clonedPanel);
            cloneablePanel.add(clonedPanel);
            
            // Adjust preferred size of initial panel to include new panel
            Dimension newSize = new Dimension(cloneablePanel.getWidth(), y + panelHeight + 10); // Adjusted size
            cloneablePanel.setPreferredSize(newSize);
            // Ensure the scroll pane updates its viewport
            scrollPane.revalidate();
            scrollPane.repaint();
            // Scroll to show the new panel
            scrollPane.getVerticalScrollBar().setValue(0);
        }
        
        
        int totalHeight = size * (90 + 30) + 10; // panelHeight + vertical gap + initial gap
        taskPanel.setPreferredSize(new Dimension(400, totalHeight)); // Adjusted size
        // Ensure the taskPanel updates its viewport
        taskPanel.revalidate();
        taskPanel.repaint();
    }
    
    
    private void initDesign(){
        //init the components
        homeBtnTxt = new javax.swing.JLabel();
        homeBtn = new javax.swing.JLabel();
        addWorkflowBtn = new javax.swing.JLabel();
        addWorkflowBtnTxt1 = new javax.swing.JLabel();
        addWorkflowBtnTxt = new javax.swing.JLabel();
        calendarBtn = new javax.swing.JLabel();
        calendarBtnTxt = new javax.swing.JLabel();
        aranaraBtn = new javax.swing.JLabel();
        aranaraBtnTxt = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JLabel();
        logoutBtnTxt = new javax.swing.JLabel();
        insertBtn = new App.ButtonCustom();
        titletxt = new javax.swing.JLabel();
        calendarCustom2 = new App.CalendarCustom(this.home);
        contactBtn = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        //set default close operation, size, and layout
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //styling components
        homeBtnTxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        homeBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        homeBtnTxt.setText("Home");
        getContentPane().add(homeBtnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/home.png"))); // NOI18N
        getContentPane().add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 55, -1, -1));

        addWorkflowBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/add_workflow.png"))); // NOI18N
        getContentPane().add(addWorkflowBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 155, -1, -1));

        addWorkflowBtnTxt1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        addWorkflowBtnTxt1.setForeground(new java.awt.Color(255, 255, 255));
        addWorkflowBtnTxt1.setText("Add");
        getContentPane().add(addWorkflowBtnTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 206, -1, -1));

        addWorkflowBtnTxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        addWorkflowBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        addWorkflowBtnTxt.setText("workflow");
        getContentPane().add(addWorkflowBtnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 224, -1, -1));

        calendarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/calendar_active.png"))); // NOI18N
        getContentPane().add(calendarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 284, -1, -1));

        calendarBtnTxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        calendarBtnTxt.setForeground(new java.awt.Color(0, 141, 189));
        calendarBtnTxt.setText("Calendar");
        getContentPane().add(calendarBtnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 335, -1, -1));

        aranaraBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/aranara.png"))); // NOI18N
        getContentPane().add(aranaraBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 390, -1, -1));

        aranaraBtnTxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        aranaraBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        aranaraBtnTxt.setText("Aranara");
        getContentPane().add(aranaraBtnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 455, -1, -1));

        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/logout.png"))); // NOI18N
        getContentPane().add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 635, -1, -1));

        logoutBtnTxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        logoutBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtnTxt.setText("Log out");
        getContentPane().add(logoutBtnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 676, -1, -1));

        insertBtn.setBackground(new java.awt.Color(246, 252, 254));
        insertBtn.setForeground(new java.awt.Color(0, 141, 189));
        insertBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/insert_workflow.png"))); // NOI18N
        insertBtn.setBorderColor(new java.awt.Color(0, 141, 189));
        insertBtn.setBorderColorNotOver(new java.awt.Color(0, 141, 189));
        insertBtn.setBorderColorOver(new java.awt.Color(125, 201, 255));
        insertBtn.setColor(new java.awt.Color(246, 252, 254));
        insertBtn.setColorClick(new java.awt.Color(234, 234, 234));
        insertBtn.setColorOver(new java.awt.Color(234, 234, 234));
        getContentPane().add(insertBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, 280, 38));

        titletxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 48)); // NOI18N
        titletxt.setForeground(new java.awt.Color(0, 141, 189));
        titletxt.setText("Calendar");
        getContentPane().add(titletxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 23, -1, -1));
        getContentPane().add(calendarCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));
        
        contactBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/contact_btn.png"))); // NOI18N
        getContentPane().add(contactBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 63, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/default_page.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */    
    private javax.swing.JLabel addWorkflowBtn;
    private javax.swing.JLabel addWorkflowBtnTxt;
    private javax.swing.JLabel addWorkflowBtnTxt1;
    private javax.swing.JLabel aranaraBtn;
    private javax.swing.JLabel aranaraBtnTxt;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel calendarBtn;
    private javax.swing.JLabel calendarBtnTxt;
    public App.CalendarCustom calendarCustom2;
    private javax.swing.JLabel homeBtn;
    private javax.swing.JLabel homeBtnTxt;
    private App.ButtonCustom insertBtn;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JLabel logoutBtnTxt;
    private javax.swing.JLabel titletxt;           
    private javax.swing.JLabel contactBtn;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
