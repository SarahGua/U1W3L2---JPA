package org.example;

import dao.eventoDAO;
import entites.EventType;
import entites.evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1W3L2 - JPA");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        eventoDAO ed = new eventoDAO(em);

        evento event1 = new evento("Concerto Zucchero", "24-12-2023", "Concerto natalizio", EventType.PUBBLICO, 200);
        evento event2 = new evento("Mercatini Natale", "22-12-2023", "Bellissimi mercatini natalizi", EventType.PUBBLICO, 1000);
        evento event3 = new evento("Spettacolo a teatro", "20-12-2023", "Spettacolo natalizio", EventType.PRIVATO, 500);

//        ed.saveEvent(event1);
//        ed.saveEvent(event2);

        //*****************************FIND BY ID*********************************
        long id = 3;
        evento eventFromDB = ed.findByID(id);
        if(eventFromDB != null){
            System.out.println(eventFromDB);
        } else {
            System.err.println("L'evento con ID nr. " + id + "non trovato");
        }

        //*****************************DELETE**************************************
        ed.deleteEvent(3);
        ed.deleteEvent(2);

        em.close();
        emf.close();
    }
}
