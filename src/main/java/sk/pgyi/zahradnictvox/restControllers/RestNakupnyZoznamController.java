package sk.pgyi.zahradnictvox.restControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.pgyi.zahradnictvox.domeny.NakupnyZoznam;
import sk.pgyi.zahradnictvox.services.api.NakupnyZoznamService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/nakupnyzoznam")
public class RestNakupnyZoznamController {

    private final NakupnyZoznamService nakupnyZoznamService;
    public RestNakupnyZoznamController(NakupnyZoznamService nakupnyZoznamService){this.nakupnyZoznamService = nakupnyZoznamService;}

    @PostMapping
    public ResponseEntity addPolozkaNakZoz (@RequestBody NakupnyZoznam nakupnyZoznam){
        Integer id = nakupnyZoznamService.addPolozkaNakZoz(nakupnyZoznam);

        if (id != null){
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity getNakupnyZoznam (){
        List<NakupnyZoznam> nakupnyZoznam = nakupnyZoznamService.getNakupnyZoznam();
        return new ResponseEntity<>(nakupnyZoznam, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getPolozkaNakZoz (@PathVariable("id") int id){
        NakupnyZoznam nakupnyZoznam = nakupnyZoznamService.getPolozkaNakZoz(id);
        if (nakupnyZoznam != null){
            return new ResponseEntity<>(nakupnyZoznam, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePolozkaNakZoz (@PathVariable("id") int id){
        if (nakupnyZoznamService.getPolozkaNakZoz(id) != null){
            nakupnyZoznamService.deletePolozkaNakZoz(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Polozka s id: "+ id + " neexistuje!");
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity updatePolozkaNakZoz (@PathVariable("id") int id, @RequestBody NakupnyZoznam nakupnyZoznam){
        if (nakupnyZoznamService.getPolozkaNakZoz(id) != null) {
            nakupnyZoznam.setId(id);
            nakupnyZoznamService.updatePolozkaNakZoz(id, nakupnyZoznam);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Polozka s id: "+ id + " neexistuje!");
        }
    }
}
