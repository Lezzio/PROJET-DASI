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

    public void create(Consultation consultation) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(consultation);
    }
    
    public Consultation searchById(Long consultationId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Consultation.class, consultationId); // return null if id doesn't exist
    }
    
    public void deleteConsultation(Consultation consultation) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.remove(consultation);
    }
    
    public List<Consultation> findByMedium(Medium medium) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.medium.id = :medium", Consultation.class);
        query.setParameter("medium", medium.getId());
        List<Consultation> mediumsConsultations = query.getResultList();
        return mediumsConsultations;
    }
    
    public Consultation findByEmployee(Employee employee) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.employee = :employee", Consultation.class);
        query.setParameter("employee", employee.getId()); // correspond au paramètre ":mail" dans la requête
        List<Consultation> employeeConsultations = query.getResultList();
        Consultation result = null;
        if (!employeeConsultations.isEmpty()) {
            result = employeeConsultations.get(0); // first of the list
        }
        return result;
    }
    
    public List<Medium> findByClient(Client client) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Medium> query = em.createQuery("SELECT c.medium FROM Consultation c WHERE c.client.id = :client", Medium.class);
        query.setParameter("client", client.getId()); // correspond au paramètre ":mail" dans la requête
        List<Medium> clientParMediumConsultations = query.getResultList();
        return clientParMediumConsultations;
    }
    
    public List<Consultation> findHistoryClient(Client client) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.client = :client AND c.endDate IS NOT NULL ORDER BY c.endDate DESC", Consultation.class);
        query.setParameter("client", client);
        List<Consultation> clientConsultations = query.getResultList();
        return clientConsultations;
    }
    
    /**
     * Query active or pending consultations for a given employee
     * @param employee
     * @return the list of consultations
     */
    public Consultation searchActiveEmployeeConsultation(Employee employee) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.employee = :employee AND c.endDate IS NULL", Consultation.class);
        query.setParameter("employee", employee);
        List<Consultation> activeConsultations = query.getResultList();
        Consultation result = null;
        if (!activeConsultations.isEmpty()) {
            result = activeConsultations.get(0); // first of the list
        }
        return result;
    }

    public Consultation searchActiveClientConsultation(Client client) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Consultation> query = em.createQuery("SELECT c FROM Consultation c WHERE c.client = :client AND c.endDate IS NULL", Consultation.class);
        query.setParameter("client", client);
        List<Consultation> activeConsultations = query.getResultList();
        Consultation result = null;
        if (!activeConsultations.isEmpty()) {
            result = activeConsultations.get(0); // first of the list
        }
        return result;
    }
    
    public Consultation updateConsultation(Consultation consultation) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.merge(consultation);
    }

    public void removeConsultation(Consultation consultation) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.remove(consultation);
    }
    
}
