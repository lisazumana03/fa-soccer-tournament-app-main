package za.co.footballassoc.soccertournament.service.tournament;

import za.co.footballassoc.soccertournament.domain.tournament.Knockout;

import java.util.List;

public interface IKnockoutService {
    Knockout create(Knockout knockout);
    List<Knockout> findAll();
}
