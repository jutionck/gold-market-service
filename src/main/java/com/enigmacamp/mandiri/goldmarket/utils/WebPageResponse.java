package com.enigmacamp.mandiri.goldmarket.utils;

import java.util.List;

public class WebPageResponse<T> {

    private ResponseStatus status;
    private List<T> data;
    private ResponsePage page;

    public WebPageResponse(List<T> data, ResponseStatus status, ResponsePage page) {
        this.status = status;
        this.data = data;
        this.page = page;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public ResponsePage getPage() {
        return page;
    }

    public void setPage(ResponsePage page) {
        this.page = page;
    }
}
