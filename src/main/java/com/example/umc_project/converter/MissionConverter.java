package com.example.umc_project.converter;

import com.example.umc_project.domain.Mission;
import com.example.umc_project.web.dto.MissionRequestDTO;
import com.example.umc_project.web.dto.MissionResponseDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.PostNewMissionDto request){
        return Mission.builder()
                .content(request.getContent())
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .build();
    }

    public static MissionResponseDTO.PostNewMissionResultDto toNewPostMissionResultDto(Mission mission){
        return MissionResponseDTO.PostNewMissionResultDto.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewDTO toMissionPreviewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .content(mission.getContent())
                .reward(mission.getReward())
                .deadLine(mission.getDeadline())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
