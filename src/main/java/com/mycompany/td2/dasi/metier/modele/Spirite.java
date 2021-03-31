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
public class Spirite extends Medium {
    
    private String support;

    public Spirite(String presentation, String name, String gender, String support) {
        super(presentation, name, gender);
        this.support = support;
    }
    
    public String getSupport() {
        return support;
    }
    public void setSupport(String support) {
        this.support = support;
    }
    
}