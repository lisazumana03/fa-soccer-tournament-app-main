package za.co.footballassoc.soccertournament.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.tournament.Association;
import za.co.footballassoc.soccertournament.service.impl.tournament.AssociationService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/association")
public class AssociationController {
    @Autowired
    private AssociationService associationService;

    @PostMapping("/create")
    public ResponseEntity<Association> createAssociation(@RequestBody Association association) {
        Association saved = associationService.establishAssociation(association);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Association>> getAllAssociations() {
        return new ResponseEntity<>(associationService.getAssociations(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAssociation(@PathVariable("id") String id) {
        try{
            associationService.deformAssociation();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
