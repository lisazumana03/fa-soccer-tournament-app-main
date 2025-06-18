package za.co.footballassoc.soccertournament.repository.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.match.Commentary;

@Repository
public interface CommentaryRepository extends JpaRepository<Commentary, String> {
}
