package com.example.umc_project.validation.validator;

import com.example.umc_project.apiPayload.code.status.ErrorStatus;
import com.example.umc_project.validation.annotation.CheckPageNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
@Component
@RequiredArgsConstructor
public class PageNumberValidator implements ConstraintValidator<CheckPageNumber, Integer> {
    @Override
    public void initialize(CheckPageNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        Boolean isValid = value >= 1;
        if(!isValid){
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NUMBER_NOT_ALLOWED.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
