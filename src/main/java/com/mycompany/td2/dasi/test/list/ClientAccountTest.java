/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.test.list;

import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.metier.services.AuthentificationService;
import com.mycompany.td2.dasi.metier.services.EntityService;
import com.mycompany.td2.dasi.test.Test;
import java.util.Date;
import java.util.List;

/**
 * @author aguigal
 */
public class ClientAccountTest extends Test {
    
    private final EntityService entityService = new EntityService();
    private final AuthentificationService authentificationService = new AuthentificationService();
        
    @Override
    public String getName() {
        return "ClientAccountTest : Tests for the client sign up and sign in process";
    }

    @Override
    public boolean test() {
        
        //Tests sequence with first client
        Client client1 = new Client("Calenovo", "Zorro", "M.", "zorro.calenovo@vodafone.es", "tornado123", new Date(), "0680255025", "12 rue Poussin", "Davezieux", "07430");
        boolean firstAccountPassed = clientAccountTests(client1);
        if(!firstAccountPassed) return false;
        
         //List clients after first insert
        List<Client> clientList1 = entityService.listClients();
        
        if(clientList1.size() != 1) {
            System.out.println("Failed client list not right size");
            return false;
        }
        
        //Tests sequence with second client
        Client client2 = new Client("Calenovo", "Zorro", "M.", "zorro.calenovo@vodafone.fr", "tornado123", new Date(), "0680255025", "12 rue Poussin", "Davezieux", "07430");
        boolean secondAccountPassed = clientAccountTests(client2);
        if(!secondAccountPassed) return false;
        
         //List clients after second insert
        List<Client> clientList2 = entityService.listClients();
        
        if(clientList2.size() != 2) {
            System.out.println("Failed client list not right size");
            return false;
        }
       
        return true;
    }
    
    public boolean clientAccountTests(Client client) {
        
        //Sign up
        authentificationService.signupClient(client);
        
        //Search client by id
        Client fetchedClient = entityService.searchClientById(client.getId());
        
        //Fetched client must be the same as the initial one (valid verification despite the possible local cache as it goes through the entity manager)
        if(fetchedClient == null || !fetchedClient.isSimilar(client)) {
            System.out.println("Failed fetched client not null and similar");
            return false;
        }
        
        //Sign in
        Client authentificatedClient = authentificationService.authentificateClient(client.getMail(), client.getPassword());
        
        //Signed in client must be similar to the one expected
        if(authentificatedClient == null || !authentificatedClient.isSimilar(client)) {
            System.out.println("Failed client authentification not null and similar");
            return false;
        }
        
        return true;
    }
    
}
