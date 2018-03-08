package mic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mic.entity.UserRole;

@Repository
public interface UserRoleDao extends JpaRepository<UserRole, Long>{

	List<UserRole> findByUserId(long id);
	
}
