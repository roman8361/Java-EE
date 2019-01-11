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

@WebServlet(urlPatterns = "/task-edit")
public class TaskEditServlet extends HttpServlet {

    @Inject
    private TaskRepository taskRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String taskId = req.getParameter(FieldConst.ID);
        final Task task = taskRepository.findById(taskId);
        if (task == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        req.setAttribute(FieldConst.TASK, task);
        req.getRequestDispatcher("WEB-INF/views/task-edit.jsp").forward(req, resp);
    }

}
