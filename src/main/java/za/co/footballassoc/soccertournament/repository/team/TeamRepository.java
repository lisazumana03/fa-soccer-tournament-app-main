package za.co.footballassoc.soccertournament.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.team.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
    Team findByID(String teamID);
}
