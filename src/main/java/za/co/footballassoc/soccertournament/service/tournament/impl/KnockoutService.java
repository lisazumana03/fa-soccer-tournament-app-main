package za.co.footballassoc.soccertournament.service.tournament.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.footballassoc.soccertournament.domain.match.Match;
import za.co.footballassoc.soccertournament.domain.match.MatchStatus;
import za.co.footballassoc.soccertournament.domain.team.Team;
import za.co.footballassoc.soccertournament.domain.tournament.Knockout;
import za.co.footballassoc.soccertournament.factory.match.MatchFactory;
import za.co.footballassoc.soccertournament.repository.match.MatchRepository;
import za.co.footballassoc.soccertournament.repository.team.TeamRepository;
import za.co.footballassoc.soccertournament.repository.tournament.KnockoutRepository;
import za.co.footballassoc.soccertournament.service.tournament.IKnockoutService;
import za.co.footballassoc.soccertournament.util.Helper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public Knockout read(String knockoutId) {
        return knockoutRepository.findById(knockoutId).orElse(null);
    }

    @Override
    public List<Knockout> getAll() {
        return knockoutRepository.findAll();
    }

    @Override
    public Knockout update(String knockoutId, Knockout updatedKnockout) {
        Knockout existing = knockoutRepository.findById(knockoutId)
                .orElseThrow(() -> new RuntimeException("Knockout not found"));

        Knockout newKnockout = new Knockout.Builder()
                .copy(existing)
                .setNumberOfRounds(updatedKnockout.getNumberOfRounds())
                .setHasPlayOffs(updatedKnockout.isHasPlayOffs())
                .build();

        return knockoutRepository.save(newKnockout);
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

    // Knockout match result logic using Builder
    public Team processKnockoutMatchResult(String matchId) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));

        if (match.getMatchStatus() != MatchStatus.COMPLETED) {
            throw new IllegalStateException("Match is not completed");
        }

        Team winner;
        if (match.getHomeTeamScore() > match.getAwayTeamScore()) {
            winner = match.getHomeTeam();
        } else if (match.getAwayTeamScore() > match.getHomeTeamScore()) {
            winner = match.getAwayTeam();
        } else {
            if (match.isPenaltyShootout()) {
                if (match.getPenaltyWinner() == null) {
                    throw new IllegalStateException("Penalty winner must be set for shootout");
                }
                winner = match.getPenaltyWinner();
            } else {
                throw new IllegalStateException("Match drawn without resolution");
            }
        }

        Match updatedMatch = new Match.Builder()
                .copy(match)
                .setPenaltyWinner(winner)
                .build();

        matchRepository.save(updatedMatch);
        return winner;
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

            Match newMatch = MatchFactory.createFixture(
                    UUID.randomUUID().toString(),
                    LocalDateTime.now().plusDays(7),
                    home,
                    away,
                    MatchStatus.SCHEDULED,
                    null,
                    LocalDateTime.now().plusDays(7).withHour(18).withMinute(0),
                    null,
                    false,
                    false,
                    null
            );

            matchRepository.save(newMatch);
            nextRound.add(newMatch);
        }
        return nextRound;
    }
}

