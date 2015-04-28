
package com.abstractsessionbeanstore;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author  marembo
 * @since   Apr 28, 2015
 */
@Entity
public class ChildEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AnotherEntity> otherEntities;

    @PrePersist
    void checkOtherEntities() {

        // This entity is null at this point. when a merge of containg ParentEntity and new ChildEntity is done.
        if (otherEntities == null) {
            throw new NullPointerException("otherentities is null");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public List<AnotherEntity> getOtherEntities() {
        return otherEntities == null ? (otherEntities = new ArrayList<>()) : otherEntities;
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
        if (!(object instanceof ChildEntity)) {
            return false;
        }

        ChildEntity other = (ChildEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "ChildEntity[ id=" + id + ", otherEntities=" + otherEntities + " ]";
    }

}
