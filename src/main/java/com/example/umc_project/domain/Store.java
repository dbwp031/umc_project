package com.example.umc_project.domain;

import com.example.umc_project.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Float score;

    @ManyToOne
    private FoodCategory foodCategory;
}
