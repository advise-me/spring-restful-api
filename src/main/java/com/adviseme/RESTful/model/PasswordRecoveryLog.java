package com.adviseme.RESTful.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PasswordRecoveryLog extends AuditingBase{
    private int logId;
    @NotNull
    @NotBlank
    @Size(max = 150, message = "old password should not be more than 150 characters")
    private  String oldPassword;
}
