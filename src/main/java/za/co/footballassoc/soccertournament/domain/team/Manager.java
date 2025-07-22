package za.co.footballassoc.soccertournament.domain.team;

import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private Gender managerGender;
    private LocalDate managerBirthDate;
    @Embedded
    private Location managerLocationOfBirth;

    public Manager(){}

    private Manager(Builder builder) {
        this.managerId = builder.managerId;
        this.managerName = builder.managerName;
        this.managerGender = builder.managerGender;
        this.managerBirthDate = builder.managerBirthDate;
        this.managerLocationOfBirth = builder.managerLocationOfBirth;
    }

    public String getManagerId() {
        return managerId;
    }

    public Name getManagerName() {
        return managerName;
    }

    public Gender getManagerGender() {
        return managerGender;
    }

    public LocalDate getManagerBirthDate() {
        return managerBirthDate;
    }

    public Location getManagerLocationOfBirth() {
        return managerLocationOfBirth;
    }

    public static class Builder {
        private String managerId;
        private Name managerName;
        private Gender managerGender;
        private LocalDate managerBirthDate;
        private Location managerLocationOfBirth;

        public Builder setManagerId(String managerId) {
            this.managerId = managerId;
            return this;
        }

        public Builder setManagerName(Name managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder setGender(Gender managerGender) {
            this.managerGender = managerGender;
            return this;
        }

        public Builder setManagerBirthDate(LocalDate managerBirthDate) {
            this.managerBirthDate = managerBirthDate;
            return this;
        }

        public Builder setManagerLocationOfBirth(Location managerLocationOfBirth) {
            this.managerLocationOfBirth = managerLocationOfBirth;
            return this;
        }

        public Manager build() {
            return new Manager(this);
        }

    }
}
