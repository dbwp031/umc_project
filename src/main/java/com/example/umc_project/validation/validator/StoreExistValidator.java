package com.example.umc_project.validation.validator;

import com.example.umc_project.apiPayload.code.status.ErrorStatus;
import com.example.umc_project.service.StoreService.StoreCommandServiceImpl;
import com.example.umc_project.service.StoreService.StoreQueryService;
import com.example.umc_project.validation.annotation.ExistStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {
    private final StoreQueryService storeQueryService;
    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = storeQueryService.findByStoreId(value).equals(null);
        // findByStoreId에서 이미 exception 처리가 된다. 단지 서비스 단에 들어왔을 때 해당 id가 이미 존재한다는 것을 보장하기 위한 코드.
        // controller 단에서 처리하지 않고, service 단에서 findByStoreId를 해도 되긴 하지만, 만약 들어온 id를 findByStoreId하지 않고 사용할 가능성이 있기 때문에
        // controller 단에서 한번 처리해주고 넘어가는게 좋다.
        // 서비스 단에 내려온 id값은 존재성이 보장되어야 한다.
//        if (!isValid) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
//        }
        return isValid;
    }
}
