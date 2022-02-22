package sk.pgyi.zahradnictvox.services.api;

import sk.pgyi.zahradnictvox.domeny.Projekt;

import java.util.List;

public interface ProjektUkoncenyService {
    List<Projekt> getProjekty();
    Projekt getProjekt(Integer id);
    List<Projekt> getProjketyByUserId(Integer klinetId);
    Integer addProjekt(Projekt projekt);
    void deleteProjekt(Integer id);
    void updateProjekt(Integer id, Projekt projekt);
}
