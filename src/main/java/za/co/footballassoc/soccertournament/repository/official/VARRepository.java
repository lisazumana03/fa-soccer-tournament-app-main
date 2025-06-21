package za.co.footballassoc.soccertournament.repository.official;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.official.VAR;

@Repository
public interface VARRepository extends JpaRepository<VAR, String> {
}
