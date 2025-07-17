package za.co.footballassoc.soccertournament.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.service.impl.team.TeamService;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/create")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        return new ResponseEntity<>(teamService.create(team), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Team>> getTeam(@PathVariable String id) {
        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
    }
}
