/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package App;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Asus
 */
public class CalendarPanel extends javax.swing.JLayeredPane {
    //date attributes
     private int month;
     private int year; 
     
     //display attributes
     public String color ;
     private CalendarCell current_cell = null;
     private LinkedList<CalendarCell> cells = new LinkedList<>();
     private CalendarPage home;
    /**
     * Creates new form CalendarPanel
     */
    public CalendarPanel(int month, int year, CalendarPage home) {
        this.home = home;
        initComponents();
        this.month = month;
        this.year = year;
        init();
    }
    
    private void init(){
        //set the day name as title
        mon.asTitle();
        tue.asTitle();
        wed.asTitle();
        thu.asTitle();
        fri.asTitle();
        sat.asTitle();
        sun.asTitle();
        setDate();
    }
    
    private void setDate(){
        //set all date in the cells in the panel
        //get the calendar and set the date, year, and month to the first day
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1); //month is zero based on Calendar
        calendar.set(Calendar.DATE, 1);
        
        //calculate the starting day of the first day of the week
        int start_day = calendar.get(Calendar.DAY_OF_WEEK) -1;
        calendar.add(Calendar.DATE, -start_day); //move calendar back to the start of the week
        CalendarToday today = getToday(); //get today date
        
        for (Component comp : getComponents()){
            CalendarCell cell = (CalendarCell) comp;
            if (!cell.isTitle()){ //skip cells that are title
                //add the cell to LinkedList
                cells.add(cell);
                //set the text of the cell to the date
                cell.setText(calendar.get(Calendar.DATE) + "");
                cell.setDate(calendar.getTime());
                //color and format the text color
                cell.currentMonth(calendar.get(Calendar.MONTH) == month -1, 
                        calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
                
                //if the cell is clicked
                cell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //if it is not the current cell
                        if (current_cell != cell) {
                            if (current_cell != null) {
                                //if the current cell is not null, set the selected cell to be false
                                current_cell.setAsSelected(false);                                
                                home.refresh(); 
                            }
                            current_cell = cell; //set cell as current cell
                            home.refresh();
                        }
                    }
                });
                
