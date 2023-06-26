package com.nisum.api.utils;


import com.nisum.api.enums.ErrorEnumInterface;


public class Utils {

    public static String createErrorMessageWithValue(ErrorEnumInterface userErrorEnum, Object id){
        return String.format(userErrorEnum.getMessage(), id);
    }
}
