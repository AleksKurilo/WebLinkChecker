package com.web.link.checker.Audit;


import com.web.link.checker.model.EmbeddableData;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.util.Date;


public class AuditListener {

    @PrePersist
    public void setCreatedOn(Auditable auditable) {
        EmbeddableData embeddableData = auditable.getEmbeddableData();
        if (embeddableData == null) {
            embeddableData = new EmbeddableData();
            auditable.setEmbeddableData(embeddableData);
        }
        Date date = new Date();
        embeddableData.setCreateOn(new Timestamp(date.getTime()));
    }

    @PreUpdate
    public void setLastUpdate(Auditable auditable) {
        EmbeddableData embeddableData = auditable.getEmbeddableData();
        Date date = new Date();
        embeddableData.setLastUpdate(new Timestamp(date.getTime()));
    }
}
