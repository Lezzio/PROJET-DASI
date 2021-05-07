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
import com.mycompany.td2.dasi.dao.MediumDao;
import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.metier.modele.Consultation;
import com.mycompany.td2.dasi.metier.modele.Employee;
import com.mycompany.td2.dasi.metier.modele.Medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author aguigal
 */
public class StatsService {
    
    ConsultationDao consultationDao = new ConsultationDao();
    MediumDao mediumDao = new MediumDao();
    ClientDao clientDao = new ClientDao();
    EmployeeDao employeeDao = new EmployeeDao();
    EntityService entityService = new EntityService();
    
    /**
     * @return Map with key as the medium's name and value the number of consultations for this medium
     */
    public Map<String, Integer> numberConsultationByMedium() {
        JpaUtil.creerContextePersistance();
        Map<String, Integer> map = new HashMap<String, Integer>();
        try {
            List<Medium> listeMedium = mediumDao.listMediums();
            for (Medium m : listeMedium) {
                List<Consultation> listeConsultation = consultationDao.findByMedium(m);
                map.put(m.getName(), listeConsultation.size());
            }
            return map;
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service numberConsultationByMedium()", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return null;
    }
    
    public List<Medium> topFiveMedium() {
        JpaUtil.creerContextePersistance();
        List<Medium> listeMediumRetour = null;
        try {
            List<Medium> listeMedium = mediumDao.listMediums();
            int nbMedium = listeMedium.size();
            int tabTop5[] = new int[nbMedium];
            Medium top5Medium[] = new Medium[nbMedium];
            for(int i = 0; i < 5; i++) { 
                tabTop5[i] = 0;
            }
            for(int i = 0; i < 5; i++) { 
                top5Medium[i] = listeMedium.get(0);
            }
            int indice = 0;
            for (Medium m : listeMedium) {
                List<Consultation> listeConsultation = consultationDao.findByMedium(m);
                tabTop5[indice] = listeConsultation.size();
                top5Medium[indice] = m;
                indice++;
            }
            int tempTop5;
            Medium temp5Medium;
            
            for(int i=0; i < nbMedium; i++) 
            {
                    for(int j=0; j < (nbMedium-i-1); j++)
                    {  
                            if(tabTop5[j] < tabTop5[j+1])
                            {
                                    //Swap elements
                                    tempTop5 = tabTop5[j];  
                                    tabTop5[j] = tabTop5[j+1];  
                                    tabTop5[j+1] = tempTop5;
                                    temp5Medium = top5Medium[j];  
                                    top5Medium[j] = top5Medium[j+1];  
                                    top5Medium[j+1] = temp5Medium; 
                            }

                    }
            }
            listeMediumRetour = new ArrayList<Medium>();
            for(int i = 0; i < 5; i++){
                System.out.println("Medium N° : " + (i+1) + " est le medium" + top5Medium[i].toString());
                if(tabTop5[i] != 0){
                    listeMediumRetour.add(top5Medium[i]);
                }
            }
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service Top5Medium()", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return listeMediumRetour;
        
    }
    
    public Map<Long, Integer> clientDistributionByEmployee() {
        Map<Long, Integer> mappingEmployeeClient = null;
        JpaUtil.creerContextePersistance();
 
        try {
            mappingEmployeeClient = new HashMap<>();
            List<Employee> listeEmployee = employeeDao.listEmployees();

            for (Employee e : listeEmployee) {
                List<Client> listeClientConsulte = clientDao.findClientsByEmployee(e);
                mappingEmployeeClient.put(e.getId(), listeClientConsulte.size());
            }
            
            mappingEmployeeClient = mappingEmployeeClient.entrySet()
                .stream()
                .sorted((Map.Entry.<Long, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service repartitionClientParMedium()", e);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return mappingEmployeeClient;
    }
    
    
}