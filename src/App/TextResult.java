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
        //set background color
        getContentPane().setBackground(Color.white);
        
        //init components
        choosetxt = new javax.swing.JLabel();
        d_day = new javax.swing.JLabel();
        dateField = new PlaceHolderTextField("Date", 5);
        monthComboBox = new javax.swing.JComboBox<>();
        yearField = new PlaceHolderTextField("Year",20);
        resulttxt = new javax.swing.JLabel();
        copyBtn = new App.ButtonCustom();
        setBtn = new App.ButtonCustom();

        //set size and layout
        setPreferredSize(new java.awt.Dimension(500, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //set current date to be inserted as default value in the textfield
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        String year = formattedDate.substring(0,4);
        String month = formattedDate.substring(5,7);
        String date = formattedDate.substring(8,10);

        //styling components
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
        dateField.setText(date);
        dateField.setToolTipText("");
        getContentPane().add(dateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 60, 32));

        monthComboBox.setBackground(new java.awt.Color(234, 234, 234));
        monthComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        monthComboBox.setForeground(new java.awt.Color(93, 93, 93));
        monthComboBox.setMaximumRowCount(12);
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        monthComboBox.setToolTipText("");
        monthComboBox.setSelectedIndex(Integer.parseInt(month)-1);
        getContentPane().add(monthComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, 32));

        yearField.setBackground(new java.awt.Color(234, 234, 234));
        yearField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        yearField.setForeground(new java.awt.Color(93, 93, 93));
        yearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yearField.setText(year);
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
        
        // Creating the result panel for containing labels
        resultPane = new JPanel();
        resultPane.setLayout(null);
        resultPane.setBackground(new Color(246,252,254));
        getContentPane().add(resultPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, 460, 300));
        
        //create the scroll pane for the result pane
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
        //create the result labels inside the resultPane 
        int yPos = 0;
        int space0;
        int space_iter =1;
        int labelHeight = 30;
        
        String currentDate = dateList.getFirst(); //get the first date of the result
        for (int i = 0; i < flowlist.size(); i++) {
            //if it is the first index or the date is not the same
            if (i == 0 || (!dateList.get(i).equals(currentDate))){
                currentDate = dateList.get(i);
                space_iter = 1;
                
                //if the the date is new, add the adder space0 
                if (i == 0) space0 = 30;
                else space0 = 0;
                
                yPos += space0;
                //set the date label
                JLabel date_label = new JLabel(dateList.get(i));
                date_label.setFont(new java.awt.Font("Montserrat Semibold", 0, 18)); 
                date_label.setBounds(10, yPos, 460, labelHeight);
                resultPane.add(date_label);
                yPos += labelHeight + 10;
                
                //set the flow label
                JLabel label = new JLabel(flowlist.get(i).getNameInput());
                label.setFont(new java.awt.Font("Montserrat", 0, 18)); 
                label.setBounds(10, yPos, 460, labelHeight);
                resultPane.add(label);
                yPos += labelHeight + 10;
            }
            else{
                //if the date is not new or the flow has the same date as previous flow
                space_iter +=1;
                //only set the flow label
                JLabel label = new JLabel(flowlist.get(i).getNameInput());
                label.setFont(new java.awt.Font("Montserrat", 0, 18)); 
                label.setBounds(10, yPos, 460, labelHeight);
                resultPane.add(label);
                yPos += labelHeight + 10;
            }
            //set the size of the result pane based on the space iter or number of elements
            Dimension newSize = new Dimension(resultPane.getWidth(), 400+space_iter *50);
            resultPane.setPreferredSize(newSize);
            
            //revalidate and repaint result pane and scroll pane
            resultPane.revalidate(); resultPane.repaint();
            scrollPane.revalidate(); scrollPane.repaint();
            
            // Scroll to show the new panel
            scrollPane.getVerticalScrollBar().setValue(0);
        }
    }
    
    
    private void myinit(){
        //upon clicking the 'x' button, the window will not close
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // ask for confirmation
                int option = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    //close this window only and set the opened window of edit workflow to become 0
                    EditWorkflow.open = 0;
                    setVisible(false);
                } 
            }
        });
        
        //populate the month map, the month map is used to convert month name to month number
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
        //see if the String can be parsed to be a date or not
        try {
            LocalDate.parse(dateStr, dateFormatter); 
        } catch (DateTimeParseException e) {
            return false; //return false if exception caught
        }
        return true; //if nothing happens, return true
    }
    
    private void setBtnActionPerformed(){
        //ensure that all the old labels and date are empty
        resultPane.removeAll();
        dateList.clear();
        
        //get the data of the day, month, and year
        String dateStr = dateField.getText();
        String monthStr = (String) monthComboBox.getSelectedItem();
        String yearStr = yearField.getText();
        
        //create the String in the format of YYYY-MM-dd
        String modify = yearStr + "-" + monthMap.get(monthStr) + "-" + dateStr ;
        if (modify.length() != 10){
            //add a 0 to the date if the date is only a number
            //for example: 2024-02-9 will become 2024-02-09
            modify = modify.substring(0, 8) + "0" + modify.charAt(8);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //check if the String is a valid date or not
        if (isValid(modify, formatter)){
            //if valid, then parse it to LocalDate
            LocalDate settedDate = LocalDate.parse(modify, formatter);
        
            for (Flow result : flowlist){
                //iterate over every flow in the flow list
                //if the flow is one day event
                if (result.getTypeInput().equals("One-day event")){
                    //count the date of the flow and add it to the date list
                    LocalDate day = settedDate.plusDays(result.getDayFromInput());
                    dateList.add(convertDatetoStr(day));
                }
                else{
                    //if multiple day event
                    //count the date range of the flow and add it to the date list
                    LocalDate dayFrom = settedDate.plusDays(result.getDayFromInput());
                    LocalDate dayTo = settedDate.plusDays(result.getDayToInput());
                    String dateFix = convertDatetoStr(dayFrom) + " - " +convertDatetoStr(dayTo);
                    dateList.add(dateFix);
                }
            }
            createLabels(); //create the labels based on the flow and the setted d-day
        }else{
            JOptionPane.showMessageDialog(getContentPane(), "Date is not valid.");
        }        
    }
    
    private String convertDatetoStr(LocalDate date){
        //change the YYYY-MM-dd date to become a dd {month name} YYYY string
        String curr_date = date.toString();
        String month = getKeyByValue(monthMap, curr_date.substring(5, 7));
        String str = curr_date.substring(8,10) + " " + month + " " +curr_date.substring(0,4);                
        return str;
    }
    
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
    //iterate over the hashmap to get the key based on the value
    for (Entry<T, E> entry : map.entrySet()) {
        //the month map is one to one, so there is no problem on doing this
        if (Objects.equals(value, entry.getValue())) {
            return entry.getKey();
        }
    }
    return null; //return null if the value does not exist
}
    
    private void copyBtnActionPerformed(){
        //when the user clicks the copy button
        String result = "";
        //use hash set, so that only unique date inside it
        HashSet<String> dateSet = new HashSet<>();
        dateSet.addAll(dateList); //get all the date
        
        //for every component inside the result pane
        for (Component comp : resultPane.getComponents()){
            //get the JLabel Component
            JLabel lab = (JLabel) comp;
            if (dateSet.contains(lab.getText())){
                //if it is a date, than plus one enter before appending the text (the date)
                result += "\n";
            }
            //append the text and end with an enter
            result += lab.getText() + "\n";
        }
        //copy the result
        StringSelection stringSelection = new StringSelection (result);
        Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
        clpbrd.setContents (stringSelection, null);
        
        //show success message
        JOptionPane.showMessageDialog(getContentPane(), "Successfully copied the result!");
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
