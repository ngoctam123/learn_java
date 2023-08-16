package predev07.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import predev07.domain.Group;

public interface GroupService {

	void deleteAll();

	void deleteAll(Iterable<? extends Group> entities);

	void delete(Group entity);

	<S extends Group> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Long id);

	long count();

	<S extends Group> List<S> findAll(Example<S> example);

	<S extends Group> boolean exists(Example<S> example);

	<S extends Group> long count(Example<S> example);

	Group getOne(Long id);

	void deleteAllInBatch();

	<S extends Group> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Group> entities);

	boolean existsById(Long id);

	<S extends Group> S saveAndFlush(S entity);

	void flush();

	Optional<Group> findById(Long id);

	<S extends Group> List<S> saveAll(Iterable<S> entities);

	List<Group> findAllById(Iterable<Long> ids);

	List<Group> findAll(Sort sort);

	List<Group> findAll();

	Page<Group> findAll(Pageable pageable);

	<S extends Group> Optional<S> findOne(Example<S> example);

	<S extends Group> S save(S entity);

	Optional<Group> findByGroupNameContaining(String groupName);



}
