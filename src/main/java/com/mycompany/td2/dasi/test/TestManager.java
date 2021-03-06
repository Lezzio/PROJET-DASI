/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.test;

import com.mycompany.td2.dasi.test.list.ClientAccountTest;
import com.mycompany.td2.dasi.test.list.ConsultationTest;
import com.mycompany.td2.dasi.test.list.EmployeeAccountTest;
import com.mycompany.td2.dasi.test.list.StatsTest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            log("Called test " + unitTest.getName());
            if (!valid) {
                failedTests.add(unitTest);
            }
        });
        
        int testsCount = tests.size();
        int passedCount = testsCount - failedTests.size();
        log("Tests : " + passedCount + "/" + testsCount + " passed");
        failedTests.forEach(test -> log(Level.SEVERE, "Failed : " + test.getName()));
    }

    public static void addTest(Test test) {
        tests.add(test);
    }
    
    /**
     * Instantiate test objects, they'll be added in the tests list in their constructors
     */
    public static void initTests() {
        ClientAccountTest clientAccountTest = new ClientAccountTest();
        EmployeeAccountTest employeeAccountTest = new EmployeeAccountTest();
        ConsultationTest consultationTest = new ConsultationTest();
        StatsTest statsTest = new StatsTest();
    }
    
    public static void log(String message) {
        log(Level.INFO, message);
    }
    public static void log(Level level, String message) {
        Logger.getAnonymousLogger().log(level, message);
    }
    
}