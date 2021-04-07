/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi;

import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.metier.modele.Astrolog;
import com.mycompany.td2.dasi.metier.modele.Cartomancian;
import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.modele.Medium;
import com.mycompany.td2.dasi.metier.modele.Spirite;
import com.mycompany.td2.dasi.metier.services.ClientService;
import com.mycompany.td2.dasi.metier.services.EmployeeService;
import com.mycompany.td2.dasi.metier.services.MediumService;
import java.sql.Date;

/**
 * @author aguigal
 */
public class Main {
    
    public static ClientService clientService = new ClientService();
    public static EmployeeService employeeService = new EmployeeService();
    public static MediumService mediumService = new MediumService();
    
    public static void main(String[] args) {
        System.out.println("TD1 - DASI init");
        JpaUtil.init();
        
        testerInscriptionClient();
        
        testerCreationMedium();
    }
    public static void testerInscriptionClient() {
        Client client1 = new Client("Dupond", "Jean", "jd@gmail.com", "mdp2", Date.valueOf("2020-05-05"));
        clientService.inscrireClient(client1);
        Client client2 = clientService.rechercherClientParId(client1.getId());
        System.out.println(client2.toString());
        Employee employee = new Employee("Autre", "yasmine", "souabi", "yasmine.souabi", "jesuisunemerde");
        employeeService.authentifierEmployee("yasmine.souabi@insa-lyon.fr", "jesuisunemerde");
    }
    
    public static void testerCreationMedium() {
        /*Medium medium = new Medium("Je suis un petit filou", "Lolita", "F");
        mediumService.initialiserMedium(medium);
        Medium medium2 = new Medium("Je suis un petit chaton", "Coco", "M");
        mediumService.initialiserMedium(medium2);*/
        Spirite spirite1 = new Spirite("Hello la mif", "Boubakar", "M", "marc de café");
        mediumService.initialiserMedium(spirite1);
        Astrolog astrolog1 = new Astrolog("yo la d", "Babar", "M", "luxe", "promo");
        mediumService.initialiserMedium(astrolog1);
        Cartomancian cartomancian1 = new Cartomancian("bijoir", "oui oui", "M");
        mediumService.initialiserMedium(cartomancian1);
    }
    
}