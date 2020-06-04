package com.codegym.repository;

import com.codegym.model.Blog;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void update(T model);

    void remove(Long id);

    void insert(Blog blog);
}
