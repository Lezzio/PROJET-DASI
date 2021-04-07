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

/**
 *
 * @author maxim
 */
public class Administration {
    
    public static void testerCreationMedium() {
        /*Medium medium = new Medium("Je suis un petit filou", "Lolita", "F");
        mediumService.initialiserMedium(medium);
        Medium medium2 = new Medium("Je suis un petit chaton", "Coco", "M");
        mediumService.initialiserMedium(medium2);*/
        Spirite spirite1 = new Spirite("Hello la mif", "Boubakar", "M", "marc de café");
        mediumService.initialiserMedium(spirite1);
        Astrolog astrolog1 = new Astrolog("yo la d", "Babar", "M", "luxe", "promo");
        mediumService.initialiserMedium(astrolog1);
        Cartomancian cartomancian1 = new Cartomancian("bijoir", "oui oui", "M");
        mediumService.initialiserMedium(cartomancian1);
    }
    
}
