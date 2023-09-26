package com.adviseme.RESTful.model;

import com.adviseme.RESTful.model.enums.AdviceVisibility;
import com.adviseme.RESTful.model.enums.Status;
import com.adviseme.RESTful.model.enums.ViewLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class GuidanceHubPost extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    @NotNull
    @NotBlank
    @Size(max = 100, message = "title should not be more than 100 characters")
    private String title;
    @NotNull
    @NotBlank
    @Size(max = 500, message = "content should not be more than 500 characters")
    private String content;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ViewLevel viewLevel;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AdviceVisibility receivedAdvicesVisibility;
    @NotNull
    private boolean postAnonymity;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "guidanceHubPost",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,targetEntity = GuidancePostAdvice.class)
    private Set<GuidancePostAdvice> guidancePostAdviceSet;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId",referencedColumnName = "userId", nullable = false)
    private User user;

    @ManyToMany(mappedBy = "guidanceHubPosts" , fetch = FetchType.LAZY)
    private Set<Tag> tags= new HashSet<>();
}
