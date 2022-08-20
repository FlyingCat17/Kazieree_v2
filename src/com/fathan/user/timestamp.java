/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.user;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
/**
 *
 * @author Fathan
 */
public class timestamp {
    public static void main(String[] args) {
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(today));
    }
}
