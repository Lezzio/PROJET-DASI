/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.dao;

import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.modele.Medium;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;

/**
 *
 * @author aguigal
 */
public class EmployeeDao {
    
    public void create(Employee employee) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(employee);
    }
    
    public Employee searchById(Long employeeId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Employee.class, employeeId); // renvoie null si l'identifiant n'existe pas
    }
    
    public Employee searchByMail(String employeeMail) {
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
    
    public Employee updateEmployee(Employee employee) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.merge(employee); //TODO Check if working
    }
    
    public List<Employee> listEmployees() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e ORDER BY e.lastName ASC, e.firstName ASC", Employee.class);
        return query.getResultList();
    }
    
    public List<Employee> availableEmployeesMatchingMedium(Medium medium) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.available = true AND e.gender = :gender ORDER BY e.appointmentCount ASC", Employee.class);
        query.setParameter("gender", medium.getGender());
        return query.getResultList();
    }
    
    public Map<String, Integer> getEmployeeClientCountMap() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Tuple> query = em.createQuery("""
                                                    SELECT
                                                        e.lastName as lastName,
                                                    COUNT(DISTINCT(c.client)) as uniqueClientsCount
                                                    FROM
                                                        Consultation c INNER JOIN c.employee e
                                                    GROUP BY
                                                        e
                                                    """, Tuple.class);
        var resultList = query.getResultList();
        System.out.println("Query = " + query);
        System.out.println(resultList.size());
        System.out.println("Index 0 = " + resultList.get(0));
        System.out.println("Index 1 = " + resultList.get(1));
        System.out.println("Index 1 = " + resultList.get(1).get("lastName"));
        System.out.println("Index 1 = " + resultList.get(1).get("uniqueClientsCount"));
                
                /*collect(
            Collectors.toMap(
                tuple -> ((String) tuple.get("lastName")),
                tuple -> ((Number) tuple.get("uniqueClientsCount")).intValue()           
            )
        );
        */
        return null;
    }
    
    // modifier / supprimer  ... 
}