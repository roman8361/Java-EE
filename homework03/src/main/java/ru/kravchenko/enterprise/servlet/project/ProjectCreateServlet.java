package ru.kravchenko.enterprise.servlet.project;

import ru.kravchenko.enterprise.entity.Project;
import ru.kravchenko.enterprise.repository.ProjectRepositoty;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/project-create")
public class ProjectCreateServlet extends HttpServlet {

    @Inject
    private ProjectRepositoty projectRepositoty;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Project project = new Project();
        project.setName("New Project" + System.currentTimeMillis());
        projectRepositoty.merge(project);
        resp.sendRedirect("project-list");
    }

}
