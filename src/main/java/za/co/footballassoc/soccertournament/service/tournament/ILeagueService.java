package za.co.footballassoc.soccertournament.service.tournament;

import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.League;
import za.co.footballassoc.soccertournament.service.IService;

import java.util.List;
import java.util.Optional;

public interface ILeagueService extends IService<League, String> {
    void delete(League league);
    List<League> getLeaguesByAssociation(String associationCode);
    Optional<League> getLeagueById(String id);

    // LEAGUE LOGIC
    List<Team> getLeagueTable(String leagueId); // Sorted table
    List<Team> getPromotedTeams(String leagueId);
    List<Team> getRelegatedTeams(String leagueId);
    List<Team> getContinentalQualifiedTeams(String leagueId);
    Optional<Team> getChampion(String leagueId);

    League addTeamToLeague(String leagueId, Team team);
    League removeTeamFromLeague(String leagueId, String teamId);
}
