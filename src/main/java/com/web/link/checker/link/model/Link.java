package com.web.link.checker.link.model;

import com.web.link.checker.project.model.Project;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
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
    @Column(columnDefinition = "TEXT")
    private String uuid;

    @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String location;

    @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String href;

    private boolean dofollow;

    @Size(min = 1, max = 1000)
    private String anchor;

    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

}
