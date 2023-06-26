package com.nisum.api.controller;

import com.nisum.api.controller.model.UserRequest;
import com.nisum.api.controller.model.UserResponse;
import com.nisum.api.exception.ApiNisumException;
import com.nisum.api.service.UserServiceInterface;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "UserApi", description = "User management APIs")
public class UserController implements UserApi{

    private final UserServiceInterface userServiceInterface;

    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) throws ApiNisumException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userServiceInterface.createUser(userRequest));
    }

}