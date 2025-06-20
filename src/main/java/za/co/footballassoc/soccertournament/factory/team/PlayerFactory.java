package za.co.footballassoc.soccertournament.factory.team;

import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.team.Gender;
import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.domain.team.PlayerPosition;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.time.LocalDate;

public class PlayerFactory {
    public static Player createMalePlayer(String playerID, Name playerName, Gender playerGender, String playerNationality, LocalDate playerDateOfBirth, Location playerLocationOfBirth, PlayerPosition playerPosition, double playerHeight, double playerWeight, Team club, int kitNumber, Team nationalTeam) {
        return new Player.Builder()
                .setPlayerID(playerID)
                .setPlayerName(playerName)
                .setPlayerGender(playerGender)
                .setPlayerNationality(playerNationality)
                .setPlayerDateOfBirth(playerDateOfBirth)
                .setPlayerLocationOfBirth(playerLocationOfBirth)
                .setPlayerPosition(playerPosition)
                .setPlayerHeight(playerHeight)
                .setPlayerWeight(playerWeight)
                .setClub(club)
                .setKitNumber(kitNumber)
                .setNationalTeam(nationalTeam)
                .build();
    }

    public static Player createFemalePlayer(String playerID, Name playerName, Gender playerGender, String playerNationality, LocalDate playerDateOfBirth, Location playerLocationOfBirth, PlayerPosition playerPosition, double playerHeight, double playerWeight, Team club, int kitNumber, Team nationalTeam) {
        return new Player.Builder()
                .setPlayerID(playerID)
                .setPlayerName(playerName)
                .setPlayerGender(playerGender)
                .setPlayerNationality(playerNationality)
                .setPlayerDateOfBirth(playerDateOfBirth)
                .setPlayerLocationOfBirth(playerLocationOfBirth)
                .setPlayerPosition(playerPosition)
                .setPlayerHeight(playerHeight)
                .setPlayerWeight(playerWeight)
                .setClub(club)
                .setKitNumber(kitNumber)
                .setNationalTeam(nationalTeam)
                .build();
    }


}
