/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.test.list;

import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.dao.MediumDao;
import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.metier.modele.Consultation;
import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.test.Test;
import com.mycompany.td2.dasi.metier.modele.Medium;
import com.mycompany.td2.dasi.metier.services.AppointmentService;
import com.mycompany.td2.dasi.metier.services.AuthentificationService;
import com.mycompany.td2.dasi.metier.services.EntityService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aguigal
 */
public class ConsultationTest extends Test {
    
    private final EntityService entityService = new EntityService();
    private final AuthentificationService authentificationService = new AuthentificationService();
    private final AppointmentService appointmentService = new AppointmentService();
    private final MediumDao mediumDao = new MediumDao();
        
    @Override
    public String getName() {
        return "ConsultationTest : Tests for the consultation management procedure and sequence";
    }

    @Override
    public boolean test() {
        
        //Sign up
        Client client1 = new Client("Maxime", "Tarantino", "M.", "maxime.tarantino@gmail.com", "tatata", new Date(), "0670235025");
        authentificationService.signupClient(client1);
        Employee employee1 = new Employee("female", "Claire", "Penaud", "claire.penaud@insa-lyon.fr", "tastyoctodon1", "0782977583");
        authentificationService.signupEmployee(employee1);
        Employee employee2 = new Employee("male", "Thibaud", "Collard", "thibaud.collard@gmail.com", "coco09", "0464652212");
        authentificationService.signupEmployee(employee2);
        
        Medium medium = new Medium("Prof Tran le medium oklm", "Prof Tran", "male");
        try {
        JpaUtil.creerContextePersistance();
        JpaUtil.ouvrirTransaction();
        mediumDao.create(medium);
        JpaUtil.validerTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        appointmentService.askConsultation(client1, medium);
        
        employee2 = entityService.searchEmployeeById(employee2.getId());
        if(employee2.isAvailable()) {
            System.out.println("Failed test : available state to false for the employee incoherence");
            return false;
        }
        
        
        Consultation consultation = appointmentService.getEmployeeActiveConsultation(employee2);
        boolean pending = consultation.isPending();
        
        if(!pending) {
            System.out.println("Failed test : pending consultation state for the employee incoherence");
            return false;
        }
        
        appointmentService.acceptConsultation(employee2, consultation);
        
        if(!consultation.isLive()) {
            System.out.println("Failed test : live consultation state for the employee incoherence");
            return false;
        }
        
        List<String> predictions = appointmentService.getPredictionForClient(client1, 0, 0, 0);
        System.out.println(predictions);
        if(predictions == null) {
            System.out.println("Failed test : generate prediction");
            return false;
        }
        
        appointmentService.endConsultation(employee2, consultation);
        
        if(!consultation.isOver()) {
            System.out.println("Failed test : over consultation state for the employee incoherence");
            return false;
        }
        if(!employee2.isAvailable()) {
            System.out.println("Failed test : available state to true for the employee incoherence");
            return false;
        }
        
        
        return true;
    }
    
}