package com.example.umc_project.service;

import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.Mission;
import com.example.umc_project.domain.enums.MissionStatus;
import com.example.umc_project.domain.mapping.MemberMission;
import com.example.umc_project.repository.MemberMissionRepository;
import com.example.umc_project.service.MemberService.MemberCommandService;
import com.example.umc_project.service.MemberService.MemberQueryService;
import com.example.umc_project.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class MemberMissionService {
    private final MemberQueryService memberQueryService;
    private final MissionService missionService;
    private final MemberMissionRepository memberMissionRepository;
    public Boolean checkAlreadyOnGoing(Long memberId, Long missionId){
        Member member = memberQueryService.findById(memberId);
        Mission mission = missionService.findById(missionId);

        Optional<MemberMission> optionalMemberMission = memberMissionRepository.findByMember_IdAndMission_Id(memberId, missionId);
        return optionalMemberMission.isPresent();
    }

    public MemberMission save(MemberRequestDTO.EnrollMissionDto request){
        Member member = memberQueryService.findById(request.getMemberId());
        Mission mission = missionService.findById(request.getMissionId());
        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.ONGOING)
                .build();
        return memberMissionRepository.save(memberMission);
    }
}
