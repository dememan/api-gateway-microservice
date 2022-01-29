package com.edu.miu.eaproject.apiservice.proxy;

import com.edu.miu.eaproject.apiservice.domain.Comments;
import com.edu.miu.eaproject.apiservice.domain.Post;
import com.edu.miu.eaproject.apiservice.util.RestURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostServiceProxy {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public List<Post> getPosts(Long id) {
        ResponseEntity<List<Post>> response =
                restTemplate.exchange(RestURL.postsURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Post>>() {});
        return response.getBody();
    }
    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id) {

        return restTemplate.getForObject(RestURL.postUrl, Post.class, id);
    }

    @GetMapping("/{id}/comments")
    public List<Comments> getPostComments(@PathVariable Long id) {

        ResponseEntity<List<Comments>> response =
                restTemplate.exchange(RestURL.postsURL + id + "/comments", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Comments>>() {
                        });
        return response.getBody();
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return restTemplate.postForObject(RestURL.postsURL,post,Post.class);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Post post,@PathVariable Long id ) {
        post.setId(id);
        restTemplate.put(RestURL.postUrl,post,id);
    }
    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Long id){
        restTemplate.delete(RestURL.postUrl,id);
    }

}
