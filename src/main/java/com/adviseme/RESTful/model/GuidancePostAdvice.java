package com.adviseme.RESTful.model;

import com.adviseme.RESTful.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
public class GuidancePostAdvice extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int adviceId;

    @NotNull
    private  boolean adviceAnonymity;
    @NotNull
    @NotBlank
    @Size(max = 500, message = "post advice content should not be more than 500 characters")
    private String content;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull
    private LocalDateTime lastAllowableEditingDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId",referencedColumnName = "userId",nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "postId",referencedColumnName = "postId",nullable = false)
    private GuidanceHubPost guidanceHubPost;

    @OneToMany(mappedBy = "guidancePostAdvice", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE, targetEntity = AdviceVote.class)
    private Set<AdviceVote> adviceVote;


}
