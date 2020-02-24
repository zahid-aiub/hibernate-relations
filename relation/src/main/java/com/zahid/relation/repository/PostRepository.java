package com.zahid.relation.repository;

import com.zahid.relation.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(Integer userId);
    Optional<Post> findByIdAndUserId(Integer id, Integer userId);
}
