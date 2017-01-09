package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by jessedavila on 1/5/17.
 */
@Controller
@RequestMapping("/posts")
public class PostsController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("posts", DaoFactory.getPostsDao().all());
        return "posts/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/create")
    public String createNewPost(@ModelAttribute Post post) {
        DaoFactory.getPostsDao().save(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(Model m, @PathVariable long id) {
        Post post = DaoFactory.getPostsDao().find(id);
        m.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String showEditForm(@ModelAttribute Post editedPost, @PathVariable long id) {
        Post existingPost = DaoFactory.getPostsDao().find(id);
        String newTitle = editedPost.getTitle();
        String newBody = editedPost.getBody();
        existingPost.setTitle(newTitle);
        existingPost.setBody(newBody);
        DaoFactory.getPostsDao().update(existingPost);
        return "redirect:/posts/"+existingPost.getId();
        // find record in db with id
        //update fields
        //update record in db
    }

    @GetMapping("/{id}")
    public String ShowPost (Model m, @PathVariable long id) {
        Post post = DaoFactory.getPostsDao().find(id);
        m.addAttribute("post", post);
        return "posts/show";
    }

    @PostMapping("/{id}")
    public String DeletePost () {
        return "posts/show";
    }

}
