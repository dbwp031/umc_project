package com.example.umc_project.validation.validator;

import com.example.umc_project.apiPayload.code.status.ErrorStatus;
import com.example.umc_project.repository.MemberMissionRepository;
import com.example.umc_project.repository.MemberRepository;
import com.example.umc_project.service.MemberMissionService;
import com.example.umc_project.service.MemberService.MemberCommandService;
import com.example.umc_project.service.MissionService;
import com.example.umc_project.validation.annotation.AlreadyOnGogingMissions;
import com.example.umc_project.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Slf4j
@Component
@RequiredArgsConstructor
public class OnGoingMissionsValidator implements ConstraintValidator<AlreadyOnGogingMissions, MemberRequestDTO.EnrollMissionDto> {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MemberCommandService memberCommandService;
    private final MemberMissionService memberMissionService;
    private final MissionService missionService;

    @Override
    public void initialize(AlreadyOnGogingMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberRequestDTO.EnrollMissionDto value, ConstraintValidatorContext context) {
        Boolean alreadyOngoing = memberMissionService.checkAlreadyOnGoing(value.getMemberId(), value.getMissionId());
        log.info("alreadyOngoing: {}", alreadyOngoing);
        if (alreadyOngoing){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_ONGOING.toString()).addConstraintViolation();

        }
        return !alreadyOngoing;
    }
}
