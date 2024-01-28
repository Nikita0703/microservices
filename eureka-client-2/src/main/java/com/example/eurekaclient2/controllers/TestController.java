package com.example.eurekaclient2.controllers;

import com.example.eurekaclient2.dto.Post;
import com.example.eurekaclient2.services.PostService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/posts")
@RequiredArgsConstructor
public class TestController {

    private final PostService postService;


    @GetMapping
    @CircuitBreaker(name = "randomActivity",fallbackMethod = "fallbackRandom")
    public ResponseEntity<List<Post>> getAll(){
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/test-test")
    public String test() {
        return "test-test";
    }

    public String fallbackRandom(Throwable t){
        return "Something goes wrong";
    }
}
