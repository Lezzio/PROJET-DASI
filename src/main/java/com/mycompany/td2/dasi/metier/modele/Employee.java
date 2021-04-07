/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.modele;

/**
 *
 * @author aguigal
 */
public class Employee {
    
    private String gender;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private boolean available;
    private int appointmentCount;
    
    public Employee(String gender, String firstName, String lastName, String mail, String password) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
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
    
}
