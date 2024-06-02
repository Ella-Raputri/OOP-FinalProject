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
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Asus
 */
public class CalendarPage extends javax.swing.JFrame {
    private String userID = "u1";
    private JPanel contentPane;
    private JPanel cloneablePanel;
    private JScrollPane scrollPane;
    private LinkedList<Task> taskList = new LinkedList<>();
    private String taskIDTemp;
    public static int open = 0;
    /**
     * Creates new form CalendarPage
     */
    public CalendarPage() {
        setResizable(false);
        setTitle("Calendar Page");        
        myinit();
        initComponents();
        initHover();
        
    }
    
    public CalendarPage(String id) {
        setResizable(false);
        setTitle("Calendar Page");
        this.userID = id;
        myinit();
        initComponents();
        initHover();
        
    }
    
    public void hoverButton(String image_path, int colorR, int colorG, int colorB, JLabel[] labels){
        for (JLabel label : labels){
            if (label.getIcon() != null){
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource(image_path)));
            }else{
                label.setForeground(new java.awt.Color(colorR, colorG, colorB));
            }
        }
    }
    
    private void initHover(){
        JLabel[] home_labels = {homeBtn, homeBtnTxt};
        JLabel[] add_workflow_labels = {addWorkflowBtn, addWorkflowBtnTxt, addWorkflowBtnTxt1};
        JLabel[] calendar_labels = {calendarBtn, calendarBtnTxt};
        JLabel[] aranara_labels = {aranaraBtn, aranaraBtnTxt};
        JLabel[] logout_labels = {logoutBtn, logoutBtnTxt};
        
        homeBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new HomePage(userID).setVisible(true);
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
                new HomePage(userID).setVisible(true);
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
        
        addWorkflowBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new AddWorkflowMenu(userID).setVisible(true);
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
                new AddWorkflowMenu(userID).setVisible(true);
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
                new AddWorkflowMenu(userID).setVisible(true);
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
    
        calendarBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hoverButton("/App/img/calendar_active.png", 0, 141, 189, calendar_labels);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverButton("/App/img/calendar.png", 255, 255, 255, calendar_labels);
            }
        });
        calendarBtnTxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hoverButton("/App/img/calendar_active.png", 0, 141, 189, calendar_labels);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverButton("/App/img/calendar.png", 255, 255, 255, calendar_labels);
            }
        });
        
        aranaraBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new AranaraMenu(userID).setVisible(true);
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
                new AranaraMenu(userID).setVisible(true);
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
        
        logoutBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new WelcomePage().setVisible(true);
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
                new WelcomePage().setVisible(true);
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
    }
    
    private void queryTask(){
       taskList.clear();
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM tasks WHERE userID = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.userID);
            
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
                
                Task new_task = new Task(tID, tname, ttype, ttimeFrom, ttimeTo, tnotes, tcolor, this.userID, tcomp);
                taskList.add(new_task);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        } 
    }
    
    private void myinit(){
        queryTask();
        
        // Create the content pane
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon bgImage = new ImageIcon("src/App/img/search.png");
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
        
        calendarCustom2 = new App.CalendarCustom();
        contentPane.add(calendarCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));
        
        initAddTaskBtn();
        contentPane.add(addTaskBtn);

        createClonedPanels(taskList, taskList.size());

        contentPane.setPreferredSize(new Dimension(1280, 750));
        
        // Make the components viewable
        cloneablePanel.setVisible(true);
        calendarCustom2.setVisible(true);
        
        contentPane.revalidate();
        contentPane.repaint();
    }
    
    private void createClonedPanels(LinkedList<Task> list, int size){
        JPanel taskPanel = calendarCustom2.getTaskPanel(); // Access the taskPanel from calendarCustom2
        taskPanel.removeAll();
    
        //panelMap.clear();
        for(int i=0; i<size;i++){
            String id = list.get(i).getId();
            String name = list.get(i).getNameInput();
            String type = list.get(i).getTypeInput();
            String timeFrom = list.get(i).getTimeFromInput();
            String timeTo = list.get(i).getTimeToInput();
            String note = list.get(i).getNoteInput();
            String color = list.get(i).getColorInput();
            
            // Create a new cloned panel
            // Cloneable Panel
            CloneablePanelTask clonedPanel = new CloneablePanelTask(0, new Color(31, 139, 217), 1 ,
                    id, name, type, timeFrom, timeTo, note, color);
            // Set your custom width and height for the cloned panel
            int panelWidth = 260;
            int panelHeight = 90;
            
            // Calculate the x and y positions based on row and column indices
            int x = -10;
            int y = 10 + i * (panelHeight + 30);

            // Set the bounds for the cloned panel with your custom size
            clonedPanel.setBounds(x, y, panelWidth, panelHeight);
            
//            clonedPanel.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    if (currentPanel == clonedPanel){
//                       currentPanel.setClicked(false);
//                       currentPanel = null;
//                       clearAllFields();
//                       deactivateDeleteBtn();
//                    }
//                    else{
//                        if (currentPanel != null ) {
//                            currentPanel.setClicked(false);
//                        }
//                        clonedPanel.setClicked(true);
//                        currentPanel = clonedPanel;
//                        handleEditPanel();
//                    }   
//                }
//            });
            
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
    
    private void addTaskBtnActionPerformed(){
        if (CalendarPage.open == 0){
           CalendarPage.open = 1; 
           new AddNewTask(userID).setVisible(true);
        }else{
           JOptionPane.showMessageDialog(getContentPane(), "One window is already open.");
        }               
    }
    
    private void initAddTaskBtn(){
        addTaskBtn = new App.ButtonCustom();
        addTaskBtn.setForeground(Color.white);
        addTaskBtn.setText("Add task");
        addTaskBtn.setBorderColor(Color.white);
        addTaskBtn.setBorderColorNotOver(Color.white);
        addTaskBtn.setBorderColorOver(Color.white);
        addTaskBtn.setColor(new java.awt.Color(31, 139, 217));
        addTaskBtn.setColor2(java.awt.Color.white);
        addTaskBtn.setColorClick(new java.awt.Color(125, 201, 255));
        addTaskBtn.setColorClick2(java.awt.Color.white);
        addTaskBtn.setColorOver(new java.awt.Color(125, 201, 255));
        addTaskBtn.setColorOver2(java.awt.Color.white);
        addTaskBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); 
        addTaskBtn.setRadius(0);
        addTaskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskBtnActionPerformed();
            }
        });
        addTaskBtn.setBounds(1070, 580, 133, 40); 
    }
    
