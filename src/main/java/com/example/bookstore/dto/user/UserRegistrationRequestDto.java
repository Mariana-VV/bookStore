package com.example.bookstore.dto.user;

import com.example.bookstore.validation.FieldMatch;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@FieldMatch(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "öadhfwahf"
        )
public class UserRegistrationRequestDto {
    @NotBlank
    @Size(min = 4, max = 50)
    private String email;
    @NotBlank
    @Size(min = 4, max = 100)
    private String password;
    @NotBlank
    @Size(min = 4, max = 100)
    private String repeatPassword;
    private String firstName;
    private String lastName;
    private String adress;
}
