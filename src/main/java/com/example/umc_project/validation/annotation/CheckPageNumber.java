package com.example.umc_project.validation.annotation;

import com.example.umc_project.validation.validator.PageNumberValidator;
import com.example.umc_project.validation.validator.StoreExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPageNumber {
    String message() default "올바르지 않은 페이지 넘버 값입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
