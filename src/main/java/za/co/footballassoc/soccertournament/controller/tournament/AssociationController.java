package za.co.footballassoc.soccertournament.controller.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.footballassoc.soccertournament.domain.tournament.Association;
import za.co.footballassoc.soccertournament.service.impl.tournament.AssociationService;

@RestController
@RequestMapping("/api/association")
public class AssociationController {
    @Autowired
    private AssociationService associationService;

    @PostMapping("/create")
    public Association createAssociation(@RequestBody Association association) {
        return associationService.establishAssociation(association);
    }
}
