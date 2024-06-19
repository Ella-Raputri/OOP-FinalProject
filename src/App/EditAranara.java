/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Asus
 */
public class EditAranara extends javax.swing.JFrame {
    private String userID;
    public String aranaraName;
    private int affection;
    private int patAmount;
    private String patDay;
    private String defaultAranara;
    private AranaraChatMenu childWindow = null;
    private EditAranara parent = (EditAranara) SwingUtilities.getRoot(this);
    private MusicPlayer player;
    private SfxPlayer sfxplay = new SfxPlayer("src/App/sound/select.wav", 0.8f);;
    /**
     * Creates new form EditAranara
     */
    public EditAranara(String aranaraName, String uID, MusicPlayer player) {
        this.player = player;
        this.aranaraName = aranaraName;
        this.userID = uID;
        setResizable(false);
        setTitle("Aranara Activity Page");
        initComponents();
        initHover();
        initBasedOnAranara();
    }    
    
    public EditAranara(String aranaraName, String uID, AranaraChatMenu child, MusicPlayer player) {
        this.player = player;
        this.aranaraName = aranaraName;
        this.userID = uID;
        this.childWindow = child;
        setResizable(false);
        setTitle("Aranara Activity Page");
        initComponents();
        initHover();
        initBasedOnAranara();
    } 
    
