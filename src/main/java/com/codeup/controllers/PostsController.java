package com.codeup.controllers;

import com.codeup.Post;
import com.codeup.Posts;
import com.codeup.User;
import com.fasterxml.jackson.databind.deser.Deserializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by jessedavila on 1/5/17.
 */
@Controller
@RequestMapping("/posts")
public class PostsController extends BaseController {

    @Autowired
    Posts postsDao;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/create")
    public String createNewPost(
            @Valid Post post,
            Errors validation,
            Model model
    ) {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }
        post.setUser(loggedInUser());
        postsDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(Model m, @PathVariable long id) {
        m.addAttribute("post", postsDao.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String showEditForm(@Valid Post editedPost, @PathVariable long id, Errors validation, Model m) {

        if (validation.hasErrors()) {
            m.addAttribute("errors", validation);
            m.addAttribute("post", editedPost);
            return "posts/edit";
        }

        Post existingPost = postsDao.findOne(id);

        if (existingPost.getUser().getId().equals(loggedInUser().getId())) {
            return "redirect:/posts";
        }
        existingPost.setTitle(editedPost.getTitle());
        existingPost.setBody(editedPost.getBody());
        postsDao.save(existingPost);
        return "redirect:/posts/" + existingPost.getId();
    }

    @GetMapping("/{id}")
    public String showPost(Model m, @PathVariable long id) {
        Post existingPost = postsDao.findOne(id);
        m.addAttribute("post", existingPost);

        return "posts/show";
    }

    @GetMapping("/{id}/delete")
    public String deletePost(@PathVariable long id) {
        Post existingPost = postsDao.findOne(id);
        postsDao.delete(existingPost);
        return "redirect:/posts";
    }

}
