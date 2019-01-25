package ru.kravchenko.enterprise.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.enterprise.api.ProjectRepositoty;
import ru.kravchenko.enterprise.entity.Project;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

/**
 * @author Roman Kravchenko
 */

@ApplicationScoped
public class ProjectRepositoryBean implements ProjectRepositoty {


    @NotNull
    private Map<String, Project> projects = new LinkedHashMap<>();

    @PostConstruct
    private void init() { merge(new Project("DEMO PROJECT")); }

    @NotNull
    public Collection<Project> findAll() { return projects.values(); }

    @Nullable
    public Project findById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return projects.get(id);
    }

    @NotNull
    @Override
    public Collection<Project> findByIds(@Nullable final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return Collections.emptySet();
        @NotNull final Collection<Project> result = new LinkedHashSet<>();
        for (@Nullable final String id: ids) {
            if (id == null || id.isEmpty()) continue;
            final Project project = findById(id);
            if (project == null) continue;
            result.add(project);
        }
        return result;
    }

    @Nullable
    public Project merge(@Nullable Project project) {
        if (project == null) return null;
        @Nullable final String id = project.getId();
        if (id == null || id.isEmpty()) return null;
        projects.put(id, project);
        return project;
    }

    @Nullable
    public Collection<Project> merge(@Nullable Collection<Project> projects) {
        if (projects == null || projects.isEmpty()) return Collections.emptySet();
        @NotNull final Collection<Project> result = new LinkedHashSet<>();
        for (@Nullable final Project project: projects) {
            if (project == null) continue;
            result.add(merge(project));
        }
        return result;
    }

    public void removeById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return;
        if (!projects.containsKey(id)) return;
        projects.remove(id);
    }

    public void removeByIds(@Nullable final Collection<String> ids) {
        if (ids == null || ids.isEmpty()) return;
        for (@Nullable final String id: ids) removeById(id);
    }

    public void remove(@Nullable final Collection<Project> projects) {
        if (projects == null || projects.isEmpty()) return;
        for (@Nullable final Project project: projects) {
            if (project == null) continue;
            removeById(project.getId());
        }
    }

    @Override
    public void removeAll() { projects.clear(); }

}
