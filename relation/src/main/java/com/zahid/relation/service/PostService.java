package com.zahid.relation.service;

import com.zahid.relation.exception.ResourceNotFoundException;
import com.zahid.relation.model.Post;
import com.zahid.relation.repository.PostRepository;
import com.zahid.relation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Post> getAllPostByUserId(Integer userId) {
        return postRepository.findByUserId(userId);
    }

    public Optional<Post> getPostByIdAndUserId(Integer id, Integer userId) {
        return postRepository.findByIdAndUserId(id, userId);
    }

    public Post createPost(Integer userId, Post post) {
        return userRepository.findById(userId).map(user -> {
            post.setUser(user);
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }

    public Post updatePost(Integer userId, Integer postId, Post postRequest) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("UserId " + userId + " not found");
        }

        return postRepository.findById(postId).map(post -> {
            post.setText(postRequest.getText());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + "not found"));
    }

    public ResponseEntity<?> deletePost(Integer userId, Integer postId) {
        return postRepository.findByIdAndUserId(postId, userId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId + " and UserId " + userId));
    }
}
