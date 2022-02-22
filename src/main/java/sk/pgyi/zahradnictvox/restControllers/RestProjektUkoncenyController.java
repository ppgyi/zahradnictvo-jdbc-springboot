package sk.pgyi.zahradnictvox.restControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.pgyi.zahradnictvox.domeny.Projekt;
import sk.pgyi.zahradnictvox.services.api.ProjektUkoncenyService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/projektyukoncene")
public class RestProjektUkoncenyController {

    private final ProjektUkoncenyService projektUkoncenyService;
    public RestProjektUkoncenyController(ProjektUkoncenyService projektUkoncenyService){this.projektUkoncenyService = projektUkoncenyService;}

    @PostMapping
    public ResponseEntity addProjekt (@RequestBody Projekt projekt){
        Integer id = projektUkoncenyService.addProjekt(projekt);
        if (id != null){
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity getProjekty (){
        List<Projekt> projekty = projektUkoncenyService.getProjekty();
        return new ResponseEntity<>(projekty, HttpStatus.OK);
    }

    @GetMapping("/klient/{id}")
    public ResponseEntity getProjektyByUserId (@PathVariable("id") int klientId){
        List<Projekt> projekty = projektUkoncenyService.getProjketyByUserId(klientId);
        return new ResponseEntity<>(projekty, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getProjekt (@PathVariable("id") int id){
        Projekt projekt = projektUkoncenyService.getProjekt(id);
        if (projekt != null){
            return new ResponseEntity<>(projekt, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteProjekt (@PathVariable("id") int id){
        if (projektUkoncenyService.getProjekt(id) != null){
            projektUkoncenyService.deleteProjekt(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Projekt s id: "+ id + " neexistuje!");
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity updateProjekt (@PathVariable("id") int id, @RequestBody Projekt projekt){
        if (projektUkoncenyService.getProjekt(id) != null) {
            projekt.setId(id);
            projektUkoncenyService.updateProjekt(id, projekt);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Projekt s id: "+ id + " neexistuje!");
        }
    }
}
