package za.co.footballassoc.soccertournament.factory.official;

import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.official.FourthOfficial;

import java.time.LocalDate;

public class FourthOfficialFactory {
    public static FourthOfficial createFourthOfficial(String officialId, Name officialName, String officialNationality,
                                                      LocalDate officialDateOfBirth, Location officialLocationOfBirth,
                                                      String officialOrganisation, Match match, String role) {
        return new FourthOfficial.Builder()
                .setOfficialId(officialId)
                .setOfficialName(officialName)
                .setOfficialNationality(officialNationality)
                .setOfficialDateOfBirth(officialDateOfBirth)
                .setRole(role)
                .build();
    }
}
