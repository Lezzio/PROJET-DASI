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
public class Medium {
    
    protected String presentation;
    protected String name;
    protected String gender;

    public Medium(String presentation, String name, String gender) {
        this.presentation = presentation;
        this.name = name;
        this.gender = gender;
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
