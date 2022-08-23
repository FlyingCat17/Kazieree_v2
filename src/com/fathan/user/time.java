/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.user;

import com.fathan.db.configdb;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Fathan
 */
public class time {
    public void timee(){
        DateFormat vblnth = new SimpleDateFormat("yyyyMMdd");
        String blnth = vblnth.format(Calendar.getInstance().getTime());

        DateFormat hari = new SimpleDateFormat("yyyy-MM-dd");
        String a = hari.format(Calendar.getInstance().getTime());
//        try {
//            String sql = "SELECT MAX(right(id_transaksi,6)) AS Kode_Pinjam "
//                    + "FROM tb_jual Where tgl_transaksi like '" + a + "';";
//            java.sql.Connection con = (java.sql.Connection) konekdb.GetConnection();
//            java.sql.Statement pst = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            java.sql.ResultSet rs = pst.executeQuery(sql);
//            while (rs.next()) {
//                if (rs.last()) {
//                    int auto_id = rs.getInt(1) + 1;
//                    String no = String.valueOf(auto_id);
//                    int NomorJual = no.length();
//                    //MENGATUR jumlah 0
//                    for (int j = 0; j < 6 - NomorJual; j++) {
//                        no = "0" + no;
//                    }
//                    txt_idTransaksii.setText("TJ/" + blnth + "/" + no);
//                    System.out.println("TJ/" + blnth + "/" + no);
//                    txt_tanggal.setText(a);
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("ERROR " + e.getMessage());
//        }
    }
    
    public static void main(String[] args) {
        
    }
}
