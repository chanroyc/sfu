/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamlinedgradingsystem;

import ca.sfu.cmpt275.deliverable.colinq.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author colinq
 */
public class LoginGUI extends javax.swing.JFrame {
//        private User userModel;
        private int numberOfAttempts;
        private User userModel = new User();
        private UserAccount userAccount = new UserAccount();
        private Connection conn = null;
	/**
	 * Creates new form LoginGUI
	 */
	public LoginGUI() {
//            this.userModel = userModel;
            numberOfAttempts = 0;
            
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
        jLabel4 = new javax.swing.JLabel();
        userIDField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Welcome to the Streamlined Grading System");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("User ID:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Password:");

        userIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDFieldActionPerformed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginButton.setText("Log In");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(passwordField))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(passwordField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void userIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDFieldActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_userIDFieldActionPerformed
        
	private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
            
            String userID=userIDField.getText();
            String password=passwordField.getText();
            
            System.out.println("userID entered: " + userID +
                    ", password entered: " + password);
            
            String DB_URL = "jdbc:sqlserver://cypress;";
            String USER = "c275g11";
            String PASS = "bL344y3Emh2dPtaT";
            
            Statement stmt = null;
            
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                stmt = conn.createStatement();
                String sql;
                // login id should be unique.
                //                sql = "SELECT * from Account where loginID='" + userID + "' and password='" + password + "'";
                sql = "SELECT * from Account where loginID='" + userID + "'";
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next() == false) {
                    //                    JOptionPane.showMessageDialog(null,"Incorrect User ID or Password","Warning!", JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null,"No such User ID!",
                            "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
                else {
                    processUserAccount(rs);
                    if (userID.equals(userAccount.getLoginID())) {
                        if (validateUserAccess()) {
                            if (password.equals(userAccount.getPassword())) {
                                JOptionPane.showMessageDialog(null,"login successful!","login success", JOptionPane.INFORMATION_MESSAGE);
                                this.setVisible(false);
                                java.awt.EventQueue.invokeLater(new Runnable() {
                                    public void run() {
                                        new UserMenuGUI(userModel).setVisible(true);
                                    }
                                });
                            } else {
                                JOptionPane.showMessageDialog(null,"Incorrect Password!",
                                        "Warning!",
                                        JOptionPane.WARNING_MESSAGE);
                                numberOfAttempts++;
                                if (!validateUserAttempts()) {
                                    userAccount.blockAccount();
                                    updateUserAccessInDatabase();
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Incorrect User ID!",
                                "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            catch(SQLException se){
                //Handle errors for JDBC
                JOptionPane.showMessageDialog(null,se,"SQLException", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(Exception e){
                //Handle errors for Class.forName
                JOptionPane.showMessageDialog(null,e,"Exception", JOptionPane.INFORMATION_MESSAGE);
                
            }
            

	}//GEN-LAST:event_loginButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void updateUserAccessInDatabase() {
            try {
                String sql = "UPDATE Account SET islocked = 1 WHERE accountID = " + userAccount.getAccountID();
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                
            }
    }
    
    private boolean validateUserAccess() {
          if (userModel.getAccount().isBlocked() == 1) {
            JOptionPane.showMessageDialog(null,
                    "Your account is currently blocked.\n"
                            + "Please contact a System Administrator for further assistance.",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
          } else {
              return true;
          }
    }
    private boolean validateUserAttempts() {
        if (numberOfAttempts == UserAccount.MAX_ATTEMPTS - 1) {
            JOptionPane.showMessageDialog(null,
                    "Last attempt to correctly enter you User ID and Password!",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return true;
        }
        else if (numberOfAttempts >= UserAccount.MAX_ATTEMPTS) {
            JOptionPane.showMessageDialog(null,
                    "You have failed to login 6 times. Your account is now blocked.\n"
                            + "Please contact a System Administrator for further assistance.",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    private void processUserAccount(ResultSet rs) {
            userAccount.clearAccount();
        try {
            System.out.println("String the sql ");
            userModel.setEmployeeID(rs.getInt("employeeID"));
            userModel.setFirstName(rs.getString("firstName"));
            userModel.setLastName(rs.getString("lastName"));
            userModel.setMiddleName(rs.getString("middleName"));
            userAccount.setAccountID(rs.getInt("accountID"));
            userAccount.setLoginID(rs.getString("loginID"));
            userAccount.setPassword(rs.getString("password"));
            if (rs.getInt("ispasswdtemp") == 1) {
                userAccount.makePasswordTemp();
            } else {
                userAccount.makePassReal();
            }
            if (rs.getInt("islocked") == 1) {
                userAccount.blockAccount();
            } else {
                userAccount.unBlockAccount();
            }
            if (rs.getInt("isAssistAdmin") == 1) {
                userAccount.addRole(User.ADMINISTRATIVE_ASSISTANT);
            }
            if (rs.getInt("isSysAdmin") == 1) {
                userAccount.addRole(User.SYSTEM_ADMINISTRATOR);
            }
            if (rs.getInt("isAdministrator") == 1) {
                userAccount.addRole(User.ADMINISTRATOR);
            }
            if (rs.getInt("isTA") == 1) {
                userAccount.addRole(User.TA);
            }
            if (rs.getInt("isInstructor") == 1) {
                userAccount.addRole(User.INSTRUCTOR);
            }
            userModel.addAccount(userAccount);
            userAccount.dump();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
	/**
	 * @param args the command line arguments
	 */
//	public static void main(String args[]) {
//		/* Set the Nimbus look and feel */
//		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//		 */
//		try {
//			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//				if ("Nimbus".equals(info.getName())) {
//					javax.swing.UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
//		} catch (ClassNotFoundException ex) {
//			java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (InstantiationException ex) {
//			java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (IllegalAccessException ex) {
//			java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
//			java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		}
//		//</editor-fold>
//		//</editor-fold>
//
//		/* Create and display the form */
//
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				new LoginGUI().setVisible(true);
//			}
//		});
//
//	}

	private int countLoginSuccess=0;

	//private boolean loginSuccess ;



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userIDField;
    // End of variables declaration//GEN-END:variables
}
