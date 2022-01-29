package com.edu.miu.eaproject.apiservice.proxy;

import com.edu.miu.eaproject.apiservice.domain.Comments;
import com.edu.miu.eaproject.apiservice.domain.Post;
import com.edu.miu.eaproject.apiservice.domain.Users;
import com.edu.miu.eaproject.apiservice.util.RestURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UsersServiceProxy {

    @Autowired
    private RestTemplate restTemplate;

 @GetMapping
 public List<Users> getUsers() {
     ResponseEntity<List<Users>> response =
             restTemplate.exchange(RestURL.usersURL, HttpMethod.GET, null,
                     new ParameterizedTypeReference<List<Users>>() {});
     return response.getBody();
 }

        @GetMapping("/{id}")
        public Users getById(@PathVariable Long id) {

            return restTemplate.getForObject(RestURL.userURL, Users.class, id);
 }
    @PutMapping("/{id}")
    public String updateTest(@RequestBody Users user , @PathVariable Long id) {
      return "update request received for id: " + id;
    }
  }
