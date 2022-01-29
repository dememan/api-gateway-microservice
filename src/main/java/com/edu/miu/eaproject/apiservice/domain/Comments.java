package com.edu.miu.eaproject.apiservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Comments {
    private Long id;

    private String title;

    private String body;
    private Long userId;
    private Long PostId;

    public Comments() {
    }

    public Comments(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String username) {
        this.title = username;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return PostId;
    }

    public void setPostId(Long postId) {
        PostId = postId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", username='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
