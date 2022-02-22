package sk.pgyi.zahradnictvox.domeny;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class Klient {

    @NonNull
    private Integer id;

    @NonNull
    private String meno;

    @NonNull
    private String priezvisko;

    @NonNull
    private String adresa;

    @NonNull
    private String telefon;

    @NonNull
    private String eMail;

    public Klient() {
    }

    public Klient(@NonNull Integer id, @NonNull String meno, @NonNull String priezvisko, @NonNull String adresa, @NonNull String telefon, @NonNull String eMail) {
        this.id = id;
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.adresa = adresa;
        this.telefon = telefon;
        this.eMail = eMail;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getMeno() {
        return meno;
    }

    public void setMeno(@NonNull String meno) {
        this.meno = meno;
    }

    @NonNull
    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(@NonNull String priezvisko) {
        this.priezvisko = priezvisko;
    }

    @NonNull
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(@NonNull String adresa) {
        this.adresa = adresa;
    }

    @NonNull
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(@NonNull String telefon) {
        this.telefon = telefon;
    }

    @NonNull
    public String geteMail() {
        return eMail;
    }

    public void seteMail(@NonNull String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id=" + id +
                ", meno='" + meno + '\'' +
                ", priezvisko='" + priezvisko + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon='" + telefon + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klient klient = (Klient) o;
        return id.equals(klient.id) && meno.equals(klient.meno) && priezvisko.equals(klient.priezvisko) && adresa.equals(klient.adresa) && telefon.equals(klient.telefon) && eMail.equals(klient.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, meno, priezvisko, adresa, telefon, eMail);
    }
}
