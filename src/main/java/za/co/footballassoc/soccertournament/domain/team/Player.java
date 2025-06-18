package za.co.footballassoc.soccertournament.domain.team;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.Name;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Player implements Serializable {
    @Id
    private String playerID;
    @Embedded
    private Name playerName;
    private String playerNationality; //South Africa, England
    private LocalDate playerDateOfBirth;
    @Embedded
    private Location playerLocationOfBirth;

    @Enumerated(EnumType.STRING)
    private PlayerPosition playerPosition;

    private double playerHeight; //in m or ft
    private double playerWeight; //in kg or ib
    @ManyToOne
    private Team club;
    @ManyToOne
    @JoinColumn(name = "national_team_id")
    private Team nationalTeam;

    public Player() {}

    private Player(Builder builder){
        this.playerID = builder.playerID;
        this.playerName = builder.playerName;
        this.playerNationality = builder.playerNationality;
        this.playerDateOfBirth = builder.playerDateOfBirth;
        this.playerLocationOfBirth = builder.playerLocationOfBirth;
        this.playerPosition = builder.playerPosition;
        this.playerHeight = builder.playerHeight;
        this.playerWeight = builder.playerWeight;
        this.club = builder.club;
        this.nationalTeam = builder.nationalTeam;
    }

    public Name getPlayerName() {
        return playerName;
    }

    public String getPlayerNationality() {
        return playerNationality;
    }

    public LocalDate getPlayerDateOfBirth() {
        return playerDateOfBirth;
    }

    public Location getPlayerLocationOfBirth() {
        return playerLocationOfBirth;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public double getPlayerHeight() {
        return playerHeight;
    }

    public double getPlayerWeight() {
        return playerWeight;
    }

    public Team getClub() {
        return club;
    }

    public Team getNationalTeam() {
        return nationalTeam;
    }

    public static class Builder{
        private String playerID;
        private Name playerName;
        private String playerNationality;
        private LocalDate playerDateOfBirth;
        private Location playerLocationOfBirth;
        private PlayerPosition playerPosition;
        private double playerHeight;
        private double playerWeight;
        private Team club;
        private Team nationalTeam;

        public Builder setPlayerName(Name playerName){
            this.playerName = playerName;
            return this;
        }
        public Builder setPlayerNationality(String playerNationality){
            this.playerNationality = playerNationality;
            return this;
        }
        public Builder setPlayerDateOfBirth(LocalDate playerDateOfBirth){
            this.playerDateOfBirth = playerDateOfBirth;
            return this;
        }
        public Builder setPlayerLocationOfBirth(Location playerLocationOfBirth){
            this.playerLocationOfBirth = playerLocationOfBirth;
            return this;
        }
        public Builder setPlayerPosition(PlayerPosition playerPosition){
            this.playerPosition = playerPosition;
            return this;
        }
        public Builder setPlayerHeight(double playerHeight){
            this.playerHeight = playerHeight;
            return this;
        }

    }
}
