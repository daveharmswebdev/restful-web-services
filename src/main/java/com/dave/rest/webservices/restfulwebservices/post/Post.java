package com.dave.rest.webservices.restfulwebservices.post;

public class Post {

    private Integer id;
    private Integer userId;
    private String postTitle;
    private String postContent;

    protected Post() {}

    public Post(Integer id, Integer userId, String postTitle, String postContent) {
        this.id = id;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                '}';
    }
}
