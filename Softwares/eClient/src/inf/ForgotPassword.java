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
import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.JOptionPane;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.Random;



/**
 *
 * @author Iroshan
 */
public class ForgotPassword extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
 int OTP;

    public static final String ACCOUNT_SID =
            "ACe55609f8867185957887cee60eb9e083";
    public static final String AUTH_TOKEN =
            "fe93469492948a5fa1851e63f19febee";

    public ForgotPassword() {
        initComponents();
        conn = DBconnect.connect();
       
        reset();
        lblClientID.setText(Login.tbClientID.getText());
    }

public void reset (){
    
    lblTimer.hide();
    lblResend.hide();
    
    lblOTP.hide();
    tbVerifyOTP.hide();
    btnVerify.hide();
    
    lblnewpass.hide();
    lblrenewpass.hide();
    tbNewPass.hide();
    tbReNewPass.hide();
    lblWrong.hide();
    cbShow.hide();
    btnChange.hide();
    btnReset.hide();
}
public void OTPSend(){
    
      try {
             Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
         Random rand = new Random();
         OTP =rand.nextInt(999999);
         
        Message message = Message
                .creator(new PhoneNumber(tbPhone.getText()), // to
                        new PhoneNumber("+12058962320"), // from
                        "eBankONLINE \n " +" Please Enter OTP : "+OTP+" to complete you online request.Thank You")
                .create();
        JOptionPane.showMessageDialog(null, "OTP sent seccessfully!");
        System.out.println(message.getSid());
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        lblClientID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblOTP = new javax.swing.JLabel();
        tbPhone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        btnVerify = new javax.swing.JButton();
        lblResend = new javax.swing.JLabel();
        tbVerifyOTP = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        tbNewPass = new javax.swing.JPasswordField();
        lblnewpass = new javax.swing.JLabel();
        lblrenewpass = new javax.swing.JLabel();
        tbReNewPass = new javax.swing.JPasswordField();
        cbShow = new javax.swing.JCheckBox();
        btnReset = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        lblWrong = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Forgot Password");
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel30.setText("Client_ID :");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        lblClientID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(lblClientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 80, 20));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Forgot Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-left-24.png"))); // NOI18N
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, -1));

        lblOTP.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblOTP.setText("Enter OTP :");
        jPanel1.add(lblOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        tbPhone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbPhone.setText("+94");
        tbPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbPhoneActionPerformed(evt);
            }
        });
        jPanel1.add(tbPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 240, 30));

        jLabel2.setText("*With Country code");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));
        jPanel1.add(lblTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 50, 10));

        btnVerify.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnVerify.setText("Verify");
        btnVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerify, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 90, 30));

        lblResend.setText("Resend Code");
        jPanel1.add(lblResend, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        tbVerifyOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbVerifyOTPActionPerformed(evt);
            }
        });
        jPanel1.add(tbVerifyOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 200, 30));

        jLabel54.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel54.setText("Phone Number :");
        jPanel1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        btnSend.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        jPanel1.add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 90, 30));
        jPanel1.add(tbNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 240, 30));

        lblnewpass.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblnewpass.setText("New Password :");
        jPanel1.add(lblnewpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        lblrenewpass.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblrenewpass.setText("Re-Type Password :");
        jPanel1.add(lblrenewpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));
        jPanel1.add(tbReNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 240, 30));

        cbShow.setText("Show Password");
        cbShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowActionPerformed(evt);
            }
        });
        jPanel1.add(cbShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, -1, -1));

        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 100, 30));

        btnChange.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnChange.setText("Change");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });
        jPanel1.add(btnChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 100, 30));

        lblWrong.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblWrong.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblWrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 220, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 590));

        setSize(new java.awt.Dimension(448, 629));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   int i = 30;
   Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
           
            i--;
           
           if(i>=0){
               lblTimer.setText("00 : "+i);
               if(i==0){
                   btnSend.setEnabled(true);
               }
           }
        }
    });
    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        this.dispose();
        
    }//GEN-LAST:event_jLabel29MouseClicked

    private void tbPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPhoneActionPerformed

    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyActionPerformed
        int verify = Integer.parseInt(tbVerifyOTP.getText());
        
        if(tbVerifyOTP.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the OTP!");
         
        }
        else if (verify == OTP){
            JOptionPane.showMessageDialog(null, "Change Password here!");
            lblnewpass.show();
            lblrenewpass.show();
            tbNewPass.show();
            tbReNewPass.show();
            cbShow.show();
            btnChange.show();
            btnReset.show();
            
        }
        else{
            
            JOptionPane.showMessageDialog(null, "Incorrect OTP!");
            tbVerifyOTP.setText("");
        }
    }//GEN-LAST:event_btnVerifyActionPerformed

    private void tbVerifyOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbVerifyOTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbVerifyOTPActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
         String id = lblClientID.getText();
        String cupass = tbPhone.getText();
       
        if(tbPhone.equals("+94")){
            JOptionPane.showMessageDialog(null, "Please enter your phone Number!");
        }
        else{
            OTPSend();
            btnSend.setEnabled(false);
            
            lblTimer.show();
            lblResend.show();
            timer.start();
            lblOTP.show();
            tbVerifyOTP.show();
            btnVerify.show();
            
        }
        
    }//GEN-LAST:event_btnSendActionPerformed

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
        tbNewPass.setText("");
      tbReNewPass.setText("");
      lblWrong.hide();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        String id = lblClientID.getText();
        String newpass = tbNewPass.getText();
        String retype = tbReNewPass.getText();

        try {
           
                if(newpass.equals(retype)){

                    String SQL2 ="UPDATE tblClient SET Password='"+newpass+"' WHERE Client_ID = '"+id+"'";
                    pst = conn.prepareStatement(SQL2);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Password Changed Successfully!");
                    reset();
                    this.dispose();
                }
                else{
                    lblWrong.show();
                    lblWrong.setText("Password does not match,Please Retry!");
                }

            
          

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnChangeActionPerformed

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnVerify;
    private javax.swing.JCheckBox cbShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClientID;
    private javax.swing.JLabel lblOTP;
    private javax.swing.JLabel lblResend;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblWrong;
    private javax.swing.JLabel lblnewpass;
    private javax.swing.JLabel lblrenewpass;
    private javax.swing.JPasswordField tbNewPass;
    private javax.swing.JTextField tbPhone;
    private javax.swing.JPasswordField tbReNewPass;
    private javax.swing.JTextField tbVerifyOTP;
    // End of variables declaration//GEN-END:variables
}
