/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.laporan;

import com.fathan.chart.ModelChart;
import com.fathan.db.configdb;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fathan
 */
public class laporan extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    com.fathan.user.user usr = new com.fathan.user.user();

    String hari, bulan, tahun;

    public laporan() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        panel_top.setBackground(new Color(255, 255, 255, 240));
        panel_top1.setBackground(new Color(255, 255, 255, 100));
        scroll.setVerticalScrollBar(new com.fathan.swing.scrollbar.ScrollBarCustom());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        SimpleDateFormat hariDateFormat = new SimpleDateFormat("dd");
        SimpleDateFormat bulanDateFormat = new SimpleDateFormat("MM");
        SimpleDateFormat tahunDateFormat = new SimpleDateFormat("yyyy");
        Date datea = new Date();
        hari = hariDateFormat.format(datea);
        bulan = bulanDateFormat.format(datea);
        tahun = tahunDateFormat.format(datea);
        getPendapatan();
        saldo();
        getLabaKotor();
        getLabaBersih();
        getPengeluaran();
        getDataTransaksiJual();
        getDataTransaksiBeli();
        dateChooser.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
                hari = String.valueOf(date.getDay());
                bulan = String.valueOf(date.getMonth());
                tahun = String.valueOf(date.getYear());
                getPendapatan();
                saldo();
                getLabaKotor();
                getLabaBersih();
                getPengeluaran();
                getDataTransaksiJual();
                getDataTransaksiBeli();
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser.hidePopup();
                }
            }
        });
    }

    public void saldo() {
        try { //Saldo
            String sql = "SELECT * FROM cashbox";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                label_saldo.setText(rs.getString("jumlah_saldo"));
            }
        } catch (Exception e) {
            System.err.println("Get Saldo : " + e.getMessage());
            label_saldo.setText("0");
        }
    }

    public void getPendapatan() {
        try { //Pendapatan
            String sql = "SELECT SUM(jual.total_harga) AS Income FROM jual\n"
                    + "WHERE EXTRACT(DAY FROM tgl_transaksi) = '" + hari + "'\n"
                    + "AND EXTRACT(MONTH FROM tgl_transaksi) = '" + bulan + "'\n"
                    + "AND EXTRACT(YEAR FROM tgl_transaksi) = '" + tahun + "'\n"
                    + "GROUP BY EXTRACT(DAY FROM jual.tgl_transaksi)";
            java.sql.Connection con1 = (Connection) configdb.GetConnection();
            java.sql.Statement st1 = con1.createStatement();
            java.sql.ResultSet rs1 = st1.executeQuery(sql);
            if (rs1.next()) {
                label_pendapatan.setText(rs1.getString("Income"));
            } else {
                label_pendapatan.setText("0");
            }
        } catch (Exception e) {
            label_pendapatan.setText("0");
            System.err.println("Get Pendapatan : " + e.getMessage());
        }
    }

    public void getLabaKotor() {
        double db = 0;
        try { //laba
            String sql = "SELECT SUM((produk.harga_jual - produk.harga_beli)*detail_jual.qty)AS LABA FROM detail_jual \n"
                    + "JOIN produk \n"
                    + "ON detail_jual.kode_produk = produk.kode_produk \n"
                    + "JOIN jual\n"
                    + "ON jual.kode_transaksi = detail_jual.kode_transaksi\n"
                    + "WHERE EXTRACT(YEAR FROM jual.tgl_transaksi) = '" + tahun + "' \n"
                    + "AND EXTRACT(DAY FROM jual.tgl_transaksi) = '" + hari + "'\n"
                    + "AND EXTRACT(MONTH FROM jual.tgl_transaksi) = '" + bulan + "'\n";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                if (rs.getString("LABA") == null) {
                    label_laba.setText("0");
                } else {
                    db = Double.parseDouble(rs.getString("LABA"));
                    int laba = (int) Math.round(db);
                    label_laba.setText(String.valueOf(laba));
                }
            }
        } catch (Exception e) {
            System.err.println("Get Laba Kotor : " + e.getMessage());
            label_laba.setText("0");
        }
    }

    public void getLabaBersih() {
        int labaKotor = 0, hargaBeban = 0;
        double db = 0;
        try {
            String sqlLabaKotor = "SELECT SUM((produk.harga_jual - produk.harga_beli) * detail_jual.qty) AS Laba FROM detail_jual \n"
                    + "JOIN produk \n"
                    + "ON detail_jual.kode_produk = produk.kode_produk \n"
                    + "JOIN jual\n"
                    + "ON jual.kode_transaksi = detail_jual.kode_transaksi\n"
                    + "WHERE EXTRACT(YEAR FROM jual.tgl_transaksi) = '" + tahun + "' \n"
                    + "AND EXTRACT(DAY FROM jual.tgl_transaksi) = '" + hari + "'\n"
                    + "AND EXTRACT(MONTH FROM jual.tgl_transaksi) = '" + bulan + "'\n";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs122 = st.executeQuery(sqlLabaKotor);
            if (rs122.next()) {
                if (!(rs122.getString("Laba").equals(null))) {
                    db = Double.parseDouble(rs122.getString("Laba"));
                    System.out.println("Double : " + db);
                    labaKotor = (int) Math.round(db);
                    System.out.println("Integer : " + labaKotor);
                } else {
                    labaKotor = 0;
                    System.out.println("Laba Kotor yang didapat : " + labaKotor);
                }
            } else {
                labaKotor = 0;
            }
        } catch (Exception e) {
            System.err.println("Get Laba Kotor (153:52) : " + e.getMessage());
            labaKotor = 0;
        }
        try {
            String tgll = tahun + "-" + bulan + "-" + hari;
            String sqlBeban = "SELECT SUM(pengeluaran.jumlah_pengeluaran) AS Beban FROM pengeluaran\n"
                    + "WHERE pengeluaran.tgl_pengeluaran = '" + tgll + "'";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sqlBeban);
            if (rs.next()) {
                if (!(rs.getString("Beban") == null)) {
                    hargaBeban = Integer.parseInt(rs.getString("Beban"));
                    System.out.println("Harga Beban yang didapat : " + hargaBeban);
                } else {
                    hargaBeban = 0;
                }
            } else {
                hargaBeban = 0;
            }
        } catch (Exception e) {
            System.err.println("Get Harga Beban (169:54) : " + e.getMessage());
        }

        System.out.println(labaKotor - hargaBeban);
        int labaBersih = labaKotor - hargaBeban;
        label_laba1.setText(String.valueOf(labaBersih));
    }

    public void getPengeluaran() {
        String tgll = tahun + "-" + bulan + "-" + hari;
        try {
            String loadPengeluaran = "SELECT SUM(pengeluaran.jumlah_pengeluaran) AS Outcome FROM pengeluaran\n"
                    + "WHERE pengeluaran.tgl_pengeluaran = '" + tgll + "'";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(loadPengeluaran);
            if (rs.next()) {
                if (!(rs.getString("Outcome").equals(null))) {
                    label_laba3.setText(rs.getString("Outcome").toString());
                } else {
                    label_laba3.setText("0");
                }
            } else {
                label_laba3.setText("0");
            }
        } catch (Exception e) {
            System.err.println("Get Pengeluaran (200:53) : " + e.getMessage());
            label_laba3.setText("0");
        }
    }

    public void getDataTransaksiJual() {
        DefaultTableModel transjual = new DefaultTableModel();
        transjual.addColumn("Kode Transaksi");
        transjual.addColumn("Tanggal Transaksi");
        transjual.addColumn("Kasir");
        transjual.addColumn("Total Harga");
        transjual.addColumn("Laba Produk");
        table_transaksijual.setModel(transjual);
        try {
            String sql = "SELECT jual.kode_transaksi, jual.tgl_transaksi, detail_pengguna.nama_lengkap, jual.total_harga,\n"
                    + "SUM((produk.harga_jual - produk.harga_beli)*detail_jual.qty) AS LABA\n"
                    + "FROM jual \n"
                    + "JOIN detail_pengguna \n"
                    + "ON jual.id_pengguna = detail_pengguna.id_pengguna\n"
                    + "JOIN detail_jual ON detail_jual.kode_transaksi = jual.kode_transaksi\n"
                    + "JOIN produk ON produk.kode_produk = detail_jual.kode_produk\n"
                    + "WHERE EXTRACT(DAY FROM jual.tgl_transaksi) = '" + hari + "'\n"
                    + "AND EXTRACT(MONTH FROM jual.tgl_transaksi) = '" + bulan + "'\n"
                    + "AND EXTRACT(YEAR FROM jual.tgl_transaksi) = '" + tahun + "'\n"
                    + "GROUP BY jual.kode_transaksi";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                transjual.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                });
                table_transaksijual.setModel(transjual);
            }
        } catch (Exception e) {
            System.err.println("Error Load Transaksi Jual Harian : " + e.getMessage());
        }
    }

    public void getDataTransaksiBeli() {
        DefaultTableModel transbeli = new DefaultTableModel();
        transbeli.addColumn("Kode Transaksi");
        transbeli.addColumn("Tanggal Transaksi");
        transbeli.addColumn("Kasir");
        transbeli.addColumn("Nama Supplier");
        transbeli.addColumn("Total Beli");
        table_transaksibeli.setModel(transbeli);
        try {
            String sql = "SELECT beli.kode_transaksi, beli.tgl_transaksi, detail_pengguna.nama_lengkap, "
                    + "pemasok.nama_pemasok, beli.total_harga FROM beli\n"
                    + "JOIN detail_pengguna ON detail_pengguna.id_pengguna = beli.id_pengguna\n"
                    + "JOIN pemasok ON pemasok.kode_pemasok = beli.id_pemasok\n"
                    + "WHERE EXTRACT(DAY FROM beli.tgl_transaksi) = '"+hari+"'\n"
                    + "AND EXTRACT(MONTH FROM beli.tgl_transaksi) = '"+bulan+"'\n"
                    + "AND EXTRACT(YEAR FROM beli.tgl_transaksi) = '"+tahun+"'";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                transbeli.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                });
                table_transaksibeli.setModel(transbeli);
            }
        } catch (Exception e) {
            System.err.println("Error Load Transaksi Jual Harian : " + e.getMessage());
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

        dateChooser = new com.raven.datechooser.DateChooser();
        panelBordeer1 = new com.fathan.swing.PanelBordeer();
        panel_top1 = new com.fathan.swing.PanelRound();
        scroll = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new com.fathan.swing.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        button1 = new com.raven.datechooser.Button();
        panelShadow2 = new main.PanelShadow();
        label_pendapatan = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelShadow10 = new main.PanelShadow();
        jLabel11 = new javax.swing.JLabel();
        label_laba3 = new javax.swing.JLabel();
        panelShadow9 = new main.PanelShadow();
        jLabel10 = new javax.swing.JLabel();
        label_laba2 = new javax.swing.JLabel();
        panelShadow8 = new main.PanelShadow();
        jLabel9 = new javax.swing.JLabel();
        label_laba1 = new javax.swing.JLabel();
        panelShadow3 = new main.PanelShadow();
        jLabel5 = new javax.swing.JLabel();
        label_laba = new javax.swing.JLabel();
        panelShadow7 = new main.PanelShadow();
        jLabel3 = new javax.swing.JLabel();
        panelShadow4 = new main.PanelShadow();
        label_saldo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelShadow6 = new main.PanelShadow();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_transaksibeli = new com.fathan.swing.jtable.TableDark(){
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };
        jLabel8 = new javax.swing.JLabel();
        panelShadow5 = new main.PanelShadow();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_transaksijual = new com.fathan.swing.jtable.TableDark(){
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_top = new com.fathan.swing.PanelRound();
        button4 = new com.fathan.form.kategori.Button();
        label_ucapan1 = new javax.swing.JLabel();

        dateChooser.setTextRefernce(jTextField1);

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

        scroll.setBackground(new java.awt.Color(255, 255, 255));
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(244, 244, 244));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tanggal     :");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 40));

        jTextField1.setBackground(new java.awt.Color(244, 244, 244));
        jTextField1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jTextField1.setBorder(null);
        panelRound1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 150, 40));

        button1.setBackground(new java.awt.Color(244, 244, 244));
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/laporan/icon_calendar.png"))); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelRound1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 40, 40));

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 320, 40));

        panelShadow2.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_pendapatan.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        label_pendapatan.setForeground(new java.awt.Color(19, 179, 200));
        label_pendapatan.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_pendapatan.setText("0");
        panelShadow2.add(label_pendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, 50));

        jLabel7.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(19, 179, 200));
        jLabel7.setText("Pendapatan");
        panelShadow2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jPanel1.add(panelShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 360, 160));

        panelShadow10.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(19, 179, 200));
        jLabel11.setText("Pengeluaran");
        panelShadow10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 310, -1));

        label_laba3.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        label_laba3.setForeground(new java.awt.Color(19, 179, 200));
        label_laba3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_laba3.setText("0");
        panelShadow10.add(label_laba3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, 50));

        jPanel1.add(panelShadow10, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, 360, 160));

        panelShadow9.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(19, 179, 200));
        jLabel10.setText("Pemasukan Lainnya");
        panelShadow9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 310, -1));

        label_laba2.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        label_laba2.setForeground(new java.awt.Color(19, 179, 200));
        label_laba2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_laba2.setText("0");
        panelShadow9.add(label_laba2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, 50));

        jPanel1.add(panelShadow9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 360, 160));

        panelShadow8.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(19, 179, 200));
        jLabel9.setText("Laba Bersih");
        panelShadow8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 200, -1));

        label_laba1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        label_laba1.setForeground(new java.awt.Color(19, 179, 200));
        label_laba1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_laba1.setText("0");
        panelShadow8.add(label_laba1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, 50));

        jPanel1.add(panelShadow8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 360, 160));

        panelShadow3.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(19, 179, 200));
        jLabel5.setText("Laba Kotor");
        panelShadow3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 200, -1));

        label_laba.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        label_laba.setForeground(new java.awt.Color(19, 179, 200));
        label_laba.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_laba.setText("0");
        panelShadow3.add(label_laba, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, 50));

        jPanel1.add(panelShadow3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 360, 160));

        panelShadow7.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(19, 179, 200));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bulan");
        panelShadow7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        jPanel1.add(panelShadow7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, 130, 50));

        panelShadow4.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_saldo.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 30)); // NOI18N
        label_saldo.setForeground(new java.awt.Color(19, 179, 200));
        label_saldo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_saldo.setText("0");
        panelShadow4.add(label_saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, 50));

        jLabel4.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(19, 179, 200));
        jLabel4.setText("Saldo Sekarang");
        panelShadow4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, -1));

        jPanel1.add(panelShadow4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 360, 160));

        panelShadow6.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(null);

        table_transaksibeli.setForeground(new java.awt.Color(51, 51, 51));
        table_transaksibeli.setModel(new javax.swing.table.DefaultTableModel(
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
        table_transaksibeli.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        table_transaksibeli.setGridColor(new java.awt.Color(255, 255, 255));
        table_transaksibeli.getTableHeader().setResizingAllowed(false);
        table_transaksibeli.getTableHeader().setReorderingAllowed(false);
        table_transaksibeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_transaksibeliMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_transaksibeli);

        panelShadow6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 990, 280));

        jLabel8.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(19, 179, 200));
        jLabel8.setText("Pembelian Produk (Transaksi Beli)");
        panelShadow6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 30));

        jPanel1.add(panelShadow6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 910, 1100, 410));

        panelShadow5.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(null);

        table_transaksijual.setForeground(new java.awt.Color(51, 51, 51));
        table_transaksijual.setModel(new javax.swing.table.DefaultTableModel(
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
        table_transaksijual.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        table_transaksijual.setGridColor(new java.awt.Color(255, 255, 255));
        table_transaksijual.getTableHeader().setResizingAllowed(false);
        table_transaksijual.getTableHeader().setReorderingAllowed(false);
        table_transaksijual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_transaksijualMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_transaksijual);

        panelShadow5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 990, 280));

        jLabel6.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(19, 179, 200));
        jLabel6.setText("Produk Terjual (Transaksi Jual)");
        panelShadow5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 30));

        jPanel1.add(panelShadow5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 1100, 410));

        scroll.setViewportView(jPanel1);

        panel_top1.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1200, 470));

        panelBordeer1.add(panel_top1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 1220, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/beranda/bg_beranda.png"))); // NOI18N
        panelBordeer1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, 440));

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

        label_ucapan1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 22)); // NOI18N
        label_ucapan1.setForeground(new java.awt.Color(107, 107, 107));
        label_ucapan1.setText("Laporan Harian");
        panel_top.add(label_ucapan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 475, 70));

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
            try {
                Thread.sleep(1);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened


    private void panel_topMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_topMouseClicked

    }//GEN-LAST:event_panel_topMouseClicked

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
        new com.fathan.form.beranda.beranda().setVisible(true);
    }//GEN-LAST:event_button4ActionPerformed

    private void panel_top1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_top1MouseClicked

    }//GEN-LAST:event_panel_top1MouseClicked

    private void table_transaksijualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_transaksijualMouseClicked

    }//GEN-LAST:event_table_transaksijualMouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        dateChooser.showPopup();
    }//GEN-LAST:event_button1ActionPerformed

    private void table_transaksibeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_transaksibeliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_transaksibeliMouseClicked

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
            java.util.logging.Logger.getLogger(laporan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.Button button1;
    private com.fathan.form.kategori.Button button4;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_laba;
    private javax.swing.JLabel label_laba1;
    private javax.swing.JLabel label_laba2;
    private javax.swing.JLabel label_laba3;
    private javax.swing.JLabel label_pendapatan;
    private javax.swing.JLabel label_saldo;
    public javax.swing.JLabel label_ucapan1;
    private com.fathan.swing.PanelBordeer panelBordeer1;
    private com.fathan.swing.PanelRound panelRound1;
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
    private javax.swing.JScrollPane scroll;
    private com.fathan.swing.jtable.TableDark table_transaksibeli;
    private com.fathan.swing.jtable.TableDark table_transaksijual;
    // End of variables declaration//GEN-END:variables
}
