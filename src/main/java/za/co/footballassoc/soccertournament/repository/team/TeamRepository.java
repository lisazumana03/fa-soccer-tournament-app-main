package za.co.footballassoc.soccertournament.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.team.Team;

import java.util.Collection;
import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {

    List<Object> findByTournament_TournamentID(String tournamentID);
    List<Team> findByOwner_OwnerId(String ownerId);
}
