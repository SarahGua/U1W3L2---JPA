package entites;


import javax.persistence.*;

@Entity
@Table(name = "evento")
public class evento {
    @Id
    @GeneratedValue
    public long id;
    public String titolo;
    public String dataEvento;
    public String descrizione;
    @Enumerated(EnumType.STRING)
    public EventType tipo;
    public int numeroMaxPArtecipanti;

    public evento(){}

    public evento(String titolo, String dataEvento, String descrizione, EventType tipo, int numeroMaxPArtecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numeroMaxPArtecipanti = numeroMaxPArtecipanti;
    }

    @Override
    public String toString() {
        return "evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento='" + dataEvento + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", numeroMaxPArtecipanti=" + numeroMaxPArtecipanti +
                '}';
    }
}
