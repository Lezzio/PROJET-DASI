/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.td2.dasi.utils;

import com.mycompany.td2.dasi.dao.JpaUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author maxim
 */
@Entity
public class MessageInspiration implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    String texteMessage;
    int numeroMessage;

    public MessageInspiration(long id, String texteMessage, int numeroMessage) {
        this.id = id;
        this.texteMessage = texteMessage;
        this.numeroMessage = numeroMessage;
    }

    public MessageInspiration() {
    }

    public long getId() {
        return id;
    }

    public int getNumeroMessage() {
        return numeroMessage;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumeroMessage(int numeroMessage) {
        this.numeroMessage = numeroMessage;
    }
    
    public void setTexteMessage(String texteMessage) {
        this.texteMessage = texteMessage;
    }

    public String getTexteMessage() {
        return texteMessage;
    }
    
    public void persisterMessageInspiration(MessageInspiration messageInspiration) {
        JpaUtil.creerContextePersistance();
        try {
            JpaUtil.ouvrirTransaction();
            EntityManager em = JpaUtil.obtenirContextePersistance();
            em.persist(messageInspiration);
            JpaUtil.validerTransaction();
            System.out.println("initilisation du message d'inspiration réussie");
        } catch (Exception ex) {
            //Affichage de précis de l'erreur encourue
            Logger.getAnonymousLogger().log(Level.WARNING, "Exception lors de l'appel au Service initialiserMessageInspiration(MessageInspiration messageInspiration)", ex);
            JpaUtil.annulerTransaction();
            System.out.println("initilisation du message d'inspiration échouée");
        } finally {
            JpaUtil.fermerContextePersistance();
        }
    }
    
     public List<MessageInspiration> listeMessageAmour(){
        
        List<MessageInspiration> listeMessageAmour = new ArrayList<MessageInspiration>();
        
        MessageInspiration message1 = new MessageInspiration("Il n'y a rien de plus précieux en ce monde que le sentiment d'exister pour quelqu'un.", 1);
        MessageInspiration message2 = new MessageInspiration("Il n'y a qu'un bonheur dans la vie, c'est d'aimer et d'être aimé.", 2);
        
        MessageInspiration message3 = new MessageInspiration("Aimer c'est savoir dire je t'aime sans parler.", 3);
        MessageInspiration message4 = new MessageInspiration("Aimer, c'est vivre ; aimer c'est voir ; aimer c'est être.", 4);
        
        MessageInspiration message5 = new MessageInspiration("L'amour est comme le vent, nous ne savons pas d'où il vient", 5);
        MessageInspiration message6 = new MessageInspiration("Quand tu tombes amoureux de la lune, tu arrêtes de regarder les étoiles.", 6);
        
        MessageInspiration message7 = new MessageInspiration("Il y a des êtres qui nous touchent plus que d'autres, sans doute parce que, sans que nous le sachions nous-mêmes, ils portent en eux "
                + "une partie de ce qui nous manque.", 7);
        MessageInspiration message8 = new MessageInspiration("Si seulement les gens qu'on aime pouvaient se voir de la façon dont on les voit.", 8);
        
        persisterMessageInspiration(message1);
        persisterMessageInspiration(message2);
        persisterMessageInspiration(message3);
        persisterMessageInspiration(message4);
        persisterMessageInspiration(message5);
        persisterMessageInspiration(message6);
        persisterMessageInspiration(message7);
        persisterMessageInspiration(message8);
        
        listeMessageAmour.add(message1);
        listeMessageAmour.add(message2);
        listeMessageAmour.add(message3);
        listeMessageAmour.add(message4);
        listeMessageAmour.add(message5);
        listeMessageAmour.add(message6);
        listeMessageAmour.add(message7);
        listeMessageAmour.add(message8);
        
        return listeMessageAmour;      
    }
    
    public List<MessageInspiration> listeMessageSanté(){
        
        List<MessageInspiration> listeMessageSanté = new ArrayList<MessageInspiration>();
        
        MessageInspiration message1 = new MessageInspiration("Qui est en bonne santé est riche sans le savoir.", 11);
        MessageInspiration message2 = new MessageInspiration("La meilleure santé, c'est de ne pas sentir sa santé.", 12);
        
        MessageInspiration message3 = new MessageInspiration("La santé est le support de notre vie, l'oublier c'est ôter l'essence à notre survie.", 13);
        MessageInspiration message4 = new MessageInspiration("La santé c'est d'avoir mal tous les jours à un endroit différent.", 14);
        
        MessageInspiration message5 = new MessageInspiration("La santé est hypocrite, elle loge notre corps, mais à tout moment peut lui causer des torts.", 15);
        MessageInspiration message6 = new MessageInspiration("Deux choses ne s'apprécient bien que quand on ne les a plus : la santé et la jeunesse.", 16);
        
        MessageInspiration message7 = new MessageInspiration("La bonne santé n'est que la plus lente des façons de mourir", 17);
        MessageInspiration message8 = new MessageInspiration("Mourir en bonne santé, c'est le voeu le plus cher de tout bon vivant bien portant.", 18);
        
        persisterMessageInspiration(message1);
        persisterMessageInspiration(message2);
        persisterMessageInspiration(message3);
        persisterMessageInspiration(message4);
        persisterMessageInspiration(message5);
        persisterMessageInspiration(message6);
        persisterMessageInspiration(message7);
        persisterMessageInspiration(message8);
        
        listeMessageSanté.add(message1);
        listeMessageSanté.add(message2);
        listeMessageSanté.add(message3);
        listeMessageSanté.add(message4);
        listeMessageSanté.add(message5);
        listeMessageSanté.add(message6);
        listeMessageSanté.add(message7);
        listeMessageSanté.add(message8);
        
        return listeMessageSanté;      
    }

    public MessageInspiration(String texteMessage, int numeroMessage) {
        this.texteMessage = texteMessage;
        this.numeroMessage = numeroMessage;
    }
    
    public List<MessageInspiration> listeMessageTravail(){
        
        List<MessageInspiration> listeMessageTravail = new ArrayList<MessageInspiration>();
        
        MessageInspiration message1 = new MessageInspiration("C'est travail qui nourrit l'homme.", 21);
        MessageInspiration message2 = new MessageInspiration("Le talent est un jardin et le travail est son jardinier.", 22);
        
        MessageInspiration message3 = new MessageInspiration("Travailler dur est la seule manière d'avoir ce que tu veux dans ce monde.", 23);
        MessageInspiration message4 = new MessageInspiration("On ne peut rien obtenir de bien sans travail.", 24);
        
        MessageInspiration message5 = new MessageInspiration("Le travail de demain, c'est l'effort personnel d'aujourd'hui.", 25);
        MessageInspiration message6 = new MessageInspiration("L'homme ne vit pas du nom, mais du travail.", 26);
        
        MessageInspiration message7 = new MessageInspiration("Le travail comme le génie est un don.", 27);
        MessageInspiration message8 = new MessageInspiration("Le travail est pour les hommes un trésor.", 28);
        
        persisterMessageInspiration(message1);
        persisterMessageInspiration(message2);
        persisterMessageInspiration(message3);
        persisterMessageInspiration(message4);
        persisterMessageInspiration(message5);
        persisterMessageInspiration(message6);
        persisterMessageInspiration(message7);
        persisterMessageInspiration(message8);
        
        listeMessageTravail.add(message1);
        listeMessageTravail.add(message2);
        listeMessageTravail.add(message3);
        listeMessageTravail.add(message4);
        listeMessageTravail.add(message5);
        listeMessageTravail.add(message6);
        listeMessageTravail.add(message7);
        listeMessageTravail.add(message8);
        
        return listeMessageTravail;      
    }
    
}
