package com.example.umc_project.domain;

import com.example.umc_project.domain.common.BaseEntity;
import com.example.umc_project.domain.enums.Gender;
import com.example.umc_project.domain.enums.MemberStatus;
import com.example.umc_project.domain.enums.SocialType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String specAddress;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDate inactivateDate;

    private String email;

    private Float point;
}
