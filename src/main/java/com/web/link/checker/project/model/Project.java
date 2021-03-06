package com.web.link.checker.project.model;

import lombok.*;
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
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NotEmpty
    private String uuid;

}