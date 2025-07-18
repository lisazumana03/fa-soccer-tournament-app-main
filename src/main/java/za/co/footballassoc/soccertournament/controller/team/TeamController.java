package za.co.footballassoc.soccertournament.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.service.impl.team.PlayerService;
import za.co.footballassoc.soccertournament.service.impl.team.TeamService;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        return new ResponseEntity<>(teamService.create(team), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Team>> getTeam(@PathVariable String id) {
        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable("id") String teamId, @RequestBody Team updatedTeam) {
        try {
            Team result = teamService.update(teamId, updatedTeam);
            return ResponseEntity.ok(result); // 200 OK with updated team
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }


    @GetMapping("/delete/{id}")
    public void deleteTeam(@PathVariable String id) {
        teamService.delete(id);
    }
}
