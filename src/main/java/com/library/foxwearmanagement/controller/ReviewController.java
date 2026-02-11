package com.library.foxwearmanagement.controller;

import com.library.foxwearmanagement.dto.ApiResponse;
import com.library.foxwearmanagement.dto.request.CreateReviewRequest;
import com.library.foxwearmanagement.dto.response.CreateReviewResponse;
import com.library.foxwearmanagement.dto.response.GetReviewResponse;
import com.library.foxwearmanagement.service.ReviewService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<@NonNull ApiResponse<List<GetReviewResponse>>> getAllReviews() {
        var response = reviewService.getAllReviews();
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
