/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf;


import codes.DBconnect;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import static inf.Home.ACCOUNT_SID;
import static inf.Home.AUTH_TOKEN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Iroshan
 */
public class OnlineMessage extends javax.swing.JFrame {
 String phone = null;
 String ClientID = null;
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public static final String ACCOUNT_SID =
            "ACe55609f8867185957887cee60eb9e083";
    public static final String AUTH_TOKEN =
            "fe93469492948a5fa1851e63f19febee";
    public OnlineMessage() {
        initComponents();
        conn = DBconnect.connect();
        info();
    }
    
    public void info(){
        String id = Login.tbClientID.getText();
        
         try {
            String sql ="SELECT * FROM tblClient WHERE Client_ID = '"+id+"'";
            pst =conn.prepareStatement(sql);
            rs =pst.executeQuery();
            
            if(rs.next()){
               
                    ClientID =rs.getString("Client_ID");
                String name = rs.getString("Client_Name");
                    lblName.setText(name);
                   phone = rs.getString("Phone");
                   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBody = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tbSubject = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Forum");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Online Chat");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-left-24.png"))); // NOI18N
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Your Problem or other :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        btnSend.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        getContentPane().add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, 80, 30));

        tbBody.setColumns(20);
        tbBody.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tbBody.setRows(5);
        jScrollPane1.setViewportView(tbBody);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 310, 130));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("* Tell us your problems or others here.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Subject :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 60, 20));

        tbSubject.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tbSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbSubjectActionPerformed(evt);
            }
        });
        getContentPane().add(tbSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 310, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Name :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 50, 20));

        lblName.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 170, 30));

        setSize(new java.awt.Dimension(588, 619));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        this.dispose();
        Contact con = new Contact();
        con.setVisible(true);

    }//GEN-LAST:event_jLabel29MouseClicked

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
             
        
        try {
                            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                            com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message
                                    .creator(new PhoneNumber("+94776775195"), // to
                                    new PhoneNumber("+12058962320"), // from
                                     "eBank \nClient ID - "+ClientID+ "\n"+lblName.getText()+"\n"+tbSubject.getText()+"\n"+tbBody.getText()+"\n"+phone)
                                    .create();
                                   
                                         System.out.println(message.getSid());
                                         JOptionPane.showMessageDialog(null, "Thanks for messaging us.We try to be as \nresponsive as possible.We'll get back \nyou soon.");
                                         tbSubject.setText("");
                                         tbBody.setText("");
                                   
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void tbSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSubjectActionPerformed

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
            java.util.logging.Logger.getLogger(OnlineMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OnlineMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OnlineMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OnlineMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OnlineMessage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextArea tbBody;
    private javax.swing.JTextField tbSubject;
    // End of variables declaration//GEN-END:variables
}
