package com.example.bookstore.dto.user;

import com.example.bookstore.validation.FieldMatch;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@FieldMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "password do not match with repeatPassword!"
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
}
