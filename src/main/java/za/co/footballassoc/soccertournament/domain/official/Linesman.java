package za.co.footballassoc.soccertournament.domain.official;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Linesman extends Official implements Serializable {
    private String side;

    public Linesman() {}

    private Linesman(Builder builder) {}

    public static class Builder{}
}
