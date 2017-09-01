package com.web.link.checker.project.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Data
@Table(
        indexes = {
                @Index(columnList = "uuid", name = "uuid")
        })
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    private String uuid;

}