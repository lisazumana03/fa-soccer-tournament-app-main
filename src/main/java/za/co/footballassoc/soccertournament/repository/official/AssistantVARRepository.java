package za.co.footballassoc.soccertournament.repository.official;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.official.AssistantVAR;

import java.util.List;

@Repository
public interface AssistantVARRepository extends MongoRepository<AssistantVAR, String> {
    List<AssistantVAR> findByMatch_MatchID(String matchId);
}
