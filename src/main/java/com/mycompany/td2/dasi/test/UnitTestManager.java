/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aguigal
 */
public class UnitTestManager {
    
    List<Test> tests = new ArrayList<>();
    List<Test> failedTests = new ArrayList<>();
    
    public void testApplications() {
        
        tests.forEach(unitTest -> {
            boolean valid = unitTest.test();
            if (!valid) {
                failedTests.add(unitTest);
            }
        });
        
        int testsCount = tests.size();
        int passedCount = testsCount - failedTests.size();
        System.out.println("Tests : " + passedCount + "/" + testsCount);
        failedTests.forEach(test -> System.out.println("Failed : " + test.getName()));
        
    }
    
}