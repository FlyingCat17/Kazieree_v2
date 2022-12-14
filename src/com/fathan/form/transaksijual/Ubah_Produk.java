/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.transaksijual;

import com.fathan.form.produk.*;
import com.fathan.db.configdb;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Fathan
 */
public class Ubah_Produk extends javax.swing.JDialog {

    /**
     * Creates new form Tambah_Produk
     */
    public Ubah_Produk(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        label_warning_kp.setVisible(false);
        label_warning_kp1.setVisible(false);
        loadData();
        System.out.println("Kode Produk : " + new com.fathan.form.transaksijual.getKode_Produk().getKode_produk());
    }

//    public void cari(String key) {
//        if (field_kp.getText().equals("")) {
//            field_np.setText("");
//            field_s.setText("");
//            field_hp.setText("");
//            field_jumlah.setEnabled(false);
//            field_jumlah.setText("");
//            label_sisastok.setText("-");
//        } else {
//            try {
//                String sql = "SELECT produk.kode_produk,`nama_produk`,`id_kategori`,`satuan`,`harga_beli`,`harga_jual`, stok.jumlah_stok FROM produk LEFT JOIN stok\n"
//                        + "ON produk.kode_produk = stok.kode_produk\n"
//                        + "WHERE produk.kode_produk LIKE '" + key + "'";
//                java.sql.Connection conn = (Connection) configdb.GetConnection();
//                java.sql.Statement st = conn.createStatement();
//                java.sql.ResultSet rs = st.executeQuery(sql);
//                if (rs.next()) {
//                    if (rs.getString("jumlah_stok") == null) {
//                        field_np.setText(rs.getString("nama_produk"));
//                        field_s.setText(rs.getString("satuan"));
//                        field_hp.setText(rs.getString("harga_jual"));
//                        field_jumlah.setText("-");
//                        label_sisastok.setText("jasa");
//                    } else {
//                        field_np.setText(rs.getString("nama_produk"));
//                        field_s.setText(rs.getString("satuan"));
//                        field_hp.setText(rs.getString("harga_jual"));
//                        field_jumlah.setText("");
//                        field_jumlah.setEnabled(true);
//                        label_sisastok.setText(rs.getString("jumlah_stok"));
//                    }
//                } else {
//                    field_np.setText("");
//                    field_s.setText("");
//                    field_hp.setText("");
//                    field_jumlah.setEnabled(false);
//                    field_jumlah.setText("");
//                    label_sisastok.setText("-");
//                }
//
//            } catch (SQLException e) {
//                System.err.println("Get Data Produk [Tambah Produk] : " + e.getMessage());
//            }
//
//        }
//    }
    com.fathan.form.transaksijual.getKode_Produk k_p = new com.fathan.form.transaksijual.getKode_Produk();

