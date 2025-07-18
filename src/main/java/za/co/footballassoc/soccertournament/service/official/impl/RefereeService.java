package za.co.footballassoc.soccertournament.service.official.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.official.Referee;
import za.co.footballassoc.soccertournament.repository.official.RefereeRepository;
import za.co.footballassoc.soccertournament.service.official.IRefereeService;

import java.util.List;
import java.util.Optional;

@Service
public class RefereeService implements IRefereeService {
    @Autowired
    private RefereeRepository refereeRepository;

    @Override
    public Referee createReferee(Referee referee) {
        return refereeRepository.save(referee);
    }

    @Override
    public List<Referee> getAllReferees() {
        return List.of();
    }

    @Override
    public List<Referee> getRefereesByMatch(String matchId) {
        return refereeRepository.findByMatch_MatchID(matchId);
    }

    @Override
    public Optional<Referee> getRefereeById(String officialId) {
        return Optional.empty();
    }

    @Override
    public void fireReferee(Referee referee) {
        refereeRepository.delete(referee);
    }
}
