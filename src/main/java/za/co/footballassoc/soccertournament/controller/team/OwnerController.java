package za.co.footballassoc.soccertournament.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.team.Owner;
import za.co.footballassoc.soccertournament.service.team.impl.OwnerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/create")
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        return new ResponseEntity<>(ownerService.create(owner), HttpStatus.CREATED);
    }
}
