
package com.abstractsessionbeanstore.sessionbean;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.abstractsessionbeanstore.ParentEntity;

/**
 * @author  marembo
 * @since   Apr 28, 2015
 */
@Stateless
public class ParentEntityFacade extends AbstractFacade<ParentEntity> {
    @PersistenceContext(unitName = "abstractsessionbeanstore_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParentEntityFacade() {
        super(ParentEntity.class);
    }

}
