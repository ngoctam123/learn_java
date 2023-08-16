package predev07.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import predev07.domain.Company;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Long>{
	Company findByCompanyNameContaining(String name);
}
