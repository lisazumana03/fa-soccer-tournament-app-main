package za.co.footballassoc.soccertournament.factory.official;

import org.junit.jupiter.api.Test;
import za.co.footballassoc.soccertournament.domain.official.Referee;

import static org.junit.jupiter.api.Assertions.*;

class RefereeFactoryTest {

    @Test
    void createReferee() {
        String officialId = "7809035699087";

        Referee referee = RefereeFactory.createReferee(officialId, null, null, null, null, null, null, 0);
        assertEquals(officialId, referee.getOfficialId());
        System.out.println("Created Referee: " + referee);
    }
}