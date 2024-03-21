package epicode.entities;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class GaraDiAtletica extends Event{
    // Attributi
    private Person atleti;
    private Person vincitore;

    // Costruttore

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Person atleti, Person vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public  GaraDiAtletica() {}

    // Getters e Setters

    public Person getAtleti() {
        return atleti;
    }

    public void setAtleti(Person atleti) {
        this.atleti = atleti;
    }

    public Person getVincitore() {
        return vincitore;
    }

    public void setVincitore(Person vincitore) {
        this.vincitore = vincitore;
    }

    // toString

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
