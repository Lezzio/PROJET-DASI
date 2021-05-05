/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.modele;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 *
 * @author aguigal
 */
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class Medium implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    protected String presentation;
    protected String name;
    protected String gender;

    public Medium() {
    }

    public Medium(String presentation, String name, String gender) {
        this.presentation = presentation;
        this.name = name;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }
    
    public String getPresentation() {
        return presentation;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Medium{" + "presentation=" + presentation + ", name=" + name + ", gender=" + gender + '}';
    }
    
}
