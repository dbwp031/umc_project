package com.example.umc_project.repository;

import com.example.umc_project.domain.Review;
import com.example.umc_project.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
