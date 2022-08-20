/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.user;

import com.fathan.db.configdb;
import java.sql.Connection;

/**
 *
 * @author Fathan
 */
public class truncate {

    public static void main(String[] args) {
        try {
            String tr = "TRUNCATE TABLE log_pengguna;";
            java.sql.Connection con = (Connection)configdb. GetConnection();
            java.sql.Statement st = con.createStatement();
            st.execute(tr);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
