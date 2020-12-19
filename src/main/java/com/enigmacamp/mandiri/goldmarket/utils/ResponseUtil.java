package com.enigmacamp.mandiri.goldmarket.utils;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil<T> {

    private final ResponseStatus responseStatus;
    private final ResponsePage responsePage;

    public ResponseUtil() {
        responseStatus = new ResponseStatus();
        responsePage = new ResponsePage();
    }

    private void setResponsePage(Page<T> pagedData) {
        responsePage.setPage(pagedData.getNumber() + 1);
        responsePage.setRows(pagedData.getSize());
        responsePage.setTotalPages(pagedData.getTotalPages());
        responsePage.setTotalRows(pagedData.getTotalElements());
    }

    private void setResponseStatus(HttpStatus status, String message) {
        responseStatus.setCode(status.value());
        responseStatus.setMessage(message);
    }

    public ResponseEntity<WebResponse<T>> build(T data) {
        setResponseStatus(HttpStatus.OK, HttpStatus.OK.getReasonPhrase());
        WebResponse<T> body = new WebResponse<>(data, responseStatus);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public ResponseEntity<WebResponse<T>> build(T data, HttpStatus status, String message) {
        setResponseStatus(status, message);
        WebResponse<T> body = new WebResponse<>(data, responseStatus);
        return ResponseEntity.status(status).body(body);
    }

    public ResponseEntity<WebPageResponse<T>> build(Page<T> pagedData) {
        setResponseStatus(HttpStatus.OK, HttpStatus.OK.getReasonPhrase());
        setResponsePage(pagedData);
        WebPageResponse<T> body = new WebPageResponse<>(pagedData.getContent(), responseStatus, responsePage);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public ResponseEntity<WebPageResponse<T>> build(Page<T> pagedData, HttpStatus status, String message) {
        setResponseStatus(status, message);
        setResponsePage(pagedData);
        WebPageResponse<T> body = new WebPageResponse<>(pagedData.getContent(), responseStatus, responsePage);
        return ResponseEntity.status(status).body(body);
    }
}
