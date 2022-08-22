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
    public static boolean kategori = false;
    public static String nama_produk = null;

    public static void setNama_produk(String nama_produk) {
        getdatabarang.nama_produk = nama_produk;
    }

    public static String getNama_produk() {
        return nama_produk;
    }

    public static boolean getKategori() {
        return kategori;
    }

    public static void setKategori(boolean kategori) {
        getdatabarang.kategori = kategori;
    }

    public static String getKode_produk() {
        return kode_produk;
    }

    public static void setKode_produk(String kode_produk) {
        getdatabarang.kode_produk = kode_produk;
    }

}
