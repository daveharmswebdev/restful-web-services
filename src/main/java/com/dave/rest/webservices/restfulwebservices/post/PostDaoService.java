package com.dave.rest.webservices.restfulwebservices.post;

import com.dave.rest.webservices.restfulwebservices.exception.CustomBadRequestException;
import com.dave.rest.webservices.restfulwebservices.user.User;
import com.dave.rest.webservices.restfulwebservices.user.UserDaoService;
import com.dave.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDaoService {

    @Autowired
    private UserDaoService userService;

    private static List<Post> posts = new ArrayList<>();

    private static int postCount = 6;

    static {
        posts.add(new Post(1,1,"Title 1A", "Dave Content A"));
        posts.add(new Post(2,1,"Title 1B", "Dave Content B"));
        posts.add(new Post(3,2,"Title 2A", "Jennifer Content A"));
        posts.add(new Post(4,2,"Title 2B", "Jennifer Content B"));
        posts.add(new Post(5,3,"Title 3A", "Orman Content"));
        posts.add(new Post(6,4,"Title 4A", "Marianna Content"));
    }

    public List<Post> getPostsByUserId(int userId) {

        User user = userService.findUserById(userId);

        if (user == null)
            throw new UserNotFoundException("id-" + userId + " not found while fetching posts.");

        List<Post> userPosts = new ArrayList<>();

        for(Post post:posts) {
            if (post.getUserId() == userId) {
                userPosts.add(post);
            }
        }
        return userPosts;
    }

    public Post save(int userId, Post post) {
        User user = userService.findUserById(userId);

        if (user == null)
            throw new CustomBadRequestException("id-" + userId + " not found while fetching posts.");

        if (post.getId()==null) {
            post.setId(++postCount);
        }
        posts.add(post);
        return post;
    }

    public Post getPostDetails(int userId, int postId) {
        User user = userService.findUserById(userId);

        if (user == null)
            throw new UserNotFoundException("id-" + userId + " not found while fetching posts.");

        for(Post post:posts) {
            if (post.getId()==postId)
                return post;
        }

        throw new PostNotFoundException("post id-" + postId + " not found.");
    }
}
