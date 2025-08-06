package za.co.footballassoc.soccertournament.controller.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.match.MatchStatus;
import za.co.footballassoc.soccertournament.service.match.impl.MatchService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        return ResponseEntity.ok(matchService.create(match));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable String id) {
        return matchService.getMatchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAll();
    }

    @GetMapping("/tournament/{tournamentId}")
    public List<Match> getMatchesByTournament(@PathVariable String tournamentId) {
        return matchService.getMatchesByTournament(tournamentId);
    }

    @GetMapping("/team/{teamId}")
    public List<Match> getMatchesByTeam(@PathVariable String teamId) {
        return matchService.getMatchesByTeam(teamId);
    }

    @PutMapping("/{id}/score")
    public ResponseEntity<Match> updateMatchScore(@PathVariable String id,
                                                  @RequestParam int homeScore,
                                                  @RequestParam int awayScore,
                                                  @RequestParam MatchStatus status,
                                                  @RequestParam LocalDateTime fullTime) {
        return ResponseEntity.ok(matchService.updateMatchScore(id, homeScore, awayScore, status, fullTime));
    }
}
