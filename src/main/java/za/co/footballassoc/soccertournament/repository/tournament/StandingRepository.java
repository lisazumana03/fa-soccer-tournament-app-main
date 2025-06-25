package za.co.footballassoc.soccertournament.repository.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.tournament.Standing;

import java.util.List;

@Repository
public interface StandingRepository extends JpaRepository<Standing, Integer> {
    //Standing findByTournamentIDandTeamID(String tournamentID, String teamID);
}
