package za.co.footballassoc.soccertournament.dto;

import za.co.footballassoc.soccertournament.domain.official.*;

import java.util.List;

public class MatchOfficialsDTO {
    private List<Referee> referees;
    private List<VAR> vars;
    private List<AssistantVAR> assistantVars;
    private List<Linesman> linesmen;
    private List<FourthOfficial> fourthOfficials;

    public MatchOfficialsDTO() {}

    private MatchOfficialsDTO(Builder builder) {
        this.referees = builder.referees;
        this.vars = builder.vars;
        this.assistantVars = builder.assistantVars;
        this.linesmen = builder.linesmen;
        this.fourthOfficials = builder.fourthOfficials;
    }

    public List<Referee> getReferees() {
        return referees;
    }

    public List<VAR> getVars() {
        return vars;
    }

    public List<AssistantVAR> getAssistantVars() {
        return assistantVars;
    }

    public List<Linesman> getLinesmen() {
        return linesmen;
    }

    public List<FourthOfficial> getFourthOfficials() {
        return fourthOfficials;
    }

    public static class Builder{
        private List<Referee> referees;
        private List<VAR> vars;
        private List<AssistantVAR> assistantVars;
        private List<Linesman> linesmen;
        private List<FourthOfficial> fourthOfficials;

        public Builder setReferees(List<Referee> referees) {
            this.referees = referees;
            return this;
        }

        public Builder setVars(List<VAR> vars) {
            this.vars = vars;
            return this;
        }

        public Builder setAssistantVars(List<AssistantVAR> assistantVars) {
            this.assistantVars = assistantVars;
            return this;
        }

        public Builder setLinesmen(List<Linesman> linesmen) {
            this.linesmen = linesmen;
            return this;
        }

        public Builder setFourthOfficials(List<FourthOfficial> fourthOfficials) {
            this.fourthOfficials = fourthOfficials;
            return this;
        }

        public MatchOfficialsDTO build() {
            return new MatchOfficialsDTO(this);
        }
    }
}