    public void setDialogText(String s){            
        //refresh the dialogue box if a button is pressed continuously
        //so that the dialog box is still visible and display other text
        dialog_box.setVisible(false);
        dialog_text.setVisible(false);
        
        //set the dialog box and text to be visible
        dialog_box.setVisible(true);
        dialog_text.setVisible(true);
        dialog_text.setText(s);
        
        //set the timer
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //after 5 seconds, the box and text will be invisible again
                dialog_box.setVisible(false);
                dialog_text.setVisible(false);
            }
        });
        // Start the timer
        timer.setRepeats(false); // Make sure the timer only runs once
        timer.start();
    }
    
    public void setGameDialogIcon(String label_path){
        //the game dialog is a special smaller dialog box when playing game with the Aranara
        //set the dialog box icon to be other icon
        dialog_box.setVisible(true);
        dialog_box.setIcon(new javax.swing.ImageIcon(getClass().getResource(label_path)));        
        
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //after 2 seconds, the box will be invisible and the dialog box icon will be default one again
                dialog_box.setVisible(false);
                dialog_box.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/dialog_box.png")));
            }
        });
        // Start the timer
        timer.setRepeats(false); // Make sure the timer only runs once
        timer.start();
    }
    
    private void setHeartIcon(){
        //heart icon is visible when user pats the Aranara
        heart_icon.setVisible(true);
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //after 2 seconds, the heart will be invisible again
                heart_icon.setVisible(false);
            }
        });
        // Start the timer
        timer.setRepeats(false); // Make sure the timer only runs once
        timer.start();
    }
    
    private void initHover(){
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false); //go back to the Aranara menu page
                new AranaraMenu(userID, player).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_aranara_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_aranara.png")));
            }
        });
        
        patBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {   
                //add the affection of the Aranara if the requirements are met and play sfx
                sfxplay.loadSound("src/App/sound/select.wav", 0.8f);
                sfxplay.play();
                patBtnActionPerformed();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                patBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/pat_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                patBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/pat.png")));
            }
        });
        
        setDefaultBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //play sfx and set the current aranara as the default aranara
                sfxplay.loadSound("src/App/sound/select.wav", 0.8f);
                sfxplay.play();
                setDefaultBtnActionPerformed();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setDefaultBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/set_default_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setDefaultBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/set_default.png")));
            }
        });
        
        //the back chat button is only visible when the Aranara chat menu is opened
        backChatBtn.setVisible(false);
        backChatBtn.setEnabled(false);
        
        chatBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //play sfx
                sfxplay.loadSound("src/App/sound/chat.wav", 0.8f);
                sfxplay.play();
                //open the AranaraChatMenu window
                childWindow = new AranaraChatMenu(parent, userID);
                childWindow.setVisible(true);
                //set the back chat button to be visible
                backChatBtn.setVisible(true);
                backChatBtn.setEnabled(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                chatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/chat_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                chatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/chat.png")));
            }
        });
        
        backChatBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (childWindow != null){
                    //play sfx
                    sfxplay.loadSound("src/App/sound/chat.wav", 0.8f);
                    sfxplay.play();
                    //set itself to be invisible again 
                    backChatBtn.setVisible(false);
                    backChatBtn.setEnabled(false);
                    //set the child window to null again
                    childWindow.setVisible(false);
                    childWindow = null;
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                backChatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_chat_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                backChatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_chat.png")));
            }
        });
    }
    
    private void patBtnActionPerformed(){   
        //set heart icon regardless the requirements
        setHeartIcon();
        if (affection < 100){ //if affection is not full
            if (checkValidPat()){ //check whether the pat is valid
                //if valid, then affection for the current aranara + 1
                affection += 1;
                String col = "aff_" + aranaraName.toLowerCase();
                try{
                    Connection con = ConnectionProvider.getCon();
                    //update the affection in the database
                    PreparedStatement ps = con.prepareStatement("UPDATE user SET "+ col +" = ? WHERE userID = ?");
                    ps.setInt(1, affection);
                    ps.setString(2, this.userID);
                    ps.executeUpdate();
                    
                    //dialog message when successfully patted
                    String[] arama_msg = {"Good day Nara!", "Arama is happy today!", "Hehe, thanks Nara!"};
                    String[] ararycan_msg = {"Ahh! Ararycan is startled.", "Nara is friend of Aranara.", 
                        "Nara is the friend of forest."};
                    String[] arabalika_msg = {"Hmph.", "Don't pat Arabalika like that, Nara.", 
                        "Hmph. don't disturb Arabalika."};
                    
                    //randomize the dialog message
                    Random random = new Random();
                    int index = random.nextInt(3);
                    //choose the message based on the aranara name
                    String[] proper = null;
                    switch (aranaraName) {
                        case "Arama" -> proper = arama_msg;
                        case "Ararycan" -> proper = ararycan_msg;
                        case "Arabalika" -> proper = arabalika_msg;
                        default -> {
                        }
                    }
                    setDialogText(proper[index]); //set the dialogue text

                    //refresh progress bar based on the affection
                    affProgressBar.setValue(affection);
                    affectiontxt.setText(affection + "/100");

                }catch(Exception e){
                    e.printStackTrace();
                } 
            }
        }else{
            //if affection is full
            setDialogText("My affection is already full, Nara.");
        }
    }
    
    private boolean checkValidPat(){
        //one user can only pat all the aranaras up to three times a day
        String day = LocalDate.now().getDayOfWeek().name(); //get the day name
        String day_name = day.charAt(0) + day.substring(1,3).toLowerCase();
        
        if (!day_name.equals(patDay)){
            //if last patted is not today
            //set the pat amount to 1 because it is patted and update the pat database
            patDay = day_name;
            patAmount = 1;
            updatePatDatabase();
            return true; //can be patted 
        }
        else{
            if (patAmount < 3){
               //if the last patted is today but have not patted 3 times
               patAmount += 1;
               updatePatDatabase();
               return true;
            }else{
                //if the user already pat 3 times
                setDialogText("Today you have patted the Aranaras enough, Nara.");
                return false;
            }
        }
    }
    
    private void updatePatDatabase(){ 
        try{
            Connection con = ConnectionProvider.getCon();
            //update the pat amount and the pat day in the database
            PreparedStatement ps = con.prepareStatement("UPDATE user SET pat_day = ?, pat_amount = ? WHERE userID = ?");
            ps.setString(1, patDay);
            ps.setInt(2, patAmount);
            ps.setString(3, userID);
            ps.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    
    private void setDefaultBtnActionPerformed(){
        //get the default aranara name in lowercase
        String new_default_aranara = aranaraName.toLowerCase();
        //check whether the default aranara is the same as the one in 
        if (defaultAranara.equals(new_default_aranara)){
            setDialogText("I'm already the default one, Nara! :]");
            return; //return if yes
        }
        try{
            Connection con = ConnectionProvider.getCon();
            //update the default aranara in the database
            PreparedStatement ps = con.prepareStatement("UPDATE user SET default_aranara = ? WHERE userID = ?");
            ps.setString(1, new_default_aranara);
            ps.setString(2, this.userID);
            ps.executeUpdate();
            
            //get the background music corresponding to the new default aranara
            String bgmPath = "src/App/sound/";                            
            if (new_default_aranara.equals("arama")){
                bgmPath += "MelodyofHiddenSeeds.wav";
            }
            else if (new_default_aranara.equals("ararycan")){
                bgmPath += "IveNeverForgotten.wav"; 
            }else if (new_default_aranara.equals("arabalika")){
                bgmPath += "ForRiddlesForWonders.wav"; 
            }
            
            player.stop(); //stop the initial music
            player.loadMusic(bgmPath); //load the new music
            player.play(); //play the new music
            
            //success message
            JOptionPane.showMessageDialog(getContentPane(), "Default aranara updated successfully.");

        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    private void initBasedOnAranara(){
        try{
            //query from the user table in the database
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM user WHERE userID = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.userID);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                //get the current aranara name
                String name = aranaraName.toLowerCase();
                //get the affection of the current aranara
                int aff = rs.getInt("aff_"+name);
                affection = aff;
                //set it in the label and progress bar
                affectiontxt.setText(aff + "/100");
                affProgressBar.setValue(aff);
                
                //set the icon of the aranara based on the aranara name
                aranara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/"+ name +"_animated.gif")));
                
                //get pat amount and day
                patDay = rs.getString("pat_day");
                patAmount = rs.getInt("pat_amount");
                //get the default aranara of that user
                defaultAranara = rs.getString("default_aranara");
                
                //set the dialog box and text to be initially invisible
                dialog_box.setVisible(false);
                dialog_text.setVisible(false);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
            e.printStackTrace();
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        dialog_text = new WrappedLabel(400);
        dialog_box = new javax.swing.JLabel();
        heart_icon = new javax.swing.JLabel();
        aranara = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
        patBtn = new javax.swing.JLabel();
        setDefaultBtn = new javax.swing.JLabel();
        chatBtn = new javax.swing.JLabel();
        chattxt = new javax.swing.JLabel();
        affectiontxt = new javax.swing.JLabel();
        pattxt = new javax.swing.JLabel();
        setDefaulttxt = new javax.swing.JLabel();
        backChatBtn = new javax.swing.JLabel();
        affectionLevel = new javax.swing.JLabel();
        affProgressBar = new javax.swing.JProgressBar();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dialog_text.setFont(new java.awt.Font("Montserrat", 0, 20));
        jLayeredPane1.add(dialog_text);
        dialog_text.setBounds(45, 80, 400, 190);

        dialog_box.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/dialog_box.png"))); // NOI18N
        jLayeredPane1.add(dialog_box);
        dialog_box.setBounds(30, 30, 460, 240);

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 174, 510, 310));

        heart_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hearts.gif"))); // NOI18N
        getContentPane().add(heart_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 284, -1, -1));
        heart_icon.setVisible(false);

        aranara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/arama.png"))); // NOI18N
        getContentPane().add(aranara, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 239, -1, -1));

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_aranara.png"))); // NOI18N
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 17, -1, -1));
        backBtn.getAccessibleContext().setAccessibleName("");

        patBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/pat.png"))); // NOI18N
        getContentPane().add(patBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1123, 567, -1, -1));

        setDefaultBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/set_default.png"))); // NOI18N
        getContentPane().add(setDefaultBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(967, 567, -1, -1));

        chatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/chat.png"))); // NOI18N
        getContentPane().add(chatBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 567, -1, -1));

        chattxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        chattxt.setText("Chat");
        chattxt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(chattxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 670, -1, -1));

        affectiontxt.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        affectiontxt.setText("xxx/100");
        getContentPane().add(affectiontxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 60, -1, -1));

        pattxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        pattxt.setText("Pat");
        getContentPane().add(pattxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1153, 670, -1, -1));

        setDefaulttxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        setDefaulttxt.setText("Set As Default");
        getContentPane().add(setDefaulttxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(944, 670, -1, -1));

        backChatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_chat.png"))); // NOI18N
        getContentPane().add(backChatBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 318, -1, -1));

        affectionLevel.setFont(new java.awt.Font("Mochiy Pop One", 0, 20)); // NOI18N
        affectionLevel.setText("Affection Level");
        getContentPane().add(affectionLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 18, -1, -1));

        affProgressBar.setForeground(new java.awt.Color(255, 152, 170));
        affProgressBar.setToolTipText("");
        affProgressBar.setValue(10);
        affProgressBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(affProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 58, 343, 28));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_aranara.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar affProgressBar;
    private javax.swing.JLabel affectionLevel;
    private javax.swing.JLabel affectiontxt;
    private javax.swing.JLabel aranara;
    private javax.swing.JLabel backBtn;
    private javax.swing.JLabel backChatBtn;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel chatBtn;
    private javax.swing.JLabel chattxt;
    private javax.swing.JLabel dialog_box;
    private App.WrappedLabel dialog_text;
    private javax.swing.JLabel heart_icon;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel patBtn;
    private javax.swing.JLabel pattxt;
    private javax.swing.JLabel setDefaultBtn;
    private javax.swing.JLabel setDefaulttxt;
    // End of variables declaration//GEN-END:variables
}
