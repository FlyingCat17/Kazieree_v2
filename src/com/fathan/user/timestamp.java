/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.user;

import java.util.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Fathan
 */
public class timestamp {

    public static void main(String[] args) {
        int angka = 200000;
        String ganti = NumberFormat.getNumberInstance(Locale.US).format(angka);
        System.out.println("Rp"+ganti);
    }
}
