package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Referee extends Official implements Serializable {
    private String certificationLevel;

    public Referee() {
        super();
    }

    private Referee(Builder builder) {
        this.officialId = builder.officialId;
        this.certificationLevel = builder.certificationLevel;
    }

    @Override
    public String toString() {
        return "Referee{" +
                "certificationLevel='" + certificationLevel + '\'' +
                ", officialName=" + officialName +
                ", officialNationality='" + officialNationality + '\'' +
                ", officialDateOfBirth=" + officialDateOfBirth +
                ", officialLocationOfBirth=" + officialLocationOfBirth +
                ", officialOrganisation='" + officialOrganisation + '\'' +
                ", match=" + match +
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
        private String certificationLevel;

        public Builder setCertificationLevel(String certificationLevel) {
            this.certificationLevel = certificationLevel;
            return this;
        }

        protected Builder self(){
            return this;
        }
        public Referee build(){
            return new Referee(this);
        }

    }

}
