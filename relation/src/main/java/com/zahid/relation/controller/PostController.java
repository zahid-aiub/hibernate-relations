package com.zahid.relation.controller;

import com.zahid.relation.model.Post;
import com.zahid.relation.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/users/{userId}/posts")
    public List<Post> getAllPostByUserId(@PathVariable(value = "userId") Integer userId) {
        return postService.getAllPostByUserId(userId);
    }

    @GetMapping("/users/{userId}/posts/{id}")
    public Optional<Post> getPostByIdAndUserId(@PathVariable Integer id, @PathVariable Integer userId) {
        return postService.getPostByIdAndUserId(id, userId);
    }

    @PostMapping("/users/{userId}/posts")
    public Post createPost(@PathVariable(value = "userId") Integer userId, @Valid @RequestBody Post post) {
        return postService.createPost(userId, post);
    }

    @PutMapping("/users/{userId}/posts/{postId}")
    public Post updatePost(@PathVariable(value = "userId") Integer userId,
                           @PathVariable(value = "postId") Integer postId,
                           @Valid @RequestBody Post post) {
        return postService.updatePost(userId, postId, post);
    }

    @DeleteMapping("/users/{userId}/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "userId") Integer userId,
                                        @PathVariable(value = "postId") Integer postId) {
        return postService.deletePost(userId, postId);
    }

}
