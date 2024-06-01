/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import DatabaseConnection.ConnectionProvider;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.LinkedList;
/**
 *
 * @author asus
 */
public class CloneablePanelWorkflow extends JPanel{ 
    private static int panelCount = 0; 
    private static int borderRadius;
    private static Color bgColor;
    private static int borderWidth;
    private String id;
    private String titleInput;
    private int checkpointInput;

    public CloneablePanelWorkflow(int borderRadius, Color bgColor, int borderWidth, String id, String titleInput, int checkpointInput) {
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
        
        JTextField titleField = new JTextField();
        titleField.setVisible(false);
        titleField.setFont(new Font("Montserrat SemiBold", 0, 36));
        setComponentBounds(titleField, 25, 27, titleField.getPreferredSize().width, titleField.getPreferredSize().height);
        add(titleField);    
        
        title.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //switch to textfield
                titleField.setText(title.getText());
                titleField.setVisible(true);
                title.setVisible(false);
                
                Dimension preferredSize = title.getPreferredSize();
                setComponentBounds(titleField, 25, 27, preferredSize.width + 10, preferredSize.height);  // Adding some extra width
                
                titleField.requestFocus();
                titleField.selectAll();
            }
        });
        
        titleField.addActionListener(new ActionListener() {
            //switch to label
            @Override
            public void actionPerformed(ActionEvent e) {
                title.setText(titleField.getText());
                
                //update name in the database
                updateNameDatabase(title);
                
                //make the label visible again
                title.setVisible(true);
                titleField.setVisible(false);                
                setComponentBounds(title, 25, 27, title.getPreferredSize().width, title.getPreferredSize().height);
            }
        });
        
        JLabel total_check = new JLabel();
        total_check.setFont(new Font("Montserrat", 0, 24));
        total_check.setText("Total: " + checkpointInput + " checkpoints");
        setComponentBounds(total_check, 25, title.getY()+title.getHeight()+50, total_check.getPreferredSize().width+10, total_check.getPreferredSize().height);
        add(total_check);
        
        ButtonCustom deleteButton = new App.ButtonCustom();
        deleteButton.setBorder(null);
        deleteButton.setBorderColor(bgColor);
        deleteButton.setBorderColorOver(bgColor);
        deleteButton.setBorderColorNotOver(bgColor);
        deleteButton.setText("–");
        deleteButton.setColor2(new Color(31, 139, 217));
        deleteButton.setForeground(new Color(31, 139, 217));
        deleteButton.setColor(Color.white);
        deleteButton.setColorClick2(new Color(125, 201, 255));
        deleteButton.setColorClick(Color.white);
        deleteButton.setColorOver(Color.white);
        deleteButton.setColorOver2(new Color(125, 201, 255));
        deleteButton.setFont(new java.awt.Font("Montserrat Black", 0, 36)); 
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        setComponentBounds(deleteButton, 255, 10, deleteButton.getPreferredSize().width, deleteButton.getPreferredSize().height);
        add(deleteButton);
        
        
        ButtonCustom editButton = new App.ButtonCustom();
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
        editButton.setBorderColor(new java.awt.Color(31, 139, 217));
        editButton.setBorderColorOver(new java.awt.Color(125, 201, 255));
        editButton.setColor2(Color.white);
        editButton.setColor(new Color(31, 139, 217));
        editButton.setColorClick2(Color.white);
        editButton.setColorClick(new Color(125, 201, 255));
        editButton.setColorOver(new Color(125, 201, 255));
        editButton.setColorOver2(Color.white);
        editButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); 
        editButton.setRadius(20);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        setComponentBounds(editButton, 95, 189, editButton.getPreferredSize().width+25, editButton.getPreferredSize().height+7);
        add(editButton);
        
        
        
//        JLabel editTitle = new JLabel();
//        editTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_title.png"))); 
//        setComponentBounds(editTitle, title.getX() + title.getWidth() + 15, title.getY()+10, 22, 27);
//        add(editTitle);     
//        
//        editTitle.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                //
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                editTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_title_hover.png")));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                editTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_title.png")));
//            }
//        });
    }
    
    private void updateNameDatabase(JLabel nameLabel){
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            PreparedStatement ps = con.prepareStatement("UPDATE workflow SET title = ? WHERE workflowID = ?");
            ps.setString(1, nameLabel.getText());
            ps.setString(2, id);
            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void setComponentBounds(Component component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height); // Set the position and size of the component
    }
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String message = "Do you really want to delete " + titleInput + "?";
        AddWorkflowMenu home = (AddWorkflowMenu) SwingUtilities.getWindowAncestor(this);
        int a = JOptionPane.showConfirmDialog(home.getContentPane(), message, "SELECT", JOptionPane.YES_OPTION);
        
        if(a==0){
            try{
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("DELETE FROM workflow where workflowID = ?");
                ps.setString(1, id);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(home.getContentPane(), "Successfully deleted");
                home.reload();
            
            }catch(Exception e){
                JOptionPane.showMessageDialog(home.getContentPane(), e);
            }
        }
    }
    
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        AddWorkflowMenu home = (AddWorkflowMenu) SwingUtilities.getWindowAncestor(this);
        home.goToEdit(id);
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
