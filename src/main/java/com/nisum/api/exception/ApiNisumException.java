package com.nisum.api.exception;


import com.nisum.api.enums.ErrorEnumInterface;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiNisumException extends Exception{

    private HttpStatus status;

    public ApiNisumException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public ApiNisumException(ErrorEnumInterface error, HttpStatus status){
        super(error.getMessage());
        this.status = status;
    }



}
