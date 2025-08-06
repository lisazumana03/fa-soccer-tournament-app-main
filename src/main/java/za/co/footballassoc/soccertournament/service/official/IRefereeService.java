package za.co.footballassoc.soccertournament.service.official;

import za.co.footballassoc.soccertournament.domain.official.Referee;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;
import java.util.Optional;

public interface IRefereeService extends IService<Referee, String> {
    List<Referee> getRefereesByMatch(String matchId);
    Optional<Referee> getRefereeById(String officialId);
    void fireReferee(String officialId);
}
