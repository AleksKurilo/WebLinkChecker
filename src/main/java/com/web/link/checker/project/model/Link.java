package com.web.link.checker.project.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(
        indexes = {
                @Index(columnList = "uuid", name = "uuid", unique = true)
        })
public class Link {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String uuid;

    @NotEmpty
    @Size(min = 3, max = 255)
    private String location;

    @NotEmpty
    private String follow;

    @NotNull
    private Boolean dofollow;

    @NotEmpty
    @Size(min = 1, max = 255)
    private String anchor;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

}
