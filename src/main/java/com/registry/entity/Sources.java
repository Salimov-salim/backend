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
@Table(name = "sources",schema = "general")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Sources.findAll", query = "SELECT s FROM Sources s")
//    , @NamedQuery(name = "Sources.findById", query = "SELECT s FROM Sources s WHERE s.id = :id")
//    , @NamedQuery(name = "Sources.findByTitle", query = "SELECT s FROM Sources s WHERE s.title = :title")
//    , @NamedQuery(name = "Sources.findByDescription", query = "SELECT s FROM Sources s WHERE s.description = :description")})
public class Sources implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "idsource")
    private Collection<PersonAnnouncement> personAnnouncementCollection;

    public Sources() {
    }

    public Sources(Integer id) {
        this.id = id;
    }

    public Sources(Integer id, String title) {
        this.id = id;
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "com.registry.entity.Sources[ id=" + id + " ]";
    }
    
}
