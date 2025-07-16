package za.co.footballassoc.soccertournament.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.tournament.League;
import za.co.footballassoc.soccertournament.service.impl.tournament.LeagueService;

import java.util.List;

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


}
