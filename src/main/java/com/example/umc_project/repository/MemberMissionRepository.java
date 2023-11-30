package com.example.umc_project.repository;

import com.example.umc_project.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Optional<MemberMission> findByMember_IdAndMission_Id(Long memberId, Long missionId);
}
