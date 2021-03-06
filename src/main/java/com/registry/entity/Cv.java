/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registry.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "cv")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Cv.findAll", query = "SELECT c FROM Cv c")
        , @NamedQuery(name = "Cv.findById", query = "SELECT c FROM Cv c WHERE c.id = :id")
        , @NamedQuery(name = "Cv.findByInsertdate", query = "SELECT c FROM Cv c WHERE c.insertdate = :insertdate")})
public class Cv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="general.cv_id_seq")
    @SequenceGenerator(sequenceName="general.cv_id_seq",name="general.cv_id_seq",allocationSize=1)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "content")
    private byte[] content;
    @Column(name = "insertdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertdate;
    @OneToMany(mappedBy = "idcv")
    private Collection<Person> personCollection;

    public Cv() {
    }

    public Cv(byte[] content, Date insertdate) {
        this.content = content;
        this.insertdate = insertdate;
    }

    public Cv(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }



    @Override
    public String toString() {
        return "com.registry.entity.Cv[ id=" + id + " ]";
    }

}