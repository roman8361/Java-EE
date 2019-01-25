package ru.kravchenko.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.enterprise.api.TaskRepository;
import ru.kravchenko.enterprise.entity.Task;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 * @author Roman Kravchenko
 */

@ViewScoped
@ManagedBean
@URLMapping(
        id = "task-new",
        pattern = "/task-new",
        viewId = "/WEB-INF/faces/task-new.xhtml")
public class TaskNewController {

    @Inject
    private TaskRepository taskRepository;

    @Nullable
    private String id;

    @NotNull
    private Task task = new Task();

    public void init() {
        @Nullable final Task task = taskRepository.findById(id);
        if (task != null) this.task = task;
    }

    public String save() {
        taskRepository.merge(task);
        return "task-list";
    }

    @NotNull
    public Task getTask() { return task; }

    public void setTask(@NotNull final Task task) { this.task = task; }

    @Nullable
    public String getId() { return id; }

    public void setId(@Nullable final String id) { this.id = id; }

}
