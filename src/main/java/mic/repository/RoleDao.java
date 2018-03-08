package mic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mic.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long>{

}
