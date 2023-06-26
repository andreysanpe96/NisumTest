package com.nisum.api.model.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorMessage {

    @JsonProperty("mensaje")
    private String message;

}
