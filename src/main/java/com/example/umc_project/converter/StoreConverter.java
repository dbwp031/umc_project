package com.example.umc_project.converter;

import com.example.umc_project.domain.Mission;
import com.example.umc_project.domain.Review;
import com.example.umc_project.web.dto.MissionResponseDTO;
import com.example.umc_project.web.dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static StoreResponseDTO.ReviewPreviewDTO toReviewPreviewDTO(Review review){
        return StoreResponseDTO.ReviewPreviewDTO.builder()
                .memberId(review.getMember().getId())
                .memberNickName(review.getMember().getName())
                .score(review.getScore())
                .body(review.getContent())
                .createdAt(review.getCreatedAt())
                .build();
    }
    public static StoreResponseDTO.ReviewPreviewListPagingDTO toReviewPreviewListDTO(Page<Review> reviewPage){
        List<StoreResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewPage.stream()
                .map(StoreConverter::toReviewPreviewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreviewListPagingDTO.builder()
                .isLast(reviewPage.isLast())
                .isFirst(reviewPage.isFirst())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .reviewList(reviewPreviewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionListPagingDTO toMissionListPagingDTO(Page<Mission> missionPage) {
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionPage.stream()
                .map(MissionConverter::toMissionPreviewDTO)
                .collect(Collectors.toList());

        return StoreResponseDTO.MissionListPagingDTO.builder()
                .isLast(missionPage.isLast())
                .isFirst(missionPage.isFirst())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .missionList(missionPreviewDTOList)
                .build();
    }
}
