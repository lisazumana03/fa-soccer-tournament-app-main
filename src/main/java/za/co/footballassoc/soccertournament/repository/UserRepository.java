package za.co.footballassoc.soccertournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
