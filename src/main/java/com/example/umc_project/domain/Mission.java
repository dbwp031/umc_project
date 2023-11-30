package com.example.umc_project.domain;

import com.example.umc_project.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Store store;

    private String content;

    private Float reward;

    private LocalDateTime deadline;
}
