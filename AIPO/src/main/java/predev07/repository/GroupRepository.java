package predev07.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import predev07.domain.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
	Optional<Group> findByGroupNameContaining(String groupName);
}
