/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class CloneablePanelContact extends JPanel{  
    //panel display attributes
    private static int borderRadius;
    private static Color bgColor;
    private static int borderWidth;
    //contact attributes
    private String id;
    private String nameInput;
    private String phoneInput;
    //behaviour attributes
    private boolean isClicked = false;   
    private ContactsList home;
    
    //constructor
    public CloneablePanelContact(ContactsList home, int borderRadius, Color bgColor, int borderWidth, String id, 
            String nameInput, String phoneInput) {
        setLayout(null);
        this.borderRadius = borderRadius;
        this.bgColor = bgColor;
        this.borderWidth = borderWidth;
        this.id = id;
        this.nameInput = nameInput;
        this.phoneInput = phoneInput;
        this.home = home;
        setOpaque(false);
        
        //init the name label based on contact name
        JLabel title = new JLabel();
        title.setText(nameInput);        
        title.setForeground(Color.black);
        title.setFont(new Font("Montserrat Semibold", 0, 14));
        title.setBounds(10, 5, title.getPreferredSize().width, title.getPreferredSize().height);
        title.setPreferredSize(new Dimension(300, title.getPreferredSize().height));
        add(title);     
        
        //init the phone number label based on the phone number
        JLabel phone = new JLabel();
        phone.setText(phoneInput);        
        phone.setForeground(Color.black);
        phone.setFont(new Font("Montserrat", 0, 14));
        phone.setBounds(10, 30, title.getPreferredSize().width, title.getPreferredSize().height);
        add(phone); 
        
        //init the delete button
        JLabel deleteBtn = new JLabel();
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_contact.png")));
        deleteBtn.setBounds(235, 10, deleteBtn.getPreferredSize().width, deleteBtn.getPreferredSize().height);
        deleteBtn.addMouseListener(new MouseAdapter() {
            //delete btn behaviour
            @Override
            public void mouseClicked(MouseEvent e) { //when clicked
                deleteContact();               
            }
            @Override
            public void mouseEntered(MouseEvent e) { //when hovered
                deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_contact_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) { //when not hovered
                deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_contact.png")));
            }
        });
        add(deleteBtn);
    }
    
    private void deleteContact(){
        //confirm whether the user wants to delete or not
      String question = "Do you really want to delete " + nameInput + "?";
      int a = JOptionPane.showConfirmDialog(home.getContentPane(), question, "SELECT", JOptionPane.YES_OPTION);

        if (a == 0){
            //delete from database
            try{
                //run query and delete the contact based on its ID
                Connection conn = ConnectionProvider.getCon();
                String query = "DELETE FROM contact WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, id);

                ps.executeUpdate();
                
                //display success message
                String message = "Contact deleted successfully.";
                JOptionPane.showMessageDialog(home.getContentPane(), message); 
                //reload home 
                home.reloadSelf();

            }catch(SQLException se){
                //show error message
                JOptionPane.showMessageDialog(home.getContentPane(), se);
            }
        }
    }
    
    //get contact name
    public String getNameInput() {
        return nameInput;
    }
    //set contact name
    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }
    //get contact id
    public String getId() {
        return id;
    }
    //set contact id
    public void setId(String id) {
        this.id = id;
    }
    //get contact phone number
    public String getPhoneInput() {
        return phoneInput;
    }
    //set contact phone number
    public void setPhoneInput(String phoneInput) {
        this.phoneInput = phoneInput;
    }
    //get panel whether is clicked or not
    public boolean isIsClicked() {
        return isClicked;
    }
    //set panel whether it is clicked or not
    public void setIsClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(bgColor); // Set background color
        // Fill the area inside the border with the background color
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius); //the panel has round edges
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
        double strokeWidth;
        
        Graphics2D g2d = (Graphics2D) g.create();
        if (isClicked) {
            //set border as blue and thicker when the panel is clicked
            g2d.setColor(new Color(125,201,255));
            g2d.setStroke(new BasicStroke(4)); // Set border width
            strokeWidth = 4f;
        } else {
            //set the border as the default black
            g2d.setColor(Color.black);
            g2d.setStroke(new BasicStroke(borderWidth)); // Set border width
            strokeWidth = borderWidth;
        }
        
        //draw border
        int offset = (int) (strokeWidth / 2);
        g2d.drawRoundRect(offset, offset, getWidth() - 1 - offset * 2, getHeight() - 1 - offset * 2, borderRadius, borderRadius);
        
        g2d.dispose();
    }
}
