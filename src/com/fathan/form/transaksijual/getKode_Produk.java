/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.transaksijual;

/**
 *
 * @author Fathan
 */
public class getKode_Produk {

    public static String kode_produk = null;
    public static String nama_produk = null;
    public static boolean opsi_hapus_yes = false;
    public static String kode_transaksi = null;

    public static boolean isOpsi_hapus_yes() {
        return opsi_hapus_yes;
    }

    public static void setOpsi_hapus_yes(boolean opsi_hapus_yes) {
        getKode_Produk.opsi_hapus_yes = opsi_hapus_yes;
    }

    public static String getKode_transaksi() {
        return kode_transaksi;
    }

    public static void setKode_transaksi(String kode_transaksi) {
        getKode_Produk.kode_transaksi = kode_transaksi;
    }

    public static String getNama_produk() {
        return nama_produk;
    }

    public static void setNama_produk(String nama_produk) {
        getKode_Produk.nama_produk = nama_produk;
    }

    public static String getKode_produk() {
        return kode_produk;
    }

    public static void setKode_produk(String kode_produk) {
        getKode_Produk.kode_produk = kode_produk;
    }

}
