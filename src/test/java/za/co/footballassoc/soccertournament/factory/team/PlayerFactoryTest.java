package za.co.footballassoc.soccertournament.factory.team;

import org.junit.jupiter.api.Test;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.team.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFactoryTest {

    @Test
    void createFemalePlayer() {
        String playerID = "0409150385084";
        Name playerName = new Name.Builder()
                .setFirstName("Rendani")
                .setMiddleName("Morgan")
                .setLastName("Mudau").build();
        Gender playerGender = Gender.FEMALE;
        String playerNationality = "South Africa";

        LocalDate playerDateOfBirth = LocalDate.of(2004, 9, 15);
        Location playerLocationOfBirth = new Location.Builder()
                .setSuburb("Thathe")
                .setCityOrTown("Thohoyandou")
                .setStateOrProvince("Limpopo")
                .setCountry("South Africa")
                .setZipCodeOrPostalCode("4220").build();

        PlayerPosition playerPosition = PlayerPosition.RW;

        double playerHeight = 1.85;
        double playerWeight = 72.25;

        Team club = new Team.Builder()
                .setTeamID("MUN")
                .setTeamName("Man United")
                .setTeamFormationYear("1878")
                .setTeamType(TeamType.CLUB)
                .build();

        int kitNumber = 17;

        Team nationalTeam = new Team.Builder()
                .setTeamID("ZAR")
                .setTeamName("South Africa")
                .setTeamFormationYear("1994")
                .setTeamType(TeamType.NATIONAL)
                .build();

        Player player = PlayerFactory.createFemalePlayer(playerID, playerName, playerGender, playerNationality, playerDateOfBirth, playerLocationOfBirth, playerPosition, playerHeight, playerWeight, club, kitNumber, nationalTeam);
        assertNotNull(player);
        System.out.println("Created Female Player " + player);
    }

    @Test
    void createMalePlayer() {
        String playerID = "0309305390085";
        Name playerName = new Name.Builder()
                .setFirstName("Lisa")
                .setMiddleName("Owen")
                .setLastName("Zumana").build();
        Gender playerGender = Gender.MALE;
        String playerNationality = "South Africa";

        LocalDate playerDateOfBirth = LocalDate.of(2003, 9, 30);
        Location playerLocationOfBirth = new Location();

        PlayerPosition playerPosition = PlayerPosition.LW;

        double playerHeight = 1.85;
        double playerWeight = 72.25;

        Team club = new Team.Builder()
                .setTeamID("MUN")
                .setTeamName("Man United")
                .setTeamFormationYear("1878")
                .setTeamType(TeamType.CLUB)
                .build();

        int kitNumber = 7;

        Team nationalTeam = new Team.Builder()
                .setTeamID("ZAR")
                .setTeamName("South Africa")
                .setTeamFormationYear("1994")
                .setTeamType(TeamType.NATIONAL)
                .build();

        Player player = PlayerFactory.createMalePlayer(playerID, playerName, playerGender, playerNationality, playerDateOfBirth, playerLocationOfBirth, playerPosition, playerHeight, playerWeight, club, kitNumber, nationalTeam);
        assertNotNull(player);
        System.out.println("Created Male Player " + player);
    }

}