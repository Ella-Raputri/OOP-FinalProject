/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.Color;

/**
 *
 * @author Asus
 */
public class AranaraChatMenu extends javax.swing.JFrame {
    private String userID = "u1";
    private EditAranara parent;
    /**
     * Creates new form AranaraChatMenu
     */
    public AranaraChatMenu(EditAranara parent, String userID) {
        this.userID = userID;
        this.parent = parent;
        setUndecorated(true);
        setResizable(false);
        initComponents();
        initDesign();
    }
    
    public AranaraChatMenu() {        
        setUndecorated(true);
        setResizable(false);
        initComponents();
        initDesign();
    }
    
    private void initDesign(){
        hiBtn = new App.ButtonCustom();
        taskBtn = new App.ButtonCustom();
        wordBtn = new App.ButtonCustom();
        excelBtn = new App.ButtonCustom();
        pptBtn  = new App.ButtonCustom();
        timerBtn = new App.ButtonCustom();
        weatherBtn = new App.ButtonCustom();
        gameBtn = new App.ButtonCustom();
        
        getContentPane().setBackground(Color.white);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(410, 760));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        hiBtn.setForeground(new java.awt.Color(255, 255, 255));
        hiBtn.setText("");
        hiBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hiBtn.png")));
        hiBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        hiBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        hiBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        hiBtn.setColor(Color.white);
        hiBtn.setColorClick(new java.awt.Color(234, 234, 234));
        hiBtn.setColorOver(new java.awt.Color(234, 234, 234));
        hiBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        hiBtn.setRadius(20);
        hiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // hiBtnActionPerformed(evt);
            }
        });
        getContentPane().add(hiBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 73, 128, 119)); 
        
        taskBtn.setForeground(new java.awt.Color(255, 255, 255));
        taskBtn.setText("");
        taskBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/taskBtn.png")));
        taskBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        taskBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        taskBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        taskBtn.setColor(Color.white);
        taskBtn.setColorClick(new java.awt.Color(234, 234, 234));
        taskBtn.setColorOver(new java.awt.Color(234, 234, 234));
        taskBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        taskBtn.setRadius(20);
        taskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // taskBtnActionPerformed(evt);
            }
        });
        getContentPane().add(taskBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 73, 128, 119)); 
        
        wordBtn.setForeground(new java.awt.Color(255, 255, 255));
        wordBtn.setText("");
        wordBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/wordBtn.png")));
        wordBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        wordBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        wordBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        wordBtn.setColor(Color.white);
        wordBtn.setColorClick(new java.awt.Color(234, 234, 234));
        wordBtn.setColorOver(new java.awt.Color(234, 234, 234));
        wordBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        wordBtn.setRadius(20);
        wordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // wordBtnActionPerformed(evt);
            }
        });
        getContentPane().add(wordBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 225, 128, 119)); 
        
        excelBtn.setForeground(new java.awt.Color(255, 255, 255));
        excelBtn.setText("");
        excelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/excelBtn.png")));
        excelBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        excelBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        excelBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        excelBtn.setColor(Color.white);
        excelBtn.setColorClick(new java.awt.Color(234, 234, 234));
        excelBtn.setColorOver(new java.awt.Color(234, 234, 234));
        excelBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        excelBtn.setRadius(20);
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // excelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(excelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 225, 128, 119)); 
        
        pptBtn.setForeground(new java.awt.Color(255, 255, 255));
        pptBtn.setText("");
        pptBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/pptBtn.png")));
        pptBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        pptBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        pptBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        pptBtn.setColor(Color.white);
        pptBtn.setColorClick(new java.awt.Color(234, 234, 234));
        pptBtn.setColorOver(new java.awt.Color(234, 234, 234));
        pptBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        pptBtn.setRadius(20);
        pptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // pptBtnActionPerformed(evt);
            }
        });
        getContentPane().add(pptBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 377, 128, 119)); 
        
        timerBtn.setForeground(new java.awt.Color(255, 255, 255));
        timerBtn.setText("");
        timerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/timerBtn.png")));
        timerBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        timerBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        timerBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        timerBtn.setColor(Color.white);
        timerBtn.setColorClick(new java.awt.Color(234, 234, 234));
        timerBtn.setColorOver(new java.awt.Color(234, 234, 234));
        timerBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        timerBtn.setRadius(20);
        timerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // timerBtnActionPerformed(evt);
            }
        });
        getContentPane().add(timerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 377, 128, 119)); 
        
        weatherBtn.setForeground(new java.awt.Color(255, 255, 255));
        weatherBtn.setText("");
        weatherBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/weatherBtn.png")));
        weatherBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        weatherBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        weatherBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        weatherBtn.setColor(Color.white);
        weatherBtn.setColorClick(new java.awt.Color(234, 234, 234));
        weatherBtn.setColorOver(new java.awt.Color(234, 234, 234));
        weatherBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        weatherBtn.setRadius(20);
        weatherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // weatherBtnActionPerformed(evt);
            }
        });
        getContentPane().add(weatherBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 526, 128, 119)); 
        
        gameBtn.setForeground(new java.awt.Color(255, 255, 255));
        gameBtn.setText("");
        gameBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/gameBtn.png")));
        gameBtn.setBorderColor(new java.awt.Color(155, 154, 154));
        gameBtn.setBorderColorNotOver(new java.awt.Color(155, 154, 154));
        gameBtn.setBorderColorOver(new java.awt.Color(155, 154, 154));
        gameBtn.setColor(Color.white);
        gameBtn.setColorClick(new java.awt.Color(234, 234, 234));
        gameBtn.setColorOver(new java.awt.Color(234, 234, 234));
        gameBtn.setFont(new java.awt.Font("Montserrat Semibold", 0, 14)); // NOI18N
        gameBtn.setRadius(20);
        gameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // gameBtnActionPerformed(evt);W
            }
        });
        getContentPane().add(gameBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 526, 128, 119)); 
        
        
        pack();
        //setLocationRelativeTo(parent);
        int parentX = parent.getX();
        int parentY = parent.getY();
        setLocation(parentX, parentY);
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
            java.util.logging.Logger.getLogger(AranaraChatMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AranaraChatMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AranaraChatMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AranaraChatMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AranaraChatMenu().setVisible(true);
            }
        });
    }
    
    private App.ButtonCustom hiBtn;
    private App.ButtonCustom taskBtn;
    private App.ButtonCustom wordBtn;
    private App.ButtonCustom excelBtn;
    private App.ButtonCustom pptBtn;
    private App.ButtonCustom timerBtn;
    private App.ButtonCustom weatherBtn;
    private App.ButtonCustom gameBtn;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
