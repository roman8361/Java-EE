package ru.kravchenko.enterprise.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @NotNull
    private String id = UUID.randomUUID().toString();

    @Nullable
    private Date created;

    @Nullable
    private Date updated;

    @PrePersist
    private void prePersist() {
        created = new Date();
        updated = new Date();
    }

    @PreUpdate
    private void preUpdate() {
        if (created == null) created = new Date();
        updated = new Date();
    }

}
