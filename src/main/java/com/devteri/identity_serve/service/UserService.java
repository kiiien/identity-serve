package com.devteri.identity_serve.service;

import com.devteri.identity_serve.dtos.CreateUserDtos;
import com.devteri.identity_serve.dtos.UserDtos;
import com.devteri.identity_serve.entity.User;
import com.devteri.identity_serve.exception.AppException;
import com.devteri.identity_serve.exception.ErrorCode;
import com.devteri.identity_serve.mapper.UserMapper;
import com.devteri.identity_serve.reponsitory.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserDtos create(CreateUserDtos request) {

        if(userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        return userMapper.toUserDtos(userRepository.save(user));
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public UserDtos getUserById(String id) {
        return userMapper.toUserDtos(userRepository.findById(id).orElseThrow(() -> new RuntimeException("not found user")));
    }

    public UserDtos update(String id, CreateUserDtos request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("not found user"));

        userMapper.updateUser(user, request);

        return userMapper.toUserDtos(userRepository.save(user));
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
