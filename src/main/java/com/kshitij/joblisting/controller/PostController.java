package com.kshitij.joblisting.controller;

import com.kshitij.joblisting.repository.PostRepository;
import com.kshitij.joblisting.model.Post;
import com.kshitij.joblisting.repository.SearchRepository;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepository srepo;
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post>search(@PathVariable String text) {
        System.out.println("Searching for: " + text);
        return srepo.findByText(text);
    }
    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }
}
