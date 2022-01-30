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
@RequestMapping("/api/users")
public class UsersServiceProxy {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PostServiceProxy postServiceProxy;

    @GetMapping
    public List<Users> getUsers(Long id) {
        ResponseEntity<List<Users>> response =
                restTemplate.exchange(RestURL.usersURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Users>>() {
                        });
        return response.getBody();
    }

    @GetMapping("/{id}")
    public Users getById(@PathVariable Long id) {

        return restTemplate.getForObject(RestURL.userURL, Users.class, id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getUserPosts(@PathVariable Long id) {

        ResponseEntity<List<Post>> response =
                restTemplate.exchange(RestURL.userPostsUrl + id + "/posts", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Post>>() {
                        });
        return response.getBody();
    }

    @PostMapping
    public Users create(@RequestBody Users user) {
        return restTemplate.postForObject(RestURL.usersURL,user,Users.class);
    }
  
    @PutMapping("/{id}")
    public void update(@RequestBody Users user,@PathVariable Long id ) {
        user.setId(id);
     restTemplate.put(RestURL.userURL,user,id);
    }
    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Long id){
        restTemplate.delete(RestURL.userURL,id);
    }

    @GetMapping("/{userId}/comments")
    public List<Comments> getUserComments(@PathVariable Long userId){
        ResponseEntity<List<Comments>> response =
                restTemplate.exchange(RestURL.usersForCommentsURL+ userId + "/comments", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Comments>>() {});

        return response.getBody();
    }
  }
