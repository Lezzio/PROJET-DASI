/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi;

import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.metier.services.ClientService;
import java.sql.Date;

/**
 * @author aguigal
 */
public class Main {
    
    public static ClientService clientService = new ClientService();
    
    public static void main(String[] args) {
        System.out.println("TD1 - DASI init");
        JpaUtil.init();
        
        testerInscriptionClient();
    }
    public static void testerInscriptionClient() {
        Client client1 = new Client("Dupond", "Jean", "jd@gmail.com", "mdp2", Date.valueOf("2020-05-05"));
        clientService.inscrireClient(client1);
        Client client2 = clientService.rechercherClientParId(client1.getId());
        System.out.println(client2.toString());
    }
    
}