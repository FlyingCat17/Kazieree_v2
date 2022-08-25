/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.transaksijual;

import com.fathan.db.configdb;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fathan
 */
public class Cari_Produk extends javax.swing.JDialog {

    /**
     * Creates new form Tambah_Produk
     */
    public Cari_Produk(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        loadTableProduk();
        label_warning_kp.setVisible(false);
        new com.fathan.form.transaksijual.getKode_Produk().setKode_produk(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBordeer1 = new com.fathan.swing.PanelBordeer();
        jLabel1 = new javax.swing.JLabel();
        panelBordeer2 = new com.fathan.swing.PanelBordeer();
        field_kp = new javax.swing.JTextField();
        button1 = new com.fathan.form.produk.Button();
        button2 = new com.fathan.form.produk.Button();
        label_warning_kp = new javax.swing.JLabel();
        button11 = new com.fathan.form.transaksijual.Button1();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDark2 = new com.fathan.swing.jtable.TableDark(){
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };

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
        jLabel1.setText("Cari Produk");
        panelBordeer1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 500, 50));

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                field_kpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_kpKeyTyped(evt);
            }
        });
        panelBordeer2.add(field_kp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 670, 40));

        panelBordeer1.add(panelBordeer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 710, 40));

        button1.setBackground(new java.awt.Color(255, 51, 51));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("BATAL");
        button1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 620, 140, 40));

        button2.setBackground(new java.awt.Color(19, 179, 200));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("SIMPAN");
        button2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 620, 140, 40));

        label_warning_kp.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_kp.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_kp.setText("Harap Pilih Produk !");
        panelBordeer1.add(label_warning_kp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 370, 20));

        button11.setBackground(new java.awt.Color(19, 179, 200));
        button11.setForeground(new java.awt.Color(255, 255, 255));
        button11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/transaksijual/icon_cari.png"))); // NOI18N
        button11.setText("Pilih");
        button11.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        button11.setIconTextGap(5);
        panelBordeer1.add(button11, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 90, 40));

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

        panelBordeer1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 820, 430));

        getContentPane().add(panelBordeer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 690));

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

    public void cariData(String key) {
        try {
            Object[] judul_kolom = {"Kode Produk", "Nama Produk", "Kategori", "Satuan", "Harga Beli", "Harga Jual"};
            DefaultTableModel model = new DefaultTableModel(null, judul_kolom);
            tableDark2.setModel(model);
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            model.getDataVector().removeAllElements();

            java.sql.ResultSet rs = st.executeQuery("SELECT produk.kode_produk, produk.nama_produk, kategori.nama_kategori, produk.satuan, "
                    + "produk.harga_beli, produk.harga_jual\n"
                    + "FROM produk\n"
                    + "JOIN kategori\n"
                    + "ON produk.id_kategori = kategori.id_kategori\n"
                    + "WHERE produk.nama_produk LIKE '%" + key + "%'\n"
                    + "ORDER BY produk.nama_produk ASC");
            while (rs.next()) {
                Object[] data = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)};
                model.addRow(data);
                tableDark2.getColumnModel().getColumn(0).setPreferredWidth(10);
                tableDark2.getColumnModel().getColumn(1).setPreferredWidth(200);
                tableDark2.getColumnModel().getColumn(2).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(3).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(4).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(5).setPreferredWidth(1);
            }
        } catch (Exception e) {
            System.err.println("Cari Data : " + e.getMessage());
        }
    }

    public void loadTableProduk() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Kategori");
        model.addColumn("Satuan");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        tableDark2.setModel(model);
        try {
            String load = "SELECT produk.kode_produk, produk.nama_produk, kategori.nama_kategori, produk.satuan, "
                    + "produk.harga_beli, produk.harga_jual\n"
                    + "FROM produk\n"
                    + "JOIN kategori\n"
                    + "ON produk.id_kategori = kategori.id_kategori\n"
                    + "ORDER BY produk.nama_produk ASC";
            java.sql.Connection conn = (Connection) configdb.GetConnection();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(load);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("kode_produk"),
                    rs.getString("nama_produk"),
                    rs.getString("nama_kategori"),
                    rs.getString("satuan"),
                    rs.getString("harga_beli"),
                    rs.getString("harga_jual")
                });

                tableDark2.setModel(model);

                tableDark2.getColumnModel().getColumn(0).setPreferredWidth(10);
                tableDark2.getColumnModel().getColumn(1).setPreferredWidth(200);
                tableDark2.getColumnModel().getColumn(2).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(3).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(4).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(5).setPreferredWidth(1);

            }

        } catch (Exception e) {
            System.err.println("Error on : " + e.getMessage());
        }
    }
    private void field_kpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_kpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_kpActionPerformed

    private void field_kpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_kpKeyTyped


    }//GEN-LAST:event_field_kpKeyTyped

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        new com.fathan.form.transaksijual.getKode_Produk().setKode_produk(null);
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
        if (new com.fathan.form.transaksijual.getKode_Produk().getKode_produk() == null) {
            label_warning_kp.setVisible(true);
        } else {
            new com.fathan.form.transaksijual.Tambah_Produk(new com.fathan.form.transaksijual.transaksi_jual(), true).field_kp.setText(new com.fathan.form.transaksijual.getKode_Produk().getKode_produk());
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
        }
    }//GEN-LAST:event_button2ActionPerformed


    private void field_kpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_kpKeyReleased
        String key = field_kp.getText();

        if (key != "") {
            cariData(key);
        } else {
            loadTableProduk();
        }
    }//GEN-LAST:event_field_kpKeyReleased

    private void tableDark2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDark2MouseClicked
        if (evt.getClickCount() == 1) {
            int i = tableDark2.rowAtPoint(evt.getPoint());
            new com.fathan.form.transaksijual.getKode_Produk().setKode_produk(tableDark2.getValueAt(i, 0).toString());
            System.out.println("Pilih dari Cari Produk {Kode Produk} : " + new com.fathan.form.transaksijual.getKode_Produk().getKode_produk());
        }
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
            java.util.logging.Logger.getLogger(Cari_Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cari_Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cari_Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cari_Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cari_Produk dialog = new Cari_Produk(new javax.swing.JFrame(), true);
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
    private com.fathan.form.transaksijual.Button1 button11;
    private com.fathan.form.produk.Button button2;
    private javax.swing.JTextField field_kp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_warning_kp;
    private com.fathan.swing.PanelBordeer panelBordeer1;
    private com.fathan.swing.PanelBordeer panelBordeer2;
    private com.fathan.swing.jtable.TableDark tableDark2;
    // End of variables declaration//GEN-END:variables
}
