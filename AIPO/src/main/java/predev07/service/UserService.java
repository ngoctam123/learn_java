package predev07.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import predev07.domain.User;

public interface UserService {

	void deleteAll();

	void deleteAll(Iterable<? extends User> entities);

	void delete(User entity);

	<S extends User> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Long id);

	long count();

	<S extends User> List<S> findAll(Example<S> example);

	<S extends User> boolean exists(Example<S> example);

	<S extends User> long count(Example<S> example);

	User getOne(Long id);

	void deleteAllInBatch();

	<S extends User> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<User> entities);

	boolean existsById(Long id);

	<S extends User> S saveAndFlush(S entity);

	void flush();

	Optional<User> findById(Long id);

	<S extends User> List<S> saveAll(Iterable<S> entities);

	List<User> findAllById(Iterable<Long> ids);

	List<User> findAll(Sort sort);

	List<User> findAll();

	Page<User> findAll(Pageable pageable);

	<S extends User> Optional<S> findOne(Example<S> example);

	<S extends User> S save(S entity);

	public List<User> findByCompanyIdQuery(String companyId);


}
