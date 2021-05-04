/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.test;

import com.mycompany.td2.dasi.test.list.ClientAccountTest;
import com.mycompany.td2.dasi.test.list.ConsultationTest;
import com.mycompany.td2.dasi.test.list.EmployeeAccountTest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aguigal
 */
public class TestManager {
    
    private static List<Test> tests = new ArrayList<>();
    private static List<Test> failedTests = new ArrayList<>();
    
    public static void testApplications() {
        initTests();
        
        tests.forEach(unitTest -> {
            boolean valid = unitTest.test();
            System.out.println("Called test for " + unitTest.getName());
            if (!valid) {
                failedTests.add(unitTest);
            }
        });
        
        int testsCount = tests.size();
        int passedCount = testsCount - failedTests.size();
        System.out.println("Tests : " + passedCount + "/" + testsCount + " passed");
        failedTests.forEach(test -> System.out.println("Failed : " + test.getName()));
        
    }

    public static void addTest(Test test) {
        tests.add(test);
    }
    
    public static void initTests() {
        ClientAccountTest clientAccountTest = new ClientAccountTest();
        EmployeeAccountTest employeeAccountTest = new EmployeeAccountTest();
        ConsultationTest consultationTest = new ConsultationTest();
    }
    
}