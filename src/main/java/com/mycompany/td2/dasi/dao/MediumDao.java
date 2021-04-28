/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.dao;

import com.mycompany.td2.dasi.metier.modele.Medium;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author aguigal
 */
public class MediumDao {
    
    public void creer(Medium medium) {
        try {
        JpaUtil.ouvrirTransaction();
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(medium);
        JpaUtil.validerTransaction();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    /*
    public Medium chercherParId(Long mediumId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Medium.class, mediumId); // renvoie null si l'identifiant n'existe pas
    }*/

    public List<Medium> listerMediums() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Medium> query = em.createQuery("SELECT m FROM Medium m", Medium.class);
        return query.getResultList();
    }

  
    // modifier / supprimer  ... 
}