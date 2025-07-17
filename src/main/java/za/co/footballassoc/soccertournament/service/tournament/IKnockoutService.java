package za.co.footballassoc.soccertournament.service.tournament;

import za.co.footballassoc.soccertournament.domain.tournament.Knockout;

import java.util.List;
import java.util.Optional;

public interface IKnockoutService {
    Knockout create(Knockout knockout);
    List<Knockout> getAllKnockouts();
    Knockout update(String knockoutId, Knockout knockout);
    void delete(String knockoutId);
    List<Knockout> getKnockoutsByAssociation(String associationCode);
    Optional<Knockout> getKnockoutById(String id);
}
