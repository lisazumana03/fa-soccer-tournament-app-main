package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;

import java.io.Serializable;
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

    public Association() {}

    private Association(Builder builder){
        this.associationCode = builder.associationCode;
        this.associationName = builder.associationName;
        this.associationCEO = builder.associationCEO;
        this.associationHeadquarters = builder.associationHeadquarters;
        this.tournaments = builder.tournaments;
        this.associationLogo = null;
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

    @Override
    public String toString() {
        return "Association{" +
                "associationCode='" + associationCode + '\'' +
                ", associationName='" + associationName + '\'' +
                ", associationCEO=" + associationCEO +
                ", associationHeadquarters=" + associationHeadquarters +
                ", tournaments=" + tournaments +
                ", associationLogo=" + Arrays.toString(associationLogo) +
                '}';
    }

    public static class Builder{
        private String associationCode;
        private String associationName;
        private Name associationCEO;
        private Location associationHeadquarters;
        private List<Tournament> tournaments;
        private byte[] associationLogo;

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

        public Association build(){
            return new Association(this);
        }
    }
}
