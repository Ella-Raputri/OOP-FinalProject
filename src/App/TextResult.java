/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JPanel cloneablePanel;
    /**
     * Creates new form TextResult
     */
    public TextResult() {
        initComponents();        
        myinit();
        initDesign();
    }
    
    public TextResult(LinkedList<Flow> flowlist) {
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
        //resultPane = new javax.swing.JPanel();
        resulttxt = new javax.swing.JLabel();
        copyBtn = new App.ButtonCustom();
        setBtn = new App.ButtonCustom();
        
        //resultPane.setBackground(Color.white);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        dateField.setForeground(new java.awt.Color(155, 154, 154));
        dateField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateField.setText("Date");
        dateField.setToolTipText("");
        getContentPane().add(dateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 60, 32));

        monthComboBox.setBackground(new java.awt.Color(234, 234, 234));
        monthComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        monthComboBox.setForeground(new java.awt.Color(155, 154, 154));
        monthComboBox.setMaximumRowCount(12);
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "Desember" }));
        monthComboBox.setToolTipText("");
        getContentPane().add(monthComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, 32));

        yearField.setBackground(new java.awt.Color(234, 234, 234));
        yearField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        yearField.setForeground(new java.awt.Color(155, 154, 154));
        yearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yearField.setText("Year");
        yearField.setToolTipText("");
        getContentPane().add(yearField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 80, 32));

//        resultPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
//        resultPane.setLayout(null);

        resulttxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        resulttxt.setText("Results");
        getContentPane().add(resulttxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 100, 30));
        //resulttxt.setBounds(170, 20, 100, 30);

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
//        copyBtn.setBounds(280, 20, 34, 30);

//        getContentPane().add(resultPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 500, 430));

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
        int yPos = 0;
        int labelHeight = 30;
        resultPane = new JPanel();
        resultPane.setLayout(null);
        for (Flow result : flowlist) {
            JLabel label = new JLabel(result.getNameInput());
            label.setFont(new java.awt.Font("Montserrat", 0, 18)); // Customize the font as needed
            label.setBounds(10, yPos, 460, labelHeight);
            resultPane.add(label);
            yPos += labelHeight + 20;
        }
        resultPane.setBackground(new Color(246,252,254));
        
//        scrollPane.getViewport().setBackground(Color.lightGray); // Sets the background color of the viewport
    //    scrollPane.setBackground(Color.gray); // Sets the background color of the scroll pane itself
    //    scrollPane.getVerticalScrollBar().setBackground(Color.gray); // Sets the background color of the vertical scroll bar
    //    scrollPane.getHorizontalScrollBar().setBackground(Color.gray); 
        // Creating the scroll pane and adding the result panel to it
        scrollPane = new JScrollPane(resultPane);
        scrollPane.setPreferredSize(new Dimension(349, 271)); // Adjust the size as needed
        scrollPane.setBackground(new Color(246,252,254));
        getContentPane().add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, 460, 300));

        
        pack();
        setLocationRelativeTo(null);
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
    }
    
    
    private void setBtnActionPerformed(){
        //
    }
    
    private void copyBtnActionPerformed(){
        //
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
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextResult().setVisible(true);
            }
        });
    }
    
    
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
