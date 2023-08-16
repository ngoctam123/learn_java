package predev07.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import predev07.domain.Group;
import predev07.repository.GroupRepository;
import predev07.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	GroupRepository groupRepository;

	@Override
	public <S extends Group> S save(S entity) {
		return groupRepository.save(entity);
	}

	@Override
	public <S extends Group> Optional<S> findOne(Example<S> example) {
		return groupRepository.findOne(example);
	}

	@Override
	public Page<Group> findAll(Pageable pageable) {
		return groupRepository.findAll(pageable);
	}

	@Override
	public List<Group> findAll() {
		return groupRepository.findAll();
	}

	@Override
	public List<Group> findAll(Sort sort) {
		return groupRepository.findAll(sort);
	}

	@Override
	public List<Group> findAllById(Iterable<Long> ids) {
		return groupRepository.findAllById(ids);
	}

	@Override
	public <S extends Group> List<S> saveAll(Iterable<S> entities) {
		return groupRepository.saveAll(entities);
	}

	@Override
	public Optional<Group> findById(Long id) {
		return groupRepository.findById(id);
	}

	@Override
	public void flush() {
		groupRepository.flush();
	}

	@Override
	public <S extends Group> S saveAndFlush(S entity) {
		return groupRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return groupRepository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Group> entities) {
		groupRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Group> Page<S> findAll(Example<S> example, Pageable pageable) {
		return groupRepository.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		groupRepository.deleteAllInBatch();
	}

	@Override
	public Group getOne(Long id) {
		return groupRepository.getOne(id);
	}

	@Override
	public <S extends Group> long count(Example<S> example) {
		return groupRepository.count(example);
	}

	@Override
	public <S extends Group> boolean exists(Example<S> example) {
		return groupRepository.exists(example);
	}

	@Override
	public <S extends Group> List<S> findAll(Example<S> example) {
		return groupRepository.findAll(example);
	}

	@Override
	public long count() {
		return groupRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		groupRepository.deleteById(id);
	}

	@Override
	public <S extends Group> List<S> findAll(Example<S> example, Sort sort) {
		return groupRepository.findAll(example, sort);
	}

	@Override
	public void delete(Group entity) {
		groupRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Group> entities) {
		groupRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		groupRepository.deleteAll();
	}

	@Override
	public Optional<Group> findByGroupNameContaining(String groupName) {
		return groupRepository.findByGroupNameContaining(groupName);
	}



}
