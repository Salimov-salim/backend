/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registry.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "relationadditionalinfo",schema = "general")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Relationadditionalinfo.findAll", query = "SELECT r FROM Relationadditionalinfo r")
//    , @NamedQuery(name = "Relationadditionalinfo.findById", query = "SELECT r FROM Relationadditionalinfo r WHERE r.id = :id")
//    , @NamedQuery(name = "Relationadditionalinfo.findByNote", query = "SELECT r FROM Relationadditionalinfo r WHERE r.note = :note")
//    , @NamedQuery(name = "Relationadditionalinfo.findByInsertdate", query = "SELECT r FROM Relationadditionalinfo r WHERE r.insertdate = :insertdate")})
public class Relationadditionalinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "note")
    private String note;
    @Column(name = "insertdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertdate;
    @JoinColumn(name = "idrelation", referencedColumnName = "id")
    @ManyToOne
    private Relation idrelation;

    public Relationadditionalinfo() {
    }

    public Relationadditionalinfo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

    public Relation getIdrelation() {
        return idrelation;
    }

    public void setIdrelation(Relation idrelation) {
        this.idrelation = idrelation;
    }



    @Override
    public String toString() {
        return "com.registry.entity.Relationadditionalinfo[ id=" + id + " ]";
    }
    
}
