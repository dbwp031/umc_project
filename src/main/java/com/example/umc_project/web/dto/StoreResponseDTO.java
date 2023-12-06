package com.example.umc_project.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class StoreResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewDTO{
        private Long memberId;
        private String memberNickName;
        private Float score;
        private String body;
        LocalDateTime createdAt;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewListPagingDTO {
        Boolean isLast;
        Boolean isFirst;
        Integer totalPage;
        Long totalElements;
        List<ReviewPreviewDTO> reviewList;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionListPagingDTO {
        Boolean isLast;
        Boolean isFirst;
        Integer totalPage;
        Long totalElements;
        List<MissionResponseDTO.MissionPreviewDTO> missionList;
    }
}
