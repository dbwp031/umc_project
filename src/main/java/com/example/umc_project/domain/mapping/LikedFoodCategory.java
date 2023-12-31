package com.example.umc_project.domain.mapping;

import com.example.umc_project.domain.FoodCategory;
import com.example.umc_project.domain.Member;
import com.example.umc_project.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class LikedFoodCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private FoodCategory foodCategory;
}
