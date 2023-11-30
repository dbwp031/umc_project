package com.example.umc_project.service.ReviewService;

import com.example.umc_project.apiPayload.code.status.ErrorStatus;
import com.example.umc_project.apiPayload.exception.handler.MemberHandler;
import com.example.umc_project.apiPayload.exception.handler.StoreHandler;
import com.example.umc_project.converter.ReviewConverter;
import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.Review;
import com.example.umc_project.domain.Store;
import com.example.umc_project.repository.MemberRepository;
import com.example.umc_project.repository.ReviewRepository;
import com.example.umc_project.repository.StoreRepository;
import com.example.umc_project.web.dto.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Review postNewReview(ReviewRequestDTO.PostNewReviewDto request){
        Review review = ReviewConverter.toReview(request);
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        review.setMember(member);
        review.setStore(store);
        return reviewRepository.save(review);

    }
}
