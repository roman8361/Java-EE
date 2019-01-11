package ru.kravchenko.enterprise.servlet.project;

import ru.kravchenko.enterprise.constant.FieldConst;
import ru.kravchenko.enterprise.entity.Project;
import ru.kravchenko.enterprise.repository.ProjectRepositoty;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/project-edit")
public class ProjectEditServlet extends HttpServlet {

    @Inject
    private ProjectRepositoty projectRepositoty;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String projectId = req.getParameter(FieldConst.ID);
        final Project project = projectRepositoty.findById(projectId);
        if (project == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        req.setAttribute(FieldConst.PROJECT, project);
        req.getRequestDispatcher("WEB-INF/views/project-edit.jsp").forward(req, resp);
    }

}
