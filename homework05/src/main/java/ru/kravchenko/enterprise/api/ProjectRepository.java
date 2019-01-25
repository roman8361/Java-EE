package ru.kravchenko.enterprise.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.enterprise.entity.Project;
import java.util.Collection;

/**
 * @author Roman Kravchenko
 */

public interface ProjectRepository {

    @Nullable
    Project findById(@Nullable String id);

    @NotNull
    Collection<Project> findAll();

    @Nullable
    public Project getById(@Nullable final String projectId);

    @Nullable
    Project persist(@Nullable final Project project);

    @Nullable
    Project merge(@Nullable Project project);

    void removeById(@Nullable String id);

    void removeProject(@Nullable Project project);

    void removeAll();

}
