package com.example.umc_project.converter;

import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.enums.Gender;
import com.example.umc_project.web.dto.MemberRequestDTO;
import com.example.umc_project.web.dto.MemberResponseDto;

import java.time.LocalDateTime;

public class MemberConverter {
    public static MemberResponseDto.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDto.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender =null;
        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .build();

    }
}