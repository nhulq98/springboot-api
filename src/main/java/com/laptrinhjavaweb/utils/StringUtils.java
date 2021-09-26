package com.laptrinhjavaweb.utils;

public class StringUtils {
    public static boolean isNullOrEmpty(Object value){
        if(value == null || value.equals("")){
            return true;
        }
        return false;
    }

    public static boolean isNull(Object value) {
        if(value == null) {
            return true;
        }
        return false;
    }

    public static boolean isBlank(Object value) {
        if(value instanceof String && value == "") {
            return true;
        }
        return false;
    }
}
