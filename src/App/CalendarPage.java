/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author Asus
 */
public class CalendarPage extends javax.swing.JFrame {
    private String userID;
    /**
     * Creates new form CalendarPage
     */
    public CalendarPage() {
        setResizable(false);
        setTitle("Calendar Page");
        initComponents();
        myinit();
    }
    
    public CalendarPage(String id) {
        setResizable(false);
        setTitle("Calendar Page");
        this.userID = id;
        initComponents();
        myinit();
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
    
    private void myinit(){
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
}
