package com.web.link.checker.Audit;

import com.web.link.checker.model.Audit;

public interface Auditable {

    Audit getAudit();

    void setAudit(Audit audit);
}
