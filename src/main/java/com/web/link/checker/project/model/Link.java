package com.web.link.checker.project.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Link {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(min = 3, max = 255)
    private String location;

    @NotEmpty
    @Size(min = 3, max = 255)
    private String follow;

    @NotNull
    private Boolean dofollow;

    @NotEmpty
    private String anchor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

}
