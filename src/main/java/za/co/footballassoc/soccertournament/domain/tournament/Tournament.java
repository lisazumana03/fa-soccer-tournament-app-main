package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.team.Gender;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Tournament implements Serializable {
    @Id
    protected String tournamentID; //1000PL, 2000LL, 3000BL
    protected String tournamentName;
    protected String tournamentLocation; //city/town, country, continent
    protected String tournamentSeason; ///24/25
    protected String ageGroup;
    @Enumerated(EnumType.STRING)
    protected TournamentType tournamentType;
    @Enumerated(EnumType.STRING)
    protected Gender tournamentGenderGroup;

    //Tournament Begin and End
    protected LocalDateTime startDate;
    protected LocalDateTime endDate;
    @OneToMany(mappedBy = "tournament")
    protected List<Team> teams;

    protected int homeAndAwayGames; //how many times the team will meet in the league/ knockout

    protected byte[] tournamentLogo;

    @ManyToOne
    protected Association association;

    public Tournament() {}// for JPA
    public Tournament(String tournamentID, String tournamentName, String tournamentLocation,
                      String tournamentSeason, String ageGroup, TournamentType tournamentType,
                      Gender tournamentGenderGroup, LocalDateTime startDate, LocalDateTime endDate,
                      List<Team> teams, int homeAndAwayGames, byte[] tournamentLogo, Association association) {
        this.tournamentID = tournamentID;
        this.tournamentName = tournamentName;
        this.tournamentLocation = tournamentLocation;
        this.tournamentSeason = tournamentSeason;
        this.ageGroup = ageGroup;
        this.tournamentType = tournamentType;
        this.tournamentGenderGroup = tournamentGenderGroup;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teams = teams;
        this.homeAndAwayGames = homeAndAwayGames;
        this.tournamentLogo = tournamentLogo;
        this.association = association;
    }

    public String getTournamentID() {
        return tournamentID;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public String getTournamentLocation() {
        return tournamentLocation;
    }

    public String getTournamentSeason() {
        return tournamentSeason;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public TournamentType getTournamentType() {
        return tournamentType;
    }

    public Gender getTournamentGenderGroup() {
        return tournamentGenderGroup;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public int getHomeAndAwayGames() {
        return homeAndAwayGames;
    }

    public byte[] getTournamentLogo() {
        return tournamentLogo;
    }

    public Association getAssociation() {
        return association;
    }

    public void setTournamentID(String tournamentID) {
        this.tournamentID = tournamentID;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public void setTournamentLocation(String tournamentLocation) {
        this.tournamentLocation = tournamentLocation;
    }

    public void setTournamentSeason(String tournamentSeason) {
        this.tournamentSeason = tournamentSeason;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public void setTournamentType(TournamentType tournamentType) {
        this.tournamentType = tournamentType;
    }

    public void setTournamentGenderGroup(Gender tournamentGenderGroup) {
        this.tournamentGenderGroup = tournamentGenderGroup;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void setHomeAndAwayGames(int homeAndAwayGames) {
        this.homeAndAwayGames = homeAndAwayGames;
    }

    public void setTournamentLogo(byte[] tournamentLogo) {
        this.tournamentLogo = tournamentLogo;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    @Override
    public abstract String toString();

}
