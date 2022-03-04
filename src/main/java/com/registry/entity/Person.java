/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registry.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "person",schema = "general")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
//    , @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id")
//    , @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name")
//    , @NamedQuery(name = "Person.findBySurname", query = "SELECT p FROM Person p WHERE p.surname = :surname")
//    , @NamedQuery(name = "Person.findByFathername", query = "SELECT p FROM Person p WHERE p.fathername = :fathername")
//    , @NamedQuery(name = "Person.findByMilitarystate", query = "SELECT p FROM Person p WHERE p.militarystate = :militarystate")
//    , @NamedQuery(name = "Person.findByStatus", query = "SELECT p FROM Person p WHERE p.status = :status")
//    , @NamedQuery(name = "Person.findByInsertdate", query = "SELECT p FROM Person p WHERE p.insertdate = :insertdate")
//    , @NamedQuery(name = "Person.findByBlockstatus", query = "SELECT p FROM Person p WHERE p.blockstatus = :blockstatus")
//    , @NamedQuery(name = "Person.findByFin", query = "SELECT p FROM Person p WHERE p.fin = :fin")
//    , @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "fathername")
    private String fathername;
    @Column(name = "militarystate")
    private String militarystate;
    @Column(name = "status")
    private String status;
    @Column(name = "insertdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertdate;
    @Column(name = "blockstatus")
    private Integer blockstatus;
    @Column(name = "fin")
    private String fin;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "idperson")
    private Collection<PersonEducation> personEducationCollection;
    @OneToMany(mappedBy = "idperson")
    private Collection<Personsocialnetworks> personsocialnetworksCollection;
    @OneToMany(mappedBy = "idpersonone")
    private Collection<Relation> relationCollection;
    @OneToMany(mappedBy = "idpersontwo")
    private Collection<Relation> relationCollection1;
    @JoinColumn(name = "idcv", referencedColumnName = "id")
    @ManyToOne
    private Cv idcv;
    @OneToMany(mappedBy = "personId")
    private Collection<PersonAnnouncement> personAnnouncementCollection;
    @OneToMany(mappedBy = "idperson")
    private Collection<WorkExperience> workExperienceCollection;
    @OneToMany(mappedBy = "idperson")
    private Collection<Additionalinformation> additionalinformationCollection;

    public Person() {
    }

    public Person(Integer id) {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMilitarystate() {
        return militarystate;
    }

    public void setMilitarystate(String militarystate) {
        this.militarystate = militarystate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

    public Integer getBlockstatus() {
        return blockstatus;
    }

    public void setBlockstatus(Integer blockstatus) {
        this.blockstatus = blockstatus;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }





    public Cv getIdcv() {
        return idcv;
    }

    public void setIdcv(Cv idcv) {
        this.idcv = idcv;
    }



    @Override
    public String toString() {
        return "com.registry.entity.Person[ id=" + id + " ]";
    }

}