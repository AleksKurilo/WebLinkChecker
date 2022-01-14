package com.web.link.checker.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Audit {

    private long created;
    private long modified;
}
