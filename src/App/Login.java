/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author Asus
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        setResizable(false);
        setTitle("Login Page");
        initComponents();
        myinit();
    }
    
    private void setBottomBorder(javax.swing.JTextField field, int colorR, int colorG, int colorB){
        Color border_color = new java.awt.Color(colorR, colorG, colorB);
        Border bottomBorder = BorderFactory.createMatteBorder(0,0,1,0,border_color);
        field.setBorder(bottomBorder);
        field.setOpaque(false); 
        field.setBackground(new java.awt.Color(0,0,0,0));
    }
    
    public static final Pattern VALID_PASSWORD_REGEX = 
    Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", Pattern.CASE_INSENSITIVE);
    
    public static boolean validatePassword(String passwordStr) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(passwordStr);
        return matcher.matches();
    }
    
    private void myinit(){
        //style the username textfield to has transparent background and only bottom border 
        setBottomBorder(username_field, 0, 0, 0);
        setBottomBorder(password_field, 0, 0 ,0); 
        
        //style the password field text
        password_field.setEchoChar((char)8226);
        password_field.setFont(new java.awt.Font("Montserrat", 1, 22));
        
        //set the hover and click action for signup button
        signUpBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Signup().setVisible(true);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                signUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hover_smallButton.png")));
                signUptxt.setForeground(new java.awt.Color(252, 239, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/smallButton.png")));      
                signUptxt.setForeground(new java.awt.Color(112, 79, 40));
            }
        });
        signUptxt.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Signup().setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                signUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hover_smallButton.png")));
                signUptxt.setForeground(new java.awt.Color(252, 239, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/smallButton.png")));      
                signUptxt.setForeground(new java.awt.Color(112, 79, 40));
            }
        });
        
        
        //set the click action for hide and show password
        show_pass.addMouseListener(new MouseAdapter() {
            boolean showPass = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!showPass){
                    show_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hide_password.png")));
                    password_field.setEchoChar((char)0);
                    password_field.setFont(new java.awt.Font("Montserrat", Font.PLAIN, 24));
                    showPass = true;
                }else{
                    show_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/show_password.png")));
                    password_field.setEchoChar((char)8226);
                    password_field.setFont(new java.awt.Font("Montserrat", 1, 22));
                    showPass = false;
                }
            }
        });  
        
        username_field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                recolorField(username_field, usernametxt);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                recolorField(username_field, usernametxt);
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                recolorField(username_field, usernametxt);
            }
        });
        username_field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When "Enter" is pressed in textField1, move focus to textField2
                password_field.requestFocusInWindow();
            }
        });
        
        password_field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                recolorField(password_field, passwordtxt);
                checkPass();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                recolorField(password_field, passwordtxt);
                checkPass();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                recolorField(password_field, passwordtxt);
                checkPass();
            }
        });
        password_field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When "Enter" is pressed in textField1, move focus to textField2
                submitBtnActionPerformed(e);
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

        show_pass = new javax.swing.JLabel();
        backBtn = new App.ButtonCustom();
        submitBtn = new javax.swing.JButton();
        signUptxt = new javax.swing.JLabel();
        signUpBtn = new javax.swing.JLabel();
        dont_have_txt = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        passwordtxt = new javax.swing.JLabel();
        usernametxt = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        show_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/show_password.png"))); // NOI18N
        getContentPane().add(show_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 350, -1, -1));

        backBtn.setBackground(new java.awt.Color(245, 215, 180));
        backBtn.setForeground(new java.awt.Color(184, 138, 82));
        backBtn.setText("< Back");
        backBtn.setBorderColor(new java.awt.Color(245, 215, 180));
        backBtn.setBorderColorNotOver(new java.awt.Color(245, 215, 180));
        backBtn.setBorderColorOver(new java.awt.Color(238, 202, 158));
        backBtn.setColor(new java.awt.Color(245, 215, 180));
        backBtn.setColor2(new java.awt.Color(184, 138, 82));
        backBtn.setColorClick(new java.awt.Color(238, 202, 158));
        backBtn.setColorClick2(new java.awt.Color(204, 162, 109));
        backBtn.setColorOver(new java.awt.Color(238, 202, 158));
        backBtn.setColorOver2(new java.awt.Color(204, 162, 109));
        backBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 32)); // NOI18N
        backBtn.setPreferredSize(new java.awt.Dimension(161, 69));
        backBtn.setRadius(40);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 161, 69));

        submitBtn.setBackground(new java.awt.Color(112, 79, 40));
        submitBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 30)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 542, 242, 59));

        signUptxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        signUptxt.setForeground(new java.awt.Color(112, 79, 40));
        signUptxt.setText("Sign Up");
        signUptxt.setToolTipText("");
        getContentPane().add(signUptxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 440, -1, -1));

        signUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/smallButton.png"))); // NOI18N
        getContentPane().add(signUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 430, -1, -1));

        dont_have_txt.setFont(new java.awt.Font("Montserrat Medium", 0, 20)); // NOI18N
        dont_have_txt.setText("<html><u>Do not have an account?</u></html>");
        dont_have_txt.setToolTipText("");
        getContentPane().add(dont_have_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 443, -1, -1));

        password_field.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        password_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                password_fieldFocusLost(evt);
            }
        });
        password_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 556, 42));

        passwordtxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        passwordtxt.setText("Password");
        getContentPane().add(passwordtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 302, -1, -1));

        usernametxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        usernametxt.setText("Username");
        getContentPane().add(usernametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 192, -1, -1));

        username_field.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        username_field.setToolTipText("");
        username_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                username_fieldFocusLost(evt);
            }
        });
        getContentPane().add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 225, 556, 42));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/Login.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new WelcomePage().setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void password_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_fieldActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        String username_str = username_field.getText();
        String pass_str = password_field.getText();
        
        if(username_str.trim().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Username is still empty.");
        }
        else if(pass_str.trim().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Password is still empty.");
        }
        else{
            if(!(validatePassword(pass_str))){
                 JOptionPane.showMessageDialog(getContentPane(), "Password must have 8 characters with at least one number and one character");
            }
        } 
        
        if(validatePassword(pass_str)){
            try{
                //search the username in database
                Connection con = ConnectionProvider.getCon();
                String query = "SELECT * FROM user WHERE username = ?";
                
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, username_str);
                
                try(ResultSet rs = ps.executeQuery()){
                    
                    if (rs.next()){
                        String pass = rs.getString("password");
                        String id = rs.getString("userID");
                        
                        //check password
                        if (pass_str.equals(pass)){
                           setVisible(false);
                           new HomePage(id).setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(getContentPane(), "Password is incorrect.");
                        }
                    }else{
                        JOptionPane.showMessageDialog(getContentPane(),"User is not available.");
                    }
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(getContentPane(), e);
            }
        }
        
    }//GEN-LAST:event_submitBtnActionPerformed

    private void username_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username_fieldFocusLost
        // TODO add your handling code here:        recolorField(username_field, usernametxt);
        recolorField(username_field, usernametxt);
    }//GEN-LAST:event_username_fieldFocusLost

    private void password_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_fieldFocusLost
        // TODO add your handling code here:
        recolorField(password_field, passwordtxt);
        checkPass();
    }//GEN-LAST:event_password_fieldFocusLost

    private void recolorField(JTextField field, JLabel label){
        String text = field.getText();
        if(text.trim().isEmpty()){
            label.setForeground(Color.red);
            setBottomBorder(field, 255, 0, 0);
            field.setForeground(Color.red);
        }
        else{
            label.setForeground(Color.black);
            setBottomBorder(field, 0, 0, 0);
            field.setForeground(Color.black);
        }
    }
    
    private void checkPass(){
        String text = password_field.getText();
        if(!(validatePassword(text))){
            passwordtxt.setForeground(Color.red);
            setBottomBorder(password_field, 255, 0, 0);
            password_field.setForeground(Color.red);
        }
        else{
            passwordtxt.setForeground(Color.black);
            setBottomBorder(password_field, 0, 0, 0);
            password_field.setForeground(Color.black);
        }
    }
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private App.ButtonCustom backBtn;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel dont_have_txt;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JLabel passwordtxt;
    private javax.swing.JLabel show_pass;
    private javax.swing.JLabel signUpBtn;
    private javax.swing.JLabel signUptxt;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField username_field;
    private javax.swing.JLabel usernametxt;
    // End of variables declaration//GEN-END:variables
}
