package za.co.footballassoc.soccertournament.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import za.co.footballassoc.soccertournament.service.impl.tournament.HybridService;

@RestController
public class HybridController {
    @Autowired
    private HybridService hybridService;
}
