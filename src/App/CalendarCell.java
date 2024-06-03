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
import java.util.HashMap;
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
    private HashMap<String, Color> color_map = new HashMap<>();
    public int task_amount = 0;
    public String colorStr = "Blue";
    private boolean hasTask;
    
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
        
        color_map.put("Blue", new Color(80, 213, 255));
        color_map.put("Red", new Color(255, 164, 164));
        color_map.put("Orange", new Color(255, 182, 128));
        color_map.put("Yellow", new Color(248, 232, 87));
        color_map.put("Green", new Color(153, 237, 113));
        color_map.put("Purple", new Color(218, 157, 255));
        color_map.put("Pink", new Color(255, 125, 203));
        color_map.put("Brown", new Color(223, 170, 106));
    }
    
    public void setColorTasks(int amount, String color){
        this.task_amount = amount;
        this.colorStr = color;
        System.out.print(this.colorStr);
        repaint();
        getParent().repaint();
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
    
    public Date getDate(){
        return this.date;
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
    
    public void setAsTasks(boolean bool, String color){
        this.colorStr = color;
        hasTask = bool;
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
        if (hasTask && !title ){
            if (!colorStr.trim().isEmpty()) {
                g.setColor(color_map.get(colorStr));
                int dotSize = 10; // Size of the dot
                int x = getWidth() / 2 - dotSize / 2;
                int y = getHeight() - dotSize - 5;
                g.fillOval(x, y, dotSize, dotSize);
            }
            else{
                System.out.print(colorStr);
            }
        }        
    }
    
    @Override
    protected void paintBorder(Graphics g) {
       if (isSelected && !title) {
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
