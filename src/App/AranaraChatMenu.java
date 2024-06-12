/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class AranaraChatMenu extends javax.swing.JFrame {
    private String userID = "u1";
    private EditAranara parent;
    private String username;
    private LinkedList<Task> taskList = new LinkedList<>();
    /**
     * Creates new form AranaraChatMenu
     */
    public AranaraChatMenu(EditAranara parent, String userID) {
        this.userID = userID;
        this.parent = parent;
        setUndecorated(true);
        setResizable(false);
        initComponents();
        initDesign();
    }
    
    public AranaraChatMenu() {        
        setUndecorated(true);
        setResizable(false);
        initComponents();
        initDesign();
    }
    
    private void initDesign(){
        queryAllUserInfo();
        hiBtn = new App.ButtonCustom();
        taskBtn = new App.ButtonCustom();
        wordBtn = new App.ButtonCustom();
        excelBtn = new App.ButtonCustom();
        pptBtn  = new App.ButtonCustom();
        timerBtn = new App.ButtonCustom();
        weatherBtn = new App.ButtonCustom();
        gameBtn = new App.ButtonCustom();
        
        getContentPane().setBackground(Color.white);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(410, 760));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        hiBtn.setForeground(new java.awt.Color(255, 255, 255));
        hiBtn.setText("");
        hiBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hiBtn.png")));
        hiBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        hiBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        hiBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        hiBtn.setColor(Color.white);
        hiBtn.setColorClick(new java.awt.Color(234, 234, 234));
        hiBtn.setColorOver(new java.awt.Color(234, 234, 234));
        hiBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        hiBtn.setRadius(20);
        hiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hiBtnActionPerformed();
            }
        });
        getContentPane().add(hiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 73, 128, 119)); 
        
        taskBtn.setForeground(new java.awt.Color(255, 255, 255));
        taskBtn.setText("");
        taskBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/taskBtn.png")));
        taskBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        taskBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        taskBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        taskBtn.setColor(Color.white);
        taskBtn.setColorClick(new java.awt.Color(234, 234, 234));
        taskBtn.setColorOver(new java.awt.Color(234, 234, 234));
        taskBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        taskBtn.setRadius(20);
        taskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskBtnActionPerformed();
            }
        });
        getContentPane().add(taskBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 73, 128, 119)); 
        
        wordBtn.setForeground(new java.awt.Color(255, 255, 255));
        wordBtn.setText("");
        wordBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/wordBtn.png")));
        wordBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        wordBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        wordBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        wordBtn.setColor(Color.white);
        wordBtn.setColorClick(new java.awt.Color(234, 234, 234));
        wordBtn.setColorOver(new java.awt.Color(234, 234, 234));
        wordBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        wordBtn.setRadius(20);
        wordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              openMsApplication("winword", "Word");
            }
        });
        getContentPane().add(wordBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 225, 128, 119)); 
        
        excelBtn.setForeground(new java.awt.Color(255, 255, 255));
        excelBtn.setText("");
        excelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/excelBtn.png")));
        excelBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        excelBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        excelBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        excelBtn.setColor(Color.white);
        excelBtn.setColorClick(new java.awt.Color(234, 234, 234));
        excelBtn.setColorOver(new java.awt.Color(234, 234, 234));
        excelBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        excelBtn.setRadius(20);
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               openMsApplication("excel", "Excel");
            }
        });
        getContentPane().add(excelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 225, 128, 119)); 
        
        pptBtn.setForeground(new java.awt.Color(255, 255, 255));
        pptBtn.setText("");
        pptBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/pptBtn.png")));
        pptBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        pptBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        pptBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        pptBtn.setColor(Color.white);
        pptBtn.setColorClick(new java.awt.Color(234, 234, 234));
        pptBtn.setColorOver(new java.awt.Color(234, 234, 234));
        pptBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        pptBtn.setRadius(20);
        pptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               openMsApplication("powerpnt", "PowerPoint");
            }
        });
        getContentPane().add(pptBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 377, 128, 119)); 
        
        timerBtn.setForeground(new java.awt.Color(255, 255, 255));
        timerBtn.setText("");
        timerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/timerBtn.png")));
        timerBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        timerBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        timerBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        timerBtn.setColor(Color.white);
        timerBtn.setColorClick(new java.awt.Color(234, 234, 234));
        timerBtn.setColorOver(new java.awt.Color(234, 234, 234));
        timerBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        timerBtn.setRadius(20);
        timerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // timerBtnActionPerformed(evt);
            }
        });
        getContentPane().add(timerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 377, 128, 119)); 
        
        weatherBtn.setForeground(new java.awt.Color(255, 255, 255));
        weatherBtn.setText("");
        weatherBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/weatherBtn.png")));
        weatherBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        weatherBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        weatherBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        weatherBtn.setColor(Color.white);
        weatherBtn.setColorClick(new java.awt.Color(234, 234, 234));
        weatherBtn.setColorOver(new java.awt.Color(234, 234, 234));
        weatherBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        weatherBtn.setRadius(20);
        weatherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // weatherBtnActionPerformed(evt);
            }
        });
        getContentPane().add(weatherBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 526, 128, 119)); 
        
        gameBtn.setForeground(new java.awt.Color(255, 255, 255));
        gameBtn.setText("");
        gameBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/gameBtn.png")));
        gameBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        gameBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        gameBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        gameBtn.setColor(Color.white);
        gameBtn.setColorClick(new java.awt.Color(234, 234, 234));
        gameBtn.setColorOver(new java.awt.Color(234, 234, 234));
        gameBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        gameBtn.setRadius(20);
        gameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // gameBtnActionPerformed(evt);W
            }
        });
        getContentPane().add(gameBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 526, 128, 119)); 
        
        
        pack();
        //setLocationRelativeTo(parent);
        int parentX = parent.getX();
        int parentY = parent.getY();
        setLocation(parentX, parentY);
    }
    
    private void openMsApplication(String app, String name) {
        try {
            // Command to open Microsoft Word on Windows
            String command = "cmd /c start " + app;

            // Execute the command
            Runtime.getRuntime().exec(command);
            
            //set the dialogue box text
            parent.setDialogText("Opening Microsoft " + name + "... Please wait a moment, Nara!");
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error opening " + name + e.getMessage());
        }
    }
    
    private void queryAllUserInfo(){
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM user WHERE userID = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.userID);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
               //get pat amount and day
                username = rs.getString("username");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
            e.printStackTrace();
        } 
    }
    
    private void queryTask(){
       taskList.clear();
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM tasks WHERE userID = ? ORDER BY completed ASC";
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
    
    private void hiBtnActionPerformed(){
        String[] arama_msg = {"Hello Nara! I am Arama.", 
            "Nice to meet you, Nara " + username + ".", "Oh welcome, good Nara!"};
        
        String[] ararycan_msg = {"Hello, Nara. I am Ararycan.", 
            "Ahhh! Nara " + username + ".", "You are good Nara. Ararycan is not afraid."};
        
        String[] arabalika_msg = {"Hmph. I am " + parent.aranaraName + ".", 
            "Arabalika want to see how strong Nara " + username + "is.", "Hmph. Arabalika wants to practice."};
        
        Random random = new Random();
        int index = random.nextInt(3);
        
        String[] proper = null;
        switch (parent.aranaraName) {
            case "Arama" -> proper = arama_msg;
            case "Ararycan" -> proper = ararycan_msg;
            case "Arabalika" -> proper = arabalika_msg;
            default -> {
            }
        }
        parent.setDialogText(proper[index]);
    }
    
    private void taskBtnActionPerformed(){        
        queryTask();
        String[] options = {"today", "tomorrow", "random date"};

        // Show the initial option dialog
        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Choose a date option:",
                "Date Options",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == null) {
            // User pressed cancel or closed the dialog
            JOptionPane.showMessageDialog(parent.getContentPane(), "No options selected.");
            return;
        }

        switch (choice) {
            case "today":
                // Display today's date
                String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                getSpecificTaskDate(today);
                break;

            case "tomorrow":
                // Display tomorrow's date
                Date tomorrowDate = new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24));
                String tomorrow = new SimpleDateFormat("yyyy-MM-dd").format(tomorrowDate);
                getSpecificTaskDate(tomorrow);
                break;

            case "random date":
                // Prompt the user to enter a random date
                String randomDate = JOptionPane.showInputDialog("Please enter a date (yyyy-MM-dd):");

                if (randomDate != null) {
                    // Validate the date format
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        sdf.setLenient(false);
                        Date date = sdf.parse(randomDate);
                        getSpecificTaskDate(randomDate);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid date format. Please use yyyy-MM-dd.");
                    }
                } else {
                    // User pressed cancel or closed the dialog
                    System.out.println("No date entered.");
                }
                break;

            default:
                System.out.println("Unexpected option: " + choice);
        }
    }
    
    private void getSpecificTaskDate(String date){
        LocalDate input_date = convertStrDate(date);
        LinkedList<String> result = new LinkedList<>();
        
        //iterate the taskList
        for (int i = 0; i < taskList.size(); i++){
            LocalDate date_from = convertStrDate(taskList.get(i).getTimeFromInput());
            if (taskList.get(i).getTypeInput().equals("One-day event")){                
                if (date_from.equals(input_date)){
                    result.add(taskList.get(i).getNameInput());
                }
            //multiple day event
            }else{
                LocalDate date_to = convertStrDate(taskList.get(i).getTimeToInput());
                LocalDate curr_iter = date_from;
        
                while (!curr_iter.isAfter(date_to)) {
                    if (curr_iter.equals(input_date)){
                        result.add(taskList.get(i).getNameInput());
                        break;
                    }
                    // Increment date by one day
                    curr_iter = curr_iter.plusDays(1);
                }
            }
        }
        
        //show the result in dialogue text
        if (result.isEmpty()){
            parent.setDialogText("You don't have any tasks for " + date + ", Nara.");
        }
        else{            
            String message = "For " + date + " task(s), you have ";
            for (int i = 0; i < result.size(); i++){
                message += result.get(i);
                
                if (i != result.size()-1){
                    message += ", ";
                }else{
                    message += ", Nara.";
                }
            }
            parent.setDialogText(message);
        } 
    }
    
    private LocalDate convertStrDate(String timeStr){
        String modify = timeStr;
        if (timeStr.length() != 10){
            modify = timeStr.substring(0, 8) + "0" + timeStr.charAt(8);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(modify, formatter);
        return date;
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
            java.util.logging.Logger.getLogger(AranaraChatMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AranaraChatMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AranaraChatMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AranaraChatMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AranaraChatMenu().setVisible(true);
            }
        });
    }
    
    private App.ButtonCustom hiBtn;
    private App.ButtonCustom taskBtn;
    private App.ButtonCustom wordBtn;
    private App.ButtonCustom excelBtn;
    private App.ButtonCustom pptBtn;
    private App.ButtonCustom timerBtn;
    private App.ButtonCustom weatherBtn;
    private App.ButtonCustom gameBtn;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
