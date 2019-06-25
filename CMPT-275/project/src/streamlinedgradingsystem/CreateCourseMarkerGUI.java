/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamlinedgradingsystem;

import ca.sfu.cmpt275.deliverable.colinq.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author colinq
 */
public class CreateCourseMarkerGUI extends javax.swing.JFrame {
    private Course courseModel;
    private User userModel;
    private UserManager instructorManager = new UserManager();
    private UserManager TAManager = new UserManager();
    private String chosenInstructor = "";
    private String chosenTA = "";
    private ArrayList<String> chosenInstructors = new ArrayList();
    private ArrayList<String> chosenTAs = new ArrayList();
    private DefaultListModel listModel = new DefaultListModel();
    private Connection con;
    JFileChooser chooser;
    
    /**
     * Creates new form CreateCourseMarkerGUI
     * @param userModel
     * @param courseModel
     */
    public CreateCourseMarkerGUI(User userModel, Course courseModel) {
        this.userModel = userModel;
        this.courseModel = courseModel;
        chooser = new JFileChooser();
        
        initComponents();
        markerList.setModel(listModel);
        connectToDatabase();
        loadMarkersIntoModel();
        
        //debugging---------
        displayMarkers();
        
        addItemsToComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createCourseContTitle = new javax.swing.JLabel();
        createCourseContDescr = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        instructorComboBox = new javax.swing.JComboBox();
        addDelInstrLbl = new javax.swing.JLabel();
        addInstructorButton = new javax.swing.JButton();
        TAComboBox = new javax.swing.JComboBox();
        addDelTALbl = new javax.swing.JLabel();
        addTAButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        markerList = new javax.swing.JList();
        deleteTAButton = new javax.swing.JButton();
        markersAddedLbl = new javax.swing.JLabel();
        CSVPathField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createCourseContTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        createCourseContTitle.setText("Create Course (Continued)");

        createCourseContDescr.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        createCourseContDescr.setText("The following fields can be left empty during creation:");

        createButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        instructorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorComboBoxActionPerformed(evt);
            }
        });

        addDelInstrLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addDelInstrLbl.setText("Add or Delete the Instructor:");

        addInstructorButton.setText("Add");
        addInstructorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInstructorButtonActionPerformed(evt);
            }
        });

        TAComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TAComboBoxActionPerformed(evt);
            }
        });

        addDelTALbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addDelTALbl.setText("Add or Delete a TA:");

        addTAButton.setText("Add");
        addTAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTAButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(markerList);

        deleteTAButton.setText("Delete");
        deleteTAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTAButtonActionPerformed(evt);
            }
        });

        markersAddedLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        markersAddedLbl.setText("Markers Added:");

        CSVPathField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSVPathFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Students Enrolled (CSV path):");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createCourseContDescr, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createCourseContTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(192, 192, 192))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addDelTALbl)
                                    .addComponent(addDelInstrLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(markersAddedLbl)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(addInstructorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TAComboBox, 0, 341, Short.MAX_VALUE)
                                            .addComponent(instructorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(CSVPathField))
                                        .addComponent(addTAButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(deleteTAButton))
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(createCourseContTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createCourseContDescr)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CSVPathField)
                        .addComponent(jButton1))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDelInstrLbl)
                    .addComponent(instructorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addInstructorButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDelTALbl)
                    .addComponent(TAComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addTAButton)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(markersAddedLbl)
                    .addComponent(deleteTAButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        if(insertIntoDatabase()){
        JOptionPane.showMessageDialog(null,
                           "Creation Successful!" , "Information" , JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (isTherePath()) {
            if (insertStudentsIntoDb()){
                JOptionPane.showMessageDialog(null,
                           "Students Successfully Added!" , "Information" , JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,
                           "Student Path Was Not Found." , "Information" , JOptionPane.INFORMATION_MESSAGE);        
            }
        }
         this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ManageCoursesGUI(userModel).setVisible(true);
                }
            });
    }//GEN-LAST:event_createButtonActionPerformed
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateCourseGUI(userModel, courseModel).setVisible(true);
            }
        });
    }//GEN-LAST:event_backButtonActionPerformed

    private void addInstructorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInstructorButtonActionPerformed

        if (!chosenInstructor.equals("")) {
           
            if (chosenInstructors.size() < 1) {
                if (chosenTAs.contains(chosenInstructor)) {
                JOptionPane.showMessageDialog(null,
                           "This Instrucor has been selected as a TA!" , "Reminder" , 
                           JOptionPane.INFORMATION_MESSAGE);
                } else {
                    chosenInstructors.add(chosenInstructor);
                    System.out.println("instructors size is: " + chosenInstructors.size());
                    listModel.addElement(chosenInstructor);
                }
            } else {
                 JOptionPane.showMessageDialog(null,
                           "An instructor has already been selected!" , "Reminder" , 
                           JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_addInstructorButtonActionPerformed

    private void addTAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTAButtonActionPerformed
        if (!chosenTA.equals("")) {
            if (chosenTAs.contains(chosenTA)) {
                JOptionPane.showMessageDialog(null,
                           "This TA has already already been selected!" , "Reminder" , 
                           JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (chosenInstructors.contains(chosenTA)){
                JOptionPane.showMessageDialog(null,
                           "This TA has been selected as the Instructor!" , "Reminder" , 
                           JOptionPane.INFORMATION_MESSAGE);
            }else {
                chosenTAs.add(chosenTA);
                listModel.addElement(chosenTA);
            }
        }
    }//GEN-LAST:event_addTAButtonActionPerformed

    private void instructorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructorComboBoxActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        chosenInstructor = (String)cb.getSelectedItem();
        
        //DEBUG
        System.out.println("Role Instructor is: " + chosenInstructor);
    }//GEN-LAST:event_instructorComboBoxActionPerformed

    private void TAComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TAComboBoxActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        chosenTA = (String)cb.getSelectedItem();
        
        //DEBUG
        System.out.println("Role TA is: " + chosenTA );
    }//GEN-LAST:event_TAComboBoxActionPerformed

    private void deleteTAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTAButtonActionPerformed
       int index = markerList.getSelectedIndex();
       System.out.println("index is: " + index);
       if (index == -1) {
           JOptionPane.showMessageDialog(null,
                   "Nothing is selected!" , "Warning!" ,
                   JOptionPane.WARNING_MESSAGE);
       } else {
        Object removedItem = listModel.remove(index);
        String removedMarker = (String)removedItem;
        if(chosenInstructors.contains(removedMarker)) {
            chosenInstructors.remove(removedMarker);
        } else {
            chosenTAs.remove(removedMarker);
        }
       }
    }//GEN-LAST:event_deleteTAButtonActionPerformed

    private void CSVPathFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSVPathFieldActionPerformed

    }//GEN-LAST:event_CSVPathFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        chooser.setDialogTitle("Specify student file path");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int path = chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String subPathName=f.getAbsolutePath();
        CSVPathField.setText(subPathName);
    }//GEN-LAST:event_jButton1ActionPerformed
  
    private void addItemsToComboBox() {
        ArrayList<User> instructors = instructorManager.getUsers();
        ArrayList<User> TAs = TAManager.getUsers();
        
        addNamesToComboBox(instructors, instructorComboBox);
        addNamesToComboBox(TAs, TAComboBox);
    }
    
    private void addNamesToComboBox(ArrayList<User> users, javax.swing.JComboBox cb) {
        for (User user : users) {
            String item = user.getFirstName().trim() + ", " 
                    + user.getMiddleName().trim() + ", "
                    + user.getLastName().trim() + ", "
                    + user.getEmployeeID();
            cb.addItem(item);
        }
    }
    
    private void loadMarkersIntoModel(){
        try {
            PreparedStatement stat = con.prepareStatement(
                    "SELECT * "
                            + "FROM Account "
                            + "WHERE isTA = 1 OR isInstructor = 1");
            ResultSet accounts = executeQuery(stat);
            processAccountInfo(accounts);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void processAccountInfo(ResultSet rs) {
        try {
            while(rs.next()) {
                if(rs.getInt("isTA") == 1) {
                    User user = new User();
                    user.addAccount(new UserAccount(rs.getInt("accountID")));
                    user.setEmployeeID(rs.getInt("employeeID"));
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastName"));
                    user.setMiddleName(rs.getString("middleName"));
                    TAManager.addUser(user);
                    
                    System.out.println("TA accountID is: " + user.getAccount().getAccountID());
                }
                if(rs.getInt("isInstructor") == 1) {
                    User user = new User();
                    user.setEmployeeID(rs.getInt("employeeID"));
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastName"));
                    user.setMiddleName(rs.getString("middleName"));
                    instructorManager.addUser(user);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private boolean insertIntoDatabase() {
        if(insertCourses() && retriveCourseID() && insertTAs()) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isTherePath() {
        return !CSVPathField.getText().equals("");
    }
    
    private boolean actualInsertion(String[] student, int courseID, int grouped){
        try {
            // \\freesia.csil.sfu.ca\ userdata\skhamilt\Desktop\275\studentListInput.csv
            Statement stat = con.createStatement();
            String SQL_0 =("INSERT INTO STUDENT VALUES (" +
                           student[3] + ", " + courseID + 
                           ", '" + student[0] + "', '" + student[1] + 
                           "', '" + student[2] + "', " + grouped + ")");                    
            System.out.println(SQL_0);
            stat.executeUpdate(SQL_0); 
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }  
        return true;
    }
    
    private boolean insertStudentsIntoDb() { 
    //  unloading csv happens in here as well as inserting into db
        String csvPath = CSVPathField.getText();
        System.out.println(csvPath);
        BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
        try{
            br = new BufferedReader(new FileReader(csvPath));
            while ((line = br.readLine())!=null){
                String[] studentTemp = line.split(cvsSplitBy);
                System.out.println("studentID: " + studentTemp[3] +
                                 " courseID: " + courseModel.getCourseID() +
                                 " studentFirstName: " + studentTemp[0] +
                                 " studentMiddleName: " + studentTemp[1] +
                                 " studentLastName: " + studentTemp[2] +
                                 " isGrouped: " + 0);     
                if (!actualInsertion(studentTemp, courseModel.getCourseID(), 0)){
                    return false;
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
	} 
        catch (IOException e) {
            e.printStackTrace();
	} 
        finally {
            if (br != null) {
		try {
                    br.close();
		} 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
           
    private boolean insertCourses() {
        try {
            Statement stat = con.createStatement();
            String[] chosens = null;
//            String instructorName = null;
            int instructorID = -1;
            if(!chosenInstructors.isEmpty()) {
                chosens = chosenInstructors.get(0).split(CreateCourseGUI.SPLIT_SYMBOL);
                instructorID = Integer.parseInt(chosens[CreateCourseGUI.EMPLOYEEID_INDEX].trim());
            }
            
            if (instructorID == -1) {
                stat.executeUpdate("INSERT INTO Course(courseNum, courseName, startDate, endDate)"
                     + " VALUES ('" 
                     + courseModel.getCourseNumber() + "', '" 
                     + courseModel.getCourseName()+ "', '" 
                     + courseModel.getStartDate() + "', '"
                     + courseModel.getEndDate() + "')");
            } else {
                stat.executeUpdate("INSERT INTO Course(courseNum, courseName, startDate, endDate, "
                        + "instructorEmployeeID) VALUES ('"
                        + courseModel.getCourseNumber() + "', '"
                        + courseModel.getCourseName()+ "', '"
                        + courseModel.getStartDate() + "', '"
                        + courseModel.getEndDate() + "', "
                        + instructorID + ")");
            }
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"SQLException", JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();
            return false;
        }
    }
    
    private boolean retriveCourseID(){
        try {
//            Statement stat = con.createStatement();
            
            String sql = "SELECT courseID FROM Course"
                    + " WHERE courseNum = '" + courseModel.getCourseNumber() + "' AND " 
                    + "courseName = '" + courseModel.getCourseName() + "' AND "
                    + "startDate = '" + courseModel.getStartDate() + "' AND "
                    + "endDate = '" + courseModel.getEndDate() + "'";
            
            PreparedStatement ps = con.prepareStatement(sql);
//            System.out.println(sql);
            System.out.println("courseNum: " + courseModel.getCourseNumber() +
                    ", startDate: " + courseModel.getStartDate() +
                    ", endDate: " + courseModel.getEndDate());
            /*
            System.out.println("courseNum = " + courseModel.getCourseNumber() +
                   "courseName = " + courseModel.getCourseName() +
                    "startD = " + courseModel.getStartDate() +
                    "endD = " + courseModel.getEndDate());
            */
            ResultSet rs = executeQuery(ps);
            
            
            
            if (rs.next()) {
                 System.out.println("++++++++++++++++++");
                courseModel.setCourseID(rs.getInt("courseID"));
            }
            
            System.out.println("courseID is: " + courseModel.getCourseID());
            
            return true;
                 
        } catch (SQLException ex) {
           ex.printStackTrace();
           return false;
        }
    }
    
    private boolean insertTAs(){
        if (!chosenTAs.isEmpty()) {
            try {
                Statement stat = con.createStatement();
                String[] chosens = null;
                
                for (String TA : chosenTAs) {
                    chosens = TA.split(CreateCourseGUI.SPLIT_SYMBOL);
                    int TAID = Integer.parseInt(chosens[CreateCourseGUI.EMPLOYEEID_INDEX].trim());
                    int accountID = TAManager.getUser(TAID).getAccount().getAccountID();
                    
                    System.out.println("TAID: " + TAID +
                                    "accountID: " + accountID);
                    String SQL_0 =("INSERT INTO TA VALUES (" +
                             TAID + ", " + accountID + ", " + courseModel.getCourseID() + ")");
//                     String SQL_0 =("INSERT INTO TA VALUES (" +
//                             TAID + ", " + accountID + ", " + courseModel.getCourseID() +", (SELECT TOP 1 activityID FROM Activity ORDER BY NEWID()))");
                     System.out.println(SQL_0);
                     stat.executeUpdate(SQL_0);
                }
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
        
    }
    
    private String[] processStrings(){
        String[] chosens = null;
        for (String user : chosenTAs) {
            chosens = user.split(",");
            
        }
        return chosens;
    }
    
    private ResultSet executeQuery(PreparedStatement pstmt) {
        try {
            return(pstmt.executeQuery());
        } catch (SQLException se){
            System.out.println("\nSQL Exception occured, the state : "+
				se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
            return null;
	}
    }
    
    private void connectToDatabase() {
        String userName = "c275g11";
        String password = "bL344y3Emh2dPtaT";
        String url = "jdbc:sqlserver://cypress;" +
                        "user = " + userName + ";" +
			"password = " + password;
        
        // DEBUGG-------------------------
        System.out.println("\n connectionUrl = " + url + "\n\n");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(ClassNotFoundException ce) {
            System.out.println("\n\nNo JDBC dirver; exit now.\n\n");
            return;
	}
        
        try {
            con = DriverManager.getConnection(url);
	} catch (SQLException se) {
            System.out.println("\n\nFail to connect to CSIL SQL Server; exit now.\n\n");
            return;
        }
    }
    
    private void displayMarkers() {
        System.out.println("Displaying Instructors: ");
        instructorManager.display();
        System.out.println("Displaying TAs: ");
        TAManager.display();
    }
    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CreateCourseMarkerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CreateCourseMarkerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CreateCourseMarkerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CreateCourseMarkerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CreateCourseMarkerGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CSVPathField;
    private javax.swing.JComboBox TAComboBox;
    private javax.swing.JLabel addDelInstrLbl;
    private javax.swing.JLabel addDelTALbl;
    private javax.swing.JButton addInstructorButton;
    private javax.swing.JButton addTAButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel createCourseContDescr;
    private javax.swing.JLabel createCourseContTitle;
    private javax.swing.JButton deleteTAButton;
    private javax.swing.JComboBox instructorComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList markerList;
    private javax.swing.JLabel markersAddedLbl;
    // End of variables declaration//GEN-END:variables
}