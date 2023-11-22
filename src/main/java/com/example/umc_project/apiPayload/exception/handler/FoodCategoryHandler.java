package com.example.umc_project.apiPayload.exception.handler;

import com.example.umc_project.apiPayload.code.BaseErrorCode;
import com.example.umc_project.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
