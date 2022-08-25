
package com.fathan.form.transaksibeli;

import com.fathan.db.configdb;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Fathan
 */
public class option_hapus extends javax.swing.JDialog {

    /**
     * Creates new form Tambah_Produk
     */
    public option_hapus(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        System.out.println("Kode produk :  " + new com.fathan.form.transaksijual.getKode_Produk().getKode_produk());

    }

//    public void setNamaProduk() {
//        jLabel4.setText("Produk : " + new com.fathan.form.produk.getdatabarang().getNama_produk());
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button2 = new com.fathan.form.produk.Button();
        button1 = new com.fathan.form.produk.Button();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 179, 200)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button2.setForeground(new java.awt.Color(255, 0, 0));
        button2.setText("Hapus");
        button2.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 90, 30));

        button1.setForeground(new java.awt.Color(51, 51, 51));
        button1.setText("Batal");
        button1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 90, 30));

        jLabel3.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Yakin Ingin Menghapus Data Produk Ini?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 490, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/produk/icon_ask.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 490, 120));

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fathan/form/produk/bg_OptionPane.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 500, 150));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 320));

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

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        for (double i = 1.0; i >= 0.1; i = i - 0.2) {
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
        try {
            String sql = "DELETE FROM temp_beli WHERE temp_beli.kode_produk = '" + new com.fathan.form.transaksibeli.getKode_Produk().getKode_produk() + "'";
            java.sql.Connection con = (Connection) configdb.GetConnection();
            java.sql.Statement st = con.createStatement();
            st.execute(sql);
            JOptionPane.showMessageDialog(this, "Berhasil Hapus : " + new com.fathan.form.transaksibeli.getKode_Produk().getKode_produk());
            for (double i = 1.0; i >= 0.1; i = i - 0.2) {
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
            new com.fathan.form.transaksibeli.option_hapus_yes(new com.fathan.form.transaksibeli.transaksi_beli(), true).setVisible(true);
            new com.fathan.form.transaksibeli.getKode_Produk().setOpsi_hapus_yes(true);
        } catch (Exception e) {
            System.err.println("GAGAL HAPUS : " + e.getMessage());
        }
    }//GEN-LAST:event_button2ActionPerformed

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
            java.util.logging.Logger.getLogger(option_hapus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(option_hapus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(option_hapus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(option_hapus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                option_hapus dialog = new option_hapus(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
