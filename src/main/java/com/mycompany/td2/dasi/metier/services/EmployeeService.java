/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.services;

import com.mycompany.td2.dasi.dao.EmployeeDao;
import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.metier.modele.Consultation;
import com.mycompany.td2.dasi.metier.modele.Employee;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguigal
 */
public class EmployeeService {
    
    private final EmployeeDao employeeDao = new EmployeeDao();
    private final ConsultationDao consultationDao = new ConsultationDao();

    public Employee authentifierEmployee(String mail, String motDePasse) {
        Employee resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            // Search employee
            Employee employee = employeeDao.chercherParMail(mail);
            if (employee != null) {
                // Vérification du mot de passe
                if (employee.getPassword().equals(motDePasse)) {
                    resultat = employee;
                }
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifierEmployee(mail,motDePasse)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    public Consultation getEmployeeConsultation(Employee employee) {
        return null; //TODO Implement
    }
    
    public void endConsultation(Employee employee) {
        
    }
    
}