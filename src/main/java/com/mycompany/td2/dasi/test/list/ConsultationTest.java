/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.test.list;

import com.mycompany.td2.dasi.dao.MediumDao;
import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.metier.modele.Consultation;
import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.services.ClientService;
import com.mycompany.td2.dasi.metier.services.EmployeeService;
import com.mycompany.td2.dasi.test.Test;
import com.mycompany.td2.dasi.metier.modele.Medium;
import java.util.Date;

/**
 *
 * @author aguigal
 */
public class ConsultationTest extends Test {
    
    
    private final ClientService clientService = new ClientService();
    private final EmployeeService employeeService = new EmployeeService();
    private final MediumDao mediumDao = new MediumDao();
        
    @Override
    public String getName() {
        return "ConsultationTest : Tests for the consultation management procedure and sequence";
    }
    

    @Override
    public boolean test() {
        
        //Sign up
        Client client1 = new Client("Maxime", "Tarantino", "M.", "maxime.tarantino@gmail.com", "tatata", new Date(), "0670235025");
        clientService.signupClient(client1);
        Employee employee1 = new Employee("female", "Claire", "Penaud", "claire.penaud@insa-lyon.fr", "tastyoctodon1", "0782977583");
        employeeService.signupEmployee(employee1);
        Employee employee2 = new Employee("male", "Martin", "Delevoie", "martin.delevoie@gmail.com", "delevoie", "0466552212");
        employeeService.signupEmployee(employee2);
        
        Medium medium = new Medium("Prof Tran le medium oklm", "Prof Tran", "male");
        mediumDao.creer(medium);
        clientService.askConsultation(client1, medium);
        
        Consultation consultation = employeeService.getEmployeeActiveConsultation(employee1);
        boolean pending = consultation.isPending();
        boolean over = consultation.isOver();
        boolean live = consultation.isLive();
        
        if(!pending || over || live) {
            System.out.println("Failed test : pending consultation state for the employee");
        }
        
        
        
        return true;
    }
    
}
