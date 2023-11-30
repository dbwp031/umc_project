package com.example.umc_project.converter;

import com.example.umc_project.domain.FoodCategory;
import com.example.umc_project.domain.mapping.LikedFoodCategory;

import java.util.List;
import java.util.stream.Collectors;

public class LikedFoodCategoryConverter {
    public static List<LikedFoodCategory> toLikedFoodCategoryList(List<FoodCategory> foodCategoryList){
        return foodCategoryList.stream()
                .map(foodCategory ->
                        LikedFoodCategory.builder()
                                .foodCategory(foodCategory)
                                .build())
                .collect(Collectors.toList());
    }
}
