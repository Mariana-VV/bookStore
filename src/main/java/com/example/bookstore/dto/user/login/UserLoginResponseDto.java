package com.example.bookstore.dto.user.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data
public class UserLoginResponseDto {
    private String token;
}

