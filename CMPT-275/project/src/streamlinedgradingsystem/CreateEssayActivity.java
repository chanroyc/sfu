/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamlinedgradingsystem;

import ca.sfu.cmpt275.deliverable.colinq.Course;
import ca.sfu.cmpt275.deliverable.colinq.User;
import ca.sfu.cmpt275.deliverable.telunc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jsargent
 */
public class CreateEssayActivity extends javax.swing.JFrame {

    private User userModel;
    private Course courseModel;
    
    String actName;
    String solPath;
    String actType;
    String language;
    String subPath;
    String dueDate;
    int actID;
//    Rubric actRubric;
    int courseid;
    DateFormat format;
    boolean createRubric = false;
    String sqlString1;
//    Activity essay;
    /**
     * Creates Essay activity
     */
    public CreateEssayActivity(User userModel, Course courseModel) {
        this.userModel = userModel;
        this.courseModel = courseModel;
        
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        solutionPathField = new javax.swing.JTextField();
        actLanguage = new javax.swing.JTextField();
        submissionPath = new javax.swing.JTextField();
        dueDateLabel = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        createRubricButton = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Create Essay Activity");

        jLabel2.setText("Activity name:");

        jLabel3.setText("Model Solution:");

        jLabel4.setText("Language:");

        jLabel5.setText("Submission Path:");

        jLabel6.setText("Due Date:");

        jLabel7.setText("Create Rubric:");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        solutionPathField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solutionPathFieldActionPerformed(evt);
            }
        });

        actLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actLanguageActionPerformed(evt);
            }
        });

        submissionPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submissionPathActionPerformed(evt);
            }
        });

        dueDateLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dueDateLabelActionPerformed(evt);
            }
        });

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        createRubricButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRubricButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(227, 227, 227)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(239, 239, 239)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(60, 60, 60)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(solutionPathField)
                                .addComponent(actLanguage)
                                .addComponent(submissionPath)
                                .addComponent(dueDateLabel)
                                .addComponent(createRubricButton)))))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(solutionPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(actLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(submissionPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dueDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(createRubricButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        
    }//GEN-LAST:event_nameFieldActionPerformed

    private void solutionPathFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solutionPathFieldActionPerformed
      
    }//GEN-LAST:event_solutionPathFieldActionPerformed

    private void actLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actLanguageActionPerformed
       
    }//GEN-LAST:event_actLanguageActionPerformed

    private void submissionPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submissionPathActionPerformed
      
    }//GEN-LAST:event_submissionPathActionPerformed

    private void dueDateLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dueDateLabelActionPerformed

    }//GEN-LAST:event_dueDateLabelActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        actName = nameField.getText();
        language = actLanguage.getText();
        dueDate = dueDateLabel.getText();
        solPath = solutionPathField.getText();
        subPath = submissionPath.getText();
        actType = ca.sfu.cmpt275.deliverable.colinq.Activity.ESSAY_TYPE;
        actID = -1;
        String sUsername = "c275g11";
	String sPassword = "bL344y3Emh2dPtaT";
        String connectionUrl = "jdbc:sqlserver://cypress;" + "user = " + sUsername + ";" + "password = " + sPassword;
 	 
        Connection conn = null;
	Statement stmt = null;

        
        
            try{
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String sql;
            
                    conn = DriverManager.getConnection(connectionUrl);
                    stmt = conn.createStatement();
                    
                    generateUniqueRandomActID(stmt);
                    sql = "insert into Activity "
                            + "values(" + actID + ", " + courseModel.getCourseID() +  
                            ", '" + actName + "', '" + actType + "', '" + dueDate + "','" + 
                            language + "', '" + subPath + "', '" + 0 + "','" + solPath + "')";
                    
                    //" + activityID + ",
                    
                    
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"add item success","success", JOptionPane.INFORMATION_MESSAGE);

                    stmt.close();
                    conn.close();
                    if(createRubric) {
                        new CreateRubric(actID).setVisible(true);
                    }
            }
            catch(SQLException se){
                    //Handle errors for JDBC
                    JOptionPane.showMessageDialog(null,se,"SQLException", JOptionPane.INFORMATION_MESSAGE);
                    se.printStackTrace();
            }catch(Exception e){
                    //Handle errors for Class.forName
                    JOptionPane.showMessageDialog(null,e,"Exception", JOptionPane.INFORMATION_MESSAGE);
                    e.printStackTrace();
            }
        
        
        if(createRubric) {
            new CreateRubric(actID).setVisible(true);
            JOptionPane.showMessageDialog(null,"add rubric success","success", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_createButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        new CreateActivity(userModel, courseModel).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void createRubricButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRubricButtonActionPerformed
        createRubric = true;
    }//GEN-LAST:event_createRubricButtonActionPerformed

     private void generateUniqueRandomActID(Statement stmt) {
        try {
            actID = generateRandomID();
            String getActID_sql = "SELECT activityID FROM Activity WHERE courseID = " + 
                    courseModel.getCourseID() + " AND activityID = " + actID;
            ResultSet rs = stmt.executeQuery(getActID_sql);
            int resultCounter = 0;
            System.out.println("ActID is: " + actID);
            while(rs.next()) {
                resultCounter++;    
            }
            if(resultCounter > 0) {
                generateUniqueRandomActID(stmt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateProgrammingActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int generateRandomID() {
        Random rand = new Random();
        int randomID = rand.nextInt(Integer.MAX_VALUE) + 10;
        return randomID;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actLanguage;
    private javax.swing.JButton backButton;
    private javax.swing.JButton createButton;
    private javax.swing.JCheckBox createRubricButton;
    private javax.swing.JTextField dueDateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField solutionPathField;
    private javax.swing.JTextField submissionPath;
    // End of variables declaration//GEN-END:variables
}
