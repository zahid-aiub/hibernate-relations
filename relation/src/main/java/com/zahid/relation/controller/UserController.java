package com.zahid.relation.controller;

import com.zahid.relation.model.User;
import com.zahid.relation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getuserById(@PathVariable Integer id) {
        return this.userService.getUserById(id);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return this.userService.createUser(user);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Integer userId, @Valid @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        return userService.deleteUser(userId);
    }

}
