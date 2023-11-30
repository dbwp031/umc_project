package com.example.umc_project.converter;

import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.enums.Gender;
import com.example.umc_project.domain.enums.MemberStatus;
import com.example.umc_project.domain.enums.SocialType;
import com.example.umc_project.web.dto.MemberRequestDTO;
import com.example.umc_project.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){
        Gender gender = null;
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
                .name(request.getName())
                .age(request.getAge())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .socialType(SocialType.KAKAO)
                .status(MemberStatus.ACTIVATE)
                .inactivateDate(null)
                .email(request.getEmail())
                .point(0f)
                .build();
    }
}
