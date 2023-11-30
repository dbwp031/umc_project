package com.example.umc_project.service.MemberService;

import com.example.umc_project.domain.Member;
import com.example.umc_project.repository.MemberRepository;
import com.example.umc_project.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
