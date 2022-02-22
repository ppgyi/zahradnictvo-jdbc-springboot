package sk.pgyi.zahradnictvox.services.api;

import sk.pgyi.zahradnictvox.domeny.Klient;

import java.util.List;

public interface KlientService {
    List<Klient> getKlienti();
    Klient getKlient(Integer id);
    Integer addKlient(Klient klient);
    void deleteKlient(Integer id);
    void updateKlient(Integer id, Klient klient);
}
