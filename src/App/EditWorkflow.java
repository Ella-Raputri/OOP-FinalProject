/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Asus
 */
public class EditWorkflow extends javax.swing.JFrame {
    private String workflowID;
    private JPanel contentPane;
    private JPanel cloneablePanel;
    private JScrollPane scrollPane;
    public static int open = 0;
    /**
     * Creates new form EditWorkflow
     */
    public EditWorkflow() {
        setResizable(false);
        setTitle("Edit Workflow");
        initComponents();
        myinit();
        initDesign();
    }
    
    public EditWorkflow(String workflowid) {
        this.workflowID = workflowid;
        setResizable(false);
        setTitle("Edit Workflow");
        initComponents();
        myinit();
        System.out.print(workflowid);
        initDesign();
    }
    
    private void initDesign(){
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
    }


    
    private void myinit(){
        int totalElement = 0;
        LinkedList<Flow> flowList = new LinkedList<>();
        
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM flow WHERE workflowID = ? ORDER BY dayFrom ASC";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.workflowID);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String fID = rs.getString("id");
                String fname = rs.getString("name");
                String ftype = rs.getString("type");
                int fdayFrom = rs.getInt("dayFrom");
                int fdayTo = rs.getInt("dayTo");
                String fnotes = rs.getString("notes");
                String fcolor = rs.getString("color");
                
                Flow flow = new Flow(fID, fname, ftype, fdayFrom, fdayTo, fnotes, fcolor);
                flowList.add(flow);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
        totalElement = flowList.size();
        
        // Create the content pane
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon bgImage = new ImageIcon("src/App/img/edit_workflow_page.png");
                // Draw the background image
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPane.setLayout(null); // Use absolute layout
        setContentPane(contentPane);
        
        // Create the scroll pane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(732, 120, 508, 559); // Set bounds for the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane);

        // Create the cloneable panel
        cloneablePanel = new JPanel(); // The initial panel inside scroll pane
        cloneablePanel.setLayout(null); // Use absolute layout
        cloneablePanel.setPreferredSize(new Dimension(400, 200)); // Set initial size
        cloneablePanel.setBounds(180, 200, 1200, 1500); // Set bounds for the initial panel
        cloneablePanel.setBackground(new Color(246,252,254));
        scrollPane.setViewportView(cloneablePanel); // Set this panel as viewport's view
        
        
        for(int i=0; i<totalElement;i++){
            String id = flowList.get(i).getId();
            String name = flowList.get(i).getNameInput();
            String type = flowList.get(i).getTypeInput();
            int dayFrom = flowList.get(i).getDayFromInput();
            int dayTo = flowList.get(i).getDayToInput();
            String color = flowList.get(i).getColorInput();
            
            // Create a new cloned panel
            // Cloneable Panel
            CloneablePanelFlow clonedPanel = new CloneablePanelFlow(20, Color.white, 2 ,id, name, type, dayFrom, dayTo, color);
            // Set your custom width and height for the cloned panel
            int panelWidth = 288;
            int panelHeight = 146;
            

            // Calculate the x and y positions based on row and column indices
            int x = 110;
            int y = 10 + i * (panelHeight + 50);

            // Set the bounds for the cloned panel with your custom size
            clonedPanel.setBounds(x, y, panelWidth, panelHeight);
            clonedPanel.setBackground(new Color(246,252,254));
            
            // Add the cloned panel to the initial panel
            cloneablePanel.add(clonedPanel);
            // Adjust preferred size of initial panel to include new panel
            Dimension newSize = new Dimension(cloneablePanel.getWidth(), y + panelHeight + 10); // Adjusted size
            cloneablePanel.setPreferredSize(newSize);
            // Ensure the scroll pane updates its viewport
            scrollPane.revalidate();
            scrollPane.repaint();
            // Scroll to show the new panel
            scrollPane.getVerticalScrollBar().setValue(0);
        }
        
        
        ImageIcon bgImage = new ImageIcon("src/App/img/background_adminhome.png");
        contentPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
    }
    
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(EditWorkflow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditWorkflow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditWorkflow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditWorkflow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditWorkflow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
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
}
