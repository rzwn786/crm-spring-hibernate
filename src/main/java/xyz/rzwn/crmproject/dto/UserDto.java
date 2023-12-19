package xyz.rzwn.crmproject.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

@Data
@Builder
public class UserDto {
    private long userID;

    @NotBlank(message = "Username required")
    private String username;

    @NotBlank(message = "First Name required")
    private String firstName;

    @NotBlank(message = "Last Name required")
    private String lastName;

    @NotBlank(message = "User Email required")
    @Email(message = "Insert Valid Email")
    private String userEmail;

    @NumberFormat
    @Pattern(regexp="(^$|[0-9]{10})",message = "Enter a valid phone number")
    @NotNull(message = "Enter a valid phone number")
    private String userPhone;

    private String password;
    private int roleID;
}
