/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registry.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "educationtype",schema = "general")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Educationtype.findAll", query = "SELECT e FROM Educationtype e")
//    , @NamedQuery(name = "Educationtype.findById", query = "SELECT e FROM Educationtype e WHERE e.id = :id")
//    , @NamedQuery(name = "Educationtype.findByType", query = "SELECT e FROM Educationtype e WHERE e.type = :type")})
public class Educationtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
