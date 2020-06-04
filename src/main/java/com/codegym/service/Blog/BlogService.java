package com.codegym.service.Blog;

import com.codegym.model.Blog;
import com.codegym.repository.Blog.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findGetById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void update(Blog model) {
        blogRepository.update(model);
    }

    @Override
    public void insert(Blog model) {
        blogRepository.insert(model);
    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }
}
