package za.co.footballassoc.soccertournament.domain.match;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.official.Official;
import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.Tournament;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Match implements Serializable {
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
    @Enumerated(EnumType.STRING)
    private MatchStatus matchStatus;
    private int duration = 90; ///90 min full match (45min + 45min)
    @OneToMany(mappedBy = "match")
    private List<MatchEvent> matchEvents = new ArrayList<>();
    @OneToMany(mappedBy = "match")
    private List<Official> officials = new ArrayList<>();

    @ManyToOne
    private Venue venue;

    @OneToOne
    private Team penaltyWinner;

    private LocalDateTime kickoffTime;
    private LocalDateTime fullTime;

    private boolean isExtraTime;
    private boolean isPenaltyShootout;

    @OneToOne
    private Player manOfTheMatch;


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
        this.duration = builder.duration;
        this.matchEvents = builder.matchEvents;
        this.officials = builder.officials;
        this.venue = builder.venue;
        this.kickoffTime = builder.kickoffTime;
        this.fullTime = builder.fullTime;
        this.isExtraTime = builder.isExtraTime;
        this.isPenaltyShootout = builder.isPenaltyShootout;
        this.manOfTheMatch = builder.manOfTheMatch;
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

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public int getDuration() {
        return duration;
    }

    public List<MatchEvent> getMatchEvents() {
        return matchEvents;
    }

    public List<Official> getOfficials() {
        return officials;
    }

    public Venue getVenue() {
        return venue;
    }

    public Team getPenaltyWinner() {
        return penaltyWinner;
    }

    public LocalDateTime getKickoffTime() {
        return kickoffTime;
    }

    public LocalDateTime getFullTime() {
        return fullTime;
    }

    public boolean isExtraTime() {
        return isExtraTime;
    }

    public boolean isPenaltyShootout() {
        return isPenaltyShootout;
    }

    public Player getManOfTheMatch() {
        return manOfTheMatch;
    }

    public static class Builder {
        private String matchID;
        private LocalDateTime matchDate;
        private Team homeTeam;
        private Team awayTeam;
        private int homeTeamScore;
        private int awayTeamScore;
        private Tournament tournament;
        private MatchStatus matchStatus;
        private int duration;
        private List<MatchEvent> matchEvents;
        private List<Official> officials;
        private Venue venue;
        private LocalDateTime kickoffTime;
        private LocalDateTime fullTime;
        private boolean isExtraTime;
        private boolean isPenaltyShootout;
        private Player manOfTheMatch;


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
        public Builder setMatchStatus(MatchStatus matchStatus) {
            this.matchStatus = matchStatus;
            return this;
        }
        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }
        public Builder setMatchEvents(List<MatchEvent> matchEvents) {
            this.matchEvents = matchEvents;
            return this;
        }

        public Builder setOfficials(List<Official> officials) {
            this.officials = officials;
            return this;
        }

        public Builder setVenue(Venue venue) {
            this.venue = venue;
            return this;
        }

        public Builder setKickOffTime(LocalDateTime kickoffTime) {
            this.kickoffTime = kickoffTime;
            return this;
        }

        public Builder setFullTime(LocalDateTime fullTime) {
            this.fullTime = fullTime;
            return this;
        }

        public Builder setExtraTime(boolean extraTime) {
            isExtraTime = extraTime;
            return this;
        }
        public Builder setPenaltyShootout(boolean penaltyShootout) {
            isPenaltyShootout = penaltyShootout;
            return this;
        }

        public Builder setManOfTheMatch(Player manOfTheMatch) {
            this.manOfTheMatch = manOfTheMatch;
            return this;
        }

        public Builder copy(Match match){
            this.matchID = match.matchID;
            this.matchDate = match.matchDate;
            this.homeTeam = match.homeTeam;
            this.awayTeam = match.awayTeam;
            this.homeTeamScore = match.homeTeamScore;
            this.awayTeamScore = match.awayTeamScore;
            this.tournament = match.tournament;
            this.matchStatus = match.matchStatus;
            this.duration = match.duration;
            this.matchEvents = match.matchEvents;
            this.officials = match.officials;
            this.venue = match.venue;
            this.kickoffTime = match.kickoffTime;
            this.fullTime = match.fullTime;
            this.isExtraTime = match.isExtraTime;
            this.isPenaltyShootout = match.isPenaltyShootout;
            return this;
        }

        public Match build() {
            return new Match(this);
        }
    }
}
