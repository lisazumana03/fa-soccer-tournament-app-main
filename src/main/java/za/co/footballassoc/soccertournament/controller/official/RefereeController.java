package za.co.footballassoc.soccertournament.controller.official;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.footballassoc.soccertournament.domain.official.Referee;
import za.co.footballassoc.soccertournament.service.official.impl.RefereeService;

@RestController
@RequestMapping("/api/referee")
public class RefereeController {
    @Autowired
    private RefereeService refereeService;

    @PostMapping("/create")
    public ResponseEntity<Referee> createReferee(@RequestBody Referee referee) {
        return ResponseEntity.ok(refereeService.create(referee));
    }
}
