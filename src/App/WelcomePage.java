/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Asus
 */
public class WelcomePage extends javax.swing.JFrame {
    private MusicPlayer musicPlayer; 
    /**
     * Creates new form WelcomePage
     */
    public WelcomePage(MusicPlayer player) {
        musicPlayer = player;
        setTitle("Welcome Page");
        initComponents();
        myinit();
        setResizable(false);
    }
    
    private void myinit(){
        signUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Signup(musicPlayer).setVisible(true);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                signUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hover_button.png")));
                signUpText.setForeground(new java.awt.Color(252, 239, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/button.png")));      
                signUpText.setForeground(new java.awt.Color(112, 79, 40));
            }
        });
        
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Login(musicPlayer).setVisible(true);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hover_button.png")));
                loginText.setForeground(new java.awt.Color(252, 239, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/button.png")));      
                loginText.setForeground(new java.awt.Color(112, 79, 40));
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

        loginText = new javax.swing.JLabel();
        signUpText = new javax.swing.JLabel();
        loginButton = new javax.swing.JLabel();
        signUpButton = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginText.setFont(new java.awt.Font("Montserrat SemiBold", 0, 52)); // NOI18N
        loginText.setForeground(new java.awt.Color(112, 79, 40));
        loginText.setText("Login");
        getContentPane().add(loginText, new org.netbeans.lib.awtextra.AbsoluteConstraints(899, 513, -1, -1));

        signUpText.setFont(new java.awt.Font("Montserrat SemiBold", 0, 52)); // NOI18N
        signUpText.setForeground(new java.awt.Color(112, 79, 40));
        signUpText.setText("Sign Up");
        getContentPane().add(signUpText, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 280, -1, -1));

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/button.png"))); // NOI18N
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 480, -1, -1));

        signUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/button.png"))); // NOI18N
        signUpButton.setText("Sin");
        getContentPane().add(signUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 245, 420, -1));
        signUpButton.getAccessibleContext().setAccessibleName("signUpButton");

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/welcome.png"))); // NOI18N
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
            java.util.logging.Logger.getLogger(WelcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MusicPlayer player = new MusicPlayer("src/App/sound/EnchantingBedtimeStories.wav", 0.9f);
                player.play();
                new WelcomePage(player).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel loginButton;
    private javax.swing.JLabel loginText;
    private javax.swing.JLabel signUpButton;
    private javax.swing.JLabel signUpText;
    // End of variables declaration//GEN-END:variables
}
