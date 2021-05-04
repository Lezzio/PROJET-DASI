package com.mycompany.td2.dasi.dao;

import com.mycompany.td2.dasi.metier.modele.Client;
import com.mycompany.td2.dasi.metier.modele.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author DASI Team
 */
public class ClientDao {
    
    public void create(Client client) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(client);
    }
    
    public Client searchById(Long clientId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Client.class, clientId); //Return null if doesn't exist
    }
    
    public Client searchByMail(String clientMail) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.mail = :mail", Client.class);
        query.setParameter("mail", clientMail); // correspond au paramètre ":mail" dans la requête
        List<Client> clients = query.getResultList();
        Client result = null;
        if (!clients.isEmpty()) {
            result = clients.get(0); //Return matched client by mail
        }
        return result;
    }
    
    public List<Client> listClients() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c ORDER BY c.lastName ASC, c.firstName ASC", Client.class);
        return query.getResultList();
    }
    
    public List<Client> findClientsByEmployee(Employee employee) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<Client> query = em.createQuery("SELECT DISTINCT(c.client) FROM Consultation c WHERE c.employee.id = :employee", Client.class);
        query.setParameter("employee", employee.getId()); // correspond au paramètre ":mail" dans la requête
        List<Client> clientConsultatesParEmployee = query.getResultList();
        return clientConsultatesParEmployee;
    }
    
}