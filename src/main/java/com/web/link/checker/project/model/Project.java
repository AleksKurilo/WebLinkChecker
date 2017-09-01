package com.web.link.checker.project.model;

import lombok.*;
import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Indexed
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @Field
    private String uuid;

}