package com.example.bookstore.dto.user;

import com.example.bookstore.model.Role;
import com.example.bookstore.validation.FieldMatch;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    private String shippingAddress;

    private Set<Role> roles;
}
