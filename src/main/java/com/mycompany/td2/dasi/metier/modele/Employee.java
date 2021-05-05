/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author aguigal
 */
@Entity
public class Employee implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String gender;
    private String firstName;

    private String lastName;
    private String mail;
    private String password;
    private String phone;
    private boolean available;
    private int appointmentCount;
    
    public Employee() {
    }
    
    public Employee(String gender, String firstName, String lastName, String mail, String password, String phone) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.available = true;
    }
    
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public String getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public int getAppointmentCount() {
        return appointmentCount;
    }
    public void setAppointmentCount(int appointmentCount) {
        this.appointmentCount = appointmentCount;
    }
    
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addAppointmentCount(int i) {
        appointmentCount += i;
    }

    public boolean isSimilar(Employee employee) {
        return this.id.equals(employee.getId())
        && this.gender.equals(employee.gender)
        && this.firstName.equals(employee.firstName)
        && this.lastName.equals(employee.lastName)
        && this.mail.equals(employee.mail)
        && this.password.equals(employee.password)
        && this.phone.equals(employee.phone)
        && this.available == employee.available
        && this.appointmentCount == employee.getAppointmentCount();
    }
}