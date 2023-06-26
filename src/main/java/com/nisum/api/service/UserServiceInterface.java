package com.nisum.api.service;

import com.nisum.api.controller.model.UserRequest;
import com.nisum.api.controller.model.UserResponse;
import com.nisum.api.exception.ApiNisumException;

public interface UserServiceInterface {

    UserResponse createUser(UserRequest userRequest) throws ApiNisumException;

}
