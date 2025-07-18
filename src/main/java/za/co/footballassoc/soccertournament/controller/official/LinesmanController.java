package za.co.footballassoc.soccertournament.controller.official;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.footballassoc.soccertournament.domain.official.Linesman;
import za.co.footballassoc.soccertournament.service.official.impl.LinesmanService;

@RestController
@RequestMapping("/api/linesman")
public class LinesmanController {
    @Autowired
    private LinesmanService linesmanService;

    @PostMapping("/create")
    public ResponseEntity<Linesman> create(@RequestBody Linesman linesman) {
        return ResponseEntity.ok(linesmanService.create(linesman));
    }
}
