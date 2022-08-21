/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathan.form.about;

/**
 *
 * @author Fathan
 */
public class logout {
    public static boolean yn = false;
    
    public static boolean getStatusLog_Out(){
        return yn;
    }
    public static void setLog_out(boolean yn){
        logout.yn = yn;
    }
}
