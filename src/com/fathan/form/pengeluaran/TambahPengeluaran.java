/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.pengeluaran;

import com.fathan.db.configdb;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Fathan
 */
public class TambahPengeluaran extends javax.swing.JDialog {

    String tgl;

    public TambahPengeluaran(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        jTextField2.requestFocus();
        getDate();
        label_warning_ket.setVisible(false);
        label_warning_nominal.setVisible(false);
    }

    public void getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        jLabel4.setText(sdf.format(now));
        setTgl(df.format(now));
        System.out.println("Inputing Date : " + getTgl());
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }
    com.fathan.user.user usr = new com.fathan.user.user();

    public void addPengeluaran() {
        try {
            String sql = "INSERT INTO `pengeluaran`(`id_pengeluaran`, `tgl_pengeluaran`, `id_pengguna`, `jumlah_pengeluaran`, `keterangan`, `id_cashbox`) "
                    + "VALUES (NULL,'" + getTgl() + "','" + usr.getId_pengguna() + "','" + jTextField2.getText() + "','" + jTextField1.getText() + "','1')";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            st.execute(sql);
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
        } catch (Exception e) {
            System.err.println("Add Pengeluaran : "+e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new main.PanelShadow();
        jLabel1 = new javax.swing.JLabel();
        panelRound2 = new com.fathan.swing.PanelRound();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panelRound1 = new com.fathan.swing.PanelRound();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        label_warning_nominal = new javax.swing.JLabel();
        label_warning_ket = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelShadow3 = new main.PanelShadow();
        jLabel8 = new javax.swing.JLabel();
        panelShadow2 = new main.PanelShadow();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(19, 179, 200));
        jLabel1.setText("Tambah Pengeluaran");
        panelShadow1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 47, -1, -1));

        panelRound2.setBackground(new java.awt.Color(229, 229, 229));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setBackground(new java.awt.Color(229, 229, 229));
        jTextField2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        panelRound2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 0, 330, 60));

        jLabel2.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Rp");
        panelRound2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 60));

        panelShadow1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 270, 408, -1));

        panelRound1.setBackground(new java.awt.Color(229, 229, 229));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(229, 229, 229));
        jTextField1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 13)); // NOI18N
        jTextField1.setText("Pengeluaran");
        jTextField1.setBorder(null);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        panelRound1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 0, 352, 36));

        panelShadow1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 188, 408, -1));

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Tanggal");
        panelShadow1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 95, 71, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        jLabel4.setText("30-08-2022");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelShadow1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 118, 186, -1));

        label_warning_nominal.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_nominal.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_nominal.setText("Nominal Tidak Boleh Kosong !");
        panelShadow1.add(label_warning_nominal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 270, 30));

        label_warning_ket.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        label_warning_ket.setForeground(new java.awt.Color(255, 51, 51));
        label_warning_ket.setText("Keterangan Tidak Boleh Kosong !");
        panelShadow1.add(label_warning_ket, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 270, 30));

        jLabel6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Nominal");
        panelShadow1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 248, 209, 20));

        panelShadow3.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(19, 179, 200));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("BATAL");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        panelShadow3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 10, 100, 20));

        panelShadow1.add(panelShadow3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 110, 40));

        panelShadow2.setBackground(new java.awt.Color(19, 179, 200));
        panelShadow2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SIMPAN");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        panelShadow2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 10, 100, 20));

        panelShadow1.add(panelShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 110, 40));

        jLabel9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Keterangan");
        panelShadow1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 165, 209, -1));

        getContentPane().add(panelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 506, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        if (jTextField2.isEditable()) {
            label_warning_nominal.setVisible(false);
        }
        char k = evt.getKeyChar();
        if (!(Character.isDigit(k) || k == KeyEvent.VK_BACK_SPACE || k == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (jTextField2.getText().length() >= 12) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            System.out.println("Disabled");
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        if (jTextField1.isEditable()) {
            label_warning_ket.setVisible(false);
        }
        if (jTextField2.getText().length() >= 80) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            System.out.println("Disabled");
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
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
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        if (jTextField1.getText().equals("")) {
            label_warning_ket.setVisible(true);
            label_warning_ket.requestFocus();
        } else if(jTextField2.getText().equals("")){
            label_warning_nominal.setVisible(true);
            label_warning_nominal.requestFocus();
        } else {
            addPengeluaran();
        }
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(TambahPengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahPengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahPengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahPengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TambahPengeluaran dialog = new TambahPengeluaran(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel label_warning_ket;
    private javax.swing.JLabel label_warning_nominal;
    private com.fathan.swing.PanelRound panelRound1;
    private com.fathan.swing.PanelRound panelRound2;
    private main.PanelShadow panelShadow1;
    private main.PanelShadow panelShadow2;
    private main.PanelShadow panelShadow3;
    // End of variables declaration//GEN-END:variables
}
