package com.example.umc_project.service.StoreService;

import com.example.umc_project.domain.Mission;
import com.example.umc_project.domain.Review;
import com.example.umc_project.domain.Store;
import org.springframework.data.domain.Page;

public interface StoreQueryService {
    Store findByStoreId(Long storeId);
    Page<Review> getReviewList(Long storeId, Integer pageNumber, Integer pageSize);

    Page<Mission> getMissionList(Long storeId, int pageNumber, int pageSize);
}
