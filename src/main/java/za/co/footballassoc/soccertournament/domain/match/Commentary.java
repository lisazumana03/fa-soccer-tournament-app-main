package za.co.footballassoc.soccertournament.domain.match;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import za.co.footballassoc.soccertournament.domain.Name;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Commentary implements Serializable {
    @Id
    private String commentaryID;
    @Embedded
    private Name commentatorName;
    private String commentatorNationality;
    private LocalDate commentatorDateOfBirth;
    private String commentaryLanguage;

    public Commentary() {}

    private Commentary(Builder builder) {
        this.commentaryID = builder.commentaryID;
        this.commentatorName = builder.commentatorName;
        this.commentatorNationality = builder.commentatorNationality;
        this.commentatorDateOfBirth = builder.commentatorDateOfBirth;
        this.commentaryLanguage = builder.commentaryLanguage;
    }

    public String getCommentaryID() {
        return commentaryID;
    }

    public Name getCommentatorName() {
        return commentatorName;
    }

    public String getCommentatorNationality() {
        return commentatorNationality;
    }

    public LocalDate getCommentatorDateOfBirth() {
        return commentatorDateOfBirth;
    }

    public String getCommentaryLanguage() {
        return commentaryLanguage;
    }

    public static class Builder{
        private String commentaryID;
        private Name commentatorName;
        private String commentatorNationality;
        private LocalDate commentatorDateOfBirth;
        private String commentaryLanguage;

        public Builder setCommentaryID(String commentaryID) {
            this.commentaryID = commentaryID;
            return this;
        }

        public Builder setCommentatorName(Name commentatorName) {
            this.commentatorName = commentatorName;
            return this;
        }

        public Builder setCommentatorNationality(String commentatorNationality) {
            this.commentatorNationality = commentatorNationality;
            return this;
        }

        public Builder setCommentatorDateOfBirth(LocalDate commentatorDateOfBirth) {
            this.commentatorDateOfBirth = commentatorDateOfBirth;
            return this;
        }

        public Builder setCommentaryLanguage(String commentaryLanguage) {
            this.commentaryLanguage = commentaryLanguage;
            return this;
        }

        public Builder copy(Commentary commentary) {
            this.commentaryID = commentary.commentaryID;
            this.commentatorName = commentary.commentatorName;
            this.commentatorNationality = commentary.commentatorNationality;
            this.commentatorDateOfBirth = commentary.commentatorDateOfBirth;
            this.commentaryLanguage = commentary.commentaryLanguage;
            return this;
        }

        public Commentary build() {
            return new Commentary(this);
        }

    }
}
