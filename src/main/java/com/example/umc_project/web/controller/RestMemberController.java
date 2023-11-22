package com.example.umc_project.web.controller;

import com.example.umc_project.apiPayload.ApiResponse;
import com.example.umc_project.converter.MemberConverter;
import com.example.umc_project.domain.Member;
import com.example.umc_project.service.MemberService.MemberService;
import com.example.umc_project.web.dto.MemberRequestDTO;
import com.example.umc_project.web.dto.MemberResponseDto;
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
public class RestMemberController {
    private final MemberService memberService;
    @PostMapping
    public ApiResponse<MemberResponseDto.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
//        Member member = memberService.joinMember(request);
//        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}