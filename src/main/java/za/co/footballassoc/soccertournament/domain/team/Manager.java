package za.co.footballassoc.soccertournament.domain.team;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Manager implements Serializable {
    @Id
    private String managerId;
    @Embedded
    private Name managerName;
    private LocalDate managerBirthDate;
    @Embedded
    private Location managerLocationOfBirth;

    public static class Builder {
        private String managerId;
        private Name managerName;
        private LocalDate managerBirthDate;
        private Location managerLocationOfBirth;
    }
}
