/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.test.list;

import com.mycompany.td2.dasi.dao.ConsultationDao;
import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.dao.MediumDao;
import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.metier.modele.Consultation;
import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.modele.Medium;
import com.mycompany.td2.dasi.metier.services.AuthentificationService;
import com.mycompany.td2.dasi.metier.services.EntityService;
import com.mycompany.td2.dasi.metier.services.StatsService;
import com.mycompany.td2.dasi.test.Test;
import com.mycompany.td2.dasi.utils.Gender;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author aguigal
 */
public class StatsTest extends Test {

    StatsService statsService = new StatsService();
    EntityService entityService = new EntityService();
    AuthentificationService authentificationService = new AuthentificationService();
    ConsultationDao consultationDao = new ConsultationDao();
    MediumDao mediumDao = new MediumDao();
    
    @Override
    public String getName() {
        return "StatsTest : Tests for the employee sign up and sign in process";
    }

    @Override
    public boolean test() {
        
        //numberConsultationByMedium
        //topFiveMedium
        //clientDistributionByEmployee
        
        statsService.numberConsultationByMedium();
        Client client = new Client("Chloé", "Pascal", "Mme.", "chloe.pascal@orange.fr", "mypasswordcool", new Date(), "0475009835", "12 rue Poussin", "Davezieux", "07430");
        Medium medium = new Medium("Medium test", "Test", Gender.OTHER);
        Employee employee = new Employee(Gender.MALE, "James", "McDonald", "james.mcdonald@orange.fr", "mcdo", "0799435634");
        Date startDate = new Date();
        Date endDate = new Date();
        Consultation consultation1 = new Consultation(startDate, endDate, "Très bonne séance", client, medium, employee);
        Consultation consultation2 = new Consultation(startDate, endDate, "Séance intéressante", client, medium, employee);
        
        authentificationService.signupClient(client);
        authentificationService.signupEmployee(employee);
        
        List<Medium> mediums = entityService.listMediums();
        
        System.out.println("List mediums = " + mediums);
        
        try {
        JpaUtil.creerContextePersistance();
        JpaUtil.ouvrirTransaction();
        mediumDao.create(medium);
        consultationDao.create(consultation1);
        JpaUtil.validerTransaction();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        
        Map<String, Integer> stats = statsService.numberConsultationByMedium();
        System.out.println("Stats = " + stats);
        
        int testConsultationsCount = stats.get("Test");
        //
        if(testConsultationsCount != 1) {
            System.out.println("Failed test medium consultation count for Test");
            return false;
        }
        
        int endoraConsultationsCount = stats.get("Endora");
        //
        if(endoraConsultationsCount != 0) {
            System.out.println("Failed test medium consultation count for Endora");
            return false;
        }
        
        Map<String, Integer> mediumRanking = statsService.topFiveMedium();
        mediumRanking.entrySet().forEach(entry -> {
            System.out.println("Medium " + entry.getKey() + " avec " + entry.getValue() + " consultation(s)");
        });
        
        //Only 2 mediums have consultations, first ranked must be Prof Tran with 2 consultations and Test second with one consultation from ConsultationTest
        int compteur = 0;
        for (Map.Entry mapentry : mediumRanking.entrySet()) {      
            compteur++;
            if(compteur == 5){
                if(!mapentry.getKey().equals("Prof Tran")) {
                    System.out.println("Failed test medium ranking 1st place for Prof Tran medium");
                    return false;
                }
            }
            else if(compteur == 4)
            {
                if(!mapentry.getKey().equals("Test")) {
                    System.out.println("Failed test medium ranking 2nd place for Test medium");
                    return false;
                }
            }
            
        }
        
        Map<Long, Integer> employeesDistribution = statsService.clientDistributionByEmployee();
        
        Integer count = employeesDistribution.get(employee.getId());
        
        //Make sure the employee had one unique unique client
        if(count != 1) {
            System.out.println("Failed test employee distribution");
            return false;
        }
        
        return true;
    }
    
}