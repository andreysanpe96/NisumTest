package com.nisum.api.mapper;

import com.nisum.api.controller.model.Phone;
import com.nisum.api.controller.model.UserRequest;
import com.nisum.api.controller.model.UserResponse;
import com.nisum.api.entity.PhoneEntity;
import com.nisum.api.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class UserEntityMapper {

    @Mapping(target = "isActive", expression = "java(true)")
    @Mapping(target = "token", source = "jwt")
    public abstract UserEntity UserRequestToUserEntity(UserRequest request, String jwt);

    public abstract PhoneEntity PhoneToPhoneEntity(Phone value);

    @Mapping(source = "userId", target = "id")
    @Mapping(source = "createdAt", target = "created")
    @Mapping(source = "updatedAt", target = "modified")
    public abstract UserResponse UserEntityToUserResponse(UserEntity entity);
}