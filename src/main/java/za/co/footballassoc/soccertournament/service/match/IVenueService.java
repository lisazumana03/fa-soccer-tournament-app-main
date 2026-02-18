package za.co.footballassoc.soccertournament.service.match;

import za.co.footballassoc.soccertournament.domain.match.Venue;
import za.co.footballassoc.soccertournament.service.IService;

public interface IVenueService extends IService <Venue, String>{
    void delete(String venueId);
}
