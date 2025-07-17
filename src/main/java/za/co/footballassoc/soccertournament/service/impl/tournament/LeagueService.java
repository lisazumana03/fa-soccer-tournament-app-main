package za.co.footballassoc.soccertournament.service.impl.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.League;
import za.co.footballassoc.soccertournament.repository.team.TeamRepository;
import za.co.footballassoc.soccertournament.repository.tournament.LeagueRepository;
import za.co.footballassoc.soccertournament.service.tournament.ILeagueService;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;

@Service
public class LeagueService implements ILeagueService {
    @Autowired
    private LeagueRepository leagueRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public League create(League league) {
        return leagueRepository.save(league);
    }

    @Override
    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
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


}