    public void loadData() {

        field_kp.setText(k_p.getKode_produk());
        try {
            String sql = "SELECT temp_jual.kode_produk, temp_jual.nama_produk, temp_jual.qty, temp_jual.harga_jual, produk.satuan"
                    + " FROM temp_jual JOIN produk ON temp_jual.kode_produk = produk.kode_produk WHERE temp_jual.kode_produk = '" + new com.fathan.form.transaksijual.getKode_Produk().getKode_produk() + "'";
            String sql1 = "SELECT stok.jumlah_stok AS Sisa FROM stok WHERE stok.kode_produk = '" + k_p.getKode_produk() + "'";
            java.sql.Connection conn = (Connection) configdb.GetConnection();
            java.sql.Statement st = conn.createStatement();
            java.sql.Statement st1 = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            java.sql.ResultSet rs1 = st1.executeQuery(sql1);
            if (rs.next()) {
                if (rs.getString("satuan").equals("Jasa")) {
                    field_np.setText(rs.getString("nama_produk"));
                    field_s.setText("Jasa");
                    field_hp.setText(rs.getString("harga_jual"));
                    field_jumlah.setEnabled(false);
                    label_sisastok.setText("Jasa");
                    System.out.println("Dapetnya Jasa");
                    button2.setEnabled(false);
                    button2.setBackground(Color.GRAY);
                    button2.setForeground(Color.WHITE);
                    button3.setText("HAPUS JASA");
                } else {
                    if (rs1.next()) {
                        field_np.setText(rs.getString("nama_produk"));
                        field_s.setText(rs.getString("satuan"));
                        field_hp.setText(rs.getString("harga_jual"));
                        field_jumlah.setText(rs.getString("qty"));
                        label_sisastok.setText(rs.getString("qty"));
                        
                    }
                }
            }
            field_jumlah.requestFocus();
        } catch (Exception e) {
            System.err.println("load data : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBordeer1 = new com.fathan.swing.PanelBordeer();
        jLabel1 = new javax.swing.JLabel();
        panelBordeer3 = new com.fathan.swing.PanelBordeer();
        field_np = new javax.swing.JTextField();
        panelBordeer2 = new com.fathan.swing.PanelBordeer();
        field_kp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelBordeer4 = new com.fathan.swing.PanelBordeer();
        field_s = new javax.swing.JTextField();
        panelBordeer5 = new com.fathan.swing.PanelBordeer();
        field_hp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelBordeer6 = new com.fathan.swing.PanelBordeer();
        field_jumlah = new javax.swing.JTextField();
        button3 = new com.fathan.form.produk.Button();
        button1 = new com.fathan.form.produk.Button();
        button2 = new com.fathan.form.produk.Button();
        jLabel3 = new javax.swing.JLabel();
        label_warning_kp1 = new javax.swing.JLabel();
        label_warning_kp = new javax.swing.JLabel();
        label_sisastok = new javax.swing.JLabel();
        label_warning_kp3 = new javax.swing.JLabel();

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
        panelBordeer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Hapus Produk");
        panelBordeer1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 500, 50));

        panelBordeer3.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer3.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_np.setBackground(new java.awt.Color(226, 226, 226));
        field_np.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_np.setBorder(null);
        field_np.setEnabled(false);
        field_np.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_npActionPerformed(evt);
            }
        });
        field_np.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_npKeyTyped(evt);
            }
        });
        panelBordeer3.add(field_np, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 460, 40));

        panelBordeer1.add(panelBordeer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 490, 40));

        panelBordeer2.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer2.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_kp.setBackground(new java.awt.Color(226, 226, 226));
        field_kp.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_kp.setBorder(null);
        field_kp.setEnabled(false);
        field_kp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_kpActionPerformed(evt);
            }
        });
        field_kp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                field_kpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_kpKeyTyped(evt);
            }
        });
        panelBordeer2.add(field_kp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 320, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/produk/Barcode.png"))); // NOI18N
        panelBordeer2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 30, 20));

        panelBordeer1.add(panelBordeer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 490, 40));

        jLabel5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Nama Produk");
        panelBordeer1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, -1));

        jLabel6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Satuan");
        panelBordeer1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 100, -1));

        panelBordeer4.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer4.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_s.setBackground(new java.awt.Color(226, 226, 226));
        field_s.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_s.setBorder(null);
        field_s.setEnabled(false);
        field_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_sActionPerformed(evt);
            }
        });
        field_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_sKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_sKeyTyped(evt);
            }
        });
        panelBordeer4.add(field_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        panelBordeer1.add(panelBordeer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 130, 40));

        panelBordeer5.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer5.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_hp.setBackground(new java.awt.Color(226, 226, 226));
        field_hp.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_hp.setBorder(null);
        field_hp.setEnabled(false);
        field_hp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_hpActionPerformed(evt);
            }
        });
        field_hp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_hpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_hpKeyTyped(evt);
            }
        });
        panelBordeer5.add(field_hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 120, 40));

        jLabel7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Rp");
        panelBordeer5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        panelBordeer1.add(panelBordeer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 170, 40));

        jLabel9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Harga Produk");
        panelBordeer1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 100, -1));

        jLabel10.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Jumlah Stok yang dihapus");
        panelBordeer1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 170, -1));

        panelBordeer6.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer6.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_jumlah.setBackground(new java.awt.Color(226, 226, 226));
        field_jumlah.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_jumlah.setBorder(null);
        field_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_jumlahActionPerformed(evt);
            }
        });
        field_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_jumlahKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                field_jumlahKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_jumlahKeyTyped(evt);
            }
        });
        panelBordeer6.add(field_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        panelBordeer1.add(panelBordeer6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 170, 40));

        button3.setBackground(new java.awt.Color(255, 51, 51));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("HAPUS SEMUA");
        button3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 150, 40));

        button1.setBackground(new java.awt.Color(255, 51, 51));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("BATAL");
        button1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 150, 40));

        button2.setBackground(new java.awt.Color(19, 179, 200));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("SIMPAN");
        button2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 150, 40));

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Kode Produk");
        panelBordeer1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 100, -1));

        label_warning_kp1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_kp1.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_kp1.setText("Ketikkan Jumlah !");
        panelBordeer1.add(label_warning_kp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 160, 20));

        label_warning_kp.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_kp.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_kp.setText("Harap Pilih Produk !");
        panelBordeer1.add(label_warning_kp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 370, 20));

        label_sisastok.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        label_sisastok.setForeground(new java.awt.Color(19, 179, 200));
        label_sisastok.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_sisastok.setText("Tidak Ada");
        panelBordeer1.add(label_sisastok, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 100, 20));

        label_warning_kp3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        label_warning_kp3.setForeground(new java.awt.Color(19, 179, 200));
        label_warning_kp3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_warning_kp3.setText("Stok Sebelumnya :");
        panelBordeer1.add(label_warning_kp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 150, 20));

        getContentPane().add(panelBordeer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(19);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void field_kpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_kpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_kpActionPerformed

    private void field_kpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_kpKeyTyped
        char k = evt.getKeyChar();
        if (Character.isLowerCase(k)) {
            evt.setKeyChar(Character.toUpperCase(k));
        }
//        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
//            
//        }
        if (field_kp.isEditable()) {
            label_warning_kp.setVisible(false);
        }

    }//GEN-LAST:event_field_kpKeyTyped

    private void field_npActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_npActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_npActionPerformed

    private void field_npKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_npKeyTyped

    }//GEN-LAST:event_field_npKeyTyped

    private void field_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_sActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_sActionPerformed

    private void field_sKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_sKeyTyped
        if (field_s.isEditable()) {
        }
        if (field_s.getText().length() >= 6) {
            evt.consume();
        }

    }//GEN-LAST:event_field_sKeyTyped

    private void field_hpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_hpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_hpActionPerformed

    private void field_hpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_hpKeyTyped
        char k = evt.getKeyChar();
        if (field_hp.isEditable()) {

        }
        if (!(Character.isDigit(k) || k == KeyEvent.VK_BACK_SPACE || k == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (field_hp.getText().length() >= 12) {
            evt.consume();
        }
    }//GEN-LAST:event_field_hpKeyTyped

    private void field_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_jumlahActionPerformed

    private void field_jumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_jumlahKeyTyped
        char k = evt.getKeyChar();
        if (field_jumlah.isEditable()) {

        }
        if (!(Character.isDigit(k) || k == KeyEvent.VK_BACK_SPACE || k == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (field_jumlah.getText().length() >= 12) {
            evt.consume();
        }

    }//GEN-LAST:event_field_jumlahKeyTyped

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        new com.fathan.form.transaksijual.getKode_Produk().setKode_produk(null);
        for (double i = 1.0; i >= 0.1; i = i - 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(10);
                if (this.getOpacity() <= 0.25) {
                    this.dispose();
                }

            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        if (field_jumlah.getText().isEmpty()) {
            label_warning_kp1.setVisible(true);
            label_warning_kp1.setText("Ketikkan Jumlah!");
            field_jumlah.requestFocus();
        } else {
            if (field_s.getText() == "Jasa") {
//                try {
//                    String sql = "REPLACE INTO temp_jual(kode_produk, nama_produk, qty, harga_jual)\n"
//                            + "VALUES('" + field_kp.getText() + "', '" + field_np.getName() + "', " + Integer.parseInt(field_jumlah.getText()) + ", " + Integer.parseInt(field_hp.getText()) + ")";
//                    java.sql.Connection con = (Connection) configdb.GetConnection();
//                    java.sql.Statement st = con.createStatement();
//                    st.execute(sql);
//                    System.out.println("Jasa Berhasil Diubah!!");
//                    for (double i = 1.0; i >= 0.1; i = i - 0.25) {
//                        String val = i + "";
//                        float f = Float.valueOf(val);
//                        this.setOpacity(f);
//                        try {
//                            Thread.sleep(10);
//                            if (this.getOpacity() <= 0.25) {
//                                this.dispose();
//                            }
//
//                        } catch (Exception e) {
//                        }
//                    }
//                } catch (Exception e) {
//                    System.err.println("Ubah Jasa : " + e.getMessage());
//                }
            } else {
                if (Integer.parseInt(field_jumlah.getText()) > Integer.parseInt(label_sisastok.getText())) {
                    label_warning_kp1.setVisible(true);
                    label_warning_kp1.setText("Stok Kelebihan");
                    field_jumlah.requestFocus();
                } else {
                    try {
                        String sql = "UPDATE temp_jual SET temp_jual.qty = temp_jual.qty - "+Integer.parseInt(field_jumlah.getText())
                                + " WHERE temp_jual.kode_produk = '"+k_p.getKode_produk()+"'";
                        String sql1 = "UPDATE `stok` SET `jumlah_stok`= jumlah_stok + "+Integer.parseInt(field_jumlah.getText())+" WHERE kode_produk = '"+k_p.getKode_produk()+"'";
                        java.sql.Connection con = (Connection) configdb.GetConnection();
                        java.sql.Statement st = con.createStatement();
                        java.sql.Statement st1 = con.createStatement();
                        st.execute(sql);
                        st1.execute(sql1);
                        for (double i = 1.0; i >= 0.1; i = i - 0.25) {
                            String val = i + "";
                            float f = Float.valueOf(val);
                            this.setOpacity(f);
                            try {
                                Thread.sleep(10);
                                if (this.getOpacity() <= 0.25) {
                                    this.dispose();
                                }

                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Ubah Barang : " + e.getMessage());
                    }
                }
            }
        }


    }//GEN-LAST:event_button2ActionPerformed


    private void field_hpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_hpKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            System.out.println("Disabled");
            evt.consume();
        }
    }//GEN-LAST:event_field_hpKeyPressed

    private void field_jumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_jumlahKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            System.out.println("Disabled");
            evt.consume();
        }

    }//GEN-LAST:event_field_jumlahKeyPressed

    private void field_sKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_sKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            System.out.println("Disabled Satuan");
            evt.consume();
        }
    }//GEN-LAST:event_field_sKeyPressed

    private void field_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_jumlahKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_field_jumlahKeyReleased

    private void field_kpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_kpKeyReleased
