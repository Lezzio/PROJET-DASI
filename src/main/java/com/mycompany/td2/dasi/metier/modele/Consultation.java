/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.modele;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author aguigal
 */
@Entity
public class Consultation implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String commentary;
    @ManyToOne
    private Medium medium;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Employee employee;
    
     public Consultation() {}
    
    public Consultation(Client client, Medium medium, Employee employee) {
        this.client = client;
        this.medium = medium;
        this.employee = employee;
    }
    public Consultation(Date startDate, Date endDate, String commentary, Client client, Medium medium, Employee employee) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.commentary = commentary;
        this.client = client;
        this.medium = medium;
        this.employee = employee;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getCommentary() {
        return commentary;
    }

    public Medium getMedium() {
        return medium;
    }

    public Client getClient() {
        return client;
    }

    public Employee getEmployee() {
        return employee;
    }
    
    public boolean isPending() {
        return startDate == null && endDate == null;
    }
    public boolean isLive() {
        return startDate != null && endDate == null;
    }
    public boolean isOver() {
        return startDate != null && endDate != null;
    }
    
}