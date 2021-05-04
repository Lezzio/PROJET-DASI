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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
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
        Client client = new Client("Chloé", "Pascal", "Mme.", "chloe.pascal@orange.fr", "mypasswordcool", new Date(), "04");
        Medium medium = new Medium("Medium test", "Test", "not specified");
        Employee employee = new Employee();
        Date startDate = new Date();
        Date endDate = new Date();
        Consultation consultation = new Consultation(startDate, endDate, "Très bonne séance ", client, medium, employee);
        
        authentificationService.signupClient(client);
        authentificationService.signupEmployee(employee);
        
        List<Medium> mediums = entityService.listMediums();
        
        System.out.println("List mediums = " + mediums);
        
        try {
        JpaUtil.creerContextePersistance();
        JpaUtil.ouvrirTransaction();
        mediumDao.create(medium);
        consultationDao.create(consultation);
        JpaUtil.validerTransaction();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        Map<String, Integer> stats = statsService.numberConsultationByMedium();
        System.out.println("Stats = " + stats);
        
        int testConsultationsCount = stats.get("Test");
        if(testConsultationsCount != 1) {
            System.out.println("Failed test medium consultation count for Test");
            return false;
        }
        
        int endoraConsultationsCount = stats.get("Endora");
        if(endoraConsultationsCount != 0) {
            System.out.println("Failed test medium consultation count for Endora");
            return false;
        }
        
        List<Medium> mediumRanking = statsService.topFiveMedium();
        mediumRanking.forEach(m -> System.out.println(m.getName()));
        
        Map<Long, Integer> employeesDistribution = statsService.clientDistributionByEmployee();
        System.out.println("Employee = " + employeesDistribution);
        employeesDistribution.forEach((id, value) -> System.out.println(id + " et " + value));
        
        return true;
    }
    
}