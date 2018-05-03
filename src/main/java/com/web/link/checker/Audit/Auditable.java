package com.web.link.checker.Audit;

import com.web.link.checker.model.EmbeddableData;

public interface Auditable {

    EmbeddableData getEmbeddableData();

    void setEmbeddableData(EmbeddableData embeddableData);
}
