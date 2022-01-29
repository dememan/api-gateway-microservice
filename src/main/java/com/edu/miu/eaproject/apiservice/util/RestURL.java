package com.edu.miu.eaproject.apiservice.util;

import java.net.URI;

public class RestURL {

    //USER_SERVICE
    public static final String usersURL = "http://localhost:8081/users/";
    public static final String userURL = "http://localhost:8081/users/{id}";

    //POST-SERVICE
    public static  final String postsURL = "http://localhost:8082/posts/";
    public static final String postUrl = "http://localhost:8082/posts/{id}";
    public static final String userPostsUrl = "http://localhost:8082/users/";

    public static final String postLikes = "http://localhost:8082/posts/{id}/like";
    public static final String postDisLikes = "http://localhost:8082/posts/{id}/dislike";


    // Comment-service
    public static  final String commentsURL = "http://localhost:8083/comments/";
    public static  final String commentURL = "http://localhost:8083/comments/{id}";

    public static final String usersForCommentsURL = "http://localhost:8083/users/";
    public static final String postsForCommentsURL = "http://localhost:8083/posts/";

}
