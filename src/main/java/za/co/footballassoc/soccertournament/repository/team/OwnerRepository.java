package za.co.footballassoc.soccertournament.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.footballassoc.soccertournament.domain.team.Owner;

public interface OwnerRepository extends JpaRepository<Owner, String> {
}
