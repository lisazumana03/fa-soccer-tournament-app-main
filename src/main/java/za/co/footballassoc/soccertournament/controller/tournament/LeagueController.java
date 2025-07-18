package za.co.footballassoc.soccertournament.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.League;
import za.co.footballassoc.soccertournament.service.tournament.impl.LeagueService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/league")
public class LeagueController {
    @Autowired
    private LeagueService leagueService;

    @PostMapping("/create")
    public ResponseEntity <League> createLeague(@RequestBody League league) {
        return ResponseEntity.ok(leagueService.create(league));
    }

    @GetMapping
    public List<League> getAllLeagues() {
        return leagueService.getAllLeagues();
    }

    @GetMapping("/association/{code}")
    public List<League> getLeaguesByAssociation(@PathVariable String code) {
        return leagueService.getLeaguesByAssociation(code);
    }

    @GetMapping("/{id}")
    public ResponseEntity<League> getLeagueById(@PathVariable("id") String id) {
        return leagueService.getLeagueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //League logic
    @GetMapping("/{leagueId}/table")
    public ResponseEntity<List<Team>> getLeagueTable(@PathVariable String leagueId) {
        return ResponseEntity.ok(leagueService.getLeagueTable(leagueId));
    }

    @GetMapping("/{leagueId}/promoted")
    public ResponseEntity<List<Team>> getLeaguePromoted(@PathVariable String leagueId) {
        return ResponseEntity.ok(leagueService.getPromotedTeams(leagueId));
    }

    @GetMapping("/{leagueId}/relegated")
    public ResponseEntity<List<Team>> getLeagueRelegated(@PathVariable String leagueId) {
        return ResponseEntity.ok(leagueService.getRelegatedTeams(leagueId));
    }

    @GetMapping("/{leagueId}/continental")
    public ResponseEntity<List<Team>> getContinentalQualifiedTeams(@PathVariable String leagueId) {
        return ResponseEntity.ok(leagueService.getContinentalQualifiedTeams(leagueId));
    }

    // Get league champion
    @GetMapping("/{leagueId}/champion")
    public ResponseEntity<?> getChampion(@PathVariable String leagueId) {
        Optional<Team> champion = leagueService.getChampion(leagueId);

        if (champion.isPresent()) {
            return ResponseEntity.ok(champion.get()); // type: ResponseEntity<Team>
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "League not finished or no champion available")); // type: ResponseEntity<Map>
        }
    }

    // Simulate full season (calls match processor for completed matches)
    @PostMapping("/{leagueId}/simulate")
    public ResponseEntity<String> simulateFullSeason(@PathVariable String leagueId) {
        leagueService.simulateFullSeason(leagueId);
        return ResponseEntity.ok("Season simulation completed.");
    }

    // Process one completed match
    @PostMapping("/match/{matchId}/process")
    public ResponseEntity<String> processMatch(@PathVariable String matchId) {
        try {
            leagueService.processLeagueMatchResult(matchId);
            return ResponseEntity.ok("Match processed.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
