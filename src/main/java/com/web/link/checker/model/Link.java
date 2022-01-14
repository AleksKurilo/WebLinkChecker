package com.web.link.checker.model;

import com.web.link.checker.Audit.AuditListener;
import com.web.link.checker.Audit.Auditable;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Data
@Table(
        indexes = {
                @Index(columnList = "uuid", name = "uuid", unique = true)
        })
@EntityListeners(AuditListener.class)
public class Link implements Auditable {

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

    @Column(columnDefinition = "TEXT")
    private String anchor;

    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Embedded
    private Audit audit;
}
