/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import DatabaseConnection.ConnectionProvider;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Asus
 */
public class AddWorkflowMenu extends javax.swing.JFrame {
    private String userID = "u1";
    private JPanel contentPane;
    private JPanel cloneablePanel;
    private JScrollPane scrollPane;
    public static int open = 0;
    /**
     * Creates new form AddWorkflowPage
     */
    public AddWorkflowMenu() {
        setResizable(false);
        setTitle("Add Workflow Page");
        myinit();
        initComponents();
    }
    
    public AddWorkflowMenu(String id) {
        setResizable(false);
        setTitle("Add Workflow Page");
        this.userID = id;
        myinit();
        initComponents();
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
        
        search_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                search_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hover_search.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                search_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/search.png")));
            }
        });
        
    }

    
    private void initDesign(){
        homeBtn = new javax.swing.JLabel();
        homeBtnTxt = new javax.swing.JLabel();
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
        search_icon = new javax.swing.JLabel();
        search_field = new RoundJTextField(21, "Find workflow");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/home.png"))); // NOI18N
        getContentPane().add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 55, -1, -1));

        homeBtnTxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        homeBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        homeBtnTxt.setText("Home");
        getContentPane().add(homeBtnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        addWorkflowBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/add_workflow_active.png"))); // NOI18N
        getContentPane().add(addWorkflowBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 155, -1, -1));

        addWorkflowBtnTxt1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        addWorkflowBtnTxt1.setForeground(new java.awt.Color(0, 141, 189));
        addWorkflowBtnTxt1.setText("Add");
        getContentPane().add(addWorkflowBtnTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 206, -1, -1));

        addWorkflowBtnTxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        addWorkflowBtnTxt.setForeground(new java.awt.Color(0, 141, 189));
        addWorkflowBtnTxt.setText("workflow");
        getContentPane().add(addWorkflowBtnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 224, -1, -1));

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

        titletxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 48)); // NOI18N
        titletxt.setForeground(new java.awt.Color(0, 141, 189));
        titletxt.setText("Add a New Workflow");
        getContentPane().add(titletxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 27, -1, -1));

        search_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/search.png"))); // NOI18N
        getContentPane().add(search_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, -1, -1));

        search_field.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        search_field.setForeground(new java.awt.Color(155, 154, 154));
        search_field.setText("Find workflow");
        search_field.setPreferredSize(new java.awt.Dimension(456, 46));        
        search_field.setBorder(new EmptyBorder(new Insets(5, 20, 5, 10)));
        getContentPane().add(search_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 110, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }
    
    private void myinit(){
        int totalElement = 0;
        LinkedList<Workflow> workflowList = new LinkedList<>();
        
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM workflow WHERE userID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString("workflowID");
                String title = rs.getString("title");
                int checkpoint = rs.getInt("checkpoint");
                String userid = rs.getString("userID");
                Workflow workflow = new Workflow(title, checkpoint, id, userid);
                workflowList.add(workflow);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
        totalElement = workflowList.size();
        
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
        scrollPane.setBounds(180, 180, 1054, 455); // Set bounds for the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane);

        // Create the cloneable panel
        cloneablePanel = new JPanel(); // The initial panel inside scroll pane
        cloneablePanel.setLayout(null); // Use absolute layout
        cloneablePanel.setPreferredSize(new Dimension(400, 200)); // Set initial size
        cloneablePanel.setBounds(180, 200, 1200, 1500); // Set bounds for the initial panel
        cloneablePanel.setBackground(Color.white);
        scrollPane.setViewportView(cloneablePanel); // Set this panel as viewport's view
        
        
        
        int row=0, column=0;
        for(int i=0; i<totalElement;i++){
            String id = workflowList.get(i).getId();
            String title = workflowList.get(i).getTitle();
            int checkpoint = workflowList.get(i).getCheckpoint();
            
            // Create a new cloned panel
            // Cloneable Panel
            CloneablePanelWorkflow clonedPanel = new CloneablePanelWorkflow(20, Color.white, 2 ,id, title, checkpoint);
            // Set your custom width and height for the cloned panel
            int panelWidth = 292;
            int panelHeight = 278;
            
            
            // Calculate the row and column indices
            if (i == 0 || i == 1){
                column = (i % 3) +1;
                row = 0;
            }else{
              column = (i-2) % 3;  
              row = (i+1)/3;
            }

            // Calculate the x and y positions based on row and column indices
            int x = 10 + column * (panelWidth + 50);
            int y = 10 + row * (panelHeight + 50);

            // Set the bounds for the cloned panel with your custom size
            clonedPanel.setBounds(x, y, panelWidth, panelHeight);
            clonedPanel.setBackground(Color.white);
            
            // Add the cloned panel to the initial panel
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
        
        createAddPanel();
        
        ImageIcon bgImage = new ImageIcon("src/App/img/background_adminhome.png");
        contentPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
        
        initDesign(); //initialize all the design components
        initHover(); //initialize the hovering method for buttons
        
        //set the addworkflowbutton to be focused when opening this page 
        //so that the textfield is not focused first
        SwingUtilities.invokeLater(() -> addWorkflowBtn.requestFocusInWindow());
        
    }
    
    private void createAddPanel(){
        //intialize the add panel, 
        JPanel add_panel = new JPanel();
        //add panel width, height, x, and y
        int panelWidth = 292;
        int panelHeight = 278;
        int add_panel_x = 10;
        int add_panel_y = 10;
        add_panel.setBounds(add_panel_x, add_panel_y, panelWidth, panelHeight);
        add_panel.setLayout(null);
        
        //add_panel color and border
        add_panel.setBackground(new Color(246, 252, 254));
        float[] dashPattern = {10, 10}; // 10 pixels on, 10 pixels off
        BasicStroke dashedStroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashPattern, 0);
        add_panel.setBorder(BorderFactory.createStrokeBorder(dashedStroke, new Color(31,139,217)));
        
        //labels inside the add panel
        JLabel createtxt = new JLabel();
        createtxt.setFont(new java.awt.Font("Montserrat Medium", 0, 28)); // NOI18N
        createtxt.setForeground(new java.awt.Color(167, 204, 231));
        createtxt.setText("Create New");
        createtxt.setBounds(57, 172, 235, 34);
        add_panel.add(createtxt);
        
        JLabel add_icon = new JLabel();
        add_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/add_workflow_icon.png"))); 
        add_icon.setBounds(102, 77, 79, 78);
        add_panel.add(add_icon);
        
        //add_panel get selected
        add_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddWorkflowMenu.open = 1;
                new CreateNewWorkflow(userID).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                createtxt.setForeground(new java.awt.Color(31, 139, 217));
                add_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/add_workflow_icon_hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                createtxt.setForeground(new java.awt.Color(167, 204, 231));
                add_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/add_workflow_icon.png")));
            }
        });
        
        //add the add panel to the cloneable panel
        cloneablePanel.add(add_panel);
        scrollPane.revalidate();
        scrollPane.repaint();
        // Scroll to show the new panel
        scrollPane.getVerticalScrollBar().setValue(0);
    }
    
    public void goToEdit(String workflowID){
        setVisible(false);
        new EditWorkflow(workflowID, userID).setVisible(true);
    }
    
    public void reload(){
        setVisible(false);
        new AddWorkflowMenu().setVisible(true);
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
            java.util.logging.Logger.getLogger(AddWorkflowMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddWorkflowMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddWorkflowMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddWorkflowMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddWorkflowMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel addWorkflowBtn;
    private javax.swing.JLabel addWorkflowBtnTxt;
    private javax.swing.JLabel addWorkflowBtnTxt1;
    private javax.swing.JLabel aranaraBtn;
    private javax.swing.JLabel aranaraBtnTxt;
    private javax.swing.JLabel calendarBtn;
    private javax.swing.JLabel calendarBtnTxt;
    private javax.swing.JLabel homeBtn;
    private javax.swing.JLabel homeBtnTxt;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JLabel logoutBtnTxt;
    private RoundJTextField search_field;
    private javax.swing.JLabel search_icon;
    private javax.swing.JLabel titletxt;
}
