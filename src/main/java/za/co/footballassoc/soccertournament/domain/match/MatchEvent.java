package za.co.footballassoc.soccertournament.domain.match;

import jakarta.persistence.*;
import za.co.footballassoc.soccertournament.domain.team.Player;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.io.Serializable;

@Entity
public class MatchEvent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String eventID;
    @ManyToOne
    private Match match;
    private int minute; // Minute of the match (e.g., 0, 45+, 45, 90 (Regular time), 90, 105+, 105, 120+)

    @Enumerated(EnumType.STRING)
    private EventType eventType;
    @ManyToOne
    private Player playerInvolved;

    @ManyToOne
    private Team team; // Team responsible for the event

    private String eventDescription; // Optional: “Goal from outside the box”

    private boolean isVARReviewed;
    private boolean isCancelledByVAR;

    private String additionalInfo; // Assist, second yellow, etc.
    @OneToOne
    private Venue venueSelection;
    private String assistantRefereeDecision;
    private boolean isInjuryRelated;

    public MatchEvent() {}

    private MatchEvent(Builder builder) {
        this.eventID = builder.eventID;
        this.match = builder.match;
        this.minute = builder.minute;
        this.eventType = builder.eventType;
        this.playerInvolved = builder.playerInvolved;
        this.team = builder.team;
        this.eventDescription = builder.eventDescription;
        this.isVARReviewed = builder.isVARReviewed;
        this.isCancelledByVAR = builder.isCancelledByVAR;
        this.additionalInfo = builder.additionalInfo;
        this.venueSelection = builder.venueSelection;
        this.assistantRefereeDecision = builder.assistantRefereeDecision;
        this.isInjuryRelated = builder.isInjuryRelated;
    }

    public String getEventID() {
        return eventID;
    }

    public Match getMatch() {
        return match;
    }

    public int getMinute() {
        return minute;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Player getPlayerInvolved() {
        return playerInvolved;
    }

    public Team getTeam() {
        return team;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public boolean isVARReviewed() {
        return isVARReviewed;
    }

    public boolean isCancelledByVAR() {
        return isCancelledByVAR;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public Venue getVenueSelection() {
        return venueSelection;
    }

    public String getAssistantRefereeDecision() {
        return assistantRefereeDecision;
    }

    public boolean isInjuryRelated() {
        return isInjuryRelated;
    }

    @Override
    public String toString() {
        return "MatchEvent{" +
                "eventID='" + eventID + '\'' +
                ", match=" + match +
                ", minute=" + minute +
                ", eventType=" + eventType +
                ", playerInvolved=" + playerInvolved +
                ", team=" + team +
                ", eventDescription='" + eventDescription + '\'' +
                ", isVARReviewed=" + isVARReviewed +
                ", isCancelledByVAR=" + isCancelledByVAR +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", venueSelection=" + venueSelection +
                ", assistantRefereeDecision='" + assistantRefereeDecision + '\'' +
                ", isInjuryRelated=" + isInjuryRelated +
                '}';
    }

    public static class Builder{
        private String eventID;
        private Match match;
        private int minute;
        private EventType eventType;
        private Player playerInvolved;
        private Team team;
        private String eventDescription;
        private boolean isVARReviewed;
        private boolean isCancelledByVAR;
        private String additionalInfo;
        private Venue venueSelection;
        private String assistantRefereeDecision;
        private boolean isInjuryRelated;

        public Builder setEventID(String eventID) {
            this.eventID = eventID;
            return this;
        }

        public Builder setMatch(Match match) {
            this.match = match;
            return this;
        }

        public Builder setMinute(int minute) {
            this.minute = minute;
            return this;
        }

        public Builder setEventType(EventType eventType) {
            this.eventType = eventType;
            return this;
        }

        public Builder setPlayerInvolved(Player playerInvolved) {
            this.playerInvolved = playerInvolved;
            return this;
        }

        public Builder setTeam(Team team) {
            this.team = team;
            return this;
        }

        public Builder setEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
            return this;
        }

        public Builder setIsVARReviewed(boolean isVARReviewed) {
            this.isVARReviewed = isVARReviewed;
            return this;
        }

        public Builder setIsCancelledByVAR(boolean isCancelledByVAR) {
            this.isCancelledByVAR = isCancelledByVAR;
            return this;
        }

        public Builder setAdditionalInfo(String additionalInfo) {
            this.additionalInfo = additionalInfo;
            return this;
        }

        public Builder setVenueSelection(Venue venueSelection) {
            this.venueSelection = venueSelection;
            return this;
        }

        public Builder setAssistantRefereeDecision(String assistantRefereeDecision) {
            this.assistantRefereeDecision = assistantRefereeDecision;
            return this;
        }

        public Builder setInjuryRelated(boolean isInjuryRelated) {
            this.isInjuryRelated = isInjuryRelated;
            return this;
        }

        public Builder copy(MatchEvent event){
            this.eventID = event.eventID;
            this.match = event.match;
            this.minute = event.minute;
            this.eventType = event.eventType;
            this.playerInvolved = event.playerInvolved;
            this.team = event.team;
            this.eventDescription = event.eventDescription;
            this.isVARReviewed = event.isVARReviewed;
            this.isCancelledByVAR = event.isCancelledByVAR;
            this.additionalInfo = event.additionalInfo;
            this.venueSelection = event.venueSelection;
            this.assistantRefereeDecision = event.assistantRefereeDecision;
            this.isInjuryRelated = event.isInjuryRelated;
            return this;
        }

        public MatchEvent build() {
            return new MatchEvent(this);
        }

    }

}
