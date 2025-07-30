package za.co.footballassoc.soccertournament.controller.official;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.footballassoc.soccertournament.service.official.impl.VARService;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/var")
public class VARController {
    @Autowired
    private VARService varService;
}
