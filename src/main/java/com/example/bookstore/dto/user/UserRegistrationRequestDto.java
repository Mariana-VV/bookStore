package com.example.bookstore.dto.user;

import com.example.bookstore.model.Role;
import com.example.bookstore.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.Data;

@Data
@FieldMatch(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "Password and repeatPassword are not the same !!!"
        )
public class UserRegistrationRequestDto {
    @NotBlank
    @Email
    private String email;
    private String password;
    private String repeatPassword;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String shippingAddress;
    private Set<Role> roles;
}
