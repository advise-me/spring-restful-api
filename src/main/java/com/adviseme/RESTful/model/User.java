package com.adviseme.RESTful.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class User extends  AuditingBase{
    private int userId;

    @NotNull
    @NotBlank
    @Size(max = 70,message = "email should not be more than 70 characters")
    private String email;
    @NotNull
    @NotBlank
    @Size(max = 50, message = "username should not be more than 50 characters")
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 150, message = "password should not be more than 150 characters")
    private String password;


}
