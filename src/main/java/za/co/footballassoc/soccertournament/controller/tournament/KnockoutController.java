package za.co.footballassoc.soccertournament.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.tournament.Knockout;
import za.co.footballassoc.soccertournament.service.tournament.impl.KnockoutService;

import java.util.List;

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

    @GetMapping("/association/{code}")
    public List<Knockout> getKnockoutsByAssociation(@PathVariable String code) {
        return knockoutService.getKnockoutsByAssociation(code);
    }
}
