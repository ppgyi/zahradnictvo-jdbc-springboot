package sk.pgyi.zahradnictvox.domeny;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.NonNull;

import java.sql.Date;
import java.util.Objects;

public class Projekt {

    @NonNull
    private Integer id;

    @NonNull
    private Integer klientId;

    @NonNull
    private String nazov;

    @NonNull
    private String popis;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NonNull
    private Date datum;

    @NonNull
    private String adresaprojektu;

    @NonNull
    private boolean ukoncene;

    public Projekt() {
    }

    public Projekt(@NonNull Integer id, @NonNull Integer klientId, @NonNull String nazov, @NonNull String popis, @NonNull Date datum, @NonNull String adresaprojektu, boolean ukoncene) {
        this.id = id;
        this.klientId = klientId;
        this.nazov = nazov;
        this.popis = popis;
        this.datum = datum;
        this.adresaprojektu = adresaprojektu;
        this.ukoncene = ukoncene;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getKlientId() {
        return klientId;
    }

    public void setKlientId(@NonNull Integer klientId) {
        this.klientId = klientId;
    }

    @NonNull
    public String getNazov() {
        return nazov;
    }

    public void setNazov(@NonNull String nazov) {
        this.nazov = nazov;
    }

    @NonNull
    public String getPopis() {
        return popis;
    }

    public void setPopis(@NonNull String popis) {
        this.popis = popis;
    }

    @NonNull
    public Date getDatum() {
        return datum;
    }

    public void setDatum(@NonNull Date datum) {
        this.datum = datum;
    }

    @NonNull
    public String getAdresaprojektu() {
        return adresaprojektu;
    }

    public void setAdresaprojektu(@NonNull String adresaprojektu) {
        this.adresaprojektu = adresaprojektu;
    }

    public boolean isUkoncene() {
        return ukoncene;
    }

    public void setUkoncene(boolean ukoncene) {
        this.ukoncene = ukoncene;
    }

    @Override
    public String toString() {
        return "Projekt{" +
                "id=" + id +
                ", klientId=" + klientId +
                ", nazov='" + nazov + '\'' +
                ", popis='" + popis + '\'' +
                ", datum=" + datum +
                ", adresaprojektu='" + adresaprojektu + '\'' +
                ", ukoncene=" + ukoncene +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projekt projekt = (Projekt) o;
        return ukoncene == projekt.ukoncene && id.equals(projekt.id) && klientId.equals(projekt.klientId) && nazov.equals(projekt.nazov) && popis.equals(projekt.popis) && datum.equals(projekt.datum) && adresaprojektu.equals(projekt.adresaprojektu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, klientId, nazov, popis, datum, adresaprojektu, ukoncene);
    }
}
