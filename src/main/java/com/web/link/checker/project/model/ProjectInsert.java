package com.web.link.checker.project.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;


@Data
public class ProjectInsert {

    @NotNull
    @Size(min = 3, max = 255)
    private String name;

}
