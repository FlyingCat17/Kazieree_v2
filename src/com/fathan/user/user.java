/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.user;

/**
 *
 * @author Fathan
 */
public class user {
    public static String nama;
    public static String id_pengguna;
    public static String role;
    public static String nama_lengkap;
    
    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        user.nama = nama;
    }

    public static String getId_pengguna() {
        return id_pengguna;
    }

    public static void setId_pengguna(String id_pengguna) {
        user.id_pengguna = id_pengguna;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        user.role = role;
    }
    
    public static String getNama_lengkap(){
        return nama_lengkap;
    }
    
    public static void setNama_Lengkap(String nama_lengkap){
        user.nama_lengkap = nama_lengkap;
    }
}
