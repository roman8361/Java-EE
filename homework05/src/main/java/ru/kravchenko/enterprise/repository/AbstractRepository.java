package ru.kravchenko.enterprise.repository;

import org.jetbrains.annotations.NotNull;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

abstract class AbstractRepository {

    @PersistenceContext
    EntityManager em;

    <T> T getEntity(@NotNull final TypedQuery<T> query) {
        final List<T> resultList = query.getResultList();
        if (resultList.isEmpty()) return null;
        return resultList.get(0);
    }

}
