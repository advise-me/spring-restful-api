package com.adviseme.RESTful.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class FavoriteAdvice extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favoriteAdviceId;

    @NotNull
    @NotBlank
    @Size(max = 500, message = "advice content should not be more than 500 characters")
    private  String content;

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId",referencedColumnName = "categoryId",nullable = false)
    private FavoriteAdviceCategory favoriteAdviceCategory;



}
