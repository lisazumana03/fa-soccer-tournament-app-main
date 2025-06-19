package za.co.footballassoc.soccertournament.repository.match;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.match.Match;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository <Match, Long>{

}
