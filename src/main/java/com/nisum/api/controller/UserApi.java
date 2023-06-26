package com.nisum.api.controller;

import com.nisum.api.controller.model.UserRequest;
import com.nisum.api.controller.model.UserResponse;
import com.nisum.api.exception.ApiNisumException;
import com.nisum.api.model.error.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {

    @Operation(
            summary = "Create a new user",
            description = "create a new user, validating that the email doesn't exist and the password have correct format"
            )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = UserResponse.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = ErrorMessage.class), mediaType = "application/json") }) })
    @PostMapping
    ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) throws ApiNisumException;
}
