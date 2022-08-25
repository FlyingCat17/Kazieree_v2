/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.transaksibeli;

import com.fathan.db.configdb;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fathan
 */
public class transaksi_beli extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    com.fathan.user.user usr = new com.fathan.user.user();

    public transaksi_beli() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        panel_top.setBackground(new Color(255, 255, 255, 240));
        panel_top1.setBackground(new Color(255, 255, 255, 230));
        keranjang_jual();
        gen_kodeTransaksi();
        setJam();
        if (!(new com.fathan.user.user().getNama_lengkap() == null)) {
            this.label_namaLengkap.setText(new com.fathan.user.user().getNama_lengkap());
        } else {
            this.label_namaLengkap.setText("Guest");
        }

    }

    public void keranjang_jual() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Qty");
        model.addColumn("Harga Jual");
        model.addColumn("Total Harga");
        tableDark2.setModel(model);
        try {
            String sql = "SELECT *, SUM(temp_beli.qty * temp_beli.harga_jual) AS Total FROM `temp_beli` GROUP BY temp_beli.kode_produk ";
            String totalHarga = "SELECT SUM(harga_jual*qty) As Totall FROM temp_beli";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.Statement st1 = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            java.sql.ResultSet rs1 = st1.executeQuery(totalHarga);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                });
                tableDark2.setModel(model);

                tableDark2.getColumnModel().getColumn(0).setPreferredWidth(45);
                tableDark2.getColumnModel().getColumn(1).setPreferredWidth(400);
                tableDark2.getColumnModel().getColumn(2).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(3).setPreferredWidth(50);
                tableDark2.getColumnModel().getColumn(4).setPreferredWidth(50);

            }
            int total_harga;
            if (rs1.next()) {
                if (rs1.getString("Totall") == null) {
                    label_totalHarga.setText("Rp0");
                } else {
                    label_totalHarga.setText("Rp" + rs1.getString("Totall"));
                    total_harga = Integer.parseInt(rs1.getString("Totall"));
                    System.out.println("Total Harga Saat ini = " + total_harga);
                }
            }
        } catch (SQLException e) {
            System.err.println("Get Keranjang Jual " + e.getMessage());
        }
    }

    public void setJam() {
        ActionListener taskPerformer = new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                String nol_jam = "", nol_menit = "", nol_detik = "";
                java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Date dateTime = new java.util.Date();
                int nilai_jam = dateTime.getHours();
                int nilai_menit = dateTime.getMinutes();
                int nilai_detik = dateTime.getSeconds();

                if (nilai_jam <= 9) {
                    nol_jam = "0";
                }
                if (nilai_menit <= 9) {
                    nol_menit = "0";
                }
                if (nilai_detik <= 9) {
                    nol_detik = "0";
                }

                String waktu = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);
                String tgl = kal.format(dateTime);

                label_tanggalNow.setText(tgl + " " + waktu + ":" + menit + ":" + detik + "");
            }
        };
        new Timer(1000, taskPerformer).start();
    }

    public void setTanggal() {
        java.util.Date skrg = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("dd/MM/yyyy");
//        jLabel1.setText(kal.format(skrg));
    }

    protected void gen_kodeTransaksi() {
        DateFormat vblnth = new SimpleDateFormat("yyyyMMdd");
        String blnth = vblnth.format(Calendar.getInstance().getTime());
        System.out.println(blnth);

        DateFormat hari = new SimpleDateFormat("yyyy-MM-dd");
        String a = hari.format(Calendar.getInstance().getTime());
        try {
            String sql = "SELECT MAX(right(beli.kode_transaksi,6)) AS Kode_Pinjam "
                    + "FROM beli WHERE DATE(beli.tgl_transaksi) = '" + a + "'";
            java.sql.Connection con = (java.sql.Connection) configdb.GetConnection();
            java.sql.Statement pst = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                if (rs.last()) {
                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 6 - NomorJual; j++) {
                        no = "0" + no;
                    }
//                    txt_idTransaksii.setText("TJ/" + blnth + "/" + no);
                    label_kodeTransaksi.setText("TB/" + blnth + "/" + no);
                    System.out.println("TB/" + blnth + "/" + no);
//                    label_tanggalNow.setText(a);
                    new com.fathan.form.transaksibeli.getKode_Produk().setKode_transaksi("TB/" + blnth + "/" + no);
                }
            }
        } catch (Exception e) {
            System.err.println("ERROR " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBordeer1 = new com.fathan.swing.PanelBordeer();
        panel_top1 = new com.fathan.swing.PanelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDark2 = new com.fathan.swing.jtable.TableDark(){
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };
        button3 = new com.fathan.form.transaksijual.Button();
        button1 = new com.fathan.form.transaksijual.Button();
        label_totalHarga = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button5 = new com.fathan.form.transaksijual.Button();
        button6 = new com.fathan.form.transaksijual.Button();
        button7 = new com.fathan.form.transaksijual.Button();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_top = new com.fathan.swing.PanelRound();
        button4 = new com.fathan.form.kategori.Button();
        label_ucapan = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_tanggalNow = new javax.swing.JLabel();
        panelBorderGradient1 = new com.fathan.form.transaksijual.PanelBorderGradient();
        label_namaLengkap = new javax.swing.JLabel();
        label_kodeTransaksi = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1294, 679));
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBordeer1.setForeground(new java.awt.Color(247, 247, 247));
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

        jScrollPane2.setBorder(null);

        tableDark2.setForeground(new java.awt.Color(51, 51, 51));
        tableDark2.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDark2.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tableDark2.setGridColor(new java.awt.Color(255, 255, 255));
        tableDark2.getTableHeader().setResizingAllowed(false);
        tableDark2.getTableHeader().setReorderingAllowed(false);
        tableDark2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDark2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableDark2);

        panel_top1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 840, 390));

        button3.setBackground(new java.awt.Color(0, 204, 51));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Simpan");
        button3.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        panel_top1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 290, 40));

        button1.setBackground(new java.awt.Color(19, 179, 200));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Tambah Produk");
        button1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panel_top1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 290, 40));

        label_totalHarga.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 30)); // NOI18N
        label_totalHarga.setForeground(new java.awt.Color(51, 51, 51));
        label_totalHarga.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_totalHarga.setText("Rp0");
        panel_top1.add(label_totalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 350, 310, 70));

        jLabel2.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Total Harga");
        panel_top1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 310, 170, -1));

        button5.setBackground(new java.awt.Color(0, 198, 148));
        button5.setForeground(new java.awt.Color(255, 255, 255));
        button5.setText("Ubah");
        button5.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        panel_top1.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, 290, 40));

        button6.setBackground(new java.awt.Color(255, 169, 43));
        button6.setForeground(new java.awt.Color(255, 255, 255));
        button6.setText("Pilih Supplier");
        button6.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        panel_top1.add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 290, 40));

        button7.setBackground(new java.awt.Color(0, 204, 51));
        button7.setForeground(new java.awt.Color(255, 255, 255));
        button7.setText("Simpan");
        button7.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        panel_top1.add(button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 290, 40));

        jLabel3.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("-");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panel_top1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 260, 220, 40));

        jLabel4.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 12)); // NOI18N
        jLabel4.setText("Supplier :");
        panel_top1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 280, 60, 20));

        panelBordeer1.add(panel_top1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 1220, 440));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/beranda/bg_beranda.png"))); // NOI18N
        panelBordeer1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, 430));

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

        button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/kategori/back.png"))); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        panel_top.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 70));

        label_ucapan.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 22)); // NOI18N
        label_ucapan.setForeground(new java.awt.Color(107, 107, 107));
        label_ucapan.setText("Transaksi Beli");
        panel_top.add(label_ucapan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 310, 70));

        jLabel7.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(107, 107, 107));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Tanggal");
        panel_top.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 300, 20));

        label_tanggalNow.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        label_tanggalNow.setForeground(new java.awt.Color(107, 107, 107));
        label_tanggalNow.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_tanggalNow.setText("2022-08-23");
        panel_top.add(label_tanggalNow, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 300, 30));

        panelBordeer1.add(panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1220, 70));

        panelBorderGradient1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_namaLengkap.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        label_namaLengkap.setForeground(new java.awt.Color(255, 255, 255));
        label_namaLengkap.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_namaLengkap.setText("Guest");
        panelBorderGradient1.add(label_namaLengkap, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 330, 70));

        label_kodeTransaksi.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        label_kodeTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        label_kodeTransaksi.setText("TB/20220823/194530/01");
        panelBorderGradient1.add(label_kodeTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 300, 30));

        jLabel5.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kode Transaksi");
        panelBorderGradient1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 300, 20));

        panelBordeer1.add(panelBorderGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1220, 70));

        getContentPane().add(panelBordeer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 680));

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
                Thread.sleep(1);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void panel_topMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_topMouseClicked

    }//GEN-LAST:event_panel_topMouseClicked

    private void panel_top1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_top1MouseClicked

    }//GEN-LAST:event_panel_top1MouseClicked

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
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
        new com.fathan.form.beranda.beranda().setVisible(true);
    }//GEN-LAST:event_button4ActionPerformed

    private void tableDark2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDark2MouseClicked
        if (evt.getClickCount() == 1) {
            int i = tableDark2.rowAtPoint(evt.getPoint());
            new com.fathan.form.transaksibeli.getKode_Produk().setKode_produk(tableDark2.getValueAt(i, 0).toString());
            System.out.println("id produk : " + new com.fathan.form.transaksibeli.getKode_Produk().getKode_produk());
        }
    }//GEN-LAST:event_tableDark2MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        new com.fathan.form.transaksibeli.Tambah_Produk(this, true).setVisible(true);
        keranjang_jual();
    }//GEN-LAST:event_button1ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        if (new com.fathan.form.transaksibeli.getKode_Produk().getKode_produk() == null) {
            new com.fathan.form.transaksibeli.option_kodebarangkosong(this, true).setVisible(true);
        } else {
            new com.fathan.form.transaksibeli.Ubah_Produk(this, true).setVisible(true);
            keranjang_jual();
        }
    }//GEN-LAST:event_button5ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        if (tableDark2.getRowCount() <= 0) {
            new com.fathan.form.transaksibeli.option_produkKosong(this, true).setVisible(true);
            keranjang_jual();
        } else if (jLabel3.getText().equals("-")) {
            new com.fathan.form.transaksibeli.option_supplierKosong(this, true).setVisible(true);
            keranjang_jual();
        } else {
            System.out.println("Pembayaran pada Kode Transaksi : " + new com.fathan.form.transaksibeli.getKode_Produk().getKode_transaksi());
            new com.fathan.form.transaksibeli.Bayar(this, true).setVisible(true);
            keranjang_jual();
            gen_kodeTransaksi();
        }
    }//GEN-LAST:event_button3ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        new com.fathan.form.transaksibeli.Cari_Supplier(this, true).setVisible(true);
        jLabel3.setText(new com.fathan.form.transaksibeli.getKode_Produk().getNama_supplier());
        System.out.println(new com.fathan.form.transaksibeli.getKode_Produk().getNama_supplier() + " " + new com.fathan.form.transaksibeli.getKode_Produk().getKode_supplier());
        keranjang_jual();
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button7ActionPerformed

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
            java.util.logging.Logger.getLogger(transaksi_beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi_beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi_beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi_beli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi_beli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fathan.form.transaksijual.Button button1;
    private com.fathan.form.transaksijual.Button button3;
    private com.fathan.form.kategori.Button button4;
    private com.fathan.form.transaksijual.Button button5;
    private com.fathan.form.transaksijual.Button button6;
    private com.fathan.form.transaksijual.Button button7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_kodeTransaksi;
    private javax.swing.JLabel label_namaLengkap;
    private javax.swing.JLabel label_tanggalNow;
    private javax.swing.JLabel label_totalHarga;
    public javax.swing.JLabel label_ucapan;
    private com.fathan.swing.PanelBordeer panelBordeer1;
    private com.fathan.form.transaksijual.PanelBorderGradient panelBorderGradient1;
    private com.fathan.swing.PanelRound panel_top;
    private com.fathan.swing.PanelRound panel_top1;
    private com.fathan.swing.jtable.TableDark tableDark2;
    // End of variables declaration//GEN-END:variables
}
