/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.test.list;

import com.mycompany.td2.dasi.dao.EmployeeDao;
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
 * @author aguigal
 */
public class ConsultationTest extends Test {
    
    private final EntityService entityService = new EntityService();
    private final AuthentificationService authentificationService = new AuthentificationService();
    private final AppointmentService appointmentService = new AppointmentService();
    private final MediumDao mediumDao = new MediumDao();
    private final EmployeeDao employeeDao = new EmployeeDao();
        
    @Override
    public String getName() {
        return "ConsultationTest : Tests for the consultation management procedure and sequence";
    }

    @Override
    public boolean test() {
        
        //Sign up more employees for the tests
        Client client1 = new Client("Maxime", "Tarantino", "M.", "maxime.tarantino@gmail.com", "tatata", new Date(), "0670235025");
        authentificationService.signupClient(client1);
        Employee employee1 = new Employee("female", "Lucille", "Fantini", "lucille.fantini@gmail.com", "tastyoctodon1", "0782577583");
        authentificationService.signupEmployee(employee1);
        Employee employee2 = new Employee("male", "Thibaud", "Collard", "thibaud.collard@gmail.com", "coco09", "0464652212");
        authentificationService.signupEmployee(employee2);
        
        //Force the creation of a new medium for the test (not allowed in production)
        Medium medium = new Medium("Prof Tran le medium oklm", "Prof Tran", "male");
        try {
        JpaUtil.creerContextePersistance();
        JpaUtil.ouvrirTransaction();
        mediumDao.create(medium);
        JpaUtil.validerTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Ask the consultation for the test medium Prof Tran
        Long consultationId = appointmentService.askConsultation(client1, medium);
        
        if(consultationId == null) {
            System.out.println("Failed test : ask consultation generated a null appointment");
            return false;
        }
        
        //Try to fetch the employee from the service and make sure the employee is no longer available
        employee2 = entityService.searchEmployeeById(employee2.getId());
        if(employee2.isAvailable()) {
            System.out.println("Failed test : available state to false for the employee incoherence");
            return false;
        }
        
        //Fetch the active consultation for the employee who must have the consltation, it has to be in pending state
        Consultation consultation = appointmentService.getEmployeeActiveConsultation(employee2);
        if(!consultation.isPending()) {
            System.out.println("Failed test : pending consultation state for the employee incoherence");
            return false;
        }
        
        //Accepts the consultation
        appointmentService.acceptConsultation(employee2, consultation);
        
        //It now must be in the live state
        if(!consultation.isLive()) {
            System.out.println("Failed test : live consultation state for the employee incoherence");
            return false;
        }
        
        //Try to ask predictions and make sure they are generated
        List<String> predictions = appointmentService.getPredictionsForClient(client1, 0, 0, 0);
        System.out.println(predictions);
        if(predictions == null) {
            System.out.println("Failed test : generate prediction");
            return false;
        }
        
        //Finally end the consultation
        appointmentService.endConsultation(employee2, consultation);
        
        //Make sure the state becomes over
        if(!consultation.isOver()) {
            System.out.println("Failed test : over consultation state for the employee incoherence");
            return false;
        }
        if(!employee2.isAvailable()) {
            System.out.println("Failed test : available state to true for the employee incoherence");
            return false;
        }
        
        //==================================================================================================================
        
        //Ask a second consultation for the test medium Prof Tran
        Long secondConsultationId = appointmentService.askConsultation(client1, medium);
        
        //Not null
        if(secondConsultationId == null) {
            System.out.println("Failed test : ask consultation generated a null appointment");
            return false;
        }
        
        /*
        * This second time it has to be Martin Dellevoie signed up in EmployeeAccountTest prioritizing the ones with least appointment count
        * and employee2 Thibaud Collard already has 1 appointment done
        * This kind of direct access is not used in production so we directly use the DAO
        */
        try {
        JpaUtil.creerContextePersistance(); //create context here for uncommon DAO usage for tests
        Employee employee = employeeDao.searchByMail("martin.delevoie@gmail.com");
        
        Consultation martinConsultation = appointmentService.getEmployeeActiveConsultation(employee);
        
        if(!martinConsultation.getId().equals(secondConsultationId)) {
            System.out.println("Failed test : available state to true for the employee incoherence");
            return false;
        }
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
}