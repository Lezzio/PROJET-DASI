/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.services;

import com.mycompany.td2.dasi.dao.MediumDao;
import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.metier.modele.Medium;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguigal
 */
public class MediumService {
    
    protected MediumDao mediumDao = new MediumDao();

    public void initialiserMedium(Medium medium) {
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            mediumDao.creer(medium);
            JpaUtil.validerTransaction();
            System.out.println("initilisation du médium réussie");
        } catch (Exception ex) {
            //Affichage de précis de l'erreur encourue
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service initialiserMedium(medium)", ex);
            JpaUtil.annulerTransaction();
            System.out.println("initilisation du médium échouée");
        } finally {
            JpaUtil.fermerContextePersistance();
        }
    }
    
}