/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Asus
 */
public class TextResult extends javax.swing.JFrame {
    private LinkedList<Flow> flowlist = new LinkedList<>();
    private JScrollPane scrollPane;
    private HashMap <String, String> monthMap = new HashMap<>();
    private LinkedList<String> dateList = new LinkedList<>();
    /**
     * Creates new form TextResult
     */
    
    public TextResult(LinkedList<Flow> flowlist) {
        setResizable(false);
        setTitle("Generate Workflow to Text");
        this.flowlist = flowlist;
        initComponents();
        myinit();
        initDesign();        
    }
    
    private void initDesign(){
        getContentPane().setBackground(Color.white);
        choosetxt = new javax.swing.JLabel();
        d_day = new javax.swing.JLabel();
        dateField = new PlaceHolderTextField("Date", 5);
        monthComboBox = new javax.swing.JComboBox<>();
        yearField = new PlaceHolderTextField("Year",20);
        resulttxt = new javax.swing.JLabel();
        copyBtn = new App.ButtonCustom();
        setBtn = new App.ButtonCustom();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(500, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        choosetxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        choosetxt.setText("Choose Date");
        getContentPane().add(choosetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        d_day.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        d_day.setText("D-Day:");
        getContentPane().add(d_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, -1, -1));

        dateField.setBackground(new java.awt.Color(234, 234, 234));
        dateField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        dateField.setForeground(new java.awt.Color(93, 93, 93));
        dateField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateField.setText("Date");
        dateField.setToolTipText("");
        getContentPane().add(dateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 60, 32));

        monthComboBox.setBackground(new java.awt.Color(234, 234, 234));
        monthComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        monthComboBox.setForeground(new java.awt.Color(93, 93, 93));
        monthComboBox.setMaximumRowCount(12);
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "Desember" }));
        monthComboBox.setToolTipText("");
        getContentPane().add(monthComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, 32));

        yearField.setBackground(new java.awt.Color(234, 234, 234));
        yearField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        yearField.setForeground(new java.awt.Color(93, 93, 93));
        yearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yearField.setText("Year");
        yearField.setToolTipText("");
        getContentPane().add(yearField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 80, 32));


        resulttxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        resulttxt.setText("Results");
        getContentPane().add(resulttxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 100, 30));

        copyBtn.setForeground(new java.awt.Color(255, 255, 255));
        copyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/copy.png")));
        copyBtn.setBorderColor(new java.awt.Color(31, 139, 217));
        copyBtn.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
        copyBtn.setBorderColorOver(new java.awt.Color(125, 201, 255));
        copyBtn.setColor(new java.awt.Color(31, 139, 217));
        copyBtn.setColor2(java.awt.Color.white);
        copyBtn.setColorClick(new java.awt.Color(125, 201, 255));
        copyBtn.setColorClick2(java.awt.Color.white);
        copyBtn.setColorOver(new java.awt.Color(125, 201, 255));
        copyBtn.setColorOver2(java.awt.Color.white);
        copyBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        copyBtn.setRadius(10);
        copyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyBtnActionPerformed();
            }
        });
        getContentPane().add(copyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 34, 30));

        setBtn.setForeground(new java.awt.Color(255, 255, 255));
        setBtn.setText("Set");
        setBtn.setBorderColor(new java.awt.Color(31, 139, 217));
        setBtn.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
        setBtn.setBorderColorOver(new java.awt.Color(125, 201, 255));
        setBtn.setColor(new java.awt.Color(31, 139, 217));
        setBtn.setColor2(java.awt.Color.white);
        setBtn.setColorClick(new java.awt.Color(125, 201, 255));
        setBtn.setColorClick2(java.awt.Color.white);
        setBtn.setColorOver(new java.awt.Color(125, 201, 255));
        setBtn.setColorOver2(java.awt.Color.white);
        setBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        setBtn.setRadius(10);
        setBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setBtnActionPerformed();
            }
        });
        getContentPane().add(setBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 60, -1));
        
        // Creating the result panel and adding labels
        resultPane = new JPanel();
        resultPane.setLayout(null);
        resultPane.setBackground(new Color(246,252,254));
        getContentPane().add(resultPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, 460, 300));
        //createLabels();
        
