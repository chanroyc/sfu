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
import java.util.ArrayList;


import javax.swing.JComboBox;
import javax.swing.JOptionPane;
//import ca.sfu.cmpt275.deliverable.colinq.Activity;


/**
 *
 * @author chanroyc
 */
public class SelectActivity extends javax.swing.JFrame {

    /**
     * Creates new form SelectActivity
     */
    private Course courseModel;
    private Activity activityModel;
    private User userModel;
    private int isView;
    private ArrayList<Activity>activities = new ArrayList<Activity>();
    
    private Connection con;
    public SelectActivity(User userModel, Course courseModel, int isView) {
        this.courseModel = courseModel;        
        this.userModel = userModel;
        this.isView = isView;
        this.activityModel = new Activity();
        initComponents();
        fillcombo();
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
        activitySelectionComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Select Activity");

        activitySelectionComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        activitySelectionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Select an activity)" }));
        activitySelectionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activitySelectionComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Please select an activity to view:");

        backButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(activitySelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(105, 105, 105)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(activitySelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageActivitiesGUI(userModel, courseModel).setVisible(true);
            }
        });
    }//GEN-LAST:event_backButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
                
        if (activityModel.getActivityID() == 0) {
            JOptionPane.showMessageDialog(null,"Please select an activity.","Reminder", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.setVisible(false);
            String activityType = activityModel.getActivityType();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    if (isView == 0){
                        new ViewActivity(userModel, courseModel, activityModel).setVisible(true);
                    }
                    else if (isView == 1 && activityType.equals("programming activity")){
                        new ModifyProgrammingActivity(userModel, courseModel, activityModel).setVisible(true);
                    }
                    else if (isView == 1 && activityType.equals("essay activity")){
                        new ModifyEssayActivity(userModel, courseModel, activityModel).setVisible(true);
                    }
                    else if (isView == 1 && activityType.equals("problemset activity")){
                        new ModifyProblemSetActivity(userModel, courseModel, activityModel).setVisible(true);
                    }
                    else if (isView == 1 && activityType.equals("multiplechoice activity")){
                        new ModifyMultipleChoiceActivity(userModel, courseModel, activityModel).setVisible(true);
                    }
                }
            });
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void activitySelectionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activitySelectionComboBoxActionPerformed
        // TODO add your handling code here:
        JComboBox cb = (JComboBox)evt.getSource();
        String chosenActivity = (String)cb.getSelectedItem();
        int activityID;
        
        if (chosenActivity == "(Select an activity)"){
            activityModel.setActivityID(0);
        }else{

        String[] splittedInfo = chosenActivity.split(",");
        int activityIDIndex = 0;
        activityID = Integer.parseInt(splittedInfo[activityIDIndex].trim());
        
        System.out.println("activityID is: " + activityID);
        
        
        for(Activity c : activities) {
            System.out.println("Activities are: ");
            c.display();
            if(c.getActivityID() == activityID) {
                activityModel = c;
                break;
            }
        }
        if (activityModel != null) {
            System.out.println("activity selected is: " + activityModel.getActivityID());
            System.out.println("activity type is: " + activityModel.getActivityType());
        }
        }
                                             
    }//GEN-LAST:event_activitySelectionComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */

    private void fillcombo() {

		String DB_URL = "jdbc:sqlserver://cypress;";
		String USER = "c275g11";
		String PASS = "bL344y3Emh2dPtaT";
		Connection conn = null;
		Statement stmt = null;

                try{
                    
                    String sql;
                    
                    int courseID = courseModel.getCourseID();
//                    int row = 0;
                    
                    
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    conn = DriverManager.getConnection(DB_URL,USER,PASS);
                    stmt = conn.createStatement();
                    

                    sql = "SELECT * from Activity where courseID = '"+ courseID +"'" ;
                    
                    ResultSet rs = stmt.executeQuery(sql);
                    
                    ca.sfu.cmpt275.deliverable.colinq.Activity activity;
                    activity = new ca.sfu.cmpt275.deliverable.colinq.Activity();
                    
                    processResult(rs);
                    
                }
		catch(SQLException se){
			//Handle errors for JDBC
			JOptionPane.showMessageDialog(null,se,"SQLException", JOptionPane.INFORMATION_MESSAGE);
                        se.printStackTrace();
		}
                
		catch(Exception e){
			//Handle errors for Class.forName
			JOptionPane.showMessageDialog(null,e,"Exception", JOptionPane.INFORMATION_MESSAGE);
                        e.printStackTrace();

		}
    }
        private void processResult(ResultSet rs) {
        try {
            while(rs.next()) {
                Activity activity = new Activity();
                activity.setDueDate(rs.getString("dueDate"));
                activity.setActivityID(rs.getInt("activityID"));
                activity.setCourseID(rs.getInt("courseID"));
                activity.setSubmissionPath(rs.getString("pathToSubmissions"));
                activity.setLanguage(rs.getString("language"));
                activity.setActivityType(rs.getString("activityType"));
                activity.setSolutionPath(rs.getString("pathToSolution"));
                activity.setActivityName(rs.getString("activityName"));
                activity.setNumTests(rs.getInt("numTests"));
                
                activitySelectionComboBox.addItem(activity.getActivityID() + ", "
                                                + activity.getActivityName() + ", "
                                                + activity.getdueDate());
                activities.add(activity);
                
            }
        } catch (SQLException ex) {
            
//            Logger.getLogger(InstructorMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
            
            ex.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox activitySelectionComboBox;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton nextButton;
    // End of variables declaration//GEN-END:variables
}