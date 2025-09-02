package za.co.footballassoc.soccertournament.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.tournament.Hybrid;
import za.co.footballassoc.soccertournament.service.tournament.impl.HybridService;

import java.util.List;

@RestController
public class HybridController {
    @Autowired
    private HybridService hybridService;

    @PostMapping("/create")
    public ResponseEntity<Hybrid> createHybrid(@RequestBody Hybrid hybrid) {
        return ResponseEntity.ok(hybridService.create(hybrid));
    }

    @GetMapping
    public List<Hybrid> getAllHybrids() {
        return hybridService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hybrid> getHybridById(@PathVariable String id) {
        return hybridService.getHybridById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/association/{code}")
    public List<Hybrid> getHybridByAssociation(@PathVariable String code) {
        return hybridService.getHybridByAssociationCode(code);
    }
}
