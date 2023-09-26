package com.adviseme.RESTful.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.generator.Generator;

import java.util.Set;

@Data
@Entity
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @NotNull
    @NotBlank
    @Size(message = "role name should not be more than 70 characters")
    @Column(nullable = false,length = 70)
    private String roleName;

    @OneToMany(mappedBy = "appRole",fetch = FetchType.LAZY, targetEntity = User.class)
    private Set<User> user;
}
