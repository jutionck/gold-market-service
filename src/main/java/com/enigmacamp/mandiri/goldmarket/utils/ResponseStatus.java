package com.enigmacamp.mandiri.goldmarket.utils;

import org.springframework.http.HttpStatus;

public class ResponseStatus {

    private int code = HttpStatus.OK.value();
    private String message = "OK";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
