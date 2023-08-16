package predev07.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import predev07.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	Optional<Post> findBypostNameContaining(String name);
}
