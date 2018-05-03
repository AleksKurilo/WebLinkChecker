package com.web.link.checker.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.sql.Timestamp;

@Data
@Embeddable
public class EmbeddableData {

    private Timestamp createOn;
    private Timestamp lastUpdate;
}
