package com.example.umc_project.apiPayload.code.status;

import com.example.umc_project.apiPayload.code.BaseErrorCode;
import com.example.umc_project.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD404", "음식 카테고리를 찾을 수 없습니다"),

    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER404", "멤버id에 맞는 멤버를 찾을 수 없습니다"),
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND,"STORE404","스토어id에 맞는 스토어를 찾을 수 없습니다"),
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION404","미션id에 맞는 미션을 찾을 수 없습니다."),

    MISSION_ALREADY_ONGOING(HttpStatus.BAD_REQUEST, "MISSION4001", "이 멤버는 이미 해당 미션에 참여했습니다."),

    PAGE_NUMBER_NOT_ALLOWED(HttpStatus.BAD_REQUEST,"PAGE4001", "올바르지 않은 페이지 값입니다.")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }

}
