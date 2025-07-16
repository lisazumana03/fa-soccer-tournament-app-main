package za.co.footballassoc.soccertournament.controller.official;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.footballassoc.soccertournament.domain.official.FourthOfficial;
import za.co.footballassoc.soccertournament.service.impl.official.FourthOfficialService;

@RestController
@RequestMapping("/api/fourth-official")
public class FourthOfficialController {
    @Autowired
    private FourthOfficialService fourthOfficialService;

    @PostMapping("/create")
    public ResponseEntity<FourthOfficial> create(@RequestBody FourthOfficial fourthOfficial) {
        return ResponseEntity.ok(fourthOfficialService.create(fourthOfficial));
    }
}
