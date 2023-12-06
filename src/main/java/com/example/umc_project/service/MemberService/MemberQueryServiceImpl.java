package com.example.umc_project.service.MemberService;

import com.example.umc_project.apiPayload.code.status.ErrorStatus;
import com.example.umc_project.apiPayload.exception.handler.MemberHandler;
import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.Review;
import com.example.umc_project.repository.MemberRepository;
import com.example.umc_project.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }

    @Override
    public Page<Review> getAllReviewsByMemberId(Long memberId, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Review> memberReviews = reviewRepository.findAllByMember_Id(memberId, pageable);
        return memberReviews;
    }

}
