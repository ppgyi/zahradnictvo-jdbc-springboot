package sk.pgyi.zahradnictvox.domeny;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class NakupnyZoznam {

    @NonNull
    private Integer id;

    @NonNull
    private String nazov;

    @NonNull
    private Integer pocet;

    public NakupnyZoznam() {
    }

    public NakupnyZoznam(@NonNull Integer id, @NonNull String nazov, @NonNull Integer pocet) {
        this.id = id;
        this.nazov = nazov;
        this.pocet = pocet;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getNazov() {
        return nazov;
    }

    public void setNazov(@NonNull String nazov) {
        this.nazov = nazov;
    }

    @NonNull
    public Integer getPocet() {
        return pocet;
    }

    public void setPocet(@NonNull Integer pocet) {
        this.pocet = pocet;
    }

    @Override
    public String toString() {
        return "NakupnyZoznam{" +
                "id=" + id +
                ", nazov='" + nazov + '\'' +
                ", pocet=" + pocet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NakupnyZoznam that = (NakupnyZoznam) o;
        return id.equals(that.id) && nazov.equals(that.nazov) && pocet.equals(that.pocet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazov, pocet);
    }
}
