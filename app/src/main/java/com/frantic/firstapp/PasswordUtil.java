package com.frantic.firstapp;

public class PasswordUtil {
    public static boolean isStrongPassword(String value){

        if(value.length() < 7)return false;
        if(value.matches(".*[A-Z]*"))return false;
        if(value.matches(""))return false;

        return true;
    }
}
