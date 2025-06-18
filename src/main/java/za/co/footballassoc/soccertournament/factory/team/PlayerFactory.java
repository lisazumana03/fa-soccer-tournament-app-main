package za.co.footballassoc.soccertournament.factory.team;

import za.co.footballassoc.soccertournament.domain.team.Player;

public class PlayerFactory {
    public static Player createPlayer() {
        return new Player.Builder()
                .setPlayerID(createPlayer().getPlayerID())
                .setPlayerName(createPlayer().getPlayerName())
                .setPlayerNationality(createPlayer().getPlayerNationality())
                .setPlayerDateOfBirth(createPlayer().getPlayerDateOfBirth())
                .setPlayerLocationOfBirth(createPlayer().getPlayerLocationOfBirth())
                .setPlayerPosition(createPlayer().getPlayerPosition())
                .setPlayerHeight(createPlayer().getPlayerHeight())
                .setPlayerWeight(createPlayer().getPlayerWeight())
                .setClub(createPlayer().getClub())
                .setNationalTeam(createPlayer().getNationalTeam()).build();
    }
}
