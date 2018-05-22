package com.web.link.checker.model;


import com.web.link.checker.Audit.AuditListener;
import com.web.link.checker.Audit.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Data
@Table(
        indexes = {
                @Index(columnList = "uuid", name = "uuid", unique = true)
        })
@EqualsAndHashCode(exclude = {"links"})
@ToString(exclude = "links")
@EntityListeners(AuditListener.class)
public class Project implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NotEmpty
    private String uuid;

    @OneToMany(mappedBy = "project")
    private Set<Link> links;

    @Embedded
    private Audit audit;

}