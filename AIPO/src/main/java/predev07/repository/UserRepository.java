package predev07.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import predev07.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query(value = "SELECT * FROM dbo.turbine_user WHERE company_id = :companyId ",nativeQuery = true)
	List<User> findByCompanyIdQuery(@Param("companyId") String companyId);
}
