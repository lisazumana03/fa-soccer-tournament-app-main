package za.co.footballassoc.soccertournament.service.match.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.match.MatchEvent;
import za.co.footballassoc.soccertournament.repository.match.MatchEventRepository;
import za.co.footballassoc.soccertournament.service.match.IMatchEventService;

import java.util.List;

@Service
public class MatchEventService implements IMatchEventService {
    @Autowired
    private MatchEventRepository matchEventRepository;

    @Override
    public MatchEvent create(MatchEvent matchEvent) {
        return matchEventRepository.save(matchEvent);
    }

    @Override
    public MatchEvent read(String matchId) {
        return matchEventRepository.findById(matchId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<MatchEvent> getAll() {
        return matchEventRepository.findAll();
    }

    @Override
    public MatchEvent update(String eventID, MatchEvent matchEvent) {
        return null;
    }

    @Override
    public void deleteMatchEvent(String eventID) {
        if (!matchEventRepository.existsById(eventID)) {
            throw new EntityNotFoundException("Event not found with ID: " + eventID);
        }
        matchEventRepository.deleteById(eventID);
    }
}
