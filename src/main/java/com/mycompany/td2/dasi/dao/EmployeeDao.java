/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.dao;

import com.mycompany.td2.dasi.metier.modele.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author aguigal
 */
public class EmployeeDao {
    
    public void creer(Employee employee) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(employee);
    }
    
    public Employee chercherParId(Long employeeId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Employee.class, employeeId); // renvoie null si l'identifiant n'existe pas
    }
    
    public Employee chercherParMail(String employeeMail) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.mail = :mail", Employee.class);
        query.setParameter("mail", employeeMail); // correspond au paramètre ":mail" dans la requête
        List<Employee> employees = query.getResultList();
        Employee result = null;
        if (!employees.isEmpty()) {
            result = employees.get(0); // premier de la liste
        }
        return result;
    }
    
    public List<Employee> listEmployees() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e ORDER BY e.nom ASC, e.prenom ASC", Employee.class);
        return query.getResultList();
    }
    
    // modifier / supprimer  ... 
}