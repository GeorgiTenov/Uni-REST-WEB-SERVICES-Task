package com.unitask.UNI_WEB_SERVICES.interfaces;

import java.util.List;

public interface MyService<T> {
    List<T> findAll();
    T findById(Long id);
    void create(T entity);
    void delete(Long id);
    void update(Long id, T entity);
}
