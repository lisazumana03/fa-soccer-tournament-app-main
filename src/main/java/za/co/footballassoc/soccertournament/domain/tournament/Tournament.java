package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.Location;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Tournament implements Serializable {
    @Id
    private Long tournamentID; //1000PL, 2000LL, 3000BL
    private String tournamentName;
    @Embedded
    private String tournamentLocation; //city/town, country, continent
    @OneToMany(mappedBy = "tournament")
    private List<Team> teams;
    private String tournamentSeason; ///24/25

    //Tournament Begin and End
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private int homeAndAwayGames; //how many times the team will meet in the league/ knockout

    private byte[] tournamentLogo;

    public Tournament() {}// for JPA

    protected Tournament(Builder<?> builder) {
        this.tournamentID = builder.tournamentID;
        this.tournamentName = builder.tournamentName;
        this.tournamentLocation = builder.tournamentLocation;
        this.tournamentSeason = builder.tournamentSeason;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.teams = builder.teams;
        this.tournamentLogo = builder.tournamentLogo;
    }

    public static class Builder<T extends Builder<T>> {
        private Long tournamentID;
        private String tournamentName;
        private String tournamentLocation; //tournament country
        private String tournamentSeason;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private List<Team> teams;
        private byte[] tournamentLogo; ////2000x1450 eg.

    }
}
