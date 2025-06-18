package za.co.footballassoc.soccertournament.factory.team;

import za.co.footballassoc.soccertournament.domain.team.Player;

public class PlayerFactory {
    public static Player createPlayer() {
        return new Player();
    }
}
