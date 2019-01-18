package ru.kravchenko.enterprise.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@NoArgsConstructor
public class Task extends AbstractEntity {

    @Nullable
    private Project project;

    @Nullable
    private String name;

    @Nullable
    private String description;

    public Task(@Nullable String name) { this.name = name; }

}
