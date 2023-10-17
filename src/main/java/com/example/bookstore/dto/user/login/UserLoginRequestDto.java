package com.example.bookstore.dto.user.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserLoginRequestDto {

    private String email;

    private String password;
}
