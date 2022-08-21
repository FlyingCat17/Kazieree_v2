/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.produk;

import com.fathan.db.configdb;
import java.sql.Connection;

/**
 *
 * @author Fathan
 */
public class getdatabarang {

    public static String kode_produk = null;

    public static String getKode_produk() {
        return kode_produk;
    }

    public static void setKode_produk(String kode_produk) {
        getdatabarang.kode_produk = kode_produk;
    }

    
}
