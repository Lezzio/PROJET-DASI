/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.utils;

import com.mycompany.td2.dasi.dao.ConsultationDao;
import com.mycompany.td2.dasi.dao.JpaUtil;
import com.mycompany.td2.dasi.metier.modele.Astrolog;
import com.mycompany.td2.dasi.metier.modele.Cartomancian;
import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.metier.modele.Consultation;
import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.modele.Spirite;
import com.mycompany.td2.dasi.metier.services.AppointmentService;
import com.mycompany.td2.dasi.metier.services.AuthentificationService;
import com.mycompany.td2.dasi.metier.services.EntityService;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxim
 */
public class Administration {
    
    public static EntityService entityService = new EntityService();
    public static AuthentificationService authentificationService = new AuthentificationService();
    private final ConsultationDao consultationDao = new ConsultationDao();
    private final AppointmentService appointmentService = new AppointmentService();
    
    public void initializeMediums() {

        Spirite spirite1 = new Spirite("Spécialiste des grandes conversations au-delà de TOUTES les frontières.",
        "Gwenaëlle", Gender.FEMALE, "Boule de cristal");
        Spirite spirite2 = new Spirite("Votre avenir est devant vous : regardons-le ensemble !",
        "Professeur Tran", Gender.MALE, "Marc de café, boule de cristal, oreilles de lapin");
        Cartomancian cartomancian1 = new Cartomancian("Comprenez votre entourage grâce à mes cartes ! Résultats rapides.",
        "Mme Irma", Gender.FEMALE);
        Cartomancian cartomancian2 = new Cartomancian("Mes cartes répondront à toutes vos questions personnelles.",
        "Endora", Gender.FEMALE);
        Astrolog astrolog1 = new Astrolog("Avenir, avenir, que nous réserves-tu ? N'attendez plus, demandez à me consulter!", "Mr M", Gender.MALE, "Institut des Nouveaux Savoirs Astrologiques", "2010");
        Astrolog astrolog2 = new Astrolog("Basée à Champigny-sur-Marne, Serena vous révèlera votre avenir pour éclairer votre passé.", "Serena", Gender.FEMALE, "École Normale Supérieure d’Astrologie (ENS-Astro)", "2006");


        entityService.initializeMedium(spirite1);
        entityService.initializeMedium(spirite2);
        entityService.initializeMedium(cartomancian1);
        entityService.initializeMedium(cartomancian2);
        entityService.initializeMedium(astrolog1);
        entityService.initializeMedium(astrolog2);
    }
    
    
    
    
    public void initializeFemaleMediums() {

        Spirite spirite1 = new Spirite("Spécialiste des grandes conversations au-delà de TOUTES les frontières.",
        "Gwenaëlle", Gender.FEMALE, "Boule de cristal");
        Spirite spirite2 = new Spirite("Votre avenir est devant vous : regardons-le ensemble !",
        "Professeur Tran", Gender.MALE, "Marc de café, boule de cristal, oreilles de lapin");
        Cartomancian cartomancian1 = new Cartomancian("Comprenez votre entourage grâce à mes cartes ! Résultats rapides.",
        "Mme Irma", Gender.FEMALE);
        Cartomancian cartomancian2 = new Cartomancian("Mes cartes répondront à toutes vos questions personnelles.",
        "Endora", Gender.FEMALE);
        Astrolog astrolog1 = new Astrolog("Avenir, avenir, que nous réserves-tu ? N'attendez plus, demandez à me consulter!", "Mr M", Gender.MALE, "Institut des Nouveaux Savoirs Astrologiques", "2010");
        Astrolog astrolog2 = new Astrolog("Basée à Champigny-sur-Marne, Serena vous révèlera votre avenir pour éclairer votre passé.", "Serena", Gender.FEMALE, "École Normale Supérieure d’Astrologie (ENS-Astro)", "2006");


        entityService.initializeMedium(spirite1);
        entityService.initializeMedium(spirite2);
        entityService.initializeMedium(cartomancian1);
        entityService.initializeMedium(cartomancian2);
        entityService.initializeMedium(astrolog1);
        entityService.initializeMedium(astrolog2);
        
        Employee employe001 = new Employee(Gender.FEMALE, "Lola", "Adams", "lola.adams@hotmail.fr", "lola4512","06 35 24 89 74");
        Employee employe002 = new Employee(Gender.MALE, "Thomas", "Bernard", "thomas.bernard@hotmail.fr", "thomas6975","07 98 89 54 74");
        Employee employe003 = new Employee(Gender.FEMALE, "Camille", "Dupont", "camille.dupont@hotmail.fr", "camille1313","06 75 57 41 14");
        Employee employe004 = new Employee(Gender.MALE, "Lucas", "Roche", "lucas.roche@hotmail.fr", "lucas5656","01 23 45 65 23");
        Employee employe005 = new Employee(Gender.FEMALE, "Zoé", "Marchal", "zoe.marchal@hotmail.fr", "zoe2378","06 12 23 45 56");
        Employee employe006 = new Employee(Gender.MALE, "Arthur", "Le Goff", "arthur.legoff@hotmail.fr", "arthur8520","07 87 89 54 56");
        Employee employe007 = new Employee(Gender.FEMALE, "Martine", "Perrier", "martine.perrier@hotmail.fr", "martine1234","04 25 85 96 36");
        Employee employe008 = new Employee(Gender.MALE, "Hugo", "Germain", "hugo.germain@hotmail.fr", "hugo2020","06 06 23 52 45");
        Employee employe009 = new Employee(Gender.FEMALE, "Sarah", "Le Roux", "sarah.leroux@hotmail.fr", "sarah1956","07 85 25 41 13");
        Employee employe010 = new Employee(Gender.MALE, "Martin", "Pelletier", "martin.pelletier@hotmail.fr", "martin1321","06 86 52 12 14");
        
        authentificationService.signupEmployee(employe001);
        authentificationService.signupEmployee(employe002);
        authentificationService.signupEmployee(employe003);
        authentificationService.signupEmployee(employe004);
        authentificationService.signupEmployee(employe005);
        authentificationService.signupEmployee(employe006);
        authentificationService.signupEmployee(employe007);
        authentificationService.signupEmployee(employe008);
        authentificationService.signupEmployee(employe009);
        authentificationService.signupEmployee(employe010);
        
        Date now = new Date();
        
        Client client001 = new Client("Monnier", "Marie", "F", "marie.monnier@hotmail.fr", "mdpMarie12", now, "06 32 12 23 32", "88 chemin des tulipes", "Vienne", "2552");
        Client client002 = new Client("Giraud", "Tom", "M", "tom.giraud@hotmail.fr", "tomMDP45", now, "07 56 54 21 32", "45 rue de la framboise", "Narbonne", "1335");
        Client client003 = new Client("Brunet", "Mathieu", "M", "mathieu.brunet@hotmail.fr", "Mdpdemathieu1", now, "04 23 21 56 41", "28 rue ferdinand", "Metz", "2321");
        Client client004 = new Client("Renard", "Marion", "F", "marion.renard@hotmail.fr", "marion23", now, "07 56 54 12 32", "37 rue des pieuvres", "Castres", "1311");
        Client client005 = new Client("Fournier", "Evan", "M", "evan.fournier@hotmail.fr", "evan52", now, "04 23 21 25 52", "12 rue des camomilles", "Brest", "8978");
        Client client006 = new Client("Lambert", "Emma", "F", "emma.lambert@hotmail.fr", "emmaX21", now, "07 52 14 63 69", "23 rue carsson", "Bordeaux", "3456");
        
        authentificationService.signupClient(client001);
        authentificationService.signupClient(client002);
        authentificationService.signupClient(client003);
        authentificationService.signupClient(client004);
        authentificationService.signupClient(client005);
        authentificationService.signupClient(client006);
        
        Consultation consultation = null;
        Long id002 = appointmentService.askConsultation(client002, cartomancian1);
        Long id003 = appointmentService.askConsultation(client003, cartomancian1);
        Long id004 = appointmentService.askConsultation(client004, astrolog2);
        Long id005 = appointmentService.askConsultation(client005, spirite1);
        Long id006 = appointmentService.askConsultation(client006, astrolog2);
        
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id002);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id003);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id004);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id005);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id006);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        
    }
    
    public void initialize() {

        Spirite spirite1 = new Spirite("Spécialiste des grandes conversations au-delà de TOUTES les frontières.",
        "Gwenaëlle", Gender.FEMALE, "Boule de cristal");
        Spirite spirite2 = new Spirite("Votre avenir est devant vous : regardons-le ensemble !",
        "Professeur Tran", Gender.MALE, "Marc de café, boule de cristal, oreilles de lapin");
        Cartomancian cartomancian1 = new Cartomancian("Comprenez votre entourage grâce à mes cartes ! Résultats rapides.",
        "Mme Irma", Gender.FEMALE);
        Cartomancian cartomancian2 = new Cartomancian("Mes cartes répondront à toutes vos questions personnelles.",
        "Endora", Gender.FEMALE);
        Astrolog astrolog1 = new Astrolog("Avenir, avenir, que nous réserves-tu ? N'attendez plus, demandez à me consulter!", "Mr M", Gender.MALE, "Institut des Nouveaux Savoirs Astrologiques", "2010");
        Astrolog astrolog2 = new Astrolog("Basée à Champigny-sur-Marne, Serena vous révèlera votre avenir pour éclairer votre passé.", "Serena", Gender.FEMALE, "École Normale Supérieure d’Astrologie (ENS-Astro)", "2006");


        entityService.initializeMedium(spirite1);
        entityService.initializeMedium(spirite2);
        entityService.initializeMedium(cartomancian1);
        entityService.initializeMedium(cartomancian2);
        entityService.initializeMedium(astrolog1);
        entityService.initializeMedium(astrolog2);
        
        Employee employe001 = new Employee(Gender.FEMALE, "Lola", "Adams", "lola.adams@hotmail.fr", "lola4512","06 35 24 89 74");
        Employee employe002 = new Employee(Gender.MALE, "Thomas", "Bernard", "thomas.bernard@hotmail.fr", "thomas6975","07 98 89 54 74");
        Employee employe003 = new Employee(Gender.FEMALE, "Camille", "Dupont", "camille.dupont@hotmail.fr", "camille1313","06 75 57 41 14");
        Employee employe004 = new Employee(Gender.MALE, "Lucas", "Roche", "lucas.roche@hotmail.fr", "lucas5656","01 23 45 65 23");
        Employee employe005 = new Employee(Gender.FEMALE, "Zoé", "Marchal", "zoe.marchal@hotmail.fr", "zoe2378","06 12 23 45 56");
        Employee employe006 = new Employee(Gender.MALE, "Arthur", "Le Goff", "arthur.legoff@hotmail.fr", "arthur8520","07 87 89 54 56");
        Employee employe007 = new Employee(Gender.FEMALE, "Martine", "Perrier", "martine.perrier@hotmail.fr", "martine1234","04 25 85 96 36");
        Employee employe008 = new Employee(Gender.MALE, "Hugo", "Germain", "hugo.germain@hotmail.fr", "hugo2020","06 06 23 52 45");
        Employee employe009 = new Employee(Gender.FEMALE, "Sarah", "Le Roux", "sarah.leroux@hotmail.fr", "sarah1956","07 85 25 41 13");
        Employee employe010 = new Employee(Gender.MALE, "Martin", "Pelletier", "martin.pelletier@hotmail.fr", "martin1321","06 86 52 12 14");
        
        authentificationService.signupEmployee(employe001);
        authentificationService.signupEmployee(employe002);
        authentificationService.signupEmployee(employe003);
        authentificationService.signupEmployee(employe004);
        authentificationService.signupEmployee(employe005);
        authentificationService.signupEmployee(employe006);
        authentificationService.signupEmployee(employe007);
        authentificationService.signupEmployee(employe008);
        authentificationService.signupEmployee(employe009);
        authentificationService.signupEmployee(employe010);
        
        Date now = new Date();
        
        Client client001 = new Client("Monnier", "Marie", "F", "marie.monnier@hotmail.fr", "mdpMarie12", now, "06 32 12 23 32", "88 chemin des tulipes", "Vienne", "2552");
        Client client002 = new Client("Giraud", "Tom", "M", "tom.giraud@hotmail.fr", "tomMDP45", now, "07 56 54 21 32", "45 rue de la framboise", "Narbonne", "1335");
        Client client003 = new Client("Brunet", "Mathieu", "M", "mathieu.brunet@hotmail.fr", "Mdpdemathieu1", now, "04 23 21 56 41", "28 rue ferdinand", "Metz", "2321");
        Client client004 = new Client("Renard", "Marion", "F", "marion.renard@hotmail.fr", "marion23", now, "07 56 54 12 32", "37 rue des pieuvres", "Castres", "1311");
        Client client005 = new Client("Fournier", "Evan", "M", "evan.fournier@hotmail.fr", "evan52", now, "04 23 21 25 52", "12 rue des camomilles", "Brest", "8978");
        Client client006 = new Client("Lambert", "Emma", "F", "emma.lambert@hotmail.fr", "emmaX21", now, "07 52 14 63 69", "23 rue carsson", "Bordeaux", "3456");
        
        authentificationService.signupClient(client001);
        authentificationService.signupClient(client002);
        authentificationService.signupClient(client003);
        authentificationService.signupClient(client004);
        authentificationService.signupClient(client005);
        authentificationService.signupClient(client006);
        
        Consultation consultation = null;
        Long id001 = appointmentService.askConsultation(client001, spirite1);
        Long id002 = appointmentService.askConsultation(client002, spirite2);//male
        Long id003 = appointmentService.askConsultation(client003, cartomancian1);
        Long id004 = appointmentService.askConsultation(client004, cartomancian2);
        Long id005 = appointmentService.askConsultation(client005, astrolog1);//male
        Long id006 = appointmentService.askConsultation(client006, astrolog2);
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id001);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id002);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id003);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id004);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id005);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id006);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        Long id007 = appointmentService.askConsultation(client001, spirite1);
        Long id008 = appointmentService.askConsultation(client002, spirite2);//male
        Long id009 = appointmentService.askConsultation(client003, spirite1);
        Long id010 = appointmentService.askConsultation(client004, cartomancian2);
        Long id011 = appointmentService.askConsultation(client005, spirite1);//male
        Long id012 = appointmentService.askConsultation(client006, astrolog2);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id007);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id008);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id009);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id010);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id011);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);
        
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id012);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        Long id013 = appointmentService.askConsultation(client001, cartomancian2);
        Long id014 = appointmentService.askConsultation(client002, spirite2);//male
        Long id015 = appointmentService.askConsultation(client003, astrolog1);
        Long id016 = appointmentService.askConsultation(client004, cartomancian2);
        Long id017 = appointmentService.askConsultation(client005, spirite1);//male
        Long id018 = appointmentService.askConsultation(client006, astrolog1);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id013);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id014);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id015);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id016);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id016);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id017);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);

        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id018);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);


        
        Long id019 = appointmentService.askConsultation(client001, cartomancian2);
        Long id020 = appointmentService.askConsultation(client002, spirite2);//male
        Long id021 = appointmentService.askConsultation(client003, astrolog1);
        /*
        Long id022 = appointmentService.askConsultation(client004, cartomancian2);
        Long id023 = appointmentService.askConsultation(client005, spirite1);//male
        Long id024 = appointmentService.askConsultation(client006, astrolog1);
        */
        
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id019);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        
        
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id020);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        appointmentService.endConsultation(consultation.getEmployee(), consultation);
        
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id021);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        
        /*
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id022);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id023);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        
        /*JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            consultation = consultationDao.searchById(id024);
        }  
        catch(Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel searchById", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        appointmentService.acceptConsultation(consultation.getEmployee(), consultation);
        */
        /*
        Long id025 = appointmentService.askConsultation(client001, astrolog2);
        Long id026 = appointmentService.askConsultation(client002, spirite2);//male
        Long id027 = appointmentService.askConsultation(client003, astrolog2);
        */
        Long id028 = appointmentService.askConsultation(client004, cartomancian2);
        Long id029 = appointmentService.askConsultation(client005, spirite1);
        Long id030 = appointmentService.askConsultation(client006, spirite2);
    }
    
}