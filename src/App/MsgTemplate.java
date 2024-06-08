/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Asus
 */
public class MsgTemplate extends javax.swing.JFrame {
    private String userID;

    /**
     * Creates new form msgTemplate
     */
    public MsgTemplate() {
        setResizable(false);
        setTitle("Message Template");
        initComponents();
        initDesign();
    }
    
        private void initHover(){
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new HomePage(userID).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_msg_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_msg.png")));
            }
        });
    }
    
    private void initDesign(){
        getContentPane().setBackground(Color.white);
        
        backBtn = new JLabel();
        messagetxt = new JLabel("Message Template");
        newMsgField = new PlaceHolderTextField("Add new message", 0);
        setBtn = new App.ButtonCustom();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_msg.png"))); // NOI18N
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        
        messagetxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        messagetxt.setForeground(new java.awt.Color(0,0,0));
        getContentPane().add(messagetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 32, -1, -1));
        
        newMsgField.setBackground(new java.awt.Color(234, 234, 234));
        newMsgField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        newMsgField.setForeground(new java.awt.Color(155, 154, 154));
        newMsgField.setBorder(new EmptyBorder(new Insets(5, 15, 5, 10)));
        getContentPane().add(newMsgField, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 75, 279, 35));
        
        setBtn.setForeground(new java.awt.Color(255, 255, 255));
        setBtn.setText("Set");
        setBtn.setBorderColor(new java.awt.Color(31, 139, 217));
        setBtn.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
        setBtn.setBorderColorOver(new java.awt.Color(125, 201, 255));
        setBtn.setColor(new java.awt.Color(31, 139, 217));
        setBtn.setColor2(java.awt.Color.white);
        setBtn.setColorClick(new java.awt.Color(125, 201, 255));
        setBtn.setColorClick2(java.awt.Color.white);
        setBtn.setColorOver(new java.awt.Color(125, 201, 255));
        setBtn.setColorOver2(java.awt.Color.white);
        setBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        setBtn.setRadius(5);
        setBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // setBtnActionPerformed(evt);
            }
        });
        getContentPane().add(setBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 75, 60, 34));     
        
        initHover();
        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(MsgTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MsgTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MsgTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MsgTemplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MsgTemplate().setVisible(true);
            }
        });
    }
    
    private javax.swing.JLabel backBtn;
    private javax.swing.JLabel messagetxt;
    private javax.swing.JTextField newMsgField;
    private App.ButtonCustom setBtn;
    private JPanel contentPane;
    private JPanel cloneablePanel;
    private JScrollPane scrollPane;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
