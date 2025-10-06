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
    private Double netWorth; // Net worth in billions USD

    protected Owner() {}

    private Owner(Builder builder) {
        this.ownerId = builder.ownerId;
        this.ownerName = builder.ownerName;
        this.gender = builder.gender;
        this.teams = builder.teams;
        this.dateOfBirth = builder.dateOfBirth;
        this.birthLocation = builder.birthLocation;
        this.netWorth = builder.netWorth;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public Name getOwnerName() {
        return ownerName;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Location getBirthLocation() {
        return birthLocation;
    }

    public Double getNetWorth() {
        return netWorth;
    }

    public static class Builder {
        private String ownerId;
        private Name ownerName;
        private Gender gender;
        private List<Team> teams;
        private LocalDate dateOfBirth;
        private Location birthLocation;
        private Double netWorth;

        public Builder setOwnerId(String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Builder setOwnerName(Name ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder setTeams(List<Team> teams) {
            this.teams = teams;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setBirthLocation(Location birthLocation) {
            this.birthLocation = birthLocation;
            return this;
        }

        public Builder setNetWorth(Double netWorth) {
            this.netWorth = netWorth;
            return this;
        }

        public Builder copy(Owner owner) {
            this.ownerId = owner.ownerId;
            this.ownerName = owner.ownerName;
            this.gender = owner.gender;
            this.teams = owner.teams;
            this.dateOfBirth = owner.dateOfBirth;
            this.birthLocation = owner.birthLocation;
            this.netWorth = owner.netWorth;
            return this;
        }

        public Owner build() {
            return new Owner(this);
        }
    }
}
