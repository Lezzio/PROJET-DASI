/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.dao;

import com.mycompany.td2.dasi.metier.modele.Medium;
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
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(medium);
    }
    
    public Medium chercherParId(Long mediumId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Medium.class, mediumId); // renvoie null si l'identifiant n'existe pas
    }
    
    public Medium chercherParMail(String mediumMail) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Medium> query = em.createQuery("SELECT e FROM Medium e WHERE e.mail = :mail", Medium.class);
        query.setParameter("mail", mediumMail); // correspond au paramètre ":mail" dans la requête
        List<Medium> mediums = query.getResultList();
        Medium result = null;
        if (!mediums.isEmpty()) {
            result = mediums.get(0); // premier de la liste
        }
        return result;
    }
    
    public List<Medium> listMedium() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Medium> query = em.createQuery("SELECT e FROM Medium e ORDER BY e.nom ASC, e.prenom ASC", Medium.class);
        return query.getResultList();
    }
    
    // modifier / supprimer  ... 
}