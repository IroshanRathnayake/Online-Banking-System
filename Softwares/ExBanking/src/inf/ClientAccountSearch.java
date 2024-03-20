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
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Iroshan
 */
public class ClientAccountSearch extends javax.swing.JFrame {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        String status = null;
    public ClientAccountSearch() {
        initComponents();
        Login log = new Login();
        log.setIcon();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        lblUser.setText(Home.lblUser.getText());
        conn = DBconnect.connect();
        tableLoad();
        editBoxdisable();
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
     public void tableLoad(){
            
            try {
                
                String sql = "SELECT Client_ID,Account_No,Client_Name,NIC,Address,BD,Gender,Account_Type,Password,Email,Phone,Amount FROM tblClient";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                tblClient.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
     public void tableData(){
           int r = tblClient.getSelectedRow();

        String ClientID = tblClient.getValueAt(r, 0).toString();

        try {

            String sql = "SELECT * FROM tblClient WHERE Client_ID ='"+ClientID +"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {

                String id = rs.getString("Client_ID");
                    lblClientID.setText(id);
                String accno = rs.getString("Account_No");
                    lblAccountNo.setText(accno);
                String UName = rs.getString("Client_Name");
                    tbCname.setText(UName);
                String FName = rs.getString("FullName");
                    tbFName.setText(FName);
                String nic = rs.getString("NIC");
                    tbNIC.setText(nic);
                String Address = rs.getString("Address");
                    tbAddress.setText(Address);
                String bd = rs.getString("BD");
                    tbBD.setText(bd);
                String gen = rs.getString("Gender");                  
                    cbGender.setSelectedItem(gen);
                String AccType = rs.getString("Account_Type");
                    cbAccType.setSelectedItem(AccType);
                String pass = rs.getString("Password");
                    tbPassword.setText(pass);
                String email = rs.getString("Email");
                    tbEmail.setText(email);
                String phone = rs.getString("Phone");
                    tbPhone.setText(phone);
                String balance = rs.getString("Amount");
                    lblBalance.setText(balance);
                

                
                 
                
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        
         
     }
     public void search(){
         
         String srch = tbSearch.getText();
         
        try {

            String sql = "SELECT * FROM tblClient WHERE Client_Name LIKE '%" + srch + "%' || Client_ID LIke '%" + srch + "%' || NIC LIKE '%" + srch + "%'";
            // String ="SELECT * FROM student WHERE ID='"+srch+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tblClient.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
     }
     public void editBoxEnable(){
         tbCname.setEditable(true);
         tbFName.setEditable(true);
         tbNIC.setEditable(true);
         tbAddress.setEditable(true);
         tbBD.setEditable(true);
         cbGender.setEditable(true);
         cbAccType.setEditable(true);
         tbEmail.setEditable(true);
         tbPhone.setEditable(true);
         
     }
     public void editBoxdisable(){
         tbCname.setEditable(false);
         tbFName.setEditable(false);
         tbNIC.setEditable(false);
         tbAddress.setEditable(false);
         tbBD.setEditable(false);
         cbGender.setEditable(false);
         cbAccType.setEditable(false);
         tbPassword.setEditable(false);
         tbEmail.setEditable(false);
         tbPhone.setEditable(false);
         
         
     }
     public void tbClear(){
         lblClientID.setText("");
         lblAccountNo.setText("");
         tbCname.setText("");
         tbFName.setText("");
         tbNIC.setText("");
         tbAddress.setText("");
         tbBD.setText("");
         cbGender.setSelectedIndex(0);
         cbAccType.setSelectedIndex(0);
         tbPassword.setText("");
         tbEmail.setText("");
         tbPhone.setText("");
         lblBalance.setText("");
         
        
     }
     

     public void print(){
            MessageFormat header = new MessageFormat("Deposit Report");
            MessageFormat footer = new MessageFormat("-eBankONLINE-");
            
            try {
            tblClient.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot Print", e.getMessage());
        }       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        tbSearch = new javax.swing.JTextField();
        JTpane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClient = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblBDsign = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tbCname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        tbEmail = new javax.swing.JTextField();
        tbAddress = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tbFName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        tbPhone = new javax.swing.JTextField();
        lblPhoneSign = new javax.swing.JLabel();
        cbAccType = new javax.swing.JComboBox<>();
        tbPassword = new javax.swing.JTextField();
        tbNIC = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblAccountNo = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        tbBD = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        lblClientID = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lblBankAccounts = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblReport = new javax.swing.JLabel();
        lblHelp = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        btnPrint3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
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
        setTitle("Client Account Details");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Client Account Search");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-left-24.png"))); // NOI18N
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 30, -1));

        tbSearch.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tbSearch.setToolTipText("Search Here");
        tbSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true), "Search Here", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        tbSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbSearchKeyReleased(evt);
            }
        });
        getContentPane().add(tbSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 140, 270, 40));

        JTpane.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblClient.setBackground(new java.awt.Color(204, 204, 204));
        tblClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblClient);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 990, 500));

        JTpane.addTab("Client Account Search", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel12.setText("Phone Number : ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, -1, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel8.setText("Password : ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 90, -1));

        lblBDsign.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblBDsign.setText("*DD/MM/YYYY");
        jPanel2.add(lblBDsign, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, -1, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel10.setText("  Account Type : ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("  Account Number : ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        btnEdit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/edit-icon.png"))); // NOI18N
        btnEdit.setText(" Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel2.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 100, 30));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel7.setText("Address : ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Full Name : ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an Item", "Male", "Female", " " }));
        jPanel2.add(cbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 130, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("NIC Number : ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("Client Name : ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        lblBalance.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblBalance.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(lblBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 210, 20));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel14.setText("Current Balance : ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        tbCname.setEditable(false);
        tbCname.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbCname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbCnameActionPerformed(evt);
            }
        });
        jPanel2.add(tbCname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 290, 30));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel11.setText("Email :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/Actions-edit-delete-icon.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 100, 30));

        tbEmail.setEditable(false);
        tbEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbEmailActionPerformed(evt);
            }
        });
        jPanel2.add(tbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 280, 30));

        tbAddress.setEditable(false);
        tbAddress.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbAddressActionPerformed(evt);
            }
        });
        jPanel2.add(tbAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 560, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("LKR");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, -1, -1));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel9.setText("Gender : ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        tbFName.setEditable(false);
        tbFName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFNameActionPerformed(evt);
            }
        });
        jPanel2.add(tbFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 560, 30));

        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-save-16.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 100, 30));

        tbPhone.setEditable(false);
        tbPhone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbPhoneActionPerformed(evt);
            }
        });
        jPanel2.add(tbPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 150, 30));

        lblPhoneSign.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblPhoneSign.setText("*with Country Code");
        jPanel2.add(lblPhoneSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, -1, -1));

        cbAccType.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbAccType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an Item", "Saving Account" }));
        jPanel2.add(cbAccType, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 130, -1));

        tbPassword.setEditable(false);
        tbPassword.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(tbPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 150, 30));

        tbNIC.setEditable(false);
        tbNIC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbNIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNICActionPerformed(evt);
            }
        });
        jPanel2.add(tbNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 290, 30));

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel2.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 440, 100, 30));

        lblAccountNo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel2.add(lblAccountNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 220, 20));

        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel32.setText(" Birth Date : ");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 100, -1));

        tbBD.setEditable(false);
        tbBD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBDActionPerformed(evt);
            }
        });
        jPanel2.add(tbBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 150, 30));

        jLabel33.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel33.setText("Client ID :");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        lblClientID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel2.add(lblClientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 210, 20));

        JTpane.addTab("Client Account Details", jPanel2);

        getContentPane().add(JTpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 1000, 530));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("Date & Time :");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("Log Out");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 60, -1, -1));

        lblTime.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, -1, -1));

        lblDate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-shutdown-35 (1).png"))); // NOI18N
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 50, -1, -1));

        jPanel3.setBackground(new java.awt.Color(32, 101, 101));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setBackground(new java.awt.Color(0, 153, 255));
        jLabel29.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("eBanking");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Home");
        jLabel30.setToolTipText("Go to Home Page");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 50, 20));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Employees");
        jLabel34.setToolTipText("Add Employee");
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });
        jLabel34.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jLabel34ComponentMoved(evt);
            }
        });
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 1180, 50));

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

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 250, 50));

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

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 250, 50));

        jPanel14.setBackground(new java.awt.Color(32, 101, 101));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel14.setToolTipText("Search Transfaction Details Here");
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Transfaction Details");
        jLabel24.setToolTipText("Search Transfaction Details Here");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel15.setBackground(new java.awt.Color(153, 51, 255));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Transfaction Details");
        jLabel25.setToolTipText("Bank Branch List");
        jPanel15.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 250, 50));

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 250, 50));

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

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Transfaction Details");
        jLabel23.setToolTipText("Bank Branch List");
        jPanel13.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 250, 50));

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 250, 50));

        btnPrint3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPrint3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-print-35.png"))); // NOI18N
        btnPrint3.setText("Print");
        btnPrint3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrint3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrint3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 120, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/beautiful-wallpaper-39.jpg"))); // NOI18N
        jLabel2.setText("jLabel1");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -220, 1390, 1130));

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

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        Home hm = new Home();
        hm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel31MouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
            editBoxEnable();
           
    }//GEN-LAST:event_btnEditActionPerformed

    private void tbCnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbCnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCnameActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
            String id = lblClientID.getText();
            int check = JOptionPane.showConfirmDialog(null, "Do you want to Delete?");
            
            if(check==0){
            try {
                
                String sql="DELETE FROM tblClient WHERE Client_ID='"+id+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Account Deleted Successfully!");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
            
            }
            tableLoad();
            editBoxdisable();
            tbClear();
      
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbEmailActionPerformed

    private void tbAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbAddressActionPerformed

    private void tbFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFNameActionPerformed

    }//GEN-LAST:event_tbFNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
          int id = Integer.parseInt(lblClientID.getText());
            String Cname = tbCname.getText();
            String Fname = tbFName.getText();
            String address = tbAddress.getText();
            String nic =  tbNIC.getText();
            String bd = tbBD.getText();
            String gen = cbGender.getSelectedItem().toString();
            String acctype = cbAccType.getSelectedItem().toString();
            String pass = tbPassword.getText();
            String email = tbEmail.getText();
            String phone = tbPhone.getText();
            
            try {
            
                String sql = "UPDATE tblClient SET Client_Name='"+Cname+"',FullName='"+Fname+"',NIC='"+nic+"',Address='"+address+"',BD='"+bd+"',Gender='"+gen+"',Account_Type='"+acctype+"',Password='"+pass+"',Email='"+email+"',Phone='"+phone+"' WHERE Client_ID = '"+id+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Account Updated Successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            tableLoad();
            tbClear();
            editBoxdisable();
            
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tbPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPhoneActionPerformed

    private void tbPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPasswordActionPerformed

    private void tbNICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbNICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbNICActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
            tbClear();
            editBoxdisable();
            tableLoad();
    }//GEN-LAST:event_btnBackActionPerformed

    private void tbBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbBDActionPerformed

    private void tblClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientMouseClicked
        JTpane.setSelectedIndex(1);
        tableData();
    }//GEN-LAST:event_tblClientMouseClicked

    private void tbSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbSearchKeyReleased
       search();
    }//GEN-LAST:event_tbSearchKeyReleased

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        int check = JOptionPane.showConfirmDialog(null, "Do you want to Log Out?");

        if (check == 0){
            Login log = new Login();
            log.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked

        Home hm = new Home();
        hm.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        status = "Employee";
        Home hm =new Home();
        hm.user();
    }//GEN-LAST:event_jLabel34MouseClicked

    private void jLabel34ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel34ComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel34ComponentMoved

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

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        Transfactiondetails TD = new Transfactiondetails();
        TD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel24MouseClicked

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

    private void btnPrint3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrint3ActionPerformed
        print();
    }//GEN-LAST:event_btnPrint3ActionPerformed

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
            java.util.logging.Logger.getLogger(ClientAccountSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientAccountSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientAccountSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientAccountSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientAccountSearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuExit;
    private javax.swing.JTabbedPane JTpane;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPrint3;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbAccType;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAccountNo;
    private javax.swing.JLabel lblBDsign;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblBankAccounts;
    private javax.swing.JLabel lblClientID;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblHelp;
    private javax.swing.JLabel lblPhoneSign;
    private javax.swing.JLabel lblReport;
    private javax.swing.JLabel lblTime;
    public static javax.swing.JLabel lblUser;
    private javax.swing.JTextField tbAddress;
    private javax.swing.JTextField tbBD;
    private javax.swing.JTextField tbCname;
    private javax.swing.JTextField tbEmail;
    private javax.swing.JTextField tbFName;
    private javax.swing.JTextField tbNIC;
    private javax.swing.JTextField tbPassword;
    private javax.swing.JTextField tbPhone;
    private javax.swing.JTextField tbSearch;
    private javax.swing.JTable tblClient;
    // End of variables declaration//GEN-END:variables
}
