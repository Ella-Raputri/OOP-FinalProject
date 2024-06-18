package App;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class ButtonCustom extends JButton {
    //getter to see whether the button is hovered or not
    public boolean isOver() {
        return over;
    }
    //set the button hovered to be true
    public void setOver(boolean over) {
        this.over = over;
    }
    //get the color of button
    public Color getColor() {
        return color;
    }
    //set the color of button
    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }
    //get the color of button when it is hovered
    public Color getColorOver() {
        return colorOver;
    }
    //set the color of button when it is hovered    
    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }
    //get the color of button when it is clicked
    public Color getColorClick() {
        return colorClick;
    }
    //set the color of button when it is clicked
    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }
    //get the color of button border when it is not hovered
    public Color getBorderColorNotOver() {
        return borderColorNotOver;
    }
    //get the color of text
    public Color getColor2() {
        return color2;
    }
    //set the color of text
    public void setColor2(Color color2) {
        this.color2 = color2;
    }
    //get the color of text when hover
    public Color getColorOver2() {
        return colorOver2;
    }
    //set the color of text when hover
    public void setColorOver2(Color colorOver2) {
        this.colorOver2 = colorOver2;
    }
    //get the color of text when clicked
    public Color getColorClick2() {
        return colorClick2;
    }
    //set the color of text when clicked
    public void setColorClick2(Color colorClick2) {
        this.colorClick2 = colorClick2;
    }
    //get the color of border when hovered
    public Color getBorderColorOver() {
        return borderColorOver;
    }
    //set the color of border when hovered
    public void setBorderColorOver(Color borderColorOver) {
        this.borderColorOver = borderColorOver;
    }
    //set the color of border when not hovered
    public void setBorderColorNotOver(Color borderColor) {
        this.borderColorNotOver = borderColor;
    }
    //set the color of border 
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
    //get the radius
    public int getRadius() {
        return radius;
    }
    //set the radius
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
    public ButtonCustom() {
        //  Init Color as all null
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setColor(null);
        colorOver = null;
        colorClick = null;
        borderColorNotOver = null;
        color2 = null;
        colorOver2 = null;
        colorClick2 = null;
        borderColorOver = null;
        setContentAreaFilled(false);
        
        
        //  Add event mouse and set the colors
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) { //mouse entered
                setBackground(colorOver);
                setForeground(colorOver2);
                setBorderColor(borderColorOver);
                over = true; //hover become true
            }

            @Override
            public void mouseExited(MouseEvent me) { //mouse exited
                setBackground(color);
                setForeground(color2);
                setBorderColor(borderColorNotOver);
                over = false; //hover become false
            }

            @Override
            public void mousePressed(MouseEvent me) { //mouse pressed
                setBackground(colorClick);
                setForeground(colorClick2);
                setBorderColor(borderColorOver);
            }

            @Override
            public void mouseReleased(MouseEvent me) { //mouse released
                if (over) { // if it is hovered
                    setBackground(colorOver);
                    setForeground(colorOver2);
                    setBorderColor(borderColorOver);
                    
                } else { //if it is not hovered
                    setBackground(color);
                    setForeground(color2);
                    setBorderColor(borderColorNotOver);
                }
            }
        });
    }
    
    //attributes
    private boolean over; //hover
    
    //button background colors
    private Color color;
    private Color colorOver;
    private Color colorClick;
    
    //text colors
    private Color color2;
    private Color colorOver2;
    private Color colorClick2;
    
    //border color
    private Color borderColorOver;
    private Color borderColorNotOver;
    private Color borderColor;    
    private int radius = 0; //radius

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        //  Border set 2 Pixel
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
    }
}
