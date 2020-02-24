package com.zahid.relation.controller;

import com.zahid.relation.model.Comment;
import com.zahid.relation.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/posts/{postId}/comments")
    public List<Comment> getAllCommentsByPostId(@PathVariable Integer postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping(value = "/posts/{postId}/comments/{id}")
    public List<Comment> getCommentByIdAndPostId(@PathVariable Integer id, @PathVariable Integer postId) {
        return commentService.getCommentByIdAndPostId(id, postId);
    }

    @PostMapping(value = "/posts/{postId}/comments")
    public Comment createComment(@Valid @RequestBody Comment comment, @PathVariable Integer postId) {
        return this.commentService.createComment(comment, postId);
    }
}
