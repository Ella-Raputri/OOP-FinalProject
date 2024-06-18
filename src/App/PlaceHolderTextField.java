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
import javax.swing.JTextField;
/**
 *
 * @author Asus
 */
public class PlaceHolderTextField extends JTextField{
    //attribute
    private String placeholder;
    private int adder;

    public PlaceHolderTextField(String placeholder, int add) {
        this.placeholder = placeholder;
        this.adder = add;

        // Add focus listener to repaint the field on focus gain/loss
        setBorder(null);
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder) || getText().equals("")){
                    //if focus gained and the intial field is empty (only placeholder), 
                    //then delete all placeholder text
                  setText("");
                }else{
                    //if in ex: editTask, the initial field has text that is not placeholder
                   //then dont delete it
                  setText(getText());
                }
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
            int padding = (getHeight() - getFont().getSize()) / 2;
            
            g2d.drawString(placeholder, getInsets().left+this.adder, getHeight() - padding - 1);
            g2d.dispose();
        }
    }
    
}
