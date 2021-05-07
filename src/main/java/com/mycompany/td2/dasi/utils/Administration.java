/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.utils;

import com.mycompany.td2.dasi.metier.modele.Astrolog;
import com.mycompany.td2.dasi.metier.modele.Cartomancian;
import com.mycompany.td2.dasi.metier.modele.Spirite;
import com.mycompany.td2.dasi.metier.services.EntityService;

/**
 *
 * @author maxim
 */
public class Administration {
    
    public static EntityService entityService = new EntityService();
    
    public void initializeMediums() {

        Spirite spirite1 = new Spirite("Spécialiste des grandes conversations au-delà de TOUTES les frontières.",
        "Gwenaëlle", Gender.FEMALE, "Boule de cristal");
        Spirite spirite2 = new Spirite("Votre avenir est devant vous : regardons-le ensemble !",
        "Professeur Tran", Gender.MALE, "Marc de café, boule de cristal, oreilles de lapin");
        Cartomancian cartomancian1 = new Cartomancian("Comprenez votre entourage grâce à mes cartes ! Résultats rapides.",
        "Mme Irma", Gender.FEMALE);
        Cartomancian cartomancian2 = new Cartomancian("Mes cartes répondront à toutes vos questions personnelles.",
        "Endora", Gender.FEMALE);
        Astrolog astrolog1 = new Astrolog("Avenir, avenir, que nous réserves-tu ? N'attendez plus, demandez à me consulter!", "Mr M", Gender.MALE, "Institut des Nouveaux Savoirs Astrologiques", "2010");
        Astrolog astrolog2 = new Astrolog("Basée à Champigny-sur-Marne, Serena vous révèlera votre avenir pour éclairer votre passé.", "Serena", Gender.FEMALE, "École Normale Supérieure d’Astrologie (ENS-Astro)", "2006");


        entityService.initializeMedium(spirite1);
        entityService.initializeMedium(spirite2);
        entityService.initializeMedium(cartomancian1);
        entityService.initializeMedium(cartomancian2);
        entityService.initializeMedium(astrolog1);
        entityService.initializeMedium(astrolog2);
    }
    
}