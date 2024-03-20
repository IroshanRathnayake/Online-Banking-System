
package inf;

import codes.DBconnect;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import static inf.ForgotPassword.ACCOUNT_SID;
import static inf.ForgotPassword.AUTH_TOKEN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Random;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.Timer;
import net.proteanit.sql.DbUtils;







public class Home extends javax.swing.JFrame{
    
  int OTP;
  String status;
  String fileName=null;
  byte[] person_image = null;
    
    public static final String ACCOUNT_SID =
            "ACe55609f8867185957887cee60eb9e083";
    public static final String AUTH_TOKEN =
            "fe93469492948a5fa1851e63f19febee";
    
    Connection conn;
    PreparedStatement pst;
    PreparedStatement pst2;
    PreparedStatement pst3;
    PreparedStatement pst4;
    PreparedStatement pst5;
    ResultSet rs;
    progressThread th;
    progressThread2 th2;
    
    
    public Home() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        conn = DBconnect.connect();
       
        
        accDetail();
        depositTableLoad();
        transferTableLoad();
        timeDate();
        accInfo();
        btnPrint.hide();
       
      clear();

       
    }
    
    
    
    public void timeDate(){
         
        
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        lblDate.setText(sdf.format(d));
  
    
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
  
     class progressThread extends Thread{
      
      JProgressBar proBar;
      
      progressThread(JProgressBar proBar){
          
          proBar = ProgressBar; 
      }
      
      public void run(){
          int min = 0;
          int max =10;
          
          ProgressBar.setMaximum(min);
          ProgressBar.setMaximum(max);
          ProgressBar.setValue(0);
          
          for(int i=min; i<=max; i++){
              
              ProgressBar.setValue(i);
        
              try {
                  sleep(500);
              } catch (InterruptedException ex) {
                  Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
              }
         
            if (i== max){
                JOptionPane.showMessageDialog(null, "Deposited Successfully!");
                ProgressBar.setValue(0);
                
                accDetail();
                depositTableLoad();
                
             
                
                   try {
                            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                            Message message = Message
                                    .creator(new PhoneNumber(tbPhone1.getText()), // to
                                    new PhoneNumber("+12058962320"), // from
                                     "eBankONLINE \n " +"Deposit for "+tbDepositAmount.getText()+" to " +lblAccNo.getText()+" at "+lblTime.getText()+".Thank You")
                                    .create();
                                   
                                         System.out.println(message.getSid());
                                         
                                    tbDepositAmount.enable(true);
                                    tbDepositAmount.setEditable(true);
                                    clear();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
            }  
              
      }
      }
  }
       
     
   
        
 
    
    public void accDetail(){
      int id = Integer.parseInt(Login.tbClientID.getText());
      
        try {
            String sql ="SELECT * FROM tblClient WHERE Client_ID = '"+id+"'";
            pst =conn.prepareStatement(sql);
            rs =pst.executeQuery();
            
            if(rs.next()){
                
                String ID = rs.getString("Client_ID");
                    lblClientID.setText(ID);
                String AccNo = rs.getString("Account_No");
                    lblAccNo.setText(AccNo);
                String name = rs.getString("Client_Name");
                    lblUname.setText(name);
                String nic = rs.getString("NIC");
                    lblNIC.setText(nic);
                String balance = rs.getString("Amount");
                    lblBalance.setText(balance);
                    tbDCurrentAmount.setText(balance);
                    lblAvailabaleBal.setText(balance);
                String acctype = rs.getString("Account_Type");
                    lblAccType.setText(acctype);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      
      
    }
    
    class progressThread2 extends Thread{
      
      JProgressBar proBar;
      
      progressThread2(JProgressBar proBar){
          
          proBar = TProgressBar; 
      }
      
      public void run(){
          
          String Tamount = tbTransferAmount.getText();
               
          
               int min = 0;
               int max =50;
                TProgressBar.setMaximum(min);
                TProgressBar.setMaximum(max);
                TProgressBar.setValue(0);
          
          for(int i=min; i<=max; i++){
              
              TProgressBar.setValue(i);
             
              
              try {
                  sleep(500);
                  
              } catch (InterruptedException ex) {
                  Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
              }
              
            if (i==max){
                JOptionPane.showMessageDialog(null, "Transfaction Completed!");
                ProgressBar.setValue(0);
                lblProgress1.setText("");
                
                
                try {
                            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                            Message message = Message
                                    .creator(new PhoneNumber(tbPhone1.getText()), // to
                                    new PhoneNumber("+12058962320"), // from
                                     "eBankONLINE \nTransfer to "+tbTransferTo.getText()+" for LKR " +tbTransferAmount.getText()+" on "+lblDate.getText()+" "+lblTime.getText()+".Thank You")
                                    .create();
                                   
                                         System.out.println(message.getSid());
                                         
                                    tbDepositAmount.enable(true);
                                    tbDepositAmount.setEditable(true);
                                    clear();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
                accDetail();
                transferTableLoad();
                clear();   
          
          }
          }
      }    
          
  }
   
    public void accInfo(){
         int id = Integer.parseInt(Login.tbClientID.getText());
      
        try {
            String sql ="SELECT * FROM tblClient WHERE Client_ID = '"+id+"'";
            pst =conn.prepareStatement(sql);
            rs =pst.executeQuery();
            
            if(rs.next()){
                
                String ID = rs.getString("Client_ID");
                    lblCliID.setText(ID);
                String AccNo = rs.getString("Account_No");
                    lblAccountNo.setText(AccNo);
                String name = rs.getString("Client_Name");
                    tbUname.setText(name);
                String fname =rs.getString("FullName");
                    tbFName.setText(fname);
                String address = rs.getString("Address");
                    tbAddress.setText(address);
                String nic = rs.getString("NIC");
                    tbNIC.setText(nic);
                String gen = rs.getString("Gender");
                    cbGender.setSelectedItem(gen);
                String bd = rs.getString("BD");
                    tbBD.setText(bd);
                String email = rs.getString("Email");
                    tbEmail.setText(email);
                String acctype =rs.getString("Account_Type");
                    cbAccType.setSelectedItem(acctype);
                String phone = rs.getString("Phone");
                    tbPhone1.setText(phone);
                String balance = rs.getString("Amount");
                    lblBalance1.setText(balance);
                    
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      
    }
    public void depositTableLoad(){
        
        int id = Integer.parseInt(lblAccNo.getText());
        try {
            String sql = "SELECT Date,Time,User_Name,Before_Amount,Deposit_Amount,Current_Amount FROM tblDeposit WHERE Account_No='"+id+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tblDeposit.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void transferTableLoad(){
          int id = Integer.parseInt(lblAccNo.getText());
        try {
            String sql = "SELECT Date,Time,To_Acc,To_User_Name,TBefore_Amount,Transfered_Amount FROM tblMoneyTransfer WHERE From_Acc='"+id+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tblTransfer.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void clear(){
 
         //Account Info
         btnSave.setEnabled(false);
                  
         //Money Deposit       
        tbDepositAmount.setText("");
        ProgressBar.setValue(0);
        ProgressBar.hide();
        lblDProgress.hide();
        btnDCancel.hide();
        
        //Money Transfer
        lblResend.hide();
        lblTimer.hide();
        tbTransferTo.setText("");
        tbTransferUserName.setText("");
        tbTCurrentAmount.setText("");
        tbTransferAmount.setEnabled(true);
        tbTransferAmount.setText("");
        lblOTP.hide();
        tbOTP.setText("");
        tbOTP.hide();
        btnVerify.hide();
        TProgressBar.setValue(0);
        TProgressBar.hide();
        lblProgress1.hide();
        btnTCancel.hide();
        
        
    }
    
      public void searchAcc(){
              String srch = tbTransferTo.getText();
              String check = lblAccNo.getText();
        
        if(srch.equals(check)){
            JOptionPane.showMessageDialog(null, "Same Accounts.Please check Account Numbers");
            tbTransferTo.setText("");
        }
        else{
             try {
            String sql = "SELECT * FROM tblSavingAccount WHERE Account_No='"+srch+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if (rs.next()){
                String name = rs.getString("User_Name");
                    tbTransferUserName.setText(name);
                String CAmount = rs.getString("Amount");
                    tbTCurrentAmount.setText(CAmount);
                 
                rs.close();
                pst.close();
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Input!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
       
         }
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblDeposit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblAccNo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblLKR = new javax.swing.JLabel();
        lblUname = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblAccType = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblClientID = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lblNIC = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        JTpane = new javax.swing.JTabbedPane();
        JPWelcome = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        JPMoneyDeposit = new javax.swing.JPanel();
        lblAvalableBal = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        tbDCurrentAmount = new javax.swing.JTextField();
        tbDepositAmount = new javax.swing.JTextField();
        btnDeposit1 = new javax.swing.JButton();
        ProgressBar = new javax.swing.JProgressBar();
        btnDCancel = new javax.swing.JButton();
        lblDProgress = new javax.swing.JLabel();
        JPMoneyTransfer = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tbTransferTo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tbTransferUserName = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnTransfer = new javax.swing.JButton();
        btnVerify = new javax.swing.JButton();
        tbOTP = new javax.swing.JTextField();
        lblOTP = new javax.swing.JLabel();
        TProgressBar = new javax.swing.JProgressBar();
        btnTCancel = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        tbTCurrentAmount = new javax.swing.JTextField();
        btnTransfer3 = new javax.swing.JButton();
        lblProgress1 = new javax.swing.JLabel();
        lblAvailabaleBal = new javax.swing.JLabel();
        tbTransferAmount = new javax.swing.JTextField();
        btnTransfer5 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        lblResend = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        JPDepositDetails = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeposit = new javax.swing.JTable();
        JPTransDetail = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTransfer = new javax.swing.JTable();
        JPAccInfo = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        lblAccountNo = new javax.swing.JLabel();
        tbUname = new javax.swing.JTextField();
        tbFName = new javax.swing.JTextField();
        tbAddress = new javax.swing.JTextField();
        tbNIC = new javax.swing.JTextField();
        cbGender = new javax.swing.JComboBox<>();
        tbEmail = new javax.swing.JTextField();
        lblBalance1 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        tbBD = new javax.swing.JTextField();
        cbAccType = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        tbPhone1 = new javax.swing.JTextField();
        btnChangePass = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        tbPass = new javax.swing.JPasswordField();
        btnEdit = new javax.swing.JButton();
        lblCliID = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        JMenuExit = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Date & Time :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDeposit.setBackground(new java.awt.Color(255, 255, 255));
        lblDeposit.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblDeposit.setForeground(new java.awt.Color(0, 51, 204));
        lblDeposit.setText("Money Deposit");
        lblDeposit.setToolTipText("Money Deposit Here");
        lblDeposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDepositMouseClicked(evt);
            }
        });
        jPanel1.add(lblDeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-initiate-money-transfer-35.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 60, 50));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 204));
        jLabel21.setText("Money Transfer");
        jLabel21.setToolTipText("Money Transfer Here");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-cash-receipt-35.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, 50));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 204));
        jLabel24.setText("Transfaction Details");
        jLabel24.setToolTipText("Search Transfaction Details Here");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-time-machine-35.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 204));
        jLabel22.setText("Deposit Details");
        jLabel22.setToolTipText("Search Deposit Details Here");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-order-history-35.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 204));
        jLabel23.setText("Account Infomation");
        jLabel23.setToolTipText("Search Deposit Details Here");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-account-35 (1).png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 320, 380));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAccNo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(lblAccNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel14.setText("Account No :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel15.setText("User Name :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel16.setText(" Balance :  ");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        lblLKR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblLKR.setForeground(new java.awt.Color(0, 204, 0));
        lblLKR.setText("LKR");
        jPanel2.add(lblLKR, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, 20));

        lblUname.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(lblUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel19.setText("Account Type :");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        lblAccType.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(lblAccType, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, 20));

        lblBalance.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblBalance.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lblBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, 20));

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel30.setText("Client_ID :");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        lblClientID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(lblClientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel36.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel36.setText("NIC :");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        lblNIC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.add(lblNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 320, 250));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Log Out");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 80, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-shutdown-35 (1).png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 70, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("About Us");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 80, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-account-35 (1).png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 70, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-contact-details-35.png"))); // NOI18N
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 70, -1, -1));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setText("Contacts");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 80, -1, -1));
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 130, -1, -1));

        jLabel31.setBackground(new java.awt.Color(0, 0, 0));
        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 255));
        jLabel31.setText("e-Banking");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 170, 70));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-merchant-account-64 (1).png"))); // NOI18N
        jLabel33.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel33.setMinimumSize(new java.awt.Dimension(200, 200));
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 90, 90));

        lblTime.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lblTime.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 20, -1, -1));

        lblDate.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 20, -1, -1));

        jPanel3.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-verified-account-25.png"))); // NOI18N
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 30, 30));

        JTpane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JTpane.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        JTpane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTpaneMouseClicked(evt);
            }
        });

        JPWelcome.setBackground(new java.awt.Color(204, 204, 204));
        JPWelcome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 2, true));
        JPWelcome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("Service.");
        JPWelcome.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("e-Banking");
        JPWelcome.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 120, 70));

        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 102));
        jLabel32.setText("Enjoy with yourself.");
        JPWelcome.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/Background.png"))); // NOI18N
        jLabel10.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel10.setMinimumSize(new java.awt.Dimension(200, 200));
        JPWelcome.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 230, 180));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 102));
        jLabel34.setText("Welcome to the");
        JPWelcome.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/online-banking-in-Ghana.jpg"))); // NOI18N
        jLabel43.setText("jLabel43");
        JPWelcome.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(-430, -10, 1580, 580));

        JTpane.addTab("Welcome", JPWelcome);

        JPMoneyDeposit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAvalableBal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JPMoneyDeposit.add(lblAvalableBal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 170, 20));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 102, 255));
        jLabel38.setText("Enter Amount you want to Deposit.");
        JPMoneyDeposit.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Current Amount : ");
        JPMoneyDeposit.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Deposit Amount : ");
        JPMoneyDeposit.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        jLabel41.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel41.setText("LKR");
        JPMoneyDeposit.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        jLabel42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel42.setText("LKR");
        JPMoneyDeposit.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, -1, -1));

        tbDCurrentAmount.setEditable(false);
        tbDCurrentAmount.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbDCurrentAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbDCurrentAmountActionPerformed(evt);
            }
        });
        JPMoneyDeposit.add(tbDCurrentAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 140, 30));

        tbDepositAmount.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbDepositAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbDepositAmountActionPerformed(evt);
            }
        });
        JPMoneyDeposit.add(tbDepositAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 140, 30));

        btnDeposit1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDeposit1.setText("Deposit");
        btnDeposit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeposit1ActionPerformed(evt);
            }
        });
        JPMoneyDeposit.add(btnDeposit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 110, 30));

        ProgressBar.setBackground(new java.awt.Color(51, 255, 51));
        ProgressBar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ProgressBar.setForeground(new java.awt.Color(51, 255, 51));
        ProgressBar.setAutoscrolls(true);
        ProgressBar.setBorderPainted(false);
        ProgressBar.setName(""); // NOI18N
        ProgressBar.setStringPainted(true);
        JPMoneyDeposit.add(ProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 420, 30));

        btnDCancel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDCancel.setText("Cancel");
        btnDCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDCancelActionPerformed(evt);
            }
        });
        JPMoneyDeposit.add(btnDCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 380, 110, 30));

        lblDProgress.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblDProgress.setForeground(new java.awt.Color(0, 204, 0));
        JPMoneyDeposit.add(lblDProgress, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, -1, -1));

        JTpane.addTab("Cash Deposit", JPMoneyDeposit);

        JPMoneyTransfer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Available Balance :");
        JPMoneyTransfer.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel35.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel35.setText("LKR");
        JPMoneyTransfer.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Transfer To :");
        JPMoneyTransfer.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        tbTransferTo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbTransferTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbTransferToActionPerformed(evt);
            }
        });
        tbTransferTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbTransferToKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbTransferToKeyTyped(evt);
            }
        });
        JPMoneyTransfer.add(tbTransferTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 340, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("User Name : ");
        JPMoneyTransfer.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        tbTransferUserName.setEditable(false);
        tbTransferUserName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbTransferUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbTransferUserNameActionPerformed(evt);
            }
        });
        JPMoneyTransfer.add(tbTransferUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 340, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Tranfer Amount : ");
        JPMoneyTransfer.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setText("LKR");
        JPMoneyTransfer.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));

        btnTransfer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTransfer.setText("Transfer");
        btnTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferActionPerformed(evt);
            }
        });
        JPMoneyTransfer.add(btnTransfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 110, 30));

        btnVerify.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnVerify.setText("Verify");
        btnVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyActionPerformed(evt);
            }
        });
        JPMoneyTransfer.add(btnVerify, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 110, 30));

        tbOTP.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbOTPActionPerformed(evt);
            }
        });
        JPMoneyTransfer.add(tbOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 140, 30));

        lblOTP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblOTP.setText("Enter OTP :");
        JPMoneyTransfer.add(lblOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        TProgressBar.setForeground(new java.awt.Color(0, 204, 0));
        TProgressBar.setStringPainted(true);
        JPMoneyTransfer.add(TProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 450, 30));

        btnTCancel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTCancel.setText("Cancel");
        btnTCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTCancelActionPerformed(evt);
            }
        });
        JPMoneyTransfer.add(btnTCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, 110, 30));

        jLabel28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel28.setText("LKR");
        JPMoneyTransfer.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, -1, -1));

        tbTCurrentAmount.setEditable(false);
        tbTCurrentAmount.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbTCurrentAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbTCurrentAmountActionPerformed(evt);
            }
        });
        JPMoneyTransfer.add(tbTCurrentAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 140, 30));

        btnTransfer3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTransfer3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-search-24.png"))); // NOI18N
        btnTransfer3.setText("Search");
        btnTransfer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransfer3ActionPerformed(evt);
            }
        });
        JPMoneyTransfer.add(btnTransfer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 110, 30));

        lblProgress1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblProgress1.setForeground(new java.awt.Color(0, 204, 0));
        JPMoneyTransfer.add(lblProgress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, -1, -1));

        lblAvailabaleBal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAvailabaleBal.setForeground(new java.awt.Color(255, 0, 0));
        JPMoneyTransfer.add(lblAvailabaleBal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 150, 20));

        tbTransferAmount.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbTransferAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbTransferAmountActionPerformed(evt);
            }
        });
        JPMoneyTransfer.add(tbTransferAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 140, 30));

        btnTransfer5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTransfer5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-search-24.png"))); // NOI18N
        btnTransfer5.setText("Search");
        btnTransfer5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransfer5ActionPerformed(evt);
            }
        });
        JPMoneyTransfer.add(btnTransfer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 110, 30));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel58.setText("Current Amount : ");
        JPMoneyTransfer.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        lblResend.setText("Resend Code");
        JPMoneyTransfer.add(lblResend, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));
        JPMoneyTransfer.add(lblTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 50, 10));

        jLabel59.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 102, 255));
        jLabel59.setText("Transfer Money Here.");
        JPMoneyTransfer.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        JTpane.addTab("Money Transfer", JPMoneyTransfer);

        JPDepositDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPDepositDetailsMouseClicked(evt);
            }
        });
        JPDepositDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDeposit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDeposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepositMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDeposit);

        JPDepositDetails.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 570));

        JTpane.addTab("Deposit Details", JPDepositDetails);

        JPTransDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPTransDetailMouseClicked(evt);
            }
        });
        JPTransDetail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTransfer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblTransfer);

        JPTransDetail.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 570));

        JTpane.addTab("Transfaction Details", JPTransDetail);

        JPAccInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel44.setText("  Account Number : ");
        JPAccInfo.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        lblAccountNo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JPAccInfo.add(lblAccountNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 290, 20));

        tbUname.setEditable(false);
        tbUname.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbUname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbUnameActionPerformed(evt);
            }
        });
        JPAccInfo.add(tbUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 290, 30));

        tbFName.setEditable(false);
        tbFName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFNameActionPerformed(evt);
            }
        });
        JPAccInfo.add(tbFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 560, 30));

        tbAddress.setEditable(false);
        tbAddress.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbAddressActionPerformed(evt);
            }
        });
        JPAccInfo.add(tbAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 560, 30));

        tbNIC.setEditable(false);
        tbNIC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbNIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNICActionPerformed(evt);
            }
        });
        JPAccInfo.add(tbNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 290, 30));

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an Item", "Male", "Female" }));
        JPAccInfo.add(cbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 140, -1));

        tbEmail.setEditable(false);
        tbEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbEmailActionPerformed(evt);
            }
        });
        JPAccInfo.add(tbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 280, 30));

        lblBalance1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblBalance1.setForeground(new java.awt.Color(204, 0, 0));
        JPAccInfo.add(lblBalance1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 210, 20));

        jLabel45.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel45.setText("LKR");
        JPAccInfo.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, -1));

        jLabel46.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel46.setText("Current Balance : ");
        JPAccInfo.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabel47.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel47.setText("Email :");
        JPAccInfo.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        jLabel48.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel48.setText(" Gender : ");
        JPAccInfo.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        jLabel49.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel49.setText("NIC Number : ");
        JPAccInfo.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jLabel50.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel50.setText("Address : ");
        JPAccInfo.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jLabel51.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel51.setText("Full Name : ");
        JPAccInfo.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel52.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel52.setText("User Name : ");
        JPAccInfo.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel53.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel53.setText("Password :");
        JPAccInfo.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, -1, -1));

        tbBD.setEditable(false);
        tbBD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBDActionPerformed(evt);
            }
        });
        JPAccInfo.add(tbBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 150, 30));

        cbAccType.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbAccType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an Item", "Saving Account" }));
        JPAccInfo.add(cbAccType, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 130, -1));

        jLabel54.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel54.setText("  Account Type : ");
        JPAccInfo.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, -1));

        jLabel55.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel55.setText("Phone Number : ");
        JPAccInfo.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, -1, -1));

        tbPhone1.setEditable(false);
        tbPhone1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbPhone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbPhone1ActionPerformed(evt);
            }
        });
        JPAccInfo.add(tbPhone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 150, 30));

        btnChangePass.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnChangePass.setText(" Change Password");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });
        JPAccInfo.add(btnChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 130, 20));

        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-save-16.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        JPAccInfo.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 100, 30));

        jLabel56.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel56.setText(" Birth Date : ");
        JPAccInfo.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, -1, -1));

        tbPass.setEditable(false);
        tbPass.setText("123456");
        JPAccInfo.add(tbPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 150, 30));

        btnEdit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/edit-icon.png"))); // NOI18N
        btnEdit.setText(" Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        JPAccInfo.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 100, 30));

        lblCliID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JPAccInfo.add(lblCliID, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 190, 20));

        jLabel57.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel57.setText("Client ID :");
        JPAccInfo.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        JTpane.addTab("Account Infomation", JPAccInfo);

        jPanel3.add(JTpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 940, 600));

        btnPrint.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-print-35.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, 120, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 780));

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-chat-16.png"))); // NOI18N
        jMenuItem2.setText("Online Chat");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-change-user-16.png"))); // NOI18N
        jMenuItem1.setText("Changer Account");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        JMenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        JMenuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/Actions-edit-delete-icon.png"))); // NOI18N
        JMenuExit.setText("Exit");
        JMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuExitActionPerformed(evt);
            }
        });
        jMenu1.add(JMenuExit);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("       About");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-about-16.png"))); // NOI18N
        jMenuItem3.setText("About Bank");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("      Help");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-phone-16.png"))); // NOI18N
        jMenuItem4.setText("Contact");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-contact-16.png"))); // NOI18N
        jMenuItem5.setText("Developer");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   int i = 30;
   Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
           
            i--;
           
           if(i>=0){
               lblTimer.setText("00 : "+i);
               if(i==0){
                   btnTransfer.setEnabled(true);
               }
           }
        }
    });
    private void tbTransferToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbTransferToActionPerformed
            searchAcc();
    }//GEN-LAST:event_tbTransferToActionPerformed

    private void tbTransferUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbTransferUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbTransferUserNameActionPerformed

    private void tbOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbOTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbOTPActionPerformed

    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyActionPerformed
         String TT = tbTransferTo.getText();
        String TA = tbTransferAmount.getText();
        String phone = tbPhone1.getText();
       
       if(TT.equals("") || TA.equals("") || phone.equals("")){
           JOptionPane.showMessageDialog(null, "Please fill all the details!");
          }
          else{
                int check = JOptionPane.showConfirmDialog(null, "Are you sure?");
           
           if(check == 0){
               String date = lblDate.getText();
               String time = lblTime.getText();
               String Aid = lblAccNo.getText();
               String AUname = lblUname.getText();
               String Aamount = lblAvailabaleBal.getText();
               String Bid = tbTransferTo.getText();
               String BUname = tbTransferUserName.getText();
               String Bamount = tbTCurrentAmount.getText();
               String Tamount = tbTransferAmount.getText();
                float MinValue = Float.parseFloat(Aamount)-Float.parseFloat(Tamount);
                float AddValue = Float.parseFloat(Bamount)+Float.parseFloat(Tamount);
               
                if(Float.parseFloat(Aamount)<= Float.parseFloat(Tamount) && Float.parseFloat(Aamount) <= 1500 && Float.parseFloat(Tamount) - Float.parseFloat(Aamount) <=1500 ){
                    
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                
                }
                else{
                    
                    try {
                   
                   String sql = "UPDATE tblSavingAccount SET Amount='"+MinValue+"' WHERE Account_No='"+Aid+"' ";
                   String SQL2 = "UPDATE tblSavingAccount SET Amount='"+AddValue+"' WHERE Account_No='"+Bid+"'";
                   String SQL3 = "UPDATE tblClient SET Amount='"+MinValue+"' WHERE Account_No='"+Aid+"' ";
                   String SQL4 = "UPDATE tblClient SET Amount='"+AddValue+"' WHERE Account_No='"+Bid+"'";
                   String SQL5 ="INSERT INTO tblMoneyTransfer (Date,Time,From_Acc,From_User_Name,FBefore_Amount,To_Acc,To_User_Name,TBefore_Amount,Transfered_Amount) VALUES ('"+date+"','"+time+"','"+Aid+"','"+AUname+"','"+Aamount+"','"+Bid+"','"+BUname+"','"+Bamount+"','"+Tamount+"')";
                   pst = conn.prepareStatement(sql);
                   pst2 =conn.prepareStatement(SQL2);
                   pst3 = conn.prepareStatement(SQL3);
                   pst4 = conn.prepareStatement(SQL4);
                   pst5 = conn.prepareStatement(SQL5);
                   pst.execute();
                   pst2.execute();
                   pst3.execute();
                   pst4.execute();
                   pst5.execute();
                   TProgressBar.show();
                   lblProgress1.setText("Processing....");
                   th2 = new progressThread2(TProgressBar);
                   th2.start();
                   btnTCancel.show();
                   btnTCancel.enable();
                   
                   
                   
                   
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e);
               }
                }
           
               
               
               
           }
          }
      
       
       
       
    }//GEN-LAST:event_btnVerifyActionPerformed

    private void btnTCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTCancelActionPerformed
       
            th2.stop();
          int check = JOptionPane.showConfirmDialog(null, "Do you want to cancel?");
           
           if(check == 0){
               
               String Aid = lblAccNo.getText();
               String Aamount = lblAvailabaleBal.getText();
               String Bid = tbTransferTo.getText();
               String Bamount = tbTCurrentAmount.getText();
            
                float MinValue = Float.parseFloat(Aamount);
                float AddValue = Float.parseFloat(Bamount);
                
                try {
                   
                   String sql = "UPDATE tblSavingAccount SET Amount='"+MinValue+"' WHERE Account_No='"+Aid+"' ";
                   String SQL2 = "UPDATE tblSavingAccount SET Amount='"+AddValue+"' WHERE Account_No='"+Bid+"'";
                   pst = conn.prepareStatement(sql);
                   pst2 =conn.prepareStatement(SQL2);
                   pst.execute();
                   pst2.execute();
                   JOptionPane.showMessageDialog(null, "Tranfaction Canceled!");
                    ProgressBar.setValue(0);
                    
        
                   
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e);
               }
                clear();
                lblProgress1.setText("");
                btnTCancel.enable(false);
                btnTCancel.hide();
             
               clear();
               
               
           }
    }//GEN-LAST:event_btnTCancelActionPerformed

    private void tbTCurrentAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbTCurrentAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbTCurrentAmountActionPerformed

    private void btnTransfer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransfer3ActionPerformed
              searchAcc();
    }//GEN-LAST:event_btnTransfer3ActionPerformed

    private void btnTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferActionPerformed
       String TT = tbTransferTo.getText();
       String TA = tbTransferAmount.getText();
       String phone = tbPhone1.getText();
       
       if(TT.equals("") || TA.equals("") || phone.equals("")){
           JOptionPane.showMessageDialog(null, "Please fill all the details!");
       }
       else{
           lblResend.show();
           lblTimer.show();
           timer.start();
           tbTransferAmount.setEnabled(false);
           tbPhone1.setEnabled(false);
           lblOTP.show();
           tbOTP.show();
           btnVerify.show();
           btnTransfer.setEnabled(false);
           
          
             try {
             Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
         Random rand = new Random();
         OTP =rand.nextInt(999999);
         
        Message message = Message
                .creator(new PhoneNumber(phone), // to
                        new PhoneNumber("+12058962320"), // from
                        "eBankONLINE \nPlease Enter OTP : "+OTP+" to complete you online transfaction.Thank You")
                .create();
        JOptionPane.showMessageDialog(null, "OTP sent seccessfully!");
        System.out.println(message.getSid());
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
           
           
       }
    }//GEN-LAST:event_btnTransferActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
       int check = JOptionPane.showConfirmDialog(null, "Do you want to Log Out?");
       
       if (check == 0){
           Login log = new Login();
           log.setVisible(true);
           this.dispose();
       }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void tbDCurrentAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbDCurrentAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDCurrentAmountActionPerformed

    private void tbDepositAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbDepositAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDepositAmountActionPerformed

    private void btnDeposit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeposit1ActionPerformed
            
        
         int check = JOptionPane.showConfirmDialog(null, "Are Details correct?");
         if(check == 0){
             
             String date = lblDate.getText();
             String time = lblTime.getText();
             String id = lblAccNo.getText();
             String uname = lblUname.getText();
             String nic = lblNIC.getText();
             String CAmount =tbDCurrentAmount.getText();
             String DAmount = tbDepositAmount.getText();
             float value = Float.parseFloat(CAmount) + Float.parseFloat(DAmount);
             
             
             
             try {
                  String sql = "UPDATE tblSavingAccount SET Amount='"+value+"' WHERE Account_No='"+id+"'";
                  String SQL2 ="UPDATE tblClient SET Amount='"+value+"' WHERE Account_No='"+id+"'";
                  String SQL3="INSERT INTO tblDeposit (Date,Time,Account_No,User_Name,NIC,Before_Amount,Deposit_Amount,Current_Amount) VALUES ('"+date+"','"+time+"','"+id+"','"+uname+"','"+nic+"','"+CAmount+"','"+DAmount+"','"+value+"')";
                  pst=conn.prepareStatement(sql);
                  pst2 = conn.prepareStatement(SQL2);
                  pst3 = conn.prepareStatement(SQL3);
                  pst.execute();
                  pst2.execute();
                  pst3.execute();
                  ProgressBar.show();
                 lblDProgress.show();
                 lblDProgress.setText("Processing....");
                 th = new progressThread(ProgressBar);
                 th.start();
                 btnDCancel.show();
                 btnDCancel.enable();
                 tbDepositAmount.enable(false);
                 
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
             }
           
         }
            
    
    }//GEN-LAST:event_btnDeposit1ActionPerformed

    private void btnDCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDCancelActionPerformed
      th.stop();

            int check = JOptionPane.showConfirmDialog(null, "Do you want to cancel deposit?");
        
        if(check == 0){
        
        String id = lblAccNo.getText();
        String CAmount = tbDCurrentAmount.getText();
        float value = Float.parseFloat(CAmount);
        try {
            String sql = "UPDATE tblSavingAccount SET Amount='"+value+"' WHERE Account_No='"+id+"'";
            String SQL2 = "UPDATE tblClient SET Amount='"+value+"' WHERE Account_No='"+id+"'";
            String SQL3= "DELETE FROM tblDeposit ORDER BY ID DESC LIMIT 1";
            pst=conn.prepareStatement(sql);
            pst2 = conn.prepareStatement(SQL2);
            pst3 = conn.prepareStatement(SQL3);
            pst.execute();
            pst2.execute();
            pst3.execute();
            
            
          
            JOptionPane.showMessageDialog(null, "Deposit Canceled!");
            ProgressBar.setValue(0);
            ProgressBar.hide();
            btnDCancel.enable(false);
            btnDCancel.hide();
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
         tbDepositAmount.setText("");
         ProgressBar.setValue(0);
         lblDProgress.setText("");
        }
        accDetail();
        tbDepositAmount.enable(true);
    }//GEN-LAST:event_btnDCancelActionPerformed

    private void tbTransferAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbTransferAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbTransferAmountActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
      AboutUS AB = new AboutUS();
      AB.setVisible(true);
     
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        JTpane.setSelectedIndex(5);
        
         btnPrint.setEnabled(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        JTpane.setSelectedIndex(5);
       
        btnPrint.setEnabled(false);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        JTpane.setSelectedIndex(3);
        
             btnPrint.show();
              btnPrint.setEnabled(true);
           status = "Deposit";
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        JTpane.setSelectedIndex(3);
        
         btnPrint.show();
          btnPrint.setEnabled(true);
         status = "Deposit";
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        JTpane.setSelectedIndex(4);
         btnPrint.show();
          btnPrint.setEnabled(true);
           status = "Transfer";
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        JTpane.setSelectedIndex(4);
         btnPrint.show();
          btnPrint.setEnabled(true);
           status = "Transfer";
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        JTpane.setSelectedIndex(1);
        
        btnPrint.setEnabled(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        JTpane.setSelectedIndex(2);
        
        btnPrint.setEnabled(false);

    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        JTpane.setSelectedIndex(1);
        
        btnPrint.setEnabled(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lblDepositMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDepositMouseClicked
        JTpane.setSelectedIndex(1);
       
        btnPrint.setEnabled(false);
        

    }//GEN-LAST:event_lblDepositMouseClicked

    private void tbUnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbUnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbUnameActionPerformed

    private void tbFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFNameActionPerformed

    }//GEN-LAST:event_tbFNameActionPerformed

    private void tbAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbAddressActionPerformed

    private void tbNICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbNICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbNICActionPerformed

    private void tbEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbEmailActionPerformed

    private void tbBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbBDActionPerformed

    private void tbPhone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPhone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPhone1ActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        ChangePassword cp = new ChangePassword();
        cp.setVisible(true);
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
            int id = Integer.parseInt(lblClientID.getText());
            String uname = tbUname.getText();
            String Fname = tbFName.getText();
            
            String address = tbAddress.getText();
            String nic =  tbNIC.getText();
            String bd = tbBD.getText();
            String gen = cbGender.getSelectedItem().toString();
            String acctype = cbAccType.getSelectedItem().toString();
            String email = tbEmail.getText();
            String phone = tbPhone1.getText();
            
            try {
            
                String sql = "UPDATE tblClient SET Client_Name='"+uname+"',FullName='"+Fname+"',NIC='"+nic+"',Address='"+address+"',BD='"+bd+"',Gender='"+gen+"',Account_Type='"+acctype+"',Email='"+email+"',Phone='"+phone+"' WHERE Client_ID = '"+id+"'";
                pst = conn.prepareStatement(sql);
                
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Account Updated Successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
             tbUname.setEditable(false);
        tbFName.setEditable(false);
        tbAddress.setEditable(false);
        tbBD.setEditable(false);
        tbEmail.setEditable(false);
        tbBD.setEditable(false);
        btnSave.setEnabled(false);
          
            
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        tbUname.setEditable(true);
        tbFName.setEditable(true);
        tbAddress.setEditable(true);
        tbBD.setEditable(true);
        tbEmail.setEditable(true);
        tbBD.setEditable(true);
        btnSave.setEnabled(true);
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnTransfer5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransfer5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransfer5ActionPerformed

    private void tblDepositMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepositMouseClicked

    }//GEN-LAST:event_tblDepositMouseClicked

    private void JTpaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTpaneMouseClicked
       
           
       int r = JTpane.getSelectedIndex();
       
       
       if(r==3){
           btnPrint.show();
           btnPrint.setEnabled(true);
           status = "Deposit";
       }
       else if (r==4){
           btnPrint.show();
           btnPrint.setEnabled(true);
           status = "Transfer";
       }
       else{
           btnPrint.setEnabled(false);
           status="";
       }
    
       
    }//GEN-LAST:event_JTpaneMouseClicked

    private void JPDepositDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPDepositDetailsMouseClicked
       
    }//GEN-LAST:event_JPDepositDetailsMouseClicked

    private void JPTransDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPTransDetailMouseClicked
         
    }//GEN-LAST:event_JPTransDetailMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
      AboutUS au = new AboutUS();
      au.setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
       Contact con = new Contact();
       con.setVisible(true);
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        Contact con = new Contact();
       con.setVisible(true);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void tbTransferToKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTransferToKeyTyped
      
    }//GEN-LAST:event_tbTransferToKeyTyped

    private void tbTransferToKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTransferToKeyPressed
        
    }//GEN-LAST:event_tbTransferToKeyPressed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
      if(status.equals("Deposit")){
            MessageFormat header = new MessageFormat("Deposit Report");
            MessageFormat footer = new MessageFormat("-eBankONLINE-");
        
        try {
            tblDeposit.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot Print", e.getMessage());
        }       
      }
        else if (status.equals("Transfer")){
            MessageFormat header = new MessageFormat("Money Transfaction Report");
        MessageFormat footer = new MessageFormat("-eBankONLINE-");
        
        try {
            tblTransfer.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot Print", e.getMessage());
        }       
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       OnlineMessage msg = new OnlineMessage();
       msg.setVisible(true);
      
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void JMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuExitActionPerformed
        int ex =JOptionPane.showConfirmDialog(null, "Do you wan to Exit?");
        if (ex == 0){
            this.dispose();
        }

    }//GEN-LAST:event_JMenuExitActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        AboutUS AU = new AboutUS();
        AU.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed

    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       Contact con =  new Contact();
       con.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Help hp = new Help();
        hp.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuExit;
    private javax.swing.JPanel JPAccInfo;
    private javax.swing.JPanel JPDepositDetails;
    private javax.swing.JPanel JPMoneyDeposit;
    private javax.swing.JPanel JPMoneyTransfer;
    private javax.swing.JPanel JPTransDetail;
    private javax.swing.JPanel JPWelcome;
    private javax.swing.JTabbedPane JTpane;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JProgressBar TProgressBar;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnDCancel;
    private javax.swing.JButton btnDeposit1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTCancel;
    private javax.swing.JButton btnTransfer;
    private javax.swing.JButton btnTransfer3;
    private javax.swing.JButton btnTransfer5;
    private javax.swing.JButton btnVerify;
    private javax.swing.JComboBox<String> cbAccType;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAccNo;
    private javax.swing.JLabel lblAccType;
    private javax.swing.JLabel lblAccountNo;
    private javax.swing.JLabel lblAvailabaleBal;
    private javax.swing.JLabel lblAvalableBal;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblBalance1;
    private javax.swing.JLabel lblCliID;
    private javax.swing.JLabel lblClientID;
    private javax.swing.JLabel lblDProgress;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDeposit;
    private javax.swing.JLabel lblLKR;
    private javax.swing.JLabel lblNIC;
    private javax.swing.JLabel lblOTP;
    private javax.swing.JLabel lblProgress1;
    private javax.swing.JLabel lblResend;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblUname;
    private javax.swing.JTextField tbAddress;
    private javax.swing.JTextField tbBD;
    private javax.swing.JTextField tbDCurrentAmount;
    private javax.swing.JTextField tbDepositAmount;
    private javax.swing.JTextField tbEmail;
    private javax.swing.JTextField tbFName;
    private javax.swing.JTextField tbNIC;
    private javax.swing.JTextField tbOTP;
    private javax.swing.JPasswordField tbPass;
    private javax.swing.JTextField tbPhone1;
    private javax.swing.JTextField tbTCurrentAmount;
    private javax.swing.JTextField tbTransferAmount;
    private javax.swing.JTextField tbTransferTo;
    private javax.swing.JTextField tbTransferUserName;
    private javax.swing.JTextField tbUname;
    private javax.swing.JTable tblDeposit;
    private javax.swing.JTable tblTransfer;
    // End of variables declaration//GEN-END:variables

   
   
}
