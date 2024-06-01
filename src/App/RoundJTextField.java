package App;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

public class RoundJTextField extends JTextField {
    private String placeholder;
    private Shape shape;
    
    public RoundJTextField(int size, String placeholder) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
        this.placeholder = placeholder;
        
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
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
         super.paintComponent(g);
         
         if (getText().isEmpty() && !isFocusOwner()) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.GRAY); // Set the color for the placeholder text
            int padding = (getHeight() - getFont().getSize()) / 2;
            g2d.drawString(placeholder, getInsets().left, getHeight() - padding - 1);
            g2d.dispose();
        }
    }
    
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Stroke oldStroke = g2.getStroke(); //get the original stroke
        
        g2.setStroke(new BasicStroke(1)); //the thickness of the border
        g.setColor(getForeground());
        g.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 30, 30); //draw the round rect for the border
        
        g2.setStroke(oldStroke); // Restore the original stroke
    }
    
    @Override
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 30, 30);
         }
         return shape.contains(x, y);
    }
}