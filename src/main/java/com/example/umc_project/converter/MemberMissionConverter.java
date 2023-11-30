package com.example.umc_project.converter;

import com.example.umc_project.domain.enums.MissionStatus;
import com.example.umc_project.domain.mapping.MemberMission;
import com.example.umc_project.web.dto.MemberRequestDTO;
import com.example.umc_project.web.dto.MemberResponseDTO;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(MemberRequestDTO.EnrollMissionDto request){
        return MemberMission.builder()
                .status(MissionStatus.ONGOING)
                .build();
    }

    public static MemberResponseDTO.EnrollMissionResultDTO toEnrollMissionResultDTO(MemberMission memberMission) {
        return MemberResponseDTO.EnrollMissionResultDTO.builder()
                .missionId(memberMission.getMission().getId())
                .memberId(memberMission.getMember().getId())
                .build();

    }
}
