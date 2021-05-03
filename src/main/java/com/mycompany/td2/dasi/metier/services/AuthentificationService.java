/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.metier.services;

import com.mycompany.td2.dasi.dao.ClientDao;
import com.mycompany.td2.dasi.dao.ConsultationDao;
import com.mycompany.td2.dasi.dao.EmployeeDao;
import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.metier.modele.AstralProfile;
import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.utils.AstroNetApi;
import com.mycompany.td2.dasi.utils.Message;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguigal
 */
public class AuthentificationService {
    
    
    private final String contactMail = "contact@predict.if";
    
    private final ClientDao clientDao = new ClientDao();
    private final EmployeeDao employeeDao = new EmployeeDao();
    private final ConsultationDao consultationDao = new ConsultationDao();
    
    public Long signupClient(Client client) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            //Générer le profile astral
            AstroNetApi astroNetApi = new AstroNetApi();
            List<String> astroStatements = astroNetApi.getProfil(client.getFirstName(), client.getBirthDate());
            AstralProfile astralProfile = new AstralProfile(astroStatements.get(0), astroStatements.get(1), astroStatements.get(2), astroStatements.get(3));
            client.setAstralProfile(astralProfile);
            JpaUtil.ouvrirTransaction();
            clientDao.create(client);
            JpaUtil.validerTransaction();
            resultat = client.getId();
            //Notifier l'inscription
            Message.envoyerMail(contactMail, client.getMail(),
                    "Bienvenue chez PREDICT'IF",
                    "Bonjour " + client.getFirstName() + " nous vous confirmons votre inscription au service PREDICT’IF. Rendez-vous vite sur notre site pour consulter votre profil astrologique et profiter des dons " +
"incroyables de nos mediums");
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service inscrireClient(client)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
            //Notifier l'échec
            Message.envoyerMail(contactMail, client.getMail(),
                    "Echec de l’inscription chez PREDICT’IF",
                    "Bonjour " + client.getFirstName() + ", votre inscription au service PREDICT’IF a malencontreusement échoué...\n" +
"Merci de recommencer ultérieurement.");
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public Client authentificateClient(String mail, String password) {
        Client resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            // Recherche du client
            Client client = clientDao.searchByMail(mail);
            if (client != null) {
                // Vérification du mot de passe
                if (client.getPassword().equals(password)) {
                    resultat = client;
                }
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifierClient(mail,motDePasse)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    /**
     * Only needed for test purposes
     * @param employee
     * @return 
     */
    public Long signupEmployee(Employee employee) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            employeeDao.create(employee);
            JpaUtil.validerTransaction();
            resultat = employee.getId();
            //Notifier l'inscription
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service signupEmployee(employee)", ex);
            JpaUtil.annulerTransaction();
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public Employee authentificateEmployee(String mail, String password) {
        Employee resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            // Search employee
            Employee employee = employeeDao.searchByMail(mail);
            if (employee != null) {
                // Vérification du mot de passe
                if (employee.getPassword().equals(password)) {
                    resultat = employee;
                }
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service authentifierEmployee(mail,motDePasse)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
}
