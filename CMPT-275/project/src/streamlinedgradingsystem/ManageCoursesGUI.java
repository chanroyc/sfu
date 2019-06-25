/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamlinedgradingsystem;

import ca.sfu.cmpt275.deliverable.colinq.*;

/**
 *
 * @author naris
 */
public class ManageCoursesGUI extends javax.swing.JFrame {
    private User userModel;
    /**
     * Creates new form ManageCourses
     */
    public ManageCoursesGUI(User userModel) {
        this.userModel = userModel;
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

        manageCoursesTitle = new javax.swing.JLabel();
        createCourseButton = new javax.swing.JButton();
        modifyCourseButton = new javax.swing.JButton();
        deleteCourseButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        manageCoursesTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        manageCoursesTitle.setText("Manage Courses");

        createCourseButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createCourseButton.setText("Create Course");
        createCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCourseButtonActionPerformed(evt);
            }
        });

        modifyCourseButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modifyCourseButton.setText("Modify Course");
        modifyCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyCourseButtonActionPerformed(evt);
            }
        });

        deleteCourseButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteCourseButton.setText("Delete Course");
        deleteCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCourseButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modifyCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manageCoursesTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 256, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(manageCoursesTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(createCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(modifyCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(deleteCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCourseButtonActionPerformed
        //opens course creation screen
        Course courseModel = new Course();
        this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateCourseGUI(userModel, courseModel).setVisible(true);

            }
            });
                        
    }//GEN-LAST:event_createCourseButtonActionPerformed

    private void deleteCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCourseButtonActionPerformed
        //leads to course search to delete
        Course courseModel = new Course();
        this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchCourseDeleteGUI(userModel, courseModel).setVisible(true);

            }
            });
    }//GEN-LAST:event_deleteCourseButtonActionPerformed

    private void modifyCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyCourseButtonActionPerformed
        //leads to course search to modify
        Course courseModel = new Course();
        this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchCourseModifyGUI(userModel, courseModel).setVisible(true);

            }
            });
    }//GEN-LAST:event_modifyCourseButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //returns to main admin assistant screen
        this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministativeAssistantMenuGUI(userModel).setVisible(true);
            }
            });
                
    }//GEN-LAST:event_backButtonActionPerformed

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
//            java.util.logging.Logger.getLogger(ManageCoursesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManageCoursesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManageCoursesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManageCoursesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManageCoursesGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton createCourseButton;
    private javax.swing.JButton deleteCourseButton;
    private javax.swing.JLabel manageCoursesTitle;
    private javax.swing.JButton modifyCourseButton;
    // End of variables declaration//GEN-END:variables
}
