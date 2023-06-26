package com.nisum.api.controller.model;

import com.nisum.api.utils.validator.ValidPassword;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class UserBase {

    @NotBlank(message = "Invalid Name")
    private String name;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Invalid Email")
    private String email;
    @ValidPassword
    private String password;
    @Valid
    private List<Phone> phones;

}
