package za.co.footballassoc.soccertournament.service.official;

import za.co.footballassoc.soccertournament.domain.official.Referee;
import za.co.footballassoc.soccertournament.domain.official.VAR;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;
import java.util.Optional;

public interface IVARService extends IService<VAR, String> {
    List<VAR> getVARsByMatch(String matchId);
    Optional<VAR> getVARById(String officialId);
    void fireVAR(String officialId);
}
