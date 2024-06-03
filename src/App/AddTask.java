/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

/**
 *
 * @author Asus
 */
public class AddTask extends javax.swing.JFrame {

    /**
     * Creates new form AddTask
     */
    public AddTask() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        oneDay = new javax.swing.JRadioButton();
        nameField = new javax.swing.JTextField();
        multipleDay = new javax.swing.JRadioButton();
        theDay_from = new javax.swing.JLabel();
        theDay_to = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        noteArea = new javax.swing.JTextArea();
        colortxt = new javax.swing.JLabel();
        monthFromComboBox = new javax.swing.JComboBox<>();
        titletxt = new javax.swing.JLabel();
        saveBtn = new App.ButtonCustom();
        fromYearField = new javax.swing.JTextField();
        colorComboBox = new javax.swing.JComboBox<>();
        fromDateField = new javax.swing.JTextField();
        toDateField = new javax.swing.JTextField();
        monthToComboBox = new javax.swing.JComboBox<>();
        toYearField = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Task");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(500, 577));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        oneDay.setBackground(new java.awt.Color(255, 255, 255));
        oneDay.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        oneDay.setSelected(true);
        oneDay.setText("One-day event");
        getContentPane().add(oneDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        nameField.setBackground(new java.awt.Color(234, 234, 234));
        nameField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        nameField.setForeground(new java.awt.Color(155, 154, 154));
        nameField.setText("Name ");
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 427, 41));

        multipleDay.setBackground(new java.awt.Color(255, 255, 255));
        multipleDay.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        multipleDay.setText("Multiple-day event");
        getContentPane().add(multipleDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        theDay_from.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        theDay_from.setText("From");
        getContentPane().add(theDay_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 195, -1, -1));

        theDay_to.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        theDay_to.setText("To");
        getContentPane().add(theDay_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        noteArea.setBackground(new java.awt.Color(234, 234, 234));
        noteArea.setColumns(22);
        noteArea.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        noteArea.setForeground(new java.awt.Color(155, 154, 154));
        noteArea.setRows(3);
        noteArea.setTabSize(5);
        noteArea.setText("Important notes");
        noteArea.setName(""); // NOI18N
        jScrollPane1.setViewportView(noteArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        colortxt.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        colortxt.setText("Color");
        getContentPane().add(colortxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        monthFromComboBox.setBackground(new java.awt.Color(234, 234, 234));
        monthFromComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        monthFromComboBox.setForeground(new java.awt.Color(155, 154, 154));
        monthFromComboBox.setMaximumRowCount(12);
        monthFromComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "Desember" }));
        monthFromComboBox.setToolTipText("");
        getContentPane().add(monthFromComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 150, 38));

        titletxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 32)); // NOI18N
        titletxt.setText("Add Task");
        getContentPane().add(titletxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 15, -1, -1));

        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorderColor(new java.awt.Color(31, 139, 217));
        saveBtn.setBorderColorNotOver(new java.awt.Color(31, 139, 217));
        saveBtn.setBorderColorOver(new java.awt.Color(125, 201, 255));
        saveBtn.setColor(new java.awt.Color(31, 139, 217));
        saveBtn.setColor2(java.awt.Color.white);
        saveBtn.setColorClick(new java.awt.Color(125, 201, 255));
        saveBtn.setColorClick2(java.awt.Color.white);
        saveBtn.setColorOver(new java.awt.Color(125, 201, 255));
        saveBtn.setColorOver2(java.awt.Color.white);
        saveBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        saveBtn.setRadius(50);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        getContentPane().add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 110, 47));

        fromYearField.setBackground(new java.awt.Color(234, 234, 234));
        fromYearField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        fromYearField.setForeground(new java.awt.Color(155, 154, 154));
        fromYearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromYearField.setText("Year");
        fromYearField.setToolTipText("");
        fromYearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromYearFieldActionPerformed(evt);
            }
        });
        getContentPane().add(fromYearField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 90, 38));

        colorComboBox.setBackground(new java.awt.Color(234, 234, 234));
        colorComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        colorComboBox.setForeground(new java.awt.Color(155, 154, 154));
        colorComboBox.setMaximumRowCount(10);
        colorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blue", "Red", "Orange", "Yellow", "Green", "Purple", "Pink", "Brown" }));
        colorComboBox.setToolTipText("");
        getContentPane().add(colorComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 100, 38));

        fromDateField.setBackground(new java.awt.Color(234, 234, 234));
        fromDateField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        fromDateField.setForeground(new java.awt.Color(155, 154, 154));
        fromDateField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromDateField.setText("Date");
        fromDateField.setToolTipText("");
        fromDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromDateFieldActionPerformed(evt);
            }
        });
        getContentPane().add(fromDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 60, 38));

        toDateField.setBackground(new java.awt.Color(234, 234, 234));
        toDateField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        toDateField.setForeground(new java.awt.Color(155, 154, 154));
        toDateField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toDateField.setText("Date");
        toDateField.setToolTipText("");
        toDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toDateFieldActionPerformed(evt);
            }
        });
        getContentPane().add(toDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 245, 60, 38));

        monthToComboBox.setBackground(new java.awt.Color(234, 234, 234));
        monthToComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        monthToComboBox.setForeground(new java.awt.Color(155, 154, 154));
        monthToComboBox.setMaximumRowCount(12);
        monthToComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "Desember" }));
        monthToComboBox.setToolTipText("");
        getContentPane().add(monthToComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 245, 150, 38));

        toYearField.setBackground(new java.awt.Color(234, 234, 234));
        toYearField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        toYearField.setForeground(new java.awt.Color(155, 154, 154));
        toYearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toYearField.setText("Year");
        toYearField.setToolTipText("");
        toYearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toYearFieldActionPerformed(evt);
            }
        });
        getContentPane().add(toYearField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 245, 90, 38));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed

    private void fromYearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromYearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromYearFieldActionPerformed

    private void fromDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromDateFieldActionPerformed

    private void toDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toDateFieldActionPerformed

    private void toYearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toYearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toYearFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> colorComboBox;
    private javax.swing.JLabel colortxt;
    private javax.swing.JTextField fromDateField;
    private javax.swing.JTextField fromYearField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> monthFromComboBox;
    private javax.swing.JComboBox<String> monthToComboBox;
    private javax.swing.JRadioButton multipleDay;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextArea noteArea;
    private javax.swing.JRadioButton oneDay;
    private App.ButtonCustom saveBtn;
    private javax.swing.JLabel theDay_from;
    private javax.swing.JLabel theDay_to;
    private javax.swing.JLabel titletxt;
    private javax.swing.JTextField toDateField;
    private javax.swing.JTextField toYearField;
    // End of variables declaration//GEN-END:variables
}