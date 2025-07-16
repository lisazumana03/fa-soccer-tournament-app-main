package za.co.footballassoc.soccertournament.service.official;

import za.co.footballassoc.soccertournament.domain.official.Linesman;
import za.co.footballassoc.soccertournament.domain.official.Referee;

import java.util.List;
import java.util.Optional;

public interface ILinesmanService {
    Linesman create(Linesman linesman);
    List<Linesman> getAllLinesmen();
    List<Linesman> getLinesmenByMatch(String matchId);
    Optional<Linesman> getLinesmenById(String officialId);
    void fireLinesman(Linesman linesman);
}
