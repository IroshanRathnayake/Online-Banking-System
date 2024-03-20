/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf;

import inf.DepositDetails;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;

/**
 *
 * @author Iroshan
 */
public class Reports extends javax.swing.JFrame {

    /**
     * Creates new form Reports
     */
    String status = null;
    
    public Reports() {
        initComponents();
        Login log = new Login();
        log.setIcon();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        lblUser.setText(Home.lblUser.getText());
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
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
        jLabel24 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lblBank = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        btnPrint1 = new javax.swing.JButton();
        btnPrint2 = new javax.swing.JButton();
        btnPrint3 = new javax.swing.JButton();
        btnPrint4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        setTitle("Reports");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Date & Time :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("Log Out");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 60, -1, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-shutdown-35 (1).png"))); // NOI18N
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 50, -1, -1));

        jPanel3.setBackground(new java.awt.Color(32, 101, 101));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setBackground(new java.awt.Color(0, 153, 255));
        jLabel27.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("eBanking");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Home");
        jLabel28.setToolTipText("Go to Home Page");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 50, 20));

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
        jPanel3.add(lblReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

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

        lblTime.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reports");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 120, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-left-24.png"))); // NOI18N
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 30, -1));

        lblDate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 3, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 51, 204));
        jLabel30.setText("4.Deposit Details");
        jLabel30.setToolTipText("Search Deposit Details Here");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 180, -1));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 51, 204));
        jLabel31.setText("3.Employee Details");
        jLabel31.setToolTipText("Search Transfaction Details Here");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        lblBank.setBackground(new java.awt.Color(255, 255, 255));
        lblBank.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblBank.setForeground(new java.awt.Color(0, 51, 204));
        lblBank.setText("1.Bank Account Details");
        lblBank.setToolTipText("Search Deposit Details Here");
        lblBank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBankMouseClicked(evt);
            }
        });
        jPanel1.add(lblBank, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, 40));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 51, 204));
        jLabel33.setText("5.Transfaction Details");
        jLabel33.setToolTipText("Search Transfaction Details Here");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 51, 204));
        jLabel34.setText("2.Client Details");
        jLabel34.setToolTipText("Search Transfaction Details Here");
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        btnPrint.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-print-35.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 120, 40));

        btnPrint1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPrint1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-print-35.png"))); // NOI18N
        btnPrint1.setText("Print");
        btnPrint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrint1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 120, 40));

        btnPrint2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPrint2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-print-35.png"))); // NOI18N
        btnPrint2.setText("Print");
        btnPrint2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrint2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 120, 40));

        btnPrint3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPrint3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-print-35.png"))); // NOI18N
        btnPrint3.setText("Print");
        btnPrint3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrint3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 120, 40));

        btnPrint4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPrint4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/icons8-print-35.png"))); // NOI18N
        btnPrint4.setText("Print");
        btnPrint4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrint4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 120, 40));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("* You can get all the Reports Here.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 210, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 750, 470));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/beautiful-wallpaper-39.jpg"))); // NOI18N
        jLabel2.setText("jLabel1");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -220, 1390, 1130));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/beautiful-wallpaper-39.jpg"))); // NOI18N
        jLabel4.setText("jLabel1");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -220, 1390, 1130));

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

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        int check = JOptionPane.showConfirmDialog(null, "Do you want to Log Out?");

        if (check == 0){
            Login log = new Login();
            log.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked

        Home hm = new Home();
        hm.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jLabel28MouseClicked

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

    private void lblReportAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblReportAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblReportAncestorAdded

    private void lblReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblReportMouseClicked

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

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        Home hm = new Home();
        hm.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
      
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
       
    }//GEN-LAST:event_jLabel31MouseClicked

    private void lblBankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBankMouseClicked
        
    }//GEN-LAST:event_lblBankMouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel34MouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        Transfactiondetails TD =  new Transfactiondetails();
        TD.print();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnPrint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrint1ActionPerformed
        
           BankAccountSearch BAS =  new BankAccountSearch();
           BAS.print();
    }//GEN-LAST:event_btnPrint1ActionPerformed

    private void btnPrint2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrint2ActionPerformed
        ClientAccountSearch CAS = new ClientAccountSearch();
        CAS.print();
    }//GEN-LAST:event_btnPrint2ActionPerformed

    private void btnPrint3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrint3ActionPerformed
       EmployeeAccountSearch EAS =  new EmployeeAccountSearch();
       EAS.print();
    }//GEN-LAST:event_btnPrint3ActionPerformed

    private void btnPrint4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrint4ActionPerformed
       DepositDetails DAD = new DepositDetails();
       DAD.print();
    }//GEN-LAST:event_btnPrint4ActionPerformed

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
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuExit;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnPrint1;
    private javax.swing.JButton btnPrint2;
    private javax.swing.JButton btnPrint3;
    private javax.swing.JButton btnPrint4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblBank;
    private javax.swing.JLabel lblBankAccounts;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblHelp;
    private javax.swing.JLabel lblReport;
    private javax.swing.JLabel lblTime;
    public static javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
}
