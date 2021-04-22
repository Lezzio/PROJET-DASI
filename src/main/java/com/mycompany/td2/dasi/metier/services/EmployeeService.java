/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.services;

import com.mycompany.td2.dasi.dao.ConsultationDao;
import com.mycompany.td2.dasi.dao.EmployeeDao;
import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.metier.modele.Consultation;
import com.mycompany.td2.dasi.metier.modele.Employee;
import java.util.Date;
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
    
    /**
     * Returns active or pending consultation
     * @param employee
     * @return 
     */
    public Consultation getEmployeeActiveConsultation(Employee employee) {
        Consultation result = null;
        JpaUtil.creerContextePersistance();
        try {
            result = consultationDao.searchActiveEmployeeConsultation(employee);
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service getEmployeeActiveConsultation(Employee employee)", e);
            result = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return result;
    }
    
    public Consultation acceptConsultation(Employee employee, Consultation consultation) {
        JpaUtil.creerContextePersistance();
        try {
            Date now = new Date();
            consultation.setStartDate(now);
            consultationDao.updateConsultation(consultation);
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service getEmployeeActiveConsultation(Employee employee)", e);
            consultation = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return consultation;
    }
    
    public void denyConsultation(Employee employee, Consultation consultation) {
        JpaUtil.creerContextePersistance();
        try {
            employee.setAvailable(true);
            employeeDao.updateEmployee(employee);
            consultationDao.removeConsultation(consultation);
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service denyConsultation(Employee employee, Consultation consultation", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
    }
    
    public void endConsultation(Employee employee, Consultation consultation) {
        JpaUtil.creerContextePersistance();
        try {
            employee.setAvailable(true);
            employeeDao.updateEmployee(employee);
            Date now = new Date();
            consultation.setEndDate(now);
            consultationDao.updateConsultation(consultation);
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service denyConsultation(Employee employee, Consultation consultation", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
    }
    
}