package ru.kravchenko.enterprise.entity;

import lombok.Data;
import org.jetbrains.annotations.Nullable;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

@Data
public abstract class AbstractEntity {

    @Nullable
    private String id = UUID.randomUUID().toString();

}
