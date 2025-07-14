package za.co.footballassoc.soccertournament.domain.team;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Owner implements Serializable {
    @Id
    private String ownerId;
    @Embedded
    private Name ownerName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany
    private List<Team> teams;
    private LocalDate dateOfBirth;
    @Embedded
    private Location birthLocation;

    protected Owner() {}

    private Owner(Builder builder) {
        this.ownerId = builder.ownerId;
        this.ownerName = builder.ownerName;
        this.gender = builder.gender;
        this.teams = builder.teams;
        this.dateOfBirth = builder.dateOfBirth;
        this.birthLocation = builder.birthLocation;
    }

    public static class Builder {
        private String ownerId;
        private Name ownerName;
        private Gender gender;
        private List<Team> teams;
        private LocalDate dateOfBirth;
        private Location birthLocation;
    }
}
