package za.co.footballassoc.soccertournament.service.tournament;

import za.co.footballassoc.soccertournament.domain.tournament.Hybrid;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;
import java.util.Optional;

public interface IHybridService extends IService<Hybrid, String> {
    void delete(Hybrid hybrid);
    Optional<Hybrid> getHybridById(String id);
    List<Hybrid> getHybridByAssociationCode(String associationCode);
}
