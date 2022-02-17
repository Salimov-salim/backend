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
@Table(name = "universities",schema = "general")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Universities.findAll", query = "SELECT u FROM Universities u")
//    , @NamedQuery(name = "Universities.findById", query = "SELECT u FROM Universities u WHERE u.id = :id")
//    , @NamedQuery(name = "Universities.findByName", query = "SELECT u FROM Universities u WHERE u.name = :name")
//    , @NamedQuery(name = "Universities.findByStatus", query = "SELECT u FROM Universities u WHERE u.status = :status")
//    , @NamedQuery(name = "Universities.findByLocation", query = "SELECT u FROM Universities u WHERE u.location = :location")})
public class Universities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private String status;
    @Column(name = "location")
    private String location;
    @OneToMany(mappedBy = "iduniversity")
    private Collection<PersonEducation> personEducationCollection;

    public Universities() {
    }

    public Universities(Integer id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    @Override
    public String toString() {
        return "com.registry.entity.Universities[ id=" + id + " ]";
    }
    
}
