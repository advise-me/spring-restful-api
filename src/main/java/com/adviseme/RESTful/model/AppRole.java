package com.adviseme.RESTful.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AppRole {
    private int roleId;

    @NotNull
    @NotBlank
    @Size(message = "role name should not be more than 70 characters")
    private String roleName;
}
