package za.co.footballassoc.soccertournament.service.official.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.official.AssistantVAR;
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
    public Referee create(Referee referee) {
        return refereeRepository.save(referee);
    }

    @Override
    public Referee read(String s) {
        return null;
    }

    @Override
    public List<Referee> getAll() {
        return refereeRepository.findAll();
    }

    @Override
    public Referee update(String officialId, Referee updatedReferee) {
        Referee referee = refereeRepository.findById(officialId)
                .orElseThrow(()->new RuntimeException("Referee not found"));
        Referee updated = new Referee.Builder()
                .copy(referee)
                .setOfficialName(updatedReferee.getOfficialName())
                .setOfficialGender(updatedReferee.getOfficialGender())
                .setOfficialNationality(updatedReferee.getOfficialNationality())
                .setOfficialDateOfBirth(updatedReferee.getOfficialDateOfBirth())
                .setOfficialLocationOfBirth(updatedReferee.getOfficialLocationOfBirth())
                .setOfficialOrganisation(updatedReferee.getOfficialOrganisation())
                .setCertificationLevel(updatedReferee.getCertificationLevel())
                .build();
        return refereeRepository.save(updatedReferee);
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
    public void fireReferee(String officialId) {
        refereeRepository.deleteById(officialId);
    }
}
