package ru.kravchenko.enterprise.servlet.task;

import ru.kravchenko.enterprise.entity.Task;
import ru.kravchenko.enterprise.repository.TaskRepository;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/task-create")
public class TaskCreateServlet extends HttpServlet {

    @Inject
    private TaskRepository taskRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Task task = new Task();
        task.setName("New Task" + System.currentTimeMillis());
        taskRepository.merge(task);
        resp.sendRedirect("task-list");
    }

}
