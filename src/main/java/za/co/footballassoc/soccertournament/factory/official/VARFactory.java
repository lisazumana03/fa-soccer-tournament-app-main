package za.co.footballassoc.soccertournament.factory.official;

import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.official.VAR;

import java.time.LocalDate;

public class VARFactory {
    public static VAR createVAR(String officialId, Name officialName, String officialNationality,
                                LocalDate officialDateOfBirth, Location officialLocationOfBirth,
                                String officialOrganisation, Match match, int techExperience) {
        return new VAR.Builder()
                .setTechExperience(techExperience)
                .build();
    }
}
