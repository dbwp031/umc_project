package com.example.umc_project.validation.validator;

import com.example.umc_project.validation.annotation.ExistCategories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

    @Override
    public boolean isValid(List<Long> value, ConstraintValidatorContext context) {
        return false;
    }

}
