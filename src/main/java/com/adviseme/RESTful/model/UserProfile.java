package com.adviseme.RESTful.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class UserProfile extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int profileId;

    @NotNull
    @NotBlank
    @Size(max = 50, message = "first name should not be more than 50 characters")
    private  String firstName;
    @NotNull
    @NotBlank
    @Size(max = 50, message = "last name should not be more than 50 characters")
    private String lastName;
    @NotNull
    @NotBlank
    @Size(max = 300, message = "profile description should not be more than 300 characters")
    private String profileDescription;

    @Size(max = 500, message = "profile image link should not be more than 500 characters")
    private String profileImageLink;

    @Size(max = 20, message = "phone number should not be more than 20 characters")
    private String phoneNumber;

    @OneToOne(optional = false,fetch = FetchType.EAGER,targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",referencedColumnName = "userId",nullable = false)
    private User user;

}
