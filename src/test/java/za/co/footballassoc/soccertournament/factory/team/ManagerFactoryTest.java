package za.co.footballassoc.soccertournament.factory.team;

import org.junit.jupiter.api.Test;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.team.Gender;
import za.co.footballassoc.soccertournament.domain.team.Manager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ManagerFactoryTest {

    @Test
    void createManager() {
        String managerId = "940314 0969 388";
        Name managerName = new Name.Builder()
                .setFirstName("Levi")
                .setMiddleName("Lewis")
                .setLastName("Fletcher")
                .build();
        Gender managerGender = Gender.MALE;
        LocalDate managerBirthDate = LocalDate.of(1994, 3, 14);
        Location managerLocationOfBirth = new Location();
        Manager manager = ManagerFactory.createManager(managerId, managerName, managerGender, managerBirthDate, managerLocationOfBirth);
    }
}