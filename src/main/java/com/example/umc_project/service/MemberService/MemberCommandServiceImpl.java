package com.example.umc_project.service.MemberService;

import com.example.umc_project.apiPayload.code.status.ErrorStatus;
import com.example.umc_project.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.umc_project.apiPayload.exception.handler.MemberHandler;
import com.example.umc_project.apiPayload.exception.handler.MissionHandler;
import com.example.umc_project.converter.LikedFoodCategoryConverter;
import com.example.umc_project.converter.MemberConverter;
import com.example.umc_project.converter.MemberMissionConverter;
import com.example.umc_project.domain.FoodCategory;
import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.Mission;
import com.example.umc_project.domain.mapping.LikedFoodCategory;
import com.example.umc_project.domain.mapping.MemberMission;
import com.example.umc_project.repository.FoodCategoryRepository;
import com.example.umc_project.repository.MemberMissionRepository;
import com.example.umc_project.repository.MemberRepository;
import com.example.umc_project.repository.MissionRepository;
import com.example.umc_project.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    @Transactional
    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<LikedFoodCategory> likedFoodCategoryList = LikedFoodCategoryConverter.toLikedFoodCategoryList(foodCategoryList);
        likedFoodCategoryList.forEach(likedFood -> {likedFood.setMember(newMember);});
        return memberRepository.save(newMember);
    }

    @Override
    public MemberMission enrollMission(MemberRequestDTO.EnrollMissionDto request) {
        MemberMission memberMission = MemberMissionConverter.toMemberMission(request);
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission =missionRepository.findById(request.getMissionId())
                .orElseThrow(()->new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        memberMission.setMember(member);
        memberMission.setMission(mission);
        return memberMissionRepository.save(memberMission);
    }

    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }
}
