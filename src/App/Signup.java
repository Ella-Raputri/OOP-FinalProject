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
import java.time.LocalDate;
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
    private MusicPlayer musicPlayer;
    /**
     * Creates new form 
     */
    public Signup(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
        setResizable(false);
        setTitle("Sign Up Page");
        initComponents();
        myinit();
    }
    
    private void setBottomBorder(javax.swing.JTextField field, int colorR, int colorG, int colorB){
        //set the bottom border for the textfield
        //so that it only has the bottom border
        Color border_color = new java.awt.Color(colorR, colorG, colorB);
        Border bottomBorder = BorderFactory.createMatteBorder(0,0,1,0,border_color);
        field.setBorder(bottomBorder);
        field.setOpaque(false); 
        field.setBackground(new java.awt.Color(0,0,0,0));
    }
    
    //valid password pattern is at least 8 characters containing both alphabet and numbers
    public static final Pattern VALID_PASSWORD_REGEX = 
    Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", Pattern.CASE_INSENSITIVE);
    
    //validate the password by checking whether it matches the regex pattern or not
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
        
        //set the hover and click action for login button
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //when clicked
                setVisible(false);
                new Login(musicPlayer).setVisible(true);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) { //when hovered
                loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hover_smallButton.png")));
                logintxt.setForeground(new java.awt.Color(252, 239, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {//when not hovered
                loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/smallButton.png")));      
                logintxt.setForeground(new java.awt.Color(112, 79, 40));
            }
        });
        //the login txt is also part of the login button
        logintxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //when clicked
                setVisible(false);
                new Login(musicPlayer).setVisible(true);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) { //when hovered
                loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hover_smallButton.png")));
                logintxt.setForeground(new java.awt.Color(252, 239, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) { //when not hovered
                loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/smallButton.png")));      
                logintxt.setForeground(new java.awt.Color(112, 79, 40));
            }
        });
        
        //set the click action for hide and show password
        show_pass.addMouseListener(new MouseAdapter() {
            //by default, the password will not be shown
            boolean showPass = false;

            @Override
            public void mouseClicked(MouseEvent e) { //if clicked
                if (!showPass){ //if the passqord is not shown yet
                    //set the password to be visible
                    show_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hide_password.png")));
                    password_field.setEchoChar((char)0);
                    password_field.setFont(new java.awt.Font("Montserrat", Font.PLAIN, 24));
                    showPass = true;
                }else{
                    //if the password already visible, set it to be hidden again
                    show_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/show_password.png")));
                    password_field.setEchoChar((char)8226);
                    password_field.setFont(new java.awt.Font("Montserrat", 1, 22));
                    showPass = false;
                }
            }
        });
        show_conf.addMouseListener(new MouseAdapter() {
            //by default the password confirmation will be hidden
            boolean showConf = false;

            @Override
            public void mouseClicked(MouseEvent e) { //if clicked
                //if the password confirmation is not shown yet
                if (!showConf){
                    //set it to be not hidden
                    show_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hide_password.png")));
                    confirm_field.setEchoChar((char)0);
                    confirm_field.setFont(new java.awt.Font("Montserrat", Font.PLAIN, 24));
                    showConf = true;
                }else{
                    //set it to be hidden again
                    show_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/show_password.png")));
                    confirm_field.setEchoChar((char)8226);
                    confirm_field.setFont(new java.awt.Font("Montserrat", 1, 24));
                    showConf = false;
                }
            }
        });
    
        //for every character update in the username field
        username_field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { //when insert
                recolorField(username_field, usernametxt);
            }
            @Override
            public void removeUpdate(DocumentEvent e) { //when remove
                recolorField(username_field, usernametxt);
            }
            @Override
            public void changedUpdate(DocumentEvent e) { //when change
                recolorField(username_field, usernametxt);
            }
        });
        username_field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When "Enter" is pressed in username_field, move focus to password_field
                password_field.requestFocusInWindow();
            }
        });
        
        //for every character update in password field
        password_field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { //when insert
                recolorField(password_field, passwordtxt);
                checkPassConfirm();
            }
            @Override
            public void removeUpdate(DocumentEvent e) { //when remove
                recolorField(password_field, passwordtxt);
                checkPassConfirm();
            }
            @Override
            public void changedUpdate(DocumentEvent e) { //when change
                recolorField(password_field, passwordtxt);
                checkPassConfirm();
            }
        });
        password_field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When "Enter" is pressed in password field, move focus to confirm field
                confirm_field.requestFocusInWindow();
            }
        });
        
        //for every character update in confirm field
        confirm_field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { //when insert
                recolorField(confirm_field, confirmtxt);
                checkPassConfirm();
            }
            @Override
            public void removeUpdate(DocumentEvent e) { //when remove
                recolorField(confirm_field, confirmtxt);
                checkPassConfirm();
            }
            @Override
            public void changedUpdate(DocumentEvent e) { //when change
                recolorField(confirm_field, confirmtxt);
                checkPassConfirm();
            }
        });
        confirm_field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When "Enter" is pressed in confirm field, submit the inputted data
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
        //back to the welcome page when back button is pressed
        setVisible(false);
        new WelcomePage(musicPlayer).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void confirm_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirm_fieldActionPerformed

    private void password_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_fieldActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        //get the data from the textfields
        String username_str = username_field.getText();
        String pass_str = password_field.getText();
        String confirm_str = confirm_field.getText();
        
        //validation
        if(username_str.trim().isEmpty()){ //if username is still empty
            JOptionPane.showMessageDialog(getContentPane(), "Username is still empty.");
        }
        else if(pass_str.trim().isEmpty()){ //if password is still empty
            JOptionPane.showMessageDialog(getContentPane(), "Password is still empty.");
        }
        else if(confirm_str.trim().isEmpty()){ //if confirm password is still empty
            JOptionPane.showMessageDialog(getContentPane(), "Confirm Password is still empty.");
        }
        else{           
           if(!(pass_str.equals(confirm_str))){ //if password and confirm password is not the same
               JOptionPane.showMessageDialog(getContentPane(), "Password and Confirm Password is not the same.");
           }
           else{
               if(!(validatePassword(pass_str))){ //if password pattern is not valid
                    JOptionPane.showMessageDialog(getContentPane(), "Password must have 8 characters with at least one number and one character");
               }
           }
        }
        
        if(pass_str.equals(confirm_str) && validatePassword(pass_str)){ //if all requirements met
            //get today day name
            String day = LocalDate.now().getDayOfWeek().name();
            String day_name = day.charAt(0) + day.substring(1,3).toLowerCase(); 
            try{
                //set ID first
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery("SELECT COUNT(userID) FROM user");
                String idStr ="";
                if(rs.first()){
                    //if there exists other users before you, your ID will be the last ID + 1
                    String id = rs.getString(1);                    
                    int idInt = Integer.parseInt(id);
                    idInt = idInt+1;
                    idStr = "u" + String.valueOf(idInt);
                }
                else{
                    idStr = "u1"; //if you are the first user
                }

                //insert into database
                String sql = "INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, idStr);
                ps.setString(2, username_str);
                ps.setString(3, pass_str);
                ps.setString(4, "arama");
                ps.setInt(5, 0);
                ps.setInt(6, 0);
                ps.setInt(7, 0);
                ps.setString(8, day_name);
                ps.setInt(9, 0);

                ps.executeUpdate();
                
                updateTaskCompletions(idStr);
                
                //after sign up, auto redirect to the homepage
                setVisible(false);
                
                //because it is their first signup, then the default aranara will be arama
                //set the background music to play arama song
                musicPlayer.loadMusic("src/App/sound/MelodyofHiddenSeeds.wav");
                musicPlayer.play();
                new HomePage(idStr, musicPlayer).setVisible(true);

            }catch(Exception e){
                e.printStackTrace();
            }
        }                
    }//GEN-LAST:event_submitBtnActionPerformed

    private void updateTaskCompletions(String userID){
        //update the task completion database
        try{
            //insert all value to be 0 to the task completon database
            //because the user is new and does not complete any task before
            Connection con = ConnectionProvider.getCon();
            String query = "INSERT INTO task_completion VALUES(?,?,?,?,?,?,?,?)";
             
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, userID);
            pst.setInt(2, 0);
            pst.setInt(3, 0);
            pst.setInt(4, 0);
            pst.setInt(5, 0);
            pst.setInt(6, 0);
            pst.setInt(7, 0);
            pst.setInt(8, 0);
            
            pst.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void username_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_fieldActionPerformed

    private void username_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_username_fieldFocusLost
        // recolor username field when focus lost
        recolorField(username_field, usernametxt);
    }//GEN-LAST:event_username_fieldFocusLost

    private void password_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password_fieldFocusLost
        // recolor field and check pasword and confirm field valid or not
        recolorField(password_field, passwordtxt);
        checkPassConfirm();
    }//GEN-LAST:event_password_fieldFocusLost

    private void confirm_fieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirm_fieldFocusLost
        // recolor field and check pasword and confirm field valid or not
        recolorField(confirm_field, confirmtxt);
        checkPassConfirm();
    }//GEN-LAST:event_confirm_fieldFocusLost
    
    private void recolorField(JTextField field, JLabel label){
        //get text of the field
        String text = field.getText();
        //if the text is empty, set the color to be red
        if(text.trim().isEmpty()){
            label.setForeground(Color.red); //red text color
            setBottomBorder(field, 255, 0, 0); //red border
            field.setForeground(Color.red); //red text color
        }
        else{
            // if not, then like default, it is black (text and border)
            label.setForeground(Color.black);
            setBottomBorder(field, 0, 0, 0);
            field.setForeground(Color.black);
        }
    }
    
    private void checkPassConfirm(){
        //get the text in password and confirm password field
        String text = password_field.getText();
        String textConfirm = confirm_field.getText();
        
        //if both text is not the same
        if(!(text.equals(textConfirm))){
            //set both fields border and text color to be red
            passwordtxt.setForeground(Color.red);
            setBottomBorder(password_field, 255, 0, 0);
            password_field.setForeground(Color.red);
            
            confirmtxt.setForeground(Color.red);
            setBottomBorder(confirm_field, 255, 0, 0);
            confirm_field.setForeground(Color.red);
        }
        else if(!(validatePassword(text))){
            //if the password is not valid
            //set the password border and text to be red
            passwordtxt.setForeground(Color.red);
            setBottomBorder(password_field, 255, 0, 0);
            password_field.setForeground(Color.red);            
        }
        else{
            //set the color to be default again, which is black
            //for password field
            passwordtxt.setForeground(Color.black);
            setBottomBorder(password_field, 0, 0, 0);
            password_field.setForeground(Color.black);
            
            //for confirm field
            confirmtxt.setForeground(Color.black);
            setBottomBorder(confirm_field, 0, 0, 0);
            confirm_field.setForeground(Color.black);
        }
    }
    /**
     * @param args the command line arguments
     */

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
