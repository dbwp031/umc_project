package com.example.umc_project.web.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MissionRequestDTO {
    @Getter
    @Setter
    public static class PostNewMissionDto{
        @NotNull
        private Long storeId;
        @NotBlank
        private String content;
        @NotNull
        private Float reward;
        @NotNull
        private LocalDateTime deadline;
    }
}
