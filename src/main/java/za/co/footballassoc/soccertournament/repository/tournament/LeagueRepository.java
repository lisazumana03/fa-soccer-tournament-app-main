package za.co.footballassoc.soccertournament.repository.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.tournament.League;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<League, String> {
    List<League> findByAssociation_AssociationCode(String associationCode);
}
