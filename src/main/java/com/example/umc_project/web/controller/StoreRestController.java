package com.example.umc_project.web.controller;

import com.example.umc_project.apiPayload.ApiResponse;
import com.example.umc_project.converter.StoreConverter;
import com.example.umc_project.domain.Review;
import com.example.umc_project.service.StoreService.StoreQueryService;
import com.example.umc_project.validation.annotation.ExistStore;
import com.example.umc_project.web.dto.StoreResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/stores")
@RestController
public class StoreRestController {
    private final StoreQueryService storeQueryService;

    @Operation(summary = "Store별 review 조회", description = "특정 store의 review 정보를 페이지별로 조회하는 API")
    @GetMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.ReviewPreviewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                        @Parameter(description = "페이지 번호") @RequestParam(required = false, defaultValue = "0", value="page") int pageNumber,
                                                                        @Parameter(description = "페이지 번호") @RequestParam(required = false, defaultValue = "3", value="size") int pageSize
                                                                        ){
        Page<Review> reviewPage = storeQueryService.getReviewList(storeId, pageNumber, pageSize);
        return  ApiResponse.onSuccess(StoreConverter.toReviewPreviewListDTO(reviewPage));
    }
}
