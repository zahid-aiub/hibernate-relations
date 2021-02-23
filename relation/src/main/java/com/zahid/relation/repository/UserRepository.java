package com.zahid.relation.repository;

import com.zahid.relation.dto.classBased.UserDto;
import com.zahid.relation.dto.interfaceBased.UserInDto;
import com.zahid.relation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    UserDto findByName(String name);

    UserInDto findByPassword(String name);

    <T> T findByEmail(String name, Class<T> type);

}
