package sk.pgyi.zahradnictvox.restControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.pgyi.zahradnictvox.domeny.Klient;
import sk.pgyi.zahradnictvox.services.api.KlientService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/klienti")
public class RestKlientController {

    private final KlientService klientService;
    public RestKlientController(KlientService klientService){this.klientService = klientService;}

    @PostMapping
    public ResponseEntity addKlient (@RequestBody Klient klient){
        Integer id = klientService.addKlient(klient);

        if (id != null){
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getKlient (@PathVariable("id") int id){
        Klient klient = klientService.getKlient(id);

        if (klient != null){
            return new ResponseEntity<>(klient, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity getKlienti (){
        List<Klient> klienti = klientService.getKlienti();
        return new ResponseEntity<>(klienti, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteKlient (@PathVariable("id") int id){
        if (klientService.getKlient(id) != null){
            klientService.deleteKlient(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Klient s id: "+ id + " neexsituje!");
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity updateKlient (@PathVariable("id") int id, @RequestBody Klient klient){
        if (klientService.getKlient(id) != null){
            klient.setId(id);
            klientService.updateKlient(id, klient);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Klient s id: "+ id + " neexsituje!");
        }
    }
}
