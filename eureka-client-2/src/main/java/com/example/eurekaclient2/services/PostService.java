package com.example.eurekaclient2.services;

import com.example.eurekaclient2.dto.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private String firstHost = "http://localhost:8082/eureka-client-1/api/posts";

    private final RestTemplate restTemplate;

    public List<Post> getAllPostByFirst(){
        ResponseEntity<List<Post>> responseEntity=
                restTemplate.exchange(firstHost, HttpMethod.GET, null,
                   new ParameterizedTypeReference<List<Post>>() {
             });
        return responseEntity.getBody();
    }

    public List<Post> getAll(){
        List<Post> postsFromFirst = getAllPostByFirst();
        List<Post> posts = new ArrayList<>();
        for (Post post:postsFromFirst){
            for(Post post1:postsFromFirst){
                if(post.getTitle().equals(post1.getTitle()))
                    break;
            }
            post.setCheked(true);
            posts.add(post);
        }
        return posts;
    }
}
