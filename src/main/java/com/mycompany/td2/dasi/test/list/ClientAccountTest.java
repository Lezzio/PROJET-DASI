/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.test.list;

import com.mycompany.td2.dasi.metier.services.ClientService;
import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.test.Test;
import java.util.Date;

/**
 *
 * @author aguigal
 */
public class ClientAccountTest extends Test {

    @Override
    public String getName() {
        return "ClientAccountTest : Tests for the client sign up and sign in process";
    }

    @Override
    public boolean test() {
        
        ClientService clientService = new ClientService();
        
        Client client = new Client("Calenovo", "Zorro", "M.", "zorro.calenovo@vodafone.es", "tornado123", new Date(), "0680255025");
        clientService.inscrireClient(client);
                
        return true;
    }
    
    
    
}
