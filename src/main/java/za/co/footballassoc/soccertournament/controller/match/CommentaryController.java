package za.co.footballassoc.soccertournament.controller.match;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.footballassoc.soccertournament.domain.match.Commentary;
import za.co.footballassoc.soccertournament.service.match.impl.CommentaryService;

@RestController
@RequestMapping("/api/commentary-team")
public class CommentaryController {
    @Autowired
    private CommentaryService commentaryService;

    @PostMapping("/create")
    public ResponseEntity<Commentary> createCommentary(@RequestBody Commentary commentary) {
        return ResponseEntity.ok(commentaryService.create(commentary));
    }
}
