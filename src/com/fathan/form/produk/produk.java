/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.produk;

import com.fathan.form.kategori.*;
import com.fathan.form.beranda.*;
import com.fathan.main.*;
import com.fathan.db.configdb;
import java.awt.Color;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fathan
 */
public class produk extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    com.fathan.user.user usr = new com.fathan.user.user();

    public produk() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        panel_top.setBackground(new Color(255, 255, 255, 210));
        panel_top1.setBackground(new Color(255, 255, 255, 210));
        getKategori();
        label_emptyData.setVisible(false);
        combobox1.setSelectedIndex(0);
        if (combobox1.getSelectedIndex() == 0) {
            loadTableProduk();
        }
    }

    public void cariDataBarang(String key) {
        try {
            Object[] judul_kolom = {"Kode Produk", "Nama Produk", "Kategori", "Satuan", "Harga Beli", "Harga Jual", "Sisa Stok"};
            DefaultTableModel model = new DefaultTableModel(null, judul_kolom);
            tableDark2.setModel(model);
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            model.getDataVector().removeAllElements();

            java.sql.ResultSet rs = st.executeQuery("SELECT produk.kode_produk, produk.nama_produk, kategori.nama_kategori, produk.satuan,\n"
                    + "produk.harga_beli, produk.harga_jual, stok.jumlah_stok\n"
                    + "FROM produk\n"
                    + "JOIN kategori ON produk.id_kategori = kategori.id_kategori\n"
                    + "JOIN stok ON produk.kode_produk = stok.kode_produk\n"
                    + "WHERE produk.nama_produk LIKE '%" + key + "%'\n"
                    + "AND NOT produk.id_kategori = 2");
            while (rs.next()) {
                Object[] data = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)};
                model.addRow(data);
                tableDark2.getColumnModel().getColumn(0).setPreferredWidth(10);
                tableDark2.getColumnModel().getColumn(1).setPreferredWidth(200);
                tableDark2.getColumnModel().getColumn(2).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(3).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(4).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(5).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(6).setPreferredWidth(1);
            }
        } catch (Exception e) {
            System.err.println("Cari Data : " + e.getMessage());
        }
    }

    public void getKategori() {
        try {
            String getCat = "SELECT kategori.nama_kategori FROM kategori";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(getCat);
            while (rs.next()) {
                String kategori = rs.getString("nama_kategori");
                combobox1.addItem(kategori);
            }
        } catch (Exception e) {
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
        model.addColumn("Sisa Stok");
        tableDark2.setModel(model);
        try {
            String load = "SELECT produk.kode_produk, produk.nama_produk, kategori.nama_kategori, produk.satuan, "
                    + "produk.harga_beli, produk.harga_jual, stok.jumlah_stok\n"
                    + "FROM produk\n"
                    + "JOIN kategori\n"
                    + "ON produk.id_kategori = kategori.id_kategori\n"
                    + "JOIN stok\n"
                    + "ON produk.kode_produk = stok.kode_produk\n"
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
                    rs.getString("harga_jual"),
                    rs.getString("jumlah_stok")
                });

                tableDark2.setModel(model);

                tableDark2.getColumnModel().getColumn(0).setPreferredWidth(10);
                tableDark2.getColumnModel().getColumn(1).setPreferredWidth(200);
                tableDark2.getColumnModel().getColumn(2).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(3).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(4).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(5).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(6).setPreferredWidth(1);

            }

        } catch (Exception e) {
            label_emptyData.setVisible(true);
            System.err.println("Error on : " + e.getMessage());
        }

    }

    public void cariDataJasa(String key1) {
        try {
            Object[] judul_kolom = {"Kode Produk", "Nama Produk", "Kategori", "Satuan", "Harga Jasa"};
            DefaultTableModel model = new DefaultTableModel(null, judul_kolom);
            tableDark2.setModel(model);
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            model.getDataVector().removeAllElements();

            java.sql.ResultSet rs = st.executeQuery("SELECT * FROM produk JOIN kategori ON produk.id_kategori = kategori.id_kategori\n"
                    + "WHERE produk.nama_produk LIKE '%"+key1+"%' AND produk.id_kategori = 2");
            while (rs.next()) {
                Object[] data = {
                    rs.getString("kode_produk"),
                    rs.getString("nama_produk"),
                    rs.getString("nama_kategori"),
                    rs.getString("satuan"),
                    rs.getString("harga_jual")
                };
                model.addRow(data);
                tableDark2.getColumnModel().getColumn(0).setPreferredWidth(10);
                tableDark2.getColumnModel().getColumn(1).setPreferredWidth(200);
                tableDark2.getColumnModel().getColumn(2).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(3).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(4).setPreferredWidth(1);
            }
        } catch (Exception e) {
            System.err.println("Cari Data Jasa: " + e.getMessage());
        }
    }

    public void loadTableProdukJasa() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Kategori");
        model.addColumn("Satuan");
        model.addColumn("Harga Jasa");
        tableDark2.setModel(model);
        try {
            String load = "SELECT produk.kode_produk, produk.nama_produk, kategori.nama_kategori, produk.satuan, produk.harga_jual FROM produk JOIN kategori ON produk.id_kategori = kategori.id_kategori\n"
                    + "WHERE produk.id_kategori = 2\n"
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
                    rs.getString("harga_jual")
                });

                tableDark2.setModel(model);

                tableDark2.getColumnModel().getColumn(0).setPreferredWidth(10);
                tableDark2.getColumnModel().getColumn(1).setPreferredWidth(200);
                tableDark2.getColumnModel().getColumn(2).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(3).setPreferredWidth(1);
                tableDark2.getColumnModel().getColumn(4).setPreferredWidth(1);

            }

        } catch (Exception e) {
            label_emptyData.setVisible(true);
            System.err.println("Error on Load Jasa : " + e.getMessage());
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

        panelBordeer1 = new com.fathan.swing.PanelBordeer();
        panel_top1 = new com.fathan.swing.PanelRound();
        label_emptyData = new javax.swing.JLabel();
        panelRound1 = new com.fathan.swing.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        field_cari = new javax.swing.JTextField();
        button1 = new com.fathan.form.kategori.Button();
        button2 = new com.fathan.form.kategori.Button();
        button3 = new com.fathan.form.kategori.Button();
        combobox1 = new com.fathan.swing.jcombobox.Combobox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDark2 = new com.fathan.swing.jtable.TableDark();
        jLabel1 = new javax.swing.JLabel();
        panel_top = new com.fathan.swing.PanelRound();
        label_ucapan = new javax.swing.JLabel();
        button4 = new com.fathan.form.kategori.Button();

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
        panel_top1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_emptyData.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        label_emptyData.setForeground(new java.awt.Color(255, 0, 0));
        label_emptyData.setText("Data Kosong!!");
        panel_top1.add(label_emptyData, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 510, 40));

        panelRound1.setBackground(new java.awt.Color(247, 247, 247));
        panelRound1.setRoundBottomLeft(10);
        panelRound1.setRoundBottomRight(10);
        panelRound1.setRoundTopLeft(10);
        panelRound1.setRoundTopRight(10);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/kategori/search.png"))); // NOI18N
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 40));

        field_cari.setBackground(new java.awt.Color(247, 247, 247));
        field_cari.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_cari.setBorder(null);
        field_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_cariActionPerformed(evt);
            }
        });
        field_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                field_cariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_cariKeyTyped(evt);
            }
        });
        panelRound1.add(field_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 530, 40));

        panel_top1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 620, 40));

        button1.setBackground(new java.awt.Color(255, 51, 51));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Hapus");
        button1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 13)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panel_top1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 30, 100, 40));

        button2.setBackground(new java.awt.Color(19, 179, 200));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Tambah");
        button2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 13)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panel_top1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 100, 40));

        button3.setBackground(new java.awt.Color(0, 204, 0));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Ubah");
        button3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 13)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        panel_top1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 100, 40));

        combobox1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        combobox1.setLabeText("Pilih Kategori");
        combobox1.setLineColor(new java.awt.Color(19, 179, 200));
        combobox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox1ActionPerformed(evt);
            }
        });
        panel_top1.add(combobox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 200, 40));

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

        panel_top1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 1160, 350));

        panelBordeer1.add(panel_top1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 1220, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/beranda/bg_beranda.png"))); // NOI18N
        panelBordeer1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, 440));

        panel_top.setBackground(new java.awt.Color(255, 255, 255));
        panel_top.setRoundBottomLeft(15);
        panel_top.setRoundBottomRight(15);
        panel_top.setRoundTopLeft(15);
        panel_top.setRoundTopRight(15);
        panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_ucapan.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 22)); // NOI18N
        label_ucapan.setForeground(new java.awt.Color(107, 107, 107));
        label_ucapan.setText("Produk");
        panel_top.add(label_ucapan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 475, 70));

        button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/kategori/back.png"))); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        panel_top.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 70));

        panelBordeer1.add(panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1220, 70));

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

    private void field_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_cariActionPerformed

    }//GEN-LAST:event_field_cariActionPerformed

    private void field_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_cariKeyTyped

    }//GEN-LAST:event_field_cariKeyTyped

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        new com.fathan.form.produk.Tambah_Produk(this, true).setVisible(true);
        loadTableProduk();
    }//GEN-LAST:event_button2ActionPerformed

    private void tableDark2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDark2MouseClicked
        if (evt.getClickCount() == 1) {
            int i = tableDark2.rowAtPoint(evt.getPoint());
            new com.fathan.form.produk.getdatabarang().setKode_produk(tableDark2.getValueAt(i, 0).toString());
            System.out.println("ID PRODUK = " + new com.fathan.form.produk.getdatabarang().getKode_produk());
            new com.fathan.form.produk.getdatabarang().setNama_produk(tableDark2.getValueAt(i, 1).toString());
            System.out.println("NAMA PRODUK = " + new com.fathan.form.produk.getdatabarang().getNama_produk());
            label_emptyData.setVisible(false);
            label_emptyData.setText("Data Kosong!!");
            if (tableDark2.getValueAt(tableDark2.rowAtPoint(evt.getPoint()), 2).toString().equals("Jasa")) {
                new com.fathan.form.produk.getdatabarang().setKategori(true);
                System.out.println("Kategori Jasa : " + new com.fathan.form.produk.getdatabarang().getKategori());
            } else {
                new com.fathan.form.produk.getdatabarang().setKategori(false);
                System.out.println("Kategori Jasa : " + new com.fathan.form.produk.getdatabarang().getKategori());
//                System.out.println("Kategori PRODUK = " + new com.fathan.form.produk.getdatabarang().getKategori());
//                kategori = tableDark2.getValueAt(i, 2).toString();
//                
            }
//                int i = tableDark2.rowAtPoint(evt.getPoint());
//                new com.fathan.form.produk.getdatabarang().setKategori(tableDark2.getValueAt(tableDark2.rowAtPoint(evt.getPoint()), 2).toString());
//                System.out.println("ID PRODUK = " + new com.fathan.form.produk.getdatabarang().getKode_produk());
//                label_emptyData.setVisible(false);
//                label_emptyData.setText("Data Kosong!!");
        }
    }//GEN-LAST:event_tableDark2MouseClicked

    public String kategori = null;
    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        if (new com.fathan.form.produk.getdatabarang().kode_produk == null) {
            label_emptyData.setVisible(true);
            label_emptyData.setText("Harap Pilih Salah Satu Produk !");

        } else if (new com.fathan.form.produk.getdatabarang().getKategori() == true) {
            new com.fathan.form.produk.getdatabarang().setKategori(true);
            new com.fathan.form.produk.Ubah_Produk(this, true).setVisible(true);
            loadTableProdukJasa();
        } else {
            new com.fathan.form.produk.Ubah_Produk(this, true).setVisible(true);
            loadTableProduk();
        }
    }//GEN-LAST:event_button3ActionPerformed

    private void combobox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox1ActionPerformed
        if (combobox1.getSelectedIndex() == 0) {
            loadTableProduk();
        } else if (combobox1.getSelectedIndex() == 1) {
            loadTableProdukJasa();
        }
    }//GEN-LAST:event_combobox1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if (usr.getRole().equals("member")) {
            System.out.println("Disabled You Can't Delete this!");
        } else if (new com.fathan.form.produk.getdatabarang().getKode_produk() == null) {
            label_emptyData.setVisible(true);
            label_emptyData.setText("Harap Pilih Salah Satu Produk !");
        } else {
            if (new com.fathan.form.produk.getdatabarang().getKategori() == true) {
                new com.fathan.form.produk.option_hapus(this, true).setVisible(true);
                loadTableProdukJasa();
            } else {
                new com.fathan.form.produk.option_hapus(this, true).setVisible(true);
                loadTableProduk();
            }

        }
    }//GEN-LAST:event_button1ActionPerformed

    private void field_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_cariKeyReleased
        if (combobox1.getSelectedIndex() == 0) {
            String key = field_cari.getText();

            if (key != "") {
                cariDataBarang(key);
            } else {
                loadTableProduk();
            }
        } else if(combobox1.getSelectedIndex()==1){
            String key = field_cari.getText();

            if (key != "") {
                cariDataJasa(key);
            } else {
                loadTableProdukJasa();
            }
        }
    }//GEN-LAST:event_field_cariKeyReleased

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
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fathan.form.kategori.Button button1;
    private com.fathan.form.kategori.Button button2;
    private com.fathan.form.kategori.Button button3;
    private com.fathan.form.kategori.Button button4;
    private com.fathan.swing.jcombobox.Combobox combobox1;
    private javax.swing.JTextField field_cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_emptyData;
    public javax.swing.JLabel label_ucapan;
    private com.fathan.swing.PanelBordeer panelBordeer1;
    private com.fathan.swing.PanelRound panelRound1;
    private com.fathan.swing.PanelRound panel_top;
    private com.fathan.swing.PanelRound panel_top1;
    private com.fathan.swing.jtable.TableDark tableDark2;
    // End of variables declaration//GEN-END:variables
}
