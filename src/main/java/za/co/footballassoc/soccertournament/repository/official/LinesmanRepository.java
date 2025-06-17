package za.co.footballassoc.soccertournament.repository.official;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.footballassoc.soccertournament.domain.official.Linesman;

public interface LinesmanRepository extends JpaRepository<Linesman, String> {
}
