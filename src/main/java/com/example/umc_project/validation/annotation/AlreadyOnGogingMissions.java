package com.example.umc_project.validation.annotation;

import com.example.umc_project.validation.validator.CategoriesExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoriesExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface AlreadyOnGogingMissions {

    String message() default "해당 미션은 이미 진행 중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
