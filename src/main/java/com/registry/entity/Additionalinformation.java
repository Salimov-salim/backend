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
@Table(name = "additionalinformation")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Additionalinformation.findAll", query = "SELECT a FROM Additionalinformation a")
//    , @NamedQuery(name = "Additionalinformation.findById", query = "SELECT a FROM Additionalinformation a WHERE a.id = :id")
//    , @NamedQuery(name = "Additionalinformation.findByNote", query = "SELECT a FROM Additionalinformation a WHERE a.note = :note")
//    , @NamedQuery(name = "Additionalinformation.findByInsertdate", query = "SELECT a FROM Additionalinformation a WHERE a.insertdate = :insertdate")})
public class Additionalinformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="general.additionalinformation_id_seq")
    @SequenceGenerator(sequenceName="general.additionalinformation_id_seq",name="general.additionalinformation_id_seq",allocationSize=1)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "note")
    private String note;
    @Column(name = "insertdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertdate;
    @JoinColumn(name = "idperson", referencedColumnName = "id")
    @ManyToOne
    private Person idperson;

    public Additionalinformation() {
    }

    public Additionalinformation(Integer id) {
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

    public Person getIdperson() {
        return idperson;
    }

    public void setIdperson(Person idperson) {
        this.idperson = idperson;
    }



    @Override
    public String toString() {
        return "com.registry.entity.Additionalinformation[ id=" + id + " ]";
    }
    
}
