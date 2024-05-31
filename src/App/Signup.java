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
public class Signup extends javax.swing.JFrame {

    /**
     * Creates new form 
     */
    public Signup() {
        setResizable(false);
        setTitle("Sign Up Page");
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
        setBottomBorder(confirm_field, 0, 0, 0);
        
        //set the password field
        password_field.setEchoChar((char)8226);
        password_field.setFont(new java.awt.Font("Montserrat", 1, 22));
        
        //set the confirm password field
        confirm_field.setEchoChar((char)8226);
        confirm_field.setFont(new java.awt.Font("Montserrat", 1, 22));
        
        //set the hover and click action for signup button
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Login().setVisible(true);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hover_smallButton.png")));
                logintxt.setForeground(new java.awt.Color(252, 239, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/smallButton.png")));      
                logintxt.setForeground(new java.awt.Color(112, 79, 40));
            }
        });
        logintxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Login().setVisible(true);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hover_smallButton.png")));
                logintxt.setForeground(new java.awt.Color(252, 239, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/smallButton.png")));      
                logintxt.setForeground(new java.awt.Color(112, 79, 40));
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
        show_conf.addMouseListener(new MouseAdapter() {
            boolean showConf = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!showConf){
                    show_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hide_password.png")));
                    confirm_field.setEchoChar((char)0);
                    confirm_field.setFont(new java.awt.Font("Montserrat", Font.PLAIN, 24));
                    showConf = true;
                }else{
                    show_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/show_password.png")));
                    confirm_field.setEchoChar((char)8226);
                    confirm_field.setFont(new java.awt.Font("Montserrat", 1, 24));
                    showConf = false;
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
                checkPassConfirm();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                recolorField(password_field, passwordtxt);
                checkPassConfirm();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                recolorField(password_field, passwordtxt);
                checkPassConfirm();
            }
        });
        password_field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When "Enter" is pressed in textField1, move focus to textField2
                confirm_field.requestFocusInWindow();
            }
        });
        
        confirm_field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                recolorField(confirm_field, confirmtxt);
                checkPassConfirm();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                recolorField(confirm_field, confirmtxt);
                checkPassConfirm();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                recolorField(confirm_field, confirmtxt);
                checkPassConfirm();
            }
        });
        confirm_field.addActionListener(new ActionListener() {
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

        alr_have_txt = new javax.swing.JLabel();
        logintxt = new javax.swing.JLabel();
        loginBtn = new javax.swing.JLabel();
        show_pass = new javax.swing.JLabel();
        show_conf = new javax.swing.JLabel();
        confirmtxt = new javax.swing.JLabel();
        confirm_field = new javax.swing.JPasswordField();
        passwordtxt = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        username_field = new javax.swing.JTextField();
        usernametxt = new javax.swing.JLabel();
        backBtn = new App.ButtonCustom();
        submitBtn = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        alr_have_txt.setFont(new java.awt.Font("Montserrat Medium", 0, 20)); // NOI18N
        alr_have_txt.setText("<html><u>Already have an account?</u></html>");
        alr_have_txt.setToolTipText("");
        getContentPane().add(alr_have_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 499, -1, -1));

        logintxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        logintxt.setForeground(new java.awt.Color(112, 79, 40));
        logintxt.setText("Login");
        logintxt.setToolTipText("");
        getContentPane().add(logintxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 499, -1, -1));

        loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/smallButton.png"))); // NOI18N
        getContentPane().add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(922, 490, -1, -1));

        show_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/show_password.png"))); // NOI18N
        getContentPane().add(show_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 310, -1, -1));

        show_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/show_password.png"))); // NOI18N
        getContentPane().add(show_conf, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 410, -1, -1));

        confirmtxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        confirmtxt.setText("Confirm Password");
        getContentPane().add(confirmtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 363, -1, -1));

        confirm_field.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        confirm_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirm_fieldFocusLost(evt);
            }
        });
        confirm_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(confirm_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 399, 556, 42));

        passwordtxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        passwordtxt.setText("Password");
        getContentPane().add(passwordtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 266, -1, -1));

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
        getContentPane().add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 302, 556, 42));

        username_field.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        username_field.setToolTipText("");
        username_field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                username_fieldFocusLost(evt);
            }
        });
        username_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 198, 556, 42));

        usernametxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        usernametxt.setText("Username");
        getContentPane().add(usernametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 165, -1, -1));

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
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 161, 69));

        submitBtn.setBackground(new java.awt.Color(112, 79, 40));
        submitBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 30)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 590, 242, 59));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/Signup.png"))); // NOI18N
        bg.setText("jLabel1");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        setVisible(false);
        new WelcomePage().setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void confirm_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirm_fieldActionPerformed

    private void password_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_fieldActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        String username_str = username_field.getText();
        String pass_str = password_field.getText();
        String confirm_str = confirm_field.getText();
        
        if(username_str.trim().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Username is still empty.");
        }
        else if(pass_str.trim().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Password is still empty.");
        }
        else if(confirm_str.trim().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Confirm Password is still empty.");
        }
        else{           
           if(!(pass_str.equals(confirm_str))){
               JOptionPane.showMessageDialog(getContentPane(), "Password and Confirm Password is not the same.");
           }
           else{
               if(!(validatePassword(pass_str))){
                    JOptionPane.showMessageDialog(getContentPane(), "Password must have 8 characters with at least one number and one character");
               }
           }
        }
        
        if(pass_str.equals(confirm_str) && validatePassword(pass_str)){
            try{
                //set ID first
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery("SELECT COUNT(userID) FROM user");
                String idStr ="";
                if(rs.first()){
                    String id = rs.getString(1);                    
                    int idInt = Integer.parseInt(id);
                    idInt = idInt+1;
                    idStr = "u" + String.valueOf(idInt);
                }
                else{
                    idStr = "u1";
                }

                //insert into database
                String sql = "insert into user values(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, idStr);
                ps.setString(2, username_str);
                ps.setString(3, pass_str);
                ps.setString(4, "arama");
                ps.setInt(5, 0);
                ps.setInt(6, 0);
                ps.setInt(7, 0);

                ps.executeUpdate();
                setVisible(false);
                new HomePage(idStr).setVisible(true);

            }catch(Exception e){
                JOptionPane.showMessageDialog(getContentPane(), e);
            }
        }
                
    }//GEN-LAST:event_submitBtnActionPerformed

    private void username_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_fieldActionPerformed

    private void username_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username_fieldFocusLost
        // TODO add your handling code here:
        recolorField(username_field, usernametxt);
    }//GEN-LAST:event_username_fieldFocusLost

    private void password_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_fieldFocusLost
        // TODO add your handling code here
        recolorField(password_field, passwordtxt);
        checkPassConfirm();
    }//GEN-LAST:event_password_fieldFocusLost

    private void confirm_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirm_fieldFocusLost
        // TODO add your handling code here:
        recolorField(confirm_field, confirmtxt);
        checkPassConfirm();
    }//GEN-LAST:event_confirm_fieldFocusLost
    
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
    
    private void checkPassConfirm(){
        String text = password_field.getText();
        String textConfirm = confirm_field.getText();
        if(!(text.equals(textConfirm))){
            passwordtxt.setForeground(Color.red);
            setBottomBorder(password_field, 255, 0, 0);
            password_field.setForeground(Color.red);
            
            confirmtxt.setForeground(Color.red);
            setBottomBorder(confirm_field, 255, 0, 0);
            confirm_field.setForeground(Color.red);
        }
        else if(!(validatePassword(text))){
            passwordtxt.setForeground(Color.red);
            setBottomBorder(password_field, 255, 0, 0);
            password_field.setForeground(Color.red);
            
            confirmtxt.setForeground(Color.red);
            setBottomBorder(confirm_field, 255, 0, 0);
            confirm_field.setForeground(Color.red);
        }
        else{
            passwordtxt.setForeground(Color.black);
            setBottomBorder(password_field, 0, 0, 0);
            password_field.setForeground(Color.black);
            
            confirmtxt.setForeground(Color.black);
            setBottomBorder(confirm_field, 0, 0, 0);
            confirm_field.setForeground(Color.black);
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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alr_have_txt;
    private App.ButtonCustom backBtn;
    private javax.swing.JLabel bg;
    private javax.swing.JPasswordField confirm_field;
    private javax.swing.JLabel confirmtxt;
    private javax.swing.JLabel loginBtn;
    private javax.swing.JLabel logintxt;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JLabel passwordtxt;
    private javax.swing.JLabel show_conf;
    private javax.swing.JLabel show_pass;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField username_field;
    private javax.swing.JLabel usernametxt;
    // End of variables declaration//GEN-END:variables
}
