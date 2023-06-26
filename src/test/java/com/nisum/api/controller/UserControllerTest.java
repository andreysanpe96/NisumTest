package com.nisum.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisum.api.config.security.JwtTokenInterceptor;
import com.nisum.api.service.UserServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.nisum.utils.DataProvider.createUserRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtTokenInterceptor jwtTokenInterceptor;

    @MockBean
    private UserServiceInterface userServiceInterface;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testCreateUserWhenIsSuccess() throws Exception {
        when(jwtTokenInterceptor.preHandle(any(),any(),any())).thenReturn(true);
        String requestBody = objectMapper.writeValueAsString(createUserRequest());
        String authorizationToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmRyZXlAaG90bWFpbC5jb20iLCJpYXQiOjE2ODc2MzYxNDB9.x7_WN-T5Iqh9e7Eu_8zA9E5skszAdz-7-T-p-ZKAAog";

        ResultActions result = mockMvc.perform(post("/api/users")
                .content(requestBody)
                .header(HttpHeaders.AUTHORIZATION, authorizationToken)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isCreated());
    }

}