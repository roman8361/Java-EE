package ru.kravchenko.enterprise.entity;

import lombok.Data;
import org.jetbrains.annotations.Nullable;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Data
public class Project extends AbstractEntity {

    @Nullable
    private String name = "";

    @Nullable
    private String description = "";

    @Nullable
    private Date dateBegin;

    @Nullable
    private Date dateEnd;

    public Project() {}

    public Project(@Nullable final String name) { this.name = name; }

}
