package za.co.footballassoc.soccertournament.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.Knockout;
import za.co.footballassoc.soccertournament.service.tournament.impl.KnockoutService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/knockout")
public class KnockoutController {
    @Autowired
    private KnockoutService knockoutService;

    @PostMapping("/create")
    public ResponseEntity<Knockout> createKnockout(@RequestBody Knockout knockout) {
        return ResponseEntity.ok(knockoutService.create(knockout));
    }

    @GetMapping
    public List<Knockout> getAllKnockouts() {
        return knockoutService.getAllKnockouts();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateKnockout(@PathVariable String knockoutId, @RequestBody Knockout updatedKnockout) {
        try {
            Knockout knockout = knockoutService.update(knockoutId, updatedKnockout);
            return ResponseEntity.ok(knockout);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/association/{code}")
    public List<Knockout> getKnockoutsByAssociation(@PathVariable String code) {
        return knockoutService.getKnockoutsByAssociation(code);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Knockout> getKnockout(@PathVariable String id) {
        return knockoutService.getKnockoutById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 2. Process Knockout Match Result (trigger winner logic)
    @PostMapping("/matches/{matchId}/process")
    public ResponseEntity<?> processKnockoutMatch(@PathVariable String matchId) {
        try {
            Team winner = knockoutService.processKnockoutMatchResult(matchId);
            return ResponseEntity.ok(winner);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    // 3. Generate Next Knockout Round
    @PostMapping("/{knockoutId}/next-round")
    public ResponseEntity<?> generateNextRound(@PathVariable String knockoutId) {
        Optional<Knockout> knockoutOpt = knockoutService.getKnockoutById(knockoutId);
        if (knockoutOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Knockout not found");
        }

        try {
            List<Match> newMatches = knockoutService.generateNextKnockoutRound(knockoutOpt.get());
            return ResponseEntity.ok(newMatches);
        } catch (IllegalStateException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
