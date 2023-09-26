package com.adviseme.RESTful.model;

import com.adviseme.RESTful.model.enums.VoteType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class AdviceVote extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voteId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private VoteType voteType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "adviceId",referencedColumnName = "adviceId",nullable = false)
    private GuidancePostAdvice guidancePostAdvice;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId",referencedColumnName = "userId",nullable = false)
    private User user;

}
