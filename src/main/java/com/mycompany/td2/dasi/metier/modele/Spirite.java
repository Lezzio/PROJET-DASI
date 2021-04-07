/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author aguigal
 */
@Entity
public class Spirite extends Medium implements Serializable {
    
    private String support;

    public Spirite() {
    }

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