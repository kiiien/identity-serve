package com.devteri.identity_serve.service;

import com.devteri.identity_serve.dtos.CreateUserDtos;
import com.devteri.identity_serve.entity.User;
import com.devteri.identity_serve.reponsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(CreateUserDtos request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setDateBirth(request.getDateBirth());
        user.setFullName(request.getFullName());

        return userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User update(String id, CreateUserDtos request) {
        User user = getUserById(id);

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setDateBirth(request.getDateBirth());
        user.setFullName(request.getFullName());

        return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
