package com.edu.miu.eaproject.apiservice.proxy;

import com.edu.miu.eaproject.apiservice.domain.Comments;
import com.edu.miu.eaproject.apiservice.util.RestURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import org.springframework.stereotype.Service;

@RestController
public class CommentServiceProxy {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/comments")
    public List<Comments> getComments() {
        System.out.println("INSIDE GET COMMENTS 1");

        ResponseEntity<List<Comments>> response =
                restTemplate.exchange(RestURL.commentsURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Comments>>() {});

        System.out.println("INSIDE GET COMMENTS 2");
        System.out.println(response.getBody());

        return response.getBody();
    }

    @GetMapping("/comments/{id}")
    public Comments getComment(@PathVariable Long id){
        return restTemplate.getForObject(RestURL.commentURL, Comments.class, id);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<Comments> getPostComments(@PathVariable Long postId){
        ResponseEntity<List<Comments>> response =
                restTemplate.exchange("http://localhost:8083/posts/" + postId + "/comments", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Comments>>() {});

        return response.getBody();
    }

    @GetMapping("users/{userId}/comments")
    public List<Comments> getUserComments(@PathVariable Long userId){
        System.out.println("localhost:8083/users/" + userId + "/comments");
        ResponseEntity<List<Comments>> response =
                restTemplate.exchange("http://localhost:8083/users/" + userId + "/comments", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Comments>>() {});

        return response.getBody();
    }

    @PostMapping("/comments")
    public void add(@RequestBody Comments comment){
        restTemplate.postForEntity(RestURL.commentsURL, comment, Comments.class);
    }

    @PutMapping("/comments/{id}")
    public void update(@PathVariable Long id, @RequestBody Comments comment){
        restTemplate.put(RestURL.commentsURL + id, comment);
    }

    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable Long id){
        restTemplate.delete(RestURL.commentsURL + id);
    }
}
