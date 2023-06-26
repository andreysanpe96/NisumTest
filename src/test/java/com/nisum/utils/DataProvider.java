package com.nisum.utils;

import com.nisum.api.controller.model.Phone;
import com.nisum.api.controller.model.UserRequest;
import com.nisum.api.entity.PhoneEntity;
import com.nisum.api.entity.UserEntity;

import java.util.List;

public class DataProvider {

    public static UserRequest createUserRequest(){
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("andreyS@hotmail.com");
        userRequest.setName("andrey");
        userRequest.setPassword("andrey!123");
        Phone phone = new Phone();
        phone.setCityCode("57");
        phone.setNumber("21234234");
        phone.setCountryCode("34");
        userRequest.setPhones(List.of(phone));
        return userRequest;
    }

    public static UserEntity createUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("andreyS@hotmail.com");
        userEntity.setName("andrey");
        userEntity.setPassword("andrey!123");
        PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setCityCode("57");
        phoneEntity.setNumber("21234234");
        phoneEntity.setCountryCode("34");
        userEntity.setPhones(List.of(phoneEntity));
        return userEntity;
    }

}

