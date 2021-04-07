package com.mycompany.td2.dasi.metier.services;

import com.mycompany.td2.dasi.dao.ClientDao;
import com.mycompany.td2.dasi.dao.ConsultationDao;
import com.mycompany.td2.dasi.dao.EmployeeDao;
import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.metier.modele.AstralProfile;
import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.metier.modele.Consultation;
import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.modele.Medium;
import com.mycompany.td2.dasi.utils.AstroNetApi;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Message;

/**
 *
 */
public class ClientService {
    
    private final String contactMail = "contact@predict.if";
    
    private final ClientDao clientDao = new ClientDao();
    private final EmployeeDao employeeDao = new EmployeeDao();
    private final ConsultationDao consultationDao = new ConsultationDao();

    public Long inscrireClient(Client client) {
        Long resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            //Générer le profile astral
            AstroNetApi astroNetApi = new AstroNetApi();
            List<String> astroStatements = astroNetApi.getProfil(client.getFirstName(), client.getBirthDate());
            AstralProfile astralProfile = new AstralProfile(astroStatements.get(0), astroStatements.get(1), astroStatements.get(2), astroStatements.get(3));
            client.setAstralProfile(astralProfile);
            JpaUtil.ouvrirTransaction();
            clientDao.creer(client);
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

    public Client rechercherClientParId(Long id) {
        Client resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = clientDao.chercherParId(id);
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service rechercherClientParId(id)", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }

    public Client authentifierClient(String mail, String motDePasse) {
        Client resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            // Recherche du client
            Client client = clientDao.chercherParMail(mail);
            if (client != null) {
                // Vérification du mot de passe
                if (client.getPassword().equals(motDePasse)) {
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

    public List<Client> listerClients() {
        List<Client> resultat = null;
        JpaUtil.creerContextePersistance();
        try {
            resultat = clientDao.listerClients();
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service listerClients()", ex);
            resultat = null;
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return resultat;
    }
    
    public Long askConsultation(Client client, Medium medium) {
        Long result = null;
        JpaUtil.creerContextePersistance();
        try {
            //Find available employee to embody the medium
            List<Employee> availableMatchingEmployees = employeeDao.availableEmployeesMatchingMedium(medium);
            //Take the one with least appointment count (ascendant ordered list)
            Employee employee = availableMatchingEmployees.get(0);
            
            if(employee != null) {
                //Create consultation
                Consultation consultation = new Consultation(client, medium);
                JpaUtil.ouvrirTransaction();
                
                consultationDao.creer(consultation);
                result = consultation.getId();
                
                Message.envoyerNotification(employee.getPhone(), ""
                        + "Bonjour " + employee.getFirstName() + 
                        ". Consultation requise pour "
                        + client.getCivility() + " "
                        + client.getFirstName() + " "
                        + client.getLastName().toUpperCase()
                        + ". Médium à incarner : " + medium.getName());
                employee.setAvailable(false);
                
                employeeDao.updateEmployee(employee);
                JpaUtil.validerTransaction();
            }
        } catch(Exception e) {
            
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return result;
    }
}