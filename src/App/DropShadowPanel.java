/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;


public class DropShadowPanel extends JPanel {
    private int shadowSize = 10;
    private Color shadowColor = Color.GRAY;
    private int arcWidth = 20;
    private int arcHeight = 20;

    public DropShadowPanel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        int x = shadowSize;
        int y = shadowSize;
        int width = getWidth() - shadowSize * 2;
        int height = getHeight() - shadowSize * 2;

        // Enable anti-aliasing for better quality
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw shadow
        g2.setColor(shadowColor);
        g2.fillRoundRect(x, y, width, height, arcWidth, arcHeight);

        // Draw the panel itself
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, arcWidth, arcHeight);

        g2.dispose();
    }
    
    @Override
    protected void paintBorder(Graphics g) {
        // Optional: paint border here
    }
}
