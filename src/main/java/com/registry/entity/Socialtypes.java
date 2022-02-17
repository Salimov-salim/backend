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
@Table(name = "socialtypes",schema = "general")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Socialtypes.findAll", query = "SELECT s FROM Socialtypes s")
//    , @NamedQuery(name = "Socialtypes.findById", query = "SELECT s FROM Socialtypes s WHERE s.id = :id")
//    , @NamedQuery(name = "Socialtypes.findByName", query = "SELECT s FROM Socialtypes s WHERE s.name = :name")})
public class Socialtypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "idsocialpage")
    private Collection<Personsocialnetworks> personsocialnetworksCollection;

    public Socialtypes() {
    }

    public Socialtypes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "com.registry.entity.Socialtypes[ id=" + id + " ]";
    }
    
}
