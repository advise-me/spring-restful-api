package com.adviseme.RESTful.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Tag extends AuditingBase{
    private  int tagId;
    @NotNull
    @NotBlank
    @Size(max = 100, message = "tag name should not be more than 100 characters")
    private String name;

}
