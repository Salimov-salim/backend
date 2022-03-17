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
@Table(name = "person_announcement",schema = "general")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "PersonAnnouncement.findAll", query = "SELECT p FROM PersonAnnouncement p")
//    , @NamedQuery(name = "PersonAnnouncement.findById", query = "SELECT p FROM PersonAnnouncement p WHERE p.id = :id")
//    , @NamedQuery(name = "PersonAnnouncement.findByPhoneNumber", query = "SELECT p FROM PersonAnnouncement p WHERE p.phoneNumber = :phoneNumber")
//    , @NamedQuery(name = "PersonAnnouncement.findByFullname", query = "SELECT p FROM PersonAnnouncement p WHERE p.fullname = :fullname")
//    , @NamedQuery(name = "PersonAnnouncement.findByInsertdate", query = "SELECT p FROM PersonAnnouncement p WHERE p.insertdate = :insertdate")})
public class PersonAnnouncement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="general.person_announcement_id_seq")
    @SequenceGenerator(sequenceName="general.person_announcement_id_seq",name="general.person_announcement_id_seq",allocationSize=1)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "fullname")
    private String fullname;
    @Basic(optional = false)
    @Column(name = "insertdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertdate;
    @OneToMany(mappedBy = "idpersonannouncement")
    private Collection<NumberTags> numberTagsCollection;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne
    private Person personId;
    @JoinColumn(name = "idsource", referencedColumnName = "id")
    @ManyToOne
    private Sources idsource;

    public PersonAnnouncement() {
    }

    public PersonAnnouncement(Integer id) {
        this.id = id;
    }

    public PersonAnnouncement(Integer id, String phoneNumber, Date insertdate) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.insertdate = insertdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }



    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Sources getIdsource() {
        return idsource;
    }

    public void setIdsource(Sources idsource) {
        this.idsource = idsource;
    }



    @Override
    public String toString() {
        return "com.registry.entity.PersonAnnouncement[ id=" + id + " ]";
    }
    
}
