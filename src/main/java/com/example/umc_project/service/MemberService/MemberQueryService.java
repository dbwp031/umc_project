package com.example.umc_project.service.MemberService;

import com.example.umc_project.domain.Member;

public interface MemberQueryService {

    Member findById(Long memberId);
}
