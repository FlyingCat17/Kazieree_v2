/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.about.ubahAkun;

import com.fathan.db.configdb;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Fathan
 */
public class ubahAkun extends javax.swing.JDialog {

    /**
     * Creates new form lainnya
     */
    public ubahAkun(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        jLabel10.setText(new com.fathan.user.user().getRole().toUpperCase());
        jLabel1.setText(new com.fathan.user.user().getId_pengguna());
        jLabel2.setText(new com.fathan.user.user().getNama());
        jLabel3.setText(new com.fathan.user.user().getNama_lengkap());
    }

    com.fathan.user.user usr = new com.fathan.user.user();
    public void getDataUser() {
        try {
            String sql = "SELECT pengguna.id_pengguna, pengguna.nama_pengguna, detail_pengguna.nama_lengkap, detail_pengguna.jenis_kelamin, detail_pengguna.no_telepon, detail_pengguna.alamat\n"
                    + "FROM pengguna JOIN detail_pengguna ON pengguna.id_pengguna = detail_pengguna.id_pengguna\n"
                    + "WHERE pengguna.id_pengguna = '"+usr.getId_pengguna()+"'";
            java.sql.Connection con = (Connection)configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelShadow1 = new main.PanelShadow();
        jLabel11 = new javax.swing.JLabel();
        panelBordeer4 = new com.fathan.swing.PanelBordeer();
        field_ip2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelShadow4 = new main.PanelShadow();
        button4 = new com.fathan.form.about.Button();
        panelShadow3 = new main.PanelShadow();
        button3 = new com.fathan.form.about.Button();
        panelShadow2 = new main.PanelShadow();
        button2 = new com.fathan.form.about.Button();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelBordeer2 = new com.fathan.swing.PanelBordeer();
        field_ip = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelBordeer3 = new com.fathan.swing.PanelBordeer();
        field_ip1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        radioButtonCustom2 = new com.fathan.swing.RadioButtonCustom();
        radioButtonCustom1 = new com.fathan.swing.RadioButtonCustom();
        jLabel12 = new javax.swing.JLabel();
        panelBordeer7 = new com.fathan.swing.PanelBordeer();
        jScrollPane1 = new javax.swing.JScrollPane();
        field_a = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Montserrat Medium", 0, 13)); // NOI18N
        jLabel11.setText("Nomor Telepon");
        panelShadow1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 250, 20));

