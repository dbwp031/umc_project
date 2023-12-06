package com.example.umc_project.repository;

import com.example.umc_project.domain.Review;
import com.example.umc_project.domain.enums.MissionStatus;
import com.example.umc_project.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Optional<MemberMission> findByMember_IdAndMission_Id(Long memberId, Long missionId);

    Page<MemberMission> findByMember_IdAndStatus(Long memberId, MissionStatus missionStatus, Pageable pageable);
}
