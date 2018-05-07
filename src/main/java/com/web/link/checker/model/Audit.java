package com.web.link.checker.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.sql.Timestamp;

@Data
@Embeddable
public class Audit {

    private Timestamp created;
    private Timestamp modified;
}
