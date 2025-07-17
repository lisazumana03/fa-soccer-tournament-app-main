package za.co.footballassoc.soccertournament.service.impl.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.match.MatchStatus;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.Knockout;
import za.co.footballassoc.soccertournament.repository.match.MatchRepository;
import za.co.footballassoc.soccertournament.repository.team.TeamRepository;
import za.co.footballassoc.soccertournament.repository.tournament.KnockoutRepository;
import za.co.footballassoc.soccertournament.service.tournament.IKnockoutService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hibernate.type.SqlTypes.UUID;

@Service
public class KnockoutService implements IKnockoutService {
    @Autowired
    private KnockoutRepository knockoutRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private MatchRepository matchRepository;

    @Override
    public Knockout create(Knockout knockout) {
        return knockoutRepository.save(knockout);
    }

    @Override
    public List<Knockout> getAllKnockouts() {
        return knockoutRepository.findAll();
    }

    @Override
    public Knockout update(String knockoutId, Knockout updateKnockout) {
        Knockout updatedKnockout = knockoutRepository.findById(knockoutId).orElseThrow();
        return knockoutRepository.save(updatedKnockout);
    }

    @Override
    public void delete(String knockoutId) {
        knockoutRepository.deleteById(knockoutId);
    }

    @Override
    public List<Knockout> getKnockoutsByAssociation(String associationCode) {
        return knockoutRepository.findByAssociation_AssociationCode(associationCode);
    }

    @Override
    public Optional<Knockout> getKnockoutById(String id) {
        return knockoutRepository.findById(id);
    }

    public Team processKnockoutMatchResult(String matchId) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));

        if (match.getMatchStatus() != MatchStatus.COMPLETED) {
            throw new IllegalStateException("Match is not completed");
        }

        Team home = match.getHomeTeam();
        Team away = match.getAwayTeam();
        int homeGoals = match.getHomeTeamScore();
        int awayGoals = match.getAwayTeamScore();

        if (homeGoals > awayGoals) {
            match.setPenaltyWinner(home);
        } else if (awayGoals > homeGoals) {
            match.setPenaltyWinner(away);
        } else {
            // Extra time or penalty decision
            if (match.isPenaltyShootout()) {
                if (match.getPenaltyWinner() == null) {
                    throw new IllegalStateException("Penalty winner must be set for shootout");
                }
            } else {
                throw new IllegalStateException("Match drawn without resolution");
            }
        }
        matchRepository.save(match);
        return match.getPenaltyWinner();
    }

    private List<Team> getWinnersFromPreviousRound(Knockout knockout) {
        return matchRepository.findByTournament_TournamentID(knockout.getTournamentID()).stream()
                .filter(m -> m.getMatchStatus() == MatchStatus.COMPLETED && m.getPenaltyWinner() != null)
                .map(Match::getPenaltyWinner)
                .collect(Collectors.toList());
    }


    public List<Match> generateNextKnockoutRound(Knockout knockout) {
        List<Team> winners = getWinnersFromPreviousRound(knockout);

        if (winners.size() % 2 != 0) {
            throw new IllegalStateException("Odd number of teams; cannot pair all");
        }

        List<Match> nextRound = new ArrayList<>();
        for (int i = 0; i < winners.size(); i += 2) {
            Team home = winners.get(i);
            Team away = winners.get(i + 1);

            Match newMatch = new Match();
            newMatch.setMatchID(newMatch.getMatchID());
            newMatch.setHomeTeam(home);
            newMatch.setAwayTeam(away);
            newMatch.setTournament(knockout);
            newMatch.setMatchDate(LocalDateTime.now().plusDays(7)); // 1 week later
            newMatch.setMatchStatus(MatchStatus.SCHEDULED);

            matchRepository.save(newMatch);
            nextRound.add(newMatch);
        }

        return nextRound;
    }


}
