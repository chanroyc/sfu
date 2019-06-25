/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamlinedgradingsystem;

import ca.sfu.cmpt275.deliverable.colinq.*;
import ca.sfu.cmpt275.deliverable.telunc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author jsargent
 */
public class CreateProgrammingActivity_old extends javax.swing.JFrame {

    private User userModel;
    private Course courseModel;
    /**
     * Creates new form ProgramActivityForm
     */
//    Activity programming;
    String actName;
    String solPath;
    String language;
    String actType;
    String subPath;
    String dueDate;
    int actID = -1;
//    Rubric actRubric;
    int numTest;
    int courseid;
    SimpleDateFormat format;
    boolean createRubric = false;
    String sqlString1;
//    CreateCourse course;
    
    
    public CreateProgrammingActivity_old(User userModel, Course courseModel) {
        this.userModel = userModel;
        this.courseModel = courseModel;
        
//        programming = new ProgrammingActivity(actName, solPath, actType, dueDate, language, subPath, courseid, actRubric, numTest);
//        course = new CreateCourse();
        format = new SimpleDateFormat("yyyy-mm-dd");       
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

        nameField = new javax.swing.JTextField();
        activityName = new javax.swing.JLabel();
        solutionpath = new javax.swing.JLabel();
        activityLanguage = new javax.swing.JLabel();
        actDueDate = new javax.swing.JLabel();
        submissionpath = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        solutionPathFIeld = new javax.swing.JTextField();
        actLanguage = new javax.swing.JTextField();
        submissionPath = new javax.swing.JTextField();
        dueDateLabel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        numtest = new javax.swing.JTextField();
        createRubricButton = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        activityName.setText("Activity Name:");

        solutionpath.setText("Solution Path:");

        activityLanguage.setText("Language:");

        actDueDate.setText("Due Date:");

        submissionpath.setText("Submission Path:");

        jLabel6.setText("Create Rubric:");

        solutionPathFIeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solutionPathFIeldActionPerformed(evt);
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Create Programming Activity");

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

        jLabel1.setText("Number of Test:");

        numtest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numtestActionPerformed(evt);
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
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(activityName)
                            .addComponent(submissionpath)
                            .addComponent(activityLanguage)
                            .addComponent(solutionpath)
                            .addComponent(actDueDate)
                            .addComponent(jLabel1))
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameField)
                                .addComponent(solutionPathFIeld)
                                .addComponent(actLanguage)
                                .addComponent(submissionPath)
                                .addComponent(dueDateLabel)
                                .addComponent(numtest, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(createRubricButton))
                        .addContainerGap(135, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(activityName)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(solutionpath)
                            .addComponent(solutionPathFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(activityLanguage)
                            .addComponent(actLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(submissionpath))
                    .addComponent(submissionPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dueDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actDueDate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numtest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(createRubricButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        
    }//GEN-LAST:event_nameFieldActionPerformed

    private void actLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actLanguageActionPerformed
       
    }//GEN-LAST:event_actLanguageActionPerformed

    private void dueDateLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dueDateLabelActionPerformed
        
    }//GEN-LAST:event_dueDateLabelActionPerformed

    private void solutionPathFIeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solutionPathFIeldActionPerformed
        
    }//GEN-LAST:event_solutionPathFIeldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
       
        new CreateActivity(userModel, courseModel).setVisible(true);
        this.setVisible(false);
              
    }//GEN-LAST:event_backButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        actName = nameField.getText();
        language = actLanguage.getText();
        dueDate = dueDateLabel.getText();
        solPath = solutionPathFIeld.getText();
        subPath = submissionPath.getText();
        actType = Activity.PROGRAMMING_TYPE;
        numTest = Integer.parseInt(numtest.getText());
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
                            language + "', '" + subPath + "', '" + numTest + "','" + solPath + "')";
                    
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
        
        
        
        
        
        
   //     sqlString1 = "INSERT INTO "
    }//GEN-LAST:event_createButtonActionPerformed

    private void numtestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numtestActionPerformed
        
    }//GEN-LAST:event_numtestActionPerformed

    private void submissionPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submissionPathActionPerformed
       
    }//GEN-LAST:event_submissionPathActionPerformed

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
            Logger.getLogger(CreateProgrammingActivity_old.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int generateRandomID() {
        Random rand = new Random();
        int randomID = rand.nextInt(Integer.MAX_VALUE) + 10;
        return randomID;
    }
    
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actDueDate;
    private javax.swing.JTextField actLanguage;
    private javax.swing.JLabel activityLanguage;
    private javax.swing.JLabel activityName;
    private javax.swing.JButton backButton;
    private javax.swing.JButton createButton;
    private javax.swing.JCheckBox createRubricButton;
    private javax.swing.JTextField dueDateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField numtest;
    private javax.swing.JTextField solutionPathFIeld;
    private javax.swing.JLabel solutionpath;
    private javax.swing.JTextField submissionPath;
    private javax.swing.JLabel submissionpath;
    // End of variables declaration//GEN-END:variables
}
