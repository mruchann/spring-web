package yte.intern.springweb.model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record User(
        @NotBlank
        String name,

        @NotBlank
        String lastName,

        @Min(12)
        @Max(100)
        Integer age,

        @Email
        @NotEmpty
        String email,

        String nationalID,

        @PastOrPresent
        LocalDate birthdate,

        @Size(max = 250)
        String address,

        @NotBlank
        String username
) {
    @AssertFalse
    private boolean isAdmin() {
        return username.equals("admin");
    }
}
