package com.example.umc_project.web.controller;

import com.example.umc_project.apiPayload.ApiResponse;
import com.example.umc_project.converter.MemberConverter;
import com.example.umc_project.converter.MemberMissionConverter;
import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.Review;
import com.example.umc_project.domain.mapping.MemberMission;
import com.example.umc_project.service.MemberMissionService;
import com.example.umc_project.service.MemberService.MemberCommandService;
import com.example.umc_project.service.MemberService.MemberQueryService;
import com.example.umc_project.validation.annotation.AlreadyOnGogingMissions;
import com.example.umc_project.validation.annotation.CheckPageNumber;
import com.example.umc_project.web.dto.MemberRequestDTO;
import com.example.umc_project.web.dto.MemberResponseDTO;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
@RestController
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    private final MemberMissionService memberMissionService;

    @PostMapping
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/missions")
    public ApiResponse<MemberResponseDTO.EnrollMissionResultDTO> enrollMission(@RequestBody @AlreadyOnGogingMissions MemberRequestDTO.EnrollMissionDto request){
        MemberMission memberMission = memberMissionService.save(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toEnrollMissionResultDTO(memberMission));
    }

    /**
     * 특정 멤버가 작성한 모든 review를 요청하는 api. paging 기능을 포함하고 있다.
     * @param memberId 특정 멤버의 id
     * @param pageNumber page값 (페이징)
     * @param pageSize 각 page의 크기(페이징)
     * @return
     */
    @GetMapping("/{memberId}/reviews")
    public ApiResponse<MemberResponseDTO.ReviewPreviewListDTO> getReviewList(@PathVariable Long memberId,
                                                                             @Parameter(description = "페이지 번호") @RequestParam(required = false, defaultValue = "0", value="page") @CheckPageNumber int pageNumber,
                                                                             @Parameter(description = "페이지 번호") @RequestParam(required = false, defaultValue = "3", value="size") int pageSize
                                                                             ) {
        return ApiResponse.onSuccess(MemberConverter.toReviewPreviewListDTO(memberQueryService.getAllReviewsByMemberId(memberId, pageNumber, pageSize)));
    }
}
