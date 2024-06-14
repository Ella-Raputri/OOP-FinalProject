/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AranaraDropShadowPanel extends JPanel {
    private final int shadowSize = 8;
    private final Color shadowColor = new java.awt.Color (0,0,0,25);
    private final int arcWidth = 20;
    private final int arcHeight = 20;
    private String aranaraName;
    private int aranaraAffection;
    
    public AranaraDropShadowPanel(String name, int affection, String userID, AranaraMenu home, MusicPlayer player) {
        this.aranaraName = name;
        this.aranaraAffection = affection;
        
        if (name.equals("Arama") || affection > 0){
            setOpaque(false);
            setLayout(null);
            setBackground(Color.white);

            //add the name of the aranara
            JLabel name_label = new JLabel(aranaraName);
            name_label.setBounds(35, 33, 200, 48); // Set the position and size of the label
            name_label.setFont(new java.awt.Font("Montserrat SemiBold", 0, 32)); 
            name_label.setForeground(new java.awt.Color(0,0,0));
            add(name_label);

            //add affection text
            JLabel affection_label = new JLabel ("Affection: " + aranaraAffection + "/100");
            affection_label.setBounds(35, 100, 220, 36); // Set the position and size of the label
            affection_label.setFont(new java.awt.Font("Montserrat", 0, 24)); 
            affection_label.setForeground(new java.awt.Color(0,0,0));
            add(affection_label);

            //add button
            App.ButtonCustom visit_btn = new App.ButtonCustom();
            visit_btn.setForeground(new java.awt.Color(255, 255, 255));
            visit_btn.setText("Visit");
            visit_btn.setBorderColor(new java.awt.Color(31, 139, 217));
            visit_btn.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
            visit_btn.setBorderColorOver(new java.awt.Color(109, 207, 251));
            visit_btn.setColor(new java.awt.Color(31, 139, 217));
            visit_btn.setColor2(java.awt.Color.white);
            visit_btn.setColorClick(new java.awt.Color(109, 207, 251));
            visit_btn.setColorClick2(java.awt.Color.white);
            visit_btn.setColorOver(new java.awt.Color(109, 207, 251));
            visit_btn.setColorOver2(java.awt.Color.white);
            visit_btn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
            visit_btn.setRadius(50);
            visit_btn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    visitBtnActionPerformed(userID, home, player);
                }
            });
            visit_btn.setBounds(68, 189, 135, 53);
            add(visit_btn); 
        }
        else{
            setOpaque(false);
            setLayout(null);
            setBackground(new Color(234,234,234));
            
            //set the requirements for each aranara
            int requirement =0;
            if (name.equals("Ararycan")){
                requirement = 100;
            }else if (name.equals("Arabalika")){
                requirement = 200;
            }
            //add the lock icon
            JLabel lock_label = new JLabel();
            lock_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/locked.png")));
            lock_label.setBounds(105, 68, 66, 88); // Set the position and size of the label\
            add(lock_label);

            //add the explanation text
            WrappedLabel explanation = new WrappedLabel(250);
            explanation.setText("Reach a total affection of "+ requirement + " to unlock");
            explanation.setBounds(13, 180, 257, 60); // Set the position and size of the label
            explanation.setFont(new java.awt.Font("Montserrat Medium", 0, 20)); 
            explanation.setForeground(new java.awt.Color(155, 154, 154));
            add(explanation);
        }      
    }
    
    private void visitBtnActionPerformed(String uid, AranaraMenu home, MusicPlayer player){
        home.setVisible(false);
        new EditAranara(aranaraName, uid, player).setVisible(true);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        int x = shadowSize;
        int y = shadowSize;
        int shadow_width = getWidth() - shadowSize * 2;
        int shadow_height = getHeight() - shadowSize * 2;

        // Enable anti-aliasing for better quality
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw shadow
        g2.setColor(shadowColor);
        g2.fillRoundRect(x, y, shadow_width, shadow_height, arcWidth, arcHeight);

        // Draw the panel itself
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, shadow_width, shadow_height, arcWidth, arcHeight);
        
        //draw the border
        g2.setColor(Color.BLACK); // You can change the border color as needed
        Graphics2D border = (Graphics2D) g;
        Stroke oldStroke = border.getStroke(); //get the original stroke
        
        border.setStroke(new BasicStroke(1)); //the thickness of the border
        g.setColor(getForeground());
        g.drawRoundRect(1, 1, shadow_width, shadow_height, arcWidth, arcHeight); //draw the round rect for the border
        
        g2.setStroke(oldStroke); // Restore the original stroke
        g2.dispose();
    }
    
    @Override
    protected void paintBorder(Graphics g) {
        // Optional: paint border here
    }
}
