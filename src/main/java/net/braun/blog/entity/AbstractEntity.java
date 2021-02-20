package net.braun.blog.entity;

import net.braun.blog.model.AbstractModel;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractEntity<PK> extends AbstractModel implements Serializable {

    private static final long serialVersionUID = 7561734740783784963L;
    private PK id;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
