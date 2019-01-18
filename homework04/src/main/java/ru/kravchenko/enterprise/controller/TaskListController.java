package ru.kravchenko.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import ru.kravchenko.enterprise.api.TaskRepository;
import ru.kravchenko.enterprise.entity.Task;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Collection;

/**
 * @author Roman Kravchenko
 */

@ViewScoped
@ManagedBean
@URLMapping(
        id = "task-list",
        pattern = "/task-list",
        viewId = "/WEB-INF/faces/task-list.xhtml")
public class TaskListController {

    @Inject
    private TaskRepository taskRepository;

    public Collection<Task> getListTask() {
        return taskRepository.findAll();
    }

    public void removeTaskById(String taskId) {
        taskRepository.removeById(taskId);
    }

}
