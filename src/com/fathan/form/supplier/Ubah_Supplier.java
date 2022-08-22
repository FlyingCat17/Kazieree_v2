/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.supplier;

import com.fathan.db.configdb;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Fathan
 */
public class Ubah_Supplier extends javax.swing.JDialog {

    /**
     * Creates new form Tambah_Produk
     */
    public Ubah_Supplier(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        field_ns.requestFocus();
        label_warning_ks.setVisible(false);
        label_warning_nt.setVisible(false);
        label_warning_ns.setVisible(false);
        label_warning_nu.setVisible(false);
        label_warning_a.setVisible(false);
        label_success.setVisible(false);
        getDataSupplier();
    }

    public void getDataSupplier() {
        try {
            String sql = "SELECT * FROM pemasok WHERE pemasok.kode_pemasok = '" 
                    + new com.fathan.form.supplier.getdataSupplier().getKode_supplier()+"';";
            java.sql.Connection con = (Connection)configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                field_ks.setText(rs.getString("kode_pemasok"));
                field_ns.setText(rs.getString("nama_pemasok"));
                field_nu.setText(rs.getString("nama_usaha"));
                field_nt.setText(rs.getString("no_telepon"));
                field_a.setText(rs.getString("alamat"));
            }
        } catch (Exception e) {
            System.err.println("Get Data Supplier : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBordeer1 = new com.fathan.swing.PanelBordeer();
        label_success = new javax.swing.JLabel();
        label_warning_a = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelBordeer3 = new com.fathan.swing.PanelBordeer();
        field_ns = new javax.swing.JTextField();
        panelBordeer2 = new com.fathan.swing.PanelBordeer();
        field_ks = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelBordeer4 = new com.fathan.swing.PanelBordeer();
        field_nu = new javax.swing.JTextField();
        panelBordeer5 = new com.fathan.swing.PanelBordeer();
        field_nt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelBordeer6 = new com.fathan.swing.PanelBordeer();
        jScrollPane1 = new javax.swing.JScrollPane();
        field_a = new javax.swing.JTextArea();
        button1 = new com.fathan.form.produk.Button();
        button2 = new com.fathan.form.produk.Button();
        jLabel3 = new javax.swing.JLabel();
        label_warning_ks = new javax.swing.JLabel();
        label_warning_ns = new javax.swing.JLabel();
        label_warning_nu = new javax.swing.JLabel();
        label_warning_nt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBordeer1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 179, 200)));
        panelBordeer1.setForeground(new java.awt.Color(255, 255, 255));
        panelBordeer1.setPreferredSize(new java.awt.Dimension(930, 520));
        panelBordeer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_success.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_success.setForeground(new java.awt.Color(0, 153, 0));
        label_success.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_success.setText("Data Berhasil Diubah!");
        panelBordeer1.add(label_success, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 390, 50));

        label_warning_a.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_a.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_a.setText("Alamat Kosong!");
        panelBordeer1.add(label_warning_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 300, 20));

        jLabel1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Ubah Supplier");
        panelBordeer1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 500, 50));

        panelBordeer3.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer3.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_ns.setBackground(new java.awt.Color(226, 226, 226));
        field_ns.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_ns.setBorder(null);
        field_ns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nsActionPerformed(evt);
            }
        });
        field_ns.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_nsKeyTyped(evt);
            }
        });
        panelBordeer3.add(field_ns, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 40));

        panelBordeer1.add(panelBordeer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 380, 40));

        panelBordeer2.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer2.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_ks.setBackground(new java.awt.Color(226, 226, 226));
        field_ks.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_ks.setBorder(null);
        field_ks.setEnabled(false);
        field_ks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_ksActionPerformed(evt);
            }
        });
        field_ks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_ksKeyTyped(evt);
            }
        });
        panelBordeer2.add(field_ks, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 40));

        panelBordeer1.add(panelBordeer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 380, 40));

        jLabel5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Nama Supplier");
        panelBordeer1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, -1));

        jLabel6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Nama Usaha");
        panelBordeer1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 100, -1));

        panelBordeer4.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer4.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_nu.setBackground(new java.awt.Color(226, 226, 226));
        field_nu.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_nu.setBorder(null);
        field_nu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nuActionPerformed(evt);
            }
        });
        field_nu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_nuKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_nuKeyTyped(evt);
            }
        });
        panelBordeer4.add(field_nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 40));

        panelBordeer1.add(panelBordeer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 380, 40));

        panelBordeer5.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer5.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_nt.setBackground(new java.awt.Color(226, 226, 226));
        field_nt.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_nt.setBorder(null);
        field_nt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_ntActionPerformed(evt);
            }
        });
        field_nt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_ntKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_ntKeyTyped(evt);
            }
        });
        panelBordeer5.add(field_nt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 360, 40));

        panelBordeer1.add(panelBordeer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 380, 40));

        jLabel9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nomor Telepon");
        panelBordeer1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 100, -1));

        jLabel10.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Alamat");
        panelBordeer1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 100, -1));

        panelBordeer6.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer6.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        field_a.setBackground(new java.awt.Color(226, 226, 226));
        field_a.setColumns(20);
        field_a.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_a.setLineWrap(true);
        field_a.setRows(5);
        field_a.setWrapStyleWord(true);
        field_a.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_aKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(field_a);

        panelBordeer6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 110));

        panelBordeer1.add(panelBordeer6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 390, 130));

        button1.setBackground(new java.awt.Color(255, 51, 51));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("BATAL");
        button1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 180, 40));

        button2.setBackground(new java.awt.Color(19, 179, 200));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("SIMPAN");
        button2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 190, 40));

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Kode Supplier");
        panelBordeer1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 100, -1));

        label_warning_ks.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_ks.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_ks.setText("Kode Supplier Kosong!");
        panelBordeer1.add(label_warning_ks, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 370, 20));

        label_warning_ns.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_ns.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_ns.setText("Nama Supplier Kosong!");
        panelBordeer1.add(label_warning_ns, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 300, 20));

        label_warning_nu.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_nu.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_nu.setText("Nama Usaha Kosong!");
        panelBordeer1.add(label_warning_nu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 130, 20));

        label_warning_nt.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_nt.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_nt.setText("Nomor Telepon Kosong!");
        panelBordeer1.add(label_warning_nt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 160, 20));

        getContentPane().add(panelBordeer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            System.out.println(f);
            try {
                Thread.sleep(19);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void field_ksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_ksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_ksActionPerformed

    private void field_ksKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_ksKeyTyped
        char k = evt.getKeyChar();
        if (field_ks.isEditable()) {
            label_warning_ks.setVisible(false);
            if (field_ks.getText().length() >= 45) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_ks.setVisible(true);
                label_warning_ks.setText("Kode Produk tidak boleh melebihi 45 Karakter !");
            } else if (field_ns.getText().length() >= 80) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_ns.setVisible(true);
                label_warning_ns.setText("Kode Produk tidak boleh melebihi 80 Karakter !");
                label_warning_ks.setVisible(false);
            } else {
                button2.setBackground(new Color(19, 179, 200));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(true);
                label_warning_ks.setVisible(false);
            }
        }


    }//GEN-LAST:event_field_ksKeyTyped

    private void field_nsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nsActionPerformed

    private void field_nsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_nsKeyTyped
        if (field_ns.isEditable()) {
            label_warning_ns.setVisible(false);
            if (field_ns.getText().length() >= 80) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_ns.setVisible(true);
                label_warning_ns.setText("Nama Supplier tidak boleh melebihi 80 karakter");
            } else if (field_nu.getText().length() >= 50) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_ns.setVisible(false);
            } else if (field_a.getText().length() >= 200) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_ns.setVisible(false);
            } else {
                button2.setBackground(new Color(19, 179, 200));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(true);
                label_warning_ns.setVisible(false);
            }
        }
    }//GEN-LAST:event_field_nsKeyTyped

    private void field_nuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nuActionPerformed

    private void field_nuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_nuKeyTyped
        if (field_nu.isEditable()) {
            label_warning_nu.setVisible(false);
            if (field_nu.getText().length() >= 50) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_nu.setVisible(true);
                label_warning_nu.setText("Nama Usaha tidak boleh melebihi 50 karakter");
            } else if (field_ns.getText().length() >= 80) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_nu.setVisible(false);
            } else if (field_a.getText().length() >= 200) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_nu.setVisible(false);
            } else {
                button2.setBackground(new Color(19, 179, 200));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(true);
                label_warning_nu.setVisible(false);
            }
        }


    }//GEN-LAST:event_field_nuKeyTyped

    private void field_ntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_ntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_ntActionPerformed

    private void field_ntKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_ntKeyTyped
        char k = evt.getKeyChar();
        if (field_nt.isEditable()) {
            label_warning_nt.setVisible(false);
        }
        if (!(Character.isDigit(k) || k == KeyEvent.VK_BACK_SPACE || k == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (field_nt.getText().length() >= 13) {
            evt.consume();
        }
    }//GEN-LAST:event_field_ntKeyTyped

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        new com.fathan.form.supplier.getdataSupplier().setKode_supplier(null);
        for (double i = 1.0; i >= 0.1; i = i - 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            System.out.println(f);
            try {
                Thread.sleep(10);
                if (this.getOpacity() <= 0.25) {
                    this.dispose();
                }

            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_button1ActionPerformed

//    public void autoKode() {
//        try {
//            String sql = "SELECT MAX(RIGHT(pemasok.kode_pemasok,5)) AS nomor FROM pemasok";
//            java.sql.Connection con = (Connection)configdb.GetConnection();
//            java.sql.Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            java.sql.ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                if (rs.first() == false) {
//                    field_ks.setText("P00001");
//                } else {
//                    rs.last();
//                    int autoId = rs.getInt(1) + 1;
//                    String no = String.valueOf(autoId);
//                    int noLong = no.length();
//                    for (int i = 0; i < 5 - noLong; i++) {
//                        no = "0" + no;
//                    }
//                    field_ks.setText("P" + no);
//                    System.out.println(no);
//                }
//            }
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//    }
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        Connection con;
        PreparedStatement pst, pst1;
        String ks, ns, nu, nt, a;
        ks = field_ks.getText().toString();
        ns = field_ns.getText().toString();
        nu = field_nu.getText().toString();
        nt = field_nt.getText();
        a = field_a.getText();
        if (ks.isEmpty()) {
            label_warning_ks.setVisible(true);
            label_warning_ks.setText("Kode Supplier Kosong!");
        } else if (ns.isEmpty()) {
            label_warning_ns.setVisible(true);
            label_warning_ns.setText("Nama Supplier Kosong!");
            field_ns.requestFocus();
        } else if (nu.isEmpty()) {
            label_warning_nu.setVisible(true);
            label_warning_nu.setText("Nama Usaha Kosong!");
            field_nu.requestFocus();
        } else if (nt.equals("")) {
            label_warning_nt.setVisible(true);
            label_warning_nt.setText("Nomor Telepon Kosong!");
            field_nt.requestFocus();
        } else if (a.equals("")) {
            label_warning_a.setVisible(true);
            label_warning_a.setText("Alamat Supplier Kosong!");
            field_a.requestFocus();
        } else {
            try {
                String sql = "UPDATE `pemasok` SET `nama_pemasok`='"+ns+"',`nama_usaha`='"+nu+"',`no_telepon`='"+nt+"',`alamat`='"+a+"' "
                        + "WHERE kode_pemasok = '"+ks+"'";
                con = (Connection) configdb.GetConnection();
                pst = con.prepareStatement(sql);
                pst.execute();
                label_success.setVisible(true);
                autoKode();
                getDataSupplier();
            } catch (Exception e) {
                System.err.println("Input Data Supplier : " + e.getMessage());
            }
        }

    }//GEN-LAST:event_button2ActionPerformed
    public void autoKode() {
        try {
            String sql = "SELECT MAX(RIGHT(pemasok.kode_pemasok,5)) AS nomor FROM pemasok";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.first() == false) {
                    field_ks.setText("P00001");
                } else {
                    rs.last();
                    int autoId = rs.getInt(1) + 1;
                    String no = String.valueOf(autoId);
                    int noLong = no.length();
                    for (int i = 0; i < 5 - noLong; i++) {
                        no = "0" + no;
                    }
                    field_ks.setText("P" + no);
                    System.out.println(no);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private void field_ntKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_ntKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            System.out.println("Disabled");
            evt.consume();
        }
    }//GEN-LAST:event_field_ntKeyPressed

    private void field_nuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_nuKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            System.out.println("Disabled Satuan");
            evt.consume();
        }
    }//GEN-LAST:event_field_nuKeyPressed

    private void field_aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_aKeyTyped
        if (field_a.isEditable()) {
            label_warning_a.setVisible(false);
            if (field_a.getText().length() >= 200) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_a.setVisible(true);
                label_warning_a.setText("Alamat Supplier tidak boleh melebihi 200 karakter");
            } else if (field_ns.getText().length() >= 80) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_a.setVisible(false);
            } else if (field_nu.getText().length() >= 50) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_a.setVisible(false);
            } else {
                button2.setBackground(new Color(19, 179, 200));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(true);
                label_warning_a.setVisible(false);
            }
        }
    }//GEN-LAST:event_field_aKeyTyped

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
            java.util.logging.Logger.getLogger(Ubah_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ubah_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ubah_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ubah_Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ubah_Supplier dialog = new Ubah_Supplier(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fathan.form.produk.Button button1;
    private com.fathan.form.produk.Button button2;
    private javax.swing.JTextArea field_a;
    private javax.swing.JTextField field_ks;
    private javax.swing.JTextField field_ns;
    private javax.swing.JTextField field_nt;
    private javax.swing.JTextField field_nu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_success;
    private javax.swing.JLabel label_warning_a;
    private javax.swing.JLabel label_warning_ks;
    private javax.swing.JLabel label_warning_ns;
    private javax.swing.JLabel label_warning_nt;
    private javax.swing.JLabel label_warning_nu;
    private com.fathan.swing.PanelBordeer panelBordeer1;
    private com.fathan.swing.PanelBordeer panelBordeer2;
    private com.fathan.swing.PanelBordeer panelBordeer3;
    private com.fathan.swing.PanelBordeer panelBordeer4;
    private com.fathan.swing.PanelBordeer panelBordeer5;
    private com.fathan.swing.PanelBordeer panelBordeer6;
    // End of variables declaration//GEN-END:variables
}
