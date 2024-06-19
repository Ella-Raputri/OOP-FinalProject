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
    private AddWorkflowMenu home;
    /**
     * Creates new form CreateNewWorkflow
     */
    
    public CreateNewWorkflow(String userID, AddWorkflowMenu home) {
        setResizable(false);
        setTitle("Create New Workflow");
        this.userID = userID;
        this.home = home;
        initComponents();
        myinit();
    }
    
    private void myinit(){
        //set the background and always on top
        getContentPane().setBackground(Color.white);
        setAlwaysOnTop(true);
        
        //set the close operation 
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // when pressing the X button, ask for xonfirmation first
                int option = JOptionPane.showConfirmDialog(getContentPane(), 
                        "Do you really want to go back?", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    //if yes, then set invisible and 
                    //make the opened window in AddWorkflowMenu to become 0 again
                    setVisible(false);
                    AddWorkflowMenu.open=0;
                } 
            }
        });
        
        //init the components
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
        
        //generate the last ID
        LinkedList<String> allIdList = new LinkedList<>();
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT workflowID FROM workflow");
            //query all the workflow inside the database
            while(rs.next()){
                String text = rs.getString("workflowID");
                allIdList.add(text);
            }
            
            // if it is empty
            if(allIdList.isEmpty()){
                idtxt.setText("w1");
            }
            else{
                //if not, then generate the ID based on the last ID
                String lastId = allIdList.getLast();
                String temp = "";
                for(int i=1; i<lastId.length(); i++){
                    temp = temp + lastId.charAt(i);
                }
                int idnow = Integer.parseInt(temp);
                idnow++;
                String str = "w" + String.valueOf(idnow);
                idtxt.setText(str); //set the last ID in the label
            }
            
        } catch(Exception e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
        
    }
    
    private void OKbuttonActionPerformed(java.awt.event.ActionEvent evt) {  
        //get the ID and name of the new workflow
        String idInput = idtxt.getText();
        String titleInput = nameField.getText();
        
        if(titleInput.trim().isEmpty()){ //if title is empty
            JOptionPane.showMessageDialog(getContentPane(), "Your workflow name is still empty");
        }
        else{
            try{
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                
                //insert the ID and name of the new workflow to the database
                PreparedStatement ps = con.prepareStatement("INSERT INTO workflow VALUES(?,?,?,?)");
                ps.setString(1, idInput);
                ps.setString(2, titleInput);
                ps.setInt(3, 0);
                ps.setString(4, userID);
                ps.executeUpdate();
                
                //display success message
                JOptionPane.showMessageDialog(getContentPane(), "Successfully created a new workflow!");
                //set invisible again and the opened window become 0
                AddWorkflowMenu.open=0;
                setVisible(false);
                
                home.queryWorkflow();
                home.cloneablePanel.removeAll();
                home.createClonedPanels(home.workflowList, home.workflowList.size());
                home.createAddPanel();

            }catch(Exception e){
                e.printStackTrace();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idtxt;
    private javax.swing.JLabel nameLabel;
    private RoundJTextField nameField;
    private App.ButtonCustom OKbutton;
}
