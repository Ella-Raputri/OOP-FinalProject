/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import DatabaseConnection.ConnectionProvider;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.LinkedList;
/**
 *
 * @author asus
 */
public class CloneablePanelAdmin extends JPanel{ 
    private static int panelCount = 0; 
    private static int borderRadius;
    private static Color bgColor;
    private static int borderWidth;
    private String id;
    private String titleInput;
    private int checkpointInput;

    public CloneablePanelAdmin(int borderRadius, Color bgColor, int borderWidth, String id, String titleInput, int checkpointInput) {
        setLayout(null);
        this.borderRadius = borderRadius;
        this.bgColor = bgColor;
        this.borderWidth = borderWidth;
        this.id = id;
        this.titleInput = titleInput;
        this.checkpointInput = checkpointInput;
        setOpaque(false);
             
                
        // Example content - you can add whatever components you need
        WrappedLabel title = new WrappedLabel(250);
        title.setText(titleInput);
        title.setFont(new Font("Montserrat SemiBold", 0, 36));
        setComponentBounds(title, 25, 27, title.getPreferredSize().width, title.getPreferredSize().height);
        add(title);
        
        
        JLabel total_check = new JLabel();
        total_check.setFont(new Font("Montserrat", 0, 24));
        total_check.setText(checkpointInput + " minutes");
        setComponentBounds(total_check, 25, title.getY()+title.getHeight()+50, total_check.getPreferredSize().width+10, total_check.getPreferredSize().height);
        add(total_check);
        
        ButtonCustom deleteButton = new App.ButtonCustom();
        deleteButton.setBorder(null);
        deleteButton.setBorderColor(bgColor);
        deleteButton.setBorderColorOver(bgColor);
        deleteButton.setBorderColorNotOver(bgColor);
        deleteButton.setText("–");
        deleteButton.setColor2(new Color(31, 139, 217));
        deleteButton.setColor(Color.white);
        deleteButton.setColorClick2(new Color(167, 204, 231));
        deleteButton.setColorClick(Color.white);
        deleteButton.setColorOver(Color.white);
        deleteButton.setColorOver2(new Color(167, 204, 231));
        deleteButton.setFont(new java.awt.Font("Montserrat Black", 0, 44)); 
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        setComponentBounds(deleteButton, 250, 10, deleteButton.getPreferredSize().width, deleteButton.getPreferredSize().height);
        add(deleteButton);
        
        
        ButtonCustom editButton = new App.ButtonCustom();
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
        editButton.setBorderColor(new java.awt.Color(31, 139, 217));
        editButton.setBorderColorOver(new java.awt.Color(167, 204, 231));
        editButton.setColor2(Color.white);
        editButton.setColor(new Color(31, 139, 217));
        editButton.setColorClick2(Color.white);
        editButton.setColorClick(new Color(167, 204, 231));
        editButton.setColorOver(new Color(167, 204, 231));
        editButton.setColorOver2(Color.white);
        editButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); 
        editButton.setRadius(20);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        setComponentBounds(editButton, 68, 189, editButton.getPreferredSize().width+25, editButton.getPreferredSize().height+7);
        add(editButton);
        
    }
    
    public void setComponentBounds(Component component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height); // Set the position and size of the component
    }
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
//        String str = "Do you really want to delete " + titleInput + "?";
        AddWorkflowMenu home = (AddWorkflowMenu) SwingUtilities.getWindowAncestor(this);
      JOptionPane.showMessageDialog(home.getContentPane(), "delete berhaisl");
//        int a = JOptionPane.showConfirmDialog(home.getContentPane(), str, "SELECT", JOptionPane.YES_OPTION);
//        if(a==0){
//            try{
//                Connection con = ConnectionProvider.getCon();
//                PreparedStatement ps = con.prepareStatement("delete from quiz where id=?");
//                ps.setString(1, id);
//                ps.executeUpdate();
//
//                JOptionPane.showMessageDialog(home.getContentPane(), "Successfully deleted");
//                home.reloadSelf();
//            
//            }catch(Exception e){
//                JOptionPane.showMessageDialog(home.getContentPane(), e);
//            }
//        }
    }
    
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        AddWorkflowMenu home = (AddWorkflowMenu) SwingUtilities.getWindowAncestor(this);
      JOptionPane.showMessageDialog(home.getContentPane(), "eddit berhaisl");
        //home.goToEdit(id);
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
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK); // Set border color
        g2d.setStroke(new BasicStroke(borderWidth)); // Set border width
        g2d.drawRoundRect(borderWidth / 2, borderWidth / 2, getWidth() - borderWidth, getHeight() - borderWidth, borderRadius, borderRadius); // Adjust position and size based on border width
        g2d.dispose();
    }
}

