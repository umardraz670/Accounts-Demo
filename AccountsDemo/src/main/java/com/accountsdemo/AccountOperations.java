/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accountsdemo;

import models.AccountTableModel;
import database.db;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import models.TableCellCenter;
import models.TableHeaderCenter;

/**
 *
 * @author Orax Solution Provider +923219598676
 */
public class AccountOperations extends javax.swing.JDialog {

    /**
     * Creates new form AccountOperations
     *
     * @param parent
     * @param modal
     */
    private final Map<String, Integer> accounts;
    private final AccountTableModel model;
    private final TableHeaderCenter headerCenter;
    private final TableCellCenter cellCenter;
    private int generalId = -1;
    private Frame parent;

    public AccountOperations(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.parent = parent;
        accounts = new HashMap<>();
        model = new AccountTableModel();
        headerCenter = new TableHeaderCenter();
        cellCenter = new TableCellCenter();
        entryDate.setDate(new Date());
        jProgressBar1.hide();
        jTable1.setModel(model);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);

        jTable1.getColumnModel().getColumn(0).setHeaderRenderer(headerCenter);
        jTable1.getColumnModel().getColumn(1).setHeaderRenderer(headerCenter);
        jTable1.getColumnModel().getColumn(2).setHeaderRenderer(headerCenter);
        jTable1.getColumnModel().getColumn(3).setHeaderRenderer(headerCenter);
        jTable1.getColumnModel().getColumn(4).setHeaderRenderer(headerCenter);
        jTable1.getColumnModel().getColumn(5).setHeaderRenderer(headerCenter);

        jTable1.getColumnModel().getColumn(0).setCellRenderer(cellCenter);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(cellCenter);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(cellCenter);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(cellCenter);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(cellCenter);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(cellCenter);

        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setResizable(false);
        jTable1.getColumnModel().getColumn(4).setResizable(false);
        jTable1.getColumnModel().getColumn(5).setResizable(false);

        getAccounts();
    }

    private void getAccounts() {
        String s;
        try (Connection con = db.getConnection()) {
            ResultSet res = con.createStatement().executeQuery("select * from accounts order by name asc");
            while (res.next()) {
                s = res.getString("name");
                jComboBox1.addItem(s);
                accounts.put(s, res.getInt("id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        entryDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        amount = new javax.swing.JFormattedTextField(Utils.numberFormatter());
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        debit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        credit = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Account Operations");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Accounts Details"));

        jLabel3.setText("Description");
        jPanel3.add(jLabel3);

        description.setPreferredSize(new java.awt.Dimension(285, 22));
        jPanel3.add(description);

        jLabel4.setText("Date");
        jPanel3.add(jLabel4);

        entryDate.setPreferredSize(new java.awt.Dimension(130, 24));
        jPanel3.add(entryDate);

        jLabel5.setText("Amount");
        jPanel3.add(jLabel5);

        amount.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel3.add(amount);

        jLabel1.setText("Accounts");
        jPanel4.add(jLabel1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(200, 22));
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox1KeyReleased(evt);
            }
        });
        jPanel4.add(jComboBox1);

        jLabel2.setText("Select Entry Type");
        jPanel4.add(jLabel2);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Debit", "Credit" }));
        jComboBox2.setFocusable(false);
        jComboBox2.setMinimumSize(new java.awt.Dimension(80, 22));
        jPanel4.add(jComboBox2);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Account Entries"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setText("Total Debit");

        debit.setEditable(false);
        debit.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setText("Total Credit");

        credit.setEditable(false);
        credit.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(debit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(credit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(debit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(credit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyReleased
        // TODO add your handling code here:
        PreparedStatement ps = null;
        ResultSet res = null;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jComboBox1.getSelectedIndex() > 0) {
                try (Connection con = db.getConnection()) {
                    int id = accounts.get(jComboBox1.getSelectedItem().toString());
                    ps = con.prepareStatement("select * from accounts_generals where account_fk=?");
                    ps.setInt(1, id);
                    res = ps.executeQuery();
                    if (res.next()) {
                        debit.setText("" + res.getFloat("debit"));
                        credit.setText("" + res.getFloat("credit"));
                        generalId = res.getInt("id");
                        ps = con.prepareStatement("SELECT "
                                + "    ae.id,"
                                + "    ae.description,"
                                + "    at.id AS 'accountType',"
                                + "    ae.entry_date,"
                                + "    amount,"
                                + "    ag.id AS 'generalId',"
                                + "    CONCAT(u.first_name, ' ', u.last_name) AS 'user' "
                                + "FROM"
                                + "    accounts_entries ae"
                                + "        INNER JOIN"
                                + "    accounts_generals ag ON ae.account_general_fk = ag.id"
                                + "        INNER JOIN"
                                + "    users u ON ae.user_id_fk = u.id"
                                + "        INNER JOIN"
                                + "    account_types at ON ae.account_type_fk = at.id "
                                + "WHERE "
                                + "    ag.account_fk=?");
                        ps.setInt(1, accounts.get(jComboBox1.getSelectedItem().toString()));
                        res = ps.executeQuery();
                        model.removeAll();
                        jProgressBar1.show();
                        jProgressBar1.setIndeterminate(true);
                        while (res.next()) {
                            model.addRow(new Entry(
                                    res.getInt("id"),
                                    res.getString("description"),
                                    res.getInt("accountType"),
                                    res.getDate("entry_date"),
                                    res.getFloat("amount"),
                                    res.getInt("generalId"),
                                    res.getString("user")));
                        }
                        jProgressBar1.setIndeterminate(false);
                        jProgressBar1.hide();
                    } else {
                        debit.setText("");
                        credit.setText("");
                        generalId = -1;
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jComboBox1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PreparedStatement ps = null;
        ResultSet res = null;
        try (Connection con = db.getConnection()) {
            int id = accounts.get(jComboBox1.getSelectedItem().toString());
            ps = con.prepareStatement("select * from accounts_generals where account_fk=?");
            ps.setInt(1, id);
            res = ps.executeQuery();
            if (res.next()) {
                generalId = res.getInt("id");
                if (entryDate.getDate() != null) {
                    if (amount.getValue() != null) {
                        ps = con.prepareStatement("insert into accounts_entries("
                                + "description,"
                                + "entry_date,"
                                + "amount,"
                                + "account_general_fk,"
                                + "user_id_fk,"
                                + "account_type_fk) values(?,?,?,?,?,?)");
                        ps.setString(1, description.getText());
                        ps.setDate(2, new java.sql.Date(entryDate.getDate().getTime()));
                        ps.setFloat(3, ((Integer) amount.getValue()).floatValue());
                        ps.setInt(4, generalId);
                        ps.setInt(5, 1);
                        ps.setInt(6, jComboBox2.getSelectedIndex() == 0 ? 1 : 2);
                        if (ps.executeUpdate() == 1) {
                            con.commit();
                            JOptionPane.showMessageDialog(rootPane, "Entry Saved");
                            debit.setText("");
                            credit.setText("");
                            generalId = -1;
                            model.removeAll();
                            jComboBox2.setSelectedIndex(0);
                            jComboBox1.setSelectedIndex(0);
                            description.setText("");
                            amount.setValue(0);
                        }
                    }
                }
            } else {
                new CreateAccountGeneral(parent, true, id).show();
                debit.setText("");
                credit.setText("");
                generalId = -1;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(AccountOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AccountOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AccountOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AccountOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                AccountOperations dialog = new AccountOperations(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField amount;
    private javax.swing.JTextField credit;
    private javax.swing.JTextField debit;
    private javax.swing.JTextField description;
    private org.jdesktop.swingx.JXDatePicker entryDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
