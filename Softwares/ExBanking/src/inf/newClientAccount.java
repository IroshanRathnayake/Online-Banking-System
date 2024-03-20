/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf;

import codes.DBconnect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.security.util.Password;

/**
 *
 * @author Iroshan
 */
public class newClientAccount extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    ResultSet rs2;
    
    String status =null;
    
    public newClientAccount() {
        initComponents();
        Login log = new Login();
        log.setIcon();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        lblUser.setText(Home.lblUser.getText());
        tbPassword.enable(false);
        conn = DBconnect.connect();
        clientID();
        date();
        time();
        
    }
     public void date(){
        
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        lblDate.setText(sdf.format(d));
    }
    public void time(){
        
      new javax.swing.Timer(0, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
              
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                lblTime.setText(sdf.format(d));
              
          }
      }){
            
        }.start();
    }
    public void clientID(){
        try {
            String sql = "SELECT * FROM tblClient ORDER BY Client_ID DESC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if (rs.next()){
                int id = rs.getInt("Client_ID");
                    int relID = id +1;
                lblClientlID.setText(Integer.toString(relID));
         }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void search(){
        
        int id = Integer.parseInt(tbAccNo.getText());
        
        
        try {
            
            String SQL2 = "SELECT * FROM tblClient WHERE Account_No = '"+id+"'";
            String sql = "SELECT * FROM tblSavingAccount WHERE Account_No='"+id+"'";
            pst = conn.prepareStatement(sql);
            pst2 = conn.prepareStatement(SQL2);
            rs = pst.executeQuery();
            rs2 = pst2.executeQuery();
            
            if(rs2.next()){
                
                JOptionPane.showMessageDialog(null, "Account Already Exist!");
                tbAccNo.setText("");
                
            }
            else{
                 if(rs.next()){
                String uname = rs.getString("User_Name");
                    tbNameWithInitials.setText(uname);
                String fname = rs.getString("FullName");
                    tbFName.setText(fname);
                String nic = rs.getString("NIC");
                    tbNIC.setText(nic);
                String address = rs.getString("Address");
                    tbAddress.setText(address);
                String bd = rs.getString("BD");
                    tbBirth.setText(bd);
                String gen = rs.getString("Gender");
                    cbGender.setSelectedItem(gen);
                String acctype = rs.getString("Account_Type");
                    cbAccType.setSelectedItem(acctype);
                String email = rs.getString("Email");
                    tbEmail.setText(email);
                String phone = rs.getString("Phone");
                    tbPhone.setText(phone);
                float amount = rs.getFloat("Amount");
                    lblAmount.setText(Float.toString(amount));
            }
            else {
                JOptionPane.showMessageDialog(null, "Create New Bank Account!");
                tbAccNo.setText("");
            }
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
            
    public void reset(){
       tbAccNo.setText("");
        tbFName.setText("");
        tbNameWithInitials.setText("");
        tbAccNo.setText("");
        tbNIC.setText("");
        tbPhone.setText("");
        tbAddress.setText("");
        tbBirth.setText("");
        tbPassword.setText("");
       tbEmail.setText("");
        cbAccType.setSelectedIndex(0);
        cbGender.setSelectedIndex(0);
        lblAmount.setText("");
    }
   
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        tbFName = new javax.swing.JTextField();
        tbNameWithInitials = new javax.swing.JTextField();
        tbAccNo = new javax.swing.JTextField();
        tbBirth = new javax.swing.JTextField();
        cbGender = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAddress = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tbPassword = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        tbEmail = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cbAccType = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        tbPhone = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        tbNIC = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblClientlID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPhoneSign = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblBankAccounts = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblReport = new javax.swing.JLabel();
        lblHelp = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        JMenuExit = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("New Client Account");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(1380, 780));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(44, 62, 80));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 190, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Amount :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 700, 70, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText(" Full Name : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 80, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Name with Initials : ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Account Number:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Address : ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 70, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Date of birth : ");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, 100, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Gender : ");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 640, 60, -1));

        lblAmount.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 700, 150, 20));

        tbFName.setEditable(false);
        tbFName.setBackground(new java.awt.Color(204, 204, 204));
        tbFName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbFName.setToolTipText("Enter Full Name");
        tbFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFNameActionPerformed(evt);
            }
        });
        jPanel1.add(tbFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 650, 30));

        tbNameWithInitials.setEditable(false);
        tbNameWithInitials.setBackground(new java.awt.Color(204, 204, 204));
        tbNameWithInitials.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tbNameWithInitials, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 650, 30));

        tbAccNo.setBackground(new java.awt.Color(204, 204, 204));
        tbAccNo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbAccNoActionPerformed(evt);
            }
        });
        jPanel1.add(tbAccNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 210, 260, 30));

        tbBirth.setEditable(false);
        tbBirth.setBackground(new java.awt.Color(204, 204, 204));
        tbBirth.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tbBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 560, 180, 30));

        cbGender.setBackground(new java.awt.Color(204, 204, 204));
        cbGender.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        jPanel1.add(cbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 640, 130, -1));

        tbAddress.setEditable(false);
        tbAddress.setBackground(new java.awt.Color(204, 204, 204));
        tbAddress.setColumns(20);
        tbAddress.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbAddress.setRows(5);
        jScrollPane1.setViewportView(tbAddress);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 270, 80));

        jLabel26.setText("* DD/MM/YYYY");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 600, -1, -1));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel27.setText("Phone Number : ");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 380, -1, -1));

        tbPassword.setEditable(false);
        tbPassword.setBackground(new java.awt.Color(204, 204, 204));
        tbPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(tbPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 550, 190, 30));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel28.setText("  Email : ");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 470, 50, -1));

        tbEmail.setEditable(false);
        tbEmail.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(tbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 460, 190, 30));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-left-24.png"))); // NOI18N
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 30, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create a New Client Account");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        btnAdd.setBackground(new java.awt.Color(204, 204, 204));
        btnAdd.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(153, 51, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 140, 90, 30));

        btnReset.setBackground(new java.awt.Color(204, 204, 204));
        btnReset.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(153, 51, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 140, 90, 30));

        cbAccType.setBackground(new java.awt.Color(204, 204, 204));
        cbAccType.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbAccType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Saving Account", "FixDeposit Account" }));
        cbAccType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAccTypeActionPerformed(evt);
            }
        });
        jPanel1.add(cbAccType, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 640, 150, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Account Type :");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 640, -1, -1));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel35.setText("Password : ");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 560, -1, -1));

        tbPhone.setEditable(false);
        tbPhone.setBackground(new java.awt.Color(204, 204, 204));
        tbPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbPhoneActionPerformed(evt);
            }
        });
        jPanel1.add(tbPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 380, 190, 30));

        jButton3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jButton3.setText("Generate");
        jButton3.setToolTipText("Generate a Password");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 590, -1, -1));

        tbNIC.setEditable(false);
        tbNIC.setBackground(new java.awt.Color(204, 204, 204));
        tbNIC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tbNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 260, 30));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText(" NIC number : ");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, -1, -1));

        btnSearch.setBackground(new java.awt.Color(204, 204, 204));
        btnSearch.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(153, 51, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-search-24.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 210, -1, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Client ID : ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 70, -1));

        lblClientlID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblClientlID.setText("ID");
        jPanel1.add(lblClientlID, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("LKR");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 710, -1, -1));

        lblPhoneSign.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblPhoneSign.setText("*with Country Code");
        jPanel1.add(lblPhoneSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 420, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Date & Time :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Log Out");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 60, -1, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-shutdown-35 (1).png"))); // NOI18N
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 50, -1, -1));

        jPanel3.setBackground(new java.awt.Color(32, 101, 101));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setBackground(new java.awt.Color(0, 153, 255));
        jLabel34.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("eBanking");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Home");
        jLabel37.setToolTipText("Go to Home Page");
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 50, 20));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Employees");
        jLabel18.setToolTipText("Add Employee");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jLabel18.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jLabel18ComponentMoved(evt);
            }
        });
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        lblBankAccounts.setBackground(new java.awt.Color(255, 255, 255));
        lblBankAccounts.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblBankAccounts.setForeground(new java.awt.Color(255, 255, 255));
        lblBankAccounts.setText("Bank Accounts\n");
        lblBankAccounts.setToolTipText("Bank Account Type Details Here");
        lblBankAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBankAccountsMouseClicked(evt);
            }
        });
        jPanel3.add(lblBankAccounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        lblUser.setBackground(new java.awt.Color(255, 255, 255));
        lblUser.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Admin");
        lblUser.setToolTipText("Log Out");
        lblUser.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblUserAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserMouseClicked(evt);
            }
        });
        jPanel3.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 70, -1));

        lblReport.setBackground(new java.awt.Color(255, 255, 255));
        lblReport.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblReport.setForeground(new java.awt.Color(255, 255, 255));
        lblReport.setText("Reports");
        lblReport.setToolTipText("Get Bank Reports");
        lblReport.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblReportAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReportMouseClicked(evt);
            }
        });
        jPanel3.add(lblReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        lblHelp.setBackground(new java.awt.Color(255, 255, 255));
        lblHelp.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblHelp.setForeground(new java.awt.Color(255, 255, 255));
        lblHelp.setText("Help");
        lblHelp.setToolTipText("Get Bank Reports");
        lblHelp.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblHelpAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHelpMouseClicked(evt);
            }
        });
        jPanel3.add(lblHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 50, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 1180, 50));

        jPanel9.setBackground(new java.awt.Color(32, 101, 101));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel9.setToolTipText("Money Deposit Here");
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Money Deposit");
        jLabel19.setToolTipText("Money Deposit Here");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, -1));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 250, 50));

        jPanel10.setBackground(new java.awt.Color(32, 101, 101));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel10.setToolTipText("Money Transfer Here");
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Money Transfer");
        jLabel21.setToolTipText("Money Transfer Here");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 250, 50));

        jPanel14.setBackground(new java.awt.Color(32, 101, 101));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel14.setToolTipText("Search Transfaction Details Here");
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Transfaction Details");
        jLabel38.setToolTipText("Search Transfaction Details Here");
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel15.setBackground(new java.awt.Color(153, 51, 255));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Transfaction Details");
        jLabel39.setToolTipText("Bank Branch List");
        jPanel15.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 250, 50));

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 250, 50));

        jPanel12.setBackground(new java.awt.Color(32, 101, 101));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel12.setToolTipText("Search Deposit Details Here");
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Deposit Details");
        jLabel22.setToolTipText("Search Deposit Details Here");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel13.setBackground(new java.awt.Color(153, 51, 255));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Transfaction Details");
        jLabel40.setToolTipText("Bank Branch List");
        jPanel13.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 250, 50));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 250, 50));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 3, true));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 860, 570));

        lblTime.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/beautiful-wallpaper-39.jpg"))); // NOI18N
        jLabel11.setText("jLabel1");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -220, 1390, 1130));

        lblDate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 790));

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-print-16.png"))); // NOI18N
        jMenuItem2.setText("Print");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-change-user-16.png"))); // NOI18N
        jMenuItem1.setText("Changer User");
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

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-contact-16.png"))); // NOI18N
        jMenuItem4.setText("Developer");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbFNameActionPerformed

    private void tbPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPasswordActionPerformed
            
    }//GEN-LAST:event_tbPasswordActionPerformed

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
      Home hm = new Home();
        hm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        int accno = Integer.parseInt(tbAccNo.getText());
        String fname = tbFName.getText();
        String uname = tbNameWithInitials.getText();
        String nic = tbAccNo.getText();
        String phone = tbPhone.getText();
        String address = tbAddress.getText();
        String bd = tbBirth.getText();
        String pass = tbPassword.getText();
        String email= tbEmail.getText();
        String acctype = cbAccType.getSelectedItem().toString();
        String gen = cbGender.getSelectedItem().toString();
        float amount = Float.parseFloat(lblAmount.getText());
        
     
        if(tbAccNo.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill all the details!");
        }
        else{
            if(pass.equals("")){
                JOptionPane.showMessageDialog(null, "Please genarate the password!");
            }
            else{
                try {
            
            String SQL2 = "INSERT INTO tblClient (Account_No,Client_Name,FullName,NIC,Address,BD,Gender,Password,Email,Phone,Amount) VALUES ('"+accno+"','"+uname+"','"+fname+"','"+nic+"','"+address+"','"+bd+"','"+gen+"','"+pass+"','"+email+"','"+phone+"','"+amount+"')";
            pst2 = conn.prepareStatement(SQL2);
            pst2.execute();
            JOptionPane.showMessageDialog(null, "Added Successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        
        }
            }
             
        }
        reset();
    
      
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbAccTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAccTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAccTypeActionPerformed

    private void tbPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPhoneActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int length = 6;
         StringBuilder str = new StringBuilder();
         for (int i=0 ; i<length; i++){
             int num = randomNum();
             char ch = GenPass.charAt(num);
             str.append(ch);
             
         }                                       
         tbPassword.setText(str.toString());
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       search();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tbAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbAccNoActionPerformed
       search();
    }//GEN-LAST:event_tbAccNoActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        int check = JOptionPane.showConfirmDialog(null, "Do you want to Log Out?");

        if (check == 0){
            Login log = new Login();
            log.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked

        Home hm = new Home();
        hm.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        status = "Employee";
        Home hm = new Home();
        hm.user();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel18ComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18ComponentMoved

    private void lblBankAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBankAccountsMouseClicked
        AccountTypeDetails ATD = new AccountTypeDetails();
        ATD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBankAccountsMouseClicked

    private void lblUserAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblUserAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUserAncestorAdded

    private void lblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUserMouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        Deposit DP = new Deposit();
        DP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        Deposit DP = new Deposit();
        DP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        MoneyTransfer MT = new MoneyTransfer();
        MT.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        MoneyTransfer MT = new MoneyTransfer();
        MT.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        Transfactiondetails TD = new Transfactiondetails();
        TD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel38MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        Transfactiondetails TD = new Transfactiondetails();
        TD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        DepositDetails DD = new DepositDetails();
        DD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        DepositDetails DD = new DepositDetails();
        DD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel12MouseClicked

    private void lblReportAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblReportAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblReportAncestorAdded

    private void lblReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportMouseClicked
        Reports rp = new Reports();
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblReportMouseClicked

    private void lblHelpAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblHelpAncestorAdded

    }//GEN-LAST:event_lblHelpAncestorAdded

    private void lblHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHelpMouseClicked
        Help hp =new Help();
        hp.setVisible(true);
    }//GEN-LAST:event_lblHelpMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
       clientID();
       reset();
       
       
    }//GEN-LAST:event_btnResetActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Reports rpts = new Reports();
        rpts.setVisible(true);
        this.dispose();
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
        AboutBank AB = new AboutBank();
        AB.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed

    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Help hp =  new Help();
        hp.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed


    
    private String GenPass = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    
    private int randomNum(){
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(GenPass.length());
        return randomInt;
        
    }
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
            java.util.logging.Logger.getLogger(newClientAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newClientAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newClientAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newClientAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newClientAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuExit;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbAccType;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBankAccounts;
    private javax.swing.JLabel lblClientlID;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblHelp;
    private javax.swing.JLabel lblPhoneSign;
    private javax.swing.JLabel lblReport;
    private javax.swing.JLabel lblTime;
    public static javax.swing.JLabel lblUser;
    private javax.swing.JTextField tbAccNo;
    private javax.swing.JTextArea tbAddress;
    private javax.swing.JTextField tbBirth;
    private javax.swing.JTextField tbEmail;
    private javax.swing.JTextField tbFName;
    private javax.swing.JTextField tbNIC;
    private javax.swing.JTextField tbNameWithInitials;
    private javax.swing.JTextField tbPassword;
    private javax.swing.JTextField tbPhone;
    // End of variables declaration//GEN-END:variables
}
