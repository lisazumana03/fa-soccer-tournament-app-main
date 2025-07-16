package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Entity
public class Association implements Serializable {
    @Id
    private String associationCode;
    private String associationName;
    @Embedded
    private Name associationCEO;
    @Embedded
    private Location associationHeadquarters;
    @OneToMany(mappedBy = "association")
    private List<Tournament> tournaments;

    @Lob
    private byte[] associationLogo;

    private LocalDate dateFounded;
    private String contactEmail;
    private String phoneNumber;
    private String officialWebsite;
    @Enumerated(EnumType.STRING)
    private Region region;

    public Association() {}

    private Association(Builder builder){
        this.associationCode = builder.associationCode;
        this.associationName = builder.associationName;
        this.associationCEO = builder.associationCEO;
        this.associationHeadquarters = builder.associationHeadquarters;
        this.tournaments = builder.tournaments;
        this.associationLogo = builder.associationLogo;
        this.dateFounded = builder.dateFounded;
        this.contactEmail = builder.contactEmail;
        this.phoneNumber = builder.phoneNumber;
        this.officialWebsite = builder.officialWebsite;
    }

    public String getAssociationCode() {
        return associationCode;
    }

    public String getAssociationName() {
        return associationName;
    }

    public Name getAssociationCEO() {
        return associationCEO;
    }

    public Location getAssociationHeadquarters() {
        return associationHeadquarters;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public byte[] getAssociationLogo() {
        return associationLogo;
    }

    public LocalDate getDateFounded() {
        return dateFounded;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getOfficialWebsite() {
        return officialWebsite;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Region getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "Association{" +
                "associationCode='" + associationCode + '\'' +
                ", associationName='" + associationName + '\'' +
                ", associationCEO=" + associationCEO +
                ", associationHeadquarters=" + associationHeadquarters +
                ", tournaments=" + tournaments +
                ", associationLogo=" + Arrays.toString(associationLogo) +
                ", dateFounded=" + dateFounded +
                ", contactEmail='" + contactEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", officialWebsite='" + officialWebsite + '\'' +
                '}';
    }

    public static class Builder{
        private String associationCode;
        private String associationName;
        private Name associationCEO;
        private Location associationHeadquarters;
        private List<Tournament> tournaments;
        private byte[] associationLogo;
        private LocalDate dateFounded;
        private String contactEmail;
        private String phoneNumber;
        private String officialWebsite;
        private Region region;

        public Builder setAssociationCode(String associationCode){
            this.associationCode = associationCode;
            return this;
        }
        public Builder setAssociationName(String associationName){
            this.associationName = associationName;
            return this;
        }
        public Builder setAssociationCEO(Name associationCEO){
            this.associationCEO = associationCEO;
            return this;
        }
        public Builder setAssociationHeadquarters(Location associationHeadquarters){
            this.associationHeadquarters = associationHeadquarters;
            return this;
        }
        public Builder setTournaments(List<Tournament> tournaments){
            this.tournaments = tournaments;
            return this;
        }

        public Builder setAssociationLogo(byte[] associationLogo){
            this.associationLogo = associationLogo;
            return this;
        }


        public Builder setDateFounded(LocalDate dateFounded) {
            this.dateFounded = dateFounded;
            return this;
        }

        public Builder setContactEmail(String contactEmail){
            this.contactEmail = contactEmail;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setOfficialWebsite(String officialWebsite){
            this.officialWebsite = officialWebsite;
            return this;
        }

        public Builder setRegion(Region region){
            this.region = region;
            return this;
        }

        public Association build(){
            return new Association(this);
        }
    }
}
