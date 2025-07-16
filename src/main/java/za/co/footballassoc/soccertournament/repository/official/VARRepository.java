package za.co.footballassoc.soccertournament.repository.official;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.official.VAR;

import java.util.List;

@Repository
public interface VARRepository extends JpaRepository<VAR, String> {
    List<VAR> findByMatch_MatchID(String matchId);
}
