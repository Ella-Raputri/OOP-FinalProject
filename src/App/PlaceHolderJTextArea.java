/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;

/**
 *
 * @author Asus
 */
public class PlaceHolderJTextArea extends JTextArea{
    
    private String placeholder;

    public PlaceHolderJTextArea(String placeholder) {
        this.placeholder = placeholder;

        // Add focus listener to repaint the field on focus gain/loss
        setBorder(null);
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setText("");
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the placeholder text if needed
        if (getText().isEmpty() && !isFocusOwner()) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.GRAY); // Set the color for the placeholder text
            //g2d.setFont(getFont().deriveFont(Font.ITALIC)); // Set the font for the placeholder text
            int padding = (getHeight() - getFont().getSize()) / 2;
            
            g2d.drawString(placeholder, getInsets().left, padding);
            g2d.dispose();
        }
    }
    
}
