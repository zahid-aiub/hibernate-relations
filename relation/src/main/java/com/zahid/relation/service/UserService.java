package com.zahid.relation.service;

import com.zahid.relation.dto.classBased.UserDetailsDto;
import com.zahid.relation.dto.classBased.UserDto;
import com.zahid.relation.dto.interfaceBased.UserInDto;
import com.zahid.relation.exception.ResourceNotFoundException;
import com.zahid.relation.model.User;
import com.zahid.relation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer userId, User userRequest) {
        return userRepository.findById(userId).map(user -> {
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }

    public ResponseEntity<?> deleteUser(Integer userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }

    public UserDto getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public UserInDto getUserByPassword(String pass) {
        return userRepository.findByPassword(pass);
    }

    public UserDto getNameAndEmailByEmail(String email) {
        return userRepository.findByEmail(email, UserDto.class);
    }

    public UserDetailsDto getDetailsByEmail(String email) {
        return userRepository.findByEmail(email, UserDetailsDto.class);
    }

}
