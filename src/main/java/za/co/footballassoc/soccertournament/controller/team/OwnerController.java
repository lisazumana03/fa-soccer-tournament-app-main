package za.co.footballassoc.soccertournament.controller.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;
import za.co.footballassoc.soccertournament.domain.team.Owner;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.service.team.impl.OwnerService;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/create")
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        return new ResponseEntity<>(ownerService.create(owner), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerService.getAll();
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable String id) {
        try {
            Owner owner = ownerService.read(id);
            return ResponseEntity.ok(owner);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable String id, @RequestBody Owner owner) {
        try {
            Owner updatedOwner = ownerService.update(id, owner);
            return ResponseEntity.ok(updatedOwner);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable String id) {
        try {
            ownerService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{ownerId}/teams")
    public ResponseEntity<List<Team>> getOwnerTeams(@PathVariable String ownerId) {
        List<Team> teams = ownerService.getTeamsByOwner(ownerId);
        return ResponseEntity.ok(teams);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Team> transferOwnership(@RequestParam String teamId, @RequestParam String newOwnerId) {
        try {
            Team updatedTeam = ownerService.transferTeamOwnership(teamId, newOwnerId);
            return ResponseEntity.ok(updatedTeam);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/sell-team")
    public ResponseEntity<Team> sellTeam(@RequestParam String teamId) {
        try {
            Team soldTeam = ownerService.sellTeam(teamId);
            return ResponseEntity.ok(soldTeam);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
