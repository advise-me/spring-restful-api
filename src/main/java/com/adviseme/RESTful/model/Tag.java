package com.adviseme.RESTful.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
public class Tag extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int tagId;
    @NotNull
    @NotBlank
    @Size(max = 100, message = "tag name should not be more than 100 characters")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TagGuidanceJointTable",joinColumns =
            {
            @JoinColumn(name = "tagId",referencedColumnName = "tagId"),

            },
    inverseJoinColumns = {
            @JoinColumn(name = "postId",referencedColumnName = "postId")
    })
    private Set<GuidanceHubPost> guidanceHubPosts = new HashSet<>();

}
