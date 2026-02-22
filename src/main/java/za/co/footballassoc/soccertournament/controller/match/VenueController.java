package za.co.footballassoc.soccertournament.controller.match;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.footballassoc.soccertournament.domain.match.Venue;
import za.co.footballassoc.soccertournament.service.match.impl.VenueService;

@RestController
@RequestMapping("/api/venue")
public class VenueController {
    @Autowired
    private VenueService venueService;

    @PostMapping("/create")
    public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
        return ResponseEntity.ok(venueService.create(venue));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteVenue(@RequestBody String venueID) {
        try {
            venueService.delete(venueID);
            return ResponseEntity.noContent().build(); // 204
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }
}
