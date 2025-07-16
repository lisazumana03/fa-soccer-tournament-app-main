package za.co.footballassoc.soccertournament.repository.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.tournament.Hybrid;

import java.util.List;

@Repository
public interface HybridRepository extends JpaRepository<Hybrid, String> {
    List<Hybrid> findByAssociation_AssociationCode(String associationCode);
}
