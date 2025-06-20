package za.co.footballassoc.soccertournament.domain.tournament;

import jakarta.persistence.Entity;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Knockout extends Tournament implements Serializable {
    private int numberOfRounds;
    private boolean hasPlayOffs;

    public Knockout(){
        super();
    }

    private Knockout(Builder builder) {
        super();
        this.tournamentID = builder.tournamentID;
        this.numberOfRounds = builder.numberOfRounds;
        this.hasPlayOffs = builder.hasPlayOffs;
    }


    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public boolean isHasPlayOffs() {
        return hasPlayOffs;
    }

    @Override
    public String toString() {
        return "Knockout{" +
                "numberOfRounds=" + numberOfRounds +
                ", hasPlayOffs=" + hasPlayOffs +
                ", tournamentName='" + tournamentName + '\'' +
                ", tournamentLocation='" + tournamentLocation + '\'' +
                ", tournamentSeason='" + tournamentSeason + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", teams=" + teams +
                '}';
    }

    public static class Builder{
        private String tournamentID;
        private String tournamentName;
        private String tournamentLocation;
        private String tournamentSeason;
        private String tournamentGenderGroup;
        private String tournamentType;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private List<Team> teams;
        private int numberOfRounds;
        private boolean hasPlayOffs;

        public Builder setNumberOfRounds(int numberOfRounds) {
            this.numberOfRounds = numberOfRounds;
            return this;
        }

        public Builder setHasPlayOffs(boolean hasPlayOffs) {
            this.hasPlayOffs = hasPlayOffs;
            return this;
        }

        protected Builder self(){
            return this;
        }

        public Knockout build() {
            return new Knockout(this);
        }

    }
}
