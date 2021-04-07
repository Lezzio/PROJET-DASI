/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi;

import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.metier.modele.Astrolog;
import com.mycompany.td2.dasi.metier.modele.Cartomancian;
import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.modele.Medium;
import com.mycompany.td2.dasi.metier.modele.Spirite;
import com.mycompany.td2.dasi.metier.services.ClientService;
import com.mycompany.td2.dasi.metier.services.EmployeeService;
import com.mycompany.td2.dasi.metier.services.MediumService;
import com.mycompany.td2.dasi.utils.Administration;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author aguigal
 */
public class Main {
    
    public static ClientService clientService = new ClientService();
    //public static EmployeeService employeeService = new EmployeeService();
    public static MediumService mediumService = new MediumService();
    public static Administration admin = new Administration();
    
    
    public static void main(String[] args) throws RemoteException {
        System.out.println("TD1 - DASI init");
        JpaUtil.init();
        
        //testerInscriptionClient();
        
        
        admin.initialiserEmployeeMedium();
        
        afficherListeMediums();
        
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
    
    public static void afficherListeMediums() throws java.rmi.RemoteException
    {
      List<Medium> listeMedium = mediumService.listerMediums();
      for (Iterator iter = listeMedium.iterator(); iter.hasNext();)
      {
        String ch2 = iter.next().toString();
        System.out.println(ch2)  ;
      }
 
  }
    
}
