package com.enigmacamp.mandiri.goldmarket.utils;

import org.springframework.http.HttpStatus;

public class WebResponse<T> {

    int code;
    HttpStatus status;
    T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
