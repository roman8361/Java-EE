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

@WebServlet(urlPatterns = "/task-save")
public class TaskSaveServlet extends HttpServlet {

    @Inject
    private TaskRepository taskRepository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter(FieldConst.ID);
        if (id == null || id.isEmpty()) {
            sendRedirectTaskList(resp);
            return;
        }
        final Task task = taskRepository.findById(id);
        if (task == null) {
            sendRedirectTaskList(resp);
            return;
        }
        task.setName(req.getParameter(FieldConst.NAME));
        task.setDescription(req.getParameter(FieldConst.DESCRIPTION));
        taskRepository.merge(task);
        sendRedirectTaskList(resp);
    }

    private void sendRedirectTaskList(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("task-list");
    }

}
