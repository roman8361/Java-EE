package ru.kravchenko.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.enterprise.api.ProjectRepository;
import ru.kravchenko.enterprise.entity.Project;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@ViewScoped
@ManagedBean
@URLMapping(
        id = "project-list",
        pattern = "/project-list",
        viewId = "/WEB-INF/faces/project-list.xhtml")
public class ProjectListController {

    @Inject
    private ProjectRepository projectRepository;

    @NotNull
    private List<Project> projects = new ArrayList<>();

    @PostConstruct
    private void init() { reload(); }

    private void reload() {
        projects.clear();
        projects.addAll(projectRepository.findAll());
    }

    @NotNull
    public List<Project> getListProject() {
        return projects;
    }

    public void removeProjectById(@Nullable final String projectId) {
        projectRepository.removeById(projectId);
        reload();
    }

}
