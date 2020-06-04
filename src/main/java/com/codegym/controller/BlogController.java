package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.Blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Blog> blogList = blogService.findAll();
        modelAndView.addObject("bloglist", blogList);
        return modelAndView;
    }

    @GetMapping("Blog/{id}/edit")
    public ModelAndView showEdit(@ModelAttribute Blog blog, @PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Blog blog1 = blogService.findGetById(id);
        modelAndView.addObject("blog", blog1);
        return modelAndView;
    }

    @PostMapping("edit")
    public ModelAndView edit(@ModelAttribute Blog blog) {
        ModelAndView modelAndView = new ModelAndView("home");
        blogService.update(blog);
        modelAndView.addObject("bloglist", blogService.findAll());
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("Blog", new Blog());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView create(@ModelAttribute Blog blog) {
        ModelAndView modelAndView = new ModelAndView("home");
        blogService.insert(blog);
        modelAndView.addObject("bloglist", blogService.findAll());
        return modelAndView;
    }

    @GetMapping("Blog/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("home");
        blogService.remove(id);
        modelAndView.addObject("bloglist", blogService.findAll());
        return modelAndView;
    }
}
