package com.enigmacamp.mandiri.goldmarket.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Services<T> {
    void create(T entity);
    void update(T entity);
    void delete(String id);
    T get(String id);
    Page<T> list(Pageable pager);
}
