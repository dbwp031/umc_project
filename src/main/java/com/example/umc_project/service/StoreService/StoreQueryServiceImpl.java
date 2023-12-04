package com.example.umc_project.service.StoreService;

import com.example.umc_project.apiPayload.code.status.ErrorStatus;
import com.example.umc_project.apiPayload.exception.handler.StoreHandler;
import com.example.umc_project.domain.Review;
import com.example.umc_project.domain.Store;
import com.example.umc_project.repository.ReviewRepository;
import com.example.umc_project.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StoreQueryServiceImpl implements StoreQueryService{
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public Store findByStoreId(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Review> storePage = reviewRepository.findAllByStoreId(storeId, pageable);
        return storePage;
    }
}
