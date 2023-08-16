package predev07.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import predev07.domain.Company;
import predev07.repository.CompanyRepository;
import predev07.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired
	CompanyRepository companyRepository;



	@Override
	public Company findByCompanyNameContaining(String name) {
		return companyRepository.findByCompanyNameContaining(name);
	}

	@Override
	public <S extends Company> S save(S entity) {
		return companyRepository.save(entity);
	}

	@Override
	public <S extends Company> Optional<S> findOne(Example<S> example) {
		return companyRepository.findOne(example);
	}

	@Override
	public Page<Company> findAll(Pageable pageable) {
		return companyRepository.findAll(pageable);
	}

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	public List<Company> findAll(Sort sort) {
		return companyRepository.findAll(sort);
	}

	@Override
	public List<Company> findAllById(Iterable<Long> ids) {
		return companyRepository.findAllById(ids);
	}

	@Override
	public <S extends Company> List<S> saveAll(Iterable<S> entities) {
		return companyRepository.saveAll(entities);
	}



	@Override
	public void flush() {
		companyRepository.flush();
	}

	@Override
	public <S extends Company> S saveAndFlush(S entity) {
		return companyRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return companyRepository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Company> entities) {
		companyRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Company> Page<S> findAll(Example<S> example, Pageable pageable) {
		return companyRepository.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		companyRepository.deleteAllInBatch();
	}

	@Override
	public Company getOne(Long id) {
		return companyRepository.getOne(id);
	}

	@Override
	public <S extends Company> long count(Example<S> example) {
		return companyRepository.count(example);
	}

	@Override
	public <S extends Company> boolean exists(Example<S> example) {
		return companyRepository.exists(example);
	}

	@Override
	public <S extends Company> List<S> findAll(Example<S> example) {
		return companyRepository.findAll(example);
	}

	@Override
	public long count() {
		return companyRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		companyRepository.deleteById(id);
	}

	@Override
	public <S extends Company> List<S> findAll(Example<S> example, Sort sort) {
		return companyRepository.findAll(example, sort);
	}

	@Override
	public void delete(Company entity) {
		companyRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Company> entities) {
		companyRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		companyRepository.deleteAll();
	}

	@Override
	public Optional<Company> company(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}




}
