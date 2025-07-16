package za.co.footballassoc.soccertournament.service.official;

import za.co.footballassoc.soccertournament.domain.official.Referee;

import java.util.List;
import java.util.Optional;

public interface IRefereeService {
    Referee createReferee(Referee referee);
    List<Referee> getAllReferees();
    List<Referee> getRefereesByMatch(String matchId);
    Optional<Referee> getRefereeById(String officialId);
    void fireReferee(Referee referee);
}
