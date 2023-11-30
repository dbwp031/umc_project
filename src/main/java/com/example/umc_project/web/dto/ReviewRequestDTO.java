package com.example.umc_project.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {
    @Getter
    public static class PostNewReviewDto{
        @NotNull
        private Long memberId;
        @NotNull
        private Long storeId;
        @NotBlank
        private String content;
    }

}
