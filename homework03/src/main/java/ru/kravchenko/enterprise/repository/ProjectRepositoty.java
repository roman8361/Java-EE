package ru.kravchenko.enterprise.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.enterprise.entity.Project;
import java.util.Collection;

public interface ProjectRepositoty {

    @NotNull
    Collection<Project> findAll();

    @Nullable
    Project findById(@Nullable String id);

    @NotNull
    Collection<Project> findByIds(@Nullable Collection<String> ids);

    @Nullable
    Project merge(@Nullable Project project);

    @Nullable
    Collection<Project> merge(@Nullable Collection<Project> projects);

    void removeById(@Nullable String id);

    void removeByIds(@Nullable Collection<String> ids);

    void remove(@Nullable Collection<Project> projects);

    void removeAll();

}
