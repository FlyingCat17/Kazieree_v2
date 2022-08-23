/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.transaksijual;

import com.fathan.form.beranda.*;
import com.fathan.main.*;
import com.fathan.db.configdb;
import java.awt.Color;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fathan
 */
public class transaksi_jual extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    com.fathan.user.user usr = new com.fathan.user.user();

    public transaksi_jual() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));

        panel_top.setBackground(new Color(255, 255, 255, 240));
        panel_top1.setBackground(new Color(255, 255, 255, 230));
        keranjang_jual();
        gen_kodeTransaksi();
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
            String sql = "SELECT *, SUM(temp_jual.qty * temp_jual.harga_jual) AS Total FROM `temp_jual` ";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
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
        } catch (SQLException e) {
            System.err.println("Get Keranjang Jual " + e.getMessage());
        }
    }

    protected void gen_kodeTransaksi() {
        DateFormat vblnth = new SimpleDateFormat("yyyyMMdd");
        String blnth = vblnth.format(Calendar.getInstance().getTime());
        System.out.println(blnth);

        DateFormat hari = new SimpleDateFormat("yyyy-MM-dd");
        String a = hari.format(Calendar.getInstance().getTime());
        try {
            String sql = "SELECT MAX(right(jual.kode_transaksi,6)) AS Kode_Pinjam "
                    + "FROM jual WHERE DATE(jual.tgl_transaksi) = '" + a + "'";
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
                    label_kodeTransaksi.setText("TJ/" + blnth + "/" + no);
                    System.out.println("TJ/" + blnth + "/" + no);
                    label_tanggalNow.setText(a);
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
        button2 = new com.fathan.form.transaksijual.Button();
        button1 = new com.fathan.form.transaksijual.Button();
        label_totalHarga = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_top = new com.fathan.swing.PanelRound();
        button4 = new com.fathan.form.kategori.Button();
        label_ucapan = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_tanggalNow = new javax.swing.JLabel();
        panelBorderGradient1 = new com.fathan.form.transaksijual.PanelBorderGradient();
        jLabel6 = new javax.swing.JLabel();
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
        button3.setText("Simpan & Bayar");
        button3.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        panel_top1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 290, 40));

        button2.setBackground(new java.awt.Color(255, 51, 51));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Hapus Produk");
        button2.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        panel_top1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, 290, 40));

        button1.setBackground(new java.awt.Color(19, 179, 200));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Tambah Produk");
        button1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
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
        label_ucapan.setText("Transaksi Jual");
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

        jLabel6.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Fathan Maulana");
        panelBorderGradient1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 330, 70));

        label_kodeTransaksi.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        label_kodeTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        label_kodeTransaksi.setText("TJ/20220823/194530/01");
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

    }//GEN-LAST:event_tableDark2MouseClicked

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
            java.util.logging.Logger.getLogger(transaksi_jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi_jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi_jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi_jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi_jual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fathan.form.transaksijual.Button button1;
    private com.fathan.form.transaksijual.Button button2;
    private com.fathan.form.transaksijual.Button button3;
    private com.fathan.form.kategori.Button button4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_kodeTransaksi;
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
