package com.example.umc_project.service;

import com.example.umc_project.apiPayload.code.status.ErrorStatus;
import com.example.umc_project.apiPayload.exception.handler.MemberHandler;
import com.example.umc_project.apiPayload.exception.handler.StoreHandler;
import com.example.umc_project.converter.MissionConverter;
import com.example.umc_project.converter.ReviewConverter;
import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.Mission;
import com.example.umc_project.domain.Review;
import com.example.umc_project.domain.Store;
import com.example.umc_project.repository.MissionRepository;
import com.example.umc_project.repository.StoreRepository;
import com.example.umc_project.web.dto.MissionRequestDTO;
import com.example.umc_project.web.dto.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MissionService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    @Transactional
    public Mission postNewMission(MissionRequestDTO.PostNewMissionDto request){
        Mission mission = MissionConverter.toMission(request);
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(()-> new IllegalArgumentException());
        mission.setStore(store);
        return missionRepository.save(mission);
    }
}
