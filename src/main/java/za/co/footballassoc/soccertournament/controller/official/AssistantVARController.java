package za.co.footballassoc.soccertournament.controller.official;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.official.AssistantVAR;
import za.co.footballassoc.soccertournament.service.official.impl.AssistantVARService;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/assistant-var")
public class AssistantVARController {

    @Autowired
    private AssistantVARService assistantVARService;

    @PostMapping("/create")
    public ResponseEntity<AssistantVAR> create(@RequestBody AssistantVAR assistantVAR) {
        return ResponseEntity.ok(assistantVARService.create(assistantVAR));
    }
}
