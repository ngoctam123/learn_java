package predev07.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import predev07.domain.Post;

public interface PostService {

	void deleteAll();

	void deleteAll(Iterable<? extends Post> entities);

	void delete(Post entity);

	<S extends Post> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Long id);

	long count();

	<S extends Post> List<S> findAll(Example<S> example);

	<S extends Post> boolean exists(Example<S> example);

	<S extends Post> long count(Example<S> example);

	Post getOne(Long id);

	void deleteAllInBatch();

	<S extends Post> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Post> entities);

	boolean existsById(Long id);

	<S extends Post> S saveAndFlush(S entity);

	void flush();

	Optional<Post> findById(Long id);

	<S extends Post> List<S> saveAll(Iterable<S> entities);

	List<Post> findAllById(Iterable<Long> ids);

	List<Post> findAll(Sort sort);

	List<Post> findAll();

	Page<Post> findAll(Pageable pageable);

	<S extends Post> Optional<S> findOne(Example<S> example);

	<S extends Post> S save(S entity);

	Optional<Post> findBypostNameContaining(String name);





}
