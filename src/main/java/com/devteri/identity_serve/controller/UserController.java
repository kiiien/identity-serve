package com.devteri.identity_serve.controller;

import com.devteri.identity_serve.dtos.CreateUserDtos;
import com.devteri.identity_serve.entity.User;
import com.devteri.identity_serve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody CreateUserDtos request) {
        return userService.create(request);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") String id){
        return  userService.getUserById(id);
    }

    @PutMapping("/{id}")
    User update(@PathVariable("id") String id, @RequestBody CreateUserDtos request) {
        return userService.update(id, request);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable("id") String id) {
        userService.delete(id);
        return "Delete success";
    }
}
