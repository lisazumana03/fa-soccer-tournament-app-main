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
}
