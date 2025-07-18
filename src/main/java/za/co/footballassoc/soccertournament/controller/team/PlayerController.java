package za.co.footballassoc.soccertournament.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.service.impl.team.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@CrossOrigin(origins = "*")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return new ResponseEntity<>(playerService.create(player), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/update")
    public ResponseEntity<Player> updatePlayer(Player player) {
        return new ResponseEntity<>(playerService.update(player), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public void deletePlayer(@PathVariable("id") String playerID) {
        playerService.delete(playerID);
    }

}
