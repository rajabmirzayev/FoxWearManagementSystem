package com.library.foxwearmanagement.dto.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserRequest {
    @NotBlank(message = "First name is required")
    @Size(min = 3, max = 50, message = "First name must be between 3 and 50 characters")
    String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 50, message = "Last name must be between 3 and 50 characters")
    String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be a valid email address")
    @Size(max = 255, message = "Email must not exceed 255 characters")
    @Column(unique = true)
    String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/]).{8,100}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character.")
    String password;

    @NotBlank(message = "Phone number is required")
    @Column(unique = true)
    @Size(min = 9, max = 17, message = "Phone number must be valid")
    String phoneNumber;

    String profileImageUrl;
}
