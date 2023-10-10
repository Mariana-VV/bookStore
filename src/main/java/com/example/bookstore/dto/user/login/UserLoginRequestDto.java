package com.example.bookstore.dto.user.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserLoginRequestDto {

    private String email;

    private String password;
}
