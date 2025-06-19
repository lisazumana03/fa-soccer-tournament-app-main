package za.co.footballassoc.soccertournament.controller.official;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.footballassoc.soccertournament.service.impl.official.RefereeService;

@RestController
@RequestMapping("/api/referee")
public class RefereeController {
    @Autowired
    private RefereeService refereeService;
}
