package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.team.Gender;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class AssistantVAR extends Official implements Serializable {
    private String supportRole;

    public AssistantVAR() {}

    private AssistantVAR(Builder builder) {
        this.officialId = builder.officialId;
        this.supportRole = builder.supportRole;
    }

    public String getSupportRole() {
        return supportRole;
    }

    @Override
    public String toString() {
        return "AssistantVAR{" +
                "supportRole='" + supportRole + '\'' +
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
        private Gender officialGender;
        private String officialNationality;
        private LocalDate officialDateOfBirth;
        private Location officialLocationOfBirth;
        private String officialOrganisation;
        private Match match;
        private String supportRole;

        public Builder setOfficialId(String officialId){
            this.officialId = officialId;
            return this;
        }

        public Builder setOfficialName(Name officialName){
            this.officialName = officialName;
            return this;
        }

        public Builder setOfficialGender(Gender officialGender){
            this.officialGender = officialGender;
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

        public Builder setSupportRole(String supportRole){
            this.supportRole = supportRole;
            return this;
        }

        public Builder copy(AssistantVAR assistantVAR){
            this.officialId = assistantVAR.officialId;
            this.officialName = assistantVAR.officialName;
            this.officialGender = assistantVAR.officialGender;
            this.officialNationality = assistantVAR.officialNationality;
            this.officialDateOfBirth = assistantVAR.officialDateOfBirth;
            this.officialLocationOfBirth = assistantVAR.officialLocationOfBirth;
            this.officialOrganisation = assistantVAR.officialOrganisation;
            this.match = assistantVAR.match;
            this.supportRole = assistantVAR.supportRole;
            return this;
        }

        public AssistantVAR build(){
            return new AssistantVAR(this);
        }

    }

}
