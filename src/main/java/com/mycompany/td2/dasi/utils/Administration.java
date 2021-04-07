/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.utils;

import static com.mycompany.td2.dasi.Main.mediumService;
import com.mycompany.td2.dasi.metier.modele.Astrolog;
import com.mycompany.td2.dasi.metier.modele.Cartomancian;
import com.mycompany.td2.dasi.metier.modele.Spirite;
import com.mycompany.td2.dasi.metier.services.MediumService;

/**
 *
 * @author maxim
 */
public class Administration {
    
    public static MediumService mediumService = new MediumService();
    
    public void initialiserEmployeeMedium() {

        Spirite spirite1 = new Spirite("Spécialiste des grandes conversations au-delà de TOUTES les frontières.",
        "Gwenaëlle", "F", "Boule de cristal");
        Spirite spirite2 = new Spirite("Votre avenir est devant vous : regardons-le ensemble !",
        "Professeur Tran", "H", "Marc de café, boule de cristal, oreilles de lapin");
        Cartomancian cartomancian1 = new Cartomancian("Comprenez votre entourage grâce à mes cartes ! Résultats rapides.",
        "Mme Irma", "F");
        Cartomancian cartomancian2 = new Cartomancian("Mes cartes répondront à toutes vos questions personnelles.",
        "Endora", "F");
        Astrolog astrolog1 = new Astrolog("Avenir, avenir, que nous réserves-tu ? N'attendez plus, demandez à me consulter!", "Mr M", "H", "Institut des Nouveaux Savoirs Astrologiques", "2010");
        Astrolog astrolog2 = new Astrolog("Basée à Champigny-sur-Marne, Serena vous révèlera votre avenir pour éclairer votre passé.", "Serena", "F", "École Normale Supérieure d’Astrologie (ENS-Astro)", "2006");


        mediumService.initialiserMedium(spirite1);
        mediumService.initialiserMedium(spirite2);
        mediumService.initialiserMedium(cartomancian1);
        mediumService.initialiserMedium(cartomancian2);
        mediumService.initialiserMedium(astrolog1);
        mediumService.initialiserMedium(astrolog2);
        
    }
    
}