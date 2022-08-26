/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.pengguna;

/**
 *
 * @author Fathan
 */
public class getPengguna {

    public static String id_pengguna, nama_pengguna = null;

    public static String getNama_pengguna() {
        return nama_pengguna;
    }

    public static void setNama_pengguna(String nama_pengguna) {
        getPengguna.nama_pengguna = nama_pengguna;
    }

    public static String getId_pengguna() {
        return id_pengguna;
    }

    public static void setId_pengguna(String id_pengguna) {
        getPengguna.id_pengguna = id_pengguna;
    }

}
