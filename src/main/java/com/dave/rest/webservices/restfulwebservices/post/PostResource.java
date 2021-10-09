package com.dave.rest.webservices.restfulwebservices.post;

import com.dave.rest.webservices.restfulwebservices.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostResource {

    @Autowired
    private PostDaoService service;

    @GetMapping("/users/{userId}/posts")
    public List<Post> retrieveAllPostsForUser(@PathVariable int userId) {
        return service.getPostsByUserId(userId);
    }

    @GetMapping("/users/{userId}/posts/{postId}")
    public Post retrievePostDetails(@PathVariable int userId, @PathVariable int postId) {
        return service.getPostDetails(userId, postId);
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int userId, @RequestBody Post post) {
        Post savedPost = service.save(userId, post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
