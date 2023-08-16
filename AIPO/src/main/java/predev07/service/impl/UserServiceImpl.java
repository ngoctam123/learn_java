package predev07.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import predev07.domain.User;
import predev07.repository.UserRepository;
import predev07.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository repository;

	@Override
	public <S extends User> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public <S extends User> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}


	@Override
	public List<User> findByCompanyIdQuery(String companyId) {
		return repository.findByCompanyIdQuery(companyId);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public List<User> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public List<User> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public <S extends User> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public Optional<User> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void flush() {
		repository.flush();
	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<User> entities) {
		repository.deleteInBatch(entities);
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	@Override
	public User getOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public <S extends User> long count(Example<S> example) {
		return repository.count(example);
	}

	@Override
	public <S extends User> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	@Override
	public void delete(User entity) {
		repository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		repository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

}
