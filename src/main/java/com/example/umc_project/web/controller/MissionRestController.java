package com.example.umc_project.web.controller;

import com.example.umc_project.apiPayload.ApiResponse;
import com.example.umc_project.converter.MissionConverter;
import com.example.umc_project.domain.Mission;
import com.example.umc_project.service.MissionService;
import com.example.umc_project.web.dto.MissionRequestDTO;
import com.example.umc_project.web.dto.MissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
@RestController
public class MissionRestController {
    private final MissionService missionService;
    @PostMapping
    public ApiResponse<MissionResponseDTO.PostNewMissionResultDto> postNewMission(MissionRequestDTO.PostNewMissionDto request){
        Mission mission = missionService.postNewMission(request);
        return ApiResponse.onSuccess(MissionConverter.toNewPostMissionResultDto(mission));
    }
}
