package com.library.foxwearmanagement.controller;

import com.library.foxwearmanagement.dto.ApiResponse;
import com.library.foxwearmanagement.dto.request.CreateColorOptionRequest;
import com.library.foxwearmanagement.dto.response.CreateColorOptionResponse;
import com.library.foxwearmanagement.service.ColorOptionService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/color")
@RequiredArgsConstructor
public class ColorOptionController {
    private final ColorOptionService colorOptionService;

    @PostMapping
    public ResponseEntity<@NonNull ApiResponse<CreateColorOptionResponse>> createColorOption(
            @Valid @RequestBody CreateColorOptionRequest createColorOptionRequest
    ) {
        var response = colorOptionService.createColorOption(createColorOptionRequest);

        System.out.println("Response: " + response);

        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
