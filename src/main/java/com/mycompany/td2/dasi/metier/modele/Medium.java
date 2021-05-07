/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.modele;

import com.mycompany.td2.dasi.utils.Gender;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
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
    protected Gender gender;

    public Medium() {
    }

    public Medium(String presentation, String name, Gender gender) {
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

    public Gender getGender() {
        return gender;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Medium{" + "presentation=" + presentation + ", name=" + name + ", gender=" + gender + '}';
    }
    
}
