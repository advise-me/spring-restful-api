package com.adviseme.RESTful.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class PasswordRecoveryLog extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;

    @NotNull
    @NotBlank
    @Size(max = 150, message = "old password should not be more than 150 characters")
    @Column(length = 70,nullable = false)
    private  String oldPassword;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId",referencedColumnName = "userId",nullable = false)
    private User user;
}
