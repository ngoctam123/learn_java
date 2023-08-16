package predev07.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import predev07.domain.Post;
import predev07.repository.PostRepository;
import predev07.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository postRepository;

	@Override
	public <S extends Post> S save(S entity) {
		return postRepository.save(entity);
	}




	@Override
	public Optional<Post> findBypostNameContaining(String name) {
		return postRepository.findBypostNameContaining(name);
	}




	@Override
	public <S extends Post> Optional<S> findOne(Example<S> example) {
		return postRepository.findOne(example);
	}

	@Override
	public Page<Post> findAll(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public List<Post> findAll(Sort sort) {
		return postRepository.findAll(sort);
	}

	@Override
	public List<Post> findAllById(Iterable<Long> ids) {
		return postRepository.findAllById(ids);
	}

	@Override
	public <S extends Post> List<S> saveAll(Iterable<S> entities) {
		return postRepository.saveAll(entities);
	}

	@Override
	public Optional<Post> findById(Long id) {
		return postRepository.findById(id);
	}

	@Override
	public void flush() {
		postRepository.flush();
	}

	@Override
	public <S extends Post> S saveAndFlush(S entity) {
		return postRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return postRepository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Post> entities) {
		postRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Post> Page<S> findAll(Example<S> example, Pageable pageable) {
		return postRepository.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		postRepository.deleteAllInBatch();
	}

	@Override
	public Post getOne(Long id) {
		return postRepository.getOne(id);
	}

	@Override
	public <S extends Post> long count(Example<S> example) {
		return postRepository.count(example);
	}

	@Override
	public <S extends Post> boolean exists(Example<S> example) {
		return postRepository.exists(example);
	}

	@Override
	public <S extends Post> List<S> findAll(Example<S> example) {
		return postRepository.findAll(example);
	}

	@Override
	public long count() {
		return postRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		postRepository.deleteById(id);
	}

	@Override
	public <S extends Post> List<S> findAll(Example<S> example, Sort sort) {
		return postRepository.findAll(example, sort);
	}

	@Override
	public void delete(Post entity) {
		postRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Post> entities) {
		postRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		postRepository.deleteAll();
	}

}
