package com.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@ToString
@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class UserDataDto {
    private final Long id;
    private final String username;
    private final String email;
}
