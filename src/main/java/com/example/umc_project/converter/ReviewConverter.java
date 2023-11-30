package com.example.umc_project.converter;


import com.example.umc_project.domain.Review;
import com.example.umc_project.web.dto.ReviewRequestDTO;
import com.example.umc_project.web.dto.ReviewResponseDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.PostNewReviewDto request){
        return Review.builder()
                .content(request.getContent())
                .build();
    }
    public static ReviewResponseDTO.PostNewReviewResultDto toPostNewReviewResultDto(Review review){
        return ReviewResponseDTO.PostNewReviewResultDto.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
