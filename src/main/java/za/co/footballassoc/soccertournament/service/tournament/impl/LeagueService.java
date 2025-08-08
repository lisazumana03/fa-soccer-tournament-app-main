package za.co.footballassoc.soccertournament.service.tournament.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.match.MatchStatus;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.League;
import za.co.footballassoc.soccertournament.repository.match.MatchRepository;
import za.co.footballassoc.soccertournament.repository.team.TeamRepository;
import za.co.footballassoc.soccertournament.repository.tournament.LeagueRepository;
import za.co.footballassoc.soccertournament.service.tournament.ILeagueService;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class LeagueService implements ILeagueService {
    @Autowired
    private LeagueRepository leagueRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private MatchRepository matchRepository;

    @Override
    public League create(League league) {
        return leagueRepository.save(league);
    }

    @Override
    public League read(String leagueId) {
        return leagueRepository.findById(leagueId).orElse(null);
    }

    @Override
    public List<League> getAll() {
        return leagueRepository.findAll();
    }

    @Override
    public League update(String leagueID, League leagueUpdated) {
        League league = leagueRepository.findById(leagueID).orElseThrow();
        // update attributes
        return leagueRepository.save(league);
    }

    @Override
    public List<League> getLeaguesByAssociation(String associationCode) {
        return leagueRepository.findByAssociation_AssociationCode(associationCode);
    }

    @Override
    public Optional<League> getLeagueById(String id) {
        return leagueRepository.findById(id);
    }

    @Override
    public void delete(League league) {
        leagueRepository.delete(league);
    }

    @Override
    public List<Team> getLeagueTable(String leagueId) {
        League league = leagueRepository.findById(leagueId)
                .orElseThrow(() -> new RuntimeException("League not found"));
        List<Team> teams = league.getTeams();
        if (league.getStartDate().isAfter(LocalDateTime.now())) {
            // Sort alphabetically before league starts
            teams.sort(Comparator.comparing(Team::getTeamName));
        } else {
            // Sort by points, goal difference, goals for
            teams.sort(Comparator.comparingInt(Team::getPoints).reversed()
                    .thenComparingInt(team -> (team.getGoalsFor() - team.getGoalsAgainst())).reversed()
                    .thenComparingInt(Team::getGoalsFor).reversed());
        }
        return teams;
    }

    @Override
    public List<Team> getPromotedTeams(String leagueId) {
        League league = leagueRepository.findById(leagueId)
                .orElseThrow(() -> new RuntimeException("League not found"));

        List<Team> sorted = getLeagueTable(leagueId);
        return sorted.subList(0, league.getPromotionSpots()); // Top N
    }

    @Override
    public List<Team> getRelegatedTeams(String leagueId) {
        League league = leagueRepository.findById(leagueId)
                .orElseThrow(() -> new RuntimeException("League not found"));

        List<Team> sorted = getLeagueTable(leagueId);
        return sorted.subList(sorted.size() - league.getRelegationSpots(), sorted.size()); // Bottom N
    }

    @Override
    public List<Team> getContinentalQualifiedTeams(String leagueId) {
        // Define how many qualify — e.g., top 4
        int continentalSpots = 4;
        List<Team> sorted = getLeagueTable(leagueId);
        return sorted.subList(0, Math.min(continentalSpots, sorted.size()));
    }

    @Override
    public Optional<Team> getChampion(String leagueId) {
        League league = leagueRepository.findById(leagueId)
                .orElseThrow(() -> new RuntimeException("League not found"));

        if (league.getEndDate().isBefore(LocalDateTime.now())) {
            return getLeagueTable(leagueId).stream().findFirst(); // Top of table
        }
        return Optional.empty(); // Not ended yet
    }

    public void processLeagueMatchResult(String matchId) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));

        if (match.getMatchStatus() != MatchStatus.COMPLETED) {
            throw new IllegalStateException("Match is not completed");
        }

        Team home = match.getHomeTeam();
        Team away = match.getAwayTeam();

        int homeGoals = match.getHomeTeamScore();
        int awayGoals = match.getAwayTeamScore();

        // Update stats
        updateTeamStats(home, away, homeGoals, awayGoals);

        teamRepository.save(home);
        teamRepository.save(away);
    }

    public void simulateFullSeason(String leagueId) {
        List<Match> matches = matchRepository.findByTournament_TournamentID(leagueId);
        matches.forEach(match -> {
            if (match.getMatchStatus() == MatchStatus.COMPLETED) {
                processLeagueMatchResult(match.getMatchID());
            }
        });
    }

    @Override
    public League addTeamToLeague(String leagueId, Team team) {
        League league = leagueRepository.findById(leagueId).orElseThrow();
        league.getTeams().add(team);
        return leagueRepository.save(league);
    }

    @Override
    public League removeTeamFromLeague(String leagueId, String teamId) {
        League league = leagueRepository.findById(leagueId).orElseThrow();
        league.getTeams().removeIf(t -> t.getTeamID().equals(teamId));
        return leagueRepository.save(league);
    }

}
