package za.co.footballassoc.soccertournament.service.tournament;

import za.co.footballassoc.soccertournament.domain.tournament.Knockout;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;
import java.util.Optional;

public interface IKnockoutService extends IService<Knockout, String> {
    void delete(String knockoutId);

    List<Knockout> getKnockoutsByAssociation(String associationCode);
    Optional<Knockout> getKnockoutById(String id);
    //KNOCKOUT LOGIC

}
