package com.nisum.api.controller.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public  class Phone {
    @NotBlank(message = "Invalid Phone Number")
    private String number;
    @NotBlank(message = "Invalid Phone cityCode")
    private String cityCode;
    @NotBlank(message = "Invalid Phone countryCode")
    private String countryCode;
}