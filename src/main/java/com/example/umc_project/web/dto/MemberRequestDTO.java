package com.example.umc_project.web.dto;

import com.example.umc_project.validation.annotation.ExistCategories;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MemberRequestDTO {

        @Getter
        public static class JoinDto{
            @NotBlank
            String name;
            @NotNull
            Integer age;
            @NotNull
            Integer gender;
            @NotNull
            Integer birthYear;
            @NotNull
            Integer birthMonth;
            @NotNull
            Integer birthDay;
            @Size(min = 5, max = 12)
            String address;
            @Size(min = 5, max = 12)
            String specAddress;
            @NotNull
            String email;
            @ExistCategories
            List<Long> preferCategory;

        }
}

