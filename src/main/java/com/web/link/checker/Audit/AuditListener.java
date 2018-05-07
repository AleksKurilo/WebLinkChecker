package com.web.link.checker.Audit;


import com.web.link.checker.model.Audit;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class AuditListener {

    @PrePersist
    public void setCreatedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();
        if (audit == null) {
            audit = new Audit();
            auditable.setAudit(audit);
        }
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        audit.setModified(new Timestamp(now.toInstant().toEpochMilli()));
    }

    @PreUpdate
    public void setLastUpdate(Auditable auditable) {
        Audit audit = auditable.getAudit();
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        audit.setModified(new Timestamp(now.toInstant().toEpochMilli()));
    }
}
