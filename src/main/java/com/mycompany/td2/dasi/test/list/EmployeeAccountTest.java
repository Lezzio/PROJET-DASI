/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.test.list;

import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.services.EmployeeService;
import com.mycompany.td2.dasi.test.Test;

/**
 *
 * @author aguigal
 */
public class EmployeeAccountTest extends Test {
    
    
    private final EmployeeService employeeService = new EmployeeService();
        
    @Override
    public String getName() {
        return "EmployeeAccountTest : Tests for the employee sign up and sign in process";
    }

    @Override
    public boolean test() {
        
        //Sign up
        Employee employee1 = new Employee("female", "Claire", "Penot", "claire.penot@insa-lyon.fr", "tastyoctodon", "0782977582");
        boolean firstAccountPassed = employeeAccountTests(employee1);
        if(!firstAccountPassed) return false;
        
        Employee employee2 = new Employee("male", "Martin", "Delevoie", "martin.delevoie@gmail.com", "delevoie", "0466552212");
        boolean secondAccountPassed = employeeAccountTests(employee2);
        if(!secondAccountPassed) return false;
        
       
        return true;
    }
    
    public boolean employeeAccountTests(Employee employee) {
        
        //Sign up
        employeeService.signupEmployee(employee);
        
        //Search client by id
        Employee fetchedEmployee = employeeService.searchEmployeeById(employee.getId());
        
        System.out.println(fetchedEmployee);
        System.out.println(fetchedEmployee.isSimilar(employee));
        
        if(fetchedEmployee == null || !fetchedEmployee.isSimilar(employee)) {
            System.out.println("Failed fetched employee not null and similar");
            return false;
        }
        
        //Sign in
        Employee authentificatedClient = employeeService.authentifierEmployee(employee.getMail(), employee.getPassword());
        
        if(authentificatedClient == null || !authentificatedClient.isSimilar(employee)) {
            System.out.println("Failed employee authentification not null and similar");
            return false;
        }
        
        return true;
    }
    
}
