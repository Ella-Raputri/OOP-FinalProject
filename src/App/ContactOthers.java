/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Asus
 */
public class ContactOthers extends javax.swing.JFrame {
    private String userID;
    private int nameCount;
    private int msgCount;
    /**
     * Creates new form ContactOthers
     */
    public ContactOthers() {
        setResizable(false);
        setTitle("Contact Others");
        initComponents();
        initDesign();
    }
    
    private void initHover(){
        editContact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new HomePage(userID).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                editContact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_contact_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                editContact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_contact.png")));
            }
        });
        
        editMessage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new HomePage(userID).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                editMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_contact_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                editMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_contact.png")));
            }
        });
    }
    
    private void initDesign(){
        sendTotxt = new javax.swing.JLabel();
        nameTxt = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JLabel();
        editContact = new javax.swing.JLabel();
        nameBox = new javax.swing.JComboBox();
        phoneField = new RoundJTextField(30, "");
        editMessage = new javax.swing.JLabel();
        messageTxt = new javax.swing.JLabel();
        messageBox = new javax.swing.JComboBox();
        cancelBtn = new App.ButtonCustom();
        OKbtn = new App.ButtonCustom();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
       
        getContentPane().setBackground(Color.white);
        sendTotxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        sendTotxt.setForeground(new java.awt.Color(0,0,0));
        sendTotxt.setText("Send To");
        getContentPane().add(sendTotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 19, -1, -1));
        
        nameTxt.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        nameTxt.setForeground(new java.awt.Color(0,0,0));
        nameTxt.setText("Name:");
        getContentPane().add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 58, -1, -1));
        
        phoneTxt.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        phoneTxt.setForeground(new java.awt.Color(0,0,0));
        phoneTxt.setText("Phone:");
        getContentPane().add(phoneTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 107, -1, -1));
        
        messageTxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        messageTxt.setForeground(new java.awt.Color(0,0,0));
        messageTxt.setText("Message");
        getContentPane().add(messageTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 173, -1, -1));
        
        phoneField.setBackground(new java.awt.Color(234, 234, 234));
        phoneField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        phoneField.setForeground(new java.awt.Color(155, 154, 154));
        getContentPane().add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 104, 257, 32));
        
        messageBox.setBackground(new java.awt.Color(234, 234, 234));
        messageBox.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        messageBox.setForeground(new java.awt.Color(155, 154, 154));
        messageBox.setMaximumRowCount(msgCount);
        messageBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "Desember" }));
        getContentPane().add(messageBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 212, 330, 40));
        
        nameBox.setBackground(new java.awt.Color(234, 234, 234));
        nameBox.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        nameBox.setForeground(new java.awt.Color(155, 154, 154));
        nameBox.setMaximumRowCount(nameCount);
        nameBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "Desember" }));
        getContentPane().add(nameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 55, 257, 32));
        
        editContact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_contact.png"))); // NOI18N
        getContentPane().add(editContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 24, -1, -1));
        
        editMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_contact.png"))); // NOI18N
        getContentPane().add(editMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 182, -1, -1));
        
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
        OKbtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        OKbtn.setRadius(20);
        OKbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // OKbtnActionPerformed(evt);
            }
        });
        getContentPane().add(OKbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 312, 61, 37));
    
        cancelBtn.setForeground(new java.awt.Color(31, 139, 217));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorderColor(new java.awt.Color(31, 139, 217));
        cancelBtn.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
        cancelBtn.setBorderColorOver(new java.awt.Color(125, 201, 255));
        cancelBtn.setColor2(new java.awt.Color(31, 139, 217));
        cancelBtn.setColor(java.awt.Color.white);
        cancelBtn.setColorClick2(new java.awt.Color(125, 201, 255));
        cancelBtn.setColorClick(java.awt.Color.white);
        cancelBtn.setColorOver2(new java.awt.Color(125, 201, 255));
        cancelBtn.setColorOver(java.awt.Color.white);
        cancelBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        cancelBtn.setRadius(20);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              //  cancelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 312, 92, 37));
        
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
            java.util.logging.Logger.getLogger(ContactOthers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContactOthers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContactOthers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContactOthers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactOthers().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel sendTotxt;
    private javax.swing.JLabel nameTxt;
    private javax.swing.JLabel phoneTxt;
    private javax.swing.JLabel editContact;
    private javax.swing.JComboBox nameBox;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel editMessage;
    private javax.swing.JLabel messageTxt;
    private javax.swing.JComboBox messageBox;
    private App.ButtonCustom cancelBtn;
    private App.ButtonCustom OKbtn;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
