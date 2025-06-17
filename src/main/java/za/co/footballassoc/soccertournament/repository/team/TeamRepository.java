package za.co.footballassoc.soccertournament.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.footballassoc.soccertournament.domain.team.Team;

public interface TeamRepository extends JpaRepository<Team, String> {
}
