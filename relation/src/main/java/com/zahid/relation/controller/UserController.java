package com.zahid.relation.controller;

import com.zahid.relation.dto.classBased.UserDetailsDto;
import com.zahid.relation.dto.classBased.UserDto;
import com.zahid.relation.dto.interfaceBased.UserInDto;
import com.zahid.relation.model.User;
import com.zahid.relation.response.Response;
import com.zahid.relation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return this.userService.getUserById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(new Response(201, "User created successfully!."), CREATED);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @Valid @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }


    // Class based DTO method call
    @GetMapping("/getByName")
    public UserDto getUserByName(@RequestParam("name") String name) {
        return userService.getUserByName(name);
    }

    // Interface based DTO method call
    @GetMapping("/getByPass")
    public UserInDto getUserByPass(@RequestParam("pass") String pass) {
        return userService.getUserByPassword(pass);
    }

    // Dynamic DTO method call
    @GetMapping("/get-all")
    public UserDto getNameAndEmailByName(@RequestParam("email") String email) {
        return userService.getNameAndEmailByEmail(email);
    }

    // Dynamic DTO method call
    @GetMapping("/get-all-details")
    public UserDetailsDto getAllByName(@RequestParam("email") String email) {
        return userService.getDetailsByEmail(email);
    }

}
