/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.modele;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author aguigal
 */
@Entity
public class Client {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String mail;
    private String password;
    private String civility;
    private Date birthDate;
    
    public Client() {
        
    }
    public Client(String lastName, String firstName, String mail, String password, Date birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.mail = mail;
        this.password = password;
        this.birthDate = birthDate;
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
    
}