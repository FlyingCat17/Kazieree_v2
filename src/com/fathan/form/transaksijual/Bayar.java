/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.transaksijual;

import com.fathan.db.configdb;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fathan
 */
public class Bayar extends javax.swing.JDialog {

    /**
     * Creates new form Tambah_Produk
     */
    public Bayar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        field_kodeTransaksi.setText(new com.fathan.form.transaksijual.getKode_Produk().getKode_transaksi());
        loadDetailData();
        label_warningNoMoney.setVisible(false);
    }

    int total_hargaa;

    public void loadDetailData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Qty");
        model.addColumn("Harga Jual");
        model.addColumn("Total Harga");
        tableDark2.setModel(model);
        try {
            String sql = "SELECT temp_jual.kode_produk, temp_jual.nama_produk, temp_jual.qty, temp_jual.harga_jual, SUM(temp_jual.qty*temp_jual.harga_jual) AS Total_Harga FROM temp_jual\n"
                    + "JOIN produk\n"
                    + "ON temp_jual.kode_produk = produk.kode_produk\n"
                    + "GROUP BY temp_jual.kode_produk";
            String totalHarga = "SELECT SUM(harga_jual*qty) As Totall FROM temp_jual";
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
            }
            if (rs1.next()) {
                label_totalHarga.setText("Rp" + rs1.getString("Totall"));
                total_hargaa = rs1.getInt(1);
                System.out.println("Total Harga : " + total_hargaa);
            }
        } catch (Exception e) {
            System.err.println("Detail Info : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBordeer1 = new com.fathan.swing.PanelBordeer();
        jLabel1 = new javax.swing.JLabel();
        panelBordeer5 = new com.fathan.swing.PanelBordeer();
        field_hp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        button1 = new com.fathan.form.produk.Button();
        button2 = new com.fathan.form.produk.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDark2 = new com.fathan.swing.jtable.TableDark(){
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };
        panelBorderGradient31 = new com.fathan.swing.PanelBorderGradient3();
        jLabel3 = new javax.swing.JLabel();
        label_totalHarga = new javax.swing.JLabel();
        label_warningNoMoney = new javax.swing.JLabel();
        field_kodeTransaksi = new javax.swing.JLabel();
        field_kemabalian = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("-");
        panelBordeer1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 250, 20));

        panelBordeer5.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer5.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_hp.setBackground(new java.awt.Color(226, 226, 226));
        field_hp.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_hp.setBorder(null);
        field_hp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_hpActionPerformed(evt);
            }
        });
        field_hp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_hpKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                field_hpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_hpKeyTyped(evt);
            }
        });
        panelBordeer5.add(field_hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 130, 40));

        jLabel7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Rp");
        panelBordeer5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        panelBordeer1.add(panelBordeer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 190, 40));

        jLabel9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Kembalian :");
        panelBordeer1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 80, 20));

        button1.setBackground(new java.awt.Color(255, 51, 51));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("BATAL");
        button1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 240, 40));

        button2.setBackground(new java.awt.Color(102, 102, 102));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("SIMPAN");
        button2.setEnabled(false);
        button2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, 240, 40));

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

        panelBordeer1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 490, 190));

        panelBorderGradient31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Harga");
        panelBorderGradient31.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 30));

        label_totalHarga.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 30)); // NOI18N
        label_totalHarga.setForeground(new java.awt.Color(255, 255, 255));
        label_totalHarga.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_totalHarga.setText("Rp0");
        panelBorderGradient31.add(label_totalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 330, 50));

        panelBordeer1.add(panelBorderGradient31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 490, 90));

        label_warningNoMoney.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warningNoMoney.setForeground(new java.awt.Color(255, 51, 51));
        label_warningNoMoney.setText("Harap isi nominal pembayaran !");
        panelBordeer1.add(label_warningNoMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 200, -1));

        field_kodeTransaksi.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        field_kodeTransaksi.setForeground(new java.awt.Color(102, 102, 102));
        field_kodeTransaksi.setText("-");
        panelBordeer1.add(field_kodeTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 240, -1));

        field_kemabalian.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        field_kemabalian.setForeground(new java.awt.Color(51, 51, 51));
        field_kemabalian.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        field_kemabalian.setText("0");
        field_kemabalian.setToolTipText("");
        field_kemabalian.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelBordeer1.add(field_kemabalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 210, 50));

        jLabel5.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Detail Pembayaran");
        panelBordeer1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 260, 50));

        jLabel11.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Nominal Bayar");
        panelBordeer1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 170, -1));

        getContentPane().add(panelBordeer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 600));

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

    public void kembalian() {
        if (!(field_hp.getText().equals(""))) {
            int sub = total_hargaa;
            int disk = Integer.parseInt(field_hp.getText());
            int ttl = disk - sub;
            if (!(ttl < 0)) {
                field_kemabalian.setText("Rp" + Integer.toString(ttl));
                button2.setEnabled(true);
                button2.setBackground(new Color(19, 179, 200));
                button2.setForeground(Color.WHITE);
            } else {
                field_kemabalian.setText("0");
                button2.setEnabled(false);
                button2.setBackground(new Color(102, 102, 102));
                button2.setForeground(Color.WHITE);
            }
        } else {
            field_kemabalian.setText("0");
        }
    }
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

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
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
        Date todayNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DefaultTableModel model = (DefaultTableModel) tableDark2.getModel();
        int jumlah_baris = tableDark2.getRowCount();
        System.out.println("Jumlah Baris yang akan diinput : " + jumlah_baris);
        try {
            String sql = "INSERT INTO `jual`(`kode_transaksi`, `tgl_transaksi`, `id_pengguna`, `id_cashbox`, `total_harga`, `nominal_bayar`) "
                    + "VALUES ('" + field_kodeTransaksi.getText() + "','" + sdf.format(todayNow).toString() + "','" + new com.fathan.user.user().getId_pengguna() + "','1','" + total_hargaa + "','" + field_hp.getText() + "')";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            st.execute(sql);
            try {
                for (int i = 0; i < jumlah_baris; i++) {
                    String kode_produk = (String) model.getValueAt(i, 0).toString();
                    String nama_produk = (String) model.getValueAt(i, 1).toString();
                    String qty = (String) model.getValueAt(i, 2).toString();
                    String harga_jual = (String) model.getValueAt(i, 3).toString();
                    String hargaKaliQty = (String) model.getValueAt(i, 4).toString();
                    String sqll = "INSERT INTO `detail_jual`(`kode_transaksi`, `kode_produk`, `nama_produk`, `harga_jual`, `qty`, `total_harga`) "
                            + "VALUES ('" + field_kodeTransaksi.getText() + "','" + kode_produk + "','" + nama_produk + "','" + harga_jual + "','" + qty + "','" + hargaKaliQty + "')";
                    java.sql.Statement st1 = con.createStatement();
                    st1.execute(sqll);
                    
                }
                JOptionPane.showMessageDialog(this, "Sudah berhasil Tersimpan !");
                try {
                    String sqlll = "TRUNCATE TABLE temp_jual";
                    java.sql.Statement st2 = con.createStatement();
                    st2.execute(sqlll);
                    JOptionPane.showMessageDialog(this, "Keranjang Berhasil di reset");
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
                } catch (Exception exx) {
                    System.err.println("Empty of Keranjang Table : " + exx.getMessage());
                }
            } catch (Exception ex) {
                System.err.println("Input at Detail Jual : " + ex.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Input at Jual : " + e.getMessage());
        }
    }//GEN-LAST:event_button2ActionPerformed


    private void field_hpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_hpKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            System.out.println("Disabled");
            evt.consume();
        }
    }//GEN-LAST:event_field_hpKeyPressed

    private void tableDark2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDark2MouseClicked
        if (evt.getClickCount() == 1) {

        }
    }//GEN-LAST:event_tableDark2MouseClicked

    private void field_hpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_hpKeyReleased
        if (!(field_kemabalian.getText().isEmpty())) {
            kembalian();
        } else {
            field_kemabalian.setText("Rp-");
            button2.setEnabled(false);
            button2.setBackground(new Color(102, 102, 102));
            button2.setForeground(Color.WHITE);
        }

    }//GEN-LAST:event_field_hpKeyReleased

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
            java.util.logging.Logger.getLogger(Bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bayar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Bayar dialog = new Bayar(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField field_hp;
    private javax.swing.JLabel field_kemabalian;
    private javax.swing.JLabel field_kodeTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_totalHarga;
    private javax.swing.JLabel label_warningNoMoney;
    private com.fathan.swing.PanelBordeer panelBordeer1;
    private com.fathan.swing.PanelBordeer panelBordeer5;
    private com.fathan.swing.PanelBorderGradient3 panelBorderGradient31;
    private com.fathan.swing.jtable.TableDark tableDark2;
    // End of variables declaration//GEN-END:variables
}
