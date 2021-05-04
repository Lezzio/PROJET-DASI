/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.services;

import com.mycompany.td2.dasi.dao.ClientDao;
import com.mycompany.td2.dasi.dao.ConsultationDao;
import com.mycompany.td2.dasi.dao.EmployeeDao;
import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.metier.modele.Consultation;
import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.modele.Medium;
import com.mycompany.td2.dasi.utils.AstroNetApi;
import com.mycompany.td2.dasi.utils.Message;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author aguigal
 */
public class AppointmentService {
    
    private final ClientDao clientDao = new ClientDao();
    private final EmployeeDao employeeDao = new EmployeeDao();
    private final ConsultationDao consultationDao = new ConsultationDao();
    private final AstroNetApi astroNet = new AstroNetApi();
    
    public Long askConsultation(Client client, Medium medium) {
        Long result = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            //Find available employee to embody the medium
            List<Employee> availableMatchingEmployees = employeeDao.availableEmployeesMatchingMedium(medium);
            //Take the one with least appointment count (ascendant ordered list)
            
            if(!availableMatchingEmployees.isEmpty()) {
                
                Employee employee = availableMatchingEmployees.get(0);
                //Create consultation
                Consultation consultation = new Consultation(client, medium, employee);
                
                consultationDao.create(consultation);
                result = consultation.getId();
                
                employee.setAvailable(false);
                employeeDao.updateEmployee(employee);
                
                JpaUtil.validerTransaction();
                
                Message.envoyerNotification(employee.getPhone(), ""
                        + "Bonjour " + employee.getFirstName() + 
                        ". Consultation requise pour "
                        + client.getCivility() + " "
                        + client.getFirstName() + " "
                        + client.getLastName().toUpperCase()
                        + ". Médium à incarner : " + medium.getName());
                
            } else {
                //TODO Handle no available employees
                System.out.println("No matching employee for the asked medium");
            }
        } catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service askConsultation(Client client, Medium medium)", e);
            result = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return result;
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
    
    public void acceptConsultation(Employee employee, Consultation consultation) {
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            Date now = new Date();
            consultation.setStartDate(now);
            consultationDao.updateConsultation(consultation);
            
            //Notify the consultation is accepted
            Client client = consultation.getClient();
            Message.envoyerNotification(client.getPhone(), """
                                                            Bonjour Alice. J’ai bien reçu votre demande de consultation du 14/02/2020 à 12h10.
                                                           Vous pouvez dès à présent me contacter au 06 55 44 77 88. A tout de suite ! Médiumiquement
                                                           vôtre, Mme Irma""");
            
            JpaUtil.validerTransaction();
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service acceptConsultation(Employee employee, Consultation consultation)", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
    }
    
    /*
    public void denyConsultation(Employee employee, Consultation consultation) {
        JpaUtil.creerContextePersistance();
        try {
            employee.setAvailable(true);
            employeeDao.updateEmployee(employee);
            consultationDao.removeConsultation(consultation);
            JpaUtil.validerTransaction();
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service denyConsultation(Employee employee, Consultation consultation", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
    }
    */
    
    public void endConsultation(Employee employee, Consultation consultation) {
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            employee.setAvailable(true);
            employee.addAppointmentCount(1);
            employeeDao.updateEmployee(employee);
            Date now = new Date();
            consultation.setEndDate(now);
            consultationDao.updateConsultation(consultation);
            JpaUtil.validerTransaction();
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service endConsultation(Employee employee, Consultation consultation", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
    }
    
    public List<String> getPredictionForClient(Client client, int love, int health, int work){
        List<String> listPredictions = null;
        try {
            listPredictions = astroNet.getPredictions(client.getAstralProfile().getColor(), client.getAstralProfile().getTotemAnimal(), love, health, work);
        } catch (IOException e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au getPredictionForClient(Client client, int love, int health, int work)", e);
        }
        return listPredictions;
    }
    
}