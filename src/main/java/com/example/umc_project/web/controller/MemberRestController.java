package com.example.umc_project.web.controller;

import com.example.umc_project.apiPayload.ApiResponse;
import com.example.umc_project.converter.MemberConverter;
import com.example.umc_project.converter.MemberMissionConverter;
import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.mapping.MemberMission;
import com.example.umc_project.service.MemberMissionService;
import com.example.umc_project.service.MemberService.MemberCommandService;
import com.example.umc_project.validation.annotation.AlreadyOnGogingMissions;
import com.example.umc_project.web.dto.MemberRequestDTO;
import com.example.umc_project.web.dto.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
@RestController
public class MemberRestController {
    private final MemberCommandService memberService;
    private final MemberMissionService memberMissionService;

    @PostMapping
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/missions")
    public ApiResponse<MemberResponseDTO.EnrollMissionResultDTO> enrollMission(@RequestBody @AlreadyOnGogingMissions MemberRequestDTO.EnrollMissionDto request){
        MemberMission memberMission = memberMissionService.save(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toEnrollMissionResultDTO(memberMission));
    }
}
