package com.example.umc_project.service.MemberService;

import com.example.umc_project.converter.MemberConverter;
import com.example.umc_project.domain.FoodCategory;
import com.example.umc_project.domain.Member;
import com.example.umc_project.repository.MemberRepository;
import com.example.umc_project.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;
    private final FoodCategory foodCategory;
    @Transactional
    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member member = MemberConverter.toMember(request);
        return null;
    }
}
