package com.example.umc_project.apiPayload.exception.handler;

import com.example.umc_project.apiPayload.code.BaseErrorCode;
import com.example.umc_project.apiPayload.exception.GeneralException;

public class StoreCategoryHandler extends GeneralException {
    public StoreCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
