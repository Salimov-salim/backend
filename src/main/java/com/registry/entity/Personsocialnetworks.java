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
@Table(name = "personsocialnetworks",schema = "general")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Personsocialnetworks.findAll", query = "SELECT p FROM Personsocialnetworks p")
//    , @NamedQuery(name = "Personsocialnetworks.findById", query = "SELECT p FROM Personsocialnetworks p WHERE p.id = :id")
//    , @NamedQuery(name = "Personsocialnetworks.findByName", query = "SELECT p FROM Personsocialnetworks p WHERE p.name = :name")
//    , @NamedQuery(name = "Personsocialnetworks.findByInsertdate", query = "SELECT p FROM Personsocialnetworks p WHERE p.insertdate = :insertdate")
//    , @NamedQuery(name = "Personsocialnetworks.findByUrl", query = "SELECT p FROM Personsocialnetworks p WHERE p.url = :url")})
public class Personsocialnetworks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="general.socialpages_id_seq")
    @SequenceGenerator(sequenceName="general.socialpages_id_seq",name="general.socialpages_id_seq",allocationSize=1)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "insertdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertdate;
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "idperson", referencedColumnName = "id")
    @ManyToOne
    private Person idperson;
    @JoinColumn(name = "idsocialpage", referencedColumnName = "id")
    @ManyToOne
    private Socialtypes idsocialpage;

    public Personsocialnetworks() {
    }

    public Personsocialnetworks(Integer id) {
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

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Person getIdperson() {
        return idperson;
    }

    public void setIdperson(Person idperson) {
        this.idperson = idperson;
    }

    public Socialtypes getIdsocialpage() {
        return idsocialpage;
    }

    public void setIdsocialpage(Socialtypes idsocialpage) {
        this.idsocialpage = idsocialpage;
    }


    @Override
    public String toString() {
        return "com.registry.entity.Personsocialnetworks[ id=" + id + " ]";
    }
    
}
