package com.nisum.api.service;

import com.nisum.api.controller.model.UserResponse;
import com.nisum.api.exception.ApiNisumException;
import com.nisum.api.repository.UserRepository;
import com.nisum.api.utils.jwt.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static com.nisum.utils.DataProvider.createUserEntity;
import static com.nisum.utils.DataProvider.createUserRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest
class UserServiceImplementTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private UserServiceImplement userServiceImplement;

    @Test
    public void testCreateUserWhenIsSuccess() throws ApiNisumException {
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenReturn(createUserEntity());

        UserResponse response = userServiceImplement.createUser(createUserRequest());

        assertEquals("andreyS@hotmail.com", response.getEmail());
    }

    @Test
    public void testCreateUserWhenIsEmailAlreadyExists() throws ApiNisumException {
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(createUserEntity()));

        try{
            userServiceImplement.createUser(createUserRequest());
        }catch(ApiNisumException e){
            assertEquals("Email 'andreyS@hotmail.com' already exists", e.getMessage());
        }
    }
}