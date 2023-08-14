package com.adviseme.RESTful.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FavoriteAdviceCategory extends AuditingBase{
    private int categoryId;

    @NotNull
    @NotBlank
    @Size(max = 150, message = "category name should not be more than 100 characters")
    private  String name;

    @Size(max = 300, message = "category description should not be more than 300 characters")
    private String description;
}
