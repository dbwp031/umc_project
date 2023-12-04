package com.example.umc_project.web.controller;


import com.example.umc_project.apiPayload.ApiResponse;
import com.example.umc_project.converter.ReviewConverter;
import com.example.umc_project.domain.Review;
import com.example.umc_project.service.ReviewService.ReviewService;
import com.example.umc_project.web.dto.ReviewRequestDTO;
import com.example.umc_project.web.dto.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@Validated
@RequestMapping("/reviews")
@RestController
public class ReviewRestController {
    private final ReviewService reviewService;
    @PostMapping
    public ApiResponse<ReviewResponseDTO.PostNewReviewResultDto> post(@RequestBody @Valid ReviewRequestDTO.PostNewReviewDto request){
        Review review = reviewService.postNewReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toPostNewReviewResultDto(review));
    }
}
