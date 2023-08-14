package com.adviseme.RESTful.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdviceVote extends AuditingBase{

    private int voteId;

    @NotNull
    private AdviceVote voteType;

}
