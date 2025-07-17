package za.co.footballassoc.soccertournament.service.tournament;

import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.League;

import java.util.List;
import java.util.Optional;

public interface ILeagueService {
    League create(League league);
    List<League> getAllLeagues();
    List<League> getLeaguesByAssociation(String associationCode);
    Optional<League> getLeagueById(String id);
    void delete(League league);

    // LEAGUE LOGIC
    List<Team> getLeagueTable(String leagueId); // Sorted table
    List<Team> getPromotedTeams(String leagueId);
    List<Team> getRelegatedTeams(String leagueId);
    List<Team> getContinentalQualifiedTeams(String leagueId);
    Optional<Team> getChampion(String leagueId);
}
