/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.beranda;

import com.fathan.db.configdb;
import java.awt.Color;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Fathan
 */
public class beranda extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    com.fathan.user.user usr = new com.fathan.user.user();

    public beranda() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        panel_top.setBackground(new Color(255, 255, 255, 240));
        getJumlahPenjualan();
        getJumlahPembelian();
        getJumlahPendapatan();
        if (usr.getNama() == null) {
            label_ucapan.setText("Selamat Datang, fulan");
            label_nama.setText("nothing else");
        } else {
            label_ucapan.setText("Selamat Datang, " + usr.getNama());
            label_nama.setText(usr.getNama_lengkap());
            label_nama1.setText(usr.getRole().toUpperCase());
        }

    }

    public void getJumlahPembelian() {
        try {
            SimpleDateFormat yearMonth = new SimpleDateFormat("yyyyMM");
            SimpleDateFormat day = new SimpleDateFormat("dd");
            Date a = new Date();
            String sql = "SELECT COUNT(beli.kode_transaksi) AS jumlah FROM beli\n"
                    + "WHERE EXTRACT(YEAR_MONTH FROM tgl_transaksi) = '" + yearMonth.format(a) + "'\n"
                    + "AND EXTRACT(DAY FROM tgl_transaksi) = '" + day.format(a) + "'";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                label_jumlahBeli.setText(rs.getString("jumlah"));
            } else {
                label_jumlahBeli.setText("0");
            }
        } catch (Exception e) {
            System.err.println("Jumlah Pembelian : " + e.getMessage());
            label_jumlahBeli.setText("0");
        }
    }

    public void getJumlahPenjualan() {
        try {
            SimpleDateFormat yearMonth = new SimpleDateFormat("yyyyMM");
            SimpleDateFormat day = new SimpleDateFormat("dd");
            Date a = new Date();
            String sql = "SELECT COUNT(jual.kode_transaksi) AS jumlah FROM jual\n"
                    + "WHERE EXTRACT(YEAR_MONTH FROM tgl_transaksi) = '" + yearMonth.format(a) + "'\n"
                    + "AND EXTRACT(DAY FROM tgl_transaksi) = '" + day.format(a) + "'";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                label_jumlahJual.setText(rs.getString("jumlah"));
            } else {
                label_jumlahJual.setText("0");
            }
        } catch (Exception e) {
            System.err.println("Jumlah Penjualan : " + e.getMessage());
            label_jumlahJual.setText("0");
        }
    }

    public void getJumlahPendapatan() {
        try {
            SimpleDateFormat yearMonth = new SimpleDateFormat("yyyyMM");
            SimpleDateFormat day = new SimpleDateFormat("dd");
            Date a = new Date();
            String sql = "SELECT SUM(jual.total_harga) AS pendapatan FROM jual\n"
                    + "WHERE EXTRACT(YEAR_MONTH FROM tgl_transaksi) = '" + yearMonth.format(a) + "'\n"
                    + "AND EXTRACT(DAY FROM tgl_transaksi) = '" + day.format(a) + "'";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                if (!(rs.getString("pendapatan").equals("null"))) {
                    label_jumlahPendapatan.setText("Rp" + rs.getString("pendapatan"));
                } else {
                    label_jumlahPendapatan.setText("Rp0");
                }

            } else {
                label_jumlahPendapatan.setText("Rp0");
            }
        } catch (Exception e) {
            System.err.println("Jumlah Pendapatan : " + e.getMessage());
            label_jumlahPendapatan.setText("Rp0");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBordeer1 = new com.fathan.swing.PanelBordeer();
        panel_top1 = new com.fathan.swing.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelShadow10 = new main.PanelShadow();
        button6 = new com.fathan.form.beranda.Button();
        panelShadow4 = new main.PanelShadow();
        button1 = new com.fathan.form.beranda.Button();
        panelShadow7 = new main.PanelShadow();
        button4 = new com.fathan.form.beranda.Button();
        panelShadow6 = new main.PanelShadow();
        button7 = new com.fathan.form.beranda.Button();
        panelShadow3 = new main.PanelShadow();
        button8 = new com.fathan.form.beranda.Button();
        panelShadow2 = new main.PanelShadow();
        button5 = new com.fathan.form.beranda.Button();
        panelShadow1 = new main.PanelShadow();
        button3 = new com.fathan.form.beranda.Button();
        panelShadow5 = new main.PanelShadow();
        label_jumlahJual = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelShadow8 = new main.PanelShadow();
        jLabel6 = new javax.swing.JLabel();
        label_jumlahBeli = new javax.swing.JLabel();
        panelShadow9 = new main.PanelShadow();
        jLabel5 = new javax.swing.JLabel();
        label_jumlahPendapatan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_top = new com.fathan.swing.PanelRound();
        label_nama1 = new javax.swing.JLabel();
        label_nama = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        label_ucapan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1140, 680));
        setMinimumSize(new java.awt.Dimension(1140, 680));
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBordeer1.setForeground(new java.awt.Color(247, 247, 247));
        panelBordeer1.setPreferredSize(new java.awt.Dimension(1140, 680));
        panelBordeer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_top1.setBackground(new java.awt.Color(255, 255, 255));
        panel_top1.setRoundBottomLeft(15);
        panel_top1.setRoundBottomRight(15);
        panel_top1.setRoundTopLeft(15);
        panel_top1.setRoundTopRight(15);
        panel_top1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_top1MouseClicked(evt);
            }
        });
        panel_top1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Daftar Menu");
        panel_top1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 475, 60));

        panelShadow10.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button6.setForeground(new java.awt.Color(19, 179, 200));
        button6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/beranda/icon_pengeluaran.png"))); // NOI18N
        button6.setText("Pengeluaran");
        button6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        button6.setIconTextGap(10);
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        panelShadow10.add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        panel_top1.add(panelShadow10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 230, 50));

        panelShadow4.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setForeground(new java.awt.Color(19, 179, 200));
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/beranda/icon_kurangJual.png"))); // NOI18N
        button1.setText("Transaksi Jual");
        button1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        button1.setIconTextGap(7);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelShadow4.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        panel_top1.add(panelShadow4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 230, 50));

        panelShadow7.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button4.setForeground(new java.awt.Color(19, 179, 200));
        button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/beranda/icon_people.png"))); // NOI18N
        button4.setText("Pengguna");
        button4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        button4.setIconTextGap(10);
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        panelShadow7.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        panel_top1.add(panelShadow7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 230, 50));

        panelShadow6.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button7.setForeground(new java.awt.Color(19, 179, 200));
        button7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/beranda/icon_supplier.png"))); // NOI18N
        button7.setText("Supplier");
        button7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        button7.setIconTextGap(8);
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        panelShadow6.add(button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        panel_top1.add(panelShadow6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 230, 50));

        panelShadow3.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button8.setForeground(new java.awt.Color(19, 179, 200));
        button8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/beranda/icon_tambahBeli.png"))); // NOI18N
        button8.setText("Transaksi Beli");
        button8.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        button8.setIconTextGap(7);
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });
        panelShadow3.add(button8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        panel_top1.add(panelShadow3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 230, 50));

        panelShadow2.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button5.setForeground(new java.awt.Color(19, 179, 200));
        button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/beranda/icon_report.png"))); // NOI18N
        button5.setText("Laporan");
        button5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        button5.setIconTextGap(10);
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        panelShadow2.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        panel_top1.add(panelShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 230, 50));

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button3.setForeground(new java.awt.Color(19, 179, 200));
        button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/beranda/icon_produk.png"))); // NOI18N
        button3.setText("Produk");
        button3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        button3.setIconTextGap(12);
        button3.setOpaque(true);
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        panelShadow1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        panel_top1.add(panelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 230, 50));

        panelShadow5.setBackground(new java.awt.Color(19, 179, 200));
        panelShadow5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_jumlahJual.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        label_jumlahJual.setForeground(new java.awt.Color(255, 255, 255));
        label_jumlahJual.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_jumlahJual.setText("0");
        panelShadow5.add(label_jumlahJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 210, 40));

        jLabel3.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Transaksi Penjualan");
        panelShadow5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        panel_top1.add(panelShadow5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 320, 160));

        panelShadow8.setBackground(new java.awt.Color(255, 51, 102));
        panelShadow8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Transaksi Pembelian");
        panelShadow8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        label_jumlahBeli.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        label_jumlahBeli.setForeground(new java.awt.Color(255, 255, 255));
        label_jumlahBeli.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_jumlahBeli.setText("0");
        panelShadow8.add(label_jumlahBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 210, 40));

        panel_top1.add(panelShadow8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 320, 160));

        panelShadow9.setBackground(new java.awt.Color(0, 204, 51));
        panelShadow9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pendapatan Penjualan");
        panelShadow9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 270, 30));

        label_jumlahPendapatan.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 30)); // NOI18N
        label_jumlahPendapatan.setForeground(new java.awt.Color(255, 255, 255));
        label_jumlahPendapatan.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_jumlahPendapatan.setText("Rp0");
        panelShadow9.add(label_jumlahPendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 210, 40));

        panel_top1.add(panelShadow9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 320, 160));

        panelBordeer1.add(panel_top1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 1060, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/beranda/bg_beranda.png"))); // NOI18N
        panelBordeer1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 1140, 450));

        panel_top.setBackground(new java.awt.Color(255, 255, 255));
        panel_top.setRoundBottomLeft(15);
        panel_top.setRoundBottomRight(15);
        panel_top.setRoundTopLeft(15);
        panel_top.setRoundTopRight(15);
        panel_top.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_topMouseClicked(evt);
            }
        });
        panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_nama1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        label_nama1.setForeground(new java.awt.Color(51, 51, 51));
        label_nama1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_nama1.setText("label_role");
        panel_top.add(label_nama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 250, 40));

        label_nama.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        label_nama.setForeground(new java.awt.Color(51, 51, 51));
        label_nama.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_nama.setText("label_nama");
        label_nama.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panel_top.add(label_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 250, 40));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/beranda/icon_person.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        panel_top.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 70, 70));

        label_ucapan.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 22)); // NOI18N
        label_ucapan.setForeground(new java.awt.Color(51, 51, 51));
        label_ucapan.setText("Selamat Datang, fulan!");
        panel_top.add(label_ucapan, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 0, 475, 70));

        panelBordeer1.add(panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1060, 70));

        getContentPane().add(panelBordeer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(1);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        for (double i = 1.0; i >= 0.1; i = i - 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(1);
                if (this.getOpacity() <= 0.25) {
                    this.dispose();
                }

            } catch (Exception e) {
            }

        }
        new com.fathan.form.produk.produk().setVisible(true);
    }//GEN-LAST:event_button3ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

        new com.fathan.form.about.lainnya(this, true).setVisible(true);
        if (new com.fathan.form.about.logout().yn == true) {
            new com.fathan.form.about.logout().setLog_out(false);
            for (double i = 1.0; i >= 0.1; i = i - 0.25) {
                String val = i + "";
                float f = Float.valueOf(val);
                this.setOpacity(f);
                try {
                    Thread.sleep(1);
                    if (this.getOpacity() <= 0.25) {
                        this.dispose();
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }

    }//GEN-LAST:event_jLabel4MouseClicked

    private void panel_topMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_topMouseClicked

    }//GEN-LAST:event_panel_topMouseClicked

    private void panel_top1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_top1MouseClicked

    }//GEN-LAST:event_panel_top1MouseClicked

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        for (double i = 1.0; i >= 0.1; i = i - 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(1);
                if (this.getOpacity() <= 0.25) {
                    this.dispose();
                }

            } catch (Exception e) {
            }

        }
        new com.fathan.form.supplier.supplier().setVisible(true);
    }//GEN-LAST:event_button7ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        for (double i = 1.0; i >= 0.1; i = i - 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(1);
                if (this.getOpacity() <= 0.25) {
                    this.dispose();
                }

            } catch (Exception e) {
            }

        }
        new com.fathan.form.transaksijual.transaksi_jual().setVisible(true);
    }//GEN-LAST:event_button1ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        for (double i = 1.0; i >= 0.1; i = i - 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            System.out.println(f);
            try {
                Thread.sleep(1);
                if (this.getOpacity() <= 0.25) {
                    this.dispose();
                }

            } catch (Exception e) {
            }

        }
        new com.fathan.form.transaksibeli.transaksi_beli().setVisible(true);
    }//GEN-LAST:event_button8ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        for (double i = 1.0; i >= 0.1; i = i - 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(1);
                if (this.getOpacity() <= 0.25) {
                    this.dispose();
                }

            } catch (Exception e) {
            }

        }
        new com.fathan.form.pengguna.pengguna().setVisible(true);
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        for (double i = 1.0; i >= 0.1; i = i - 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(1);
                if (this.getOpacity() <= 0.25) {
                    this.dispose();
                }

            } catch (Exception e) {
            }

        }
        new com.fathan.form.laporan.laporan().setVisible(true);
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed

        new com.fathan.form.pengeluaran.TambahPengeluaran(this, true).setVisible(true);
    }//GEN-LAST:event_button6ActionPerformed

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
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new beranda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fathan.form.beranda.Button button1;
    private com.fathan.form.beranda.Button button3;
    private com.fathan.form.beranda.Button button4;
    private com.fathan.form.beranda.Button button5;
    private com.fathan.form.beranda.Button button6;
    private com.fathan.form.beranda.Button button7;
    private com.fathan.form.beranda.Button button8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel label_jumlahBeli;
    private javax.swing.JLabel label_jumlahJual;
    private javax.swing.JLabel label_jumlahPendapatan;
    public javax.swing.JLabel label_nama;
    public javax.swing.JLabel label_nama1;
    public javax.swing.JLabel label_ucapan;
    private com.fathan.swing.PanelBordeer panelBordeer1;
    private main.PanelShadow panelShadow1;
    private main.PanelShadow panelShadow10;
    private main.PanelShadow panelShadow2;
    private main.PanelShadow panelShadow3;
    private main.PanelShadow panelShadow4;
    private main.PanelShadow panelShadow5;
    private main.PanelShadow panelShadow6;
    private main.PanelShadow panelShadow7;
    private main.PanelShadow panelShadow8;
    private main.PanelShadow panelShadow9;
    private com.fathan.swing.PanelRound panel_top;
    private com.fathan.swing.PanelRound panel_top1;
    // End of variables declaration//GEN-END:variables
}
