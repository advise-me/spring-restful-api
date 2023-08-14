package com.adviseme.RESTful.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FavoriteAdvice extends AuditingBase{
    private int favoriteAdviceId;
    @NotNull
    @NotBlank
    @Size(max = 500, message = "advice content should not be more than 500 characters")
    private  String content;


}
