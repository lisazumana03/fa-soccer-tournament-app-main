package za.co.footballassoc.soccertournament.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import za.co.footballassoc.soccertournament.domain.team.Owner;

public interface OwnerRepository extends MongoRepository<Owner, String> {
}
