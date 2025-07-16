package za.co.footballassoc.soccertournament.repository.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.footballassoc.soccertournament.domain.tournament.Knockout;

import java.util.List;
import java.util.Optional;

@Repository
public interface KnockoutRepository extends JpaRepository <Knockout, String>{
    List<Knockout> findByAssociation_AssociationCode(String associationCode);
}
