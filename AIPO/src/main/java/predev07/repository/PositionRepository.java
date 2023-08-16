package predev07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import predev07.domain.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>{

}
