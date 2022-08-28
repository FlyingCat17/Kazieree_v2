/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.pengguna;

import com.fathan.db.configdb;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Locale;

/**
 *
 * @author Fathan
 */
public class Ubah_Pengguna extends javax.swing.JDialog {

    boolean username_similar;

    /**
     * Creates new form Tambah_Produk
     */
    public Ubah_Pengguna(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        label_warning_ip.setVisible(false);
        label_warning_nl.setVisible(false);
        label_warning_us.setVisible(false);
        label_warning_us1.setVisible(false);
        label_success.setVisible(false);
        label_success1.setVisible(false);
        radioButtonCustom1.setActionCommand("P");
        radioButtonCustom2.setActionCommand("L");
        field_ip.setText(new com.fathan.form.pengguna.getPengguna().getId_pengguna());
        loadDataPenggunaa();
        label_jk.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelBordeer1 = new com.fathan.swing.PanelBordeer();
        jLabel1 = new javax.swing.JLabel();
        button3 = new com.fathan.form.produk.Button();
        panelBordeer5 = new com.fathan.swing.PanelBordeer();
        field_nt = new javax.swing.JTextField();
        panelBordeer4 = new com.fathan.swing.PanelBordeer();
        field_nl = new javax.swing.JTextField();
        panelBordeer3 = new com.fathan.swing.PanelBordeer();
        field_us = new javax.swing.JTextField();
        panelBordeer2 = new com.fathan.swing.PanelBordeer();
        field_ip = new javax.swing.JTextField();
        button1 = new com.fathan.form.produk.Button();
        button2 = new com.fathan.form.produk.Button();
        jLabel3 = new javax.swing.JLabel();
        label_warning_ip = new javax.swing.JLabel();
        label_warning_nl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_warning_us1 = new javax.swing.JLabel();
        label_jk = new javax.swing.JLabel();
        label_warning_us = new javax.swing.JLabel();
        label_success1 = new javax.swing.JLabel();
        label_success = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelBordeer7 = new com.fathan.swing.PanelBordeer();
        jScrollPane1 = new javax.swing.JScrollPane();
        field_a = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        radioButtonCustom1 = new com.fathan.swing.RadioButtonCustom();
        radioButtonCustom2 = new com.fathan.swing.RadioButtonCustom();
        jLabel2 = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("ADMIN");
        panelBordeer1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 390, 50));

        button3.setBackground(new java.awt.Color(255, 51, 51));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("RESET KATA SANDI");
        button3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 150, 40));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_ntKeyTyped(evt);
            }
        });
        panelBordeer5.add(field_nt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 370, 40));

        panelBordeer1.add(panelBordeer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 390, 40));

        panelBordeer4.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer4.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_nl.setBackground(new java.awt.Color(226, 226, 226));
        field_nl.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_nl.setBorder(null);
        field_nl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nlActionPerformed(evt);
            }
        });
        field_nl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_nlKeyTyped(evt);
            }
        });
        panelBordeer4.add(field_nl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 370, 40));

        panelBordeer1.add(panelBordeer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 390, 40));

        panelBordeer3.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer3.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_us.setBackground(new java.awt.Color(226, 226, 226));
        field_us.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_us.setBorder(null);
        field_us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_usActionPerformed(evt);
            }
        });
        field_us.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                field_usKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_usKeyTyped(evt);
            }
        });
        panelBordeer3.add(field_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 360, 40));

        panelBordeer1.add(panelBordeer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 390, 40));

        panelBordeer2.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer2.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_ip.setBackground(new java.awt.Color(226, 226, 226));
        field_ip.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_ip.setBorder(null);
        field_ip.setEnabled(false);
        field_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_ipActionPerformed(evt);
            }
        });
        field_ip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_ipKeyTyped(evt);
            }
        });
        panelBordeer2.add(field_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 370, 40));

        panelBordeer1.add(panelBordeer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 390, 40));

        button1.setBackground(new java.awt.Color(255, 51, 51));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("BATAL");
        button1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 190, 40));

        button2.setBackground(new java.awt.Color(19, 179, 200));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("SIMPAN");
        button2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 190, 40));

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("ID Pengguna");
        panelBordeer1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 200, -1));

        label_warning_ip.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_ip.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_ip.setText("Kode Produk Kosong!");
        panelBordeer1.add(label_warning_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 370, 20));

        label_warning_nl.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_nl.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_nl.setText("Nama Lengkap Kosong!");
        panelBordeer1.add(label_warning_nl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 300, 20));

        jLabel7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Jenis Kelamin :");
        panelBordeer1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 100, 30));

        label_warning_us1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_us1.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_us1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_warning_us1.setText("Username Telah Terpakai !");
        panelBordeer1.add(label_warning_us1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 200, 20));

        label_jk.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_jk.setForeground(new java.awt.Color(255, 51, 51));
        label_jk.setText("Jenis Kelamin Kosong!");
        panelBordeer1.add(label_jk, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 220, 20));

        label_warning_us.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_us.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_us.setText("Username Kosong!");
        panelBordeer1.add(label_warning_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 210, 20));

        label_success1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_success1.setForeground(new java.awt.Color(0, 204, 0));
        label_success1.setText("Kata Sandi Berhasil Diubah!");
        panelBordeer1.add(label_success1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 220, 40));

        label_success.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_success.setForeground(new java.awt.Color(0, 204, 0));
        label_success.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_success.setText("Berhasil Diubah!");
        panelBordeer1.add(label_success, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 390, 20));

        jLabel6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Username");
        panelBordeer1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, -1));

        jLabel8.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Alamat");
        panelBordeer1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 100, -1));

        panelBordeer7.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer7.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        panelBordeer7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 110));

        panelBordeer1.add(panelBordeer7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 390, 130));

        jLabel9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nomor Telepon");
        panelBordeer1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 100, -1));

        jLabel10.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Nama Lengkap");
        panelBordeer1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 100, -1));

        buttonGroup1.add(radioButtonCustom1);
        radioButtonCustom1.setText("Perempuan");
        radioButtonCustom1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        radioButtonCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonCustom1ActionPerformed(evt);
            }
        });
        panelBordeer1.add(radioButtonCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, 30));

        buttonGroup1.add(radioButtonCustom2);
        radioButtonCustom2.setText("Laki-Laki");
        radioButtonCustom2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        radioButtonCustom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonCustom2ActionPerformed(evt);
            }
        });
        panelBordeer1.add(radioButtonCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, 30));

        jLabel2.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Ubah Detail Pengguna");
        panelBordeer1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 390, 50));

        getContentPane().add(panelBordeer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 510));

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

    public void loadDataPenggunaa() {
        try {
            String sql = "SELECT pengguna.id_pengguna, pengguna.nama_pengguna, detail_pengguna.nama_lengkap, detail_pengguna.jenis_kelamin, "
                    + "detail_pengguna.no_telepon, detail_pengguna.alamat, pengguna.role\n"
                    + "FROM pengguna JOIN detail_pengguna ON pengguna.id_pengguna = detail_pengguna.id_pengguna\n"
                    + "WHERE pengguna.id_pengguna = '" + new com.fathan.form.pengguna.getPengguna().getId_pengguna() + "'";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                if (rs.getString("jenis_kelamin").equals("L")) {
                    radioButtonCustom2.setSelected(true);
                } else if (rs.getString("jenis_kelamin").equals("P")) {
                    radioButtonCustom1.setSelected(true);
                } else {
                    radioButtonCustom2.setSelected(false);
                    radioButtonCustom1.setSelected(false);
                }

                field_ip.setText(rs.getString("id_pengguna"));
                field_us.setText(rs.getString("nama_pengguna"));
                field_nl.setText(rs.getString("nama_lengkap"));
                field_nt.setText(rs.getString("no_telepon"));
                field_a.setText(rs.getString("alamat"));
                jLabel1.setText(rs.getString("role").toUpperCase());
            }
        } catch (Exception e) {

        }

    }
    private void field_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_ipActionPerformed

    private void field_ipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_ipKeyTyped
        char k = evt.getKeyChar();
        if (field_ip.isEditable()) {
            label_warning_ip.setVisible(false);
            if (field_ip.getText().length() >= 45) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_ip.setVisible(true);
                label_warning_ip.setText("Kode Produk tidak boleh melebihi 45 Karakter !");
            } else if (field_us.getText().length() >= 80) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_nl.setVisible(true);
                label_warning_nl.setText("Kode Produk tidak boleh melebihi 80 Karakter !");
                label_warning_ip.setVisible(false);
            } else {
                button2.setBackground(new Color(19, 179, 200));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(true);
                label_warning_ip.setVisible(false);
            }
        }


    }//GEN-LAST:event_field_ipKeyTyped

    private void field_usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_usActionPerformed
    public void cariUsername() {
        try {
            String sql = "SELECT pengguna.nama_pengguna FROM pengguna WHERE pengguna.nama_pengguna = '" + field_us.getText() + "'";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                label_warning_us1.setVisible(true);
                label_warning_us1.setText("Username Telah Terpakai !");
                label_warning_us1.setForeground(Color.red);
                username_similar = false;
            } else if (field_us.getText().length() >= 7) {
                label_warning_us1.setVisible(true);
                label_warning_us1.setText("Username Tersedia !");
                label_warning_us1.setForeground(Color.GREEN);
                username_similar = true;
            } else {
                label_warning_us1.setVisible(true);
                label_warning_us1.setText("Username Terlalu Pendek !");
                label_warning_us1.setForeground(Color.RED);
                username_similar = false;
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private void field_usKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_usKeyTyped
        char k = evt.getKeyChar();
        if (field_us.isEditable()) {
            label_warning_us.setVisible(false);
        }
        if (field_us.getText().length() >= 50) {
            evt.consume();
        }
        if (!(Character.isAlphabetic(k) || Character.isDigit(k) || Character.isJavaIdentifierPart(k) || k == KeyEvent.VK_BACK_SPACE || k == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_field_usKeyTyped

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        new com.fathan.form.pengguna.getPengguna().setId_pengguna(null);
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

        if (username_similar = false) {
            field_us.requestFocus();
        } else if (field_us.getText().equals("")) {
            label_warning_us.setVisible(true);
            label_warning_us.setText("Username Kosong!");
            field_us.getText();
        } else if (field_nl.getText().equals("")) {
            label_warning_nl.setVisible(true);
            field_nl.requestFocus();
        } else if (buttonGroup1.isSelected(null)) {
            label_jk.setVisible(true);
        } else {
            try {
                String update_pengguna = "UPDATE `pengguna` SET `nama_pengguna`='" + field_us.getText() + "'\n"
                        + "WHERE pengguna.id_pengguna = '" + field_ip.getText() + "'";
                String update_detail_pengguna = "UPDATE `detail_pengguna` SET "
                        + "`nama_lengkap`='" + field_nl.getText() + "',"
                        + "`jenis_kelamin`='" + buttonGroup1.getSelection().getActionCommand() + "',"
                        + "`no_telepon`='" + field_nt.getText() + "',"
                        + "`alamat`='" + field_a.getText() + "' \n"
                        + "WHERE detail_pengguna.id_pengguna = '" + new com.fathan.form.pengguna.getPengguna().getId_pengguna() + "';";
                java.sql.Connection con = (Connection) configdb.GetConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.Statement st1 = con.createStatement();
                st.execute(update_pengguna);
                st1.execute(update_detail_pengguna);
                label_success.setVisible(true);
                label_success.setText("Berhasil Diubah!");
            } catch (Exception e) {
                System.err.println("Tambah Data Pengguna : " + e.getMessage());
            }
        }

    }//GEN-LAST:event_button2ActionPerformed

    private void field_nlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nlActionPerformed

    private void field_nlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_nlKeyTyped
        char k = evt.getKeyChar();
        if (field_us.getText().length() >= 70) {
            evt.consume();
        }
        if (Character.isDigit(k)) {
            evt.consume();
        }
    }//GEN-LAST:event_field_nlKeyTyped

    private void field_usKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_usKeyReleased
        if (field_nl.getText().length() >= 50) {
            label_warning_us1.setVisible(false);
        } else {
            cariUsername();
        }

    }//GEN-LAST:event_field_usKeyReleased

    private void field_ntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_ntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_ntActionPerformed

    private void field_ntKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_ntKeyTyped
        char k = evt.getKeyChar();
        if (field_nt.getText().length() >= 13) {
            evt.consume();
        }
        if (!(Character.isDigit(k) || k == KeyEvent.VK_BACK_SPACE || k == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_field_ntKeyTyped

    private void field_aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_aKeyTyped
        if (field_a.getText().length() >= 120) {
            evt.consume();
        }
    }//GEN-LAST:event_field_aKeyTyped

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        new com.fathan.form.pengguna.getPengguna().setNama_pengguna(field_us.getText());
        new com.fathan.form.pengguna.option_reset(new com.fathan.form.pengguna.pengguna(), true).setVisible(true);

    }//GEN-LAST:event_button3ActionPerformed

    private void radioButtonCustom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonCustom2ActionPerformed
        label_jk.setVisible(false);
    }//GEN-LAST:event_radioButtonCustom2ActionPerformed

    private void radioButtonCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonCustom1ActionPerformed
        label_jk.setVisible(false);
    }//GEN-LAST:event_radioButtonCustom1ActionPerformed
    public void autoKode() {
        try {
            String sql = "SELECT MAX(RIGHT(produk.kode_produk,3)) AS nomor FROM produk WHERE produk.satuan = 'Jasa'";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.first() == false) {
                    field_ip.setText("JASA001");
                } else {
                    rs.last();
                    int autoId = rs.getInt(1) + 1;
                    String no = String.valueOf(autoId);
                    int noLong = no.length();
                    for (int i = 0; i < 3 - noLong; i++) {
                        no = "0" + no;
                    }
                    field_ip.setText("JASA" + no);
                    System.out.println(no);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

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
            java.util.logging.Logger.getLogger(Ubah_Pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ubah_Pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ubah_Pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ubah_Pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ubah_Pengguna dialog = new Ubah_Pengguna(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea field_a;
    private javax.swing.JTextField field_ip;
    private javax.swing.JTextField field_nl;
    private javax.swing.JTextField field_nt;
    private javax.swing.JTextField field_us;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_jk;
    private javax.swing.JLabel label_success;
    private javax.swing.JLabel label_success1;
    private javax.swing.JLabel label_warning_ip;
    private javax.swing.JLabel label_warning_nl;
    private javax.swing.JLabel label_warning_us;
    private javax.swing.JLabel label_warning_us1;
    private com.fathan.swing.PanelBordeer panelBordeer1;
    private com.fathan.swing.PanelBordeer panelBordeer2;
    private com.fathan.swing.PanelBordeer panelBordeer3;
    private com.fathan.swing.PanelBordeer panelBordeer4;
    private com.fathan.swing.PanelBordeer panelBordeer5;
    private com.fathan.swing.PanelBordeer panelBordeer7;
    private com.fathan.swing.RadioButtonCustom radioButtonCustom1;
    private com.fathan.swing.RadioButtonCustom radioButtonCustom2;
    // End of variables declaration//GEN-END:variables
}
