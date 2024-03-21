package epicode.entities;
import javax.persistence.Entity;
import java.time.LocalDate;
@Entity
public class Concerto extends Event{
    // Attributi
    private Genere genere;
    private boolean inStreaming;

    // Costruttore
    public Concerto() {}

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    // Getters e Setters

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    // toString

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
