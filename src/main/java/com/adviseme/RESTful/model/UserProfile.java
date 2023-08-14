package com.adviseme.RESTful.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserProfile extends AuditingBase{
    private  int profileId;

    @NotNull
    @NotBlank
    @Size(max = 50, message = "first name should not be more than 50 characters")
    private  String firstName;
    @NotNull
    @NotBlank
    @Size(max = 50, message = "last name should not be more than 50 characters")
    private String lastName;
    @NotNull
    @NotBlank
    @Size(max = 300, message = "profile description should not be more than 300 characters")
    private String profileDescription;

    private String profileImageLink;

    @Size(max = 20, message = "phone number should not be more than 20 characters")
    private String phoneNumber;

}
