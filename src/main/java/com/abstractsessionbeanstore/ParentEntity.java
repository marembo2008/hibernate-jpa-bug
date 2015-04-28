
package com.abstractsessionbeanstore;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author  marembo
 * @since   Apr 28, 2015
 */
@Entity
public class ParentEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id = System.currentTimeMillis();

    @OneToOne(cascade = CascadeType.ALL)
    private ChildEntity childEntity;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setChildEntity(final ChildEntity childEntity) {
        this.childEntity = childEntity;
    }

    public ChildEntity getChildEntity() {
        return childEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(final Object object) {

        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParentEntity)) {
            return false;
        }

        ParentEntity other = (ParentEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "ParentEntity[ id=" + id + ", childEntity=" + childEntity + " ]";
    }

}
