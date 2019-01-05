package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.GiveAway;

@Repository
public interface GiveAwayRepository extends JpaRepository<GiveAway,Long> {
}
