/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

/**
 *
 * @author Asus
 */
public class EditFlowMenu extends javax.swing.JFrame {

    /**
     * Creates new form EditFlowMenu
     */
    public EditFlowMenu() {
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

        backButton = new javax.swing.JLabel();
        checkpoint = new javax.swing.JLabel();
        workflow_name = new javax.swing.JLabel();
        multipleDay = new javax.swing.JRadioButton();
        oneDay = new javax.swing.JRadioButton();
        fromField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        fromtxt = new javax.swing.JLabel();
        fromComboBox = new javax.swing.JComboBox<>();
        theDay_from = new javax.swing.JLabel();
        theDay_to = new javax.swing.JLabel();
        toField = new javax.swing.JTextField();
        colorComboBox = new javax.swing.JComboBox<>();
        toComboBox = new javax.swing.JComboBox<>();
        theDay_to1 = new javax.swing.JLabel();
        totxt = new javax.swing.JLabel();
        viewtxt = new javax.swing.JLabel();
        saveBtn = new App.ButtonCustom();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_btn.png"))); // NOI18N
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 17, -1, -1));

        checkpoint.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        checkpoint.setText("Total: xx checkpoints");
        getContentPane().add(checkpoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 120, -1, -1));

        workflow_name.setFont(new java.awt.Font("Montserrat SemiBold", 0, 40)); // NOI18N
        workflow_name.setForeground(new java.awt.Color(0, 141, 189));
        workflow_name.setText("View Workflow");
        getContentPane().add(workflow_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 52, -1, -1));

        multipleDay.setBackground(new java.awt.Color(255, 255, 255));
        multipleDay.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        multipleDay.setText("Multiple-day event");
        getContentPane().add(multipleDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 271, -1, -1));

        oneDay.setBackground(new java.awt.Color(255, 255, 255));
        oneDay.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        oneDay.setSelected(true);
        oneDay.setText("One-day event");
        getContentPane().add(oneDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 271, -1, -1));

        fromField.setBackground(new java.awt.Color(234, 234, 234));
        fromField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        fromField.setForeground(new java.awt.Color(155, 154, 154));
        fromField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromField.setText("Day");
        fromField.setToolTipText("");
        getContentPane().add(fromField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 317, 80, 38));

        nameField.setBackground(new java.awt.Color(234, 234, 234));
        nameField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        nameField.setForeground(new java.awt.Color(155, 154, 154));
        nameField.setText("Name ");
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 211, 427, 41));

        fromtxt.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        fromtxt.setText("The Day");
        getContentPane().add(fromtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 321, -1, -1));

        fromComboBox.setBackground(new java.awt.Color(234, 234, 234));
        fromComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        fromComboBox.setForeground(new java.awt.Color(155, 154, 154));
        fromComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Before", "After" }));
        fromComboBox.setToolTipText("");
        getContentPane().add(fromComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 317, 140, 38));

        theDay_from.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        theDay_from.setText("From");
        getContentPane().add(theDay_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 322, -1, -1));

        theDay_to.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        theDay_to.setText("Color");
        getContentPane().add(theDay_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, -1, -1));

        toField.setBackground(new java.awt.Color(234, 234, 234));
        toField.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        toField.setForeground(new java.awt.Color(155, 154, 154));
        toField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        toField.setText("Day");
        toField.setToolTipText("");
        getContentPane().add(toField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 374, 80, 38));

        colorComboBox.setBackground(new java.awt.Color(234, 234, 234));
        colorComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        colorComboBox.setForeground(new java.awt.Color(155, 154, 154));
        colorComboBox.setMaximumRowCount(10);
        colorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blue", "Red", "Orange", "Yellow", "Green", "Purple", "Pink", "Brown" }));
        colorComboBox.setToolTipText("");
        getContentPane().add(colorComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 100, 38));

        toComboBox.setBackground(new java.awt.Color(234, 234, 234));
        toComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        toComboBox.setForeground(new java.awt.Color(155, 154, 154));
        toComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Before", "After" }));
        toComboBox.setToolTipText("");
        getContentPane().add(toComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 374, 140, 38));

        theDay_to1.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        theDay_to1.setText("To");
        getContentPane().add(theDay_to1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, -1, -1));

        totxt.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        totxt.setText("The Day");
        getContentPane().add(totxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, -1, -1));

        viewtxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 40)); // NOI18N
        viewtxt.setForeground(new java.awt.Color(0, 141, 189));
        viewtxt.setText("[workflow name]");
        getContentPane().add(viewtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 54, -1, -1));

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
        getContentPane().add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 605, 110, 47));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_flow.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 615, -1, -1));

        jTextArea1.setBackground(new java.awt.Color(234, 234, 234));
        jTextArea1.setColumns(22);
        jTextArea1.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(155, 154, 154));
        jTextArea1.setRows(3);
        jTextArea1.setTabSize(5);
        jTextArea1.setText("Important notes");
        jTextArea1.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_workflow_page.png"))); // NOI18N
        bg.setText("jLabel1");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EditFlowMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditFlowMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditFlowMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditFlowMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditFlowMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel checkpoint;
    private javax.swing.JComboBox<String> colorComboBox;
    private javax.swing.JComboBox<String> fromComboBox;
    private javax.swing.JTextField fromField;
    private javax.swing.JLabel fromtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton multipleDay;
    private javax.swing.JTextField nameField;
    private javax.swing.JRadioButton oneDay;
    private App.ButtonCustom saveBtn;
    private javax.swing.JLabel theDay_from;
    private javax.swing.JLabel theDay_to;
    private javax.swing.JLabel theDay_to1;
    private javax.swing.JComboBox<String> toComboBox;
    private javax.swing.JTextField toField;
    private javax.swing.JLabel totxt;
    private javax.swing.JLabel viewtxt;
    private javax.swing.JLabel workflow_name;
    // End of variables declaration//GEN-END:variables
}
