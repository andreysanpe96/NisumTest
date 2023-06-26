package com.nisum.api.enums.user;


import com.nisum.api.enums.ErrorEnumInterface;

public enum UserErrorEnum implements ErrorEnumInterface {

    EMAIL_ALREADY_EXISTS("Email '%s' already exists");

    private final String message;

    UserErrorEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
