/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Asus
 */
public class EditTask extends javax.swing.JFrame {

    private String userID;
    private String thisID; 
    private Task thisTask;
    private CalendarPage home;
    private HashMap <String, String> monthMap = new HashMap<>();
    /**
     * Creates new form AddNewTask
     */
    
    
    public EditTask(String userID, CalendarPage home, String thisID) {
        setResizable(false);
        setTitle("Edit Task");
        this.home = home;
        this.userID = userID;
        this.thisID = thisID;
        initComponents();
        initDesign();
        myinit();
    }
    
    private void initDesign(){
        //set background color
        getContentPane().setBackground(Color.white);
        
        //init components
        oneDay = new javax.swing.JRadioButton();
        nameField = new PlaceHolderTextField("Name",10);
        multipleDay = new javax.swing.JRadioButton();
        theDay_from = new javax.swing.JLabel();
        theDay_to = new javax.swing.JLabel();
        noteScrollPane = new javax.swing.JScrollPane();
        noteArea = new PlaceHolderJTextArea("Notes");
        colortxt = new javax.swing.JLabel();
        monthFromComboBox = new javax.swing.JComboBox<>();
        titletxt = new javax.swing.JLabel();
        saveBtn = new App.ButtonCustom();
        deleteBtn = new javax.swing.JLabel();
        fromYearField = new PlaceHolderTextField("Year",20);
        colorComboBox = new javax.swing.JComboBox<>();
        fromDateField = new PlaceHolderTextField("Date",10);
        toDateField = new PlaceHolderTextField("Date",10);
        monthToComboBox = new javax.swing.JComboBox<>();
        toYearField = new PlaceHolderTextField("Year",20);
        optGrp = new javax.swing.ButtonGroup();

        //add them to the button group, so that only one button can be selected at a time
        optGrp.add(oneDay); optGrp.add(multipleDay);
        
        //set size and layout
        setPreferredSize(new java.awt.Dimension(500, 577));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //styling components
        oneDay.setBackground(new java.awt.Color(255, 255, 255));
        oneDay.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        oneDay.setSelected(true);
        oneDay.setText("One-day event");
        oneDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //disable the to fields
                toDateField.setEnabled(false);
                toYearField.setEnabled(false);
                monthToComboBox.setEnabled(false);
                revalidate();
                repaint();
            }
        });
        getContentPane().add(oneDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        nameField.setBackground(new java.awt.Color(234, 234, 234));
        nameField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        nameField.setForeground(new java.awt.Color(155, 154, 154));
        nameField.setText("Name");
        nameField.setBorder(new EmptyBorder(new Insets(5, 15, 5, 10)));
        nameField.setCaretPosition(0);
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 427, 41));

        multipleDay.setBackground(new java.awt.Color(255, 255, 255));
        multipleDay.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        multipleDay.setText("Multiple-day event");
        multipleDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //enable the to fields
                toDateField.setEnabled(true);
                toYearField.setEnabled(true);
                monthToComboBox.setEnabled(true);
                revalidate();
                repaint();
            }
        });
        getContentPane().add(multipleDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));
        
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_flow_active.png")));
        deleteBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteBtnActionPerformed();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_flow_hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_flow_active.png")));
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 475, -1, -1));
        
        theDay_from.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        theDay_from.setText("From");
        getContentPane().add(theDay_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 195, -1, -1));

        theDay_to.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        theDay_to.setText("To");
        getContentPane().add(theDay_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        noteArea.setBackground(new java.awt.Color(234, 234, 234));
        noteArea.setColumns(22);
        noteArea.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        noteArea.setForeground(new java.awt.Color(155, 154, 154));
        noteArea.setRows(3);
        noteArea.setTabSize(5);
        noteArea.setText("Notes");
        noteArea.setBorder(new EmptyBorder(new Insets(5, 10, 5, 10)));
        noteScrollPane.setViewportView(noteArea);

        getContentPane().add(noteScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        colortxt.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        colortxt.setText("Color");
        getContentPane().add(colortxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        monthFromComboBox.setBackground(new java.awt.Color(234, 234, 234));
        monthFromComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        monthFromComboBox.setForeground(new java.awt.Color(155, 154, 154));
        monthFromComboBox.setMaximumRowCount(12);
        monthFromComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "Desember" }));
        monthFromComboBox.setToolTipText("");
        getContentPane().add(monthFromComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 150, 38));

        titletxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 32)); // NOI18N
        titletxt.setText("Edit Task");
        getContentPane().add(titletxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 15, -1, -1));

        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorderColor(new java.awt.Color(31, 139, 217));
        saveBtn.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
        saveBtn.setBorderColorOver(new java.awt.Color(125, 201, 255));
        saveBtn.setColor(new java.awt.Color(31, 139, 217));
        saveBtn.setColor2(java.awt.Color.white);
        saveBtn.setColorClick(new java.awt.Color(125, 201, 255));
        saveBtn.setColorClick2(java.awt.Color.white);
        saveBtn.setColorOver(new java.awt.Color(125, 201, 255));
        saveBtn.setColorOver2(java.awt.Color.white);
        saveBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        saveBtn.setRadius(50);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed();
            }
        });
        getContentPane().add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 110, 47));

        fromYearField.setBackground(new java.awt.Color(234, 234, 234));
        fromYearField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        fromYearField.setForeground(new java.awt.Color(155, 154, 154));
        fromYearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromYearField.setText("Year");
        fromYearField.setToolTipText("");
        getContentPane().add(fromYearField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 90, 38));

        colorComboBox.setBackground(new java.awt.Color(234, 234, 234));
        colorComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        colorComboBox.setForeground(new java.awt.Color(155, 154, 154));
        colorComboBox.setMaximumRowCount(10);
        colorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blue", "Red", "Orange", "Yellow", "Green", "Purple", "Pink", "Brown" }));
        colorComboBox.setToolTipText("");
        getContentPane().add(colorComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 100, 38));

        fromDateField.setBackground(new java.awt.Color(234, 234, 234));
        fromDateField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        fromDateField.setForeground(new java.awt.Color(155, 154, 154));
        fromDateField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromDateField.setText("Date");
        fromDateField.setToolTipText("");
        getContentPane().add(fromDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 60, 38));

        toDateField.setBackground(new java.awt.Color(234, 234, 234));
        toDateField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        toDateField.setForeground(new java.awt.Color(155, 154, 154));
        toDateField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toDateField.setText("Date");
        toDateField.setToolTipText("");
        getContentPane().add(toDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 245, 60, 38));

        monthToComboBox.setBackground(new java.awt.Color(234, 234, 234));
        monthToComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        monthToComboBox.setForeground(new java.awt.Color(155, 154, 154));
        monthToComboBox.setMaximumRowCount(12);
        monthToComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "Desember" }));
        monthToComboBox.setToolTipText("");
        getContentPane().add(monthToComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 245, 150, 38));

        toYearField.setBackground(new java.awt.Color(234, 234, 234));
        toYearField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        toYearField.setForeground(new java.awt.Color(155, 154, 154));
        toYearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toYearField.setText("Year");
        toYearField.setToolTipText("");
        getContentPane().add(toYearField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 245, 90, 38));
        
        //the to fields are disabled by default because one-day is selected by default
        toDateField.setEnabled(false);
        toYearField.setEnabled(false);
        monthToComboBox.setEnabled(false);
        pack();
        setLocationRelativeTo(null);
    }
    
    private void deleteBtnActionPerformed(){
        queryCurrentTask(); //get the information of the current task
        //ask for confirmation
        String question = "Do you really want to delete " + thisTask.getNameInput() + "?";
        int a = JOptionPane.showConfirmDialog(getContentPane(), question, "SELECT", JOptionPane.YES_OPTION);
        
        if (a == 0){
            String id = thisTask.getId(); //get task ID
            
            //delete from database
            try{
                Connection conn = ConnectionProvider.getCon();
                String query = "DELETE FROM tasks WHERE taskID = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, id);
                
                ps.executeUpdate();
                String message = "Task deleted successfully.";
                JOptionPane.showMessageDialog(getContentPane(), message);                
                
            }catch(SQLException se){
                JOptionPane.showMessageDialog(getContentPane(), se);
            }
            
            // go back to calendar page
            CalendarPage.open=0;
            setVisible(false);
            
            //refresh calendar page
            home.queryTask(); //refresh task list
            home.queryCurrentTaskList(); //refresh current task list
            
            //refresh task panel
            home.cloneablePanel.removeAll();
            home.createClonedPanels(home.currTasksList, home.currTasksList.size());
            home.renewTaskText();
            //refresh task dots in calendar panel
            home.calendarCustom2.refreshTaskDots();
            
            //remove the task dot
            if (thisTask.getTypeInput().equals("One-day event")){
                //if it is a one day event
                CalendarCell current = home.calendarCustom2.currentPanel.getCurrentCell(); //get current cell
                current.setTaskAmount(current.getTaskAmount() -1); //deduct the task amount
                if (current.getTaskAmount() <= 0){
                    //false has task means that there is no other dots
                   current.setHasTasks(false, ""); //set has task to be false if the task amount <= 0
                }                
            }
            else{
                //get the range of date to and date from
                LocalDate date_to = home.convertStrDate(thisTask.getTimeToInput());
                LocalDate date_from = home.convertStrDate(thisTask.getTimeFromInput());
                
                //for every cell 
                for (CalendarCell cell1 : home.calendarCustom2.currentPanel.getCells()){
                    LocalDate date_cell = cell1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    //if the cell is in the task date range
                   if (date_cell.isAfter(date_from.minusDays(1)) && date_cell.isBefore(date_to.plusDays(1))){
                        cell1.setTaskAmount(cell1.getTaskAmount() -1); //deduct the task amount
                        if (cell1.getTaskAmount() <= 0){
                            //false has task means that there is no other dots
                             cell1.setHasTasks(false, ""); //set has task as false if the task amount  <= 0
                        }
                   } 
                }
            }
            //revalidate and repaint
            home.calendarCustom2.currentPanel.revalidate();
            home.calendarCustom2.currentPanel.repaint();
        }
    }
    
    private boolean isInteger(String str){
        try {
            //ig there is no error when parsing the integer, return tru
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            //if exception happens, return false
            return false;
        }
    }
    
    private void queryCurrentTask(){
        try{ //get information about current task based on its ID
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM tasks WHERE taskID = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.thisID);
            
            //get the attribute
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String tName = rs.getString("name");
                String tType = rs.getString("type");
                String timeFrom = rs.getString("timeFrom");
                String timeTo = rs.getString("timeTo");
                String tNotes = rs.getString("notes");
                String tColor = rs.getString("color");                
                //set it as a task object
                thisTask = new Task(this.thisID, tName, tType, timeFrom, timeTo, tNotes, tColor, this.userID, false);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    private void handleDateMonthYear(String time, JTextField dateField, JComboBox monthBox, JTextField yearField){
        //split the string YYYY-MM-dd to three elements
        String[] arrTime = time.split("-");
        
        yearField.setText(arrTime[0]); //the YYYY part will be the year
        dateField.setText(arrTime[2]); //the dd part will be the date   
        monthBox.setSelectedIndex(Integer.parseInt(arrTime[1])-1); //the month box selected index will be the same as MM
    }
    
    private void setUpFields(){
        //set name field as the task name
        nameField.requestFocus();
        nameField.setText(thisTask.getNameInput());
        
        //set radio button
        if (thisTask.getTypeInput().equals("One-day event")){
            //if it is one day event
            oneDay.setSelected(true);   
            //disable the to fields
            toDateField.setEnabled(false);
            monthToComboBox.setEnabled(false);
            toYearField.setEnabled(false);
            repaint();
        }else{
            //if it is multiple day event
            multipleDay.setSelected(true);
            //enable the to fields
            toDateField.setEnabled(true);
            monthToComboBox.setEnabled(true);
            toYearField.setEnabled(true);
            repaint();
            //set dateTo to the to fields
            handleDateMonthYear(thisTask.getTimeToInput(), toDateField, monthToComboBox, toYearField);
        }
        
        //set date from to the from fields
        handleDateMonthYear(thisTask.getTimeFromInput(), fromDateField, monthFromComboBox, fromYearField);
        noteArea.setText(thisTask.getNoteInput()); //set notes
        colorComboBox.setSelectedItem(thisTask.getColorInput()); //set color
    }
    
    private void myinit(){        
        queryCurrentTask(); //query current task
        setUpFields(); //set up the fields based on the task info
        
        //set default close operation
        //upon clicking the 'x' button, the window will not close
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // ask for confirmation
                int option = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    //close this window only and set the opened window of calendar page to become 0
                    CalendarPage.open = 0;
                    setVisible(false);
                } 
            }
        });
        
        //populating the monthMap hash map
        monthMap.put("January", "01");
        monthMap.put("February", "02");
        monthMap.put("March", "03");
        monthMap.put("April", "04");
        monthMap.put("May", "05");
        monthMap.put("June", "06");
        monthMap.put("July", "07");
        monthMap.put("August", "08");
        monthMap.put("September", "09");
        monthMap.put("October", "10");
        monthMap.put("November", "11");
        monthMap.put("December", "12");
    }
    
    
    private void saveBtnActionPerformed(){
        //get the data inside the fieldw
        String nameStr = nameField.getText();
        String typeStr;
        String dateToStr, monthToStr, yearToStr;
        
        if(oneDay.isSelected()){
            typeStr = "One-day event";
            //the to field attributes are not important if it is one day event
            dateToStr = "0";
            monthToStr = "0";
            yearToStr = "0";
        }
        else{
            typeStr = "Multiple-day event";
            dateToStr = toDateField.getText();
            monthToStr = (String) monthToComboBox.getSelectedItem();
            yearToStr = toYearField.getText();
        }
        
        String dateFromStr = fromDateField.getText();
        String monthFromStr = (String) monthFromComboBox.getSelectedItem();
        String yearFromStr = fromYearField.getText();
            
        String noteStr = noteArea.getText();
        if (noteStr.equals("Notes")){
            noteStr = "";
        }        
        String colorStr = (String) colorComboBox.getSelectedItem();
        
        //validation
        if (nameStr.equals("Name") || nameStr.equals("")){ //empty name
            JOptionPane.showMessageDialog(getContentPane(), "Name is still empty.");
        }
        else if (dateFromStr.equals("Date") || dateFromStr.equals("")){ //empty dateFrom
            JOptionPane.showMessageDialog(getContentPane(), "Date 'from' is still empty.");
        }
        else if (!isInteger(dateFromStr)){ //dateFrom is not integer
            JOptionPane.showMessageDialog(getContentPane(), "Date 'from' is not valid.");
        }
        else if (yearFromStr.equals("Year") || yearFromStr.equals("")){ //yearFrom is empty
            JOptionPane.showMessageDialog(getContentPane(), "Year 'from' is still empty.");
        }
        else if (!isInteger(yearFromStr)){ //yearFrom is not ineteger
            JOptionPane.showMessageDialog(getContentPane(), "Year 'from' is not valid.");
        }       
        //only for multiple day event
        else if ((dateToStr.equals("Date") || dateToStr.equals("")) && typeStr.equals("Multiple-day event")){
            JOptionPane.showMessageDialog(getContentPane(), "Date 'to' is still empty."); //empty dateTo
        }
        else if (!isInteger(dateToStr) && typeStr.equals("Multiple-day event")){
            JOptionPane.showMessageDialog(getContentPane(), "Date 'to' is not valid."); //dateTo is not integer
        }
        else if ((yearToStr.equals("Year") || yearToStr.equals("")) && typeStr.equals("Multiple-day event")){
            JOptionPane.showMessageDialog(getContentPane(), "Year 'to' is still empty."); //empty yearTo
        }
        else if (!isInteger(yearToStr) && typeStr.equals("Multiple-day event")){
            JOptionPane.showMessageDialog(getContentPane(), "Year 'to' is not valid."); //yearTo is not ineteger
        }
        else{
            //set date from and date to become String YYYY-MM-dd
            String timeFrom = yearFromStr + "-"  + monthMap.get(monthFromStr) + "-" + dateFromStr;
            String timeTo = yearToStr + "-"  + monthMap.get(monthToStr) + "-" + dateToStr;
            boolean safe = false; //track whether the date range is valid
            
            if (typeStr.equals("Multiple-day event")){
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");            
                try {
                    // Parse the date strings into Date objects
                    Date dateFrom = dateFormat.parse(timeFrom);
                    Date dateTo = dateFormat.parse(timeTo);

                    // Compare the dates to see whether the date range is valid
                    if (dateFrom.compareTo(dateTo) > 0) {
                        JOptionPane.showMessageDialog(getContentPane(), "Date range is not valid.");
                    } else if (dateFrom.compareTo(dateTo) < 0) {
                        safe = true; //valid
                    } else {
                        //if the dateFrom and dateTo is the same
                        JOptionPane.showMessageDialog(getContentPane(), "Date 'from' and 'to' are the same. Consider changing to one-day event.");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                } 
            }else{
                //if it's one day event
                safe = true;
            }
            
            if (safe){//if valid
                try{
                   Connection con = ConnectionProvider.getCon();
                   //update the tasks table
                   PreparedStatement ps = con.prepareStatement("UPDATE tasks SET name = ?, type = ?, timeFrom = ?, "
                           + "timeTo = ?, notes = ?, color = ? WHERE taskID = ?");
                   ps.setString(1, nameStr);
                   ps.setString(2, typeStr);                   
                   ps.setString(3, timeFrom);
                   ps.setString(4, timeTo);
                   ps.setString(5, noteStr);
                   ps.setString(6, colorStr);
                   ps.setString(7, this.thisID);
                   ps.executeUpdate();
                   
                   //success message
                   String message = "Task edited successfully.";              
                   JOptionPane.showMessageDialog(getContentPane(), message);

                   //go back to calendarpage
                    CalendarPage.open=0;
                    setVisible(false);
                    
                    //refresh calendar page
                    home.queryTask(); //query task list
                    home.queryCurrentTaskList(); //query current task list
                    
                    //refresh the task panel
                    home.cloneablePanel.removeAll(); 
                    home.createClonedPanels(home.currTasksList, home.currTasksList.size());
                    home.renewTaskText();
                    
                    //refresh the task dots
                    home.calendarCustom2.refreshTaskDots();                    
                    home.calendarCustom2.currentPanel.revalidate();
                    home.calendarCustom2.currentPanel.repaint();

               }catch(Exception e){
                   JOptionPane.showMessageDialog(getContentPane(), e);
               }
            }   
        }
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
    
    private javax.swing.JComboBox<String> colorComboBox;
    private javax.swing.JLabel colortxt;
    private javax.swing.JTextField fromDateField;
    private javax.swing.JTextField fromYearField;
    private javax.swing.JScrollPane noteScrollPane;
    private javax.swing.JComboBox<String> monthFromComboBox;
    private javax.swing.JComboBox<String> monthToComboBox;
    private javax.swing.JRadioButton multipleDay;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextArea noteArea;
    private javax.swing.JRadioButton oneDay;
    private App.ButtonCustom saveBtn;
    private javax.swing.JLabel theDay_from;
    private javax.swing.JLabel theDay_to;
    private javax.swing.JLabel titletxt;
    private javax.swing.JTextField toDateField;
    private javax.swing.JTextField toYearField;
    private javax.swing.ButtonGroup optGrp;
    private javax.swing.JLabel deleteBtn;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
