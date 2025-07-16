package za.co.footballassoc.soccertournament.controller.official;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.footballassoc.soccertournament.dto.MatchOfficialsDTO;
import za.co.footballassoc.soccertournament.service.impl.official.MatchOfficialsService;

@RestController
@RequestMapping("/api/match-officials")
public class MatchOfficialsController {
    @Autowired
    private MatchOfficialsService matchOfficialsService;

    @GetMapping("/match/{matchId}")
    public ResponseEntity<MatchOfficialsDTO> getOfficialsByMatch(@PathVariable String matchId) {
        return ResponseEntity.ok(matchOfficialsService.getAllOfficialsByMatch(matchId));
    }
}
