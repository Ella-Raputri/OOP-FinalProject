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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Asus
 */
public class CalendarCell extends JButton{
    
    private Date date;
    private boolean title;
    private boolean isToday;
    private boolean isSelected;
    
    public CalendarCell(){
        setContentAreaFilled(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isSelected) {
                    setAsSelected(true);
                }
            }
        });
    }
    
    public void asTitle(){
        title = true;
    }
    
    public boolean isTitle(){
        return title;
    }
        
    public void setDate(Date date1){
        this.date = date1;
    }
    
    public void currentMonth(boolean act, boolean isSunday){
        if(act && !isSunday){
            setForeground(new Color(58,58,58));
            setFont(new java.awt.Font("Montserrat Medium", 0, 22));
        }
        else if (act && isSunday){
            setForeground(new Color(234, 111, 111));
            setFont(new java.awt.Font("Montserrat Medium", 0, 22));
        }
        else if (!act && isSunday){
            setForeground(new Color(255, 167, 167));
        }
        else {
            setForeground(new Color(200,200,200));
        }
    }
    
    public void setAsToday(){
        isToday = true;
        setForeground(new Color(0,141,189));
        repaint();
    }
    
    public void setAsSelected(boolean bool){
        isSelected = bool;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        if(title){
            g.setColor(new Color(0,141,189));
            g.drawLine(20, getHeight()-1, getWidth()-20, getHeight()-1);
        }
        if (isToday){
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(222, 247, 255));
            g2.fillRoundRect(30, 10, 48, 48, 100, 100);
        }
        super.paintComponent(g);
    }
    
    @Override
    protected void paintBorder(Graphics g) {
       if (isSelected) {
        int borderWidth = 2;
        Graphics2D g2d = (Graphics2D) g.create();
        super.paintBorder(g); // Ensure any superclass painting is done

        // Set border color and width
        g2d.setColor(new Color(214, 214, 214));
        g2d.setStroke(new BasicStroke(borderWidth)); // Set border width
        
        // Draw the rounded rectangle border
        g2d.drawRoundRect(2, 2, getWidth() - 4, getHeight() - 4, 10, 10); // Adjusted position and size

        g2d.dispose();
       }
    }
    
}
