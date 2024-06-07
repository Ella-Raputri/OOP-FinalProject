/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Asus
 */
public class HomePage extends javax.swing.JFrame {
    private String userID = "u1";
    private HashMap<String, Integer> completionRate = new HashMap<>();
    /**
     * Creates new form HomePage
     */
    public HomePage() {
        setResizable(false);
        setTitle("Home Page");
        initComponents();
        myinit();
    }
    
    public HomePage(String ID){
        setResizable(false);
        setTitle("Home Page");
        this.userID = ID;
        initComponents();
        myinit();
    }
    
    //handle hover button in the navbar
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
        });
        homeBtnTxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new HomePage(userID).setVisible(true);
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
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new CalendarPage(userID).setVisible(true);
            }
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
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new CalendarPage(userID).setVisible(true);
            }
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
        
        new_window_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new AranaraMenu().setVisible(true);
            }            
            @Override
            public void mouseEntered(MouseEvent e) {
                new_window_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/open_new_window_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                new_window_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/open_new_window.png")));
            }
        });
    }
    
    
    private void myinit(){
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM user WHERE userID = ?";
             
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, this.userID);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String user_name = rs.getString("username");
                    welcometxt.setText("Welcome, Nara " +user_name +"!");
                    
                    String default_aranara = rs.getString("default_aranara");
                    String path = "/App/img/"+ default_aranara + "_home.png";                    
                    aranara_pict.setIcon(new javax.swing.ImageIcon(getClass().getResource(path)));
                } 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        initHover();
        showBarChart();
        setAnalysisTxt();
        setTodayTasks();
    }
    
    private boolean isNewWeek(LocalDate referenceDate, LocalDate currentDate) {
        // Get the week fields for the default locale
        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        // Get the week number of the reference date and current date
        int referenceWeek = referenceDate.get(weekFields.weekOfWeekBasedYear());
        int currentWeek = currentDate.get(weekFields.weekOfWeekBasedYear());

        // Get the year of the reference date and current date
        int referenceYear = referenceDate.get(weekFields.weekBasedYear());
        int currentYear = currentDate.get(weekFields.weekBasedYear());

        // Check if the year and week number are different
        return currentYear > referenceYear || (currentYear == referenceYear && currentWeek > referenceWeek);
    }
    
    public LocalDate convertStrDate(String timeStr){
        String modify = timeStr;
        if (timeStr.length() != 10){
            modify = timeStr.substring(0, 8) + "0" + timeStr.charAt(8);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(modify, formatter);
        return date;
    }
    
    private void resetTaskCompletions(boolean isReset, LocalDate todayDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayStr = todayDate.format(formatter);
        
        try{
            Connection con = ConnectionProvider.getCon();
            
            if (isReset){
                String query = "UPDATE user SET Mon = ?, Tue = ?, Wed = ?, Thu = ?, Fri = ?. Sat = ?, Sun = ?, last_online = ? WHERE userID = ?";
 
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, 0);
                ps.setInt(2, 0);
                ps.setInt(3, 0);
                ps.setInt(4, 0);
                ps.setInt(5, 0);
                ps.setInt(6, 0);
                ps.setInt(7, 0);
                ps.setString(8, todayStr);
                ps.setString(9, userID);
                ps.executeUpdate();
                
            }else{
                String query = "UPDATE user SET last_online = ? WHERE userID = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, todayStr);
                ps.setString(2, userID);
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    
    private void queryTaskCompletions(){
        
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM task_completion WHERE userID = ?";
             
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, this.userID);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    //reset the graph and databaseif it is the new week
                    String last = rs.getString("last_login");
                    LocalDate today = LocalDate.now();
                    LocalDate last_login = convertStrDate(last);

                    if (isNewWeek(last_login, today)){
                        resetTaskCompletions(true, today);
                    }else{
                        resetTaskCompletions(false, today);
                    }
                    
                    //get the amount of tasks 
                    int amtMon = rs.getInt("Mon");
                    int amtTue = rs.getInt("Tue");
                    int amtWed = rs.getInt("Wed");
                    int amtThu = rs.getInt("Thu");
                    int amtFri = rs.getInt("Fri");
                    int amtSat = rs.getInt("Sat");
                    int amtSun = rs.getInt("Sun");
                    
                    completionRate.put("Mon", amtMon);
                    completionRate.put("Tue", amtTue);
                    completionRate.put("Wed", amtWed);
                    completionRate.put("Thu", amtThu);
                    completionRate.put("Fri", amtFri);
                    completionRate.put("Sat", amtSat);
                    completionRate.put("Sun", amtSun);
                }                 
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void setAnalysisTxt(){
        String day = LocalDate.now().getDayOfWeek().name();
        String day_name = day.charAt(0) + day.substring(1,3).toLowerCase();  
        int todayCompleted = completionRate.get(day_name);
        
        if (todayCompleted == 0){
            analyze_task_txt.setText("You haven't done any task today, Nara.");
        }else if (todayCompleted ==1){
            analyze_task_txt.setText("You have completed " + todayCompleted + " task today, Nara.");
        }
        else{
            analyze_task_txt.setText("You have completed " + todayCompleted + " tasks today, Nara.");
        }
    }
    
    private void setTodayTasks(){
         try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM tasks WHERE userID = ? ORDER BY completed ASC";
             
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, this.userID);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String type = rs.getString("type");
                    String dateFrom = rs.getString("timeFrom");
                    String dateTo = rs.getString("timeTo");
                    
                    nearest_task.setText(name);
                    if (type.equals("One-day event")){
                        nearest_time.setText(convertDate(dateFrom));
                    }else{
                        String time = convertDate(dateFrom) + " to " + convertDate(dateTo);
                        nearest_time.setText(time);
                    }
                }                 
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //2024-06-2
    private String convertDate(String strDate){
        String day = strDate.substring(8, strDate.length());
        String year = strDate.substring(0,4);
        String month = strDate.substring(5,7);
        
        switch (month){
            case "01":
                month = "Jan";
                break;
            case "02":
                month = "Feb";
                break;
            case "03":
                month = "Mar";
                break;
            case "04":
                month = "Apr";
                break;
            case "05":
                month = "May";
                break;
            case "06":
                month = "Jun";
                break;
            case "07":
                month = "Jul";
                break;
            case "08":
                month = "Aug";
                break;
            case "09":
                month = "Sep";
                break;
            case "10":
                month = "Oct";
                break;
            case "11":
                month = "Nov";
                break;
            case "12":
                month = "Des";
                break;
        }
        
        return day + " " + month + " " + year;
    }
    
    private void showBarChart(){
        queryTaskCompletions();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(completionRate.get("Mon"), "Amount", "Mon");
        dataset.setValue(completionRate.get("Tue"), "Amount", "Tue");
        dataset.setValue(completionRate.get("Wed"), "Amount", "Wed");
        dataset.setValue(completionRate.get("Thu"), "Amount", "Thu");
        dataset.setValue(completionRate.get("Fri"), "Amount", "Fri");
        dataset.setValue(completionRate.get("Sat"), "Amount", "Sat");        
        dataset.setValue(completionRate.get("Sun"), "Amount", "Sun");
        
        JFreeChart chart = ChartFactory.createBarChart("Task Completion","Day","Amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color color = new Color(31, 139, 217);
        renderer.setSeriesPaint(0, color);
        renderer.setBarPainter(new StandardBarPainter()); // Disable gradient effect
        renderer.setMaximumBarWidth(0.08);
        
        for(int i=1; i<= completionRate.size(); i++){ 
            for(String key: completionRate.keySet()){
                if (completionRate.get(key) == 0){
                    NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
                    rangeAxis.setTickUnit(new NumberTickUnit(1));
                    rangeAxis.setRange(0.0, 5.0);
                }
            }            
        }
        
        ChartPanel barChart = new ChartPanel(chart);
        barChart.setPreferredSize(new Dimension(1000, 400));
        barChartPanel.removeAll();
        barChartPanel.add(barChart, BorderLayout.CENTER);
        barChartPanel.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewMoreBtn = new App.ButtonCustom();
        new_window_btn = new javax.swing.JLabel();
        upcoming_tasks = new javax.swing.JLabel();
        nearest_time = new javax.swing.JLabel();
        nearest_task = new javax.swing.JLabel();
        analyze_task_txt = new javax.swing.JLabel();
        welcometxt = new javax.swing.JLabel();
        your_daily_txt1 = new javax.swing.JLabel();
        your_daily_quote = new javax.swing.JLabel();
        quoteby_txt = new javax.swing.JLabel();
        quotetxt = new javax.swing.JLabel();
        aranara_pict = new javax.swing.JLabel();
        homeBtn = new javax.swing.JLabel();
        homeBtnTxt = new javax.swing.JLabel();
        addWorkflowBtn = new javax.swing.JLabel();
        addWorkflowBtnTxt = new javax.swing.JLabel();
        addWorkflowBtnTxt1 = new javax.swing.JLabel();
        calendarBtn = new javax.swing.JLabel();
        calendarBtnTxt = new javax.swing.JLabel();
        aranaraBtn = new javax.swing.JLabel();
        aranaraBtnTxt = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JLabel();
        logoutBtnTxt = new javax.swing.JLabel();
        barChartPanel = new javax.swing.JPanel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewMoreBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewMoreBtn.setText("View More >");
        viewMoreBtn.setBorderColor(new java.awt.Color(31, 139, 217));
        viewMoreBtn.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
        viewMoreBtn.setBorderColorOver(new java.awt.Color(125, 201, 255));
        viewMoreBtn.setColor(new java.awt.Color(31, 139, 217));
        viewMoreBtn.setColor2(java.awt.Color.white);
        viewMoreBtn.setColorClick(new java.awt.Color(125, 201, 255));
        viewMoreBtn.setColorClick2(java.awt.Color.white);
        viewMoreBtn.setColorOver(new java.awt.Color(125, 201, 255));
        viewMoreBtn.setColorOver2(java.awt.Color.white);
        viewMoreBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        viewMoreBtn.setRadius(50);
        viewMoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMoreBtnActionPerformed(evt);
            }
        });
        getContentPane().add(viewMoreBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 591, 167, 44));

        new_window_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/open_new_window.png"))); // NOI18N
        getContentPane().add(new_window_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1162, 357, -1, -1));

        upcoming_tasks.setFont(new java.awt.Font("Montserrat SemiBold", 0, 28)); // NOI18N
        upcoming_tasks.setText("Upcoming Tasks");
        getContentPane().add(upcoming_tasks, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 459, -1, -1));

        nearest_time.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        nearest_time.setForeground(new java.awt.Color(155, 154, 154));
        getContentPane().add(nearest_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 550, -1, -1));

        nearest_task.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        nearest_task.setText("There is no upcoming tasks.");
        nearest_task.setToolTipText("");
        getContentPane().add(nearest_task, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 508, -1, -1));

        analyze_task_txt.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        getContentPane().add(analyze_task_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 369, 590, -1));

        welcometxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 42)); // NOI18N
        welcometxt.setForeground(new java.awt.Color(0, 141, 189));
        welcometxt.setText("Welcome, Nara ");
        getContentPane().add(welcometxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 17, -1, -1));

        your_daily_txt1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        your_daily_txt1.setText("This is your daily tasks completion chart.");
        getContentPane().add(your_daily_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 80, -1, -1));

        your_daily_quote.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        your_daily_quote.setForeground(new java.awt.Color(85, 155, 0));
        your_daily_quote.setText("Your Daily Quote");
        getContentPane().add(your_daily_quote, new org.netbeans.lib.awtextra.AbsoluteConstraints(935, 458, -1, -1));

        quoteby_txt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        quoteby_txt.setForeground(new java.awt.Color(85, 155, 0));
        quoteby_txt.setText("~[name]");
        getContentPane().add(quoteby_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1106, 586, -1, -1));

        quotetxt.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        quotetxt.setForeground(new java.awt.Color(58, 58, 58));
        quotetxt.setText("[quote]");
        getContentPane().add(quotetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(909, 502, -1, -1));

        aranara_pict.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/arama_home.png"))); // NOI18N
        getContentPane().add(aranara_pict, new org.netbeans.lib.awtextra.AbsoluteConstraints(891, 71, -1, -1));

        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/home_active.png"))); // NOI18N
        getContentPane().add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 55, -1, -1));

        homeBtnTxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        homeBtnTxt.setForeground(new java.awt.Color(0, 141, 189));
        homeBtnTxt.setText("Home");
        getContentPane().add(homeBtnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        addWorkflowBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/add_workflow.png"))); // NOI18N
        getContentPane().add(addWorkflowBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 155, -1, -1));

        addWorkflowBtnTxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        addWorkflowBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        addWorkflowBtnTxt.setText("workflow");
        getContentPane().add(addWorkflowBtnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 224, -1, -1));

        addWorkflowBtnTxt1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        addWorkflowBtnTxt1.setForeground(new java.awt.Color(255, 255, 255));
        addWorkflowBtnTxt1.setText("Add");
        getContentPane().add(addWorkflowBtnTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 206, -1, -1));

        calendarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/calendar.png"))); // NOI18N
        getContentPane().add(calendarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 284, -1, -1));

        calendarBtnTxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        calendarBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
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

        barChartPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(barChartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 570, 190));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/homepage.png"))); // NOI18N
        bg.setText("jLabel1");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void viewMoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMoreBtnActionPerformed
        setVisible(false);
        new CalendarPage().setVisible(true);
    }//GEN-LAST:event_viewMoreBtnActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addWorkflowBtn;
    private javax.swing.JLabel addWorkflowBtnTxt;
    private javax.swing.JLabel addWorkflowBtnTxt1;
    private javax.swing.JLabel analyze_task_txt;
    private javax.swing.JLabel aranaraBtn;
    private javax.swing.JLabel aranaraBtnTxt;
    private javax.swing.JLabel aranara_pict;
    private javax.swing.JPanel barChartPanel;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel calendarBtn;
    private javax.swing.JLabel calendarBtnTxt;
    private javax.swing.JLabel homeBtn;
    private javax.swing.JLabel homeBtnTxt;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JLabel logoutBtnTxt;
    private javax.swing.JLabel nearest_task;
    private javax.swing.JLabel nearest_time;
    private javax.swing.JLabel new_window_btn;
    private javax.swing.JLabel quoteby_txt;
    private javax.swing.JLabel quotetxt;
    private javax.swing.JLabel upcoming_tasks;
    private App.ButtonCustom viewMoreBtn;
    private javax.swing.JLabel welcometxt;
    private javax.swing.JLabel your_daily_quote;
    private javax.swing.JLabel your_daily_txt1;
    // End of variables declaration//GEN-END:variables
}
