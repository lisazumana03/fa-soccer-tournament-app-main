package za.co.footballassoc.soccertournament.controller.team;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.team.Owner;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.service.team.impl.OwnerService;

import java.util.List;

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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Owner> deleteOwner(@PathVariable String id) {
        try {
            ownerService.delete(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }

    @GetMapping("/{ownerId}/teams")
    public ResponseEntity<List<Team>> getOwnerTeams(@PathVariable String ownerId) {
        List<Team> teams = ownerService.getTeamsByOwner(ownerId);
        return ResponseEntity.ok(teams);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Team> transferOwnership(@RequestParam String teamId, @RequestParam String newOwnerId) {
        Team updatedTeam = ownerService.transferTeamOwnership(teamId, newOwnerId);
        return ResponseEntity.ok(updatedTeam);
    }
}
