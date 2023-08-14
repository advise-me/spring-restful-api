package com.adviseme.RESTful.model;

import com.adviseme.RESTful.model.enums.AdviceVisibility;
import com.adviseme.RESTful.model.enums.Status;
import com.adviseme.RESTful.model.enums.ViewLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GuidanceHubPost extends ExtendedAuditingBase{
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
    private ViewLevel viewLevel;
    @NotNull
    private AdviceVisibility receivedAdvicesVisibility;
    @NotNull
    private boolean postAnonymity;
    @NotNull
    private Status status;

}
