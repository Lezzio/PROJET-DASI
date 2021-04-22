/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.dao;

import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.metier.modele.Consultation;
import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.modele.Medium;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author aguigal
 */
public class ConsultationDao {

    
    
    public void creer(Consultation consultation) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(consultation);
    }
    
    public Consultation chercherParId(Long consultationId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Consultation.class, consultationId); // renvoie null si l'identifiant n'existe pas
    }
    
    public void deleteConsultation(Consultation consultation) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.remove(consultation);
    }
    
    public Consultation findByMedium(Medium medium) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.medium = :medium", Consultation.class);
        query.setParameter("medium", medium.getId()); // correspond au paramètre ":mail" dans la requête
        List<Consultation> mediumsConsultations = query.getResultList();
        Consultation result = null;
        if (!mediumsConsultations.isEmpty()) {
            result = mediumsConsultations.get(0); // premier de la liste
        }
        return result;
    }
    
    public Consultation findByEmployee(Employee employee) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.employee = :employee", Consultation.class);
        query.setParameter("employee", employee.getId()); // correspond au paramètre ":mail" dans la requête
        List<Consultation> employeeConsultations = query.getResultList();
        Consultation result = null;
        if (!employeeConsultations.isEmpty()) {
            result = employeeConsultations.get(0); // premier de la liste
        }
        return result;
    }
    public Consultation findHistoryClient(Client client) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.client = :client AND c.endDate IS NOT NULL ORDER BY c.endDate ASC", Consultation.class);
        query.setParameter("client", client.getId()); // correspond au paramètre ":mail" dans la requête
        List<Consultation> clientConsultations = query.getResultList();
        Consultation result = null;
        if (!clientConsultations.isEmpty()) {
            result = clientConsultations.get(0); // premier de la liste
        }
        return result;
    }
    
    /**
     * Query active or pending consultations for a given employee
     * @param employee
     * @return the list of consultations
     */
    public Consultation searchActiveEmployeeConsultation(Employee employee) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.employee = :employee AND c.endDate IS NULL", Consultation.class);
        //TODO Precise if live or pending (start date or not)
        query.setParameter("employee", employee.getId()); // correspond au paramètre ":mail" dans la requête
        List<Consultation> activeConsultations = query.getResultList();
        Consultation result = null;
        if (!activeConsultations.isEmpty()) {
            result = activeConsultations.get(0); // premier de la liste
        }
        return result;
    }
    
    public Consultation updateConsultation(Consultation consultation) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.merge(consultation); //TODO Check if working
    }

    public void removeConsultation(Consultation consultation) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.remove(consultation); //TODO Check if working
    }
    
    
}
