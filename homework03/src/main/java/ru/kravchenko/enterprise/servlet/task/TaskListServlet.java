package ru.kravchenko.enterprise.servlet.task;

import ru.kravchenko.enterprise.constant.FieldConst;
import ru.kravchenko.enterprise.entity.Task;
import ru.kravchenko.enterprise.repository.TaskRepository;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(urlPatterns = "/task-list")
public class TaskListServlet extends HttpServlet {

    @Inject
    private TaskRepository taskRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Collection<Task> tasks = taskRepository.findAll();
        req.setAttribute(FieldConst.TASKS, tasks);
        req.getRequestDispatcher("WEB-INF/views/task-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
