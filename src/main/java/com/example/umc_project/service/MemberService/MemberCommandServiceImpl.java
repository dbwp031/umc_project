package com.example.umc_project.service.MemberService;

import com.example.umc_project.apiPayload.code.status.ErrorStatus;
import com.example.umc_project.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.umc_project.converter.LikedFoodCategoryConverter;
import com.example.umc_project.converter.MemberConverter;
import com.example.umc_project.domain.FoodCategory;
import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.mapping.LikedFoodCategory;
import com.example.umc_project.repository.FoodCategoryRepository;
import com.example.umc_project.repository.MemberRepository;
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
}
