/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.modele;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author aguigal
 */
@Entity
public class Client implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String firstName;
    private String lastName;
    private String civility;
    @Column(unique = true)
    private String mail;
    private String password;
    private String phone;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Embedded
    private AstralProfile astralProfile;
    @OneToMany(mappedBy = "client")
    private List<Consultation> consultations;
    
    
    
    public Client() {
        
    }
    public Client(String lastName, String firstName, String civility, String mail, String password, Date birthDate, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.civility = civility;
        this.mail = mail;
        this.password = password;
        this.birthDate = birthDate;
        this.astralProfile = null;
        this.phone = phone;
    }
    
    public Long getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setPrenom(String firstName) {
        this.firstName = firstName;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCivility() {
        return civility;
    }
    public void setCivility(String civility) {
        this.civility = civility;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    @Override
    public String toString() {
        return "-> Client: id="+id+";lastName="+lastName+";firstName="+firstName+";mail="+mail+";password"+password+";birthDate="+birthDate;
    }

    public AstralProfile getAstralProfile() {
        return astralProfile;
    }
    public void setAstralProfile(AstralProfile astralProfile) {
        this.astralProfile = astralProfile;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getPhone() {
        return phone;
    }

    public boolean isSimilar(Client client) {
        return this.id.equals(client.getId())
        && this.firstName.equals(client.firstName)
        && this.lastName.equals(client.lastName)
        && this.mail.equals(client.mail)
        && this.password.equals(client.password)
        && this.phone.equals(client.phone)
        && this.birthDate.equals(client.birthDate);
    }
    
}