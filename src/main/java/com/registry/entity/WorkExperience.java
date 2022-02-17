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
@Table(name = "work_experience",schema = "general")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "WorkExperience.findAll", query = "SELECT w FROM WorkExperience w")
//    , @NamedQuery(name = "WorkExperience.findById", query = "SELECT w FROM WorkExperience w WHERE w.id = :id")
//    , @NamedQuery(name = "WorkExperience.findByPosition", query = "SELECT w FROM WorkExperience w WHERE w.position = :position")
//    , @NamedQuery(name = "WorkExperience.findByWorkplace", query = "SELECT w FROM WorkExperience w WHERE w.workplace = :workplace")
//    , @NamedQuery(name = "WorkExperience.findByStartdate", query = "SELECT w FROM WorkExperience w WHERE w.startdate = :startdate")
//    , @NamedQuery(name = "WorkExperience.findByEnddate", query = "SELECT w FROM WorkExperience w WHERE w.enddate = :enddate")
//    , @NamedQuery(name = "WorkExperience.findByStatus", query = "SELECT w FROM WorkExperience w WHERE w.status = :status")
//    , @NamedQuery(name = "WorkExperience.findByInsertdate", query = "SELECT w FROM WorkExperience w WHERE w.insertdate = :insertdate")})
public class WorkExperience implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "position")
    private String position;
    @Column(name = "workplace")
    private String workplace;
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Column(name = "status")
    private Integer status;
    @Basic(optional = false)
    @Column(name = "insertdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertdate;
    @JoinColumn(name = "idperson", referencedColumnName = "id")
    @ManyToOne
    private Person idperson;

    public WorkExperience() {
    }

    public WorkExperience(Integer id) {
        this.id = id;
    }

    public WorkExperience(Integer id, String position, Date insertdate) {
        this.id = id;
        this.position = position;
        this.insertdate = insertdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "com.registry.entity.WorkExperience[ id=" + id + " ]";
    }
    
}
