/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.modele;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author aguigal
 */
@Entity
public class Consultation {

    @Id
    private Long id;
    private Date startDate;
    private Date endDate;
    private String commentary;
    private Medium medium;
    private Client client;
    private Employee employee;

     public Consultation(){
         
     }
    
    public Consultation(Client client, Medium medium) {
        this.client = client;
        this.medium = medium;
    }
    public Consultation(Date startDate, Date endDate, String commentary, Medium medium, Employee employee, Client client) {
        
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
    
}