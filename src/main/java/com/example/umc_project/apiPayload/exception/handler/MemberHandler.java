package com.example.umc_project.apiPayload.exception.handler;

import com.example.umc_project.apiPayload.code.BaseErrorCode;
import com.example.umc_project.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
