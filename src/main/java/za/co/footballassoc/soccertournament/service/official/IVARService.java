package za.co.footballassoc.soccertournament.service.official;

import za.co.footballassoc.soccertournament.domain.official.Referee;
import za.co.footballassoc.soccertournament.domain.official.VAR;

import java.util.List;
import java.util.Optional;

public interface IVARService {
    VAR create(VAR var  );
    List<VAR> getAllVARs();
    List<VAR> getVARsByMatch(String matchId);
    Optional<VAR> getVARById(String officialId);
    void fireVAR(VAR var);
}