//    private void handleEditPanel(){
//        //set name field
//        nameField.requestFocus();
//        nameField.setText(currentPanel.getNameInput());
//        
//        //set radio button
//        if (currentPanel.getTypeInput().equals("One-day event")){
//            oneDay.setSelected(true);   
//            toField.setEnabled(false);
//            toComboBox.setEnabled(false);
//            repaint();
//        }else{
//            multipleDay.setSelected(true);
//            toField.setEnabled(true);
//            toComboBox.setEnabled(true);
//            repaint();
//            //set dayTo
//            handleDayField(currentPanel.getDayToInput(), toComboBox, toField);
//        }
//        
//        //set day from
//        handleDayField(currentPanel.getDayFromInput(), fromComboBox, fromField);
//        notesArea.setText(currentPanel.getNoteInput());
//        colorComboBox.setSelectedItem(currentPanel.getColorInput());
//        
//        //activate delete button
//        activateDeleteBtn();
//    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        titletxt = new javax.swing.JLabel();
        calendarCustom2 = new App.CalendarCustom();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        titletxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 48)); // NOI18N
        titletxt.setForeground(new java.awt.Color(0, 141, 189));
        titletxt.setText("Calendar");
        getContentPane().add(titletxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 23, -1, -1));
        getContentPane().add(calendarCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/default_page.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalendarPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalendarPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalendarPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalendarPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalendarPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addWorkflowBtn;
    private javax.swing.JLabel addWorkflowBtnTxt;
    private javax.swing.JLabel addWorkflowBtnTxt1;
    private javax.swing.JLabel aranaraBtn;
    private javax.swing.JLabel aranaraBtnTxt;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel calendarBtn;
    private javax.swing.JLabel calendarBtnTxt;
    private App.CalendarCustom calendarCustom2;
    private javax.swing.JLabel homeBtn;
    private javax.swing.JLabel homeBtnTxt;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JLabel logoutBtnTxt;
    private javax.swing.JLabel titletxt;
    // End of variables declaration//GEN-END:variables
    private App.ButtonCustom addTaskBtn;
}
