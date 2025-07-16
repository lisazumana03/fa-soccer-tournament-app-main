package za.co.footballassoc.soccertournament.factory.official;

import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.official.AssistantVAR;

import java.time.LocalDate;

public class AssistantVARFactory {
    public static AssistantVAR createAssistantVAR(String officialId, Name officialName,
                                                  String officialNationality, LocalDate officialDateOfBirth,
                                                  Location officialLocationOfBirth, String officialOrganisation,
                                                  Match match, String supportRole) {
        return new AssistantVAR.Builder()
                .setOfficialId(officialId)
                .setOfficialName(officialName)
                .setOfficialNationality(officialNationality)
                .setOfficialDateOfBirth(officialDateOfBirth)
                .setOfficialLocationOfBirth(officialLocationOfBirth)
                .setOfficialOrganisation(officialOrganisation)
                .setMatch(match)
                .setSupportRole(supportRole).build();
    }
}
