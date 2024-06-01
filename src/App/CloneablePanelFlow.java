/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import DatabaseConnection.ConnectionProvider;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
/**
 *
 * @author asus
 */
public class CloneablePanelFlow extends JPanel{ 
    private static int panelCount = 0; 
    private static int borderRadius;
    private static Color bgColor;
    private static int borderWidth;
    private String nameInput;
    private int dayFromInput;
    private int dayToInput;
    private String id;
    private String typeInput;
    private String colorInput;
    
    
    private String appendPlusToDay(int value){
        if (value > 0){
            return "+ " + String.valueOf(value);
        }
        else if (value == 0){
            return "-Day";
        }
        else{
            return "- " + String.valueOf(value - 2*value);
        }
    }

    public CloneablePanelFlow(int borderRadius, Color bgColor, int borderWidth, String id, 
            String nameInput, String typeInput, int dayFromInput, int dayToInput, String colorInput) {
        setLayout(null);
        this.borderRadius = borderRadius;
        this.bgColor = bgColor;
        this.borderWidth = borderWidth;
        this.id = id;
        this.nameInput = nameInput;
        this.dayFromInput = dayFromInput;
        this.dayToInput = dayToInput;
        this.typeInput = typeInput;
        this.colorInput = colorInput;
        setOpaque(false);
        
        //hash map that save the color of all possible flow colors
        HashMap<String, Color> color_map = new HashMap<>();
       
        //insert the color name and the corresponding color
        color_map.put("Blue", new Color(80, 213, 255));
        color_map.put("Red", new Color(255, 164, 164));
        color_map.put("Orange", new Color(255, 182, 128));
        color_map.put("Yellow", new Color(248, 232, 87));
        color_map.put("Green", new Color(153, 237, 113));
        color_map.put("Purple", new Color(218, 157, 255));
        color_map.put("Pink", new Color(255, 125, 203));
        color_map.put("Brown", new Color(223, 170, 106));
                             
        
        // Example content - you can add whatever components you need
        WrappedLabel title = new WrappedLabel(270);
        title.setText(nameInput);
        title.setFont(new Font("Montserrat SemiBold", 0, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(18, 15, title.getPreferredSize().width, title.getPreferredSize().height);
        add(title);
        
        
        //the day label
        JLabel total_day = new JLabel();
        total_day.setFont(new Font("Montserrat", 0, 18));
        
        String dayFrom = appendPlusToDay(dayFromInput);
        String dayTo = appendPlusToDay(dayToInput);
        
        if (typeInput.equals("One-day event")){
            total_day.setText("(D " + dayFrom + ")");
        }
        else if (typeInput.equals("Multiple-day event")){
            total_day.setText("(D " + dayFrom + ") to (D " + dayTo + ")");
        }
        
        setComponentBounds(total_day, 15, title.getY()+title.getHeight()+30, total_day.getPreferredSize().width+10, total_day.getPreferredSize().height);
        add(total_day);
        
        
        //the color label
        JLabel color_label = new JLabel();
        color_label.setBackground(color_map.get(colorInput));
        color_label.setOpaque(true);
        setComponentBounds(color_label, 230, title.getY()+title.getHeight()+30, 33, 23);
        add(color_label);
        
        
        
//        ButtonCustom editButton = new App.ButtonCustom();
//        editButton.setForeground(new java.awt.Color(255, 255, 255));
//        editButton.setText("Edit");
//        editButton.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
//        editButton.setBorderColor(new java.awt.Color(31, 139, 217));
//        editButton.setBorderColorOver(new java.awt.Color(125, 201, 255));
//        editButton.setColor2(Color.white);
//        editButton.setColor(new Color(31, 139, 217));
//        editButton.setColorClick2(Color.white);
//        editButton.setColorClick(new Color(125, 201, 255));
//        editButton.setColorOver(new Color(125, 201, 255));
//        editButton.setColorOver2(Color.white);
//        editButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); 
//        editButton.setRadius(20);
//        editButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                editButtonActionPerformed(evt);
//            }
//        });
//        setComponentBounds(editButton, 95, 189, editButton.getPreferredSize().width+25, editButton.getPreferredSize().height+7);
//        add(editButton);
        
    }
    
    public void setComponentBounds(Component component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height); // Set the position and size of the component
    }
    
//    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
////        String str = "Do you really want to delete " + nameInput + "?";
//        AddWorkflowMenu home = (AddWorkflowMenu) SwingUtilities.getWindowAncestor(this);
//      JOptionPane.showMessageDialog(home.getContentPane(), "delete berhaisl");
////        int a = JOptionPane.showConfirmDialog(home.getContentPane(), str, "SELECT", JOptionPane.YES_OPTION);
////        if(a==0){
////            try{
////                Connection con = ConnectionProvider.getCon();
////                PreparedStatement ps = con.prepareStatement("delete from quiz where id=?");
////                ps.setString(1, id);
////                ps.executeUpdate();
////
////                JOptionPane.showMessageDialog(home.getContentPane(), "Successfully deleted");
////                home.reloadSelf();
////            
////            }catch(Exception e){
////                JOptionPane.showMessageDialog(home.getContentPane(), e);
////            }
////        }
//    }
    
    
    
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

