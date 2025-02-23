package com.devteri.identity_serve.mapper;

import com.devteri.identity_serve.dtos.CreateUserDtos;
import com.devteri.identity_serve.dtos.UserDtos;
import com.devteri.identity_serve.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(CreateUserDtos request);
    void updateUser(@MappingTarget User user, CreateUserDtos request);
    @Mapping(target = "password", ignore = true)
    UserDtos toUserDtos(User user);
}
