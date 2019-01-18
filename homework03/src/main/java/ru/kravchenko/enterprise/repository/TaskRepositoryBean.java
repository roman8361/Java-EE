package ru.kravchenko.enterprise.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.enterprise.entity.Task;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class TaskRepositoryBean implements TaskRepository {

    @NotNull
    private Map<String, Task> tasks = new LinkedHashMap<>();

    @PostConstruct
    private void init() {merge(new Task("DEMO TASK")); }

    @NotNull
    public Collection<Task> findAll() { return tasks.values(); }

    @Nullable
    public Task findById(@Nullable String id) {
        if (id == null || id.isEmpty()) return null;
        return tasks.get(id);
    }

    @NotNull
    public Collection<Task> findByIds(@Nullable Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return Collections.emptySet();
        @NotNull final Collection<Task> result = new LinkedHashSet<>();
        for (@Nullable final String id: ids) {
            if (id == null || id.isEmpty()) continue;
            final Task task = findById(id);
            if (task == null) continue;
            result.add(task);
        }
        return  result;
    }

    @Nullable
    public Task merge(@Nullable Task task) {
        if (task == null) return task;
        @Nullable final String id = task.getId();
        if (id == null || id.isEmpty()) return null;
        tasks.put(id, task);
        return task;
    }

    @Nullable
    public Collection<Task> merge(@Nullable Collection<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) return Collections.emptySet();
        @NotNull final Collection<Task> result = new LinkedHashSet<>();
        for (@Nullable final Task task: tasks) {
            if (task == null) continue;
            result.add(merge(task));
        }
        return result;
    }

    @Override
    public void removeById(@Nullable String id) {
        if (id == null || id.isEmpty()) return;
        if (!tasks.containsKey(id)) return;
        tasks.remove(id);
    }

    @Override
    public void removeByIds(@Nullable Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return;
        for (@Nullable final String id: ids) removeById(id);
    }

    @Override
    public void remove(@Nullable Collection<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) return;
        for (@Nullable final Task task: tasks) {
            if (task == null) continue;
            removeById(task.getId());
        }
    }

    @Override
    public void removeAll() { tasks.clear(); }

}
