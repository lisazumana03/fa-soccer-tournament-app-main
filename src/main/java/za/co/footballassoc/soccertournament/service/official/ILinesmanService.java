package za.co.footballassoc.soccertournament.service.official;

import za.co.footballassoc.soccertournament.domain.official.Linesman;
import za.co.footballassoc.soccertournament.domain.official.Referee;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;
import java.util.Optional;

public interface ILinesmanService extends IService<Linesman, String> {
    List<Linesman> getLinesmenByMatch(String matchId);
    Optional<Linesman> getLinesmenById(String officialId);
    void fireLinesman(String officialId);
}
