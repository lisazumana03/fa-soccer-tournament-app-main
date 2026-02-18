package za.co.footballassoc.soccertournament.domain.match;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venue implements Serializable {
    @Id
    private String venueID;
    private String name;
    private Location stadiumAddress;
    @Enumerated(EnumType.STRING)
    private VenueType venueType;
    @OneToMany(mappedBy = "teamHomeGround")
    private List<Team> teams = new ArrayList<>();

    public Venue() {}

    private Venue(Builder builder) {
        this.venueID = builder.venueID;
        this.name = builder.name;
        this.stadiumAddress = builder.stadiumAddress;
        this.venueType = builder.venueType;
        this.teams = builder.teams;
    }

    public String getVenueID() {
        return venueID;
    }

    public String getName() {
        return name;
    }

    public Location getStadiumAddress() {
        return stadiumAddress;
    }

    public VenueType getVenueType() {
        return venueType;
    }

    public List<Team> getTeams() {
        return teams;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueID='" + venueID + '\'' +
                ", name='" + name + '\'' +
                ", stadiumAddress=" + stadiumAddress +
                ", venueType=" + venueType +
                ", teams=" + teams +
                '}';
    }

    public static class Builder{
        private String venueID;
        private String name;
        private Location stadiumAddress;
        private VenueType venueType;
        private List<Team> teams = new ArrayList<>();

        public Builder setVenueID(String venueID) {
            this.venueID = venueID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStadiumAddress(Location stadiumAddress) {
            this.stadiumAddress = stadiumAddress;
            return this;
        }

        public Builder setVenueType(VenueType venueType) {
            this.venueType = venueType;
            return this;
        }

        public Builder setTeams(List<Team> teams) {
            this.teams = teams;
            return this;
        }

        public Builder copy(Venue venue) {
            this.venueID = venue.venueID;
            this.name = venue.name;
            this.stadiumAddress = venue.stadiumAddress;
            this.venueType = venue.venueType;
            this.teams = venue.teams;
            return this;
        }

        public Venue build() {
            return new Venue(this);
        }

    }

}
