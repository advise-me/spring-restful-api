package com.adviseme.RESTful.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;


@Data
@Entity
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotNull
    @NotBlank
    @Size(max = 70,message = "email should not be more than 70 characters")
    @Column(length = 70, nullable = false)
    private String email;
    @NotNull
    @NotBlank
    @Size(max = 50, message = "username should not be more than 50 characters")
    @Column(length = 50, nullable = false)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 150, message = "password should not be more than 150 characters")
    @Column(length = 150, nullable = false)
    private String password;


    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "appRoleId",referencedColumnName = "roleId",nullable = false)
    AppRole appRole;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE,targetEntity = FavoriteAdviceCategory.class)
    private Set<FavoriteAdviceCategory> favoriteAdviceCategories;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,targetEntity = PasswordRecoveryLog.class)
    private Set<PasswordRecoveryLog> passwordRecoveryLogs;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, targetEntity = GuidancePostAdvice.class)
    private Set<GuidancePostAdvice> guidancePostAdvices;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, targetEntity = GuidanceHubPost.class)
    private Set<GuidanceHubPost> guidanceHubPost;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE, targetEntity = AdviceVote.class)
    private Set<AdviceVote> adviceVote;


}
