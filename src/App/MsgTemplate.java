/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class MsgTemplate extends javax.swing.JFrame {
    private String userID;
    private LinkedList<Message> msgList = new LinkedList<>();
    private CloneablePanelMsg currentPanel = null;
    private String IDtemp;
    private MsgTemplate home = (MsgTemplate) SwingUtilities.getRoot(this);

    /**
     * Creates new form msgTemplate
     */
    
    public MsgTemplate(String uID) {
        this.userID = uID;
        setResizable(false);
        setTitle("Message Template");
        initComponents();
        myinit();
    }
    
    private void initHover(){
        //when the user clicks the close button on the window
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //ask for confirmation
                int option = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    //go back to Contact Others frame
                    setVisible(false);
                    new ContactOthers(userID).setVisible(true);
                } 
            }
        });
        //the back button is the same as the close button 
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //asl for confirmation
                int option = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                //go back to Contact Others frame
                    setVisible(false);
                    new ContactOthers(userID).setVisible(true);
                } 
            }
            @Override
            public void mouseEntered(MouseEvent e) { //when hovered
                backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_msg_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {//when not hovered
                backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_msg.png")));
            }
        });
    }
    
    private void initDesign(){
        //set background color
        getContentPane().setBackground(Color.white);
        
        //init components
        backBtn = new JLabel();
        messagetxt = new JLabel("Message Template");
        newMsgField = new PlaceHolderTextField("Add new message", 0);
        setBtn = new App.ButtonCustom();
        
        //set size and layout
        setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //style the components and add them to the frame
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
                setBtnActionPerformed();
            }
        });
        getContentPane().add(setBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 75, 60, 34));     
        
        initHover();
        pack();
        setLocationRelativeTo(null);
    }
    
    private void myinit(){
        queryMsg(); //query the message templates
        contentPane = new JPanel();
        contentPane.setBackground(Color.white);
        contentPane.setLayout(null); // Use absolute layout
        setContentPane(contentPane);
        
        // Create the scroll pane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 130, 350, 200); // Set bounds for the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        contentPane.add(scrollPane);

        // Create the cloneable panel
        cloneablePanel = new JPanel(); // The initial panel inside scroll pane
        cloneablePanel.setLayout(null); // Use absolute layout
        cloneablePanel.setPreferredSize(new Dimension(400, 200)); // Set initial size
        cloneablePanel.setBounds(180, 200, 1200, 1500); // Set bounds for the initial panel
        cloneablePanel.setBackground(Color.white);
        scrollPane.setViewportView(cloneablePanel); // Set this panel as viewport's view
        
        //create cloned panels based on the message list
        createClonedPanels(msgList, msgList.size());        
        contentPane.setPreferredSize(new Dimension(400, 400));
        
        initDesign(); //initialize all the design components
    }
    
    private void createClonedPanels(LinkedList<Message> list, int size){
        //iterates over all message in the message list
        for(int i=0; i<size;i++){
            String id = list.get(i).getId();
            String msg = list.get(i).getMsg();
            
            // Create a new cloned panel
            CloneablePanelMsg clonedPanel = new CloneablePanelMsg(home, 20, Color.white, 2 ,id, msg);
            // Set width and height for the cloned panel
            int panelWidth = 290;
            int panelHeight = 90;

            // Calculate the x and y positions 
            int x = 30;
            int y = 10 + i * (panelHeight + 20);

            // Set the bounds for the cloned panel with your custom size
            clonedPanel.setBounds(x, y, panelWidth, panelHeight);
            clonedPanel.setBackground(new Color(246,252,254));
            
            clonedPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //if clicked and the cloned panel is the current panel
                    //then set the the current panel to be null
                    if (currentPanel == clonedPanel){
                       currentPanel.setIsClicked(false);
                       currentPanel = null;
                       clonedPanel.repaint();
                       //clear all fields
                       newMsgField.setText("");
                    }
                    else{
                        //if the current panel is not null
                        if (currentPanel != null ) {
                            currentPanel.setIsClicked(false);
                            currentPanel.repaint();
                        }
                        //set the cloned panel to be the new current panel
                        clonedPanel.setIsClicked(true);
                        currentPanel = clonedPanel;
                        clonedPanel.repaint();
                        //set current panel info in the fields
                        newMsgField.requestFocus();
                        newMsgField.setText(currentPanel.getMsgInput());
                    }    
                }
            });
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
    }
    
    private void queryMsg(){
        msgList.clear(); //clear the message list
        try{
            //query all the message template from the database
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM message_template WHERE userID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("message");
                //add it to the message list 
                Message msg = new Message(id, name);
                msgList.add(msg);
            }            
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    private void getLastID(){
        //get the last ID of message
        LinkedList<String> allIdList = new LinkedList<>();
        try{
            //get the message template id from the database
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT id FROM message_template");
            while(rs.next()){
                String text = rs.getString("id");
                allIdList.add(text);
            }
            //if it is the first message, set the id to be m1
            if(allIdList.isEmpty()){
                IDtemp = "m1";
            }
            else{
                String lastId = allIdList.getLast();
                String temp = "";
                for(int i=1; i<lastId.length(); i++){
                    temp = temp + lastId.charAt(i);
                }
                int idnow = Integer.parseInt(temp);
                idnow++; //add 1 from the last ID
                IDtemp = "m" + String.valueOf(idnow);//set the new ID as the last ID +1
            }            
        } catch(Exception e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }
    
    private void handleAdd(){
        //get the message
        String messageStr = newMsgField.getText();
        
        if (messageStr.equals("Add new message") || messageStr.equals("")){ //if still empty
            JOptionPane.showMessageDialog(getContentPane(), "Message is still empty.");
        }
        else{
            getLastID(); //get the last ID
            //add the new message to the message list
            Message new_msg = new Message(IDtemp, messageStr);
            msgList.add(new_msg);
            
            try{
                Connection con = ConnectionProvider.getCon();
                //insert the message to the database
                PreparedStatement ps = con.prepareStatement("INSERT INTO message_template VALUES(?,?,?)");
                ps.setString(1, IDtemp);
                ps.setString(2, userID);
                ps.setString(3, messageStr);
                ps.executeUpdate();
                
                //success message
                String message = "Message added successfully.";              
                JOptionPane.showMessageDialog(getContentPane(), message);

                //clear all the fields
                currentPanel = null;
                newMsgField.setText("");                
                reloadSelf(); //reload to show the new panel

            }catch(Exception e){
                e.printStackTrace();
            }
        }        
    }
    
    private void handleEdit(){
        //get the message
        String msgStr = newMsgField.getText();
        
        if (msgStr.equals("Add new message") || msgStr.equals("")){ //if still empty
            JOptionPane.showMessageDialog(getContentPane(), "Message is still empty.");
        }
        else{
            IDtemp = currentPanel.getId(); //get current panel's ID
            
            try{
                Connection con = ConnectionProvider.getCon();
                //update the message database
                String query = "UPDATE message_template SET message = ? WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, msgStr);
                ps.setString(2, IDtemp);
                ps.executeUpdate();
                
                //success message
                String message = "Message edited successfully.";              
                JOptionPane.showMessageDialog(getContentPane(), message);

                //clear all the field
                currentPanel = null;
                newMsgField.setText("");
                reloadSelf(); //refresh the panel view

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    private void setBtnActionPerformed(){
        if (currentPanel == null){
            handleAdd(); //insert data as new message 
        }else{
            handleEdit(); //update the data of the selected panel
        }        
    }
    
    public void reloadSelf(){
        queryMsg(); //get the updated message
        cloneablePanel.removeAll(); //remove all cloned panels
        createClonedPanels(msgList, msgList.size()); //recreate updated cloned panels
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
