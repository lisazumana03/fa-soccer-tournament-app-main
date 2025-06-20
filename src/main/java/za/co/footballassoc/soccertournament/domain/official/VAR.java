package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class VAR extends Official implements Serializable {
    private int techExperience;

    public VAR() {}

    private VAR(Builder builder) {
        this.officialId = builder.officialId;
        this.officialName = builder.officialName;
        this.officialNationality = builder.officialNationality;
        this.officialDateOfBirth = builder.officialDateOfBirth;
        this.officialLocationOfBirth = builder.officialLocationOfBirth;
        this.officialOrganisation = builder.officialOrganisation;
        this.match = builder.match;
        this.techExperience = builder.techExperience;
    }

    public int getTechExperience() {
        return techExperience;
    }

    @Override
    public String toString() {
        return "VAR{" +
                "techExperience=" + techExperience +
                ", officialName=" + officialName +
                ", officialNationality='" + officialNationality + '\'' +
                ", officialDateOfBirth=" + officialDateOfBirth +
                ", officialLocationOfBirth=" + officialLocationOfBirth +
                ", officialOrganisation='" + officialOrganisation + '\'' +
                ", match=" + match +
                '}';
    }

    public static class Builder{
        private String officialId;
        private Name officialName;
        private String officialNationality;
        private LocalDate officialDateOfBirth;
        private Location officialLocationOfBirth;
        private String officialOrganisation;
        private Match match;
        private int techExperience;

        public Builder setOfficialId(String officialId){
            this.officialId = officialId;
            return this;
        }

        public Builder setOfficialName(Name officialName){
            this.officialName = officialName;
            return this;
        }

        public Builder setOfficialNationality(String officialNationality){
            this.officialNationality = officialNationality;
            return this;
        }

        public Builder setOfficialDateOfBirth(LocalDate officialDateOfBirth){
            this.officialDateOfBirth = officialDateOfBirth;
            return this;
        }

        public Builder setOfficialLocationOfBirth(Location officialLocationOfBirth){
            this.officialLocationOfBirth = officialLocationOfBirth;
            return this;
        }

        public Builder setOfficialOrganisation(String officialOrganisation){
            this.officialOrganisation = officialOrganisation;
            return this;
        }

        public Builder setMatch(Match match){
            this.match = match;
            return this;
        }

        public Builder setTechExperience(int techExperience){
            this.techExperience = techExperience;
            return this;
        }


        protected Builder self(){
            return this;
        }

        public VAR build(){
            return new VAR(this);
        }
    }

}
