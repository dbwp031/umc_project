package com.example.umc_project.service.MemberService;

import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.Review;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface MemberQueryService {

    Member findById(Long memberId);
    Page<Review> getAllReviewsByMemberId(Long memberId, Integer pageNumber, Integer pageSize);
}
