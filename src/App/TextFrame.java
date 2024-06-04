/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Asus
 */
public class TextFrame extends javax.swing.JFrame {
    private LinkedList<Flow> flowlist;
    /**
     * Creates new form TextFrame
     */
    public TextFrame(LinkedList<Flow> flowlist) {
        this.flowlist = flowlist;
        setTitle("Text Result");
        setResizable(false);
        initComponents();
        myinit();
    }
    
    public TextFrame() {
        setTitle("Text Result");
        setResizable(false);
        initComponents();
        myinit();
    }
    
    private void myinit(){
        
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                // Custom close operation logic
//                int option = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", null, JOptionPane.YES_NO_OPTION);
//                if (option == JOptionPane.YES_OPTION) {
//                    setVisible(false);
//                } 
//            }
//        });
        
//        //initialize the content pane
//        JPanel contentPane = new JPanel(new BorderLayout());
//        
//        JLabel titleLabel = new JLabel("Text Result");
//        contentPane.add(titleLabel, BorderLayout.NORTH);
//
//        // Create a panel to hold the JLabels
//        JPanel labelPanel = new JPanel();
//        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
//
//        JScrollPane scrollPane = new JScrollPane(labelPanel);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//
//        contentPane.add(scrollPane, BorderLayout.CENTER);
//        
//        // Create a button to add new JLabels
//        JButton addButton = new JButton("Add JLabel");
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JLabel newLabel = new JLabel("Label " + (labelPanel.getComponentCount() + 1));
//                labelPanel.add(newLabel);
//                labelPanel.revalidate(); // Refresh the layout
//                labelPanel.repaint();    // Repaint the panel
//            }
//        });
//
//        // Add the button to the contentPane
//        contentPane.add(addButton, BorderLayout.SOUTH);
//
//        this.setContentPane(contentPane);
//        this.setSize(370, 450);
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choosetxt = new javax.swing.JLabel();
        d_day = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        monthComboBox = new javax.swing.JComboBox<>();
        yearField = new javax.swing.JTextField();
        contentPane = new javax.swing.JPanel();
        resulttxt = new javax.swing.JLabel();
        copyBtn = new App.ButtonCustom();
        setBtn1 = new App.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(500, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        choosetxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        choosetxt.setText("Choose Date");
        getContentPane().add(choosetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        d_day.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        d_day.setText("D-Day:");
        getContentPane().add(d_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        dateField.setBackground(new java.awt.Color(234, 234, 234));
        dateField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        dateField.setForeground(new java.awt.Color(155, 154, 154));
        dateField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateField.setText("Date");
        dateField.setToolTipText("");
        dateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFieldActionPerformed(evt);
            }
        });
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
        yearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearFieldActionPerformed(evt);
            }
        });
        getContentPane().add(yearField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 80, 32));

        contentPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contentPane.setLayout(null);

        resulttxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        resulttxt.setText("Results");
        contentPane.add(resulttxt);
        resulttxt.setBounds(200, 20, 100, 30);

        copyBtn.setForeground(new java.awt.Color(255, 255, 255));
        copyBtn.setText("Set");
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
                copyBtnActionPerformed(evt);
            }
        });
        contentPane.add(copyBtn);
        copyBtn.setBounds(300, 20, 34, 30);

        getContentPane().add(contentPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 500, 430));

        setBtn1.setForeground(new java.awt.Color(255, 255, 255));
        setBtn1.setText("Set");
        setBtn1.setBorderColor(new java.awt.Color(31, 139, 217));
        setBtn1.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
        setBtn1.setBorderColorOver(new java.awt.Color(125, 201, 255));
        setBtn1.setColor(new java.awt.Color(31, 139, 217));
        setBtn1.setColor2(java.awt.Color.white);
        setBtn1.setColorClick(new java.awt.Color(125, 201, 255));
        setBtn1.setColorClick2(java.awt.Color.white);
        setBtn1.setColorOver(new java.awt.Color(125, 201, 255));
        setBtn1.setColorOver2(java.awt.Color.white);
        setBtn1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        setBtn1.setRadius(10);
        setBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(setBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 60, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFieldActionPerformed

    private void yearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearFieldActionPerformed

    private void copyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_copyBtnActionPerformed

    private void setBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(TextFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel choosetxt;
    private javax.swing.JPanel contentPane;
    private App.ButtonCustom copyBtn;
    private javax.swing.JLabel d_day;
    private javax.swing.JTextField dateField;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JLabel resulttxt;
    private App.ButtonCustom saveBtn;
    private App.ButtonCustom setBtn1;
    private javax.swing.JTextField yearField;
    // End of variables declaration//GEN-END:variables
}
