package za.co.footballassoc.soccertournament.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.footballassoc.soccertournament.service.impl.tournament.AssociationService;

@RestController
@RequestMapping("/api/association")
public class AssociationController {
    @Autowired
    private AssociationService associationService;
}
