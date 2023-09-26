package com.adviseme.RESTful.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class FavoriteAdviceCategory extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @NotNull
    @NotBlank
    @Size(max = 150, message = "category name should not be more than 100 characters")
    @Column(nullable = false)
    private  String name;

    @Size(max = 300, message = "category description should not be more than 300 characters")
    private String description;

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "userId",referencedColumnName = "userId",nullable = false)
    private User user;

    @OneToMany(mappedBy = "favoriteAdviceCategory",targetEntity = FavoriteAdvice.class,fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set<FavoriteAdvice> favoriteAdvices;
}
