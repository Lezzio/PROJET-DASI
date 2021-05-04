/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi;

import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.metier.modele.Medium;
import com.mycompany.td2.dasi.test.TestManager;
import com.mycompany.td2.dasi.utils.Administration;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

/**
 * @author aguigal
 */
public class Main {
    
    //public static EmployeeService employeeService = new EmployeeService();
    public static Administration admin = new Administration();
    
    public static void main(String[] args) throws RemoteException {
        System.out.println("TD2 - DASI init");
        JpaUtil.init();
        admin.initialiserMedium();
        
        TestManager.testApplications();
        
                /*

        afficherListeMediums();
        
        List<String> listeMessage = admin.lesMessagesInspiration(1, 3, 4);
        for(String m : listeMessage){
            System.out.println(m);
        }
        //testerInscriptionClient();
        
        */
        JpaUtil.destroy();
    }
         /*public static void testerInscriptionClient() {
        Client client1 = new Client("Dupond", "Jean", "jd@gmail.com", "mdp2", Date.valueOf("2020-05-05"));
        clientService.inscrireClient(client1);
        Client client2 = clientService.rechercherClientParId(client1.getId());
        System.out.println(client2.toString());
        Employee employee = new Employee("Autre", "yasmine", "souabi", "yasmine.souabi", "jesuisunemerde");
        employeeService.authentifierEmployee("yasmine.souabi@insa-lyon.fr", "jesuisunemerde");
    }*/
    
}
