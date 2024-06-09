/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Asus
 */
public class CloneablePanelContact extends JPanel{ 
    private static int panelCount = 0; 
    private static int borderRadius;
    private static Color bgColor;
    private static int borderWidth;
    private String id;
    private String nameInput;
    private String phoneInput;
    private boolean isClicked = false;   
    private ContactsList home;
    

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
        
        
        // the name label
        JLabel title = new JLabel();
        title.setText(nameInput);        
        title.setForeground(Color.black);
        title.setFont(new Font("Montserrat Semibold", 0, 14));
        title.setBounds(10, 5, title.getPreferredSize().width, title.getPreferredSize().height);
        title.setPreferredSize(new Dimension(300, title.getPreferredSize().height));
        add(title);     
        
        //the phone number label
        JLabel phone = new JLabel();
        phone.setText(phoneInput);        
        phone.setForeground(Color.black);
        phone.setFont(new Font("Montserrat", 0, 14));
        phone.setBounds(10, 30, title.getPreferredSize().width, title.getPreferredSize().height);
        add(phone); 
        
        //the delete button
        JLabel deleteBtn = new JLabel();
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_contact.png")));
        deleteBtn.setBounds(235, 10, deleteBtn.getPreferredSize().width, deleteBtn.getPreferredSize().height);
        deleteBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteContact();               
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_contact_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_contact.png")));
            }
        });
        add(deleteBtn);
    }
    
    private void deleteContact(){
      String question = "Do you really want to delete " + nameInput + "?";
      int a = JOptionPane.showConfirmDialog(home.getContentPane(), question, "SELECT", JOptionPane.YES_OPTION);

        if (a == 0){
            //delete from database
            try{
                Connection conn = ConnectionProvider.getCon();
                String query = "DELETE FROM contact WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, id);

                ps.executeUpdate();
                String message = "Contact deleted successfully.";
                JOptionPane.showMessageDialog(home.getContentPane(), message); 
                home.reloadSelf();

            }catch(SQLException se){
                JOptionPane.showMessageDialog(home.getContentPane(), se);
            }
        }
    }
    
    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneInput() {
        return phoneInput;
    }

    public void setPhoneInput(String phoneInput) {
        this.phoneInput = phoneInput;
    }

    public boolean isIsClicked() {
        return isClicked;
    }

    public void setIsClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(bgColor); // Set background color
        // Fill the area inside the border with the background color
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
        double strokeWidth;
        
        Graphics2D g2d = (Graphics2D) g.create();
        if (isClicked) {
            g2d.setColor(new Color(125,201,255));
            g2d.setStroke(new BasicStroke(4)); // Set border width
            strokeWidth = 4f;
        } else {
            g2d.setColor(Color.black);
            g2d.setStroke(new BasicStroke(borderWidth)); // Set border width
            strokeWidth = borderWidth;
        }
                
        int offset = (int) (strokeWidth / 2);
        g2d.drawRoundRect(offset, offset, getWidth() - 1 - offset * 2, getHeight() - 1 - offset * 2, borderRadius, borderRadius);
        
        g2d.dispose();
    }
}
