/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.modele;

import com.mycompany.td2.dasi.utils.Gender;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author maxim
 */
@Entity
public class Cartomancian extends Medium implements Serializable {

    public Cartomancian() {
    }

    public Cartomancian(String presentation, String name, Gender gender) {
        super(presentation, name, gender);
    }
}