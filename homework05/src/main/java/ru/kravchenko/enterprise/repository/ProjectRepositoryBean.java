package ru.kravchenko.enterprise.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.enterprise.api.ProjectRepository;
import ru.kravchenko.enterprise.entity.Project;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Stateless
public class ProjectRepositoryBean extends AbstractRepository implements ProjectRepository {

    @NotNull
    public @Nullable Project findById(@Nullable String id) {
        return em.find(Project.class, id);
    }


    @NotNull
    public List<Project> findAll() {
        return em.createQuery("SELECT e FROM Project e ORDER BY e.created DESC", Project.class).getResultList();
    }

    @Nullable
    public Project getById(@Nullable final String projectId) {
        if (projectId == null || projectId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT e FROM Project e WHERE e.id = :id", Project.class)
                .setParameter("id", projectId)
                .setMaxResults(1));
    }

    @Nullable
    public Project persist(@Nullable final Project project) {
        if (project == null) return null;
        em.persist(project);
        return project;
    }

    @Nullable
    public Project merge(@Nullable Project project) {
        if (project == null) return null;
        return em.merge(project);
    }

    public void removeById(@Nullable String projectId) {
        @Nullable final Project project = getById(projectId);
        if (project == null) return;
        em.remove(project);
    }

    public void removeProject(@Nullable Project project) { em.remove(project); }

    public void removeAll() { em.createQuery("DELETE FROM Project ").executeUpdate(); }

}
