package com.library.foxwearmanagement.controller;

import com.library.foxwearmanagement.dto.ApiResponse;
import com.library.foxwearmanagement.dto.request.CreateReviewRequest;
import com.library.foxwearmanagement.dto.response.CreateReviewResponse;
import com.library.foxwearmanagement.service.ReviewService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<@NonNull ApiResponse<CreateReviewResponse>> createReview(
            @Valid @RequestBody CreateReviewRequest createReviewRequest
    ) {
        var response = reviewService.createReview(createReviewRequest);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
