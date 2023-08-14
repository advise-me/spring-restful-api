package com.adviseme.RESTful.model;

import com.adviseme.RESTful.model.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GuidancePostAdvice extends ExtendedAuditingBase{
    private  int adviceId;
    @NotNull
    private  boolean adviceAnonymity;
    @NotNull
    @NotBlank
    @Size(max = 500, message = "post advice content should not be more than 500 characters")
    private String content;
    @NotNull
    private Status status;
    @NotNull
    private LocalDateTime lastAllowableEditingDate;

}