        panelBordeer4.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer4.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_ip2.setBackground(new java.awt.Color(226, 226, 226));
        field_ip2.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_ip2.setBorder(null);
        field_ip2.setEnabled(false);
        field_ip2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_ip2ActionPerformed(evt);
            }
        });
        field_ip2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_ip2KeyTyped(evt);
            }
        });
        panelBordeer4.add(field_ip2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 370, 40));

        panelShadow1.add(panelBordeer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 390, 40));

        jLabel10.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("ADMIN");
        panelShadow1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 40, 270, 30));

        jLabel3.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fathan Maulana");
        panelShadow1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 510, 30));

        jLabel2.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("fthnmrh");
        panelShadow1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 510, 20));

        jLabel1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("A00001");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelShadow1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 90, 30));

        panelShadow4.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button4.setForeground(new java.awt.Color(19, 179, 200));
        button4.setText("UBAH AKUN");
        button4.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 13)); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        panelShadow4.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 30));

        panelShadow1.add(panelShadow4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 250, 50));

        panelShadow3.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button3.setForeground(new java.awt.Color(19, 179, 200));
        button3.setText("BATAL");
        button3.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 13)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        panelShadow3.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 30));

        panelShadow1.add(panelShadow3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 200, 50));

        panelShadow2.setBackground(new java.awt.Color(19, 179, 200));
        panelShadow2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button2.setBackground(new java.awt.Color(19, 179, 200));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("SIMPAN");
        button2.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 13)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panelShadow2.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 30));

        panelShadow1.add(panelShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 190, 50));

        jLabel5.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("UBAH DETAIL AKUN");
        panelShadow1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 260, 50));

        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 0, 13)); // NOI18N
        jLabel6.setText("Username / Nama Pengguna");
        panelShadow1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 147, 250, 20));

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

        panelShadow1.add(panelBordeer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 390, 40));

        jLabel7.setFont(new java.awt.Font("Montserrat Medium", 0, 13)); // NOI18N
        jLabel7.setText("ID Pengguna");
        panelShadow1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 87, -1, -1));

        jLabel8.setFont(new java.awt.Font("Montserrat Medium", 0, 13)); // NOI18N
        jLabel8.setText("Jenis Kelamin   : ");
        panelShadow1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 130, 30));

        panelBordeer3.setBackground(new java.awt.Color(255, 255, 255));
        panelBordeer3.setForeground(new java.awt.Color(226, 226, 226));
        panelBordeer3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        field_ip1.setBackground(new java.awt.Color(226, 226, 226));
        field_ip1.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        field_ip1.setBorder(null);
        field_ip1.setEnabled(false);
        field_ip1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_ip1ActionPerformed(evt);
            }
        });
        field_ip1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_ip1KeyTyped(evt);
            }
        });
        panelBordeer3.add(field_ip1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 370, 40));

        panelShadow1.add(panelBordeer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 390, 40));

        jLabel9.setFont(new java.awt.Font("Montserrat Medium", 0, 13)); // NOI18N
        jLabel9.setText("Nama Lengkap");
        panelShadow1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 250, 20));

        buttonGroup1.add(radioButtonCustom2);
        radioButtonCustom2.setText("Laki-Laki");
        radioButtonCustom2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        radioButtonCustom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonCustom2ActionPerformed(evt);
            }
        });
        panelShadow1.add(radioButtonCustom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, 30));

        buttonGroup1.add(radioButtonCustom1);
        radioButtonCustom1.setText("Perempuan");
        radioButtonCustom1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        radioButtonCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonCustom1ActionPerformed(evt);
            }
        });
        panelShadow1.add(radioButtonCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, -1, 30));

        jLabel12.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Alamat");
        panelShadow1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 100, -1));

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

        panelShadow1.add(panelBordeer7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 390, 130));

        getContentPane().add(panelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 520));

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
                System.err.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_formWindowOpened


    public void stampLog_out() {
        try {
            String sql = "SELECT * FROM `pengguna` WHERE nama_pengguna = '" + usr.getNama() + "';";
            Connection con = (Connection) configdb.GetConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                if (rs.getString("role").equals("admin")) {
                    try {
                        Date today = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        String stampLoginAdmin = "INSERT INTO `log_pengguna`(`no_log`, `id_pengguna`, `nama_pengguna`, `role`, `stamp`, `tipe`) "
                                + "VALUES (NULL, '" + usr.getId_pengguna() + "','" + usr.getNama() + "','" + usr.getRole() + "','" + sdf.format(today) + "','Keluar')";
                        Connection con1 = (Connection) configdb.GetConnection();
                        Statement st1 = con1.createStatement();
                        st1.execute(stampLoginAdmin);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        new com.fathan.form.about.logout().setLog_out(true);
        for (double i = 1.0; i >= 0.1; i = i - 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            System.out.println(f);
            try {
                Thread.sleep(1);
                if (this.getOpacity() <= 0.25) {
                    this.dispose();
                    for (double i1 = 1.0; i >= 0.1; i = i - 0.25) {
                        String val1 = i + "";
                        float f1 = Float.valueOf(val1);
                        new com.fathan.form.beranda.beranda().setOpacity(f1);
                        System.out.println(f1);
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        stampLog_out();
        new com.fathan.main.login().setVisible(true);
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
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
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button4ActionPerformed

    private void field_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_ipActionPerformed

    private void field_ipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_ipKeyTyped
        

    }//GEN-LAST:event_field_ipKeyTyped

    private void field_ip1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_ip1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_ip1ActionPerformed

    private void field_ip1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_ip1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_field_ip1KeyTyped

    private void radioButtonCustom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonCustom2ActionPerformed
//        label_jk.setVisible(false);
    }//GEN-LAST:event_radioButtonCustom2ActionPerformed

    private void radioButtonCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonCustom1ActionPerformed
//        label_jk.setVisible(false);
    }//GEN-LAST:event_radioButtonCustom1ActionPerformed

    private void field_ip2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_ip2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_ip2ActionPerformed

    private void field_ip2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_ip2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_field_ip2KeyTyped

    private void field_aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_aKeyTyped
        if (field_a.getText().length() >= 120) {
            evt.consume();
        }
    }//GEN-LAST:event_field_aKeyTyped

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
            java.util.logging.Logger.getLogger(ubahAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ubahAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ubahAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ubahAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ubahAkun dialog = new ubahAkun(new javax.swing.JFrame(), true);
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
    private com.fathan.form.about.Button button2;
    private com.fathan.form.about.Button button3;
    private com.fathan.form.about.Button button4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea field_a;
    private javax.swing.JTextField field_ip;
    private javax.swing.JTextField field_ip1;
    private javax.swing.JTextField field_ip2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.fathan.swing.PanelBordeer panelBordeer2;
    private com.fathan.swing.PanelBordeer panelBordeer3;
    private com.fathan.swing.PanelBordeer panelBordeer4;
    private com.fathan.swing.PanelBordeer panelBordeer7;
    private main.PanelShadow panelShadow1;
    private main.PanelShadow panelShadow2;
    private main.PanelShadow panelShadow3;
    private main.PanelShadow panelShadow4;
    private com.fathan.swing.RadioButtonCustom radioButtonCustom1;
    private com.fathan.swing.RadioButtonCustom radioButtonCustom2;
    // End of variables declaration//GEN-END:variables
}
