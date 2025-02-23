package com.devteri.identity_serve.controller;

import com.devteri.identity_serve.dtos.CreateUserDtos;
import com.devteri.identity_serve.dtos.UserDtos;
import com.devteri.identity_serve.entity.User;
import com.devteri.identity_serve.exception.ApiResponse;
import com.devteri.identity_serve.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<UserDtos> createUser(@RequestBody @Valid CreateUserDtos request) {
        ApiResponse<UserDtos> response = new ApiResponse<>();
        response.setResult(userService.create(request));
        return response;
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    UserDtos getUserById(@PathVariable("id") String id){
        return  userService.getUserById(id);
    }

    @PutMapping("/{id}")
    UserDtos update(@PathVariable("id") String id, @RequestBody CreateUserDtos request) {
        return userService.update(id, request);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable("id") String id) {
        userService.delete(id);
        return "Delete success";
    }
}
