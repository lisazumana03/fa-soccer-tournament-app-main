package za.co.footballassoc.soccertournament.factory.team;

import org.junit.jupiter.api.Test;
import za.co.footballassoc.soccertournament.domain.team.Player;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFactoryTest {

    @Test
    void createPlayer() {
        Player player = PlayerFactory.createPlayer();
        assertNotNull(PlayerFactory.createPlayer());
        System.out.println("Created Player " + player);
    }
}