package za.co.footballassoc.soccertournament.factory.team;

import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.team.Gender;
import za.co.footballassoc.soccertournament.domain.team.Manager;

import java.time.LocalDate;

public class ManagerFactory {
    public static Manager createManager(String managerId, Name managerName,
                                        Gender managerGender, LocalDate managerBirthDate,
                                        Location managerLocationOfBirth) {
        return new Manager.Builder()
                .setManagerId(managerId)
                .setManagerName(managerName)
                .setGender(managerGender)
                .setManagerBirthDate(managerBirthDate)
                .setManagerLocationOfBirth(managerLocationOfBirth)
                .build();
    }
}
