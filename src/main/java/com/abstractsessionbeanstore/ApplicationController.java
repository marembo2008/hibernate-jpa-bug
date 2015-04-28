
package com.abstractsessionbeanstore;

import java.io.Serializable;

import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

import com.abstractsessionbeanstore.sessionbean.ParentEntityFacade;

/**
 * @author  marembo
 * @since   Apr 28, 2015
 */
@Named
@SessionScoped
public class ApplicationController implements Serializable {
    private static final long serialVersionUID = -1343434343L;

    @EJB
    private ParentEntityFacade parentEntityFacade;

    private ParentEntity parentEntity;

    public void createAndReloadEntity() {
        parentEntity = new ParentEntity();

        final ChildEntity childEntity = new ChildEntity();
        for (int i = 0; i < 10; i++) {
            childEntity.getOtherEntities().add(new AnotherEntity());
        }

        System.out.println(parentEntity);
        parentEntity.setChildEntity(childEntity);
        parentEntityFacade.create(parentEntity);
        this.parentEntity = parentEntityFacade.find(parentEntity.getId());
        System.out.println(parentEntity);
    }

    public void editAndReloadEntity() {
        final ChildEntity childEntity = new ChildEntity();
        for (int i = 0; i < 10; i++) {
            childEntity.getOtherEntities().add(new AnotherEntity());
        }

        System.out.println(parentEntity);
        parentEntity.setChildEntity(childEntity);
        this.parentEntity = parentEntityFacade.edit(parentEntity);
        System.out.println(parentEntity);
    }

}
