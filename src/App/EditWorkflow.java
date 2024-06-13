/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Asus
 */
public class EditWorkflow extends javax.swing.JFrame {
    private String workflowID = "w1";
    private String userID = "u1";
    private Workflow current_workflow;
    private JPanel contentPane;
    private JPanel cloneablePanel;
    private JScrollPane scrollPane;
    public static int open = 0;
    private LinkedList<Flow> flowList = new LinkedList<>();
    private String flowIDTemp;
    private CloneablePanelFlow currentPanel = null;
    
    
    public EditWorkflow() {
        setResizable(false);
        setTitle("Edit Workflow");
        initComponents();
        myinit();
        initDesign();
    }
    
    public EditWorkflow(String workflowid, String userid) {
        this.workflowID = workflowid;
        this.userID = userid;
        setResizable(false);
        setTitle("Edit Workflow");
        initComponents();
        myinit();
        initDesign();
    }
    
    private void queryWorkflow(){
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM workflow WHERE workflowID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, this.workflowID);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String id = rs.getString("workflowID");
                String title = rs.getString("title");
                int checkpoint = rs.getInt("checkpoint");
                String userid = rs.getString("userID");
                current_workflow = new Workflow(title, checkpoint, id, userid);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    private void initDesign(){
        queryWorkflow();
        
        backButton = new javax.swing.JLabel();
        checkpoint = new javax.swing.JLabel();
        workflow_name = new javax.swing.JLabel();
        multipleDay = new javax.swing.JRadioButton();
        oneDay = new javax.swing.JRadioButton();
        fromField = new PlaceHolderTextField("Day",10);
        nameField = new PlaceHolderTextField("Name",0);
        fromtxt = new javax.swing.JLabel();
        fromComboBox = new javax.swing.JComboBox<>();
        theDay_from = new javax.swing.JLabel();
        colortxt = new javax.swing.JLabel();
        toField = new PlaceHolderTextField("Day",10);
        colorComboBox = new javax.swing.JComboBox<>();
        toComboBox = new javax.swing.JComboBox<>();
        theDay_to = new javax.swing.JLabel();
        totxt = new javax.swing.JLabel();
        viewtxt = new javax.swing.JLabel();
        saveBtn = new App.ButtonCustom();
        deleteBtn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesArea = new PlaceHolderJTextArea("Notes");
        optGrp = new javax.swing.ButtonGroup();
        generateBtn = new App.ButtonCustom();
        bg = new javax.swing.JLabel();
        
        //append the two radio buttons to the button group 
        //so that only one radio button can be selecter
        optGrp.add(oneDay); optGrp.add(multipleDay);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_btn.png"))); 
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 17, -1, -1));
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (open == 0){
                  setVisible(false);
                  new AddWorkflowMenu(userID).setVisible(true);  
                }
                else{
                  JOptionPane.showMessageDialog(getContentPane(), "There is one current operation window open.");
                }                
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_btn_hover.png"))); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/back_btn.png"))); 
            }
        });

        checkpoint.setFont(new java.awt.Font("Montserrat", 0, 24)); 
        checkpoint.setText("Total: " + current_workflow.getCheckpoint() + " checkpoints");
        getContentPane().add(checkpoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 120, -1, -1));

        workflow_name.setFont(new java.awt.Font("Montserrat SemiBold", 0, 40)); 
        workflow_name.setForeground(new java.awt.Color(0, 141, 189));
        workflow_name.setText(this.current_workflow.getTitle());
        getContentPane().add(workflow_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 54, -1, -1));

        multipleDay.setBackground(new java.awt.Color(255, 255, 255));
        multipleDay.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        multipleDay.setText("Multiple-day event");
        multipleDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toField.setEnabled(true);
                toComboBox.setEnabled(true);
                revalidate();
                repaint();
            }
        });
        getContentPane().add(multipleDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 271, -1, -1));

        oneDay.setBackground(new java.awt.Color(255, 255, 255));
        oneDay.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        oneDay.setSelected(true);
        oneDay.setText("One-day event");
        oneDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toField.setEnabled(false);
                toComboBox.setEnabled(false);
                revalidate();
                repaint();
            }
        });
        getContentPane().add(oneDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 271, -1, -1));

        fromField.setBackground(new java.awt.Color(234, 234, 234));
        fromField.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        fromField.setForeground(new java.awt.Color(93, 93, 93));
        fromField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fromField.setText("Day");
        fromField.setBorder(new EmptyBorder(new Insets(5, 10, 5, 10)));
        getContentPane().add(fromField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 317, 80, 38));

        nameField.setBackground(new java.awt.Color(234, 234, 234));
        nameField.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        nameField.setForeground(new java.awt.Color(93, 93, 93));
        nameField.setBorder(new EmptyBorder(new Insets(5, 15, 5, 10)));
        nameField.setText("Name");
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 211, 427, 41));

        fromtxt.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        fromtxt.setText("The Day");
        getContentPane().add(fromtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 321, -1, -1));

        fromComboBox.setBackground(new java.awt.Color(234, 234, 234));
        fromComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        fromComboBox.setForeground(new java.awt.Color(93, 93, 93));
        fromComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Before", "After" }));
        fromComboBox.setToolTipText("");
        getContentPane().add(fromComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 317, 140, 38));

        theDay_from.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        theDay_from.setText("From");
        getContentPane().add(theDay_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 322, -1, -1));

        colortxt.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        colortxt.setText("Color");
        getContentPane().add(colortxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, -1, -1));

        toField.setBackground(new java.awt.Color(234, 234, 234));
        toField.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        toField.setForeground(new java.awt.Color(93, 93, 93));
        toField.setHorizontalAlignment(javax.swing.JTextField.CENTER);        
        toField.setBorder(new EmptyBorder(new Insets(5, 15, 5, 10)));
        toField.setEnabled(false);
        getContentPane().add(toField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 374, 80, 38));

        colorComboBox.setBackground(new java.awt.Color(234, 234, 234));
        colorComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        colorComboBox.setForeground(new java.awt.Color(93, 93, 93));
        colorComboBox.setMaximumRowCount(10);
        colorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blue", "Red", "Orange", "Yellow", "Green", "Purple", "Pink", "Brown" }));
        colorComboBox.setToolTipText("");
        getContentPane().add(colorComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 530, 100, 38));

        toComboBox.setBackground(new java.awt.Color(234, 234, 234));
        toComboBox.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        toComboBox.setForeground(new java.awt.Color(93, 93, 93));
        toComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Before", "After" }));
        toComboBox.setToolTipText("");
        toComboBox.setEnabled(false);
        getContentPane().add(toComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 374, 140, 38));

        theDay_to.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        theDay_to.setText("To");
        getContentPane().add(theDay_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, -1, -1));

        totxt.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        totxt.setText("The Day");
        getContentPane().add(totxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, -1, -1));

        viewtxt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 40)); 
        viewtxt.setForeground(new java.awt.Color(0, 141, 189));
        viewtxt.setText("View Workflow");
        getContentPane().add(viewtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(828, 54, -1, -1));

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
        saveBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); 
        saveBtn.setRadius(50);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        getContentPane().add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 605, 110, 47));

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_flow.png"))); 
        deleteBtn.setEnabled(false);
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 615, -1, -1));

        notesArea.setBackground(new java.awt.Color(234, 234, 234));
        notesArea.setColumns(22);
        notesArea.setFont(new java.awt.Font("Montserrat", 0, 18)); 
        notesArea.setForeground(new java.awt.Color(93, 93, 93));
        notesArea.setRows(3);
        notesArea.setTabSize(5);
        notesArea.setText("Notes");
        notesArea.setBorder(new EmptyBorder(new Insets(5, 10, 5, 10)));
        
        jScrollPane1.setViewportView(notesArea);
        jScrollPane1.setBorder(null);
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));
        
        generateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/generate_text.png")));
        generateBtn.setBackground(Color.white);
        generateBtn.setBorderColor(new java.awt.Color(0,141,189));
        generateBtn.setBorderColorNotOver(new java.awt.Color(0,141,189));
        generateBtn.setBorderColorOver(new java.awt.Color(125, 201, 255));
        generateBtn.setColor(Color.white);
        generateBtn.setColorClick(new java.awt.Color(234,234,234));
        generateBtn.setColorOver(new java.awt.Color(234, 234, 234));
        generateBtn.setRadius(0);
        generateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBtnActionPerformed();
            }
        });
        generateBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                generateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/generate_text_hover.png")));
                generateBtn.setBackground(new java.awt.Color(234, 234, 234));
                generateBtn.setBorderColor(new java.awt.Color(125, 201, 255));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                generateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/generate_text.png")));
                generateBtn.setBackground(Color.white);
                generateBtn.setBorderColor(new java.awt.Color(0, 141, 189));
            }
        });
        getContentPane().add(generateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 23, 98, 29));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/edit_workflow_page.png"))); 
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }
    
    private void generateBtnActionPerformed(){
        queryFlow();
        new TextResult(flowList).setVisible(true);
        EditWorkflow.open = 1;
    }
    
    private void queryFlow(){
        flowList.clear();
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
                
                Flow flow = new Flow(fID, this.workflowID, fname, ftype, fdayFrom, fdayTo, fnotes, fcolor);
                flowList.add(flow);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    private void myinit(){
        int totalElement = 0;
        queryFlow();
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
        
        createClonedPanels(flowList, totalElement);
        
        ImageIcon bgImage = new ImageIcon("src/App/img/background_adminhome.png");
        contentPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
    }
    
    private void createClonedPanels(LinkedList<Flow> list, int size){
        //panelMap.clear();
        for(int i=0; i<size;i++){
            String id = list.get(i).getId();
            String name = list.get(i).getNameInput();
            String type = list.get(i).getTypeInput();
            int dayFrom = list.get(i).getDayFromInput();
            int dayTo = list.get(i).getDayToInput();
            String note = list.get(i).getNoteInput();
            String color = list.get(i).getColorInput();
            
            // Create a new cloned panel
            // Cloneable Panel
            CloneablePanelFlow clonedPanel = new CloneablePanelFlow(20, Color.white, 2 ,id, name, type, dayFrom, dayTo, note, color);
            // Set your custom width and height for the cloned panel
            int panelWidth = 288;
            int panelHeight = 146;
            

            // Calculate the x and y positions based on row and column indices
            int x = 110;
            int y = 10 + i * (panelHeight + 50);

            // Set the bounds for the cloned panel with your custom size
            clonedPanel.setBounds(x, y, panelWidth, panelHeight);
            clonedPanel.setBackground(new Color(246,252,254));
            
            clonedPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (currentPanel == clonedPanel){
                       currentPanel.setClicked(false);
                       currentPanel = null;
                       clearAllFields();
                       deactivateDeleteBtn();
                    }
                    else{
                        if (currentPanel != null ) {
                            currentPanel.setClicked(false);
                        }
                        clonedPanel.setClicked(true);
                        currentPanel = clonedPanel;
                        handleEditPanel();
                    }   
                }
            });
            
            // Add the cloned panel to the initial panel
            cloneablePanel.add(clonedPanel);
            
            //add the cloned panel to the hash map
            //panelMap.put(id, clonedPanel);
            
            // Adjust preferred size of initial panel to include new panel
            Dimension newSize = new Dimension(cloneablePanel.getWidth(), y + panelHeight + 10); // Adjusted size
            cloneablePanel.setPreferredSize(newSize);
            // Ensure the scroll pane updates its viewport
            scrollPane.revalidate();
            scrollPane.repaint();
            // Scroll to show the new panel
            scrollPane.getVerticalScrollBar().setValue(0);
        }
    }
    
    private void handleEditPanel(){
        //set name field
        nameField.requestFocus();
        nameField.setText(currentPanel.getNameInput());
        
        //set radio button
        if (currentPanel.getTypeInput().equals("One-day event")){
            oneDay.setSelected(true);   
            toField.setEnabled(false);
            toComboBox.setEnabled(false);
            repaint();
        }else{
            multipleDay.setSelected(true);
            toField.setEnabled(true);
            toComboBox.setEnabled(true);
            repaint();
            //set dayTo
            handleDayField(currentPanel.getDayToInput(), toComboBox, toField);
        }
        
        //set day from
        handleDayField(currentPanel.getDayFromInput(), fromComboBox, fromField);
        notesArea.setText(currentPanel.getNoteInput());
        colorComboBox.setSelectedItem(currentPanel.getColorInput());
        
        //activate delete button
        activateDeleteBtn();
    }
    
    private void activateDeleteBtn(){
        removeMouseListeners(deleteBtn);
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_flow_active.png")));
        deleteBtn.setEnabled(true);
        deleteBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteFlow();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_flow_hover.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_flow_active.png")));
            }
        });
    }
    
    private void deleteFlow(){
        String question = "Do you really want to delete " + currentPanel.getNameInput() + "?";
        int a = JOptionPane.showConfirmDialog(getContentPane(), question, "SELECT", JOptionPane.YES_OPTION);
        
        if (currentPanel != null && a == 0){
            String id = currentPanel.getId();
            
            //delete from database
            try{
                Connection conn = ConnectionProvider.getCon();
                String query = "DELETE FROM flow WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, id);
                
                ps.executeUpdate();
                currentPanel = null;
                String message = "Flow/checkpoint deleted successfully.";
                JOptionPane.showMessageDialog(getContentPane(), message);                
                
            }catch(SQLException se){
                JOptionPane.showMessageDialog(getContentPane(), se);
            }
            
            //add the checkpoint by 1 and query to refresh workflow
            updateCheckpoint(-1);
            queryWorkflow();
            checkpoint.setText("Total: " + current_workflow.getCheckpoint() + " checkpoints");

            //refresh the flow view on the right
            queryFlow();
            cloneablePanel.removeAll();
            createClonedPanels(flowList, flowList.size());
            
            //deactivate delete button and clear all fields
            deactivateDeleteBtn();
            clearAllFields();
        } 
    }
    
    private void handleDayField(int day, JComboBox box, JTextField field){
        if (day > 0){
            box.setSelectedItem("After");
            field.setText(""+day);
        }
        else{
            box.setSelectedItem("Before");
            field.setText(""+(day - 2*day));
        }
    }
    
    private void deactivateDeleteBtn(){
        removeMouseListeners(deleteBtn);
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/delete_flow.png")));
        deleteBtn.setEnabled(false);
    }
    
    private void removeMouseListeners(JLabel button) {
        for (MouseListener listener : button.getMouseListeners()) {
            button.removeMouseListener(listener);
        }
    }
    
    private boolean isInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {      
        if (currentPanel == null){
            insertNewFlow();
            deactivateDeleteBtn();
        }
        else{
            editFlow();
        }
    }
    
    private void editFlow(){
        String nameStr = nameField.getText();
        String typeStr;
        String dayToStr;
        
        if(oneDay.isSelected()){
            typeStr = "One-day event";
            dayToStr = "0";
        }
        else{
            typeStr = "Multiple-day event";
            dayToStr = toField.getText();
        }
        
        String dayFromStr = fromField.getText();
        String noteStr = notesArea.getText();
        if (noteStr.equals("Notes")){
            noteStr = "";
        }        
        String colorStr = (String) colorComboBox.getSelectedItem();
        
        //handle user wrong input
        if (nameStr.equals("Name") || nameStr.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Name is still empty.");
        }
        else if (typeStr.trim().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Type is still empty.");
        }
        else if (dayFromStr.equals("Day") || dayFromStr.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Day 'from' is still empty.");
        }
        else if (!isInteger(dayFromStr)){
            JOptionPane.showMessageDialog(getContentPane(), "Day 'from' is not valid.");
        }
        else if (colorStr.trim().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Color is still empty.");
        }        
        //only for multiple day event
        else if ((dayToStr.equals("Day") || dayToStr.equals("")) && typeStr.equals("Multiple-day event")){
            JOptionPane.showMessageDialog(getContentPane(), "Day 'to' is still empty.");
        }
        else if (!isInteger(dayToStr) && typeStr.equals("Multiple-day event")){
            JOptionPane.showMessageDialog(getContentPane(), "Day 'to' is not valid.");
        }
        else{
            //set day from int and day to int
            int dayFromInt = Integer.parseInt(beforeAfterDay(dayFromStr, fromComboBox));
            int dayToInt = Integer.parseInt(beforeAfterDay(dayToStr, toComboBox));
            
            if ((dayFromInt > dayToInt) && typeStr.equals("Multiple-day event")){
                JOptionPane.showMessageDialog(getContentPane(), "Day range is not valid.");
            }
            else{
                flowIDTemp = currentPanel.getId();

                try{
                   Connection con = ConnectionProvider.getCon();
                   
                   String query = "UPDATE flow SET name = ?, type = ?, dayFrom = ?, dayTo = ?, notes = ?, color = ? WHERE id = ?";
                   PreparedStatement ps = con.prepareStatement(query);
                   ps.setString(1, nameStr);
                   ps.setString(2, typeStr);
                   ps.setInt(3, dayFromInt);
                   ps.setInt(4, dayToInt);
                   ps.setString(5, noteStr);
                   ps.setString(6, colorStr);
                   ps.setString(7, flowIDTemp);

                   ps.executeUpdate();
                   //success message
                   String message = "Flow edited successfully.";              
                   JOptionPane.showMessageDialog(getContentPane(), message);

                   //clear all the field
                   clearAllFields();

                   //refresh the flow view on the right
                   queryFlow();
                   cloneablePanel.removeAll();
                   createClonedPanels(flowList, flowList.size());

               }catch(Exception e){
                   JOptionPane.showMessageDialog(getContentPane(), e);
               }
            }   
        } 
    }
    
    private void getFlowLastID(){
        LinkedList<String> allIdList = new LinkedList<>();
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT id FROM flow");
            while(rs.next()){
                String text = rs.getString("id");
                allIdList.add(text);
            }
            
            if(allIdList.isEmpty()){
                flowIDTemp = "f1";
            }
            else{
                String lastId = allIdList.getLast();
                String temp = "";
                for(int i=1; i<lastId.length(); i++){
                    temp = temp + lastId.charAt(i);
                }
                int idnow = Integer.parseInt(temp);
                idnow++;
                flowIDTemp = "f" + String.valueOf(idnow);
            }
            
        } catch(Exception e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }
    
    private void insertNewFlow(){
        String nameStr = nameField.getText();
        String typeStr;
        String dayToStr;
        
        if(oneDay.isSelected()){
            typeStr = "One-day event";
            dayToStr = "0";
        }
        else{
            typeStr = "Multiple-day event";
            dayToStr = toField.getText();
        }
        
        String dayFromStr = fromField.getText();
        String noteStr = notesArea.getText();
        if (noteStr.equals("Notes")){
            noteStr = "";
        }        
        String colorStr = (String) colorComboBox.getSelectedItem();
        
        //handle user wrong input
        if (nameStr.equals("Name") || nameStr.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Name is still empty.");
        }
        else if (typeStr.trim().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Type is still empty.");
        }
        else if (dayFromStr.equals("Day") || dayFromStr.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Day 'from' is still empty.");
        }
        else if (!isInteger(dayFromStr)){
            JOptionPane.showMessageDialog(getContentPane(), "Day 'from' is not valid.");
        }
        else if (colorStr.trim().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Color is still empty.");
        }        
        //only for multiple day event
        else if ((dayToStr.equals("Day") || dayToStr.equals("")) && typeStr.equals("Multiple-day event")){
            JOptionPane.showMessageDialog(getContentPane(), "Day 'to' is still empty.");
        }
        else if (!isInteger(dayToStr) && typeStr.equals("Multiple-day event")){
            JOptionPane.showMessageDialog(getContentPane(), "Day 'to' is not valid.");
        }
        else{
            //set day from int and day to int
            int dayFromInt = Integer.parseInt(beforeAfterDay(dayFromStr, fromComboBox));
            int dayToInt = Integer.parseInt(beforeAfterDay(dayToStr, toComboBox));
            
            if ((dayFromInt > dayToInt) && typeStr.equals("Multiple-day event")){
                JOptionPane.showMessageDialog(getContentPane(), "Day range is not valid.");
            }
            else{
                getFlowLastID();
                Flow new_flow = new Flow(flowIDTemp, this.workflowID, nameStr, typeStr, dayFromInt, dayToInt, noteStr, colorStr);

                try{
                   Connection con = ConnectionProvider.getCon();

                   PreparedStatement ps = con.prepareStatement("insert into flow values(?,?,?,?,?,?,?,?)");
                   ps.setString(1, new_flow.getId());
                   ps.setString(2, new_flow.getWorkflowID());
                   ps.setString(3, new_flow.getNameInput());
                   ps.setString(4, new_flow.getTypeInput());
                   ps.setInt(5, new_flow.getDayFromInput());
                   ps.setInt(6, new_flow.getDayToInput());
                   ps.setString(7, new_flow.getNoteInput());
                   ps.setString(8, new_flow.getColorInput());

                   ps.executeUpdate();
                   //success message
                   String message = "Flow added successfully.";              
                   JOptionPane.showMessageDialog(getContentPane(), message);

                   //clear all the field
                   clearAllFields();

                   //add the checkpoint by 1 and query to refresh workflow
                   updateCheckpoint(1);
                   queryWorkflow();
                   checkpoint.setText("Total: " + current_workflow.getCheckpoint() + " checkpoints");

                   //refresh the flow view on the right
                   queryFlow();
                   cloneablePanel.removeAll();
                   createClonedPanels(flowList, flowList.size());

               }catch(Exception e){
                   JOptionPane.showMessageDialog(getContentPane(), e);
               }
            }   
        }
    }
    
    private void updateCheckpoint(int a){
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            PreparedStatement ps = con.prepareStatement("UPDATE workflow SET checkpoint = ? WHERE workflowID = ?");
            ps.setInt(1, current_workflow.getCheckpoint()+a);
            ps.setString(2, current_workflow.getId());
            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    private void clearAllFields(){
        nameField.setText("");
        oneDay.setSelected(true);
        fromField.setText("");
        fromComboBox.setSelectedIndex(0);
        toField.setText("");
        toComboBox.setSelectedIndex(0);
        notesArea.setText("");
        colorComboBox.setSelectedIndex(0);
    }
        
    private String beforeAfterDay(String str, JComboBox box){
        if (box.getSelectedItem().equals("Before") && (!str.equals("0"))){
            str = "-" + str;
        }
        return str;
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
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea notesArea;
    private javax.swing.JRadioButton multipleDay;
    private javax.swing.JTextField nameField;
    private javax.swing.JRadioButton oneDay;
    private App.ButtonCustom saveBtn;
    private javax.swing.JLabel theDay_from;
    private javax.swing.JLabel colortxt;
    private javax.swing.JLabel theDay_to;
    private javax.swing.JComboBox<String> toComboBox;
    private javax.swing.JTextField toField;
    private javax.swing.JLabel totxt;
    private javax.swing.JLabel viewtxt;
    private javax.swing.JLabel workflow_name;
    private javax.swing.ButtonGroup optGrp;
    private App.ButtonCustom generateBtn;
}
