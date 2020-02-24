package com.zahid.relation.repository;

import com.zahid.relation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserRepository extends JpaRepository<User, Integer> {

}
