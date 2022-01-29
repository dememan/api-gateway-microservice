package com.edu.miu.eaproject.apiservice.domain;

public class Post {
    private Long id;
    private String title;
    private String body;
    private int likes;

    public Post() {
    }

    public Post(String title, String body, int likes) {
        this.title = title;
        this.body = body;
        this.likes = likes;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
