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
public class ContactsList extends javax.swing.JFrame {
    private String userID;
    private LinkedList<Contact> contactList= new LinkedList<>();
    private CloneablePanelContact currentPanel = null;
    private String IDtemp;
    private ContactsList home = (ContactsList) SwingUtilities.getRoot(this);
    /**
     * Creates new form ContactsList
     */
    
    public ContactsList(String uID) {
        this.userID = uID;
        setResizable(false);
        setTitle("Contacts List");
        initComponents();
        myinit();
    }
    
    private void initHover(){
        //set the window close operation
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //ask for confirmation then
                // go back to ContactOthers when user presses close
                int option = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    new ContactOthers(userID).setVisible(true);
                } 
            }
        });
        //the back button function is the same with the window close operation
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ask for confirmation
                int option = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    //go back to contact others
                    setVisible(false);
                    new ContactOthers(userID).setVisible(true);
                } 
            }
            @Override
            public void mouseEntered(MouseEvent e) { //when hovered
                backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_msg_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) { //when not hovered
                backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_msg.png")));
            }
        });
    }
    
    private void myinit(){
        queryContact(); //query all the contacts 
        
        //create the content pane
         contentPane = new JPanel();
         contentPane.setBackground(Color.white);
        contentPane.setLayout(null); // Use absolute layout
        setContentPane(contentPane);
        
        // Create the scroll pane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 174, 336, 230); // Set bounds for the scroll pane
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
        
        //create the cloneable panel based on the contact list
        createClonedPanels(contactList, contactList.size());
        
        contentPane.setPreferredSize(new Dimension(400, 480));
        
        initDesign(); //initialize all the design components
    }
    
    private void createClonedPanels(LinkedList<Contact> list, int size){
        //create the cloneable panels by iterating over the contact inside the contact list
        for(int i=0; i<size;i++){
            String id = list.get(i).getId();
            String name = list.get(i).getName();
            String phone = list.get(i).getPhone();
            
            // Create a new cloned panel
            CloneablePanelContact clonedPanel = new CloneablePanelContact(home, 20, 
                    Color.white, 2 ,id, name, phone);
            // Set width and height for the cloned panel
            int panelWidth = 255;
            int panelHeight = 60;

            // Calculate the x and y positions 
            int x = 10;
            int y = 10 + i * (panelHeight + 20);

            // Set the bounds and background for the cloned panel 
            clonedPanel.setBounds(x, y, panelWidth, panelHeight);
            clonedPanel.setBackground(new Color(246,252,254));
            
            //the cloned panel can be clicked
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
                       nameField.setText("");
                       phoneField.setText("");
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
                        nameField.requestFocus();
                        nameField.setText(currentPanel.getNameInput());
                        phoneField.setText(currentPanel.getPhoneInput());
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
    
    private void queryContact(){
        contactList.clear(); //clear the contact list
        try{
            //query all the contacts from the database
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM contact WHERE userID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                //add it to the contact list
                Contact contact = new Contact(id, name, phone);
                contactList.add(contact);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    
    private void initDesign(){
        //set background color
        getContentPane().setBackground(Color.white);
        //init components
        backBtn = new JLabel();
        contacttxt = new JLabel("Contact");
        nameField = new PlaceHolderTextField("New Name", 0);
        phoneField = new PlaceHolderTextField("Phone Number", 0);
        setBtn = new App.ButtonCustom();
        
        //set size and layout
        setPreferredSize(new java.awt.Dimension(400, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //style components and add them to the frame
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_msg.png"))); // NOI18N
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));
        
        contacttxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        contacttxt.setForeground(new java.awt.Color(0,0,0));
        getContentPane().add(contacttxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 36, -1, -1));
        
        nameField.setBackground(new java.awt.Color(234, 234, 234));
        nameField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        nameField.setForeground(new java.awt.Color(155, 154, 154));
        nameField.setBorder(new EmptyBorder(new Insets(5, 15, 5, 10)));
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 77, 347, 32));
        
        phoneField.setBackground(new java.awt.Color(234, 234, 234));
        phoneField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        phoneField.setForeground(new java.awt.Color(155, 154, 154));
        phoneField.setBorder(new EmptyBorder(new Insets(5, 15, 5, 10)));
        getContentPane().add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 347, 32));
        
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
        getContentPane().add(setBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 42, 60, 24));     
        
        initHover();
        pack();
        setLocationRelativeTo(null);
    }

    private void getLastID(){
        //get the last ID of the contact
        LinkedList<String> allIdList = new LinkedList<>();
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT id FROM contact");
            while(rs.next()){
                String text = rs.getString("id");
                allIdList.add(text);
            }
            //if it is the first contact, then the ID will be c1
            if(allIdList.isEmpty()){
                IDtemp = "c1";
            }
            else{
                String lastId = allIdList.getLast();
                String temp = "";
                for(int i=1; i<lastId.length(); i++){
                    temp = temp + lastId.charAt(i);
                }
                int idnow = Integer.parseInt(temp);
                idnow++; //the last ID + 1
                IDtemp = "c" + String.valueOf(idnow); //set the new ID to it
            }
            
        } catch(Exception e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }
    
    private boolean isPhoneInteger(String test){
        try{
            //for every character in the phone number
            for (int i = 0; i < test.length(); i++){
                String s = test.charAt(i) + "";
                //try to parse it
                int a = Integer.parseInt(s);
            }            
        }
        catch(NumberFormatException e){
            //if exception caught, then there is character that is not integer
            return false; 
        }
        return true; //return true if no error
    }
    
    private void handleAdd(){
        //get the data in the name and phone field
        String nameStr = nameField.getText();
        String phoneStr = phoneField.getText();
        
        if (nameStr.equals("New Name") || nameStr.equals("")){ //empty name
            JOptionPane.showMessageDialog(getContentPane(), "Name is still empty.");
        }
        else if (phoneStr.equals("Phone Number") || phoneStr.equals("")){ //empty phone number
            JOptionPane.showMessageDialog(getContentPane(), "Phone number is still empty.");
        }
        else if (!isPhoneInteger(phoneStr)){ //character in the phone number is not integer
            JOptionPane.showMessageDialog(getContentPane(), "Phone number is not valid.");           
        }
        else{
            getLastID(); //get the last id for the new contact
            //add the new contact to the contact list
            Contact new_contact = new Contact(IDtemp, nameStr, phoneStr);
            contactList.add(new_contact);
            
            try{
                Connection con = ConnectionProvider.getCon();
                //insert the new contact to the database
                PreparedStatement ps = con.prepareStatement("INSERT INTO contact VALUES(?,?,?,?)");
                ps.setString(1, IDtemp);
                ps.setString(2, userID);
                ps.setString(3, nameStr);
                ps.setString(4, phoneStr);

                ps.executeUpdate();
                //success message
                String message = "Contact added successfully.";              
                JOptionPane.showMessageDialog(getContentPane(), message);

                //clear all the field
                nameField.setText("");
                phoneField.setText("");
                
                //reload to show the cloned panels of the added contact
                reloadSelf(); 

            }catch(Exception e){
                JOptionPane.showMessageDialog(getContentPane(), e);
            }
        }        
    }
    
    private void handleEdit(){
        //get the name and phone from the field
        String nameStr = nameField.getText();
        String phoneStr = phoneField.getText();
        
        if (nameStr.equals("New Name") || nameStr.equals("")){ //if the name is empty
            JOptionPane.showMessageDialog(getContentPane(), "Name is still empty.");
        }
        else if (phoneStr.equals("Phone Number") || phoneStr.equals("")){ //if the phone is empty
            JOptionPane.showMessageDialog(getContentPane(), "Phone number is still empty.");
        }
        else if (!isPhoneInteger(phoneStr)){ //if exists non integer character in the phone number
            JOptionPane.showMessageDialog(getContentPane(), "Phone number is not valid.");           
        }
        else{
            IDtemp = currentPanel.getId(); //get ID of current selected panel
            
            try{
                Connection con = ConnectionProvider.getCon();
                //update it in the database
                String query = "UPDATE contact SET name = ?, phone = ? WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, nameStr);
                ps.setString(2, phoneStr);
                ps.setString(3, IDtemp);
                ps.executeUpdate();
                
                //success message
                String message = "Contact edited successfully.";              
                JOptionPane.showMessageDialog(getContentPane(), message);

                //clear all the field
                nameField.setText("");
                phoneField.setText("");

                //refresh the cloned panels
                reloadSelf();

            }catch(Exception e){
                JOptionPane.showMessageDialog(getContentPane(), e);
            }
        }
    }
    
    private void setBtnActionPerformed(){
        //if there is no selected panel
        if (currentPanel == null){
            handleAdd(); //add a new contact
        }else{
            handleEdit(); //edit or update the contact
        }        
    }
    
    public void reloadSelf(){
        queryContact(); //get the updated contact list
        cloneablePanel.removeAll(); //remove all cloned panels
        createClonedPanels(contactList, contactList.size()); //recreate the cloned panels
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
    private javax.swing.JLabel contacttxt;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField phoneField;
    private App.ButtonCustom setBtn;
    private JPanel contentPane;
    private JPanel cloneablePanel;
    private JScrollPane scrollPane;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
