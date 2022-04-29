/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registry.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "relationadditionalinfo")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Relationadditionalinfo.findAll", query = "SELECT r FROM Relationadditionalinfo r")
//    , @NamedQuery(name = "Relationadditionalinfo.findById", query = "SELECT r FROM Relationadditionalinfo r WHERE r.id = :id")
//    , @NamedQuery(name = "Relationadditionalinfo.findByNote", query = "SELECT r FROM Relationadditionalinfo r WHERE r.note = :note")
//    , @NamedQuery(name = "Relationadditionalinfo.findByInsertdate", query = "SELECT r FROM Relationadditionalinfo r WHERE r.insertdate = :insertdate")})
public class Relationadditionalinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="general.relationadditionalinfo_id_seq")
    @SequenceGenerator(sequenceName="general.relationadditionalinfo_id_seq",name="general.relationadditionalinfo_id_seq",allocationSize=1)
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
