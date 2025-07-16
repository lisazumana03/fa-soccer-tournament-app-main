package za.co.footballassoc.soccertournament.service.official;

import za.co.footballassoc.soccertournament.domain.official.AssistantVAR;

import java.util.List;
import java.util.Optional;

public interface IAssistantVARService {
    AssistantVAR create(AssistantVAR assistantVAR);
    List<AssistantVAR> getAllReferees();
    List<AssistantVAR> getRefereesByMatch(String matchId);
    Optional<AssistantVAR> getAssistantVARById(String officialId);
}
