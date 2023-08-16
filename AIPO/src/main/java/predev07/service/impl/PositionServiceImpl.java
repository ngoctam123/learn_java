package predev07.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import predev07.domain.Position;
import predev07.repository.PositionRepository;
import predev07.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService{

	@Autowired
	PositionRepository positionRepository;

	@Override
	public <S extends Position> S save(S entity) {
		return positionRepository.save(entity);
	}

	@Override
	public <S extends Position> Optional<S> findOne(Example<S> example) {
		return positionRepository.findOne(example);
	}

	@Override
	public Page<Position> findAll(Pageable pageable) {
		return positionRepository.findAll(pageable);
	}

	@Override
	public List<Position> findAll() {
		return positionRepository.findAll();
	}

	@Override
	public List<Position> findAll(Sort sort) {
		return positionRepository.findAll(sort);
	}

	@Override
	public List<Position> findAllById(Iterable<Long> ids) {
		return positionRepository.findAllById(ids);
	}

	@Override
	public <S extends Position> List<S> saveAll(Iterable<S> entities) {
		return positionRepository.saveAll(entities);
	}

	@Override
	public Optional<Position> findById(Long id) {
		return positionRepository.findById(id);
	}

	@Override
	public void flush() {
		positionRepository.flush();
	}

	@Override
	public <S extends Position> S saveAndFlush(S entity) {
		return positionRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return positionRepository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Position> entities) {
		positionRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Position> Page<S> findAll(Example<S> example, Pageable pageable) {
		return positionRepository.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		positionRepository.deleteAllInBatch();
	}

	@Override
	public Position getOne(Long id) {
		return positionRepository.getOne(id);
	}

	@Override
	public <S extends Position> long count(Example<S> example) {
		return positionRepository.count(example);
	}

	@Override
	public <S extends Position> boolean exists(Example<S> example) {
		return positionRepository.exists(example);
	}

	@Override
	public <S extends Position> List<S> findAll(Example<S> example) {
		return positionRepository.findAll(example);
	}

	@Override
	public long count() {
		return positionRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		positionRepository.deleteById(id);
	}

	@Override
	public <S extends Position> List<S> findAll(Example<S> example, Sort sort) {
		return positionRepository.findAll(example, sort);
	}

	@Override
	public void delete(Position entity) {
		positionRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Position> entities) {
		positionRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		positionRepository.deleteAll();
	}

}
