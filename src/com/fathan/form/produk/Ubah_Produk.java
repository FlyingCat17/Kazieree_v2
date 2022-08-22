/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.produk;

import com.fathan.db.configdb;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
        label_warning_hbhj.setVisible(false);
        label_warning_kp.setVisible(false);
        label_warning_hj.setVisible(false);
        label_warning_hb.setVisible(false);
        label_warning_np.setVisible(false);
        label_warning_s.setVisible(false);
        label_warning_hbhj.setVisible(false);
        System.out.println("Ambil Kategori : " + new com.fathan.form.produk.getdatabarang().getKategori());
        if (new com.fathan.form.produk.getdatabarang().getKategori() == true) {
            getData_produkJasa();
            System.out.println("Produk Jasa Get in");
        } else {
            getData_produk();
            System.out.println("Produk Barang Get in");
        }
    }

    public void getKategori() {
        try {
            String getCat = "SELECT * FROM kategori";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(getCat);
            while (rs.next()) {
                String kategori = rs.getString("nama_kategori");
                combobox1.addItem(kategori);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void getData_produk() {
        field_kp.setEnabled(true);
        field_s.setEnabled(true);
        field_hb.setEnabled(true);
        getKategori();
        combobox1.setSelectedIndex(0);
        try {
            String data = "SELECT * FROM produk WHERE kode_produk = '" + new com.fathan.form.produk.getdatabarang().getKode_produk() + "'";
            String data2 = "SELECT nama_kategori FROM kategori JOIN produk\n"
                    + "ON kategori.id_kategori = produk.id_kategori\n"
                    + "WHERE produk.kode_produk = '" + new com.fathan.form.produk.getdatabarang().getKode_produk() + "'; ";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement pst = con.createStatement();
            java.sql.Statement pst1 = con.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(data);
            java.sql.ResultSet rs2 = pst1.executeQuery(data2);
            if (rs.next()) {
                field_kp.setText(rs.getString("kode_produk"));
                field_np.setText(rs.getString("nama_produk"));
                field_s.setText(rs.getString("satuan"));
                field_hb.setText(rs.getString("harga_beli"));
                field_hj.setText(rs.getString("harga_jual"));
            }
            if (rs2.next()) {
                combobox1.setSelectedItem(rs2.getString("nama_kategori").toString());
            }

        } catch (Exception e) {
            System.err.println("Get Data Produk : " + e.getMessage());
        }
    }

    public void getData_produkJasa() {
        field_kp.setEnabled(false);
        field_s.setEnabled(false);
        field_hb.setEnabled(false);
        getKategori();
        combobox1.setSelectedIndex(1);
        try {
            String load = "SELECT produk.kode_produk, produk.nama_produk, kategori.nama_kategori, produk.satuan, produk.harga_beli, produk.harga_jual FROM produk JOIN kategori ON produk.id_kategori = kategori.id_kategori\n"
                    + "WHERE produk.kode_produk = '" + new com.fathan.form.produk.getdatabarang().getKode_produk() + "'";
            String data2 = "SELECT nama_kategori FROM kategori JOIN produk\n"
                    + "ON kategori.id_kategori = produk.id_kategori\n"
                    + "WHERE produk.kode_produk = '" + new com.fathan.form.produk.getdatabarang().getKode_produk() + "'; ";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement pst = con.createStatement();
            java.sql.Statement pst1 = con.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(load);
            java.sql.ResultSet rs2 = pst1.executeQuery(data2);
            if (rs.next()) {
                field_kp.setText(rs.getString("kode_produk"));
                field_np.setText(rs.getString("nama_produk"));
                field_s.setText(rs.getString("satuan"));
                field_hb.setText(rs.getString("harga_beli"));
                field_hj.setText(rs.getString("harga_jual"));

            }
            if (rs2.next()) {
                combobox1.setSelectedItem(rs2.getString("nama_kategori").toString());
            }
        } catch (Exception e) {
            System.err.println("Get Data Produk Jasa : " + e.getMessage());
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
        label_warning_hj = new javax.swing.JLabel();
        combobox1 = new com.fathan.swing.jcombobox.Combobox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelBordeer4 = new com.fathan.swing.PanelBordeer();
        field_s = new javax.swing.JTextField();
        panelBordeer5 = new com.fathan.swing.PanelBordeer();
        field_hb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelBordeer6 = new com.fathan.swing.PanelBordeer();
        field_hj = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        button1 = new com.fathan.form.produk.Button();
        button2 = new com.fathan.form.produk.Button();
        jLabel3 = new javax.swing.JLabel();
        label_warning_kp = new javax.swing.JLabel();
        label_warning_np = new javax.swing.JLabel();
        label_warning_s = new javax.swing.JLabel();
        label_warning_hbhj = new javax.swing.JLabel();
        label_warning_hb = new javax.swing.JLabel();
        label_warning_hj1 = new javax.swing.JLabel();
        label_warning_hj2 = new javax.swing.JLabel();

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
        jLabel1.setText("Ubah Produk");
        panelBordeer1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 500, 50));

        panelBordeer3.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer3.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_np.setBackground(new java.awt.Color(226, 226, 226));
        field_np.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_np.setBorder(null);
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
        field_kp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_kpActionPerformed(evt);
            }
        });
        field_kp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_kpKeyTyped(evt);
            }
        });
        panelBordeer2.add(field_kp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 410, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/produk/Barcode.png"))); // NOI18N
        panelBordeer2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 30, 20));

        panelBordeer1.add(panelBordeer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 490, 40));

        label_warning_hj.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_hj.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_hj.setText("Harga Jual Kosong!");
        panelBordeer1.add(label_warning_hj, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 130, 20));

        combobox1.setEnabled(false);
        combobox1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        combobox1.setLabeText("Kategori");
        combobox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox1ActionPerformed(evt);
            }
        });
        panelBordeer1.add(combobox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 270, 300, 40));

        jLabel5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Nama Produk");
        panelBordeer1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, -1));

        jLabel6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Satuan");
        panelBordeer1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 100, -1));

        panelBordeer4.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer4.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_s.setBackground(new java.awt.Color(226, 226, 226));
        field_s.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_s.setBorder(null);
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

        panelBordeer1.add(panelBordeer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 130, 40));

        panelBordeer5.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer5.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_hb.setBackground(new java.awt.Color(226, 226, 226));
        field_hb.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_hb.setBorder(null);
        field_hb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_hbActionPerformed(evt);
            }
        });
        field_hb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_hbKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_hbKeyTyped(evt);
            }
        });
        panelBordeer5.add(field_hb, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 120, 40));

        jLabel7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Rp");
        panelBordeer5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        panelBordeer1.add(panelBordeer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 170, 40));

        jLabel9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Harga Beli");
        panelBordeer1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 100, -1));

        jLabel10.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Harga Jual");
        panelBordeer1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 100, -1));

        panelBordeer6.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer6.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_hj.setBackground(new java.awt.Color(226, 226, 226));
        field_hj.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_hj.setBorder(null);
        field_hj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_hjActionPerformed(evt);
            }
        });
        field_hj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_hjKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_hjKeyTyped(evt);
            }
        });
        panelBordeer6.add(field_hj, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 120, 40));

        jLabel8.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Rp");
        panelBordeer6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        panelBordeer1.add(panelBordeer6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 170, 40));

        button1.setBackground(new java.awt.Color(255, 51, 51));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("BATAL");
        button1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 240, 40));

        button2.setBackground(new java.awt.Color(19, 179, 200));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("SIMPAN");
        button2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 240, 40));

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Kode Produk");
        panelBordeer1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 100, -1));

        label_warning_kp.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_kp.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_kp.setText("Kode Produk Kosong!");
        panelBordeer1.add(label_warning_kp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 370, 20));

        label_warning_np.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_np.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_np.setText("Nama Produk Kosong!");
        panelBordeer1.add(label_warning_np, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 300, 20));

        label_warning_s.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_s.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_s.setText("Satuan Kosong!");
        panelBordeer1.add(label_warning_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 130, 20));

        label_warning_hbhj.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_hbhj.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_hbhj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_warning_hbhj.setText("Harga Beli Lebih Besar Dari Harga Jual!");
        panelBordeer1.add(label_warning_hbhj, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 490, 20));

        label_warning_hb.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_hb.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_hb.setText("Harga Beli Kosong!");
        panelBordeer1.add(label_warning_hb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 130, 20));

        label_warning_hj1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_hj1.setForeground(new java.awt.Color(51, 51, 51));
        label_warning_hj1.setText("Tidak Ada");
        panelBordeer1.add(label_warning_hj1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 90, 30));

        label_warning_hj2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_hj2.setForeground(new java.awt.Color(51, 51, 51));
        label_warning_hj2.setText("ID Kategori :");
        panelBordeer1.add(label_warning_hj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 80, 30));

        getContentPane().add(panelBordeer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 520));

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


    private void field_kpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_kpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_kpActionPerformed

    private void field_kpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_kpKeyTyped
        char k = evt.getKeyChar();
        if (field_kp.isEditable()) {
            label_warning_kp.setVisible(false);
            if (field_kp.getText().length() >= 45) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_kp.setVisible(true);
                label_warning_kp.setText("Kode Produk tidak boleh melebihi 45 Karakter !");
            } else if (field_np.getText().length() >= 80) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_np.setVisible(true);
                label_warning_np.setText("Kode Produk tidak boleh melebihi 80 Karakter !");
                label_warning_kp.setVisible(false);
            } else {
                button2.setBackground(new Color(19, 179, 200));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(true);
                label_warning_kp.setVisible(false);
            }
        }


    }//GEN-LAST:event_field_kpKeyTyped

    private void field_npActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_npActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_npActionPerformed

    private void field_npKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_npKeyTyped
        if (field_np.isEditable()) {
            label_warning_np.setVisible(false);
            if (field_np.getText().length() >= 80) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_np.setVisible(true);
                label_warning_np.setText("Nama Produk tidak boleh melebihi 80 karakter");
            } else if (field_kp.getText().length() >= 45) {
                button2.setBackground(new Color(128, 128, 128));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(false);
                label_warning_np.setVisible(false);
            } else {
                button2.setBackground(new Color(19, 179, 200));
                button2.setForeground(new Color(255, 255, 255));
                button2.setEnabled(true);
                label_warning_np.setVisible(false);
            }
        }
    }//GEN-LAST:event_field_npKeyTyped

    private void field_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_sActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_sActionPerformed

    private void field_sKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_sKeyTyped
        if (field_s.isEditable()) {
            label_warning_s.setVisible(false);
        }
        if (field_s.getText().length() >= 6) {
            evt.consume();
        }

    }//GEN-LAST:event_field_sKeyTyped

    private void field_hbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_hbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_hbActionPerformed

    private void field_hbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_hbKeyTyped
        char k = evt.getKeyChar();
        if (field_hb.isEditable()) {
            label_warning_hb.setVisible(false);
            label_warning_hbhj.setVisible(false);
        }
        if (!(Character.isDigit(k) || k == KeyEvent.VK_BACK_SPACE || k == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (field_hb.getText().length() >= 12) {
            evt.consume();
        }
    }//GEN-LAST:event_field_hbKeyTyped

    private void field_hjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_hjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_hjActionPerformed

    private void field_hjKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_hjKeyTyped
        char k = evt.getKeyChar();
        if (field_hj.isEditable()) {
            label_warning_hj.setVisible(false);
            label_warning_hbhj.setVisible(false);
        }
        if (!(Character.isDigit(k) || k == KeyEvent.VK_BACK_SPACE || k == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (field_hj.getText().length() >= 12) {
            evt.consume();
        }
    }//GEN-LAST:event_field_hjKeyTyped

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        new com.fathan.form.produk.getdatabarang().setKode_produk(null);
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

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        Connection con;
        PreparedStatement pst, pst1;
        String kp, np, sp, hb, hj;
        kp = field_kp.getText().toString();
        np = field_np.getText().toString();
        sp = field_s.getText().toString();
        hb = field_hb.getText();
        hj = field_hj.getText();
        if (kp.isEmpty()) {
            label_warning_kp.setVisible(true);
            label_warning_kp.setText("Kode Produk Kosong!");
            field_kp.requestFocus();
        } else if (np.isEmpty()) {
            label_warning_np.setVisible(true);
            label_warning_np.setText("Nama Produk Kosong!");
            field_np.requestFocus();
        } else if (sp.isEmpty()) {
            label_warning_s.setVisible(true);
            field_s.requestFocus();
        } else if (hb.equals("")) {
            label_warning_hb.setVisible(true);
            field_hb.requestFocus();
        } else if (hj.equals("")) {
            label_warning_hj.setVisible(true);
            field_hj.requestFocus();
        } else if (Integer.parseInt(field_hb.getText()) > Integer.parseInt(field_hj.getText())) {
            label_warning_hbhj.setVisible(true);
            label_warning_hbhj.setForeground(Color.RED);
            label_warning_hbhj.setText("Harga Beli Lebih Besar Dari Harga Jual!");
            field_hb.requestFocus();
        } else {
            try {
                String UbahProduk = "UPDATE `produk` SET `kode_produk`='" + kp + "',`nama_produk`='" + np + "',`satuan`='" + sp + "',`harga_beli`='" + hb + "',`harga_jual`='" + hj + "' WHERE produk.kode_produk = '" + kp + "'";
                con = (Connection) configdb.GetConnection();
                pst = con.prepareStatement(UbahProduk);
                pst.execute();
                label_warning_hbhj.setVisible(true);
                label_warning_hbhj.setForeground(Color.GREEN);
                label_warning_hbhj.setText("Data Berhasil Diubah!");
                if (sp == "Jasa") {
                    getData_produkJasa();
                } else {
                    getData_produk();
                }

            } catch (Exception e) {
                label_warning_hbhj.setVisible(true);
                label_warning_hbhj.setForeground(Color.RED);
                label_warning_hbhj.setText("Data Gagal Ditambahkan!");
                System.err.println("Input Data : " + e.getMessage());
            }
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void combobox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox1ActionPerformed
        try {
            String sql = "SELECT id_kategori FROM kategori WHERE nama_kategori = '" + combobox1.getSelectedItem().toString() + "';";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                label_warning_hj1.setText(rs.getString("id_kategori"));
                System.out.println("Id Kategori yang didapat : " + rs.getString("id_kategori"));
            }
        } catch (Exception e) {
            System.err.println("Ambil Id Kategori : " + e.getMessage());
        }
        if (combobox1.getSelectedIndex() == 1) {
            System.out.println("INi jasa");
        }
    }//GEN-LAST:event_combobox1ActionPerformed

    private void field_hbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_hbKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            System.out.println("Disabled");
            evt.consume();
        }
    }//GEN-LAST:event_field_hbKeyPressed

    private void field_hjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_hjKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            System.out.println("Disabled");
            evt.consume();
        }
    }//GEN-LAST:event_field_hjKeyPressed

    private void field_sKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_sKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            System.out.println("Disabled Satuan");
            evt.consume();
        }
    }//GEN-LAST:event_field_sKeyPressed

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
    public com.fathan.swing.jcombobox.Combobox combobox1;
    public javax.swing.JTextField field_hb;
    public javax.swing.JTextField field_hj;
    public javax.swing.JTextField field_kp;
    public javax.swing.JTextField field_np;
    public javax.swing.JTextField field_s;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel label_warning_hb;
    private javax.swing.JLabel label_warning_hbhj;
    private javax.swing.JLabel label_warning_hj;
    private javax.swing.JLabel label_warning_hj1;
    private javax.swing.JLabel label_warning_hj2;
    private javax.swing.JLabel label_warning_kp;
    private javax.swing.JLabel label_warning_np;
    private javax.swing.JLabel label_warning_s;
    private com.fathan.swing.PanelBordeer panelBordeer1;
    private com.fathan.swing.PanelBordeer panelBordeer2;
    private com.fathan.swing.PanelBordeer panelBordeer3;
    private com.fathan.swing.PanelBordeer panelBordeer4;
    private com.fathan.swing.PanelBordeer panelBordeer5;
    private com.fathan.swing.PanelBordeer panelBordeer6;
    // End of variables declaration//GEN-END:variables
}
