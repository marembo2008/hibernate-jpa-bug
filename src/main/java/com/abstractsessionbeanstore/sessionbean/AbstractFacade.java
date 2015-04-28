
package com.abstractsessionbeanstore.sessionbean;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author  marembo
 * @since   Apr 28, 2015
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(final T entity) {
        getEntityManager().persist(entity);
    }

    public T edit(final T entity) {
        return getEntityManager().merge(entity);
    }

    public void remove(final T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(final Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(final int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));

        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));

        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
