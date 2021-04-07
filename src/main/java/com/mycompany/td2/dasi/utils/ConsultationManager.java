/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.utils;

import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.metier.modele.Consultation;
import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.modele.Medium;
import java.util.HashMap;

/**
 *
 * @author aguigal
 */
public class ConsultationManager {
    
    private static HashMap<Employee, Consultation> consultations = new HashMap<Employee, Consultation>();
       
    public static void makeConsultation(Employee employee, Client client, Medium medium) {
        Consultation consultation = new Consultation(Date());
    }
    
    //pb = client peut relancer des consultations ?
    
}