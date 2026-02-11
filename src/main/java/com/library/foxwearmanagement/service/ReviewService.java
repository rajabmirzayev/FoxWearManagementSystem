package com.library.foxwearmanagement.service;

import com.library.foxwearmanagement.dto.request.CreateReviewRequest;
import com.library.foxwearmanagement.dto.response.CreateReviewResponse;
import com.library.foxwearmanagement.dto.response.GetReviewResponse;
import com.library.foxwearmanagement.entity.User;
import com.library.foxwearmanagement.entity.Review;
import com.library.foxwearmanagement.exception.ReviewNotFoundException;
import com.library.foxwearmanagement.exception.UserNotFoundException;
import com.library.foxwearmanagement.repository.ReviewRepository;
import com.library.foxwearmanagement.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CreateReviewResponse createReview(
            CreateReviewRequest request
    ) {
        Review review = modelMapper.map(request, Review.class);

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + request.getUserId()));

        review.setUser(user);
        review.setId(null); // id-ni null edirəm, çünki model mapper requestdən gələn id-ni səhvən entity-nin id-sinə set edir

        reviewRepository.save(review);

        return modelMapper.map(review, CreateReviewResponse.class);
    }

    public List<GetReviewResponse> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();

        if (reviews.isEmpty()) {
            throw new ReviewNotFoundException("reviews is empty");
        }

        return reviews.stream()
                .map(r ->
                        modelMapper.map(r, GetReviewResponse.class)
                )
                .toList();
    }
}
