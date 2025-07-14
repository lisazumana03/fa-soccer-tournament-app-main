package za.co.footballassoc.soccertournament.service.tournament;

import za.co.footballassoc.soccertournament.domain.tournament.League;

import java.util.List;

public interface ILeagueService {
    League create(League league);
    List<League> findAll();
}
