package com.edu.miu.eaproject.apiservice.util;

import java.net.URI;

public class RestURL {

    //USER_SERVICE
    public static final String usersURL = "http://user-service/users/";
    public static final String userURL = "http://user-service/users/{id}";

    //POST-SERVICE
    public static  final String postsURL = "http://post-service/posts/";
    public static final String postUrl = "http://post-service/posts/{id}";
    public static final String userPostsUrl = "http://post-service/users/";

    public static final String postLikes = "http://post-service/posts/{id}/like";
    public static final String postDisLikes = "http://post-service/posts/{id}/dislike";


    // Comment-service
    public static  final String commentsURL = "http://comment-service/comments/";
    public static  final String commentURL = "http://comment-service/comments/{id}";

    public static final String usersForCommentsURL = "http://comment-service/users/";
    public static final String postsForCommentsURL = "http://comment-service/posts/";

}
