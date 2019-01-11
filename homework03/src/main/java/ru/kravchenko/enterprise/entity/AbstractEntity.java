package ru.kravchenko.enterprise.entity;

import lombok.Data;
import org.jetbrains.annotations.Nullable;
import java.util.UUID;

@Data
public abstract class AbstractEntity {

    @Nullable
    private String id = UUID.randomUUID().toString();

}
