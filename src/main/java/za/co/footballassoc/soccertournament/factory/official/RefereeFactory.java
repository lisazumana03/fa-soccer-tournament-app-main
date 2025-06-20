package za.co.footballassoc.soccertournament.factory.official;

import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.official.Referee;

import java.time.LocalDate;

public class RefereeFactory {
    public static Referee createReferee(String officialId, Name officialName, String officialNationality,
                                        LocalDate officialDateOfBirth, Location officialLocationOfBirth,
                                        String officialOrganisation, Match match, int certificationLevel) {
        return new Referee.Builder()
                .setOfficialId(officialId)
                .setOfficialName(officialName)
                .setOfficialNationality(officialNationality)
                .setMatch(match)
                .setOfficialDateOfBirth(officialDateOfBirth)
                .setOfficialLocationOfBirth(officialLocationOfBirth)
                .setOfficialOrganisation(officialOrganisation)
                .setCertificationLevel(certificationLevel)
                .build();
    }
}
