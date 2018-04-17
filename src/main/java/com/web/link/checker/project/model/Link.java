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
    private String location;

    @NotEmpty
    private String href;

    private boolean dofollow;

    @Size(min = 1, max = 1000)
    private String anchor;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

}