//        String key = field_kp.getText();
//
//        if (key != "") {
//            cari(key);
//        } else {
//            field_np.setText("");
//            field_s.setText("");
//            field_hp.setText("");
//            field_jumlah.setEnabled(false);
//            field_jumlah.setText("");
//            label_sisastok.setText("-");
//        }
    }//GEN-LAST:event_field_kpKeyReleased

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        
        new com.fathan.form.transaksijual.option_hapus(new com.fathan.form.transaksijual.transaksi_jual(), true).setVisible(true);
        if (new com.fathan.form.transaksijual.getKode_Produk().isOpsi_hapus_yes() == true) {
            for (double i = 1.0; i >= 0.1; i = i - 0.25) {
                String val = i + "";
                float f = Float.valueOf(val);
                this.setOpacity(f);
                try {
                    Thread.sleep(10);
                    if (this.getOpacity() <= 0.25) {
                        this.dispose();
                    }

                } catch (Exception e) {

                }
            }
        }
    }//GEN-LAST:event_button3ActionPerformed

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
            java.util.logging.Logger.getLogger(Ubah_Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ubah_Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ubah_Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ubah_Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ubah_Produk dialog = new Ubah_Produk(new javax.swing.JFrame(), true);
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
    private com.fathan.form.produk.Button button3;
    private javax.swing.JTextField field_hp;
    private javax.swing.JTextField field_jumlah;
    private javax.swing.JTextField field_kp;
    private javax.swing.JTextField field_np;
    private javax.swing.JTextField field_s;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel label_sisastok;
    private javax.swing.JLabel label_warning_kp;
    private javax.swing.JLabel label_warning_kp1;
    private javax.swing.JLabel label_warning_kp3;
    private com.fathan.swing.PanelBordeer panelBordeer1;
    private com.fathan.swing.PanelBordeer panelBordeer2;
    private com.fathan.swing.PanelBordeer panelBordeer3;
    private com.fathan.swing.PanelBordeer panelBordeer4;
    private com.fathan.swing.PanelBordeer panelBordeer5;
    private com.fathan.swing.PanelBordeer panelBordeer6;
    // End of variables declaration//GEN-END:variables
}
