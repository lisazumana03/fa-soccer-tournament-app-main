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
    @Enumerated(EnumType.STRING)
    private Gender playerGender;
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
    private int kitNumber;
    @ManyToOne
    @JoinColumn(name = "national_team_id")
    private Team nationalTeam;

    public Player() {}

    private Player(Builder builder){
        this.playerID = builder.playerID;
        this.playerName = builder.playerName;
        this.playerGender = builder.playerGender;
        this.playerNationality = builder.playerNationality;
        this.playerDateOfBirth = builder.playerDateOfBirth;
        this.playerLocationOfBirth = builder.playerLocationOfBirth;
        this.playerPosition = builder.playerPosition;
        this.playerHeight = builder.playerHeight;
        this.playerWeight = builder.playerWeight;
        this.club = builder.club;
        this.kitNumber = builder.kitNumber;
        this.nationalTeam = builder.nationalTeam;
    }

    public String getPlayerID() {
        return playerID;
    }

    public Name getPlayerName() {
        return playerName;
    }

    public Gender getPlayerGender() {
        return playerGender;
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

    public int getKitNumber() {
        return kitNumber;
    }

    public Team getNationalTeam() {
        return nationalTeam;
    }

    public static class Builder{
        private String playerID;
        private Name playerName;
        private Gender playerGender;
        private String playerNationality;
        private LocalDate playerDateOfBirth;
        private Location playerLocationOfBirth;
        private PlayerPosition playerPosition;
        private double playerHeight;
        private double playerWeight;
        private Team club;
        private int kitNumber;
        private Team nationalTeam;

        public Builder setPlayerID(String playerID){
            this.playerID = playerID;
            return this;
        }

        public Builder setPlayerName(Name playerName){
            this.playerName = playerName;
            return this;
        }

        public Builder setPlayerGender(Gender playerGender){
            this.playerGender = playerGender;
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

        public Builder setPlayerWeight(double playerWeight){
            this.playerWeight = playerWeight;
            return this;
        }
        public Builder setClub(Team club){
            this.club = club;
            return this;
        }

        public Builder setKitNumber(int kitNumber){
            this.kitNumber = kitNumber;
            return this;
        }

        public Builder setNationalTeam(Team nationalTeam){
            this.nationalTeam = nationalTeam;
            return this;
        }

        public Builder copy(Player player){
            this.playerID = player.playerID;
            this.playerName = player.playerName;
            this.playerGender = player.playerGender;
            this.playerNationality = player.playerNationality;
            this.playerDateOfBirth = player.playerDateOfBirth;
            this.playerLocationOfBirth = player.playerLocationOfBirth;
            this.playerPosition = player.playerPosition;
            this.playerHeight = player.playerHeight;
            this.playerWeight = player.playerWeight;
            this.club = player.club;
            this.kitNumber = player.kitNumber;
            this.nationalTeam = player.nationalTeam;
            return this;
        }

        public Player build(){
            return new Player(this);
        }

    }
}
