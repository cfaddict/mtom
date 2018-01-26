package com.therealdanvega.mtom.controller;

import com.therealdanvega.mtom.domain.Post;
import com.therealdanvega.mtom.domain.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public List<Post> list() {
        return postRepository.findAll();
    }
}
