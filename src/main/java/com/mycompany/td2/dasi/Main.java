/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi;

import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.test.TestManager;
import com.mycompany.td2.dasi.utils.Administration;

/**
 * Project by Allan Guigal, Aurélien Tournade, Julien Bouvier and Maxime Boyer (3411 x 3409)
 * Git versioning available on GitHub :
 * https://github.com/Lezzio/PROJET-DASI
 * 
 * Have a good read!
 */
public class Main {
    
    public static Administration admin = new Administration();

    public static void main(String[] args) {
        System.out.println("DASI backend service init");
        //Init the JPA on start
        JpaUtil.init();
        
        admin.initialize();
        //admin.initializeFemaleMediums();
        admin.initializeDatabase();
        
        /**
         * Launches the test scenarios in the following order :
         * 1) ClientAccountTest, makes sure clients can sign up and sign in correctly and they can be accessed and so on
         * 2) EmployeeAccountTest, makes sure employees can be created and sign in correctly and they can be accessed and so on
         * 3) ConsultationTest, makes sure a client can ask a consultation with the right criterion 
         * 4) StatsTest, make sure our statistical service works well
         */
        //TestManager.testApplications();
        
        //Destroy the JPA on exit
        JpaUtil.destroy();
    }
    
}