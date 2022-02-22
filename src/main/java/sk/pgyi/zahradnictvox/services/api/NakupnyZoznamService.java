package sk.pgyi.zahradnictvox.services.api;

import sk.pgyi.zahradnictvox.domeny.NakupnyZoznam;

import java.util.List;

public interface NakupnyZoznamService {
    List<NakupnyZoznam> getNakupnyZoznam();
    Integer addPolozkaNakZoz(NakupnyZoznam nakupnyZoznam);
    NakupnyZoznam getPolozkaNakZoz(Integer id);
    void deletePolozkaNakZoz(Integer id);
    void updatePolozkaNakZoz(Integer id, NakupnyZoznam nakupnyZoznam);
}
