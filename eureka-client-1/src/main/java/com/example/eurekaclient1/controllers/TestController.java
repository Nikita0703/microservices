package com.example.eurekaclient1.controllers;

import com.example.eurekaclient1.dto.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/posts")
public class TestController {

    private List<Post> posts = new ArrayList<>();

    private int id =0 ;

    {
        posts.add(new Post(++id,"Fiest Podt","First Description",false));
        posts.add(new Post(++id,"Second Podt","Second Description",false));
        posts.add(new Post(++id,"Third Podt","THird Description",false));
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAll(){
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post){
        post.setId(++id);
        posts.add(post);
        return ResponseEntity.ok(post);
    }
}
