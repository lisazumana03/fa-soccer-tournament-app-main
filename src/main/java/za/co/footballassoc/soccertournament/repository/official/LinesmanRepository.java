package za.co.footballassoc.soccertournament.repository.official;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.official.Linesman;

@Repository
public interface LinesmanRepository extends JpaRepository<Linesman, String> {
}
