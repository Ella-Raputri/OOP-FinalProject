/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package App;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class CalendarCustom extends javax.swing.JPanel {
    //attributes
    private int month;
    private int year;
    public CalendarPanel currentPanel;
    private CalendarPage home;
    /**
     * Creates new form CalendarCustom
     */
    public CalendarCustom(CalendarPage home) {        
        initComponents();
        //set current panel as this month and year
        thisMonth();
        currentPanel = new CalendarPanel(month, year, home);
        
        this.home = home;
        slide.show(currentPanel, PanelSlide.AnimateType.TO_RIGHT);
        showMonthYear();
        myinit();
        refreshTaskDots();
    }
    
    private void myinit(){
        //behaviour for the previous arrow
        prevBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //if it is clicked, then navigate to previous month
                if (month == 1){
                    //if the month is January, go back to December and year deducted by 1
                    month = 12;
                    year--;
                }else{
                    //else, go back 1 month
                    month--;
                }
                updateCalendarPanel(PanelSlide.AnimateType.TO_RIGHT); //animate to right
            }
            @Override
            public void mouseEntered(MouseEvent e) { //when hovered
                prevBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/prev_month_hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) { //when not hovered
                prevBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/prev_month.png")));
            }
        });
        
        //behaviour for the next arrow
        nextBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //when clicked
                //if month is December, then go to January and year added by 1
                if (month == 12){
                    month = 1;
                    year++;
                }else{
                    //else, add 1 month from current
                    month++;
                }
                updateCalendarPanel(PanelSlide.AnimateType.TO_LEFT); //animate to left
            }
            @Override
            public void mouseEntered(MouseEvent e) { //when hovered
                nextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/next_month_hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) { //when not hovered
               nextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/next_month.png")));
            }
        });
    }
    
    private void updateCalendarPanel(PanelSlide.AnimateType type) {
        //create new current panel based on the month and year
        currentPanel = new CalendarPanel(month, year, home);
        //animate the panel movement based on the direction
        slide.show(currentPanel, type);
        //set the first date cell in the panel to be selected 
        currentPanel.setCell1Selected();
        showMonthYear();
        refreshTaskDots();
    }
    
    private void thisMonth(){
        //set the default month and year to this month
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        month = calendar.get(Calendar.MONTH) +1;
        year = calendar.get(Calendar.YEAR);        
    }
    
    private void showMonthYear(){
        //show the month and year in the month_year JLabel based on 
        //the month and year value
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month-1); //deducted by 1 because month starts from 0 here
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DATE, 1);
        
        //the display format in MMMM yyyy
        SimpleDateFormat date_format = new SimpleDateFormat("MMMM yyyy"); 
        month_year.setText(date_format.format(calendar.getTime()));
    }
    
    public void refreshTaskDots(){
        //get all cells in current panel
        LinkedList<CalendarCell> panelCells = currentPanel.getCells();
        
        //check for every task in the task list
        for (int i = 0; i < home.taskList.size(); i++){
            LocalDate date_from = home.convertStrDate(home.taskList.get(i).getTimeFromInput()); //get the date
            String color_str = home.taskList.get(i).getColorInput(); //get the color
            
            //one day event
            if (home.taskList.get(i).getTypeInput().equals("One-day event")){    
                for (CalendarCell cell1 : panelCells){
                    //check whether the date in the cell is the same with one in the task or not
                   LocalDate date_cell = cell1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                   if (date_from.equals(date_cell)){
                       if (cell1.hasATask()){
                           cell1.setTaskAmount(cell1.getTaskAmount() +1); //set task amount
                       }
                       cell1.setHasTasks(true, color_str); //set the dot color
                    } 
                }                
            //multiple day event
            }else{
                //get the last date
                LocalDate date_to = home.convertStrDate(home.taskList.get(i).getTimeToInput());
                for (CalendarCell cell1 : panelCells){
                    //get cell date
                    LocalDate date_cell = cell1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    
                    //see whether the cell date is in the range of the multiple day ebvent
                   if (date_cell.isAfter(date_from.minusDays(1)) && date_cell.isBefore(date_to.plusDays(1))){
                        if (cell1.hasATask()){
                           cell1.setTaskAmount(cell1.getTaskAmount() +1); //set task amount
                        }
                        cell1.setHasTasks(true, color_str); //set dot color
                   } 
                }
            }
        }      
    }
    
    public JPanel getTaskPanel(){
        return taskPanel;
    }
    
    public void addTaskBtnActionPerformed(){
        //if there is no window open
        if (CalendarPage.open == 0){
            //open the add new task window
           CalendarPage.open = 1; 
           new AddNewTask(home.userID, home).setVisible(true);
        }else{
            //show message
           JOptionPane.showMessageDialog(home.getContentPane(), "One window is already open.");
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

        slide = new App.PanelSlide();
        taskPanel = new javax.swing.JPanel();
        tasktxt = new javax.swing.JLabel();
        addBtn = new App.ButtonCustom();
        line = new javax.swing.JLabel();
        prevBtn = new javax.swing.JLabel();
        nextBtn = new javax.swing.JLabel();
        month_year = new javax.swing.JLabel();

        setBackground(new java.awt.Color(222, 247, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 141, 189)));
        setPreferredSize(new java.awt.Dimension(1060, 535));
        setLayout(null);

        slide.setBackground(new java.awt.Color(255, 255, 255));
        slide.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 141, 189)));
        slide.setPreferredSize(new java.awt.Dimension(784, 467));
        add(slide);
        slide.setBounds(0, 68, 780, 467);

        taskPanel.setBackground(new java.awt.Color(31, 139, 217));
        taskPanel.setPreferredSize(new java.awt.Dimension(280, 0));
        taskPanel.setLayout(null);

        tasktxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 32)); // NOI18N
        tasktxt.setForeground(new java.awt.Color(255, 255, 255));
        tasktxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tasktxt.setText("Tasks");
        tasktxt.setToolTipText("");
        taskPanel.add(tasktxt);
        tasktxt.setBounds(90, 20, 100, 39);

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
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        taskPanel.add(addBtn);
        addBtn.setBounds(120, 470, 133, 40);

        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/line.png"))); // NOI18N
        taskPanel.add(line);
        line.setBounds(30, 50, 232, 43);

        add(taskPanel);
        taskPanel.setBounds(780, -5, 280, 540);

        prevBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/prev_month.png"))); // NOI18N
        prevBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(prevBtn);
        prevBtn.setBounds(48, 26, 17, 21);

        nextBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/next_month.png"))); // NOI18N
        nextBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(nextBtn);
        nextBtn.setBounds(715, 26, 17, 21);

        month_year.setFont(new java.awt.Font("Montserrat SemiBold", 0, 28)); // NOI18N
        month_year.setForeground(new java.awt.Color(31, 139, 217));
        month_year.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        month_year.setText("[month year]");
        month_year.setToolTipText("");
        add(month_year);
        month_year.setBounds(140, 15, 500, 35);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        addTaskBtnActionPerformed();
    }//GEN-LAST:event_addBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private App.ButtonCustom addBtn;
    private javax.swing.JLabel line;
    private javax.swing.JLabel month_year;
    private javax.swing.JLabel nextBtn;
    private javax.swing.JLabel prevBtn;
    private App.PanelSlide slide;
    private javax.swing.JPanel taskPanel;
    private javax.swing.JLabel tasktxt;
    // End of variables declaration//GEN-END:variables
}
