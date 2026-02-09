package com.library.foxwearmanagement.controller;

import com.library.foxwearmanagement.dto.ApiResponse;
import com.library.foxwearmanagement.dto.request.CreateUserRequest;
import com.library.foxwearmanagement.dto.response.CreateUserResponse;
import com.library.foxwearmanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<@NonNull ApiResponse<CreateUserResponse>> createUser(
            @Valid @RequestBody CreateUserRequest createUserRequest
    ) {
        var response = userService.createUser(createUserRequest);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
