package za.co.footballassoc.soccertournament.repository.official;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.footballassoc.soccertournament.domain.official.Official;

public interface RefereeRepository extends JpaRepository<Official, String> {
}
