package predev07.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import predev07.domain.Company;

public interface CompanyService {

	void deleteAll();

	void deleteAll(Iterable<? extends Company> entities);

	void delete(Company entity);

	<S extends Company> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Long id);

	long count();

	<S extends Company> List<S> findAll(Example<S> example);

	<S extends Company> boolean exists(Example<S> example);

	<S extends Company> long count(Example<S> example);

	Company getOne(Long id);

	void deleteAllInBatch();

	<S extends Company> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Company> entities);

	boolean existsById(Long id);

	<S extends Company> S saveAndFlush(S entity);

	void flush();

	Optional<Company> company(Long id);

	<S extends Company> List<S> saveAll(Iterable<S> entities);

	List<Company> findAllById(Iterable<Long> ids);

	List<Company> findAll(Sort sort);

	List<Company> findAll();

	Page<Company> findAll(Pageable pageable);

	<S extends Company> Optional<S> findOne(Example<S> example);

	<S extends Company> S save(S entity);

	Company findByCompanyNameContaining(String name);


}
