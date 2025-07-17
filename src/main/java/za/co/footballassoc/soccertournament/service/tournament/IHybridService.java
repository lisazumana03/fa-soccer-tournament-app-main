package za.co.footballassoc.soccertournament.service.tournament;

import za.co.footballassoc.soccertournament.domain.tournament.Hybrid;

import java.util.List;
import java.util.Optional;

public interface IHybridService {
    Hybrid create(Hybrid hybrid);
    List<Hybrid> getAllHybrid();
    void delete(Hybrid hybrid);
    Optional<Hybrid> getHybridById(String id);
    List<Hybrid> getHybridByAssociationCode(String associationCode);
}
