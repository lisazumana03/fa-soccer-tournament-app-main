package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Linesman extends Official implements Serializable {
    private String side;

    public Linesman() {}

    private Linesman(Builder builder) {
        this.side = builder.side;
    }

    public String getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "Linesman{" +
                "side='" + side + '\'' +
                ", officialName=" + officialName +
                ", officialNationality='" + officialNationality + '\'' +
                ", officialDateOfBirth=" + officialDateOfBirth +
                ", officialLocationOfBirth=" + officialLocationOfBirth +
                ", match=" + match +
                ", officialOrganisation='" + officialOrganisation + '\'' +
                '}';
    }

    public static class Builder{
        private int officialId;
        private Name officialName;
        private String officialNationality;
        private LocalDate officialDateOfBirth;
        private Location officialLocationOfBirth;
        private String officialOrganisation;
        private Match match;
        private String side;

        public Builder setSide(String side){
            this.side = side;
            return this;
        }

    }
}
