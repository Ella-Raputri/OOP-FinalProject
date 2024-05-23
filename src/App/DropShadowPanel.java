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
import javax.swing.JPanel;


public class DropShadowPanel extends JPanel {
    private int shadowSize = 8;
    private Color shadowColor = new java.awt.Color (0,0,0,25);
    private int arcWidth = 20;
    private int arcHeight = 20;

    public DropShadowPanel(int shadowsize, java.awt.Color shadowcolor, int arcwidth, int archeight) {
        this.shadowSize = shadowsize;
        this.shadowColor = shadowcolor;
        this.arcWidth = arcwidth;
        this.arcHeight = archeight;
        setOpaque(false);
    }
    
    public DropShadowPanel() {
        setOpaque(false);
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
//        g2.setStroke(new BasicStroke(2)); // Border thickness
//        g2.drawRoundRect(0, 0, shadow_width, shadow_height, arcWidth, arcHeight);

        g2.dispose();
    }
    
    @Override
    protected void paintBorder(Graphics g) {
        // Optional: paint border here
    }
}
