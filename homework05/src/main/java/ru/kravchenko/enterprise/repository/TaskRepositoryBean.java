package ru.kravchenko.enterprise.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.enterprise.api.TaskRepository;
import ru.kravchenko.enterprise.entity.Task;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Stateless
public class TaskRepositoryBean extends AbstractRepository implements TaskRepository {

    @NotNull
    public @Nullable Task findById(@Nullable String id) {
        return em.find(Task.class, id);
    }

    @NotNull
    public List<Task> findAll() {
        return em.createQuery("SELECT e FROM Task e ORDER BY e.created DESC", Task.class).getResultList();
    }

    @Nullable
    public Task getById(@Nullable final String taskId) {
        if (taskId == null || taskId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT e FROM Task e WHERE e.id = :id", Task.class)
                .setParameter("id", taskId)
                .setMaxResults(1));
    }

    @Nullable
    public Task persist(@Nullable final Task task) {
        if (task == null) return null;
        em.persist(task);
        return task;
    }

    @Nullable
    public Task merge(@Nullable Task task) {
        if (task == null) return null;
        return em.merge(task);
    }

    public void removeById(@Nullable String taskId) {
        @Nullable final Task task = getById(taskId);
        if (task == null) return;
        em.remove(task);
    }

    public void removeTask(@Nullable Task task) { em.remove(task); }

    public void removeAll() { em.createQuery("DELETE FROM Task ").executeUpdate(); }

}
