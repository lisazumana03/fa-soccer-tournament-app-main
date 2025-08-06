package za.co.footballassoc.soccertournament.service.official;

import za.co.footballassoc.soccertournament.domain.official.FourthOfficial;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;
import java.util.Optional;

public interface IFourthOfficialService extends IService<FourthOfficial, String> {
    List<FourthOfficial> getFourthOfficialsByMatch(String matchId);
    Optional<FourthOfficial> getFourthOfficialById(String officialId);
}
