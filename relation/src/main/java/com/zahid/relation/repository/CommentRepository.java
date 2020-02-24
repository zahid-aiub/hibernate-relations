package com.zahid.relation.repository;

import com.zahid.relation.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> getCommentByPostId(Integer postId);
    List<Comment> getCommentByIdAndPostId(Integer id, Integer postId);
}
