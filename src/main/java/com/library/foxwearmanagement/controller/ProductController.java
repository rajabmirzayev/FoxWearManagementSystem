package com.library.foxwearmanagement.controller;

import com.library.foxwearmanagement.dto.ApiResponse;
import com.library.foxwearmanagement.dto.request.CreateProductRequest;
import com.library.foxwearmanagement.dto.response.CreateProductResponse;
import com.library.foxwearmanagement.service.ProductService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<@NonNull ApiResponse<CreateProductResponse>> createProduct(
            @Valid @RequestBody CreateProductRequest createProductRequest
    ) {
        var response = productService.createProduct(createProductRequest);

        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
