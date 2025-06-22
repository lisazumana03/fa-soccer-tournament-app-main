package za.co.footballassoc.soccertournament.repository.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.tournament.Standing;

@Repository
public interface StandingRepository extends JpaRepository<Standing, Integer> {
}
