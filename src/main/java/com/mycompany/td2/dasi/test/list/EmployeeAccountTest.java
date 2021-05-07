/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.test.list;

import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.services.AuthentificationService;
import com.mycompany.td2.dasi.metier.services.EntityService;
import com.mycompany.td2.dasi.test.Test;
import com.mycompany.td2.dasi.utils.Gender;

/**
 * @author aguigal
 */
public class EmployeeAccountTest extends Test {
    
    private final EntityService entityService = new EntityService();
    private final AuthentificationService authentificationService = new AuthentificationService();
        
    @Override
    public String getName() {
        return "EmployeeAccountTest : Tests for the employee sign up and sign in process";
    }

    @Override
    public boolean test() {
        
        //Tests sequence for first employee
        Employee employee1 = new Employee(Gender.FEMALE, "Claire", "Penaud", "claire.penaud@insa-lyon.fr", "tastyoctodon", "0782977582");
        boolean firstAccountPassed = employeeAccountTests(employee1);
        if(!firstAccountPassed) return false;
        
        //Tests sequence for second employee
        Employee employee2 = new Employee(Gender.MALE, "Martin", "Delevoie", "martin.delevoie@gmail.com", "delevoie", "0466552212");
        boolean secondAccountPassed = employeeAccountTests(employee2);
        if(!secondAccountPassed) return false;
       
        return true;
    }
    
    public boolean employeeAccountTests(Employee employee) {
        
        //Sign up
        authentificationService.signupEmployee(employee);
        
        //Search employee by id
        Employee fetchedEmployee = entityService.searchEmployeeById(employee.getId());
        
        //Same as the client test, fetched employee must exist and be similar
        if(fetchedEmployee == null || !fetchedEmployee.isSimilar(employee)) {
            System.out.println("Failed fetched employee not null and similar");
            return false;
        }
        
        //Sign in
        Employee authentificatedClient = authentificationService.authentificateEmployee(employee.getMail(), employee.getPassword());
        
        //Signed in employee must exist and be similar to the one expected
        if(authentificatedClient == null || !authentificatedClient.isSimilar(employee)) {
            System.out.println("Failed employee authentification not null and similar");
            return false;
        }
        
        return true;
    }
    
}