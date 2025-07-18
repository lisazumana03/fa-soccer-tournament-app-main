package za.co.footballassoc.soccertournament.repository.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.match.MatchEvent;

@Repository
public interface MatchEventRepository extends JpaRepository <MatchEvent, String>{
}
