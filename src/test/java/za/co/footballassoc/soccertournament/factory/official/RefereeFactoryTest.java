package za.co.footballassoc.soccertournament.factory.official;

import org.junit.jupiter.api.Test;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.official.Referee;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RefereeFactoryTest {

    @Test
    void createReferee() {
        String officialId = "7809035699087";
        Name officialName = new Name.Builder()
                .setFirstName("Jonathan")
                .setLastName("De Vos")
                .build();

        String officialNationality = "Namibia";

        LocalDate officialDateOfBirth = LocalDate.of(1978, 9, 3);

        Location officialLocationOfBirth = new Location.Builder()
                .setCityOrTown("Windhoek")
                .setCountry("Namibia")
                .setContinent("Africa")
                .build();

        String officialOrganisation = "PGMOL";

        Match match = new Match.Builder()
                .setMatchID("MUNvLIV")
                .build();

        int certificationLevel = 4;

        Referee referee = RefereeFactory.createReferee(officialId, officialName, officialNationality, officialDateOfBirth, officialLocationOfBirth, officialOrganisation, match, certificationLevel);
        assertNotNull(referee);
        System.out.println("Created Referee: " + referee);
    }
}