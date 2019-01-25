package ru.kravchenko.enterprise.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.enterprise.entity.Task;
import java.util.Collection;

/**
 * @author Roman Kravchenko
 */

public interface TaskRepository {
    @Nullable
    Task findById(@Nullable String id);

    @NotNull
    Collection<Task> findAll();

    @Nullable
    Task getById(@Nullable final String taskId);

    @Nullable
    Task persist(@Nullable final Task task);

    @Nullable
    Task merge(@Nullable Task task);

    void removeById(@Nullable String id);

    void removeTask(@Nullable Task task);

    void removeAll();

}
