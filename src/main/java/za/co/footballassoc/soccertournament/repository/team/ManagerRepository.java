package za.co.footballassoc.soccertournament.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.team.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String> {
}
