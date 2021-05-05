/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.modele;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author aguigal
 */
@Embeddable
public class AstralProfile implements Serializable {
    
    private String zodiacSign;
    private String chineeseSign;
    private String color;
    private String totemAnimal;
    
    public AstralProfile() {
        
    }
    public AstralProfile(String zodiacSign, String chineeseSign, String color, String totemAnimal) {
        this.zodiacSign = zodiacSign;
        this.chineeseSign = chineeseSign;
        this.color = color;
        this.totemAnimal = totemAnimal;
    }
    public String getZodiacSign() {
        return zodiacSign;
    }
    public void setZodiacSign(String zodiacSign) {
        this.zodiacSign = zodiacSign;
    }
    
    public String getChineeseSign() {
        return chineeseSign;
    }
    public void setChineeseSign(String chineeseSign) {
        this.chineeseSign = chineeseSign;
    }
    
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getTotemAnimal() {
        return totemAnimal;
    }
    public void setTotamAnimal(String totemAnimal) {
        this.totemAnimal = totemAnimal;
    }
    
    
}