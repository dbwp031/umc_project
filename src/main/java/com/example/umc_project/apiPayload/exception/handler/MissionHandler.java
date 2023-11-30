package com.example.umc_project.apiPayload.exception.handler;

import com.example.umc_project.apiPayload.code.BaseErrorCode;
import com.example.umc_project.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
