/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.modele;

/**
 *
 * @author maxime
 */
public class Astrolog extends Medium {
    
    private String formation;
    private String promotion;
    
    public Astrolog(String presentation, String name, String gender, String formation, String promotion) {
        super(presentation, name, gender);
        this.formation = formation;
        this.promotion = promotion;
    }

    public String getFormation() {
        return formation;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }
    
    
    
}