package za.co.footballassoc.soccertournament.domain.match;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.Tournament;

import java.time.LocalDateTime;

@Entity
public class Match {
    @Id
    private String matchID;
    private LocalDateTime matchDate;
    @ManyToOne
    private Team homeTeam;
    @ManyToOne
    private Team awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
    @ManyToOne
    private Tournament tournament;
    private String matchStatus; //Ongoing/ Complete/ Not started

    public Match() {
    }

    private Match(Builder builder) {
        this.matchID = builder.matchID;
        this.matchDate = builder.matchDate;
        this.homeTeam = builder.homeTeam;
        this.awayTeam = builder.awayTeam;
        this.homeTeamScore = builder.homeTeamScore;
        this.awayTeamScore = builder.awayTeamScore;
        this.tournament = builder.tournament;
        this.matchStatus = builder.matchStatus;
    }

    public String getMatchID() {
        return matchID;
    }

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public static class Builder {
        private String matchID;
        private LocalDateTime matchDate;
        private Team homeTeam;
        private Team awayTeam;
        private int homeTeamScore;
        private int awayTeamScore;
        private Tournament tournament;
        private String matchStatus;

        public Builder setMatchID(String matchID) {
            this.matchID = matchID;
            return this;
        }

        public Builder setMatchDate(LocalDateTime matchDate) {
            this.matchDate = matchDate;
            return this;
        }
        public Builder setHomeTeam(Team homeTeam) {
            this.homeTeam = homeTeam;
            return this;
        }
        public Builder setAwayTeam(Team awayTeam) {
            this.awayTeam = awayTeam;
            return this;
        }
        public Builder setHomeTeamScore(int homeTeamScore) {
            this.homeTeamScore = homeTeamScore;
            return this;
        }
        public Builder setAwayTeamScore(int awayTeamScore) {
            this.awayTeamScore = awayTeamScore;
            return this;
        }
        public Builder setTournament(Tournament tournament) {
            this.tournament = tournament;
            return this;
        }
        public Builder setMatchStatus(String matchStatus) {
            this.matchStatus = matchStatus;
            return this;
        }
    }
}
