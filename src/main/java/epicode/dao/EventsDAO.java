package epicode.dao;

import epicode.entities.Concerto;
import epicode.entities.Event;
import epicode.entities.Genere;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventsDAO {
    private EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Event evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();
            System.out.println("Evento - " + evento.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Event found = em.find(Event.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Evento eliminato");
            } else System.out.println("Evento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // metodo che restituisce tutti gli eventi in streaming tramite JPQL
        public List<Concerto> getConcertiInStreaming(boolean inStraming){
            TypedQuery<Concerto> query = em.createQuery("SELECT c.id FROM Concerto c WHERE c.idEvento = :idEvento", Concerto.class);
            query.setParameter("inStraming", inStraming);
            return query.getResultList();
        }

        // metodo che restituisce tutti gli eventi per genere tramite JPQL
        public List<Concerto> getConcertiPerGenere (Genere genere){
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
        }
}
