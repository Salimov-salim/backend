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
@Table(name = "educationtype")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Educationtype.findAll", query = "SELECT e FROM Educationtype e")
//    , @NamedQuery(name = "Educationtype.findById", query = "SELECT e FROM Educationtype e WHERE e.id = :id")
//    , @NamedQuery(name = "Educationtype.findByType", query = "SELECT e FROM Educationtype e WHERE e.type = :type")})
public class Educationtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="general.educationtype_id_seq")
    @SequenceGenerator(sequenceName="general.educationtype_id_seq",name="general.educationtype_id_seq",allocationSize=1)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "ideducationtype")
    private Collection<PersonEducation> personEducationCollection;

    public Educationtype() {
    }

    public Educationtype(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "com.registry.entity.Educationtype[ id=" + id + " ]";
    }
    
}
