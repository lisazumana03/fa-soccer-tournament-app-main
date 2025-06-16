package za.co.footballassoc.soccertournament.domain;

import jakarta.persistence.Entity;
import za.co.footballassoc.soccertournament.domain.official.Official;

import java.io.Serializable;

@Entity
public class Referee extends Official implements Serializable {
}
