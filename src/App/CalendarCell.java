/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
    
    public CalendarCell(){
        setContentAreaFilled(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
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
    
    public void currentMonth(boolean act){
        if(act){
            setForeground(new Color(58,58,58));
        }
        else{
            setForeground(new Color(200,200,200));
        }
    }
    
    public void setAsToday(){
        isToday = true;
        setForeground(new Color(0,141,189));
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
    
}
