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
@Table(name = "person_education",schema = "general")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "PersonEducation.findAll", query = "SELECT p FROM PersonEducation p")
//    , @NamedQuery(name = "PersonEducation.findById", query = "SELECT p FROM PersonEducation p WHERE p.id = :id")
//    , @NamedQuery(name = "PersonEducation.findByStartdate", query = "SELECT p FROM PersonEducation p WHERE p.startdate = :startdate")
//    , @NamedQuery(name = "PersonEducation.findByEnddate", query = "SELECT p FROM PersonEducation p WHERE p.enddate = :enddate")})
public class PersonEducation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @JoinColumn(name = "ideducationtype", referencedColumnName = "id")
    @ManyToOne
    private Educationtype ideducationtype;
    @JoinColumn(name = "idperson", referencedColumnName = "id")
    @ManyToOne
    private Person idperson;
    @JoinColumn(name = "iduniversity", referencedColumnName = "id")
    @ManyToOne
    private Universities iduniversity;

    public PersonEducation() {
    }

    public PersonEducation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Educationtype getIdeducationtype() {
        return ideducationtype;
    }

    public void setIdeducationtype(Educationtype ideducationtype) {
        this.ideducationtype = ideducationtype;
    }

    public Person getIdperson() {
        return idperson;
    }

    public void setIdperson(Person idperson) {
        this.idperson = idperson;
    }

    public Universities getIduniversity() {
        return iduniversity;
    }

    public void setIduniversity(Universities iduniversity) {
        this.iduniversity = iduniversity;
    }


    @Override
    public String toString() {
        return "com.registry.entity.PersonEducation[ id=" + id + " ]";
    }
    
}
