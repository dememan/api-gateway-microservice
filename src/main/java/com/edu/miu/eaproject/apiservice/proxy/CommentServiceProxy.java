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
@RequestMapping("/api/comments")
public class CommentServiceProxy {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public List<Comments> getComments() {

        ResponseEntity<List<Comments>> response =
                restTemplate.exchange(RestURL.commentsURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Comments>>() {
                        });
        return response.getBody();
    }

    @GetMapping("/{id}")
    public Comments getComment(@PathVariable Long id) {
        return restTemplate.getForObject(RestURL.commentURL, Comments.class, id);
    }

    @PostMapping()
    public void add(@RequestBody Comments comment) {
        restTemplate.postForEntity(RestURL.commentsURL, comment, Comments.class);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Comments comment) {
        comment.setId(id);
        restTemplate.put(RestURL.commentsURL + id, comment,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        restTemplate.delete(RestURL.commentsURL + id);
    }


}
