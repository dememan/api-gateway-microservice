package com.edu.miu.eaproject.apiservice.proxy;

import com.edu.miu.eaproject.apiservice.domain.Comments;
import com.edu.miu.eaproject.apiservice.domain.Post;
import com.edu.miu.eaproject.apiservice.domain.Users;
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
//    public Post get(Long postid) {
//
//        return restTemplate.getForObject(RestURL.postUrl, Post.class, postid);
//    }
//
//    @GetMapping
//    public List<Users> findAll() {
//
//        return null;
//    }
//
//    @GetMapping("/{id}")
//    public Users getById(@PathVariable Long id) {
//
//        return null;
//    }
//
//    @PostMapping
//    public Users create(@RequestBody Users user) {
//
//        return null;
//    }
//   @PutMapping("/{id}")
//    public Users update(@RequestBody Users user, @PathVariable long id) {
//
//
//       return null;
//    }
//    @DeleteMapping("/{id}")
//    public void deleteById (@PathVariable Long id){
//
//    }
//
//    // User posts
//    @GetMapping("/{id}/comments")
//    public List<Comments> getAllCommentsByUserId(@PathVariable Long id) {
//
//        return null;
//    }
//
//    @GetMapping("/{id}/posts")
//    public List<Post> getUserPosts(@PathVariable Long userId) {
//
//        return null;
//    }
//

}
