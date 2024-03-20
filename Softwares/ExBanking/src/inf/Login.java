
package inf;

//import java.awt.Toolkit;
import codes.DBconnect;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Login extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    public Login() {
        initComponents();
       
        conn = DBconnect.connect();
        setSize(718, 548);
        setIcon();
        date();
        time();
           
       
    }
    
      public void date(){
        
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        lblDate.setText(sdf.format(d));
    }
    public void time(){
        
      new Timer(0, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
              
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                lblTime.setText(sdf.format(d));
              
          }
      }){
            
        }.start();
    }
  
    public void access(){
          
         try {
            String sql = "SELECT * FROM tblUser WHERE User_Name=? && Password=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, tbUserName.getText());
            pst.setString(2, tbPass.getText());
            rs  =pst.executeQuery();
            
            if(rs.next()){
              
               Home hm = new Home();
               hm.setVisible(true);
               this.dispose();
           }
            else{
                JOptionPane.showMessageDialog(null, "Access Denied!");
                tbUserName.setText("");
                tbPass.setText("");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtHead = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tbUserName = new javax.swing.JTextField();
        tbPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMaximumSize(new java.awt.Dimension(718, 570));
        setMinimumSize(new java.awt.Dimension(718, 570));
        setName("Login"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(718, 570));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHead.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        txtHead.setForeground(new java.awt.Color(102, 0, 153));
        txtHead.setText("User Login");
        jPanel1.add(txtHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel3.setText("User Name : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel4.setText("Password : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 51, 255));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 120, 40));

        tbUserName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbUserName.setToolTipText("Type you User Name");
        tbUserName.setName(""); // NOI18N
        tbUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbUserNameActionPerformed(evt);
            }
        });
        jPanel1.add(tbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 200, 30));

        tbPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbPass.setToolTipText("Enter your Password");
        tbPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbPassActionPerformed(evt);
            }
        });
        tbPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbPassKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbPassKeyTyped(evt);
            }
        });
        jPanel1.add(tbPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 200, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/images ori.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 230, 240));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/Background.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel1.setMinimumSize(new java.awt.Dimension(200, 200));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, -20, 260, 230));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("e-Banking");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 320, 70));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Date & Time :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));

        lblDate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, -1));

        lblTime.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/online-banking-in-Ghana.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-470, -90, 1190, 750));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 570));

        getAccessibleContext().setAccessibleName("");

        setSize(new java.awt.Dimension(734, 609));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        access();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbUserNameActionPerformed
      
    }//GEN-LAST:event_tbUserNameActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        access();
    }//GEN-LAST:event_jButton1KeyPressed

    private void tbPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPassKeyPressed
        
    }//GEN-LAST:event_tbPassKeyPressed

    private void tbPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPassKeyTyped
        
    }//GEN-LAST:event_tbPassKeyTyped

    private void tbPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPassActionPerformed
       access();
    }//GEN-LAST:event_tbPassActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPasswordField tbPass;
    public static javax.swing.JTextField tbUserName;
    private javax.swing.JLabel txtHead;
    // End of variables declaration//GEN-END:variables

   public void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icons8-merchant-account-64.png")));
    }
}
