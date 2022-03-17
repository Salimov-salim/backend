/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registry.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "relation",schema = "general")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Relation.findAll", query = "SELECT r FROM Relation r")
//    , @NamedQuery(name = "Relation.findById", query = "SELECT r FROM Relation r WHERE r.id = :id")})
public class Relation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="general.relation_id_seq")
    @SequenceGenerator(sequenceName="general.relation_id_seq",name="general.relation_id_seq",allocationSize=1)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idpersonone", referencedColumnName = "id")
    @ManyToOne
    private Person idpersonone;
    @JoinColumn(name = "idpersontwo", referencedColumnName = "id")
    @ManyToOne
    private Person idpersontwo;
    @JoinColumn(name = "idrelationtype", referencedColumnName = "id")
    @ManyToOne
    private Relationtypes idrelationtype;
    @OneToMany(mappedBy = "idrelation")
    private Collection<Relationadditionalinfo> relationadditionalinfoCollection;

    public Relation() {
    }

    public Relation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getIdpersonone() {
        return idpersonone;
    }

    public void setIdpersonone(Person idpersonone) {
        this.idpersonone = idpersonone;
    }

    public Person getIdpersontwo() {
        return idpersontwo;
    }

    public void setIdpersontwo(Person idpersontwo) {
        this.idpersontwo = idpersontwo;
    }

    public Relationtypes getIdrelationtype() {
        return idrelationtype;
    }

    public void setIdrelationtype(Relationtypes idrelationtype) {
        this.idrelationtype = idrelationtype;
    }



    @Override
    public String toString() {
        return "com.registry.entity.Relation[ id=" + id + " ]";
    }
    
}
