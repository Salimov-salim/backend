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
@Table(name = "relationtypes",schema = "general")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Relationtypes.findAll", query = "SELECT r FROM Relationtypes r")
//    , @NamedQuery(name = "Relationtypes.findById", query = "SELECT r FROM Relationtypes r WHERE r.id = :id")
//    , @NamedQuery(name = "Relationtypes.findByTitle", query = "SELECT r FROM Relationtypes r WHERE r.title = :title")})
public class Relationtypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "idrelationtype")
    private Collection<Relation> relationCollection;

    public Relationtypes() {
    }

    public Relationtypes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    @Override
    public String toString() {
        return "com.registry.entity.Relationtypes[ id=" + id + " ]";
    }
    
}
