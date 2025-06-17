package za.co.footballassoc.soccertournament.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.team.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
}
