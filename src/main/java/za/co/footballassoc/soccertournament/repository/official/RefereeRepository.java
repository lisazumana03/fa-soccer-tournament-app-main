package za.co.footballassoc.soccertournament.repository.official;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.official.Official;
import za.co.footballassoc.soccertournament.domain.official.Referee;

import java.util.List;

@Repository
public interface RefereeRepository extends JpaRepository<Referee, String> {
    List<Referee> findByMatch_MatchID(String matchId);
}
