package za.co.footballassoc.soccertournament.service.match.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.match.Venue;
import za.co.footballassoc.soccertournament.repository.match.VenueRepository;
import za.co.footballassoc.soccertournament.service.match.IVenueService;

import java.util.List;

@Service
public class VenueService implements IVenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public void delete(String venueId) {
        venueRepository.deleteById(venueId);
    }

    @Override
    public Venue create(Venue venue) {
        return venueRepository.save(venue);
    }

    @Override
    public Venue read(String s) {
        return null;
    }

    @Override
    public List<Venue> getAll() {
        return venueRepository.findAll();
    }

    @Override
    public Venue update(String s, Venue venue) {
        return null;
    }
}
