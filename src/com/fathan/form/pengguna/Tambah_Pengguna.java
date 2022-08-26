
package com.fathan.form.pengguna;


import com.fathan.db.configdb;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Fathan
 */
public class Tambah_Pengguna extends javax.swing.JDialog {

    boolean username_similar;

    /**
     * Creates new form Tambah_Produk
     */
    public Tambah_Pengguna(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        getKategori();
        label_warning_ip.setVisible(false);
        label_warning_nl.setVisible(false);
        label_warning_us.setVisible(false);
        label_warning_us1.setVisible(false);
        label_success.setVisible(false);
        radioButtonCustom1.setActionCommand("aktif");
        radioButtonCustom2.setActionCommand("tidak_aktif");
    }

    public void getKategori() {
        try {
            String getCat = "SELECT pengguna.role FROM pengguna";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(getCat);
            while (rs.next()) {
                String kategori = rs.getString("role").toUpperCase();
                combobox1.addItem(kategori);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelBordeer1 = new com.fathan.swing.PanelBordeer();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelBordeer4 = new com.fathan.swing.PanelBordeer();
        field_nl = new javax.swing.JTextField();
        panelBordeer3 = new com.fathan.swing.PanelBordeer();
        field_us = new javax.swing.JTextField();
        panelBordeer2 = new com.fathan.swing.PanelBordeer();
        field_ip = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        button1 = new com.fathan.form.produk.Button();
        button2 = new com.fathan.form.produk.Button();
        jLabel3 = new javax.swing.JLabel();
        label_warning_ip = new javax.swing.JLabel();
        label_warning_nl = new javax.swing.JLabel();
        combobox1 = new com.fathan.swing.jcombobox.Combobox();
        jLabel7 = new javax.swing.JLabel();
        radioButtonCustom2 = new com.fathan.swing.RadioButtonCustom();
        radioButtonCustom1 = new com.fathan.swing.RadioButtonCustom();
        label_warning_us1 = new javax.swing.JLabel();
        label_warning_us = new javax.swing.JLabel();
        label_success = new javax.swing.JLabel();

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
        jLabel1.setText("Tambah Pengguna");
        panelBordeer1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 500, 50));

        jLabel6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Status :");
        panelBordeer1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 70, 20));

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
        panelBordeer4.add(field_nl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 460, 40));

        panelBordeer1.add(panelBordeer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 490, 40));

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
        panelBordeer3.add(field_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 460, 40));

        panelBordeer1.add(panelBordeer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 490, 40));

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
        panelBordeer2.add(field_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 40));

        panelBordeer1.add(panelBordeer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 290, 40));

        jLabel5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Username");
        panelBordeer1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, -1));

        button1.setBackground(new java.awt.Color(255, 51, 51));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("BATAL");
        button1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 240, 40));

        button2.setBackground(new java.awt.Color(19, 179, 200));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("SIMPAN");
        button2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panelBordeer1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 240, 40));

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("ID Pengguna (Auto)");
        panelBordeer1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 200, -1));

        label_warning_ip.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_ip.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_ip.setText("Kode Produk Kosong!");
        panelBordeer1.add(label_warning_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 370, 20));

        label_warning_nl.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_nl.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_nl.setText("Nama Lengkap Kosong!");
        panelBordeer1.add(label_warning_nl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 300, 20));

        combobox1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        combobox1.setLabeText("Role");
        combobox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox1ActionPerformed(evt);
            }
        });
        panelBordeer1.add(combobox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 190, 40));

        jLabel7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Nama Lengkap");
        panelBordeer1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 100, -1));

        buttonGroup1.add(radioButtonCustom2);
        radioButtonCustom2.setText("Tidak Aktif");
        panelBordeer1.add(radioButtonCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, -1, -1));

        buttonGroup1.add(radioButtonCustom1);
        radioButtonCustom1.setSelected(true);
        radioButtonCustom1.setText("Aktif");
        panelBordeer1.add(radioButtonCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        label_warning_us1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_us1.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_us1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_warning_us1.setText("Username Telah Terpakai !");
        panelBordeer1.add(label_warning_us1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 200, 20));

        label_warning_us.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_us.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_us.setText("Username Kosong!");
        panelBordeer1.add(label_warning_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 210, 20));

        label_success.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_success.setForeground(new java.awt.Color(0, 204, 0));
        label_success.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_success.setText("Berhasil Ditambahkan!");
        panelBordeer1.add(label_success, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 490, 20));

        getContentPane().add(panelBordeer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 480));

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
        System.out.println(buttonGroup1.getSelection().getActionCommand());
        if (username_similar = false) {
            field_us.requestFocus();
        } else if (field_us.getText().equals("")) {
            label_warning_us.setVisible(true);
            label_warning_us.setText("Username Kosong!");
            field_us.getText();
        } else if (field_nl.getText().equals("")) {
            label_warning_nl.setVisible(true);
            field_nl.requestFocus();
        } else {
            try {
                String sql = "INSERT INTO `pengguna`(`id_pengguna`, `nama_pengguna`, `role`, `kata_sandi`, `status`) "
                        + "VALUES ('" + field_ip.getText() + "','"
                        + field_us.getText() + "','"
                        + combobox1.getSelectedItem().toString().toLowerCase() + "','" + field_us.getText()
                        + "','" + buttonGroup1.getSelection().getActionCommand() + "')";
                String sql1 = "INSERT INTO `detail_pengguna`(`id_pengguna`, `nama_lengkap`) VALUES ('" + field_ip.getText() + "','" + field_nl.getText() + "')";
                java.sql.Connection con = (Connection) configdb.GetConnection();
                java.sql.Statement st = con.createStatement();
                java.sql.Statement st1 = con.createStatement();
                st.execute(sql);
                st1.execute(sql1);
                label_success.setVisible(true);
                label_success.setText("Berhasil Ditambahkan!");
                field_us.setText("");
                field_nl.setText("");
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

    private void combobox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox1ActionPerformed
        if (combobox1.getSelectedItem().equals("ADMIN")) {
            try {
                String sql = "SELECT MAX(RIGHT(pengguna.id_pengguna,5)) AS nomor FROM pengguna \n"
                        + "WHERE pengguna.role = 'admin'";
                java.sql.Connection con = (Connection) configdb.GetConnection();
                java.sql.Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                java.sql.ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    if (rs.first() == false) {
                        field_ip.setText("A00001");
                    } else {
                        rs.last();
                        int autoId = rs.getInt(1) + 1;
                        String no = String.valueOf(autoId);
                        int noLong = no.length();
                        for (int i = 0; i < 5 - noLong; i++) {
                            no = "0" + no;
                        }
                        field_ip.setText("A" + no);
                        System.out.println(no);
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else if (combobox1.getSelectedItem().equals("KARYAWAN")) {
            try {
                String sql = "SELECT MAX(RIGHT(pengguna.id_pengguna,5)) AS nomor FROM pengguna \n"
                        + "WHERE pengguna.role = 'karyawan'";
                java.sql.Connection con = (Connection) configdb.GetConnection();
                java.sql.Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                java.sql.ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    if (rs.first() == false) {
                        field_ip.setText("K00001");
                    } else {
                        rs.last();
                        int autoId = rs.getInt(1) + 1;
                        String no = String.valueOf(autoId);
                        int noLong = no.length();
                        for (int i = 0; i < 5 - noLong; i++) {
                            no = "0" + no;
                        }
                        field_ip.setText("K" + no);
                        System.out.println(no);
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_combobox1ActionPerformed

    private void field_usKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_usKeyReleased
        if (field_nl.getText().length() >= 50) {
            label_warning_us1.setVisible(false);
        } else {
            cariUsername();
        }

    }//GEN-LAST:event_field_usKeyReleased
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
            java.util.logging.Logger.getLogger(Tambah_Pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tambah_Pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tambah_Pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tambah_Pengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tambah_Pengguna dialog = new Tambah_Pengguna(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private com.fathan.swing.jcombobox.Combobox combobox1;
    private javax.swing.JTextField field_ip;
    private javax.swing.JTextField field_nl;
    private javax.swing.JTextField field_us;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel label_success;
    private javax.swing.JLabel label_warning_ip;
    private javax.swing.JLabel label_warning_nl;
    private javax.swing.JLabel label_warning_us;
    private javax.swing.JLabel label_warning_us1;
    private com.fathan.swing.PanelBordeer panelBordeer1;
    private com.fathan.swing.PanelBordeer panelBordeer2;
    private com.fathan.swing.PanelBordeer panelBordeer3;
    private com.fathan.swing.PanelBordeer panelBordeer4;
    private com.fathan.swing.RadioButtonCustom radioButtonCustom1;
    private com.fathan.swing.RadioButtonCustom radioButtonCustom2;
    // End of variables declaration//GEN-END:variables
}
