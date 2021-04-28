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
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

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
    
    public List<String> lesMessagesInspiration(int choixAmour, int choixSante, int choixTravail){
        List<String> listeMessage = new ArrayList<String>();
        int numRandomMessage = 2;
        numRandomMessage = (int)(Math.random() * 2);
        switch(choixAmour){
            case 1 : 
                if(numRandomMessage == 0){
                    listeMessage.add("Il n'y a rien de plus précieux en ce monde que le sentiment d'exister pour quelqu'un.");
                }else{
                    listeMessage.add("Il n'y a qu'un bonheur dans la vie, c'est d'aimer et d'être aimé.");
                }
                break;
            case 2 :
                if(numRandomMessage == 0){
                    listeMessage.add("Aimer c'est savoir dire je t'aime sans parler.");
                }else{
                    listeMessage.add("Aimer, c'est vivre ; aimer c'est voir ; aimer c'est être.");
                }
                break;
            case 3 :
                if(numRandomMessage == 0){
                    listeMessage.add("L'amour est comme le vent, nous ne savons pas d'où il vient");
                }else{
                    listeMessage.add("Quand tu tombes amoureux de la lune, tu arrêtes de regarder les étoiles.");
                }
                break;
            case 4 :
                if(numRandomMessage == 0){
                    listeMessage.add("Il y a des êtres qui nous touchent plus que d'autres, sans doute parce que, sans que nous le sachions nous-mêmes, ils portent en eux "
                + "une partie de ce qui nous manque.");
                }else{
                    listeMessage.add("Si seulement les gens qu'on aime pouvaient se voir de la façon dont on les voit.");
                }
                break;
        }
        
        numRandomMessage = (int)(Math.random() * 2);
        switch(choixSante){
            case 1 : 
                if(numRandomMessage == 0){
                    listeMessage.add("Qui est en bonne santé est riche sans le savoir.");
                }else{
                    listeMessage.add("La meilleure santé, c'est de ne pas sentir sa santé.");
                }
                break;
            case 2 :
                if(numRandomMessage == 0){
                    listeMessage.add("La santé est le support de notre vie, l'oublier c'est ôter l'essence à notre survie.");
                }else{
                    listeMessage.add("La santé c'est d'avoir mal tous les jours à un endroit différent.");
                }
                break;
            case 3 :
                if(numRandomMessage == 0){
                    listeMessage.add("La santé est hypocrite, elle loge notre corps, mais à tout moment peut lui causer des torts.");
                }else{
                    listeMessage.add("Deux choses ne s'apprécient bien que quand on ne les a plus : la santé et la jeunesse.");
                }
                break;
            case 4 :
                if(numRandomMessage == 0){
                    listeMessage.add("La bonne santé n'est que la plus lente des façons de mourir");
                }else{
                    listeMessage.add("Mourir en bonne santé, c'est le voeu le plus cher de tout bon vivant bien portant.");
                }
                break;
        }
       
        numRandomMessage = (int)(Math.random()*2);
        switch(choixTravail){
            case 1 : 
                if(numRandomMessage == 0){
                    listeMessage.add("C'est travail qui nourrit l'homme.");
                }else{
                    listeMessage.add("Le talent est un jardin et le travail est son jardinier.");
                }
                break;
            case 2 :
                if(numRandomMessage == 0){
                    listeMessage.add("Travailler dur est la seule manière d'avoir ce que tu veux dans ce monde.");
                }else{
                    listeMessage.add("On ne peut rien obtenir de bien sans travail.");
                }
                break;
            case 3 :
                if(numRandomMessage == 0){
                    listeMessage.add("Le travail de demain, c'est l'effort personnel d'aujourd'hui.");
                }else{
                    listeMessage.add("L'homme ne vit pas du nom, mais du travail.");
                }
                break;
            case 4 :
                if(numRandomMessage == 0){
                    listeMessage.add("Le travail comme le génie est un don.");
                }else{
                    listeMessage.add("Le travail est pour les hommes un trésor.");
                }
                break;
        }
 
        return listeMessage;
    }
    
}