/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi;

import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.test.TestManager;
import com.mycompany.td2.dasi.utils.Administration;
import java.rmi.RemoteException;


/**
 * @author aguigal
 */
public class Main {
    
    //public static EmployeeService employeeService = new EmployeeService();
    public static Administration admin = new Administration();
    
    public static void main(String[] args) throws RemoteException {
        System.out.println("TD2 - DASI init");
        JpaUtil.init();
        
        admin.initializeMedium();
        
        /**
         * Launches the test scenarios in the following order :
         * 1) ClientAccountTest, makes sure clients can sign up and sign in correctly and they can be accessed and so on
         * 2) EmployeeAccountTest, makes sure employees can be created and sign in correctly and they can be accessed and so on
         * 3) ConsultationTest, makes sure a client can ask a consultation with the right criterion 
         * 4) StatsTest, make sure our statistical service works well
         */
        TestManager.testApplications();
        
        JpaUtil.destroy();
    }
    
}
