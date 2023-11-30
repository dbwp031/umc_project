package com.example.umc_project.domain.mapping;

import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.Mission;
import com.example.umc_project.domain.common.BaseEntity;
import com.example.umc_project.domain.enums.MissionStatus;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Mission mission;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;
}
