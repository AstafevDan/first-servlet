package com.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Task {
    private Long id;
    private String title;
    private BigDecimal completed;
    //private LocalDateTime taskDate;
    private Long categoryId;
    private Long priorityId;
    private Long userId;
}
