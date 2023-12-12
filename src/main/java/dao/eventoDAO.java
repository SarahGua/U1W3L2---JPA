package dao;

import entites.evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class eventoDAO {

    private final EntityManager em;

    public eventoDAO(EntityManager em) {
        this.em = em;
    }

    public void saveEvent(evento event){
        // 01
        EntityTransaction transiction = em.getTransaction();

        //02
        transiction.begin();

        //03
        em.persist(event);

        //04
        transiction.commit();

    }

    public evento findByID(long id){
        evento found = em.find(evento.class, id);
        return found;
    }

    public void deleteEvent(long id){
        //01
        evento found = this.findByID(id);

        if(found != null){
            //02

            //03
            EntityTransaction transiction = em.getTransaction();

            //04
            transiction.begin();

            //05
            em.remove(found);

            //06
            transiction.commit();

            System.out.println("L'evento " + found.titolo + "è stato eliminato correttamente");
        } else {
            System.out.println("L'evento con ID " + id + " non è stato trovato");
        }
    }
}
