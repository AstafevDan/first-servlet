package com.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TaskDto {
    private final Long id;
    private final String title;
    private final BigDecimal completed;
    private final Long userId;    
}
