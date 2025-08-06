package za.co.footballassoc.soccertournament.service.official;

import za.co.footballassoc.soccertournament.domain.official.AssistantVAR;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;
import java.util.Optional;

public interface IAssistantVARService extends IService<AssistantVAR, String> {
    void fireAssistantVARs(String officialId);
    List<AssistantVAR> getRefereesByMatch(String matchId);
    Optional<AssistantVAR> getAssistantVARById(String officialId);
}
