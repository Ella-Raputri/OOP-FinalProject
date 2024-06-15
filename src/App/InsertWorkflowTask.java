/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class InsertWorkflowTask extends javax.swing.JFrame {
    private String userID;
    private String lastID;
    private LinkedList <Workflow> workflowList = new LinkedList <>();
    private LinkedList <Flow> flowList = new LinkedList <>();
    private HashMap<String,String> monthMap = new HashMap<>();
    private CalendarPage home;
    /**
     * Creates new form InsertWorkflowTask
     */
    public InsertWorkflowTask(String userID, CalendarPage home) {
        setResizable(false);
        setTitle("Insert Workflow to Tasks");
        this.userID = userID;
        this.home = home;
        initComponents();
        initDesign();
    }
    
    
    private void initDesign(){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Custom close operation logic
                int option = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    CalendarPage.open=0;
                } 
            }
        });
        
        
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
        
        getContentPane().setBackground(Color.white);
        chooseDatetxt = new javax.swing.JLabel();
        d_day = new javax.swing.JLabel();
        dateField = new PlaceHolderTextField("Date", 5);
        monthComboBox = new javax.swing.JComboBox<>();
        yearField = new PlaceHolderTextField("Year",20);
        workflowBox = new javax.swing.JComboBox<>();
        chooseWorkflowtxt = new javax.swing.JLabel();
        OKbtn = new App.ButtonCustom();
        
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(450, 350));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        String year = formattedDate.substring(0,4);
        String month = formattedDate.substring(5,7);
        String date = formattedDate.substring(8,10);

        chooseDatetxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        chooseDatetxt.setText("Choose Date");
        getContentPane().add(chooseDatetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        d_day.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        d_day.setText("D-Day:");
        getContentPane().add(d_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, -1, -1));

        dateField.setBackground(new java.awt.Color(234, 234, 234));
        dateField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        dateField.setForeground(new java.awt.Color(93, 93, 93));
        dateField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateField.setText(date);
        dateField.setToolTipText("");
        getContentPane().add(dateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 60, 32));

        monthComboBox.setBackground(new java.awt.Color(234, 234, 234));
        monthComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        monthComboBox.setForeground(new java.awt.Color(93, 93, 93));
        monthComboBox.setMaximumRowCount(12);
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "Desember" }));
        monthComboBox.setToolTipText("");
        monthComboBox.setSelectedIndex(Integer.parseInt(month)-1);
        getContentPane().add(monthComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, 32));

        yearField.setBackground(new java.awt.Color(234, 234, 234));
        yearField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        yearField.setForeground(new java.awt.Color(93, 93, 93));
        yearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yearField.setText(year);
        yearField.setToolTipText("");
        getContentPane().add(yearField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 80, 32));
        
        chooseWorkflowtxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        chooseWorkflowtxt.setText("Choose Workflow");
        getContentPane().add(chooseWorkflowtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        
        String[] workflowOptions = queryAllWorkflow();
        String[] optionIfEmpty = {"None"};
        if (workflowOptions == null){
            workflowOptions = optionIfEmpty;
        }
        workflowBox.setBackground(new java.awt.Color(234, 234, 234));
        workflowBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        workflowBox.setForeground(new java.awt.Color(93, 93, 93));
        workflowBox.setMaximumRowCount(12);
        workflowBox.setModel(new javax.swing.DefaultComboBoxModel<>(workflowOptions));
        workflowBox.setToolTipText("");
        getContentPane().add(workflowBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 300, -1));
        
        OKbtn.setForeground(new java.awt.Color(255, 255, 255));
        OKbtn.setText("OK");
        OKbtn.setBorderColor(new java.awt.Color(31, 139, 217));
        OKbtn.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
        OKbtn.setBorderColorOver(new java.awt.Color(125, 201, 255));
        OKbtn.setColor(new java.awt.Color(31, 139, 217));
        OKbtn.setColor2(java.awt.Color.white);
        OKbtn.setColorClick(new java.awt.Color(125, 201, 255));
        OKbtn.setColorClick2(java.awt.Color.white);
        OKbtn.setColorOver(new java.awt.Color(125, 201, 255));
        OKbtn.setColorOver2(java.awt.Color.white);
        OKbtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        OKbtn.setRadius(10);
        OKbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKbtnActionPerformed();
            }
        });
        getContentPane().add(OKbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1,-1));
        pack();
        setLocationRelativeTo(null);
    }
    
    private String[] queryAllWorkflow(){
        workflowList.clear();
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM workflow WHERE userID = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.userID);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String wid = rs.getString("workflowID");
                String wtitle = rs.getString("title");
                int wcheckpoint = rs.getInt("checkpoint");
                
                Workflow workflow = new Workflow(wtitle, wcheckpoint, wid, this.userID);
                workflowList.add(workflow);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
        if (!workflowList.isEmpty()){
            String[] name = new String[workflowList.size()];
            for (int i = 0; i < workflowList.size(); i++){
                name[i] = workflowList.get(i).getTitle();
            }
            return name;
        }
        return null;
    }
    
    
    public boolean isValid(String dateStr, DateTimeFormatter dateFormatter) {
        try {
            LocalDate.parse(dateStr, dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
    
    private LocalDate conditioningDate(){        
        String dateStr = dateField.getText();
        String monthStr = (String) monthComboBox.getSelectedItem();
        String yearStr = yearField.getText();
        
        String modify = yearStr + "-" + monthMap.get(monthStr) + "-" + dateStr ;
        if (modify.length() != 10){
            modify = modify.substring(0, 8) + "0" + modify.charAt(8);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (isValid(modify, formatter)){
            LocalDate settedDate = LocalDate.parse(modify, formatter);
            
            return settedDate;
        }else{
            JOptionPane.showMessageDialog(getContentPane(), "Date is not valid.");
            return null;
        }        
    }
    
    private void getNewID(){
        LinkedList<String> allIdList = new LinkedList<>();
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT taskID FROM tasks");
            while(rs.next()){
                String text = rs.getString("taskID");
                allIdList.add(text);
            }
            
            if(allIdList.isEmpty()){
                this.lastID = "t1";
            }
            else{
                String lastId = allIdList.getLast();
                String temp = "";
                for(int i=1; i<lastId.length(); i++){
                    temp = temp + lastId.charAt(i);
                }
                int idnow = Integer.parseInt(temp);
                idnow++;
                this.lastID = "t" + String.valueOf(idnow);
            }
            
        } catch(Exception e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }
    
    private void getCurrentFlows(){
        flowList.clear();
        
        Workflow currWorkflow = null;
        for (int i = 0 ; i<workflowList.size(); i++){
            if(workflowBox.getSelectedItem().equals(workflowList.get(i).getTitle())){
                currWorkflow = workflowList.get(i);
                break;
            }
        }
        
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM flow WHERE workflowID = ? ORDER BY dayFrom ASC";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, currWorkflow.getId());
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String fID = rs.getString("id");
                String fname = rs.getString("name");
                String ftype = rs.getString("type");
                int fdayFrom = rs.getInt("dayFrom");
                int fdayTo = rs.getInt("dayTo");
                String fnotes = rs.getString("notes");
                String fcolor = rs.getString("color");
                
                Flow flow = new Flow(fID, currWorkflow.getId(), fname, ftype, fdayFrom, fdayTo, fnotes, fcolor);
                flowList.add(flow);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    
    private void OKbtnActionPerformed(){
        String dateStr = dateField.getText();
        String yearStr = yearField.getText();
        
        if (dateStr.trim().isEmpty()){
           JOptionPane.showMessageDialog(getContentPane(), "Date is still empty."); 
        }
        else if (yearStr.trim().isEmpty()){
           JOptionPane.showMessageDialog(getContentPane(), "Year is still empty."); 
        }
        else{
            getCurrentFlows();
            LocalDate datee = conditioningDate();

            for (Flow flow : flowList){
                 getNewID();
                 LocalDate dateFrom;
                 LocalDate dateTo;
                 String dateToStr = "0-null-0";
                 
                 //if one day event
                 if (flow.getTypeInput().equals("One-day event")){
                     dateFrom = datee.plusDays(flow.getDayFromInput());
                 }
                 else{
                     //if multiple day event
                     dateFrom = datee.plusDays(flow.getDayFromInput());
                     dateTo = datee.plusDays(flow.getDayToInput());
                     dateToStr = dateTo.toString();
                 }
                 Task new_task = new Task(this.lastID, flow.getNameInput(), flow.getTypeInput(), 
                         dateFrom.toString(), dateToStr, flow.getNoteInput(), flow.getColorInput(), this.userID, false);

                 try{
                    Connection con = ConnectionProvider.getCon();

                    PreparedStatement ps = con.prepareStatement("insert into tasks values(?,?,?,?,?,?,?,?,?)");
                    ps.setString(1, new_task.getId());
                    ps.setString(2, new_task.getNameInput());                   
                    ps.setString(3, new_task.getTypeInput());
                    ps.setString(4, new_task.getTimeFromInput());
                    ps.setString(5, new_task.getTimeToInput());
                    ps.setString(6, new_task.getNoteInput());
                    ps.setString(7, new_task.getColorInput());
                    ps.setString(8, new_task.getUserID());
                    ps.setBoolean(9, new_task.getCompleted());
                    ps.executeUpdate();


                }catch(Exception e){
                    JOptionPane.showMessageDialog(getContentPane(), e);
                }
             }

            JOptionPane.showMessageDialog(getContentPane(), "Workflow tasks added successfully.");
            //go back to calendarpage
             CalendarPage.open=0;
             setVisible(false);

             home.queryTask();
             home.queryCurrentTaskList();
             home.cloneablePanel.removeAll();
             home.createClonedPanels(home.currTasksList, home.currTasksList.size());
             home.renewTaskText();
             home.calendarCustom2.refreshTaskDots();
             home.calendarCustom2.currentPanel.revalidate();
             home.calendarCustom2.currentPanel.repaint();
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
   
    
    private javax.swing.JLabel chooseDatetxt;
    private javax.swing.JLabel d_day;
    private javax.swing.JTextField dateField;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JTextField yearField;
    private javax.swing.JLabel chooseWorkflowtxt;
    private javax.swing.JComboBox<String> workflowBox;
    private App.ButtonCustom OKbtn;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
