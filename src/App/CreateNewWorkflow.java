/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Asus
 */
public class CreateNewWorkflow extends javax.swing.JFrame {
    private String userID;
    /**
     * Creates new form CreateNewWorkflow
     */
    
    public CreateNewWorkflow(String userID) {
        this.userID = userID;
        initComponents();
        myinit();
    }
    public CreateNewWorkflow() {
        initComponents();
        myinit();
    }
    
    private void myinit(){
        setTitle("Create New Workflow");
        getContentPane().setBackground(Color.white);
        setResizable(false);
        setAlwaysOnTop(true);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Custom close operation logic
                int option = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    AddWorkflowMenu.open=0;
                } 
            }
        });
        
        idLabel = new javax.swing.JLabel();
        idtxt = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameField = new RoundJTextField(10, "");
        OKbutton = new App.ButtonCustom();
        
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idLabel.setFont(new java.awt.Font("Montserrat Regular", 0, 32)); // NOI18N
        idLabel.setText("ID        :");
        getContentPane().add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 33, -1, -1));
        
        idtxt.setFont(new java.awt.Font("Montserrat Regular", 0, 32)); // NOI18N
        idtxt.setText("[id]");
        getContentPane().add(idtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 33, -1, -1));
        
        nameLabel.setFont(new java.awt.Font("Montserrat Regular", 0, 32)); // NOI18N
        nameLabel.setText("Name :");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 103, -1, -1));
        
        nameField.setFont(new java.awt.Font("Montserrat Regular", 0, 32));
        nameField.setPreferredSize(new java.awt.Dimension(359, 70));
        nameField.setBorder(new EmptyBorder(new Insets(5, 10, 5, 10)));
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 173, -1, -1));
        
        OKbutton.setForeground(new java.awt.Color(255, 255, 255));
        OKbutton.setColor(new java.awt.Color(31, 139, 217));
        OKbutton.setColor2(new java.awt.Color(255, 255, 255));
        OKbutton.setText("OK");
        OKbutton.setBorderColor(new java.awt.Color(255, 255, 255));
        OKbutton.setBorderColorNotOver(new java.awt.Color(255, 255, 255));
        OKbutton.setBorderColorOver(new java.awt.Color(255, 255, 255));
        OKbutton.setColorClick(new java.awt.Color(125, 201, 255));
        OKbutton.setColorClick2(new java.awt.Color(255, 255, 255));
        OKbutton.setColorOver(new java.awt.Color(125, 201, 255));
        OKbutton.setColorOver2(new java.awt.Color(255, 255, 255));
        OKbutton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 28)); 
        OKbutton.setRadius(10);
        OKbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(OKbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 295, 102, 57));
        
        
        LinkedList<String> allIdList = new LinkedList<>();
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT workflowID FROM workflow");
            while(rs.next()){
                String text = rs.getString("workflowID");
                allIdList.add(text);
            }
            
            if(allIdList.isEmpty()){
                idtxt.setText("w1");
            }
            else{
                String lastId = allIdList.getLast();
                String temp = "";
                for(int i=1; i<lastId.length(); i++){
                    temp = temp + lastId.charAt(i);
                }
                int idnow = Integer.parseInt(temp);
                idnow++;
                String str = "w" + String.valueOf(idnow);
                idtxt.setText(str);
            }
            
        } catch(Exception e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
        
    }
    
    private void OKbuttonActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String idInput = idtxt.getText();
        String titleInput = nameField.getText();
        
        if(titleInput.trim().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Your workflow name is still empty");
        }
        else{
            try{
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                
                PreparedStatement ps = con.prepareStatement("INSERT INTO workflow VALUES(?,?,?,?)");
                ps.setString(1, idInput);
                ps.setString(2, titleInput);
                ps.setInt(3, 0);
                ps.setString(4, userID);
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(getContentPane(), "Successfully created a new workflow!");
                AddWorkflowMenu.open=0;
                setVisible(false);
                new AddWorkflowMenu(userID).setVisible(true);

            }catch(Exception e){
                JOptionPane.showMessageDialog(getContentPane(), e);
            }
        }
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
        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(CreateNewWorkflow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateNewWorkflow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateNewWorkflow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateNewWorkflow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateNewWorkflow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idtxt;
    private javax.swing.JLabel nameLabel;
    private RoundJTextField nameField;
    private App.ButtonCustom OKbutton;
}
