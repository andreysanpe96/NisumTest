package com.nisum.api.service;

import com.nisum.api.controller.model.UserRequest;
import com.nisum.api.controller.model.UserResponse;
import com.nisum.api.entity.UserEntity;
import com.nisum.api.enums.user.UserErrorEnum;
import com.nisum.api.exception.ApiNisumException;
import com.nisum.api.mapper.UserEntityMapper;
import com.nisum.api.repository.UserRepository;
import com.nisum.api.utils.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static com.nisum.api.utils.Utils.createErrorMessageWithValue;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserServiceImplement implements UserServiceInterface {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    private final UserEntityMapper userEntityMapper = Mappers.getMapper(UserEntityMapper.class);

    @Override
    public UserResponse createUser(UserRequest userRequest) throws ApiNisumException {
        isValidEmail(userRequest.getEmail());
        String jwt = jwtTokenProvider.createToken(userRequest.getEmail());
        UserEntity entity = userEntityMapper.UserRequestToUserEntity(userRequest, jwt);
        UserEntity response = userRepository.save(entity);
        return userEntityMapper.UserEntityToUserResponse(response);
    }

    private void isValidEmail(String email) throws ApiNisumException {
        if(userRepository.findByEmail(email).isPresent()){
            throw new ApiNisumException(createErrorMessageWithValue(UserErrorEnum.EMAIL_ALREADY_EXISTS, email), HttpStatus.BAD_REQUEST);
        }
    }
}
