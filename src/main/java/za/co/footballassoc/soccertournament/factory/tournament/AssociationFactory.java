package za.co.footballassoc.soccertournament.factory.tournament;

import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.tournament.Association;
import za.co.footballassoc.soccertournament.domain.tournament.Tournament;

import java.util.List;

public class AssociationFactory {
    public static Association createAssociation(String associationCode, String associationName, Name associationCEO,
                                                Location associationHeadquarters, List<Tournament> tournaments,
                                                byte[] associationLogo) {
        return new Association.Builder()
                .setAssociationCode(associationCode)
                .setAssociationName(associationName)
                .setAssociationCEO(associationCEO)
                .setAssociationHeadquarters(associationHeadquarters)
                .setTournaments(tournaments)
                .setAssociationLogo(associationLogo)
                .build();
    }
}
