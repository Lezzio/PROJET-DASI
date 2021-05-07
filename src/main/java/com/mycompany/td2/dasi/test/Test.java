/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.test;

/**
 *
 * @author aguigal
 */
public abstract class Test {
    
    protected Test() {
        TestManager.addTest(this);
    }
    
    /**
     * @return String describing the test intent
     */
    public abstract String getName();
    
    /**
     * Call the unit test
     * @return true if passed, false otherwise
     */
    public abstract boolean test();
    
}