                //if the date is today's date
                if (today.isToday(new CalendarToday(calendar.get(Calendar.DATE), 
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)))){
                    //set as today and default selected to be true
                    cell.setAsToday();
                    cell.setAsSelected(true);
                    cell.repaint();
                    current_cell = cell;
                }
                //move to the next date
                calendar.add(Calendar.DATE, 1);
            }
        }
    }
    
    //set color
    public void setColor(String color){
        this.color = color;
    }
    
    //set home
    public void setHome(CalendarPage home1){
        this.home = home1;
    }
    
    //get today date
    private CalendarToday getToday(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return new CalendarToday(cal.get(Calendar.DATE), cal.get(Calendar.MONTH), cal.get(Calendar.YEAR));
    }
    
    //get current cell
    public CalendarCell getCurrentCell(){
        return current_cell;
    }
    //get all cells which is not the title
    public LinkedList<CalendarCell> getCells(){
        return cells;
    }
    //set the first cell to be selected when navigating to other months
    public void setCell1Selected(){
        current_cell = cell1;
        current_cell.setAsSelected(true);
        current_cell.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sun = new App.CalendarCell();
        mon = new App.CalendarCell();
        tue = new App.CalendarCell();
        wed = new App.CalendarCell();
        thu = new App.CalendarCell();
        fri = new App.CalendarCell();
        sat = new App.CalendarCell();
        cell1 = new App.CalendarCell();
        cell2 = new App.CalendarCell();
        cell3 = new App.CalendarCell();
        cell4 = new App.CalendarCell();
        cell5 = new App.CalendarCell();
        cell6 = new App.CalendarCell();
        cell7 = new App.CalendarCell();
        cell8 = new App.CalendarCell();
        cell9 = new App.CalendarCell();
        cell10 = new App.CalendarCell();
        cell11 = new App.CalendarCell();
        cell12 = new App.CalendarCell();
        cell13 = new App.CalendarCell();
        cell14 = new App.CalendarCell();
        cell15 = new App.CalendarCell();
        cell16 = new App.CalendarCell();
        cell17 = new App.CalendarCell();
        cell18 = new App.CalendarCell();
        cell19 = new App.CalendarCell();
        cell20 = new App.CalendarCell();
        cell21 = new App.CalendarCell();
        cell22 = new App.CalendarCell();
        cell23 = new App.CalendarCell();
        cell24 = new App.CalendarCell();
        cell25 = new App.CalendarCell();
        cell26 = new App.CalendarCell();
        cell27 = new App.CalendarCell();
        cell28 = new App.CalendarCell();
        cell29 = new App.CalendarCell();
        cell30 = new App.CalendarCell();
        cell31 = new App.CalendarCell();
        cell32 = new App.CalendarCell();
        cell33 = new App.CalendarCell();
        cell34 = new App.CalendarCell();
        cell35 = new App.CalendarCell();
        cell36 = new App.CalendarCell();
        cell37 = new App.CalendarCell();
        cell38 = new App.CalendarCell();
        cell39 = new App.CalendarCell();
        cell40 = new App.CalendarCell();
        cell41 = new App.CalendarCell();
        cell42 = new App.CalendarCell();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(784, 467));
        setLayout(new java.awt.GridLayout(7, 7));

        sun.setBackground(new java.awt.Color(255, 255, 255));
        sun.setForeground(new java.awt.Color(234, 111, 111));
        sun.setText("Sun");
        sun.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        add(sun);

        mon.setBackground(new java.awt.Color(255, 255, 255));
        mon.setForeground(new java.awt.Color(0, 141, 189));
        mon.setText("Mon");
        mon.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        add(mon);

        tue.setBackground(new java.awt.Color(255, 255, 255));
        tue.setForeground(new java.awt.Color(0, 141, 189));
        tue.setText("Tue");
        tue.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        add(tue);

        wed.setBackground(new java.awt.Color(255, 255, 255));
        wed.setForeground(new java.awt.Color(0, 141, 189));
        wed.setText("Wed");
        wed.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        add(wed);

        thu.setBackground(new java.awt.Color(255, 255, 255));
        thu.setForeground(new java.awt.Color(0, 141, 189));
        thu.setText("Thu");
        thu.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        add(thu);

        fri.setBackground(new java.awt.Color(255, 255, 255));
        fri.setForeground(new java.awt.Color(0, 141, 189));
        fri.setText("Fri");
        fri.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        add(fri);

        sat.setBackground(new java.awt.Color(255, 255, 255));
        sat.setForeground(new java.awt.Color(0, 141, 189));
        sat.setText("Sat");
        sat.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        add(sat);

        cell1.setBackground(new java.awt.Color(255, 255, 255));
        cell1.setForeground(new java.awt.Color(234, 111, 111));
        cell1.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell1);

        cell2.setBackground(new java.awt.Color(255, 255, 255));
        cell2.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell2);

        cell3.setBackground(new java.awt.Color(255, 255, 255));
        cell3.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell3);

        cell4.setBackground(new java.awt.Color(255, 255, 255));
        cell4.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell4);

        cell5.setBackground(new java.awt.Color(255, 255, 255));
        cell5.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell5);

        cell6.setBackground(new java.awt.Color(255, 255, 255));
        cell6.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell6);

        cell7.setBackground(new java.awt.Color(255, 255, 255));
        cell7.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell7);

        cell8.setBackground(new java.awt.Color(255, 255, 255));
        cell8.setForeground(new java.awt.Color(234, 111, 111));
        cell8.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell8);

        cell9.setBackground(new java.awt.Color(255, 255, 255));
        cell9.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell9);

        cell10.setBackground(new java.awt.Color(255, 255, 255));
        cell10.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell10);

        cell11.setBackground(new java.awt.Color(255, 255, 255));
        cell11.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell11);

        cell12.setBackground(new java.awt.Color(255, 255, 255));
        cell12.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell12);

        cell13.setBackground(new java.awt.Color(255, 255, 255));
        cell13.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell13);

        cell14.setBackground(new java.awt.Color(255, 255, 255));
        cell14.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell14);

        cell15.setBackground(new java.awt.Color(255, 255, 255));
        cell15.setForeground(new java.awt.Color(234, 111, 111));
        cell15.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell15);

        cell16.setBackground(new java.awt.Color(255, 255, 255));
        cell16.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell16);

        cell17.setBackground(new java.awt.Color(255, 255, 255));
        cell17.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell17);

        cell18.setBackground(new java.awt.Color(255, 255, 255));
        cell18.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell18);

        cell19.setBackground(new java.awt.Color(255, 255, 255));
        cell19.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell19);

        cell20.setBackground(new java.awt.Color(255, 255, 255));
        cell20.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell20);

        cell21.setBackground(new java.awt.Color(255, 255, 255));
        cell21.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell21);

        cell22.setBackground(new java.awt.Color(255, 255, 255));
        cell22.setForeground(new java.awt.Color(234, 111, 111));
        cell22.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell22);

        cell23.setBackground(new java.awt.Color(255, 255, 255));
        cell23.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell23);

        cell24.setBackground(new java.awt.Color(255, 255, 255));
        cell24.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell24);

        cell25.setBackground(new java.awt.Color(255, 255, 255));
        cell25.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell25);

        cell26.setBackground(new java.awt.Color(255, 255, 255));
        cell26.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell26);

        cell27.setBackground(new java.awt.Color(255, 255, 255));
        cell27.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell27);

        cell28.setBackground(new java.awt.Color(255, 255, 255));
        cell28.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell28);

        cell29.setBackground(new java.awt.Color(255, 255, 255));
        cell29.setForeground(new java.awt.Color(234, 111, 111));
        cell29.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell29);

        cell30.setBackground(new java.awt.Color(255, 255, 255));
        cell30.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell30);

        cell31.setBackground(new java.awt.Color(255, 255, 255));
        cell31.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell31);

        cell32.setBackground(new java.awt.Color(255, 255, 255));
        cell32.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell32);

        cell33.setBackground(new java.awt.Color(255, 255, 255));
        cell33.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell33);

        cell34.setBackground(new java.awt.Color(255, 255, 255));
        cell34.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell34);

        cell35.setBackground(new java.awt.Color(255, 255, 255));
        cell35.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell35);

        cell36.setBackground(new java.awt.Color(255, 255, 255));
        cell36.setForeground(new java.awt.Color(234, 111, 111));
        cell36.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell36);

        cell37.setBackground(new java.awt.Color(255, 255, 255));
        cell37.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell37);

        cell38.setBackground(new java.awt.Color(255, 255, 255));
        cell38.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell38);

        cell39.setBackground(new java.awt.Color(255, 255, 255));
        cell39.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N

        cell40.setBackground(new java.awt.Color(255, 255, 255));
        cell40.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell40);

        cell41.setBackground(new java.awt.Color(255, 255, 255));
        cell41.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell41);

        cell42.setBackground(new java.awt.Color(255, 255, 255));
        cell42.setFont(new java.awt.Font("Montserrat", 0, 22)); // NOI18N
        add(cell42);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private App.CalendarCell cell1;
    private App.CalendarCell cell10;
    private App.CalendarCell cell11;
    private App.CalendarCell cell12;
    private App.CalendarCell cell13;
    private App.CalendarCell cell14;
    private App.CalendarCell cell15;
    private App.CalendarCell cell16;
    private App.CalendarCell cell17;
    private App.CalendarCell cell18;
    private App.CalendarCell cell19;
    private App.CalendarCell cell2;
    private App.CalendarCell cell20;
    private App.CalendarCell cell21;
    private App.CalendarCell cell22;
    private App.CalendarCell cell23;
    private App.CalendarCell cell24;
    private App.CalendarCell cell25;
    private App.CalendarCell cell26;
    private App.CalendarCell cell27;
    private App.CalendarCell cell28;
    private App.CalendarCell cell29;
    private App.CalendarCell cell3;
    private App.CalendarCell cell30;
    private App.CalendarCell cell31;
    private App.CalendarCell cell32;
    private App.CalendarCell cell33;
    private App.CalendarCell cell34;
    private App.CalendarCell cell35;
    private App.CalendarCell cell36;
    private App.CalendarCell cell37;
    private App.CalendarCell cell38;
    private App.CalendarCell cell39;
    private App.CalendarCell cell4;
    private App.CalendarCell cell40;
    private App.CalendarCell cell41;
    private App.CalendarCell cell42;
    private App.CalendarCell cell5;
    private App.CalendarCell cell6;
    private App.CalendarCell cell7;
    private App.CalendarCell cell8;
    private App.CalendarCell cell9;
    private App.CalendarCell fri;
    private App.CalendarCell mon;
    private App.CalendarCell sat;
    private App.CalendarCell sun;
    private App.CalendarCell thu;
    private App.CalendarCell tue;
    private App.CalendarCell wed;
    // End of variables declaration//GEN-END:variables
}
