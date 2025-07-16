package za.co.footballassoc.soccertournament.service.official;

import za.co.footballassoc.soccertournament.domain.official.FourthOfficial;

import java.util.List;
import java.util.Optional;

public interface IFourthOfficialService {
    FourthOfficial create(FourthOfficial fourthOfficial);
    List<FourthOfficial> getAllFourthOfficials();
    List<FourthOfficial> getFourthOfficialsByMatch(String matchId);
    Optional<FourthOfficial> getFourthOfficialById(String officialId);
}
