package predev07.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import predev07.domain.Position;

public interface PositionService {

	void deleteAll();

	void deleteAll(Iterable<? extends Position> entities);

	void delete(Position entity);

	<S extends Position> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Long id);

	long count();

	<S extends Position> List<S> findAll(Example<S> example);

	<S extends Position> boolean exists(Example<S> example);

	<S extends Position> long count(Example<S> example);

	Position getOne(Long id);

	void deleteAllInBatch();

	<S extends Position> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Position> entities);

	boolean existsById(Long id);

	<S extends Position> S saveAndFlush(S entity);

	void flush();

	Optional<Position> findById(Long id);

	<S extends Position> List<S> saveAll(Iterable<S> entities);

	List<Position> findAllById(Iterable<Long> ids);

	List<Position> findAll(Sort sort);

	List<Position> findAll();

	Page<Position> findAll(Pageable pageable);

	<S extends Position> Optional<S> findOne(Example<S> example);

	<S extends Position> S save(S entity);

}
