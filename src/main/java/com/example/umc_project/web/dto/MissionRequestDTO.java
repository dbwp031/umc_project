package com.example.umc_project.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

public class MissionRequestDTO {
    @Getter
    public static class PostNewMissionDto{
        private Long missionId;
        private Long storeId;
        private String content;
        private Float reward;
        private LocalDateTime deadline;
    }
}
