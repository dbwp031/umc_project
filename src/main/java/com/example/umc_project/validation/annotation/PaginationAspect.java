/*
package com.example.umc_project.validation.annotation;

import com.example.umc_project.validation.annotation.CheckPageNumber;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PaginationAspect {
    @Before("@annotation(CheckPageNumber)")
    public void checkPageNumber(JoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println(joinPoint.getSignature());
        long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
    }
}*/