//        scrollPane.getViewport().setBackground(Color.lightGray); // Sets the background color of the viewport
    //    scrollPane.setBackground(Color.gray); // Sets the background color of the scroll pane itself
    //    scrollPane.getVerticalScrollBar().setBackground(Color.gray); // Sets the background color of the vertical scroll bar
    //    scrollPane.getHorizontalScrollBar().setBackground(Color.gray); 
        // Creating the scroll pane and adding the result panel to it
        scrollPane = new JScrollPane(resultPane);
        scrollPane.setPreferredSize(new Dimension(349, 271)); // Adjust the size as needed
        scrollPane.setBackground(new Color(246,252,254));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setViewportView(resultPane);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        getContentPane().add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, 460, 300));

        
        pack();
        setLocationRelativeTo(null);
    }
    
    private void createLabels(){        
        int yPos = 0;
        int space0;
        int space_iter =1;
        int labelHeight = 30;
        
        String currentDate = dateList.getFirst();
        for (int i = 0; i < flowlist.size(); i++) {
            if (i == 0 || (!dateList.get(i).equals(currentDate))){
                currentDate = dateList.get(i);
                //if (i != 0){
                    space_iter = 1;
                //}
                //if the the date is new 
                if (i == 0) space0 = 30;
                else space0 = 0;
                
                yPos += space0;
                JLabel date_label = new JLabel(dateList.get(i));
                date_label.setFont(new java.awt.Font("Montserrat Semibold", 0, 18)); // Customize the font as needed
                date_label.setBounds(10, yPos, 460, labelHeight);
                resultPane.add(date_label);
                yPos += labelHeight + 10;
                
                JLabel label = new JLabel(flowlist.get(i).getNameInput());
                label.setFont(new java.awt.Font("Montserrat", 0, 18)); // Customize the font as needed
                label.setBounds(10, yPos, 460, labelHeight);
                resultPane.add(label);
                yPos += labelHeight + 10;
            }
            else{
                //if the date is not new
                space_iter +=1;
                JLabel label = new JLabel(flowlist.get(i).getNameInput());
                label.setFont(new java.awt.Font("Montserrat", 0, 18)); // Customize the font as needed
                label.setBounds(10, yPos, 460, labelHeight);
                resultPane.add(label);
                yPos += labelHeight + 10;
            }
            Dimension newSize = new Dimension(resultPane.getWidth(), 400+space_iter *50);
            resultPane.setPreferredSize(newSize);
            resultPane.revalidate(); resultPane.repaint();
            scrollPane.revalidate(); scrollPane.repaint();
            
            // Scroll to show the new panel
            scrollPane.getVerticalScrollBar().setValue(0);
        }
    }
    
    
    private void myinit(){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Custom close operation logic
                int option = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    EditWorkflow.open = 0;
                    setVisible(false);
                } 
            }
        });
        
        monthMap.put("January", "01");
        monthMap.put("February", "02");
        monthMap.put("March", "03");
        monthMap.put("April", "04");
        monthMap.put("May", "05");
        monthMap.put("June", "06");
        monthMap.put("July", "07");
        monthMap.put("August", "08");
        monthMap.put("September", "09");
        monthMap.put("October", "10");
        monthMap.put("November", "11");
        monthMap.put("December", "12");
    }
    
    
    public boolean isValid(String dateStr, DateTimeFormatter dateFormatter) {
        try {
            LocalDate.parse(dateStr, dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
    
    private void setBtnActionPerformed(){
        String dateStr = dateField.getText();
        String monthStr = (String) monthComboBox.getSelectedItem();
        String yearStr = yearField.getText();
        
        String modify = yearStr + "-" + monthMap.get(monthStr) + "-" + dateStr ;
        if (modify.length() != 10){
            modify = modify.substring(0, 8) + "0" + modify.charAt(8);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (isValid(modify, formatter)){
            LocalDate settedDate = LocalDate.parse(modify, formatter);
        
            for (Flow result : flowlist){
                //if one day event
                if (result.getTypeInput().equals("One-day event")){
                    LocalDate day = settedDate.plusDays(result.getDayFromInput());
                    dateList.add(convertDatetoStr(day));
                }
                else{
                    //if multiple day event
                    LocalDate dayFrom = settedDate.plusDays(result.getDayFromInput());
                    LocalDate dayTo = settedDate.plusDays(result.getDayToInput());
                    String dateFix = convertDatetoStr(dayFrom) + " - " +convertDatetoStr(dayTo);
                    dateList.add(dateFix);
                }
            }
            createLabels();
        }else{
            JOptionPane.showMessageDialog(getContentPane(), "Date is not valid.");
        }        
    }
    
    //2024-08-18
    private String convertDatetoStr(LocalDate date){
        String curr_date = date.toString();
        String month = getKeyByValue(monthMap, curr_date.substring(5, 7));
        String str = curr_date.substring(8,10) + " " + month + " " +curr_date.substring(0,4);                
        return str;
    }
    
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
    for (Entry<T, E> entry : map.entrySet()) {
        if (Objects.equals(value, entry.getValue())) {
            return entry.getKey();
        }
    }
    return null;
}
    
    private void copyBtnActionPerformed(){
        String result = "";
        HashSet<String> dateSet = new HashSet<>();
        dateSet.addAll(dateList);
        
        for (Component comp : resultPane.getComponents()){
            JLabel lab = (JLabel) comp;
            if (dateSet.contains(lab.getText())){
                result += "\n";
            }
            result += lab.getText() + "\n";
        }
        System.out.println(result);
        StringSelection stringSelection = new StringSelection (result);
        Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
        clpbrd.setContents (stringSelection, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
 
    
    
    private javax.swing.JLabel choosetxt;
    private javax.swing.JPanel resultPane;
    private App.ButtonCustom copyBtn;
    private javax.swing.JLabel d_day;
    private javax.swing.JTextField dateField;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JLabel resulttxt;
    private App.ButtonCustom setBtn;
    private javax.swing.JTextField yearField;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
