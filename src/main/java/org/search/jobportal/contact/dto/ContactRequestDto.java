package org.search.jobportal.contact.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContactRequestDto {

    @NotBlank(message = "Email can not be empty")
    @Email(message = "Invalid Email Address")
    private String email;

    @NotBlank(message = "Message can not be empty")
    @Size(min=5, max = 500, message = "Message Must be between 5 and 500 characters")
    private String message;

    @NotBlank(message = "Name can not be empty")
    @Size(min=5, max = 500, message = "Name Must be between 5 and 30 characters")
    private String name;

    @NotBlank(message = "Subject can not be empty")
    @Size(min=5, max = 150, message = "subject Must be between 5 and 150 characters")
    private String subject;

    @NotBlank(message = "UserType can not be empty")
    @Pattern(regexp = "JobSeeker|Employer|Other", message = "UserType must be one of: Job Seeker, Employer, Other")
    private String userType;

}
