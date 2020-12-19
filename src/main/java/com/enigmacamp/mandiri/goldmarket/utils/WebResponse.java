package com.enigmacamp.mandiri.goldmarket.utils;

import org.springframework.http.HttpStatus;

public class WebResponse<T> {

    private ResponseStatus status;
    private T data;

    public WebResponse(T data, ResponseStatus status) {
        this.status = status;
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
