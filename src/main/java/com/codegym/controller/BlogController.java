package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.Blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("list")
    public ResponseEntity<List<Blog>> showList() {
        List<Blog> blogList = blogService.findAll();
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        blogService.update(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("blog/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Long id) {
        Blog blog = blogService.findGetById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable Long id) {
        Blog blog = blogService.findGetById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blogService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
