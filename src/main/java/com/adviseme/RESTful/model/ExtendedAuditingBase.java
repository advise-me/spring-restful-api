package com.adviseme.RESTful.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExtendedAuditingBase extends AuditingBase{
    private String  deletedBy;
    public LocalDateTime deletedAt;
}
