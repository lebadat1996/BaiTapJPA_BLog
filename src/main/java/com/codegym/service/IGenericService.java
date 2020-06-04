package com.codegym.service;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();

    T findGetById(Long id);

    void update(T model);

    void insert(T model);

    void remove(Long id);
}
