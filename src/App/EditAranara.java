/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class EditAranara extends javax.swing.JFrame {
    private String userID = "u1";
    private String aranaraName = "Ararycan";
    private int affection;
    /**
     * Creates new form EditAranara
     */
    public EditAranara() {
        setResizable(false);
        setTitle("Aranara Activity Page");
        initComponents();
        initHover();
        initBasedOnAranara();
    }
    
    public EditAranara(String aranaraName, String uID) {
        this.aranaraName = aranaraName;
        this.userID = uID;
        setResizable(false);
        setTitle("Aranara Activity Page");
        initComponents();
        initHover();
        initBasedOnAranara();
    }       
    
    private void initHover(){
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new AranaraMenu(userID).setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_aranara_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_aranara.png")));
            }
        });
        
        patBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                patBtnActionPerformed();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                patBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/pat_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                patBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/pat.png")));
            }
        });
        
        setDefaultBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setDefaultBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/set_default_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setDefaultBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/set_default.png")));
            }
        });
    }
    
    private void patBtnActionPerformed(){
        affection += 1;
        String col = "aff_" + aranaraName.toLowerCase();
        try{
            Connection con = ConnectionProvider.getCon();

            PreparedStatement ps = con.prepareStatement("UPDATE user SET "+ col +" = ? WHERE userID = ?");
            ps.setInt(1, affection);
            ps.setString(2, this.userID);
            ps.executeUpdate();
            //success message

            //refresh progress bar
            affProgressBar.setValue(affection);
            affectiontxt.setText(affection + "/100");

        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    private void initBasedOnAranara(){
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM user WHERE userID = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.userID);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                if (aranaraName.equals("Arama")){
                    int aff = rs.getInt("aff_arama"); 
                    affection = aff;
                    affectiontxt.setText(aff + "/100");
                    affProgressBar.setValue(aff);
                    aranara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/arama.png")));
                }
                else if (aranaraName.equals("Ararycan")){
                   int aff = rs.getInt("aff_ararycan"); 
                   affection = aff;
                   affectiontxt.setText(aff + "/100");                   
                   affProgressBar.setValue(aff);
                   aranara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/ararycan.png")));
                }
                else if (aranaraName.equals("Arabalika")){
                   int aff = rs.getInt("aff_arabalika");
                   affection = aff;
                   affectiontxt.setText(aff + "/100");                   
                   affProgressBar.setValue(aff);
                   aranara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/arabalika.png")));
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
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

        aranara = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
        patBtn = new javax.swing.JLabel();
        setDefaultBtn = new javax.swing.JLabel();
        affectiontxt = new javax.swing.JLabel();
        pattxt = new javax.swing.JLabel();
        setDefaulttxt = new javax.swing.JLabel();
        affectionLevel = new javax.swing.JLabel();
        affProgressBar = new javax.swing.JProgressBar();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aranara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/arama.png"))); // NOI18N
        getContentPane().add(aranara, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 239, -1, -1));

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_aranara.png"))); // NOI18N
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 17, -1, -1));
        backBtn.getAccessibleContext().setAccessibleName("");

        patBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/pat.png"))); // NOI18N
        getContentPane().add(patBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1123, 567, -1, -1));

        setDefaultBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/set_default.png"))); // NOI18N
        getContentPane().add(setDefaultBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(967, 567, -1, -1));

        affectiontxt.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        affectiontxt.setText("xxx/100");
        getContentPane().add(affectiontxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 60, -1, -1));

        pattxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        pattxt.setText("Pat");
        getContentPane().add(pattxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1153, 670, -1, -1));

        setDefaulttxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        setDefaulttxt.setText("Set As Default");
        getContentPane().add(setDefaulttxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(944, 670, -1, -1));

        affectionLevel.setFont(new java.awt.Font("Mochiy Pop One", 0, 20)); // NOI18N
        affectionLevel.setText("Affection Level");
        getContentPane().add(affectionLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 18, -1, -1));

        affProgressBar.setForeground(new java.awt.Color(255, 152, 170));
        affProgressBar.setToolTipText("");
        affProgressBar.setValue(10);
        affProgressBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(affProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(892, 58, 343, 28));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_aranara.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
            java.util.logging.Logger.getLogger(EditAranara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditAranara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditAranara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditAranara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditAranara().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar affProgressBar;
    private javax.swing.JLabel affectionLevel;
    private javax.swing.JLabel affectiontxt;
    private javax.swing.JLabel aranara;
    private javax.swing.JLabel backBtn;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel patBtn;
    private javax.swing.JLabel pattxt;
    private javax.swing.JLabel setDefaultBtn;
    private javax.swing.JLabel setDefaulttxt;
    // End of variables declaration//GEN-END:variables
}
