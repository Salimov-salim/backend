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
@Table(name = "number_tags")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "NumberTags.findAll", query = "SELECT n FROM NumberTags n")
//    , @NamedQuery(name = "NumberTags.findById", query = "SELECT n FROM NumberTags n WHERE n.id = :id")
//    , @NamedQuery(name = "NumberTags.findByTitle", query = "SELECT n FROM NumberTags n WHERE n.title = :title")
//    , @NamedQuery(name = "NumberTags.findByInsertdate", query = "SELECT n FROM NumberTags n WHERE n.insertdate = :insertdate")})
public class NumberTags implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="number_tags_id_seq")
    @SequenceGenerator(sequenceName="number_tags_id_seq",name="number_tags_id_seq",allocationSize=1)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "insertdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertdate;
    @JoinColumn(name = "idpersonannouncement", referencedColumnName = "id")
    @ManyToOne
    private PersonAnnouncement idpersonannouncement;

    public NumberTags() {
    }

    public NumberTags(Integer id) {
        this.id = id;
    }

    public NumberTags(Integer id, String title) {
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

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

    public PersonAnnouncement getIdpersonannouncement() {
        return idpersonannouncement;
    }

    public void setIdpersonannouncement(PersonAnnouncement idpersonannouncement) {
        this.idpersonannouncement = idpersonannouncement;
    }



    @Override
    public String toString() {
        return "com.registry.entity.NumberTags[ id=" + id + " ]";
    }
    
}
