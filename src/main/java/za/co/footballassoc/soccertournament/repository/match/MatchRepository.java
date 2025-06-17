package za.co.footballassoc.soccertournament.repository.match;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.footballassoc.soccertournament.domain.match.Match;

public interface MatchRepository extends JpaRepository <Match, Long>{
}
