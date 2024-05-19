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
    }
    
    public CalendarPage(String id) {
        setResizable(false);
        setTitle("Calendar Page");
        this.userID = id;
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
    
//    private void myinit(){
//        JLabel[] home_labels = {homeBtn, homeBtnTxt};
//        JLabel[] add_workflow_labels = {addWorkflowBtn, addWorkflowBtnTxt, addWorkflowBtnTxt1};
//        JLabel[] calendar_labels = {calendarBtn, calendarBtnTxt};
//        JLabel[] aranara_labels = {aranaraBtn, aranaraBtnTxt};
//        JLabel[] logout_labels = {logoutBtn, logoutBtnTxt};
//        
//        homeBtn.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new HomePage(userID).setVisible(true);
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                hoverButton("/App/img/home_active.png", 0, 141, 189, home_labels);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                hoverButton("/App/img/home.png", 255, 255, 255, home_labels);
//            }
//        });
//        homeBtnTxt.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new HomePage(userID).setVisible(true);
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                hoverButton("/App/img/home_active.png", 0, 141, 189, home_labels);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                hoverButton("/App/img/home.png", 255, 255, 255, home_labels);
//            }
//        }); 
//        
//        addWorkflowBtn.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new AddWorkflowPage(userID).setVisible(true);
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                hoverButton("/App/img/add_workflow_active.png", 0, 141, 189, add_workflow_labels);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                hoverButton("/App/img/add_workflow.png", 255, 255, 255, add_workflow_labels);
//            }
//        });
//        addWorkflowBtnTxt.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new AddWorkflowPage(userID).setVisible(true);
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                hoverButton("/App/img/add_workflow_active.png", 0, 141, 189, add_workflow_labels);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                hoverButton("/App/img/add_workflow.png", 255, 255, 255, add_workflow_labels);
//            }
//        });      
//        addWorkflowBtnTxt1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new AddWorkflowPage(userID).setVisible(true);
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                hoverButton("/App/img/add_workflow_active.png", 0, 141, 189, add_workflow_labels);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                hoverButton("/App/img/add_workflow.png", 255, 255, 255, add_workflow_labels);
//            }
//        });
//    
//        calendarBtn.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new CalendarPage(userID).setVisible(true);
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                hoverButton("/App/img/calendar_active.png", 0, 141, 189, calendar_labels);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                hoverButton("/App/img/calendar.png", 255, 255, 255, calendar_labels);
//            }
//        });
//        calendarBtnTxt.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new CalendarPage(userID).setVisible(true);
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                hoverButton("/App/img/calendar_active.png", 0, 141, 189, calendar_labels);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                hoverButton("/App/img/calendar.png", 255, 255, 255, calendar_labels);
//            }
//        });
//        
//        aranaraBtn.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new AranaraPage(userID).setVisible(true);
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                hoverButton("/App/img/aranara_active.png", 0, 141, 189, aranara_labels);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                hoverButton("/App/img/aranara.png", 255, 255, 255, aranara_labels);
//            }
//        });
//        aranaraBtnTxt.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new AranaraPage(userID).setVisible(true);
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                hoverButton("/App/img/aranara_active.png", 0, 141, 189, aranara_labels);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                hoverButton("/App/img/aranara.png", 255, 255, 255, aranara_labels);
//            }
//        });
//        
//        logoutBtn.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new WelcomePage().setVisible(true);
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                hoverButton("/App/img/logout_active.png", 0, 141, 189, logout_labels);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                hoverButton("/App/img/logout.png", 255, 255, 255, logout_labels);
//            }
//        });
//        logoutBtnTxt.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new WelcomePage().setVisible(true);
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                hoverButton("/App/img/logout_active.png", 0, 141, 189, logout_labels);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                hoverButton("/App/img/logout.png", 255, 255, 255, logout_labels);
//            }
//        });
//    }

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
    // End of variables declaration//GEN-END:variables
}
