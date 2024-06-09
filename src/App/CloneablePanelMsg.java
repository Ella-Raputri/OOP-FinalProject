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
public class CloneablePanelMsg extends JPanel{ 
    private static int panelCount = 0; 
    private static int borderRadius;
    private static Color bgColor;
    private static int borderWidth;
    private String id;
    private String msgInput;
    private boolean isClicked = false;   
    private MsgTemplate home;
    

    public CloneablePanelMsg(MsgTemplate home, int borderRadius, Color bgColor, int borderWidth, String id, 
            String msgInput) {
        setLayout(null);
        this.borderRadius = borderRadius;
        this.bgColor = bgColor;
        this.borderWidth = borderWidth;
        this.id = id;
        this.msgInput = msgInput;
        this.home = home;
        setOpaque(false);
        
        
        // the name label
        WrappedLabel msg = new WrappedLabel(250);
        msg.setText(msgInput);        
        msg.setForeground(Color.black);
        msg.setFont(new Font("Montserrat", 0, 14));
        msg.setBounds(10, 5, msg.getPreferredSize().width, msg.getPreferredSize().height);
        msg.setPreferredSize(new Dimension(300, msg.getPreferredSize().height));
        add(msg);   
        
        //the delete button
        JLabel deleteBtn = new JLabel();
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_contact.png")));
        deleteBtn.setBounds(270, 10, deleteBtn.getPreferredSize().width, deleteBtn.getPreferredSize().height);
        deleteBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteMsg();               
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
    
    private void deleteMsg(){
      String question = "Do you really want to delete " + msgInput + "?";
      int a = JOptionPane.showConfirmDialog(home.getContentPane(), question, "SELECT", JOptionPane.YES_OPTION);

        if (a == 0){
            //delete from database
            try{
                Connection conn = ConnectionProvider.getCon();
                String query = "DELETE FROM message_template WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, id);

                ps.executeUpdate();
                String message = "Message deleted successfully.";
                JOptionPane.showMessageDialog(home.getContentPane(), message); 
                home.reloadSelf();

            }catch(SQLException se){
                JOptionPane.showMessageDialog(home.getContentPane(), se);
            }
        }
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getMsgInput() {
        return msgInput;
    }

    public void setMsgInput(String msgInput) {
        this.msgInput = msgInput;
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
