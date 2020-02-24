package com.zahid.relation.service;

import com.zahid.relation.exception.ResourceNotFoundException;
import com.zahid.relation.model.Comment;
import com.zahid.relation.repository.CommentRepository;
import com.zahid.relation.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public List<Comment> getAllCommentsByPostId(Integer postId) {
        return commentRepository.getCommentByPostId(postId);
    }

    public List<Comment> getCommentByIdAndPostId(Integer id, Integer postId) {
        return commentRepository.getCommentByIdAndPostId(id, postId);
    }

    public Comment createComment(Comment comment, Integer postId) {
        return this.postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

}
