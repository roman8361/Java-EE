package ru.kravchenko.enterprise.entity;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

/**
 * @author Roman Kravchenko
 */

@Data
public class Task extends AbstractEntity {

    @Nullable
    private Project project;

    @Nullable
    private String name;

    @Nullable
    private String description;

    public Task() {}

    public Task(@Nullable String name) { this.name = name; }

}
