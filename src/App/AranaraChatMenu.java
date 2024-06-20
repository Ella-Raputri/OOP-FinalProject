/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import DatabaseConnection.CONFIG;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Asus
 */
public class AranaraChatMenu extends javax.swing.JFrame {
    private String userID;
    private EditAranara parent;
    private String username;
    private LinkedList<Task> taskList = new LinkedList<>();
    private String game_choice;
    private String aranara_choice;
    CONFIG config = new CONFIG();
    private final String API_KEY = config.getAPI_KEY(); 
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
    private static int open = 0;
    private SfxPlayer sfx = new SfxPlayer("src/App/sound/select.wav", 0.4f);;
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
    
    
    private void initDesign(){
        queryAllUserInfo(); //get all user information
        //init components
        hiBtn = new App.ButtonCustom();
        taskBtn = new App.ButtonCustom();
        wordBtn = new App.ButtonCustom();
        excelBtn = new App.ButtonCustom();
        pptBtn  = new App.ButtonCustom();
        timerBtn = new App.ButtonCustom();
        weatherBtn = new App.ButtonCustom();
        gameBtn = new App.ButtonCustom();
        
        //set background color 
        getContentPane().setBackground(Color.white);
        
        //set the size and layout
        setPreferredSize(new java.awt.Dimension(410, 760));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //style the components and add them to the frame
        //also play sfx for every button clicked
        hiBtn.setForeground(new java.awt.Color(255, 255, 255));
        hiBtn.setText("");
        hiBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hiBtn.png")));
        hiBtn.setBorderColor(new java.awt.Color(93, 93, 93));
        hiBtn.setBorderColorNotOver(new java.awt.Color(93, 93, 93));
        hiBtn.setBorderColorOver(new java.awt.Color(93, 93, 93));
        hiBtn.setColor(Color.white);
        hiBtn.setColorClick(new java.awt.Color(234, 234, 234));
        hiBtn.setColorOver(new java.awt.Color(234, 234, 234));
        hiBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        hiBtn.setRadius(20);
        hiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (open == 0){
                   open = 1;
                   sfx.loadSound("src/App/sound/select.wav", 0.8f);
                   sfx.play();
                   hiBtnActionPerformed();                   
                }else{
                   JOptionPane.showMessageDialog(getContentPane(), "One button window is already opened.");
                }                
            }
        });
        getContentPane().add(hiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 73, 128, 119)); 
        
        taskBtn.setForeground(new java.awt.Color(255, 255, 255));
        taskBtn.setText("");
        taskBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/taskBtn.png")));
        taskBtn.setBorderColor(new java.awt.Color(93, 93, 93));
        taskBtn.setBorderColorNotOver(new java.awt.Color(93, 93, 93));
        taskBtn.setBorderColorOver(new java.awt.Color(93, 93, 93));
        taskBtn.setColor(Color.white);
        taskBtn.setColorClick(new java.awt.Color(234, 234, 234));
        taskBtn.setColorOver(new java.awt.Color(234, 234, 234));
        taskBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        taskBtn.setRadius(20);
        taskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (open == 0){
                   open = 1;
                   sfx.loadSound("src/App/sound/select.wav", 0.8f);
                   sfx.play();
                   taskBtnActionPerformed();                   
                }else{
                   JOptionPane.showMessageDialog(getContentPane(), "One button window is already opened.");
                }  
            }
        });
        getContentPane().add(taskBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 73, 128, 119)); 
        
        wordBtn.setForeground(new java.awt.Color(255, 255, 255));
        wordBtn.setText("");
        wordBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/wordBtn.png")));
        wordBtn.setBorderColor(new java.awt.Color(93, 93, 93));
        wordBtn.setBorderColorNotOver(new java.awt.Color(93, 93, 93));
        wordBtn.setBorderColorOver(new java.awt.Color(93, 93, 93));
        wordBtn.setColor(Color.white);
        wordBtn.setColorClick(new java.awt.Color(234, 234, 234));
        wordBtn.setColorOver(new java.awt.Color(234, 234, 234));
        wordBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        wordBtn.setRadius(20);
        wordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (open == 0){
                   open = 1;
                   sfx.loadSound("src/App/sound/select.wav", 0.8f);
                   sfx.play();
                   openMsApplication("winword", "Word");                 
                }else{
                   JOptionPane.showMessageDialog(getContentPane(), "One button window is already opened.");
                }                
            }
        });
        getContentPane().add(wordBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 225, 128, 119)); 
        
        excelBtn.setForeground(new java.awt.Color(255, 255, 255));
        excelBtn.setText("");
        excelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/excelBtn.png")));
        excelBtn.setBorderColor(new java.awt.Color(93, 93, 93));
        excelBtn.setBorderColorNotOver(new java.awt.Color(93, 93, 93));
        excelBtn.setBorderColorOver(new java.awt.Color(93, 93, 93));
        excelBtn.setColor(Color.white);
        excelBtn.setColorClick(new java.awt.Color(234, 234, 234));
        excelBtn.setColorOver(new java.awt.Color(234, 234, 234));
        excelBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        excelBtn.setRadius(20);
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {               
               if (open == 0){
                   open = 1;
                   sfx.loadSound("src/App/sound/select.wav", 0.8f);
                   sfx.play();
                   openMsApplication("excel", "Excel");                   
                }else{
                   JOptionPane.showMessageDialog(getContentPane(), "One button window is already opened.");
                }  
            }
        });
        getContentPane().add(excelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 225, 128, 119)); 
        
        pptBtn.setForeground(new java.awt.Color(255, 255, 255));
        pptBtn.setText("");
        pptBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/pptBtn.png")));
        pptBtn.setBorderColor(new java.awt.Color(93, 93, 93));
        pptBtn.setBorderColorNotOver(new java.awt.Color(93, 93, 93));
        pptBtn.setBorderColorOver(new java.awt.Color(93, 93, 93));
        pptBtn.setColor(Color.white);
        pptBtn.setColorClick(new java.awt.Color(234, 234, 234));
        pptBtn.setColorOver(new java.awt.Color(234, 234, 234));
        pptBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        pptBtn.setRadius(20);
        pptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (open == 0){
                   open = 1;
                   sfx.loadSound("src/App/sound/select.wav", 0.8f);
                   sfx.play();
                   openMsApplication("powerpnt", "PowerPoint");                   
                }else{
                   JOptionPane.showMessageDialog(getContentPane(), "One button window is already opened.");
                }                 
            }
        });
        getContentPane().add(pptBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 377, 128, 119)); 
        
        timerBtn.setForeground(new java.awt.Color(255, 255, 255));
        timerBtn.setText("");
        timerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/timerBtn.png")));
        timerBtn.setBorderColor(new java.awt.Color(93, 93, 93));
        timerBtn.setBorderColorNotOver(new java.awt.Color(93, 93, 93));
        timerBtn.setBorderColorOver(new java.awt.Color(93, 93, 93));
        timerBtn.setColor(Color.white);
        timerBtn.setColorClick(new java.awt.Color(234, 234, 234));
        timerBtn.setColorOver(new java.awt.Color(234, 234, 234));
        timerBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        timerBtn.setRadius(20);
        timerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (open == 0){
                   open = 1;
                   sfx.loadSound("src/App/sound/select.wav", 0.8f);
                   sfx.play();
                   timerBtnActionPerformed();                   
                }else{
                   JOptionPane.showMessageDialog(getContentPane(), "One button window is already opened.");
                }                  
            }
        });
        getContentPane().add(timerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 377, 128, 119)); 
        
        weatherBtn.setForeground(new java.awt.Color(255, 255, 255));
        weatherBtn.setText("");
        weatherBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/weatherBtn.png")));
        weatherBtn.setBorderColor(new java.awt.Color(93, 93, 93));
        weatherBtn.setBorderColorNotOver(new java.awt.Color(93, 93, 93));
        weatherBtn.setBorderColorOver(new java.awt.Color(93, 93, 93));
        weatherBtn.setColor(Color.white);
        weatherBtn.setColorClick(new java.awt.Color(234, 234, 234));
        weatherBtn.setColorOver(new java.awt.Color(234, 234, 234));
        weatherBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        weatherBtn.setRadius(20);
        weatherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (open == 0){
                   open = 1;
                   sfx.loadSound("src/App/sound/select.wav", 0.8f);
                   sfx.play();
                   weatherBtnActionPerformed();                  
                }else{
                   JOptionPane.showMessageDialog(getContentPane(), "One button window is already opened.");
                }                  
            }
        });
        getContentPane().add(weatherBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 526, 128, 119)); 
        
        gameBtn.setForeground(new java.awt.Color(255, 255, 255));
        gameBtn.setText("");
        gameBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/gameBtn.png")));
        gameBtn.setBorderColor(new java.awt.Color(93, 93, 93));
        gameBtn.setBorderColorNotOver(new java.awt.Color(93, 93, 93));
        gameBtn.setBorderColorOver(new java.awt.Color(93, 93, 93));
        gameBtn.setColor(Color.white);
        gameBtn.setColorClick(new java.awt.Color(234, 234, 234));
        gameBtn.setColorOver(new java.awt.Color(234, 234, 234));
        gameBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        gameBtn.setRadius(20);
        gameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (open == 0){
                   open = 1;
                   sfx.loadSound("src/App/sound/select.wav", 0.8f);
                   sfx.play();
                   gameBtnActionPerformed();                   
                }else{
                   JOptionPane.showMessageDialog(getContentPane(), "One button window is already opened.");
                }                  
            }
        });
        getContentPane().add(gameBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 526, 128, 119)); 
        
        
        pack();
        //set the location to be (0,0) of the EditAranara frame
        int parentX = parent.getX();
        int parentY = parent.getY();
        setLocation(parentX, parentY);
    }
    
    private void openMsApplication(String app, String name) {
        //is used to open specific ms app on Windows 
        try {
            // Command to open Microsoft app on Windows
            String command = "cmd /c start " + app;
            // Execute the command
            Runtime.getRuntime().exec(command);            
            //set the dialogue box text
            parent.setDialogText("Opening Microsoft " + name + "... Please wait a moment, Nara!");
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error opening " + name + e.getMessage());
        }
        open = 0; //the opened window become 0
    }
    
    private void queryAllUserInfo(){
        try{//get all the user information from the database
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM user WHERE userID = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.userID);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
               //get the username
                username = rs.getString("username");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
            e.printStackTrace();
        } 
    }
    
    private void queryTask(){
       taskList.clear(); //clear the task list
        try{
            //get the tasks information from the database
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
                
                //add all the task from the same user to the task list
                Task new_task = new Task(tID, tname, ttype, ttimeFrom, ttimeTo, tnotes, tcolor, this.userID, tcomp);
                taskList.add(new_task);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        } 
    }
    
    private void hiBtnActionPerformed(){
        //when the user presses the Hi button
        String[] arama_msg = {"Hello Nara! I am Arama.", 
            "Nice to meet you, Nara " + username + ".", "Oh welcome, good Nara!"};
        
        String[] ararycan_msg = {"Hello, Nara. I am Ararycan.", 
            "Ahhh! Nara " + username + ".", "You are good Nara. Ararycan is not afraid."};
        
        String[] arabalika_msg = {"Hmph. I am Arabalika.", 
            "Arabalika want to see how strong Nara " + username + " is.", "Hmph. Arabalika wants to practice."};
        
        //randomly generate the message
        Random random = new Random();
        int index = random.nextInt(3);
        
        String[] proper = null;
        switch (parent.aranaraName) { //the message is based on the aranara
            case "Arama" -> proper = arama_msg;
            case "Ararycan" -> proper = ararycan_msg;
            case "Arabalika" -> proper = arabalika_msg;
            default -> {
            }
        }
        //set the dialog text
        parent.setDialogText(proper[index]);        
        open = 0; //opened window become 0
    }
    
    private void taskBtnActionPerformed(){        
        queryTask(); //query all the tasks information
        String[] options = {"today", "tomorrow", "random date"}; //options in joptionpane
        // Show the initial option dialog
        String choice = (String) JOptionPane.showInputDialog(
                null,   "Choose a date option:",
                "Date Options",  JOptionPane.PLAIN_MESSAGE,
                null,   options,  options[0]
        );

        if (choice == null) {
            // User pressed cancel or closed the dialog
            JOptionPane.showMessageDialog(parent.getContentPane(), "No options selected.");
            open = 0;
            return;
        }

        switch (choice) {
            case "today":
                // get task for today
                String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                getSpecificTaskDate(today);
                break;

            case "tomorrow":
                // get task for tomorrow's date
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
                        //get the task for the random date
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        sdf.setLenient(false);
                        Date date = sdf.parse(randomDate);
                        getSpecificTaskDate(randomDate);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Invalid date format. Please use yyyy-MM-dd.");
                    }
                } else {
                    // User pressed cancel or closed the dialog
                    JOptionPane.showMessageDialog(parent.getContentPane(), "No date entered.");
                }
                break;

            default:
                System.out.println("Unexpected option: " + choice);
        }        
        open =0; //opened window become 0
    }
    
    private void getSpecificTaskDate(String date){
        //set the inputted date
        LocalDate input_date = convertStrDate(date);
        LinkedList<String> result = new LinkedList<>();
        
        //iterate the taskList
        for (int i = 0; i < taskList.size(); i++){
            LocalDate date_from = convertStrDate(taskList.get(i).getTimeFromInput());
            if (taskList.get(i).getTypeInput().equals("One-day event")){  
                //if it is one day event and the date is equal to the inputted date
                if (date_from.equals(input_date)){
                    result.add(taskList.get(i).getNameInput()); //append task to result
                }
            //if it is multiple day event
            }else{
                LocalDate date_to = convertStrDate(taskList.get(i).getTimeToInput());
                LocalDate curr_iter = date_from;
                
                //if the inputted date is in range of the task date range
                while (!curr_iter.isAfter(date_to)) {
                    if (curr_iter.equals(input_date)){
                        //append to the result
                        result.add(taskList.get(i).getNameInput());
                        break;
                    }
                    // Increment date by one day
                    curr_iter = curr_iter.plusDays(1);
                }
            }
        }        
        //show the result in dialogue text
        if (result.isEmpty()){ //if empty
            parent.setDialogText("You don't have any tasks for " + date + ", Nara.");
        }
        else{       
            //if not empty
            String message = "For " + date + " task(s), you have ";
            for (int i = 0; i < result.size(); i++){
                message += result.get(i);
                //iterate over all the task inside the result
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
        //if the date is still 2024-02-8, then make it to become 2024-02-08
        if (timeStr.length() != 10){
            modify = timeStr.substring(0, 8) + "0" + timeStr.charAt(8);
        }
        //convert the date to localdate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(modify, formatter);
        return date;
    }

    private void timerBtnActionPerformed(){
        //prompt the user to input the time
        String timeStr = JOptionPane.showInputDialog(null, "Please enter minutes and seconds "
                + "in the format of minute:second.", "Time Input", JOptionPane.PLAIN_MESSAGE);
        
        if (!timeStr.contains(":")){ //check the formet
            JOptionPane.showMessageDialog(null, "The inputted time format is not correct.");
            open = 0;
            return;
        }
        
        String[] arrOfStr = timeStr.split(":"); //split the minute and second
        //validation
        if (!isDigit(arrOfStr[0]) || !isDigit(arrOfStr[1])){ //if one of them is not digit
            JOptionPane.showMessageDialog(null, "The inputted time is not valid.");
        }else{
            if (Integer.parseInt(arrOfStr[0]) < 0 || Integer.parseInt(arrOfStr[1]) < 0){
                //if the minute and second is smaller than 0
                JOptionPane.showMessageDialog(null, "The minute and second has to be greater or equal to 0.");
            }
            else if (Integer.parseInt(arrOfStr[1]) >= 60){
                //if the second is greater than or equal to 60
                JOptionPane.showMessageDialog(null, "The second has to be smaller than 0.");
            }
            else{
                //all conditions met
                setReminder(arrOfStr[0], arrOfStr[1]);
            }
        }        
        open =0; //opened window become 0 again
    }
    
    private void setReminder(String min, String sec){
        //get the reminder time
        int timeSec = Integer.parseInt(min) * 60 + Integer.parseInt(sec);
        parent.setDialogText("Timer starts!"); //set the dialog text
        
        //set the timer based on the inputted time
        Timer timer = new Timer(timeSec * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCustomDialog("Time's up, Nara!");
            }
        });
        // Start the timer
        timer.setRepeats(false); // Make sure the timer only runs once
        timer.start();
    }
    
    private void showCustomDialog(String message) {
        // Create an option pane
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);        
        // Create a JDialog from the option pane
        JDialog dialog = optionPane.createDialog(parent, "Notification");        
        // Set the dialog as always on top
        dialog.setAlwaysOnTop(true);        
        // Show the dialog
        dialog.setVisible(true);
        parent.setDialogText("Time's up, Nara!");
    }
    
    private static boolean isDigit(String str){
        return str.matches("\\d+");
    }
    
    private void aranaraTurn(){
        //the aranara turn in playing the game
        String[] move = {"rock", "paper", "scissors"};
        //the move will be randomized
        Random random = new Random();
        int index = random.nextInt(3);
        String label_icon_path = "/App/img/dialog_game_" + move[index] + ".png";
        aranara_choice = move[index];
        //set the move in the dialog box
        parent.setGameDialogIcon(label_icon_path);
    }
    
    private void judgeGame(){
        //judge the game result
        String message = "";
        if (aranara_choice.equals(game_choice)){
            //if its a draw
            message = getGameMsg("draw");
        }else{
            //user rock case
            if (game_choice.equals("rock")){
                if (aranara_choice.equals("paper")){
                    //user lose if aranara use paper
                   message = getGameMsg("lose");  
                }else{
                    //user win if aranara use scissors
                   message = getGameMsg("win");
                }
            }
            //user paper case
            else if (game_choice.equals("paper")){
                if (aranara_choice.equals("scissors")){
                    //user lose if aranara use scissors
                   message = getGameMsg("lose");
                }else{
                    //user win if aranara use rock
                   message = getGameMsg("win");
                }
            }
            //user scissors case
            else if (game_choice.equals("scissors")){
                if (aranara_choice.equals("rock")){
                    //user lose if aranara use rock
                   message = getGameMsg("lose");
                }else{
                    //user win if aranara use paper
                   message = getGameMsg("win");
                }
            }
        }        
        parent.setDialogText(message); //set the dialog text
    }
    
    private String getGameMsg(String player_result){
        String message = "";
        //set dialogue based on the game result and the aranara name
        if (player_result.equals("win")){ //user wins
           switch (parent.aranaraName) {
                case "Arama" -> message = "Look's like the winner is Nara " + username;
                case "Ararycan" -> message = "Ararycan is losing?";
                case "Arabalika" -> message = "Hmph. Arabalika admits you have some skills.";
                default -> {}
            } 
           //load win sfx
            sfx.loadSound("src/App/sound/win.wav", 0.8f);
            sfx.play();
        }
        else if (player_result.equals("lose")){ //user loses
           switch (parent.aranaraName) {
                case "Arama" -> message = "Arama wins?! How exciting, Arama is happy!";
                case "Ararycan" -> message = "Mm. Ararycan thinks it odds that Ararycan wins, but Ararycan is happy!";
                case "Arabalika" -> message = "Don't be careless, Nara. Let's try again.";
                default -> {}
            } 
           //load lose sfx
           sfx.loadSound("src/App/sound/lose.wav", 0.8f);
           sfx.play();
        }
        else if (player_result.equals("draw")){ //ends in draw
           switch (parent.aranaraName) {
                case "Arama" -> message = "Great mind thinks alike, Nara!";
                case "Ararycan" -> message = "Mmmm... then who's the winner, Nara?";
                case "Arabalika" -> message = "Hmph. it's a draw.";
                default -> {}
            } 
           //load draw sfx
            sfx.loadSound("src/App/sound/draw.wav", 0.8f);
            sfx.play();
        }
        return message;
    }
    
    private void gameBtnActionPerformed(){
        createGamePanel();
        open = 0;
    }
    
    private void createGamePanel(){
        //init the panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(460, 220));
        panel.setLayout(null);
        panel.setBackground(Color.white);

        //init the label
        JLabel label = new JLabel("Please choose your move, Nara!");
        label.setForeground(Color.black);
        label.setFont(new Font("Montserrat", 0, 24));
        label.setBounds(23, 33, 400, 29);
        panel.add(label);

        //the rock button
        JLabel rockBtn = new JLabel();
        rockBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/rock.png"))); // NOI18N
        rockBtn.setBounds(28, 98, 96, 91);
        panel.add(rockBtn);
        
        //the paper button
        JLabel paperBtn = new JLabel();
        paperBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/paper.png"))); // NOI18N
        paperBtn.setBounds(158, 98, 96, 91);        
        panel.add(paperBtn);
        
        //the scissors button
        JLabel scisBtn = new JLabel();
        scisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/scissors.png"))); // NOI18N
        scisBtn.setBounds(288, 98, 96, 91);
        panel.add(scisBtn);
        
        //the dialog
        JDialog dialog = new JDialog(this, "Game", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(panel);
        dialog.pack();
        
        //the buttons behaviour when they are hovered and clicked
        initGameBtnHover(rockBtn, paperBtn, scisBtn, dialog);
        
        //set the position of the dialog
        int parentX = parent.getX();
        int parentY = parent.getY()+50;
        dialog.setLocation(parentX, parentY+300);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);        
    }
    
    private void gameSystem(JDialog dialog){
        //aranara make a choice
        aranaraTurn();
        dialog.dispose(); //dispose the game panel dialog
        //sleep 2.2 seconds for the user to see the aranara choice
        Timer timer = new Timer(2200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                judgeGame(); //then judge the game
            }
        });
        //start the timer
        timer.setRepeats(false);
        timer.start();
    }
    
    private void initGameBtnHover(JLabel rockBtn, JLabel paperBtn, JLabel scisBtn, JDialog dialog){
        rockBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //when rock is clicked, user choice becomes rock
                game_choice = "rock";
                sfx.loadSound("src/App/sound/select.wav", 0.8f);
                sfx.play();
                paperBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/paper_disabled.png")));
                paperBtn.setEnabled(false);
                scisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/scissors_disabled.png")));
                scisBtn.setEnabled(false);
                gameSystem(dialog);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                rockBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/rock_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                rockBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/rock.png")));
            }
        });
        
        paperBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //when paper is clicked, user choice becomes paepr
                game_choice = "paper";
                sfx.loadSound("src/App/sound/select.wav", 0.8f);
                sfx.play();
                rockBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/rock_disabled.png")));
                rockBtn.setEnabled(false);
                scisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/scissors_disabled.png")));
                scisBtn.setEnabled(false);
                gameSystem(dialog);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                paperBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/paper_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                paperBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/paper.png")));
            }
        });
        
        scisBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //when scissors is clicked, user choice becomes scissors
                game_choice = "scissors";
                sfx.loadSound("src/App/sound/select.wav", 0.8f);
                sfx.play();
                rockBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/rock_disabled.png")));
                rockBtn.setEnabled(false);
                paperBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/paper_disabled.png")));
                paperBtn.setEnabled(false);
                gameSystem(dialog);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                scisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/scissors_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                scisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/scissors.png")));
            }
        });
    }
    
    private void weatherBtnActionPerformed(){
        //prompt the user to enter the city
        String city = JOptionPane.showInputDialog("Enter your city: ");
        getWeather(city);
        open = 0;
    }
    
    private void getWeather(String city) {
        try {
            //set the url string for calling the API
            String urlString = String.format(WEATHER_URL, city, API_KEY);
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            //get the response code 
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                //parse the response
                parseWeatherResponse(response.toString());
            } else {
                //if the city is not available or error
                parent.setDialogText(city + " is not available, Nara!");
                System.out.println("GET request failed. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseWeatherResponse(String response) {
        //init a json object to store the api call response
        JSONObject jsonObject = new JSONObject(response);
        //get the city name
        String cityName = jsonObject.getString("name");
        JSONObject main = jsonObject.getJSONObject("main");        
        //get the temperature
        double temperature = main.getDouble("temp");
        double tempInCelsius = temperature - 273.15; // Convert from Kelvin to Celsius
        
        //get the weather description
        JSONArray weatherArray = jsonObject.getJSONArray("weather");
        JSONObject weatherObj = weatherArray.getJSONObject(0);
        String weatherMain = weatherObj.getString("main");
        String weatherDesc = weatherObj.getString("description");
        
        //set the temperature string to 2 decimal points 
        String temper = String.format("%.2f", tempInCelsius) + " °C";
        //get the reccomendation of the aranara based on the main weather description
        String suppMsg = getAranaraMsg(weatherMain); 
        //set up the message
        String msg = "The weather in " + cityName + " today is " + weatherMain 
                + " (" + weatherDesc + ") with the temperature of " 
                + temper + ". " + suppMsg;
        
        parent.setDialogText(msg); //set the dialog text of the message
    }
    
    private String getAranaraMsg(String main){
        String msg = "";
        //get the aranara message based on the weather main condition
        if(main.equals("Clear")){
            msg += "A good day for exploring, Nara!";
        }
        else if(main.equals("Clouds")){
            msg += "Better prepare your umbrella, Nara.";
        }
        else if(main.equals("Drizzle") || main.equals("Rain") || main.equals("Thunderstorm")){
            msg += "Don't forget your umbrella, Nara!";
        }
        else if(main.equals("Snow")){
            msg += "It's cold, wear more warm clothes, Nara.";
        }
        else if(main.equals("Mist") || main.equals("Fog")){
            msg += "Be careful when hitting the road, Nara.";
        }
        else if(main.equals("Smoke") || main.equals("Sand") || main.equals("Haze") || main.equals("Ash")){
            msg += "Wear your mask, Nara!";
        }
        else if(main.equals("Squall") || main.equals("Tornado")){
            msg += "Better stay indoor, Nara.";
        }
        
        return msg;
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
