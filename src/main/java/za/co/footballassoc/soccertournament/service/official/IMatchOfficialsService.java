package za.co.footballassoc.soccertournament.service.official;

import za.co.footballassoc.soccertournament.dto.MatchOfficialsDTO;

public interface IMatchOfficialsService {
    MatchOfficialsDTO getAllOfficialsByMatch(String matchId);
}
