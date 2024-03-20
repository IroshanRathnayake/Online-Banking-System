/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf;

import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Iroshan
 */
public class ChangePassword extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    
    public ChangePassword() {
        initComponents();
        conn = DBconnect.connect();
       
        lblClientID.setText(Login.tbClientID.getText());
    }

  public void reset(){
      
      tbCurrentPass.setText("");
      tbNewPass.setText("");
      tbReNewPass.setText("");
      lblWrong.hide();
      
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        tbCurrentPass = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        tbReNewPass = new javax.swing.JPasswordField();
        tbNewPass = new javax.swing.JPasswordField();
        cbShow = new javax.swing.JCheckBox();
        btnReset = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        lblClientID = new javax.swing.JLabel();
        lblWrong = new javax.swing.JLabel();
        lblForgotPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Change Password");
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Change Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-left-24.png"))); // NOI18N
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, -1));

        jLabel52.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel52.setText("Re-Type Password :");
        getContentPane().add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        tbCurrentPass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbCurrentPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbCurrentPassActionPerformed(evt);
            }
        });
        getContentPane().add(tbCurrentPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 240, 30));

        jLabel53.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel53.setText("Current Password :");
        getContentPane().add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel54.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel54.setText("New Password :");
        getContentPane().add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));
        getContentPane().add(tbReNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 240, 30));
        getContentPane().add(tbNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 240, 30));

        cbShow.setText("Show Password");
        cbShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowActionPerformed(evt);
            }
        });
        getContentPane().add(cbShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, -1));

        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 100, 30));

        btnChange.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnChange.setText("Change");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });
        getContentPane().add(btnChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 100, 30));

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel30.setText("Client_ID :");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        lblClientID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(lblClientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        lblWrong.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblWrong.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblWrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 220, -1));

        lblForgotPass.setBackground(new java.awt.Color(51, 51, 255));
        lblForgotPass.setForeground(new java.awt.Color(51, 51, 255));
        lblForgotPass.setText("Forgot Password ?");
        lblForgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgotPassMouseClicked(evt);
            }
        });
        getContentPane().add(lblForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        setSize(new java.awt.Dimension(448, 560));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel29MouseClicked

    private void tbCurrentPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbCurrentPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCurrentPassActionPerformed

    private void cbShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowActionPerformed
        if(cbShow.isSelected()){
            tbNewPass.setEchoChar((char)0);
            tbReNewPass.setEchoChar((char)0);
        }
        else{
            tbNewPass.setEchoChar('*');
            tbReNewPass.setEchoChar('*');
        }
    }//GEN-LAST:event_cbShowActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
       reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
       String id = lblClientID.getText();
       String cupass = tbCurrentPass.getText();
       String newpass = tbNewPass.getText();
       String retype = tbReNewPass.getText();
       
        try {
            String sql = "SELECT * FROM tblClient WHERE Client_ID=? && Password = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, cupass);
            rs = pst.executeQuery();
            
            if(rs.next()){
                
                if(newpass.equals(retype)){
                    
                    String SQL2 ="UPDATE tblClient SET Password='"+newpass+"' WHERE Client_ID = '"+id+"'";
                    pst = conn.prepareStatement(SQL2);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Password Changed Successfully!");
                    reset();
                }
                else{
                    lblWrong.show();
                    lblWrong.setText("Password does not match,Please Retry!");
                }
           
            }
            else{
                JOptionPane.showMessageDialog(null, "Current Password incorrect!");
            
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnChangeActionPerformed

    private void lblForgotPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPassMouseClicked
       ForgotPassword fp = new ForgotPassword();
       fp.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_lblForgotPassMouseClicked

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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnReset;
    private javax.swing.JCheckBox cbShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel lblClientID;
    private javax.swing.JLabel lblForgotPass;
    private javax.swing.JLabel lblWrong;
    private javax.swing.JTextField tbCurrentPass;
    private javax.swing.JPasswordField tbNewPass;
    private javax.swing.JPasswordField tbReNewPass;
    // End of variables declaration//GEN-END:variables
}
