
package com.abstractsessionbeanstore.sessionbean;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.abstractsessionbeanstore.ChildEntity;

/**
 * @author  marembo
 * @since   Apr 28, 2015
 */
@Stateless
public class ChildEntityFacade extends AbstractFacade<ChildEntity> {

    @PersistenceContext(unitName = "abstractsessionbeanstore_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChildEntityFacade() {
        super(ChildEntity.class);
    }

}
